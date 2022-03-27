package nl.utwente.SMApplication.controller;

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
import nl.utwente.SMApplication.model.SalesOrder;
import nl.utwente.SMApplication.repository.SalesOrderRepository;
import nl.utwente.SMApplication.service.SalesOrderService;

@RestController
@Tag(name = "Sales Order", description = "This is the Sales Order REST API")
public class SalesOrderController {

    @Autowired SalesOrderService salesOrderService;
    @Autowired SalesOrderRepository salesOrderRepository;

    @GetMapping("/salesOrder/{id}")
    public SalesOrder getSalesOrder(@PathVariable int id){
        
        SalesOrder salesOrder = salesOrderRepository.getSalesOrder(id);
        
        return salesOrder;
    }

    @GetMapping("/salesOrder")
    public List<SalesOrder> getAllSalesOrders(){

        List<SalesOrder> salesOrderList = salesOrderRepository.getSalesOrderAll();
        
        return salesOrderList;
    }

    @PostMapping("/salesOrder")
    public SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder){
        
        // save sales order to database
        salesOrderRepository.createSalesOrder(salesOrder);

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

        SalesOrder salesOrder = salesOrderRepository.updateSalesOrderConfirmedDate(id, confirmedDeliveryDate);

        salesOrderService.updateSalesOrder(salesOrder);

        return salesOrder;
    }

    @DeleteMapping("/salesOrder/{id}")
    public int deleteSalesOrder(@PathVariable int id){

        return id;
    }
}