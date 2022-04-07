package nl.utwente.SMApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.SMApplication.model.Product;
import nl.utwente.SMApplication.repository.ProductRepository;

@RestController
@Tag(name="Product", description = "This is the Product REST API")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        List<Product> productList = productRepository.findAll();
        
        return productList;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        
        productRepository.save(product);

        return product;
    }

    @PutMapping("/product/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer productId){

        Product existingProduct = productRepository.findById(productId).orElse(null);

        existingProduct.setProductName(existingProduct.getProductName());
        existingProduct.setProductUnit(existingProduct.getProductUnit());

        productRepository.save(existingProduct);

        return product;
    }

    @DeleteMapping("/product/{productId}")
    public int deleteProduct(@PathVariable int productId){

        return productId;
    }
    
}
