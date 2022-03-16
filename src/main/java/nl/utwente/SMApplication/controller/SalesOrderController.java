package nl.utwente.SMApplication.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.SMApplication.model.Product;
import nl.utwente.SMApplication.model.SalesOrder;

@RestController
@Tag(name = "Sales Order", description = "This is the Sales Order REST API")
public class SalesOrderController {

    // @GetMapping("/")
    // public String index() {
    //     return "Hello World!";
    // }

    @GetMapping("/salesOrder/{id}")
    public SalesOrder getSalesOrder(@PathVariable int id){
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Chicken", 10));
        productList.add(new Product(2, "Tomato", 10));
        productList.add(new Product(3, "Bread", 10));

        SalesOrder salesOrder = new SalesOrder(id, "Johny", productList);
        
        return salesOrder;
    }

    @GetMapping("/salesOrder")
    public List<SalesOrder> getAllSalesOrders(){

        List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
        
        for (int i = 0; i < 3; i++) {

            List<Product> productList = new ArrayList<Product>();
            productList.add(new Product(1, "Chicken", 10));
            productList.add(new Product(2, "Tomato", 10));
            productList.add(new Product(3, "Bread", 10));

            SalesOrder salesOrder = new SalesOrder((i+1), "Marry", productList);
            salesOrderList.add(salesOrder);
        }

        return salesOrderList;
    }

    @PostMapping("/salesOrder")
    public SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder){
        
        return salesOrder;
    }

    @PutMapping("/salesOrder")
    public SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder){

        return salesOrder;
    }

    @DeleteMapping("/salesOrder/{id}")
    public int deleteSalesOrder(@PathVariable int id){

        return id;
    }
}