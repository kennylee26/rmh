/**
 *  <b>日期：</b>Oct 22, 2013-4:50:13 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.Role;
import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.enums.IssueStatusEnum;
import cn.com.timekey.rmh.repository.IssueStatusDAO;
import cn.com.timekey.rmh.repository.ProjectDAO;

/**
 * <b>类名称：</b>ProjectDAOImplTest<br/>
 * <b>类描述：</b>ProjectDAO的测试类<br/>
 * <b>创建时间：</b>Oct 22, 2013 4:50:13 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ProjectDAOImplTest {

	private final Log logger = LogFactory.getLog(getClass());

	@Resource
	private ProjectDAO projectDAO;
	@Resource
	private IssueStatusDAO issueStatusDAO;

	@Test
	public void testFindByUserAndRole() throws Exception {
		User user = new User();
		user.setId(3);
		Role role = new Role();
		role.setId(3);
		List<Project> l = projectDAO.findByUserAndRole(user, role);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		for (Project project : l) {
			logger.info(project.getName());
		}
	}

	@Test
	public void testFindIssues() throws Exception {
		Project project = new Project();
		project.setIdentifier("zjbsms");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = sdf.parse("2014-01-01");
		Date end = new Date();
		List<IssueStatus> issueStatuses = issueStatusDAO.findByIsClosed(true);
		List<Object[]> l = projectDAO.findIssues(project, begin, end,
				issueStatuses);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		String format = "%s: 【%s】 [责任人:%s%s, 耗时:%s, 最后更新时间:%s, 状态:%s]";
		float total = 0f;
		for (Object[] objs : l) {
			Issue issue = (Issue) objs[0];
			User user = (User) objs[1];

			logger.info(String.format(format, issue.getProject().getName(),
					issue.getSubject(), user.getFirstname(),
					user.getLastname(), String.valueOf(issue
							.getEstimatedHours()), sdf.format(issue
							.getUpdatedOn()), issue.getIssueStatus().getName()));
			total += issue.getEstimatedHours();
		}
		logger.info("total: " + total + " hours.");
	}

	@Test
	public void testGetTotalEstimatedHours() throws Exception {
		Project project = new Project();
		project.setIdentifier("zjbsms");
		Date[] period = null;
		// period = DateUtils.getDatePeriod(2013, 9);
		Date begin = null;
		begin = period != null ? period[0] : null;
		Date end = null;
		end = period != null ? period[1] : null;
		List<IssueStatus> issueStatuses = Arrays.asList(IssueStatusEnum.CLOSED
				.getEntity());
		Double d = projectDAO.getTotalEstimatedHours(project, begin, end,
				issueStatuses);
		Assert.assertNotNull(d);
		logger.info(d);
	}

	@Test
	public void testFindUniqueByProperty() throws Exception {
		Project p = projectDAO.findUniqueByProperty("identifier", "qygaweb");
		Assert.assertNotNull(p);
		logger.info(p.getId());
	}
}
