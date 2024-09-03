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
public class ReportesView {
    private Conexion conexion = new Conexion();
    public void obtenertodaslashabilidades() {
        String sql = "select n.id, n.nombre,h.nombre as nombre_habilidad, h.descripcion from Ninja n join Habilidad h on h.id_ninja = n.id;";
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("---------------------------");
                System.out.println("ID del ninja: " + rs.getInt("n.id"));
                System.out.println("Nombre del ninja: " + rs.getString("n.nombre"));
                System.out.println("Nombre de la habilidad: " + rs.getString("nombre_habilidad"));
                System.out.println("Descripcion: " + rs.getString("h.descripcion"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los ninjas: " + e.getMessage());
        }
    }

    public void obtenermisionesninja(int id_ninja) {
        String sql = "select mn.*, m.* from Mision_Ninja mn join Mision m on mn.id_mision = m.id where mn.id_ninja ="+id_ninja+";";
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("---------------------------");
                System.out.println("ID del ninja: " + rs.getInt("mn.id_ninja"));
                System.out.println("ID de la mision: " + rs.getInt("mn.id_mision"));
                System.out.println("Fecha inicio: " + rs.getString("mn.fecha_inicio"));
                System.out.println("Fecha fin: " + rs.getString("mn.fecha_inicio"));
                System.out.println("ID de la mision: " + rs.getInt("m.id"));
                System.out.println("Nombre de la mision: " + rs.getString("m.nombre"));
                System.out.println("Descripcion de la mision: " + rs.getString("m.descripcion"));
                System.out.println("Rango de la mision: " + rs.getString("m.rango"));
                System.out.println("Rango de la mision: " + rs.getInt("m.recompensa"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los ninjas: " + e.getMessage());
        }
    }
 }