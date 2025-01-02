package tata.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping ("/addproduct")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/mytaskservice/{userName}")
    public String getWish(@PathVariable String userName){
        return "Hi "+userName+" welcome to MyService";
    }

    @GetMapping("/search/{id}")
    public Product findById(@PathVariable("id") int id){
        return productService.findById(id);

    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId) {

            return productService.deleteProduct(productId);
    }


    @PutMapping ("/update")

    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
