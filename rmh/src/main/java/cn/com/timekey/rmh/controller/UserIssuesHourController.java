/**
 *  <b>日期：</b>Oct 12, 2013-3:35:31 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.timekey.rmh.entity.VUserIsuesHour;
import cn.com.timekey.rmh.service.VUserIsuesHourService;

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
	private VUserIsuesHourService vUserIsuesHourService;

	private final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/user/spent/{userid}", method = RequestMethod.GET)
	public String getUserHourInfo(@PathVariable("userid") String userid,
			Model model) {
		logger.debug("UserIssuesHourController.getUserHourInfo()");
		VUserIsuesHour hourinfo = vUserIsuesHourService.findLast(Integer
				.valueOf(userid));
		model.addAttribute("hourinfo", hourinfo);
		return "hourinfo";
	}
}
