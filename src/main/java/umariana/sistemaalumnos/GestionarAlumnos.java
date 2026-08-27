package umariana.sistemaalumnos;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Mflass
 */
public class GestionarAlumnos {

    Scanner lector = new Scanner(System.in);
    ArrayList<Alumnos> alumnos = new ArrayList<>();
    Archivo reporte = new Archivo();

    public GestionarAlumnos() {
        reporte.LeerArchivo(alumnos);
        System.out.println("Se cargaron " + alumnos.size() + " alumnos desde el archivo.");
    }

    public void agregarAlumno() {
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
        alumnos.add(new Alumnos(cedula, nombre, apellido, edad, semestre));
        reporte.EscribirTodos(alumnos);

    }

    public void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Listado de alumnos ======\n");
        for (Alumnos alumno : alumnos) {
            System.out.printf("Alumno: %s %s. \n", alumno.getNombre(), alumno.getApellido());
            System.out.printf("1.Cedula: %d \n2.Edad: %d años.\n3.Semestre: %d \n", alumno.getCedula(), alumno.getEdad(), alumno.getSemestre());
            System.out.println("============================");
        }
    }

    public void ModificarAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Listado de alumnos ======");
        System.out.println("digitar cedula del estudiante: ");
        int cedula = Integer.parseInt(lector.nextLine());

        for (Alumnos alumno : alumnos) {
            if (alumno.getCedula() == cedula) {

                System.out.println("digite la nombre del nombre:");
                alumno.setNombre(lector.nextLine());
                System.out.println("digite la apellido del apellido:");
                alumno.setApellido(lector.nextLine());

                try {
                    System.out.println("digite la edad del edad:");
                    alumno.setEdad(Integer.parseInt(lector.nextLine()));
                    System.out.println("digite la semestre del semestre:");
                    alumno.setSemestre(Integer.parseInt(lector.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un numero valido.");
                    return;
                }
            }

        }
        reporte.EscribirTodos(alumnos);
    }

    public void EliminarAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Listado de alumnos ======");
        System.out.println("digitar cedula del estudiante: ");
        int cedula = Integer.parseInt(lector.nextLine());

        for (Alumnos alumno : alumnos) {
            if (alumno.getCedula() == cedula) {
                System.out.printf("==== Estudiante: %s ====", alumno.getNombre());
                System.out.printf("1.Cedula: %d \n2.Edad: %d años.\n3.Semestre: %d \n", alumno.getCedula(), alumno.getEdad(), alumno.getSemestre());
                System.out.println("============================");
                System.out.println("confirmacion de eliminacion: ");
                String opc = lector.nextLine();
                if (opc.toLowerCase().equals("si")) {
                    alumnos.remove(alumno);
                    System.out.println("====== Alumno eliminado. ======");
                    return;
                } else {
                    return;
                }
            }
        }
        reporte.EscribirTodos(alumnos);
    }
}
