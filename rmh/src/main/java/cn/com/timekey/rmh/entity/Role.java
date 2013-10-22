package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private byte assignable;

	private Integer builtin;

	@Column(name = "issues_visibility")
	private String issuesVisibility;

	private String name;

	@Lob
	private String permissions;

	private Integer position;

	// bi-directional many-to-one association to MemberRole
	@OneToMany(mappedBy = "role")
	private List<MemberRole> memberRoles;

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte getAssignable() {
		return this.assignable;
	}

	public void setAssignable(byte assignable) {
		this.assignable = assignable;
	}

	public Integer getBuiltin() {
		return this.builtin;
	}

	public void setBuiltin(Integer builtin) {
		this.builtin = builtin;
	}

	public String getIssuesVisibility() {
		return this.issuesVisibility;
	}

	public void setIssuesVisibility(String issuesVisibility) {
		this.issuesVisibility = issuesVisibility;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissions() {
		return this.permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public List<MemberRole> getMemberRoles() {
		return this.memberRoles;
	}

	public void setMemberRoles(List<MemberRole> memberRoles) {
		this.memberRoles = memberRoles;
	}

	public MemberRole addMemberRole(MemberRole memberRole) {
		getMemberRoles().add(memberRole);
		memberRole.setRole(this);

		return memberRole;
	}

	public MemberRole removeMemberRole(MemberRole memberRole) {
		getMemberRoles().remove(memberRole);
		memberRole.setRole(null);

		return memberRole;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", assignable=" + assignable + ", builtin="
				+ builtin + ", issuesVisibility=" + issuesVisibility
				+ ", name=" + name + ", permissions=" + permissions
				+ ", position=" + position + "]";
	}

}