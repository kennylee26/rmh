/**
 *  <b>日期：</b>Oct 17, 2013-4:35:58 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.vo;

/**
 * <b>类名称：</b>User<br/>
 * <b>类描述：</b>User的VO类<br/>
 * <b>创建时间：</b>Oct 17, 2013 4:35:58 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class User {
	private Integer id;
	private String name;

	/**
	 * 创建一个新的实例 User.
	 */
	public User() {
		super();
	}

	/**
	 * 创建一个新的实例 User.
	 * 
	 * @param id
	 * @param name
	 */
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static User newInstance(Integer id, String name) {
		return new User(id, name);
	}

	/**
	 * id
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
