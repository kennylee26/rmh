/**
 *  <b>日期：</b>Oct 23, 2013-3:14:33 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.vo.ProjectIssueInfo;

/**
 * <b>类名称：</b>ProjectService<br/>
 * <b>类描述：</b>Project的实体类<br/>
 * <b>创建时间：</b>Oct 23, 2013 3:14:33 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Transactional(readOnly = true)
public interface ProjectService {

	/**
	 * <p>
	 * 查询某用户作为管理员的项目列表
	 * </p>
	 * 
	 * @param user
	 *            User 查询用户
	 * @return List
	 */
	public List<Project> findManaProjects(User user);

	/**
	 * <p>
	 * 查询用户某月份管理的项目情况
	 * </p>
	 * 
	 * @param user
	 *            User 查询的用户
	 * @param year
	 *            Integer 年份
	 * @param month
	 *            Integer 月份
	 * @return
	 */
	public List<ProjectIssueInfo> findManaProjectInfo(User user, int year,
			int month);
}
