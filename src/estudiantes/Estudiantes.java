/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantes;

import java.util.Scanner;

/**
 *
 * @author elaniin
 */
public class Estudiantes {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean exitProgram = true;

        do {
            int optionMenu = printMenu();

            switch (optionMenu) {
                case 1:
                    System.out.println("Agregado");
                    break;
                case 2:
                    System.out.println("Encontrado");
                    break;
                case 3:
                    System.out.println("Eliminado");
                    break;
                case 4:
                    System.out.println("Mostrar todos");
                    break;
                case 5:
                    exitProgram = true;
                    break;
            }
            
            if (optionMenu != 5) {
                exitProgram = !runAgain();
            }

        } while (!exitProgram);
    }

    public static int printMenu() {
        boolean isOptionValid = false;
        
        int returnOption = 5;

        do {
            System.out.println("**************************************************");
            System.out.println("* Bienvenido a la UDB Virtual                    *");
            System.out.println("*                                                *");
            System.out.println("*                                                *");
            System.out.println("* Selecciona una opcion para continuar:          *");
            System.out.println("* 1. Ingresar alumno                             *");
            System.out.println("* 2. Buscar alumno                               *");
            System.out.println("* 3. Eliminar alumno                             *");
            System.out.println("* 4. Mostrar todos los alumnos                   *");
            System.out.println("* 5. Salir del programa                          *");
            System.out.println("**************************************************");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            isOptionValid = option == 1 || option == 2 || option == 3 || option == 4 || option == 5;

            if (isOptionValid) {
                returnOption = option;
            } else {
                System.out.println("Opcion invalida intentalo de nuevo");
            }

        } while (!isOptionValid);

        return returnOption;
    }

    public static boolean runAgain() {
        boolean isOptionValid = false, runAgain = false;

        do {
            System.out.println("¿Quieres realizar otra accion?");
            System.out.println(" 1. Si, volver al menu");
            System.out.println(" 2. No, salir del programa");

            int option = scanner.nextInt();
            scanner.nextLine();

            isOptionValid = option == 1 || option == 2;

            if (isOptionValid) {
                runAgain = option == 1;
            } else {
                System.out.println("Opcion invalida intentalo de nuevo");
            }

        } while (!isOptionValid);

        return runAgain;
    }
}
