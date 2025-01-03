package tata.products.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tata.products.model.Product;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);
}


