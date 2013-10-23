/**
 *  <b>日期：</b>Oct 17, 2013-4:30:58 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>类名称：</b>Issue<br/>
 * <b>类描述：</b>Issue的的VO类<br/>
 * <b>创建时间：</b>Oct 17, 2013 4:30:58 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class Issue {

	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");

	private Integer id;
	private String createdOn;
	private String dueDate;
	private Float estimatedHours;
	private String startDate;
	private String subject;
	private String updatedOn;
	private Project project;
	private User assignedUser;
	private User authorUser;
	private String statusName;
	private Boolean isClosed;
	/**
	 * responsibleUser:责任人
	 */
	private User responsibleUser;

	/**
	 * 创建一个新的实例 Issue.
	 */
	public Issue() {
		super();
	}

	/**
	 * 创建一个新的实例 Issue.
	 * 
	 * @param id
	 * @param createdOn
	 * @param dueDate
	 * @param estimatedHours
	 * @param startDate
	 * @param subject
	 * @param updatedOn
	 * @param project
	 * @param assignedUser
	 * @param authorUser
	 * @param statusName
	 * @param isClosed
	 * 
	 */
	public Issue(Integer id, String createdOn, String dueDate,
			Float estimatedHours, String startDate, String subject,
			String updatedOn, Project project, User assignedUser,
			User authorUser, String statusName, Boolean isClosed) {
		super();
		this.id = id;
		this.createdOn = createdOn;
		this.dueDate = dueDate;
		this.estimatedHours = estimatedHours;
		this.startDate = startDate;
		this.subject = subject;
		this.updatedOn = updatedOn;
		this.project = project;
		this.assignedUser = assignedUser;
		this.authorUser = authorUser;
		this.statusName = statusName;
		this.isClosed = isClosed;
	}

	/**
	 * <p>
	 * new <code>cn.com.timekey.rmh.vo.Issue</code> from
	 * <code>cn.com.timekey.rmh.entity.Issue</code>
	 * </p>
	 * 
	 * @param po
	 *            cn.com.timekey.rmh.entity.Issue
	 * @return cn.com.timekey.rmh.vo.Issue
	 */
	public static Issue newInstance(cn.com.timekey.rmh.entity.Issue po) {
		String createOn = format(po.getCreatedOn());
		String dueDate = format(po.getDueDate());
		String updatedOn = format(po.getUpdatedOn());
		String startDate = format(po.getStartDate());
		cn.com.timekey.rmh.vo.Issue is = new cn.com.timekey.rmh.vo.Issue(
				po.getId(), createOn, dueDate, po.getEstimatedHours(),
				startDate, po.getSubject(), updatedOn, Project.newInstance(po
						.getProject().getId(), po.getProject().getIdentifier(),
						po.getProject().getName()), User.newInstance(po
						.getAssignedUser().getId(), po.getAssignedUser()
						.getFirstname() + po.getAssignedUser().getLastname()),
				User.newInstance(po.getAuthorUser().getId(), po.getAuthorUser()
						.getFirstname() + po.getAuthorUser().getLastname()), po
						.getIssueStatus().getName(), po.getIssueStatus()
						.getIsClosed() != 0);
		return is;
	}

	/**
	 * <p>
	 * new <code>cn.com.timekey.rmh.vo.Issue</code> from
	 * <code>cn.com.timekey.rmh.entity.Issue</code>
	 * </p>
	 * 
	 * @param po
	 *            cn.com.timekey.rmh.entity.Issue
	 * @param respUser
	 *            责任人
	 * @return cn.com.timekey.rmh.vo.Issue
	 */
	public static Issue newInstance(cn.com.timekey.rmh.entity.Issue po,
			cn.com.timekey.rmh.entity.User respUser) {
		cn.com.timekey.rmh.vo.Issue is = newInstance(po);
		is.setResponsibleUser(cn.com.timekey.rmh.vo.User.newInstance(
				respUser.getId(),
				respUser.getFirstname() + respUser.getLastname()));
		return is;
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
	private static String format(Date date) {
		return date != null ? sdf.format(date) : "";
	}

	/**
	 * id
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * createdOn
	 * 
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * dueDate
	 * 
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * estimatedHours
	 * 
	 * @return the estimatedHours
	 */
	public Float getEstimatedHours() {
		return estimatedHours;
	}

	/**
	 * @param estimatedHours
	 *            the estimatedHours to set
	 */
	public void setEstimatedHours(Float estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	/**
	 * startDate
	 * 
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * subject
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * updatedOn
	 * 
	 * @return the updatedOn
	 */
	public String getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
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
	 * assignedUser
	 * 
	 * @return the assignedUser
	 */
	public User getAssignedUser() {
		return assignedUser;
	}

	/**
	 * @param assignedUser
	 *            the assignedUser to set
	 */
	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	/**
	 * authorUser
	 * 
	 * @return the authorUser
	 */
	public User getAuthorUser() {
		return authorUser;
	}

	/**
	 * @param authorUser
	 *            the authorUser to set
	 */
	public void setAuthorUser(User authorUser) {
		this.authorUser = authorUser;
	}

	/**
	 * statusName
	 * 
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName
	 *            the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Issue [id=" + id + ", createdOn=" + createdOn + ", dueDate="
				+ dueDate + ", estimatedHours=" + estimatedHours
				+ ", startDate=" + startDate + ", subject=" + subject
				+ ", updatedOn=" + updatedOn + ", project=" + project
				+ ", assignedUser=" + assignedUser + ", authorUser="
				+ authorUser + ", statusName=" + statusName + "]";
	}

	/**
	 * isClosed
	 * 
	 * @return the isClosed
	 */
	public Boolean getIsClosed() {
		return isClosed;
	}

	/**
	 * @param isClosed
	 *            the isClosed to set
	 */
	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	/**
	 * responsibleUser
	 * 
	 * @return the responsibleUser
	 */
	public User getResponsibleUser() {
		return responsibleUser;
	}

	/**
	 * @param responsibleUser
	 *            the responsibleUser to set
	 */
	public void setResponsibleUser(User responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

}
