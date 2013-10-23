/**
 *  <b>日期：</b>Oct 22, 2013-4:24:11 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository;

import java.util.Date;
import java.util.List;

import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.Role;
import cn.com.timekey.rmh.entity.User;

/**
 * <b>类名称：</b>ProjectDAO<br/>
 * <b>类描述：</b>项目Project的DAO类<br/>
 * <b>创建时间：</b>Oct 22, 2013 4:24:11 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public interface ProjectDAO {

	/**
	 * <p>
	 * 根据用户和权限，查询项目列表。
	 * </p>
	 * 
	 * @param user
	 * @param role
	 * @return List 项目列表
	 */
	public List<Project> findByUserAndRole(User user, Role role);

	/**
	 * <p>
	 * 根据项目查找相关联的问题的estimatedHours时间总和。
	 * </p>
	 * 
	 * @param project
	 *            项目
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param issueStatuses
	 *            查询的问题状态列表，可为null
	 * @return Double 符合条件的问题的estimatedHours的总和。
	 */
	public double getTotalEstimatedHours(Project project, Date begin, Date end,
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
	public List<Object[]> findIssues(Project project, Date begin, Date end,
			List<IssueStatus> issueStatuses);
}
