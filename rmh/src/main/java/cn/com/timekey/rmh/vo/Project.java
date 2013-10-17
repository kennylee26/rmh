/**
 *  <b>日期：</b>Oct 17, 2013-4:35:28 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.vo;

/**
 * <b>类名称：</b>Project<br/>
 * <b>类描述：</b>Project的VO<br/>
 * <b>创建时间：</b>Oct 17, 2013 4:35:28 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
public class Project {

	private Integer id;
	private String identifier;
	private String name;

	/**
	 * 创建一个新的实例 Project.
	 */
	public Project() {
		super();
	}

	/**
	 * 创建一个新的实例 Project.
	 * 
	 * @param id
	 * @param identifier
	 * @param name
	 */
	public Project(Integer id, String identifier, String name) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.name = name;
	}

	public static Project newInstance(Integer id, String identifier, String name) {
		return new Project(id, identifier, name);
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
	 * identifier
	 * 
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier
	 *            the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
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
		return "Project [id=" + id + ", identifier=" + identifier + ", name="
				+ name + "]";
	}

}
