/**
 *  <b>日期：</b>Oct 14, 2013-10:34:29 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.entity.IssueStatus;
import cn.com.timekey.rmh.enums.IssueStatusEnum;
import cn.com.timekey.rmh.repository.IssueDAO;
import cn.com.timekey.rmh.repository.IssueStatusDAO;
import cn.com.timekey.rmh.service.IssueService;
import cn.com.timekey.rmh.utils.DateUtils;
import cn.com.timekey.rmh.vo.MonthWorkInfo;

/**
 * <b>类名称：</b>IssueServiceImpl<br/>
 * <b>类描述：</b>问题实体的业务实现类<br/>
 * <b>创建时间：</b>Oct 14, 2013 10:34:29 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Service("issueService")
public class IssueServiceImpl implements IssueService {

	private final Log logger = LogFactory.getLog(getClass());

	@Resource
	private IssueDAO issueDAO;
	@Resource
	private IssueStatusDAO issueStatusDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.IssueService#getNewestWorkInfoByUserId(int)
	 */
	public MonthWorkInfo getNewestWorkInfoByUserId(int userId) {
		logger.debug("IssueServiceImpl.getNewestWorkInfoByUserId()");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		return this.getNewestWorkInfoByUserId(userId, year, month);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.IssueService#getNewestWorkInfoByUserId(int,
	 * int, int)
	 */
	public MonthWorkInfo getNewestWorkInfoByUserId(int userId, int year,
			int month) {
		Date[] period = DateUtils.getDatePeriod(year, month);
		Date begin = period[0];
		Date end = period[1];
		List<Integer> finishedStatusIds = getIssueStatusIdsByIsClosed(true);// 完成状态
		List<Integer> allEffictiveStatusIds = getIssueStatusIdsByIsClosed(null);// 全部有用的状态
		Double finishedTime = issueDAO.getTotalEstimatedHours(userId, begin,
				end, finishedStatusIds);
		if (finishedTime == null)
			finishedTime = 0d;
		Double planingTime = issueDAO.getTotalEstimatedHours(userId, begin,
				end, allEffictiveStatusIds);
		if (planingTime == null)
			planingTime = 0d;
		Double totalWorkTime = 0d;
		// TODO totalWorkTime
		return new MonthWorkInfo(userId, month, year, finishedTime,
				planingTime, totalWorkTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.IssueService#findCurrentIssuesByResponsible
	 * (int, java.util.List)
	 */
	public List<Issue> findCurrentIssuesByResponsible(int userId,
			List<Integer> issueStatusIds) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		return this
				.findIssuesByResponsible(userId, year, month, issueStatusIds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.IssueService#findCurrentIssuesByResponsible
	 * (int, java.lang.Boolean)
	 */
	public List<Issue> findCurrentIssuesByResponsible(int userId,
			Boolean isClosed) {
		List<Integer> issueStatusIds = getIssueStatusIdsByIsClosed(isClosed);
		return this.findCurrentIssuesByResponsible(userId, issueStatusIds);
	}

	/**
	 * <p>
	 * 根据isClosed参数获取对应的IssueStatus的id列表。
	 * </p>
	 * 
	 * @param isClosed
	 * @return
	 */
	private List<Integer> getIssueStatusIdsByIsClosed(Boolean isClosed) {
		List<Integer> issueStatusIds = null;
		if (isClosed != null) {
			if (isClosed == true) {
				// 只有已关闭状态的有用。
				return Arrays.asList(IssueStatusEnum.CLOSED.getId());
			} else {
				List<IssueStatus> issueStatuses = issueStatusDAO
						.findByIsClosed(isClosed);
				if (CollectionUtils.isEmpty(issueStatuses) == false) {
					issueStatusIds = new ArrayList<Integer>(
							issueStatuses.size());
					for (IssueStatus i : issueStatuses) {
						issueStatusIds.add(i.getId());
					}
				}
			}
		} else {
			// 不传入isClosed表示查询全部，根据业务，可看成是查询全部非关闭的+已关闭状态的。
			// 为了避免查询已拒绝，无效的等无用状态。by kennylee 2013-10-14
			List<IssueStatus> issueStatuses = issueStatusDAO
					.findByIsClosed(false);
			if (CollectionUtils.isEmpty(issueStatuses) == false) {
				issueStatusIds = new ArrayList<Integer>(issueStatuses.size());
				for (IssueStatus i : issueStatuses) {
					issueStatusIds.add(i.getId());
				}
				issueStatusIds.add(IssueStatusEnum.CLOSED.getId());
			}
		}
		return issueStatusIds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.timekey.rmh.service.IssueService#findIssuesByResponsible(int,
	 * int, int, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	public List<Issue> findIssuesByResponsible(int userId, int year, int month,
			List<Integer> issueStatusIds) {
		Date[] period = DateUtils.getDatePeriod(year, month);
		Date begin = period[0];
		Date end = period[1];
		List<Issue> l = issueDAO.findIssuesByResponsible(userId, begin, end,
				issueStatusIds);
		if (l == null) {
			l = ListUtils.EMPTY_LIST;
		}
		return l;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.timekey.rmh.service.IssueService#findIssuesByResponsible(int,
	 * int, int, java.lang.Boolean)
	 */
	@SuppressWarnings("unchecked")
	public List<Issue> findIssuesByResponsible(int userId, int year, int month,
			Boolean isClosed) {
		Date[] period = DateUtils.getDatePeriod(year, month);
		Date begin = period[0];
		Date end = period[1];
		logger.debug("begin: " + begin + ", end: " + end);
		List<Integer> issueStatusIds = this
				.getIssueStatusIdsByIsClosed(isClosed);
		List<Issue> l = issueDAO.findIssuesByResponsible(userId, begin, end,
				issueStatusIds);
		if (l == null) {
			l = ListUtils.EMPTY_LIST;
		}
		return l;
	}
}
