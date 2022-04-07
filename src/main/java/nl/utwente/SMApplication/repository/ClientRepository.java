package nl.utwente.SMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.SMApplication.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
