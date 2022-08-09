package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.payload.RestResponse;
import com.example.demo.service.IProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/lista")
    public RestResponse listarProducto(){
        List<Producto> productoList = this.productoService.listar();
        try{
            if (productoList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de productos ubicados",productoList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @PostMapping("/registrar")
    public RestResponse registrarProducto(@RequestBody String jsonProducto) throws JsonProcessingException {

        Producto producto = this.objectMapper.readValue(jsonProducto, Producto.class);
        try {
            this.productoService.registrar(producto);
            return new RestResponse(HttpStatus.OK.value(),"Registró correctamente",producto);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @PutMapping("/actualizar")
    public RestResponse actualizarProducto(@RequestBody String jsonProducto) throws JsonProcessingException {

        Producto producto = this.objectMapper.readValue(jsonProducto, Producto.class);
        try {
            this.productoService.registrar(producto);
            return new RestResponse(HttpStatus.OK.value(),"Datos del estudiante se actualizó correctamente",producto);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public RestResponse eliminarProducto(@PathVariable Integer id ){
        try {
            this.productoService.eliminar(id);
            return new RestResponse(HttpStatus.OK.value(),"Producto eliminado correctamente",id);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }


    @GetMapping("/buscar/{appnombre}")
    public RestResponse buscarProducto(@PathVariable String appnombre){
        List<Producto> productoList = this.productoService.listarEstudiantePorApeNombre(appnombre);
        try{
            if (productoList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de productos ubicados",productoList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
}
