/**
 *  <b>日期：</b>Oct 14, 2013-10:21:08 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.enums;

/**
 * <b>类名称：</b>Tracker<br/>
 * <b>类描述：</b>问题类别<br/>
 * <b>创建时间：</b>Oct 14, 2013 10:21:08 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public enum TrackerEnum {
	/**
	 * OTCL:加班补休
	 */
	OTCL(16),
	/**
	 * OT:加班
	 */
	OT(17),
	/**
	 * CL:补休
	 */
	CL(18);// compensated leave

	private final int id;

	TrackerEnum(int id) {
		this.id = id;
	}

	/**
	 * id
	 * 
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}
}
