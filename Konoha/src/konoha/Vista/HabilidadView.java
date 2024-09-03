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

public class HabilidadView {
    private Conexion conexion = new Conexion();

public void obtenertodaslashabilidades() {
        String sql = "select n.id, n.nombre,h.nombre as nombre_habilidad, h.descripcion from Ninja n join Habilidad h on h.id_ninja = n.id;";
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("---------------------------");
                System.out.println("ID del ninja: " + rs.getInt("n.id"));
                System.out.println("Nombre del ninja: " + rs.getString("n.nombre"));
                System.out.println("Nombre de la habilidad: " + rs.getString("h.nombre"));
                System.out.println("Descripcion: " + rs.getString("h.descripcion"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los ninjas: " + e.getMessage());
        }
    }
}
