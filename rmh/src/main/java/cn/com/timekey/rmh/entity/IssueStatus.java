package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the issue_statuses database table.
 * 
 */
@Entity
@Table(name = "issue_statuses")
@NamedQueries({
		@NamedQuery(name = "IssueStatus.findAll", query = "SELECT i FROM IssueStatus i"),
		@NamedQuery(name = "IssueStatus.findByIsClosed", query = "SELECT i FROM IssueStatus i WHERE i.isClosed=:isClosed") })
public class IssueStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "default_done_ratio")
	private Integer defaultDoneRatio;

	@Column(name = "is_closed")
	private Integer isClosed;

	@Column(name = "is_default")
	private byte isDefault;

	private String name;

	private Integer position;

	// bi-directional many-to-one association to Issue
	@OneToMany(mappedBy = "issueStatus")
	private List<Issue> issues;

	public IssueStatus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDefaultDoneRatio() {
		return this.defaultDoneRatio;
	}

	public void setDefaultDoneRatio(Integer defaultDoneRatio) {
		this.defaultDoneRatio = defaultDoneRatio;
	}

	public Integer getIsClosed() {
		return this.isClosed;
	}

	public void setIsClosed(Integer isClosed) {
		this.isClosed = isClosed;
	}

	public byte getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(byte isDefault) {
		this.isDefault = isDefault;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setIssueStatus(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setIssueStatus(null);

		return issue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IssueStatus [id=" + id + ", defaultDoneRatio="
				+ defaultDoneRatio + ", isClosed=" + isClosed + ", isDefault="
				+ isDefault + ", name=" + name + ", position=" + position + "]";
	}

}