package org.smartinez.java.jdbc;

import org.smartinez.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbcSingleton {
    public static void main(String[] args) {
        //Usamos singleton porque para una aplicacion de consola con una conexion es mas que necesario
        //Pero para una aplicacion web (con varios usuarios conectados, con concurrencia) necesitamos un pool de conexiones pero estos vienen implementados por spring entonces es mas facil
        //poniendolos adentro del parentesis del try no necesitamos llamar al .close() (conn.close(), stmt.close(), resultado.close()
        try (Connection conn = ConexionBaseDatos.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {
            while (resultado.next()) {
                System.out.print(resultado.getInt("id"));
                System.out.print("  |  ");
                System.out.print(resultado.getString("nombre"));
                System.out.print("  |  ");
                System.out.print(resultado.getInt("precio"));
                System.out.print("  |  ");
                System.out.println(resultado.getDate("fecha_registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
