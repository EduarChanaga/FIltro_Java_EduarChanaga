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
import konoha.Vista.Menus.*;

public class PrincipalMenu {
    int option = 0;
    Scanner scanner = new Scanner(System.in);
    NinjaMenu ninjamenu = new NinjaMenu();
    ReportesMenu reportes = new ReportesMenu();
    MisionMenu misionmenu = new MisionMenu();
    public void MenuPrincipal() {
        do {
        System.out.println("+--------------------------------+");
        System.out.println("| Sistema de gestion de misiones |");
        System.out.println("|                                |");
        System.out.println("|   1. Gestionar Ninjas          |");
        System.out.println("|   2. Gestionar Misiones        |");
        System.out.println("|   3. Reportes                  |");
        System.out.println("|   4. Cerrar sistema            |");
        System.out.println("|                                |");
        System.out.println("+--------------------------------+");
        System.out.print("--> ");
        option = leerOpcion();
        
       switch(option) {
                case 1 -> ninjamenu.MenuNinja();
                case 2 -> misionmenu.MenuMision();
                case 3 -> reportes.MenuReportes();
                case 4 -> System.out.println("Saliendo del sistema...");
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
