/**
 *  <b>日期：</b>Oct 14, 2013-10:12:29 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.vo.MonthWorkInfo;

/**
 * <b>类名称：</b>IssueService<br/>
 * <b>类描述：</b>问题的业务层类<br/>
 * <b>创建时间：</b>Oct 14, 2013 10:12:29 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Transactional
public interface IssueService {
	/**
	 * <p>
	 * 获取用户最后一个月的工作情况。
	 * </p>
	 * 
	 * @param userId
	 *            用户id
	 * @see #getNewestWorkInfoByUserId(int, int, int)
	 * @return {@link MonthWorkInfo}
	 */
	@Transactional(readOnly = true)
	public MonthWorkInfo getNewestWorkInfoByUserId(int userId);

	/**
	 * <p>
	 * 获取用户指定月份的工作情况。
	 * </p>
	 * 
	 * @param userId
	 *            用户id
	 * @param year
	 *            年份
	 * @param month
	 *            月份，1月份为1，2月份为2，如此类推
	 * @return {@link MonthWorkInfo}
	 */
	@Transactional(readOnly = true)
	public MonthWorkInfo getNewestWorkInfoByUserId(int userId, int year,
			int month);

	/**
	 * <p>
	 * 根据责任人，查询当前月的问题。
	 * </p>
	 * 
	 * @param userId
	 *            Integer 用户id
	 * @param issueStatusIds
	 *            List 查询的问题状态id。可为null，标识查询全部。
	 * @return List of Issue
	 * @see #findIssuesByResponsible(int, int, int, List)
	 */
	@Transactional(readOnly = true)
	public List<Issue> findCurrentIssuesByResponsible(int userId,
			List<Integer> issueStatusIds);

	/**
	 * 
	 * <p>
	 * 根据责任人，查询当前月的isClosed状态的问题。
	 * </p>
	 * 
	 * @param userId
	 *            Integer 用户id
	 * @param isClosed
	 *            Boolean
	 *            是否关闭状态的问题。可为null，表示查询全部。isClosed对应的status可查询IssueStatus表。
	 * @return List of Issue
	 * @see #findCurrentIssuesByResponsible(int, List)
	 */
	@Transactional(readOnly = true)
	public List<Issue> findCurrentIssuesByResponsible(int userId,
			Boolean isClosed);

	/**
	 * <p>
	 * 根据责任人，查询指定月份的问题列表。
	 * </p>
	 * 
	 * @param userId
	 *            Integer 用户id
	 * @param year
	 *            Integer 年份
	 * @param month
	 *            Integer 月份，1月份为1，2月份为2，如此类推。
	 * @param issueStatusIds
	 *            List 查询的问题状态id。可为null，标识查询全部。
	 * @return List of Issue
	 */
	@Transactional(readOnly = true)
	public List<Issue> findIssuesByResponsible(int userId, int year, int month,
			List<Integer> issueStatusIds);

	/**
	 * <p>
	 * 根据责任人，查询指定月份的isClosed状态的问题列表。
	 * </p>
	 * 
	 * @param userId
	 *            Integer 用户id
	 * @param year
	 *            Integer 年份
	 * @param month
	 *            Integer 月份
	 * @param isClosed
	 *            Boolean
	 *            是否关闭状态的问题。可为null，表示查询全部。isClosed对应的status可查询IssueStatus表。
	 * @return List of Issue
	 * @see #findIssuesByResponsible(int, int, int, List)
	 */
	@Transactional(readOnly = true)
	public List<Issue> findIssuesByResponsible(int userId, int year, int month,
			Boolean isClosed);
}
