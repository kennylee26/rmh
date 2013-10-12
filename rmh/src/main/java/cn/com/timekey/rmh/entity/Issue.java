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

	@Column(name = "assigned_to_id")
	private Integer assignedToId;

	@Column(name = "author_id")
	private Integer authorId;

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
	private Float estimatedHours;

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

	@Column(name = "project_id")
	private Integer projectId;

	private Integer rgt;

	@Column(name = "root_id")
	private Integer rootId;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "status_id")
	private Integer statusId;

	private String subject;

	@Column(name = "tracker_id")
	private Integer trackerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "user_story_id")
	private Integer userStoryId;

	public Issue() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAssignedToId() {
		return this.assignedToId;
	}

	public void setAssignedToId(Integer assignedToId) {
		this.assignedToId = assignedToId;
	}

	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
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

	public Float getEstimatedHours() {
		return this.estimatedHours;
	}

	public void setEstimatedHours(Float estimatedHours) {
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

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Issue [id=" + id + ", assignedToId=" + assignedToId
				+ ", authorId=" + authorId + ", categoryId=" + categoryId
				+ ", createdOn=" + createdOn + ", description=" + description
				+ ", doneRatio=" + doneRatio + ", dueDate=" + dueDate
				+ ", estimatedHours=" + estimatedHours + ", fixedVersionId="
				+ fixedVersionId + ", isPrivate=" + isPrivate + ", lft=" + lft
				+ ", lockVersion=" + lockVersion + ", parentId=" + parentId
				+ ", priorityId=" + priorityId + ", projectId=" + projectId
				+ ", rgt=" + rgt + ", rootId=" + rootId + ", startDate="
				+ startDate + ", statusId=" + statusId + ", subject=" + subject
				+ ", trackerId=" + trackerId + ", updatedOn=" + updatedOn
				+ ", userStoryId=" + userStoryId + "]";
	}

}