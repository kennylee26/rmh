/**
 *  <b>日期：</b>Oct 23, 2013-3:19:58 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.Role;
import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.enums.IssueStatusEnum;
import cn.com.timekey.rmh.repository.IssueDAO;
import cn.com.timekey.rmh.repository.IssueStatusDAO;
import cn.com.timekey.rmh.repository.ProjectDAO;
import cn.com.timekey.rmh.service.ProjectService;
import cn.com.timekey.rmh.utils.DateUtils;
import cn.com.timekey.rmh.vo.ProjectIssueInfo;

/**
 * <b>类名称：</b>ProjectServiceImpl<br/>
 * <b>类描述：</b>项目的<br/>
 * <b>创建时间：</b>Oct 23, 2013 3:19:58 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	private final Log logger = LogFactory.getLog(getClass());

	@Resource
	private ProjectDAO projectDAO;
	@Resource
	private IssueDAO issueDAO;
	@Resource
	private IssueStatusDAO issueStatusDAO;

	private final Integer managerRoleId = 3;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.ProjectService#findManaProjects(cn.com.timekey
	 * .rmh.entity.User)
	 */
	@Override
	public List<Project> findManaProjects(User user) {
		logger.debug("ProjectServiceImpl.findManaProjectsByUser()");
		Role role = new Role();
		role.setId(managerRoleId);
		return projectDAO.findByUserAndRole(user, role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.ProjectService#findManaProjectInfo(cn.com.
	 * timekey.rmh.entity.User, int, int)
	 */
	@Override
	public List<ProjectIssueInfo> findManaProjectInfo(User user, int year,
			int month) {
		List<ProjectIssueInfo> result = new ArrayList<ProjectIssueInfo>();
		Date[] period = DateUtils.getDatePeriod(year, month);
		Date begin = period[0];
		Date end = period[1];
		List<IssueStatus> allUsefulStatus = new ArrayList<IssueStatus>();
		for (IssueStatus i : issueStatusDAO.findByIsClosed(false)) {
			if (i.getId().equals(IssueStatusEnum.NEW.getId()) == false) {
				allUsefulStatus.add(i);
			}
		}
		allUsefulStatus.add(IssueStatusEnum.CLOSED.getEntity());
		// List<Project> projects = this.findManaProjects(user);
		List<Object[]> projectIssues = issueDAO.findByManagerUser(user, begin,
				end, allUsefulStatus);

		if (CollectionUtils.isEmpty(projectIssues) == false) {
			Map<Integer, ProjectIssueInfo> m = new HashMap<Integer, ProjectIssueInfo>();
			for (Object[] objs : projectIssues) {
				Project prj = (Project) objs[0];
				Issue issue = (Issue) objs[1];
				User respUser = (User) objs[2];
				ProjectIssueInfo instance = m.get(prj.getId());
				if (instance == null) {
					instance = new ProjectIssueInfo();
					instance.setProject(cn.com.timekey.rmh.vo.Project
							.newInstance(prj.getId(), prj.getIdentifier(),
									prj.getName()));
					instance.setMonth(month);
					instance.setYear(year);
					List<cn.com.timekey.rmh.vo.Issue> is = new ArrayList<cn.com.timekey.rmh.vo.Issue>(
							projectIssues.size());
					instance.setIssues(is);
					m.put(prj.getId(), instance);
					result.add(instance);
				}
				instance.setMonthPlaningTime(instance.getMonthPlaningTime()
						+ issue.getEstimatedHours());
				if (issue.getIssueStatus().getId()
						.equals(IssueStatusEnum.CLOSED.getId())) {
					instance.setMonthFinishedTime(instance
							.getMonthFinishedTime() + issue.getEstimatedHours());
				}

				cn.com.timekey.rmh.vo.Issue i = cn.com.timekey.rmh.vo.Issue
						.newInstance(issue, respUser);
				instance.getIssues().add(i);
			}
			m = null;
		}
		sortProjectIssueInfo(result);
		return result;
	}

	/**
	 * <p>
	 * 项目排序
	 * </p>
	 * 
	 * @param result
	 */
	private void sortProjectIssueInfo(List<ProjectIssueInfo> result) {
		if (CollectionUtils.isEmpty(result) == false) {
			Collections.sort(result, new Comparator<ProjectIssueInfo>() {
				@Override
				public int compare(ProjectIssueInfo o1, ProjectIssueInfo o2) {
					return o1.getProject().getId()
							.compareTo(o2.getProject().getId());
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.ProjectService#getTotalEstimatedHours(cn.com
	 * .timekey.rmh.entity.Project, java.util.Date, java.util.Date,
	 * java.lang.Boolean)
	 */
	@Override
	public double getTotalEstimatedHours(Project project, Integer year,
			Integer month, Boolean isClosed) {
		Date begin = null;
		Date end = null;
		if (year != null && month != null) {
			Date[] period = DateUtils.getDatePeriod(year, month);
			begin = period[0];
			end = period[1];
		}
		List<IssueStatus> issueStatuses = null;
		if (isClosed != null) {
			if (isClosed == true) {
				issueStatuses = Arrays.asList(IssueStatusEnum.CLOSED
						.getEntity());
			} else {
				issueStatuses = issueStatusDAO.findByIsClosed(isClosed);
			}
		} else {
			issueStatuses = issueStatusDAO.findByIsClosed(false);
			issueStatuses.add(IssueStatusEnum.CLOSED.getEntity());
		}
		return projectDAO.getTotalEstimatedHours(project, begin, end,
				issueStatuses);
	}
}
