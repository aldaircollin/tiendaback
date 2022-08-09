package com.example.demo.service.Impl;

import com.example.demo.dao.IProductoDao;
import com.example.demo.entity.Producto;
import com.example.demo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoDao productoDao;

    @Override
    public List<Producto> listar() {
        return productoDao.findAll();
    }

    @Override
    public Producto registrar(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void eliminar(Integer codigo) {
    productoDao.deleteById(codigo);
    }

    @Override
    public Producto ListarPorId(Integer codigo) {
        return productoDao.findById(codigo).orElse(null);
    }

    @Override
    public List<Producto> listarEstudiantePorApeNombre(String apenombre) {
        return this.productoDao.listarEstudiantesByAppNombre(apenombre);
    }
}
