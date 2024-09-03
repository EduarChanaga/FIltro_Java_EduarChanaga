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

public class NinjaMenu {
    int option = 0;
    Scanner scanner = new Scanner(System.in);
    NinjaDAO ninja = new NinjaDAO();
    HabilidadDAO habilidad = new HabilidadDAO();
    HabilidadView habilidadview = new HabilidadView();
    NinjaView ninjaview = new NinjaView();
        public void MenuNinja() {
        do {
        System.out.println("+-----------------------------------+");
        System.out.println("|       Gestion de los ninjas       |");
        System.out.println("|                                   |");
        System.out.println("|   1. Registrar Ninja              |");
        System.out.println("|   2. Registrar habilidad de ninja |");
        System.out.println("|   3. Ver ninjas                   |");
        System.out.println("|   4. Ver habilidades              |");        
        System.out.println("|   5. Volver                       |");
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
        System.out.print("--> ");
        option = leerOpcion();
        
       switch(option) {
                case 1 -> ninja.InsertarNinja();
                case 2 -> habilidad.InsertarHabilidad();
                case 3 -> ninjaview.obtenertodoslosninjas();
                case 4 -> habilidadview.obtenertodaslashabilidades();
                case 5 -> System.out.println("Saliendo del menu de ninjas...");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }            
        } while(option != 5);
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
