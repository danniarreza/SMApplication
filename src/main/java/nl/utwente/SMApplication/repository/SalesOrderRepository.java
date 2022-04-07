package nl.utwente.SMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.SMApplication.model.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> {
    
}
