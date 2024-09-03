/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konoha.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class MisionDAO {
private Conexion conexion = new Conexion();

    // Método para insertar un nuevo labor utilizando Scanner
    public void InsertarMision() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nombre de la mision: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Descripcion de la mision: ");
        String descripcion = scanner.nextLine();
        
        System.out.println("- ## Rango requerido ##-");
        System.out.println("- genin");
        System.out.println("- chunin");
        System.out.println("- tokubetsu");
        System.out.println("- jonin");        
        String rango = scanner.nextLine();
        
        System.out.println("Recompenza: ");
        int recompenza = scanner.nextInt();
        scanner.nextLine();
        


        String sql = "INSERT INTO Mision (nombre,descripcion,rango,recompensa) VALUES (?,?,?,?)";
        try (Connection conn = conexion.establecerConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setString(3, rango);
            stmt.setInt(4, recompenza);
            stmt.executeUpdate();
            System.out.println("Mision insertada con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al insertar mision: " + e.getMessage());
        }
    }
  }

