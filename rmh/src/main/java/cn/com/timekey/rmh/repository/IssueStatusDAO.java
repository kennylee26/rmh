/**
 *  <b>日期：</b>Oct 14, 2013-11:15:25 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository;

import java.util.List;

import cn.com.timekey.rmh.entity.IssueStatus;

/**
 * <b>类名称：</b>IssueStatusDAO<br/>
 * <b>类描述：</b>IssueStatus持久化类<br/>
 * <b>创建时间：</b>Oct 14, 2013 11:15:25 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public interface IssueStatusDAO {
	/**
	 * <p>
	 * 根据isClosed字段进行查询
	 * </p>
	 * 
	 * @param isClosed
	 *            Boolean
	 * @return List of IssueStatus
	 */
	public List<IssueStatus> findByIsClosed(boolean isClosed);
}
