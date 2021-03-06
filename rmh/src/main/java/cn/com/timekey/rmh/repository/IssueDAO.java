/**
 *  <b>日期：</b>Oct 12, 2013-9:49:27 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository;

import java.util.Date;
import java.util.List;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.entity.User;

/**
 * <b>类名称：</b>IssueDAO<br/>
 * <b>类描述：</b>问题Issue实体的DAO接口类<br/>
 * <b>创建时间：</b>Oct 12, 2013 9:49:27 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public interface IssueDAO {

	/**
	 * <p>
	 * 根据责任人ID查找相关联的问题
	 * </p>
	 * 
	 * @param userId
	 *            int 责任id
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param issueStatuses
	 *            查询的问题状态列表，可为null
	 * @return List of Issue
	 */
	public List<Issue> findIssuesByResponsible(int userId, Date begin,
			Date end, List<IssueStatus> issueStatuses);

	/**
	 * <p>
	 * 根据责任人ID查找相关联的问题的estimatedHours时间总和。
	 * </p>
	 * 
	 * @param userId
	 *            int 责任id
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param issueStatuses
	 *            查询的问题状态列表，可为null
	 * @return Double 符合条件的问题的estimatedHours的总和。
	 */
	public Double getTotalEstimatedHours(int userId, Date begin, Date end,
			List<IssueStatus> issueStatuses);
	
	/**
	 * <p>
	 * 查找项目中的问题
	 * </p>
	 * 
	 * @param project
	 *            Project 项目
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param issueStatuses
	 *            问题的状态
	 * @return List 结果组合，0为issue，1为user
	 */
	public List<Object[]> findByManagerUser(User user, Date begin, Date end,
			List<IssueStatus> issueStatuses);
}
