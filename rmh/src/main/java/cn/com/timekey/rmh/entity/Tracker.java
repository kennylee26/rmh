package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the trackers database table.
 * 
 */
@Entity
@Table(name = "trackers")
@NamedQuery(name = "Tracker.findAll", query = "SELECT t FROM Tracker t")
public class Tracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "fields_bits")
	private Integer fieldsBits;

	@Column(name = "is_in_chlog")
	private byte isInChlog;

	@Column(name = "is_in_roadmap")
	private byte isInRoadmap;

	private String name;

	private Integer position;

	public Tracker() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFieldsBits() {
		return this.fieldsBits;
	}

	public void setFieldsBits(Integer fieldsBits) {
		this.fieldsBits = fieldsBits;
	}

	public byte getIsInChlog() {
		return this.isInChlog;
	}

	public void setIsInChlog(byte isInChlog) {
		this.isInChlog = isInChlog;
	}

	public byte getIsInRoadmap() {
		return this.isInRoadmap;
	}

	public void setIsInRoadmap(byte isInRoadmap) {
		this.isInRoadmap = isInRoadmap;
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

}