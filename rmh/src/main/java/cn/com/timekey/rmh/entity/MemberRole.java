package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the member_roles database table.
 * 
 */
@Entity
@Table(name="member_roles")
@NamedQuery(name="MemberRole.findAll", query="SELECT m FROM MemberRole m")
public class MemberRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="inherited_from")
	private Integer inheritedFrom;

	//bi-directional one-to-one association to Member
	@OneToOne
	@JoinColumn(name="member_id")
	private Member member;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public MemberRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInheritedFrom() {
		return this.inheritedFrom;
	}

	public void setInheritedFrom(Integer inheritedFrom) {
		this.inheritedFrom = inheritedFrom;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}