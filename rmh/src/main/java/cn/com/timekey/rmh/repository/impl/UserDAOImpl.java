/**
 *  <b>日期：</b>Oct 11, 2013-10:19:26 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.repository.AbstractRepository;
import cn.com.timekey.rmh.repository.UserDAO;

/**
 * <b>类名称：</b>UserDAOImpl<br/>
 * <b>类描述：</b>UserDAO实现类<br/>
 * <b>创建时间：</b>Oct 11, 2013 10:19:26 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Repository("userDAO")
public class UserDAOImpl extends AbstractRepository implements UserDAO {

	private final Log logger = LogFactory.getLog(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.timekey.rmh.repository.UserDAO#findById(java.lang.String)
	 */
	public User findById(int id) {
		logger.debug("UserDAOImpl.findById()");
		return getEntityManager().find(User.class, id);
	}
}
