package in.himalayas.himalayasserver.entity;

import javax.persistence.Entity;

@Entity
public class DynamicField extends BaseEntity {

	private String dataType;
	private String code;
	private String name;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
