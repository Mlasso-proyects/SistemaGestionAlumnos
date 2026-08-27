package umariana.sistemaalumnos;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Mflass
 */
public class GestionarAlumnos {

    Scanner lector ;
    ArrayList<Alumnos> misAlumnos = new ArrayList<>();
    Archivo reporte = new Archivo();

    public GestionarAlumnos(Scanner lector) throws FileNotFoundException {
        this.lector = lector;
        reporte.LeerArchivo(misAlumnos);
        System.out.println("Se cargaron " + misAlumnos.size() + " alumnos desde el archivo.");
    }

    public void agregarAlumno() throws FileNotFoundException {
        System.out.println("====== Agregar Alumno ======\n");
        int cedula, semestre, edad;
        System.out.println("digite el nombre del alumno:");
        String nombre = lector.nextLine();
        System.out.println("digite el apellido del alumno:");
        String apellido = lector.nextLine();

        try {
            System.out.println("digite la cedula del alumno:");
            cedula = Integer.parseInt(lector.nextLine());
            System.out.println("digite la edad del alumno:");
            edad = Integer.parseInt(lector.nextLine());
            System.out.println("digite el semestre del alumno:");
            semestre = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero valido.");
            return;
        }
        System.out.println("============================");
        misAlumnos.add(new Alumnos(cedula, nombre, apellido, edad, semestre));
        reporte.EscribirTodos(misAlumnos);

    }

    public void listarAlumnos() {
        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Listado de alumnos ======\n");
        for (Alumnos miAlumno : misAlumnos) {
            System.out.printf("Alumno: %s %s. \n", miAlumno.getNombre(), miAlumno.getApellido());
            System.out.printf("1.Cedula: %d \n2.Edad: %d años.\n3.Semestre: %d \n", miAlumno.getCedula(), miAlumno.getEdad(), miAlumno.getSemestre());
            System.out.println("============================");
        }
    }

    public void ModificarAlumno() throws FileNotFoundException {
        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Alumnos a modificar ======");
        System.out.println("digitar cedula del estudiante: ");
        int cedula;

        try {
            cedula = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: ingresar un numero valido");
            return;
        }

        for (Alumnos miAlumno : misAlumnos) {
            if (miAlumno.getCedula() == cedula) {

                System.out.println("digite el nombre del alumno:");
                miAlumno.setNombre(lector.nextLine());
                System.out.println("digite el apellido del alumno:");
                miAlumno.setApellido(lector.nextLine());

                try {
                    System.out.println("digite la edad del alumno:");
                    miAlumno.setEdad(Integer.parseInt(lector.nextLine()));
                    System.out.println("digite el semestre del alumno:");
                    miAlumno.setSemestre(Integer.parseInt(lector.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un numero valido.");
                    return;
                }
            }

        }
        reporte.EscribirTodos(misAlumnos);
    }

    public void EliminarAlumno() throws FileNotFoundException {
        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Listado de alumnos ======");
        System.out.println("digitar cedula del estudiante: ");
        int cedula = Integer.parseInt(lector.nextLine());

        for (Alumnos miAlumno : misAlumnos) {
            if (miAlumno.getCedula() == cedula) {
                System.out.printf("==== Estudiante: %s ====", miAlumno.getNombre());
                System.out.printf("1.Cedula: %d \n2.Edad: %d años.\n3.Semestre: %d \n", miAlumno.getCedula(), miAlumno.getEdad(), miAlumno.getSemestre());
                System.out.println("============================");
                System.out.println("confirmacion de eliminacion: ");
                String opc = lector.nextLine();
                if (opc.toLowerCase().equals("si")) {
                    misAlumnos.remove(miAlumno);
                    System.out.println("====== Alumno eliminado. ======");
                    return;
                } else {
                    return;
                }
            }
        }
        reporte.EscribirTodos(misAlumnos);
    }

    public void generarReporte() {
        System.out.println("\n====== Reporte de Alumnos Registrados ======");
        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.printf("%-12s %-15s %-15s %-6s %-9s%n",
                    "Cedula", "Nombre", "Apellido", "Edad", "Semestre");
            System.out.println("-----------------------------------------------------------");
            for (Alumnos miAlumno : misAlumnos) {
                System.out.printf("%-12d %-15s %-15s %-6d %-9d%n",
                        miAlumno.getCedula(), miAlumno.getNombre(), miAlumno.getApellido(),
                        miAlumno.getEdad(), miAlumno.getSemestre());
            }
            System.out.println("-----------------------------------------------------------");
            System.out.println("Total de alumnos registrados: " + misAlumnos.size());
        }
        System.out.println("=============================================\n");
    }
}
