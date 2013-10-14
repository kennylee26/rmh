package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;

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
	private int isClosed;

	@Column(name = "is_default")
	private byte isDefault;

	private String name;

	private Integer position;

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

	/**
	 * isClosed
	 * 
	 * @return the isClosed
	 */
	public int getIsClosed() {
		return isClosed;
	}

	/**
	 * @param isClosed
	 *            the isClosed to set
	 */
	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
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