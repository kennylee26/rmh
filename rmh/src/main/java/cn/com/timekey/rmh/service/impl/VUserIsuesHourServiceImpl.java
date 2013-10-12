/**
 *  <b>日期：</b>Oct 12, 2013-3:20:40 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.timekey.rmh.entity.User;
import cn.com.timekey.rmh.entity.VUserIsuesHour;
import cn.com.timekey.rmh.repository.VUserIsuesHourDAO;
import cn.com.timekey.rmh.service.VUserIsuesHourService;

/**
 * <b>类名称：</b>VUserIsuesHourServiceImpl<br/>
 * <b>类描述：</b>VUserIsuesHourService的实现类<br/>
 * <b>创建时间：</b>Oct 12, 2013 3:20:40 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Service("vUserIsuesHourService")
public class VUserIsuesHourServiceImpl implements VUserIsuesHourService {

	private final Log logger = LogFactory.getLog(getClass());
	@Resource
	private VUserIsuesHourDAO vUserIsuesHourDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.timekey.rmh.service.VUserIsuesHourService#findLast(int)
	 */
	public VUserIsuesHour findLast(int userId) {
		logger.debug("VUserIsuesHourServiceImpl.findLast()");
		VUserIsuesHour last = null;
		List<VUserIsuesHour> l = this.findCurrentYearInfo(userId);
		if (CollectionUtils.isEmpty(l) == false) {
			last = l.get(0);
		}
		return last;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.VUserIsuesHourService#findCurrentYearInfo(int)
	 */
	public List<VUserIsuesHour> findCurrentYearInfo(int userId) {
		VUserIsuesHour example = new VUserIsuesHour();
		User user = new User();
		user.setId(userId);
		example.setUser(user);
		example.setYear(Calendar.getInstance().get(Calendar.YEAR));
		return vUserIsuesHourDAO.findByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.timekey.rmh.service.VUserIsuesHourService#findByExample(cn.com
	 * .timekey.rmh.entity.VUserIsuesHour)
	 */
	public List<VUserIsuesHour> findByExample(VUserIsuesHour example) {
		return vUserIsuesHourDAO.findByExample(example);
	}
}
