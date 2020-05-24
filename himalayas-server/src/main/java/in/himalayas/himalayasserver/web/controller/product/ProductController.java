package in.himalayas.himalayasserver.web.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.himalayas.himalayasserver.entity.Product;
import in.himalayas.himalayasserver.service.product.IProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping
	public List<Product> list() {
		return productService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Product product) {
		productService.save(product);
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable("id") Long id) {
		return productService.getOne(id);
	}
	
	@DeleteMapping("/{id}/delete")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}
	
	@PutMapping("/{id}/update")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Product product, @PathVariable("id") Long id) {
		productService.updateProduct(product, id);
	}
}
