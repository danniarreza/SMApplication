package nl.utwente.SMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.SMApplication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    // private static final List<Product> productList = new ArrayList<>();
    // private static int idCounter = 1;

    // public Product createProduct(Product product){
    //     product.setProductId(idCounter++);
    //     productList.add(product);
    //     return product;
    // }

    // public Product updateProduct(Product product){
    //     productList.add(product);
    //     return product;
    // }

    // public Product getProduct(int id){

    //     return productList.get(id);
    // }

    // public int deleteProduct(int id){
    //     productList.remove(id);
    //     return id;
    // }

    // public List<Product> getProductsAll(){
    //     return productList;
    // }
    
}
