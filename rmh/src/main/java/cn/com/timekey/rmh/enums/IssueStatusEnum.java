/**
 *  <b>日期：</b>Oct 14, 2013-10:17:08 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.enums;

import cn.com.timekey.rmh.entity.IssueStatus;

/**
 * <b>类名称：</b>IssueStatus<br/>
 * <b>类描述：</b>问题的状态<br/>
 * <b>创建时间：</b>Oct 14, 2013 10:17:08 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public enum IssueStatusEnum {
	NEW(1), CLOSED(5), DONE(16);

	private final int id;

	IssueStatusEnum(int id) {
		this.id = id;
	}

	/**
	 * id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public IssueStatus getEntity() {
		IssueStatus e = new IssueStatus();
		e.setId(this.id);
		return e;
	}
}
