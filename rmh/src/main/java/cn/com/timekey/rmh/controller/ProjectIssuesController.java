/**
 *  <b>日期：</b>Oct 12, 2013-3:35:31 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.timekey.rmh.entity.Project;
import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.service.ProjectService;
import cn.com.timekey.rmh.vo.ProjectIssueInfo;

/**
 * <b>类名称：</b>ProjectIssuesController<br/>
 * <b>类描述：</b>获取项目的问题信息<br/>
 * <b>创建时间：</b>Oct 12, 2013 3:35:31 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Controller
public class ProjectIssuesController {

	@Resource
	private ProjectService projectService;

	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * <p>
	 * 查询某用户的本月管理的单位问题情况列表
	 * </p>
	 * 
	 * @param userid
	 *            用户id
	 * @param year
	 *            String 年份
	 * @param month
	 *            String 月份 1月份为1，2月份为2，如此类推。
	 * @return JSON
	 */
	@RequestMapping(value = "/ajax/project/work_info/{userid}", method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectIssueInfo> getUserWorkInfo(
			@PathVariable("userid") String userid, HttpServletRequest request) {
		logger.debug("UserIssuesHourController.getUserHourInfo()");
		User user = new User();
		user.setId(Integer.valueOf(userid));
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		try {
			if (request.getParameter("year") != null)
				y = Integer.valueOf(request.getParameter("year"));
			if (request.getParameter("month") != null)
				m = Integer.valueOf(request.getParameter("month"));
		} catch (NumberFormatException e) {
			logger.warn(e.getMessage());
		}
		List<ProjectIssueInfo> l = projectService.findManaProjectInfo(user, y,
				m);
		return l;
	}

	@RequestMapping(value = "/ajax/project/time/{identifier}", method = RequestMethod.GET)
	public @ResponseBody
	Double getTotalTime(@PathVariable("identifier") String identifier,
			HttpServletRequest request) {
		logger.debug("ProjectIssuesController.getTotalTime()");
		Project project = new Project();
		project.setIdentifier(identifier);
		double d = projectService.getTotalEstimatedHours(project, null, null,
				true);
		return d;
	}
}
