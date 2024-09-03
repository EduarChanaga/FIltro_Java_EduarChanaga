package konoha.Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class NinjaDAO {

    private Conexion conexion = new Conexion();

    // Método para insertar un nuevo labor utilizando Scanner
    public void InsertarNinja() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nombre del nuevo ninja: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Descripcion del nuevo ninja: ");
        String descripcion = scanner.nextLine();
        
        System.out.println("- ## Rango del nuevo ninja ##-");
        System.out.println("- genin");
        System.out.println("- chunin");
        System.out.println("- tokubetsu");
        System.out.println("- jonin");        
        String rango = scanner.nextLine();
        
        System.out.println("Aldea del nuevo ninja: ");
        String aldea = scanner.nextLine();
        


        String sql = "INSERT INTO Ninja (nombre, descripcion,rango,aldea) VALUES (?,?,?,?)";
        try (Connection conn = conexion.establecerConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setString(3, rango);
            stmt.setString(4, aldea);
            stmt.executeUpdate();
            System.out.println("Ninja insertado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al insertar Ninja: " + e.getMessage());
        }
    }
  }
