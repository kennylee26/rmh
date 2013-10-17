/**
 *  <b>日期：</b>Oct 14, 2013-10:28:38 AM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.vo;

import java.util.List;

/**
 * <b>类名称：</b>MonthWorkInfo<br/>
 * <b>类描述：</b>用户月份工作情况<br/>
 * <b>创建时间：</b>Oct 14, 2013 10:28:38 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class MonthWorkInfo {

	private int userId;
	private int month;
	private int year;
	
	private List<Issue> issues;

	/**
	 * finishedTime:已经完成的时间
	 */
	private Double finishedTime;
	/**
	 * planingTime:计划中的时间
	 */
	private Double planingTime;
	/**
	 * targetTime:本月目标时间
	 */
	private Double targetTime;

	/**
	 * 创建一个新的实例 MonthWorkInfo.
	 */
	public MonthWorkInfo() {
		super();
	}

	/**
	 * 创建一个新的实例 MonthWorkInfo.
	 * 
	 * @param userId
	 * @param month
	 * @param year
	 * @param finishedTime
	 * @param planingTime
	 * @param targetTime
	 */
	public MonthWorkInfo(int userId, int month, int year, Double finishedTime,
			Double planingTime, Double targetTime) {
		super();
		this.userId = userId;
		this.month = month;
		this.year = year;
		this.finishedTime = finishedTime;
		this.planingTime = planingTime;
		this.targetTime = targetTime;
	}

	/**
	 * userId
	 * 
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * month
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * year
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * finishedTime
	 * 
	 * @return the finishedTime
	 */
	public Double getFinishedTime() {
		return finishedTime;
	}

	/**
	 * @param finishedTime
	 *            the finishedTime to set
	 */
	public void setFinishedTime(Double finishedTime) {
		this.finishedTime = finishedTime;
	}

	/**
	 * planingTime
	 * 
	 * @return the planingTime
	 */
	public Double getPlaningTime() {
		return planingTime;
	}

	/**
	 * @param planingTime
	 *            the planingTime to set
	 */
	public void setPlaningTime(Double planingTime) {
		this.planingTime = planingTime;
	}

	/**
	 * targetTime
	 * 
	 * @return the targetTime
	 */
	public Double getTargetTime() {
		return targetTime;
	}

	/**
	 * @param targetTime
	 *            the targetTime to set
	 */
	public void setTargetTime(Double targetTime) {
		this.targetTime = targetTime;
	}

	/**
	 * issues  
	 * @return the issues
	 */
	public List<Issue> getIssues() {
		return issues;
	}

	/**
	 * @param issues the issues to set
	 */
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MonthWorkInfo [userId=" + userId + ", month=" + month
				+ ", year=" + year + ", issues=" + issues + ", finishedTime="
				+ finishedTime + ", planingTime=" + planingTime
				+ ", targetTime=" + targetTime + "]";
	}
	
	

}
