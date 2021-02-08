/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantes;

import java.util.Scanner;
import java.util.HashMap;

public class Estudiantes {

    // Static Scanner instance for the entire class
    static Scanner scanner = new Scanner(System.in);
    // Static HasMap to have access to students in the entire class
    static HashMap<String, String> students = new HashMap<String, String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean exitProgram = true;

        do {
            // Get selected option
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
                    // Exit program 
                    exitProgram = true;
                    break;
            }

            // If option is different from 5 show runAgain messages
            if (optionMenu != 5) {
                // Negate returned value to exit do while
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

        // Add record to students HashMap
        students.put(studentId, studentName);

        System.out.println("\nAlumno ingresado exitosamente");
    }

    /**
     * Prints found student or error message
     */
    public static void getStudent() {
        System.out.println("\nIngresa el carnet del alumno a buscar");
        String studentId = scanner.nextLine();

        // Try to get student name, if doesn't exists show default message
        System.out.println("\n" + students.getOrDefault(studentId, "Alumno no encontrado, no se puede mostrar"));
    }

    /**
     * Deletes found student or error message
     */
    public static void deleteStudent() {
        System.out.println("\nIngresa el carnet del alumno a eliminar");
        String studentId = scanner.nextLine();

        /**
         * remove returns deleted key, if deleted key is different from null
         * show success message, else show failure message
         */
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
        
        /**
         * Iterate students with forEach Lambda Expression
         * 
         * forEach receives key, value -> action
         */
        students.forEach((studentId, studentName) -> System.out.println(studentId + " - " + studentName));
    }

    /**
     * @return the selected option in the menu
     */
    public static int printMenu() {
        boolean isOptionValid = false;

        // default return option is exit program
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

            // if option has one of these values, option is valid
            isOptionValid = option == 1 || option == 2 || option == 3 || option == 4 || option == 5;

            if (isOptionValid) {
                // if option is valid set return option to option
                returnOption = option;
            } else {
                // else show invalid message and try again
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

            // if option is one of these values, option is valid
            isOptionValid = option == 1 || option == 2;

            if (isOptionValid) {
                // if option is 1 set runAgain = true, else runAgain = false
                runAgain = option == 1;
            } else {
                // else show invalid message and try again
                System.out.println("Opcion invalida intentalo de nuevo");
            }

        } while (!isOptionValid);

        return runAgain;
    }
}
