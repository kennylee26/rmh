package cn.com.timekey.rmh.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the custom_values database table.
 * 
 */
@Entity
@Table(name="custom_values")
@NamedQuery(name="CustomValue.findAll", query="SELECT c FROM CustomValue c")
public class CustomValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="custom_field_id")
	private Integer customFieldId;

	@Column(name="customized_id")
	private Integer customizedId;

	@Column(name="customized_type")
	private String customizedType;

	@Lob
	private String value;

	public CustomValue() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomFieldId() {
		return this.customFieldId;
	}

	public void setCustomFieldId(Integer customFieldId) {
		this.customFieldId = customFieldId;
	}

	public Integer getCustomizedId() {
		return this.customizedId;
	}

	public void setCustomizedId(Integer customizedId) {
		this.customizedId = customizedId;
	}

	public String getCustomizedType() {
		return this.customizedType;
	}

	public void setCustomizedType(String customizedType) {
		this.customizedType = customizedType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}