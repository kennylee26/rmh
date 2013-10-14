/**
 *  <b>日期：</b>Oct 14, 2013-2:17:38 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.enums.IssueStatusEnum;
import cn.com.timekey.rmh.service.IssueService;
import cn.com.timekey.rmh.vo.MonthWorkInfo;

/**
 * <b>类名称：</b>IssueServiceImplTest<br/>
 * <b>类描述：</b>IssueService实现类<br/>
 * <b>创建时间：</b>Oct 14, 2013 2:17:38 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class IssueServiceImplTest {

	@Resource
	private IssueService issueService;

	private final Log logger = LogFactory.getLog(getClass());

	private Integer userId = 3;

	@Test
	public void testGetNewestWorkInfoByUserId() throws Exception {
		MonthWorkInfo info = issueService.getNewestWorkInfoByUserId(userId);
		Assert.assertNotNull(info);
		logger.info(info);
	}

	@Test
	public void testFindCurrentIssuesByResponsibleIntegerBoolean()
			throws Exception {
		Boolean isClosed = null;
		List<Issue> issues = issueService.findCurrentIssuesByResponsible(
				userId, isClosed);
		Assert.assertFalse(CollectionUtils.isEmpty(issues));
		for (Issue issue : issues) {
			logger.info(issue.getSubject());
		}
	}

	@Test
	public void testFindCurrentIssuesByResponsibleIntegerList()
			throws Exception {
		List<IssueStatus> issueStatuses = null;
		issueStatuses = Arrays.asList(IssueStatusEnum.CLOSED.getEntity());
		List<Issue> issues = issueService.findCurrentIssuesByResponsible(
				userId, issueStatuses);
		Assert.assertFalse(CollectionUtils.isEmpty(issues));
		for (Issue issue : issues) {
			logger.info(issue.getSubject());
		}
	}

	@Test
	public void testFindIssuesByResponsibleIntegerIntegerIntegerBoolean()
			throws Exception {
		Integer year = 2013;
		Integer month = 9;
		Boolean isClosed = null;
		List<Issue> issues = issueService.findIssuesByResponsible(userId, year,
				month, isClosed);
		Assert.assertFalse(CollectionUtils.isEmpty(issues));
		double totalTime = 0d;
		for (Issue issue : issues) {
			logger.info(issue.getSubject() + ": " + issue.getIssueStatus().getName());
			totalTime += issue.getEstimatedHours();
		}
		logger.info("total: " + totalTime + " hours");
	}

	@Test
	public void testGetWorkInfoByUserIdIntegerIntegerInteger() throws Exception {
		Integer year = 2013;
		Integer month = 9;
		MonthWorkInfo info = issueService.getWorkInfoByUserId(userId, year,
				month);
		Assert.assertNotNull(info);
		logger.info(info);
	}
}
