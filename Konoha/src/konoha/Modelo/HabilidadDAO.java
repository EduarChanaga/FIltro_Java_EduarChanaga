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

public class HabilidadDAO {
private Conexion conexion = new Conexion();
NinjaView ninja = new NinjaView();

    public void InsertarHabilidad() {
        Scanner scanner = new Scanner(System.in);
        ninja.obtenertodoslosninjas();
        
        System.out.println("Ingrese el id del ninja que tiene esta habilidad: ");
        int id_ninja = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nombre de la habilidad: ");
        String nombre = scanner.nextLine();
      
        System.out.println("Descripcion de la habilidad: ");
        String descripcion = scanner.nextLine();


        String sql = "INSERT INTO Habilidad (id_ninja, nombre, descripcion) VALUES (?,?,?)";
        try (Connection conn = conexion.establecerConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_ninja);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.executeUpdate();
            System.out.println("Habilidad insertada con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al insertar la Habilidad: " + e.getMessage());
        }
    }
  }

