package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @Column(name = "nombre",length = 50, nullable = false)
    private String nombre;

    @Column(name = "categoria",length = 50, nullable = false)
    private String categoria;

    @Column(name = "precio",length = 50, nullable = false)
    private String precio;

    @Column(name = "cantidad",length = 50, nullable = false)
    private String cantidad;

    public Producto() {
    }

    public Producto(Integer idproducto, String nombre, String categoria, String precio, String cantidad) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
