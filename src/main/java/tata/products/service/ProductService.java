package tata.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tata.products.model.Product;
import tata.products.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public String addProduct(Product product) {
        productRepository.save(product);
        return "added successfully";
    }

    public List<Product> findByName(String productName) {
        return productRepository.findByName(productName);
    }

    public String deleteProduct(int  productId) {
        try {
            Product product = productRepository.findById(productId).get();
            productRepository.delete(product);
            return "deleted successfully";
        } catch (Exception e) {
            return "No Record Found";
        }
    }

    public Product findById(int productId) {
        try {
            Product product = productRepository.findById(productId).get();

            return product;
        } catch (Exception e) {
            return null;
        }

    }

    public String updateProduct( Product newProduct){
        try {
            Product oldProduct = productRepository.findById(newProduct.getId()).get();

            oldProduct.setName(newProduct.getName());
            oldProduct.setDescription(newProduct.getDescription());
            oldProduct.setPrice(newProduct.getPrice());

            productRepository.save(oldProduct);

            return "updated successfully";
        }
        catch(Exception e){
            return "No Record Found";
        }

        }
}