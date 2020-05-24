package in.himalayas.himalayasserver.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class DataStore extends BaseEntity {

	private String dataType;
	
	@Lob
	private byte[] dataContent;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public byte[] getDataContent() {
		return dataContent;
	}
	public void setDataContent(byte[] dataContent) {
		this.dataContent = dataContent;
	}
}
