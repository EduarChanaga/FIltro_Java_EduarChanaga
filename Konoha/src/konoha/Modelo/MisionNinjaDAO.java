/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konoha.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import konoha.Vista.*;


public class MisionNinjaDAO {

    private Conexion conexion = new Conexion();
    MisionView mision = new MisionView();
    NinjaView ninja = new NinjaView();

    // Método para insertar un nuevo labor utilizando Scanner
    public void InsertarMisionNinja() {
        Scanner scanner = new Scanner(System.in);
        
        mision.obtenertodaslasmisiones();
        System.out.println("ID mision: ");
        int id_mision = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Rango requerido: " + mision.obtenermisionporid(id_mision) );
        
        ninja.obtenertodoslosninjas();
        System.out.println("ID ninja (Ten en cuenta el rango de dificultad): ");
        int id_ninja = scanner.nextInt();
        scanner.nextLine();
        
        
        System.out.println("Fecha inicio (yyyy-MM-DD): ");
        String fecha_inicio = scanner.nextLine();
        
        System.out.println("Fecha fin (yyyy-MM-DD): ");
        String fecha_fin = scanner.nextLine();
        
        


        String sql = "INSERT INTO Mision_Ninja (id_ninja, id_mision, fecha_inicio, fecha_fin) VALUES (?,?,?,?)";
        try (Connection conn = conexion.establecerConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_mision);
            stmt.setInt(2, id_ninja);
            stmt.setString(3, fecha_inicio);
            stmt.setString(4, fecha_fin);
            stmt.executeUpdate();
            System.out.println("Mision asignada con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al asignar la mision: " + e.getMessage());
        }
    }
  }