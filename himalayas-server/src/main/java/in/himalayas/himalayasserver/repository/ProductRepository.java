package in.himalayas.himalayasserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.himalayas.himalayasserver.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
