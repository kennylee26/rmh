/**
 *  <b>日期：</b>Oct 11, 2013-10:18:13 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository;

import cn.com.timekey.rmh.entity.User;

/**
 * <b>类名称：</b>UserDAO<br/>
 * <b>类描述：</b>User持久化层<br/>
 * <b>创建时间：</b>Oct 11, 2013 10:18:13 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public interface UserDAO {
	
	public User findById(int id);

}
