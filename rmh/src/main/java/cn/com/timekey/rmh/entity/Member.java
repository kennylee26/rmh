package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the members database table.
 * 
 */
@Entity
@Table(name="members")
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="dmsf_mail_notification")
	private byte dmsfMailNotification;

	@Column(name="mail_notification")
	private byte mailNotification;

	//bi-directional one-to-one association to MemberRole
	@OneToOne(mappedBy="member")
	private MemberRole memberRole;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Member() {
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

	public byte getDmsfMailNotification() {
		return this.dmsfMailNotification;
	}

	public void setDmsfMailNotification(byte dmsfMailNotification) {
		this.dmsfMailNotification = dmsfMailNotification;
	}

	public byte getMailNotification() {
		return this.mailNotification;
	}

	public void setMailNotification(byte mailNotification) {
		this.mailNotification = mailNotification;
	}

	public MemberRole getMemberRole() {
		return this.memberRole;
	}

	public void setMemberRole(MemberRole memberRole) {
		this.memberRole = memberRole;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}