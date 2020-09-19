package com.example.demo.repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Encomenda_Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaEstadoRepository extends JpaRepository<Encomenda_Estado, Long> {

    // Cliente findById(long id);

}
