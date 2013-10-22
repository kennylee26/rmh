/**
 *  <b>日期：</b>Oct 22, 2013-4:50:13 PM<br/>
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

import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.Role;
import cn.com.timekey.rmh.entity.User;
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

	@Test
	public void testFindByMemberRole() throws Exception {
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
}
