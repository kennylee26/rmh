/**
 *  <b>日期：</b>Oct 12, 2013-3:35:31 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.timekey.rmh.entity.Issue;
import cn.com.timekey.rmh.service.IssueService;
import cn.com.timekey.rmh.vo.MonthWorkInfo;
import cn.com.timekey.rmh.vo.Project;
import cn.com.timekey.rmh.vo.User;

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

	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
	 * @return JSON
	 */
	@RequestMapping(value = "/ajax/user/work_info/{userid}", method = RequestMethod.GET)
	public @ResponseBody
	MonthWorkInfo getUserWorkInfo(@PathVariable("userid") String userid,
			@RequestParam("type") String type) {
		logger.debug("UserIssuesHourController.getUserHourInfo()");
		MonthWorkInfo workInfo = issueService.getNewestWorkInfoByUserId(Integer
				.valueOf(userid));
		Boolean isClosed = false;// 默认显示未关闭的
		if (type != null) {
			if (type.equalsIgnoreCase("all")) {
				isClosed = null;
			} else if (type.equalsIgnoreCase("closed")) {
				isClosed = true;
			}
		}
		logger.debug("isClosed: " + isClosed);
		List<Issue> issues = issueService.findIssuesByResponsible(
				workInfo.getUserId(), workInfo.getYear(), workInfo.getMonth(),
				isClosed);
		if (CollectionUtils.isEmpty(issues) == false) {
			setIssueList(workInfo, issues);
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
			String createOn = format(issue.getCreatedOn());
			String dueDate = format(issue.getDueDate());
			String updatedOn = format(issue.getUpdatedOn());
			String startDate = format(issue.getStartDate());
			cn.com.timekey.rmh.vo.Issue is = new cn.com.timekey.rmh.vo.Issue(
					issue.getId(), createOn, dueDate,
					issue.getEstimatedHours(), startDate, issue.getSubject(),
					updatedOn, Project.newInstance(issue.getProject().getId(),
							issue.getProject().getIdentifier(), issue
									.getProject().getName()), User.newInstance(
							issue.getAssignedUser().getId(), issue
									.getAssignedUser().getFirstname()
									+ issue.getAssignedUser().getLastname()),
					User.newInstance(issue.getAuthorUser().getId(), issue
							.getAuthorUser().getFirstname()
							+ issue.getAuthorUser().getLastname()), issue
							.getIssueStatus().getName(), issue.getIssueStatus()
							.getIsClosed() != 0);
			l.add(is);
		}
	}

	/**
	 * <p>
	 * Date 转 string
	 * </p>
	 * 
	 * @param sdf
	 * @param issue
	 * @return String 日期格式的字符串
	 */
	private String format(Date date) {
		return date != null ? sdf.format(date) : "";
	}

}
