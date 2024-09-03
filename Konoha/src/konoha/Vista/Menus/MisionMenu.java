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

public class MisionMenu {
    int option = 0;
    Scanner scanner = new Scanner(System.in);
    MisionDAO mision = new MisionDAO();
    MisionView misionview = new MisionView();
        public void MenuMision() {
        do {
        System.out.println("+---------------------------------------+");
        System.out.println("|      Gestion de las misiones          |");
        System.out.println("|                                       |");
        System.out.println("|   1. Registrar mision                 |");
        System.out.println("|   2. Ver misiones                     |");
        System.out.println("|   3. Ver ninjas asignados a la mision |");
        System.out.println("|   4. Volver                           |");
        System.out.println("|                                       |");
        System.out.println("+---------------------------------------+");
        System.out.print("--> ");
        option = leerOpcion(); 
        
       switch(option) {
                case 1 -> mision.InsertarMision();
                case 2 -> misionview.obtenertodaslasmisiones();
                case 3 -> misionview.obtenermisionesconninjas();
                case 4 -> System.out.println("Saliendo del menu de ninjas...");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }            
        } while(option != 4);
    }
        
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
