/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konoha.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import konoha.Modelo.Conexion;

/**
 *
 * @author camper
 */
public class NinjaView {
    private Conexion conexion = new Conexion();

public void obtenertodoslosninjas() {
        String sql = "SELECT * FROM Ninja";
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("---------------------------");
                System.out.println("ID del ninja: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Rango: " + rs.getString("rango"));
                System.out.println("Aldea: " + rs.getString("aldea"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los ninjas: " + e.getMessage());
        }
    }
}