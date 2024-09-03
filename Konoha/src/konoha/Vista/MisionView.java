
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
public class MisionView {
    private Conexion conexion = new Conexion();

public void obtenertodaslasmisiones() {
        String sql = "SELECT * FROM Mision";
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("---------------------------");
                System.out.println("ID de la mision: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Rango: " + rs.getString("rango"));
                System.out.println("recompensa: " + rs.getInt("recompensa"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los ninjas: " + e.getMessage());
        }
    }

    public void obtenermisionesconninjas() {
            String sql = "select mn.id_ninja, n.nombre, mn.id_mision, m.nombre from Mision_Ninja mn join Ninja n on mn.id_ninja = n.id join Mision m on mn.id_mision = m.id;";
            try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("---------------------------");
                    System.out.println("ID del ninja: " + rs.getInt("mn.id_ninja"));
                    System.out.println("Nombre del ninja: " + rs.getString("n.nombre"));
                    System.out.println("ID de la mision: " + rs.getInt("mn.id_mision"));
                    System.out.println("Nombre mision: " + rs.getString("m.nombre"));
                    System.out.println("---------------------------");
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener todos los ninjas: " + e.getMessage());
            }
        }

    public String obtenermisionporid(int id) {

            String sql = "SELECT * FROM Mision WHERE id = ?";
            try (Connection conn = conexion.establecerConexion(); 
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String rango = rs.getString("rango");     
                        return rango;
                        
                    } else {
                        System.out.println("No se encontró la mision con ID: " + id);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener mision por ID: " + e.getMessage());
            }
        return null;
        }
}