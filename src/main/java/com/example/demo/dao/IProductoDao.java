package com.example.demo.dao;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoDao extends JpaRepository<Producto,Integer> {
    //Lista estudiante por apellido o nombre
    @Query("SELECT e FROM Producto e WHERE e.nombre LIKE CONCAT('%',:appnombre,'%') OR e.categoria LIKE CONCAT('%',:appnombre,'%') ")
    List<Producto> listarEstudiantesByAppNombre(@Param("appnombre") String appnombre);
}
