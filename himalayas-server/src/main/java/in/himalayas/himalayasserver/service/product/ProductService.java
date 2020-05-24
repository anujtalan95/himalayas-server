package in.himalayas.himalayasserver.service.product;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.himalayas.himalayasserver.entity.DataStore;
import in.himalayas.himalayasserver.entity.MasterData;
import in.himalayas.himalayasserver.entity.Product;
import in.himalayas.himalayasserver.entity.SearchTag;
import in.himalayas.himalayasserver.repository.ProductRepository;

@Transactional
@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;
	
	public MasterData findTagByCode(Class className, String code) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MasterData> criteriaQuery =  criteriaBuilder.createQuery(className);
		Root<MasterData> root = criteriaQuery.from(className);
		criteriaQuery = criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("code"), code));
		
		TypedQuery<MasterData> typedQuery = entityManager.createQuery(criteriaQuery);
		List<MasterData> tagsList = typedQuery.getResultList();
		for(MasterData searchTag : tagsList) {
			return searchTag;
		}
		return new MasterData();
	}
	
	public void save(Product product) {
		Set<MasterData> searchTags = new HashSet<MasterData>();
		
		for(MasterData master : product.getSearchTags()) {
			MasterData masterData = findTagByCode(MasterData.class, master.getCode());
			searchTags.add(masterData);
		}
		
		product.setSearchTags(searchTags);
		productRepository.save(product);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product getOne(Long id){
		return productRepository.getOne(id);
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	
	public void updateProduct(Product product,Long id) {
		Optional<Product> optional = productRepository.findById(id);
		Product oldProduct = null;
		if (optional.get() != null) {
			oldProduct = optional.get();
			setProductData(product,oldProduct);
		}
		productRepository.save(oldProduct);
	}
	
	public void setProductData(Product newProduct,Product oldProduct) {
		oldProduct.setLocation(newProduct.getLocation());
		oldProduct.setProductCode(newProduct.getProductCode());
		oldProduct.setProductDescription(newProduct.getProductDescription());
		oldProduct.setProductName(newProduct.getProductName());
		oldProduct.setStatus(newProduct.getStatus());
		
		setDataStore(newProduct.getDataStore(),oldProduct.getDataStore());
		oldProduct.setDataStore(oldProduct.getDataStore());
		
		setSearchTags(newProduct.getSearchTags(),oldProduct.getSearchTags());
		oldProduct.setSearchTags(oldProduct.getSearchTags());
		
	}
	
	public void setDataStore(DataStore newDataStore,DataStore oldDataStore) {
		oldDataStore.setDataType(newDataStore.getDataType());
		oldDataStore.setDataContent(newDataStore.getDataContent());
		oldDataStore.setStatus(newDataStore.getStatus());
	}
	
	public void setSearchTags(Set<MasterData> newTags,Set<MasterData> oldTags ) {
		 for(MasterData master :  newTags) {
			 
		 }
	}
}
