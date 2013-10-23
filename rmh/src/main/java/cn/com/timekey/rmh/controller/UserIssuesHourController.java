/**
 *  <b>日期：</b>Oct 12, 2013-3:35:31 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.service.IssueService;
import cn.com.timekey.rmh.vo.MonthWorkInfo;

/**
 * <b>类名称：</b>UserIssuesHourController<br/>
 * <b>类描述：</b>获取用户完成工时的界面<br/>
 * <b>创建时间：</b>Oct 12, 2013 3:35:31 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Controller
public class UserIssuesHourController {

	@Resource
	private IssueService issueService;

	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * <p>
	 * 查询某用户的本月问题列表
	 * </p>
	 * 
	 * @param userid
	 *            用户ID
	 * @param model
	 * @return JSP View
	 */
	@RequestMapping(value = "/user/spent/{userid}", method = RequestMethod.GET)
	public String getUserHourInfo(@PathVariable("userid") String userid,
			Model model) {
		logger.debug("UserIssuesHourController.getUserHourInfo()");
		MonthWorkInfo spentTimeInfo = issueService
				.getNewestWorkInfoByUserId(Integer.valueOf(userid));
		Boolean isClosed = false;
		List<Issue> issues = issueService.findIssuesByResponsible(
				spentTimeInfo.getUserId(), spentTimeInfo.getYear(),
				spentTimeInfo.getMonth(), isClosed);
		model.addAttribute("hourinfo", spentTimeInfo);
		model.addAttribute("issues", issues);
		return "hourinfo";
	}

	/**
	 * <p>
	 * 查询某用户的本月问题列表
	 * </p>
	 * 
	 * @param userid
	 *            用户id
	 * @param type
	 *            String 查询的问题类别。all为全部，closed为已经关闭的，否则都为查询未关闭的。
	 * @param year
	 *            String 年份
	 * @param month
	 *            String 月份 1月份为1，2月份为2，如此类推。
	 * @return JSON
	 */
	@RequestMapping(value = "/ajax/user/work_info/{userid}", method = RequestMethod.GET)
	public @ResponseBody
	MonthWorkInfo getUserWorkInfo(@PathVariable("userid") String userid,
			HttpServletRequest request) {
		logger.debug("UserIssuesHourController.getUserHourInfo()");
		String type = request.getParameter("type");
		MonthWorkInfo workInfo = getWorkInfo(userid,
				request.getParameter("year"), request.getParameter("month"));
		logger.debug("isClosed: " + issueType(type));
		List<Issue> issues = issueService.findIssuesByResponsible(
				workInfo.getUserId(), workInfo.getYear(), workInfo.getMonth(),
				issueType(type));
		if (CollectionUtils.isEmpty(issues) == false) {
			setIssueList(workInfo, issues);
		}
		return workInfo;
	}

	/**
	 * <p>
	 * 查询的问题的状态
	 * </p>
	 * 
	 * @param type
	 * @return
	 */
	private Boolean issueType(String type) {
		Boolean isClosed = false;// 默认显示未关闭的
		if (type != null) {
			if (type.equalsIgnoreCase("all")) {
				isClosed = null;
			} else if (type.equalsIgnoreCase("closed")) {
				isClosed = true;
			}
		}
		return isClosed;
	}

	/**
	 * <p>
	 * 查询指定条件的工作信息
	 * </p>
	 * 
	 * @param userid
	 *            用户id
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return MonthWorkInfo 基础的MonthWorkInfo对象
	 */
	private MonthWorkInfo getWorkInfo(String userid, String year, String month) {
		MonthWorkInfo workInfo = null;
		if (year == null && month == null) {
			workInfo = issueService.getNewestWorkInfoByUserId(Integer
					.valueOf(userid));
		} else {
			Calendar cal = Calendar.getInstance();
			int y = cal.get(Calendar.YEAR);
			int m = cal.get(Calendar.MONTH) + 1;
			try {
				if (year != null)
					y = Integer.valueOf(year);
				if (month != null)
					m = Integer.valueOf(month);
			} catch (NumberFormatException e) {
				logger.warn(e.getMessage());
			}
			workInfo = issueService.getWorkInfoByUserId(
					Integer.valueOf(userid), y, m);
		}
		return workInfo;
	}

	/**
	 * <p>
	 * Issue实体转成VO的Issue以便投递
	 * </p>
	 * 
	 * @param workInfo
	 *            值载体
	 * @param issues
	 *            Issue实体
	 */
	private void setIssueList(MonthWorkInfo workInfo, List<Issue> issues) {
		List<cn.com.timekey.rmh.vo.Issue> l = new ArrayList<cn.com.timekey.rmh.vo.Issue>(
				issues.size());
		workInfo.setIssues(l);
		for (Issue issue : issues) {
			cn.com.timekey.rmh.vo.Issue is = cn.com.timekey.rmh.vo.Issue
					.newInstance(issue);
			l.add(is);
		}
	}

}
