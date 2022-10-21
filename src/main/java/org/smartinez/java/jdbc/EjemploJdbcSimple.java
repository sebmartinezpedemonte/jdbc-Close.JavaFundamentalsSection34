package org.smartinez.java.jdbc;

import java.sql.*;

public class EjemploJdbcSimple {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/java_curso";
        String username = "root";
        String password = "sasa";

        ResultSet resultado = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM productos");

            while (resultado.next()) {
                System.out.print(resultado.getInt("id"));
                System.out.print("  |  ");
                System.out.print(resultado.getString("nombre"));
                System.out.print("  |  ");
                System.out.print(resultado.getInt("precio"));
                System.out.print("  |  ");
                System.out.println(resultado.getDate("fecha_registro"));
            };
            resultado.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //aca faltaria cerrar los recursos cuando falla
        }
    }
}
