/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konoha.Vista.Menus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import konoha.Vista.*;
import konoha.Modelo.*;

public class ReportesMenu {
    int option = 0;
    Scanner scanner = new Scanner(System.in);
    ReportesView reportes = new ReportesView();
    NinjaDAO ninja = new NinjaDAO();
    HabilidadDAO habilidad = new HabilidadDAO();
    HabilidadView habilidadview = new HabilidadView();
    NinjaView ninjaview = new NinjaView();
        public void MenuReportes() {
        do {
        System.out.println("+-----------------------------------+");
        System.out.println("|               Reportes            |");
        System.out.println("|                                   |");
        System.out.println("|   1. Ver ninjas y sus habilidades |");
        System.out.println("|   2. Obtener misiones por ninja   |");
        System.out.println("|   3. Volver                       |");
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
        System.out.print("--> ");
        option = leerOpcion();
        
       switch(option) {
                case 1 -> reportes.obtenertodaslashabilidades();
                case 2 -> caso2();
                case 3 -> System.out.println("Saliendo del menu de ninjas...");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }            
        } while(option != 3);
    }
        public void caso2(){
            ninjaview.obtenertodoslosninjas();
            System.out.println("Ingrese el id del ninja");
            int id_ninja = scanner.nextInt();
            scanner.nextLine();
            
            reportes.obtenermisionesninja(id_ninja);
        };
        
        private int leerOpcion() {
        int opcion = 0;
        while (true) {
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                break; // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
        return opcion;
    }
}
