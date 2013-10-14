package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the issues database table.
 * 
 */
@Entity
@Table(name = "issues")
@NamedQuery(name = "Issue.findAll", query = "SELECT i FROM Issue i")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "category_id")
	private Integer categoryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn;

	@Lob
	private String description;

	@Column(name = "done_ratio")
	private Integer doneRatio;

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "estimated_hours")
	private float estimatedHours;

	@Column(name = "fixed_version_id")
	private Integer fixedVersionId;

	@Column(name = "is_private")
	private byte isPrivate;

	private Integer lft;

	@Column(name = "lock_version")
	private Integer lockVersion;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "priority_id")
	private Integer priorityId;

	private Integer rgt;

	@Column(name = "root_id")
	private Integer rootId;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	private String subject;

	@Column(name = "tracker_id")
	private Integer trackerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "user_story_id")
	private Integer userStoryId;

	// bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "assigned_to_id")
	private User assignedUser;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User authorUser;

	// bi-directional many-to-one association to IssueStatus
	@ManyToOne
	@JoinColumn(name = "status_id")
	private IssueStatus issueStatus;

	public Issue() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDoneRatio() {
		return this.doneRatio;
	}

	public void setDoneRatio(Integer doneRatio) {
		this.doneRatio = doneRatio;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public float getEstimatedHours() {
		return this.estimatedHours;
	}

	public void setEstimatedHours(float estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Integer getFixedVersionId() {
		return this.fixedVersionId;
	}

	public void setFixedVersionId(Integer fixedVersionId) {
		this.fixedVersionId = fixedVersionId;
	}

	public byte getIsPrivate() {
		return this.isPrivate;
	}

	public void setIsPrivate(byte isPrivate) {
		this.isPrivate = isPrivate;
	}

	public Integer getLft() {
		return this.lft;
	}

	public void setLft(Integer lft) {
		this.lft = lft;
	}

	public Integer getLockVersion() {
		return this.lockVersion;
	}

	public void setLockVersion(Integer lockVersion) {
		this.lockVersion = lockVersion;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public Integer getRgt() {
		return this.rgt;
	}

	public void setRgt(Integer rgt) {
		this.rgt = rgt;
	}

	public Integer getRootId() {
		return this.rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getTrackerId() {
		return this.trackerId;
	}

	public void setTrackerId(Integer trackerId) {
		this.trackerId = trackerId;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getUserStoryId() {
		return this.userStoryId;
	}

	public void setUserStoryId(Integer userStoryId) {
		this.userStoryId = userStoryId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getAssignedUser() {
		return this.assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public User getAuthorUser() {
		return this.authorUser;
	}

	public void setAuthorUser(User authorUser) {
		this.authorUser = authorUser;
	}

	public IssueStatus getIssueStatus() {
		return this.issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Issue [id=" + id + ", categoryId=" + categoryId
				+ ", createdOn=" + createdOn + ", description=" + description
				+ ", doneRatio=" + doneRatio + ", dueDate=" + dueDate
				+ ", estimatedHours=" + estimatedHours + ", fixedVersionId="
				+ fixedVersionId + ", isPrivate=" + isPrivate + ", lft=" + lft
				+ ", lockVersion=" + lockVersion + ", parentId=" + parentId
				+ ", priorityId=" + priorityId + ", rgt=" + rgt + ", rootId="
				+ rootId + ", startDate=" + startDate + ", subject=" + subject
				+ ", trackerId=" + trackerId + ", updatedOn=" + updatedOn
				+ ", userStoryId=" + userStoryId + ", project=" + project
				+ ", assignedUser=" + assignedUser + ", authorUser="
				+ authorUser + ", issueStatus=" + issueStatus + "]";
	}

}