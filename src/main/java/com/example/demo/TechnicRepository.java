package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TechnicRepository extends JpaRepository<Technic, Long> {
    @Query("SELECT p FROM Technic p WHERE CONCAT(p.type, ' ', p.squad, ' ', p.data_input, ' ', p.data_output, ' ', p.driver) LIKE %?1%")
    List<Technic> search(String keyword);


}
