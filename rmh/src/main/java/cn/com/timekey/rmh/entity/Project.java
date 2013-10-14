package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Lob
	private String description;

	@Lob
	@Column(name="dmsf_description")
	private String dmsfDescription;

	private String homepage;

	private String identifier;

	@Column(name="is_public")
	private byte isPublic;

	private Integer lft;

	private String name;

	@Column(name="parent_id")
	private Integer parentId;

	private Integer rgt;

	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="project")
	private List<Issue> issues;

	public Project() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDmsfDescription() {
		return this.dmsfDescription;
	}

	public void setDmsfDescription(String dmsfDescription) {
		this.dmsfDescription = dmsfDescription;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public byte getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(byte isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getLft() {
		return this.lft;
	}

	public void setLft(Integer lft) {
		this.lft = lft;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getRgt() {
		return this.rgt;
	}

	public void setRgt(Integer rgt) {
		this.rgt = rgt;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setProject(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setProject(null);

		return issue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [id=" + id + ", createdOn=" + createdOn
				+ ", description=" + description + ", dmsfDescription="
				+ dmsfDescription + ", homepage=" + homepage + ", identifier="
				+ identifier + ", isPublic=" + isPublic + ", lft=" + lft
				+ ", name=" + name + ", parentId=" + parentId + ", rgt=" + rgt
				+ ", status=" + status + ", updatedOn=" + updatedOn + "]";
	}

}