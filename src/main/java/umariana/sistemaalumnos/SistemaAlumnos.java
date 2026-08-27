package umariana.sistemaalumnos;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Mflass
 */
public class SistemaAlumnos {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner lector = new Scanner(System.in);
        GestionarAlumnos gestionar = new GestionarAlumnos();
        int opcion = 0;
        do {
            System.out.println("""
                               ====== Menu de opciones ======
                               1.\tAgregar un alumno
                               2.\tListar todos los alumnos
                               3.\tModificar alumnos 
                               4.\tEliminar un alumno 
                               5.\tGenerar un reporte de alumnos registrados (Reporte en pantalla de impresion)
                               6.\tSalir del programa
                               ============================""");
            opcion = Integer.parseInt(lector.nextLine());

            switch (opcion) {
                case 1 ->
                    gestionar.agregarAlumno();
                case 2 ->
                    gestionar.listarAlumnos();
                case 3 ->
                    gestionar.ModificarAlumno();
                case 4 ->
                    gestionar.EliminarAlumno();
                case 5 ->
                    System.out.println("5");
                case 6 -> 
                    System.out.println("Saliendo del programa...");
            }

        } while (opcion != 6);

    }

}
