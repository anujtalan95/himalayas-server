package in.himalayas.himalayasserver.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	private String imageCredit;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH})
	@JoinTable(name = "product_tag_mapping", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<SearchTag> searchTags;

	private String imageEmbeddedURL;

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

	public Set<SearchTag> getSearchTags() {
		return searchTags;
	}

	public void setSearchTags(Set<SearchTag> searchTags) {
		this.searchTags = searchTags;
	}

	public String getImageCredit() {
		return imageCredit;
	}

	public void setImageCredit(String imageCredit) {
		this.imageCredit = imageCredit;
	}

	public String getImageEmbeddedURL() {
		return imageEmbeddedURL;
	}

	public void setImageEmbeddedURL(String imageEmbeddedURL) {
		this.imageEmbeddedURL = imageEmbeddedURL;
	}
	
}
