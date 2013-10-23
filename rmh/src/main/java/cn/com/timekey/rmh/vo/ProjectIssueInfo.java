/**
 *  <b>日期：</b>Oct 23, 2013-3:27:18 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.vo;

import java.util.List;

/**
 * <b>类名称：</b>ProjectIssueInfo<br/>
 * <b>类描述：</b>项目情况信息<br/>
 * <b>创建时间：</b>Oct 23, 2013 3:27:18 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class ProjectIssueInfo {

	private Project project;
	private List<Issue> issues;
	private int year;
	private int month;
	private double monthFinishedTime;
	private double monthPlaningTime;

	/**
	 * 创建一个新的实例 ProjectIssueInfo.
	 */
	public ProjectIssueInfo() {
		super();
	}

	/**
	 * 创建一个新的实例 ProjectIssueInfo.
	 * 
	 * @param project
	 * @param year
	 * @param month
	 * @param monthFinishedTime
	 * @param monthPlaningTime
	 */
	public ProjectIssueInfo(Project project, int year, int month,
			double monthFinishedTime, double monthPlaningTime) {
		super();
		this.project = project;
		this.year = year;
		this.month = month;
		this.monthFinishedTime = monthFinishedTime;
		this.monthPlaningTime = monthPlaningTime;
	}

	/**
	 * 创建一个新的实例 ProjectIssueInfo.
	 * 
	 * @param project
	 * @param issues
	 * @param year
	 * @param month
	 * @param monthFinishedTime
	 * @param monthPlaningTime
	 */
	public ProjectIssueInfo(Project project, List<Issue> issues, int year,
			int month, double monthFinishedTime, double monthPlaningTime) {
		super();
		this.project = project;
		this.issues = issues;
		this.year = year;
		this.month = month;
		this.monthFinishedTime = monthFinishedTime;
		this.monthPlaningTime = monthPlaningTime;
	}

	/**
	 * project
	 * 
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * issues
	 * 
	 * @return the issues
	 */
	public List<Issue> getIssues() {
		return issues;
	}

	/**
	 * @param issues
	 *            the issues to set
	 */
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
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
	 * monthFinishedTime
	 * 
	 * @return the monthFinishedTime
	 */
	public double getMonthFinishedTime() {
		return monthFinishedTime;
	}

	/**
	 * @param monthFinishedTime
	 *            the monthFinishedTime to set
	 */
	public void setMonthFinishedTime(double monthFinishedTime) {
		this.monthFinishedTime = monthFinishedTime;
	}

	/**
	 * monthPlaningTime
	 * 
	 * @return the monthPlaningTime
	 */
	public double getMonthPlaningTime() {
		return monthPlaningTime;
	}

	/**
	 * @param monthPlaningTime
	 *            the monthPlaningTime to set
	 */
	public void setMonthPlaningTime(double monthPlaningTime) {
		this.monthPlaningTime = monthPlaningTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectIssueInfo [project=" + project + ", issues=" + issues
				+ ", year=" + year + ", month=" + month
				+ ", monthFinishedTime=" + monthFinishedTime
				+ ", monthPlaningTime=" + monthPlaningTime + "]";
	}

}
