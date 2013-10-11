/**
 *  <b>日期：</b>Oct 11, 2013-10:21:12 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

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

import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.repository.UserDAO;

/**
 * <b>类名称：</b>UserDAOImplTest<br/>
 * <b>类描述：</b>UserDAO测试类<br/>
 * <b>创建时间：</b>Oct 11, 2013 10:21:12 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UserDAOImplTest {

	@Resource
	private UserDAO userDAO;

	private final Log logger = LogFactory.getLog(getClass());

	@Test
	public void testFindById() throws Exception {
		int userId = 3;
		User user = userDAO.findById(userId);
		Assert.assertNotNull(user);
		logger.info(user);
	}
}
