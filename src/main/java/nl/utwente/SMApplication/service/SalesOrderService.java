package nl.utwente.SMApplication.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nl.utwente.SMApplication.model.SalesOrder;

@Service
public class SalesOrderService {
    

    @Autowired RestTemplateBuilder restTemplateBuilder;

    public void createSalesOrder(SalesOrder salesOrder){

        String url = "http://localhost:8082/transportOrder";

        RestTemplate RestTemplate = restTemplateBuilder.build();
        SalesOrder salesOrderResponse = RestTemplate.postForObject(url, salesOrder, SalesOrder.class); 
        System.out.print(salesOrder.toString());
        System.out.print(salesOrderResponse.toString());
    }

    public void updateSalesOrder(SalesOrder salesOrder){

        // define target url
        String url = "http://localhost:8080/salesOrder/" + salesOrder.getOrderId();

        // create a variable to update transport order's delivery date
        Map<String, Date> salesOrderConfirmedDeliveryDate = new HashMap<>();
        salesOrderConfirmedDeliveryDate.put("confirmedDeliveryDate", salesOrder.getConfirmedDeliveryDate());

        // patch sales order's delivery date
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.patchForObject(url, salesOrderConfirmedDeliveryDate, SalesOrder.class);

    }
}
