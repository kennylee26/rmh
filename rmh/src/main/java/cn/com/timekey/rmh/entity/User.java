package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private byte admin;

	@Column(name="auth_source_id")
	private Integer authSourceId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String firstname;

	@Column(name="hashed_password")
	private String hashedPassword;

	@Column(name="identity_url")
	private String identityUrl;

	private String language;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login_on")
	private Date lastLoginOn;

	private String lastname;

	private String login;

	private String mail;

	@Column(name="mail_notification")
	private String mailNotification;

	private String salt;

	private Integer status;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="assignedUser")
	private List<Issue> asignedIssue;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="authorUser")
	private List<Issue> authorIssue;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte getAdmin() {
		return this.admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}

	public Integer getAuthSourceId() {
		return this.authSourceId;
	}

	public void setAuthSourceId(Integer authSourceId) {
		this.authSourceId = authSourceId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getHashedPassword() {
		return this.hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getIdentityUrl() {
		return this.identityUrl;
	}

	public void setIdentityUrl(String identityUrl) {
		this.identityUrl = identityUrl;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLastLoginOn() {
		return this.lastLoginOn;
	}

	public void setLastLoginOn(Date lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMailNotification() {
		return this.mailNotification;
	}

	public void setMailNotification(String mailNotification) {
		this.mailNotification = mailNotification;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<Issue> getAsignedIssue() {
		return this.asignedIssue;
	}

	public void setAsignedIssue(List<Issue> asignedIssue) {
		this.asignedIssue = asignedIssue;
	}

	public Issue addAsignedIssue(Issue asignedIssue) {
		getAsignedIssue().add(asignedIssue);
		asignedIssue.setAssignedUser(this);

		return asignedIssue;
	}

	public Issue removeAsignedIssue(Issue asignedIssue) {
		getAsignedIssue().remove(asignedIssue);
		asignedIssue.setAssignedUser(null);

		return asignedIssue;
	}

	public List<Issue> getAuthorIssue() {
		return this.authorIssue;
	}

	public void setAuthorIssue(List<Issue> authorIssue) {
		this.authorIssue = authorIssue;
	}

	public Issue addAuthorIssue(Issue authorIssue) {
		getAuthorIssue().add(authorIssue);
		authorIssue.setAuthorUser(this);

		return authorIssue;
	}

	public Issue removeAuthorIssue(Issue authorIssue) {
		getAuthorIssue().remove(authorIssue);
		authorIssue.setAuthorUser(null);

		return authorIssue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", admin=" + admin + ", authSourceId="
				+ authSourceId + ", createdOn=" + createdOn + ", firstname="
				+ firstname + ", hashedPassword=" + hashedPassword
				+ ", identityUrl=" + identityUrl + ", language=" + language
				+ ", lastLoginOn=" + lastLoginOn + ", lastname=" + lastname
				+ ", login=" + login + ", mail=" + mail + ", mailNotification="
				+ mailNotification + ", salt=" + salt + ", status=" + status
				+ ", type=" + type + ", updatedOn=" + updatedOn + "]";
	}

}