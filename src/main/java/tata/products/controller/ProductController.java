package tata.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tata.products.model.Product;
import tata.products.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

@Autowired
private ProductService productService;
    @GetMapping("/showall")
    public List<Product> showall(){
        return productService.getAllProducts();
    }

    @PutMapping("/addproduct")
    public void addProduct(@RequestBody Product product){

    }
}
