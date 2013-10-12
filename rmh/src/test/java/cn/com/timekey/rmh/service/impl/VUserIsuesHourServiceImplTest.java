/**
 *  <b>日期：</b>Oct 12, 2013-3:25:16 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

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

import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.entity.VUserIsuesHour;
import cn.com.timekey.rmh.service.VUserIsuesHourService;

/**
 * <b>类名称：</b>VUserIsuesHourServiceImplTest<br/>
 * <b>类描述：</b>VUserIsuesHourService的测试类<br/>
 * <b>创建时间：</b>Oct 12, 2013 3:25:16 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class VUserIsuesHourServiceImplTest {

	@Resource
	private VUserIsuesHourService vUserIsuesHourService;

	private final Log logger = LogFactory.getLog(getClass());

	private int userId = 3;

	@Test
	public void testFindLast() throws Exception {
		VUserIsuesHour info = vUserIsuesHourService.findLast(userId);
		Assert.assertNotNull(info);
		logger.info(info);
	}

	@Test
	public void testFindCurrentYearInfo() throws Exception {
		List<VUserIsuesHour> l = vUserIsuesHourService
				.findCurrentYearInfo(userId);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
		for (VUserIsuesHour vUserIsuesHour : l) {
			logger.info(vUserIsuesHour);
		}
	}

	@Test
	public void testFindByExample() throws Exception {
		VUserIsuesHour example = new VUserIsuesHour();
		User user = new User();
		user.setId(userId);
		example.setUser(user);
		List<VUserIsuesHour> l = vUserIsuesHourService.findByExample(example);
		Assert.assertFalse(CollectionUtils.isEmpty(l));
	}
}
