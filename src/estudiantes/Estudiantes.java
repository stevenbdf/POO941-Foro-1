/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantes;

import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author elaniin
 */
public class Estudiantes {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, String> students = new HashMap<String, String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean exitProgram = true;

        do {
            int optionMenu = printMenu();

            switch (optionMenu) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    getStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    getStudents();
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

    /**
     * Adds a new student
     */
    public static void addStudent() {
        System.out.println("\nIngresa el carnet del alumno");
        String studentId = scanner.nextLine();

        System.out.println("\nIngresa el nombre del alumno");
        String studentName = scanner.nextLine();

        students.put(studentId, studentName);

        System.out.println("\nAlumno ingresado exitosamente");
    }

    /**
     * Prints found student or error message
     */
    public static void getStudent() {
        System.out.println("\nIngresa el carnet del alumno a buscar");
        String studentId = scanner.nextLine();

        System.out.println("\n" + students.getOrDefault(studentId, "Alumno no encontrado, no se puede mostrar"));
    }

    /**
     * Deletes found student or error message
     */
    public static void deleteStudent() {
        System.out.println("\nIngresa el carnet del alumno a eliminar");
        String studentId = scanner.nextLine();
        
        if (students.remove(studentId) != null) {
            System.out.println("\nAlumno eliminado exitosamente");
        } else {
            System.out.println("\nAlumno no encontrado, no se puede eliminar");
        }
    }

    /**
     * Prints all students
     */
    public static void getStudents() {
        System.out.println("");
        students.forEach((studentId, studentName) -> System.out.println(studentId + " - " + studentName ));
    }
    
    /**
     * @return the selected option in the menu
     */
    public static int printMenu() {
        boolean isOptionValid = false;

        int returnOption = 5;

        do {
            System.out.println("\n**************************************************");
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

    /**
     * @return run again user decision
     */
    public static boolean runAgain() {
        boolean isOptionValid = false, runAgain = false;

        do {
            System.out.println("\n¿Quieres realizar otra accion?");
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
