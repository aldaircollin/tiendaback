package com.example.demo.service;

import com.example.demo.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listar();
    Producto registrar(Producto producto);
    Producto actualizar(Producto producto);
    void eliminar(Integer codigo);
    Producto ListarPorId(Integer codigo);

    List<Producto> listarEstudiantePorApeNombre(String apenombre);
}
