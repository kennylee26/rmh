package cn.com.timekey.rmh.repository.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the v_user_isues_hours database table.
 * 
 */
//@Entity
//@Table(name="v_user_isues_hours")
//@NamedQuery(name="VUserIsuesHour.findAll", query="SELECT v FROM VUserIsuesHour v")
public class VUserIsuesHour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="isues_hours")
	private double isuesHours;

	private int month;

	@Column(name="user_name")
	private String userName;

	private int year;

	public VUserIsuesHour() {
	}

	public double getIsuesHours() {
		return this.isuesHours;
	}

	public void setIsuesHours(double isuesHours) {
		this.isuesHours = isuesHours;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}