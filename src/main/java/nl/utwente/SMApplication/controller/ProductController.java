package nl.utwente.SMApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.SMApplication.model.Product;

@RestController
@Tag(name="Product", description = "This is the Product REST API")
public class ProductController {

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        Product product = new Product(id, "Chicken", 10);

        return product;
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        List<Product> productList = new ArrayList<Product>();

        for (int i = 0; i < 3; i++) {
            Product product = new Product(i+1, "Chicken", 10);
            productList.add(product);
        }
        
        return productList;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        
        return product;
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){

        return product;
    }

    @DeleteMapping("/product")
    public int deleteProduct(@PathVariable int id){

        return id;
    }
    
}
