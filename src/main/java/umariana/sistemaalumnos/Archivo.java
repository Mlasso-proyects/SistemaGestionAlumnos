package umariana.sistemaalumnos;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Mflass
 */
public class Archivo {
    // ruta del archivo: ./java/data/ReporteAlumno.txt

    public void EscribirTodos(ArrayList<Alumnos> alumnos) throws FileNotFoundException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(".\\src\\main\\java\\data\\ReporteAlumno.txt", false))) {
            for (Alumnos miAlumno : alumnos) {
                escritor.write(miAlumno.alineaTexto());
                escritor.newLine();
            }
            System.out.println("alumno registrado con exito");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void LeerArchivo(ArrayList<Alumnos> alumnos) throws FileNotFoundException {
        try (BufferedReader lector = new BufferedReader(new FileReader(".\\src\\main\\java\\data\\ReporteAlumno.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(linea.isBlank()) continue;
                String[] datos = linea.split(",");
                int cedula = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                int edad = Integer.parseInt(datos[3]);
                int semestre = Integer.parseInt(datos[4]);

                alumnos.add(new Alumnos(cedula, nombre, apellido, edad, semestre));

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
