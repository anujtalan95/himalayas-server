package in.himalayas.himalayasserver.service.product;

import java.util.List;

import in.himalayas.himalayasserver.entity.MasterData;
import in.himalayas.himalayasserver.entity.Product;
import in.himalayas.himalayasserver.entity.SearchTag;

public interface IProductService {

	public MasterData findTagByCode(Class className, String code);
	void save(Product product);
	public List<Product> findAll();
	public Product getOne(Long id);
	public void deleteById(Long id);
	public void updateProduct(Product product,Long id);
}
