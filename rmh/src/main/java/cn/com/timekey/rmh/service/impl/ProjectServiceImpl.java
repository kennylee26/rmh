/**
 *  <b>日期：</b>Oct 23, 2013-3:19:58 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
		List<Project> projects = this.findManaProjects(user);
		Date[] period = DateUtils.getDatePeriod(year, month);
		Date begin = period[0];
		Date end = period[1];
		List<IssueStatus> uncloseIssueStatus = new ArrayList<IssueStatus>();
		for (IssueStatus i : issueStatusDAO.findByIsClosed(false)) {
			if (i.getId().equals(IssueStatusEnum.NEW.getId()) == false) {
				uncloseIssueStatus.add(i);
			}
		}
		if (CollectionUtils.isEmpty(projects) == false) {
			List<IssueStatus> allStatus = new ArrayList<IssueStatus>(
					uncloseIssueStatus);
			allStatus.add(IssueStatusEnum.CLOSED.getEntity());
			for (Project prj : projects) {
				List<Object[]> objs = projectDAO.findIssues(prj, begin, end,
						uncloseIssueStatus);
				if (CollectionUtils.isEmpty(objs) == false) {
					List<cn.com.timekey.rmh.vo.Issue> is = new ArrayList<cn.com.timekey.rmh.vo.Issue>(
							objs.size());
					ProjectIssueInfo instance = new ProjectIssueInfo();
					instance.setProject(cn.com.timekey.rmh.vo.Project
							.newInstance(prj.getId(), prj.getIdentifier(),
									prj.getName()));
					instance.setMonth(month);
					instance.setYear(year);
					instance.setMonthPlaningTime(projectDAO
							.getTotalEstimatedHours(prj, begin, end, allStatus));
					instance.setMonthFinishedTime(projectDAO.getTotalEstimatedHours(
							prj, begin, end,
							Arrays.asList(IssueStatusEnum.CLOSED.getEntity())));
					instance.setIssues(is);
					for (Object[] obj : objs) {
						Issue issue = (Issue) obj[0];
						User respUser = (User) obj[1];
						cn.com.timekey.rmh.vo.Issue i = cn.com.timekey.rmh.vo.Issue
								.newInstance(issue, respUser);
						is.add(i);
					}
					result.add(instance);
				}
			}
		}
		return result;
	}
}
