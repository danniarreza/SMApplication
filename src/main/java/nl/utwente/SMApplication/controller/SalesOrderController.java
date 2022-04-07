package nl.utwente.SMApplication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.SMApplication.model.Client;
import nl.utwente.SMApplication.model.Goods;
import nl.utwente.SMApplication.model.Product;
import nl.utwente.SMApplication.model.SalesOrder;
import nl.utwente.SMApplication.repository.ClientRepository;
import nl.utwente.SMApplication.repository.GoodsRepository;
import nl.utwente.SMApplication.repository.ProductRepository;
import nl.utwente.SMApplication.repository.SalesOrderRepository;
import nl.utwente.SMApplication.service.SalesOrderService;

@RestController
@Tag(name = "Sales Order", description = "This is the Sales Order REST API")
public class SalesOrderController {

    @Autowired SalesOrderService salesOrderService;
    @Autowired SalesOrderRepository salesOrderRepository;
    @Autowired ClientRepository clientRepository;
    @Autowired ProductRepository productRepository;
    @Autowired GoodsRepository goodsRepository;

    @GetMapping("/salesOrder/{id}")
    public SalesOrder getSalesOrder(@PathVariable int id){
        
        SalesOrder salesOrder = salesOrderRepository.findById(id).orElse(null);
        
        return salesOrder;
    }

    @GetMapping("/salesOrder")
    public List<SalesOrder> getAllSalesOrders(){

        List<SalesOrder> salesOrderList = salesOrderRepository.findAll();
        
        return salesOrderList;
    }

    @PostMapping("/salesOrder")
    public SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder){
        
        // check if the client's branch requesting the sales order exists in the database
        Client client = salesOrder.getClient();
        Client existingClient = clientRepository.findById(client.getBranchId()).orElse(null);

        if (existingClient == null) {
            client = clientRepository.save(client);
        }

        // check if the sales order's products exist in the database
        List<Goods> goodsList = salesOrder.getGoodsList();
        List<Goods> updatedGoodsList = new ArrayList<>();


        for (Goods goods : goodsList) {
            Product goodsProduct = goods.getProduct();
            Product product = productRepository.findById(goodsProduct.getProductId()).orElse(null);

            // if the product does not exist yet, create a product
            if (product == null) {
                product = goodsProduct;
                productRepository.save(product);
            }

            goods.setProduct(product);
            goods = goodsRepository.save(goods);
            updatedGoodsList.add(goods);
        }

        salesOrder.setGoodsList(updatedGoodsList);

        // save sales order to database
        salesOrderRepository.save(salesOrder);

        // send sales order to LMA
        salesOrderService.createSalesOrder(salesOrder);

        return salesOrder;
    }

    @PutMapping("/salesOrder")
    public SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder){

        return salesOrder;
    }

    @PatchMapping("/salesOrder/{id}")
    public SalesOrder patchSalesOrder(@PathVariable int id, @RequestBody Map<String, Date> confirmedDeliveryDate){

        SalesOrder salesOrder = salesOrderRepository.findById(id).orElse(null);

        salesOrder.setConfirmedDeliveryDate(confirmedDeliveryDate.get("confirmedDeliveryDate"));

        salesOrderService.updateSalesOrder(salesOrder);

        return salesOrder;
    }

    @DeleteMapping("/salesOrder/{id}")
    public int deleteSalesOrder(@PathVariable int id){

        return id;
    }
}