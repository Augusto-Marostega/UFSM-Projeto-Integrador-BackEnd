package com.example.demo.repository;

import com.example.demo.model.Doce;
import com.example.demo.model.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {

    List<Encomenda> findAllByOrderByDataDesc();
}
