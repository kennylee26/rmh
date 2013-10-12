/**
 *  <b>日期：</b>Oct 11, 2013-4:10:23 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.repository;

import java.util.List;

import cn.com.timekey.rmh.entity.VUserIsuesHour;

/**
 * <b>类名称：</b>VUserIsuesHourDAO<br/>
 * <b>类描述：</b>VUserIsuesHourDAO的DAO接口，查询已完成的工时v_user_isues_hours_finished<br/>
 * <b>创建时间：</b>Oct 11, 2013 4:10:23 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public interface VUserIsuesHourDAO {

	public static final String userName = "user_name";
	public static final String year = "year";
	public static final String month = "month";
	public static final String isuesHours = "isues_hours";

	/**
	 * <p>
	 * 根据查询实例进行查询。
	 * </p>
	 * <p>
	 * 注：example对象中的user参数会覆盖userName参数，即如果同时存在user和userName参数的话，会按照user为准！
	 * </p>
	 * 
	 * @param example
	 *            查询实例
	 * @return
	 */
	public List<VUserIsuesHour> findByExample(VUserIsuesHour example);
}
