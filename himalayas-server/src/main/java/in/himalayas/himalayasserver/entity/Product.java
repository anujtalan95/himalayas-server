package in.himalayas.himalayasserver.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5278529993232748262L;
	
	@Column(unique = true)
	private String productCode;
	private String productName;
	private String productDescription;
	private String location;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_tag_mapping", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<MasterData> searchTags;

	@OneToOne(cascade = CascadeType.ALL)
	private DataStore dataStore;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public DataStore getDataStore() {
		return dataStore;
	}

	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	public Set<MasterData> getSearchTags() {
		return searchTags;
	}

	public void setSearchTags(Set<MasterData> searchTags) {
		this.searchTags = searchTags;
	}
	
}
