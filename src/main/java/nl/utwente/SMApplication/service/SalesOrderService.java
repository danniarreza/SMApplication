package nl.utwente.SMApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nl.utwente.SMApplication.dto.Inventory;
import nl.utwente.SMApplication.model.Goods;
import nl.utwente.SMApplication.model.Product;
import nl.utwente.SMApplication.model.SalesOrder;

@Service
public class SalesOrderService {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public void createSalesOrder(SalesOrder salesOrder) {

        // String url = "http://localhost:8082/transportOrder";
        String url = "http://lma:8082/transportOrder";

        RestTemplate restTemplate = restTemplateBuilder.build();
        SalesOrder salesOrderResponse = restTemplate.postForObject(url, salesOrder, SalesOrder.class);
        // System.out.print(salesOrder.toString());
        // System.out.print(salesOrderResponse.toString());
    }

    public void updateSalesOrder(SalesOrder salesOrder) {

        // define target url
        // String urlConfirmedDeliveryDate = "http://localhost:8080/salesOrder/" + salesOrder.getOrderId() + "/confirmedDeliveryDate";
        // String urlOrderStatus = "http://localhost:8080/salesOrder/" + salesOrder.getOrderId() + "/status";
        String urlConfirmedDeliveryDate = "http://fca:8080/salesOrder/" + salesOrder.getOrderId() + "/confirmedDeliveryDate";
        String urlOrderStatus = "http://fca:8080/salesOrder/" + salesOrder.getOrderId() + "/status";

        // create a variable to update sales order's delivery date
        Map<String, Date> salesOrderConfirmedDeliveryDate = new HashMap<>();
        salesOrderConfirmedDeliveryDate.put("confirmedDeliveryDate", salesOrder.getConfirmedDeliveryDate());

        // create a variable to update sales order's status
        Map<String, String> salesOrderStatus = new HashMap<>();
        salesOrderStatus.put("orderStatus", salesOrder.getOrderStatus());

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        // patch sales order's delivery date
        restTemplate.patchForObject(urlConfirmedDeliveryDate, salesOrderConfirmedDeliveryDate, SalesOrder.class);
        // patch sales order's delivery date
        restTemplate.patchForObject(urlOrderStatus, salesOrderStatus, SalesOrder.class);

    }

    public List<Product> checkInventory(SalesOrder salesOrder) {

        // list of products that their inventory level is below the requested amount
        List<Product> depletedProductList = new ArrayList<>();

        for (Goods goods : salesOrder.getGoodsList()) {
            Product product = goods.getProduct();

            // define target url
            // String url = "http://localhost:8082/product/" + product.getProductId() + "/inventory";
            String url = "http://lma:8082/product/" + product.getProductId() + "/inventory";

            RestTemplate restTemplate = restTemplateBuilder.build();
            Inventory inventory = restTemplate.getForObject(url, Inventory.class);

            if(inventory.getAmount() < goods.getAmount()){
                depletedProductList.add(product);
            }
        }

        return depletedProductList;

    }

    public void notifySalesOrderStatus(SalesOrder salesOrder){

        // define target url
        // String url = "http://localhost:8080/salesOrder/" + salesOrder.getOrderId() + "/status";
        String url = "http://fca:8080/salesOrder/" + salesOrder.getOrderId() + "/status";

        // create a variable to update sales order's rejection status
        Map<String, String> salesOrderStatus = new HashMap<>();
        salesOrderStatus.put("orderStatus", salesOrder.getOrderStatus());

        // patch sales order's rejection status
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.patchForObject(url, salesOrderStatus, SalesOrder.class);
    }
}
