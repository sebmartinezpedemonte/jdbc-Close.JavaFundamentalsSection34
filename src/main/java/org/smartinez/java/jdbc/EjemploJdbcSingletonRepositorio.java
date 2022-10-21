package org.smartinez.java.jdbc;

import modelo.Categoria;
import modelo.Producto;
import modelo.repositorio.ProductoRepositorioImp;
import modelo.repositorio.Repositorio;
import org.smartinez.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcSingletonRepositorio {
    public static void main(String[] args) {


            Repositorio<Producto> repositorio = new ProductoRepositorioImp();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= insertar nuevo producto =============");
            Producto producto = new Producto();
            producto.setNombre("Notebook Asus ROG");
            producto.setPrecio(2550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);    //computacion
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto insertado con exito");
            repositorio.listar().forEach(System.out::println);


    }

}
