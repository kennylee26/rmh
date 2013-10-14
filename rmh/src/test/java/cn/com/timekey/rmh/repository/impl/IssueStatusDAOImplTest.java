/**
 *  <b>日期：</b>Oct 14, 2013-11:31:40 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

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

import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.repository.IssueStatusDAO;

/**
 * <b>类名称：</b>IssueStatusDAOImplTest<br/>
 * <b>类描述：</b>IssueStatusDAOImpl的测试类<br/>
 * <b>创建时间：</b>Oct 14, 2013 11:31:40 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class IssueStatusDAOImplTest {

	private final Log logger = LogFactory.getLog(getClass());
	@Resource
	private IssueStatusDAO issueStatusDAO;


	@Test
	public void testFindByIsClosed() throws Exception {
		boolean isClosed = false;
		List<IssueStatus> l = issueStatusDAO.findByIsClosed(isClosed);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		for (IssueStatus issueStatus : l) {
			logger.info(issueStatus);
		}
	}
}
