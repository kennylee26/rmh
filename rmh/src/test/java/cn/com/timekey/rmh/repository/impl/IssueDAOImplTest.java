/**
 *  <b>日期：</b>Oct 12, 2013-10:33:48 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import java.util.Arrays;
import java.util.Date;
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
import cn.com.timekey.rmh.repository.IssueDAO;
import cn.com.timekey.rmh.utils.DateUtils;

/**
 * <b>类名称：</b>IssueDAOImplTest<br/>
 * <b>类描述：</b>IssueDAO的测试类<br/>
 * <b>创建时间：</b>Oct 12, 2013 10:33:48 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class IssueDAOImplTest {

	@Resource
	private IssueDAO issueDAO;

	private final Log logger = LogFactory.getLog(getClass());

	private int userId = 3;

	@Test
	public void testFindResponsibleIssues() throws Exception {
		Date[] period = DateUtils.getDatePeriod(2013, 9);
		Date begin = period[0];
		Date end = period[1];
		List<Integer> statusIds = Arrays.asList(5);
		statusIds = null;// 全部状态的问题
		List<Issue> l = issueDAO.findResponsibleIssues(userId, begin, end,
				statusIds);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		for (Issue issue : l) {
			logger.info(issue.getSubject());
		}
	}
}