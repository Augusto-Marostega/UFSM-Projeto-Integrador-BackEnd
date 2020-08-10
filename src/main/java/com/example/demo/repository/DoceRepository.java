package com.example.demo.repository;

import com.example.demo.model.Doce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DoceRepository extends JpaRepository<Doce, Long> {



    //query insert into doce_ingrediente (doce_id, ingrediente_id) select 1, 2 where not exists (select 1 from doce_ingrediente where doce_id = 1 and ingrediente_id = 2);
}
