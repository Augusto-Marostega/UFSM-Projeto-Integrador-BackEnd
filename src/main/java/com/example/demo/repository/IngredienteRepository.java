package com.example.demo.repository;


import com.example.demo.model.Ingrediente;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    //select * from ingrediente where ingrediente.id not in (select ingrediente.id from ingrediente, doce_ingrediente, doce
    //		where doce.id = ? and doce.id = doce_ingrediente.doce_id
    //		and doce_ingrediente.ingrediente_id = ingrediente.id order by ingrediente.id);

    //@Query(value = "Select ingrediente.* From ingrediente where ingrediente.id = ?1", nativeQuery = true)
   // @Query(value = "select ingrediente.* from ingrediente where ingrediente.id not in (select ingrediente.id from ingrediente, doce_ingrediente, doce where doce.id = ?1 and doce.id = doce_ingrediente.doce_id and doce_ingrediente.ingredie)", nativeQuery = true)

    //@Query("SELECT i FROM Ingrediente i WHERE i.id NOT IN (SELECT i2.id FROM Ingrediente i2, Doce d JOIN FETCH d.ingredientes di WHERE d.id = ?1 and d.id = di.doce_id and di.ingrediente_id = i2.id order by i2.id)")



}
