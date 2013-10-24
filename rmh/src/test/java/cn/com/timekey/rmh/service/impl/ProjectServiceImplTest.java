/**
 *  <b>日期：</b>Oct 23, 2013-3:22:53 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

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

import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.service.ProjectService;
import cn.com.timekey.rmh.vo.Issue;
import cn.com.timekey.rmh.vo.ProjectIssueInfo;

/**
 * <b>类名称：</b>ProjectServiceImplTest<br/>
 * <b>类描述：</b>ProjectServiceImpl的测试类<br/>
 * <b>创建时间：</b>Oct 23, 2013 3:22:53 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ProjectServiceImplTest {

	private final Log logger = LogFactory.getLog(getClass());

	@Resource
	private ProjectService projectService;

	@Test
	public void testFindManaProjects() throws Exception {
		User user = new User();
		user.setId(3);
		List<Project> l = projectService.findManaProjects(user);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		for (Project project : l) {
			logger.info(project.getName());
		}
	}

	@Test
	public void testFindManaProjectInfo() throws Exception {
		User user = new User();
		user.setId(3);
		List<ProjectIssueInfo> l = projectService.findManaProjectInfo(user,
				2013, 10);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		int count = 0;
		for (ProjectIssueInfo project : l) {
			logger.info("--------");
			logger.info(project.getProject().getName() + ", id "
					+ project.getProject().getId() + " 问题列表: ");
			for (Issue i : project.getIssues()) {
				logger.info(i.getSubject() + ", 责任人: "
						+ i.getResponsibleUser().getName() + ", 状态: "
						+ i.getStatusName());
			}
			logger.info("--------");
			count += project.getIssues().size();
		}
		logger.info("total: " + count);
	}
}
