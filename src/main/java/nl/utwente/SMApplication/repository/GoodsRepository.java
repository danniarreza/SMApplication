package nl.utwente.SMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.SMApplication.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    
}
