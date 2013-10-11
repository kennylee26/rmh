package cn.com.timekey.rmh.repository.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the custom_fields database table.
 * 
 */
@Entity
@Table(name="custom_fields")
@NamedQuery(name="CustomField.findAll", query="SELECT c FROM CustomField c")
public class CustomField implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	@Column(name="default_value")
	private String defaultValue;

	private byte editable;

	@Column(name="field_format")
	private String fieldFormat;

	@Column(name="is_filter")
	private byte isFilter;

	@Column(name="is_for_all")
	private byte isForAll;

	@Column(name="is_required")
	private byte isRequired;

	@Column(name="max_length")
	private int maxLength;

	@Column(name="min_length")
	private int minLength;

	private byte multiple;

	private String name;

	private int position;

	@Lob
	@Column(name="possible_values")
	private String possibleValues;

	private String regexp;

	private byte searchable;

	private String type;

	private byte visible;

	public CustomField() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public byte getEditable() {
		return this.editable;
	}

	public void setEditable(byte editable) {
		this.editable = editable;
	}

	public String getFieldFormat() {
		return this.fieldFormat;
	}

	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}

	public byte getIsFilter() {
		return this.isFilter;
	}

	public void setIsFilter(byte isFilter) {
		this.isFilter = isFilter;
	}

	public byte getIsForAll() {
		return this.isForAll;
	}

	public void setIsForAll(byte isForAll) {
		this.isForAll = isForAll;
	}

	public byte getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(byte isRequired) {
		this.isRequired = isRequired;
	}

	public int getMaxLength() {
		return this.maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinLength() {
		return this.minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public byte getMultiple() {
		return this.multiple;
	}

	public void setMultiple(byte multiple) {
		this.multiple = multiple;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPossibleValues() {
		return this.possibleValues;
	}

	public void setPossibleValues(String possibleValues) {
		this.possibleValues = possibleValues;
	}

	public String getRegexp() {
		return this.regexp;
	}

	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}

	public byte getSearchable() {
		return this.searchable;
	}

	public void setSearchable(byte searchable) {
		this.searchable = searchable;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte getVisible() {
		return this.visible;
	}

	public void setVisible(byte visible) {
		this.visible = visible;
	}

}