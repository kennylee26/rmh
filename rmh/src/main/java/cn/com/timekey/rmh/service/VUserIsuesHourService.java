/**
 *  <b>日期：</b>Oct 12, 2013-3:16:56 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.com.timekey.rmh.entity.VUserIsuesHour;

/**
 * <b>类名称：</b>VUserIsuesHourService<br/>
 * <b>类描述：</b>VUserIsuesHour的业务层<br/>
 * <b>创建时间：</b>Oct 12, 2013 3:16:56 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@Transactional
public interface VUserIsuesHourService {

	/**
	 * <p>
	 * 获取最后一条统计信息
	 * </p>
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public VUserIsuesHour findLast(int userId);

	/**
	 * <p>
	 * 获取某用户本年度的统计信息
	 * </p>
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<VUserIsuesHour> findCurrentYearInfo(int userId);

	/**
	 * <p>
	 * 实例查询
	 * </p>
	 * 
	 * @param example
	 * @return VUserIsuesHour的列表
	 */
	@Transactional(readOnly = true)
	public List<VUserIsuesHour> findByExample(VUserIsuesHour example);

}
