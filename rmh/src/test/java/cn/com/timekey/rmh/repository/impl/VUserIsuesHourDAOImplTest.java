/**
 *  <b>日期：</b>Oct 11, 2013-5:09:32 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

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

import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.entity.VUserIsuesHour;
import cn.com.timekey.rmh.repository.VUserIsuesHourDAO;

/**
 * <b>类名称：</b>VUserIsuesHourDAOImplTest<br/>
 * <b>类描述：</b>VUserIsuesHourDAO测试类<br/>
 * <b>创建时间：</b>Oct 11, 2013 5:09:32 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class VUserIsuesHourDAOImplTest {

	@Resource
	private VUserIsuesHourDAO vUserIsuesHourDAO;

	private final Log logger = LogFactory.getLog(getClass());

	@Test
	public void testFindByExample() throws Exception {
		VUserIsuesHour example = new VUserIsuesHour();
		User user = new User();
		user.setId(3);
		example.setUser(user);
		List<VUserIsuesHour> l = vUserIsuesHourDAO.findByExample(example);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		for (VUserIsuesHour vUserIsuesHour : l) {
			logger.info(vUserIsuesHour);
		}
	}
}
