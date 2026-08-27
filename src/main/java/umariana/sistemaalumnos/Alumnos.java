package umariana.sistemaalumnos;

/**
 *
 * @author Mflass
 */
public class Alumnos {
    private int cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private int semestre;

    public Alumnos(int cedula, String nombre, String apellido, int edad, int semestre) {
        if(String.valueOf(Math.abs(cedula)).length() != 10){
            throw new IllegalArgumentException("numero de cedula no valida");
        }
        if(edad < 0 || semestre < 0){
            throw new IllegalArgumentException("numeros ingresados invalidos ");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.semestre = semestre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad < 0 && edad > 100){
            throw new IllegalArgumentException("No se permiten numeros negativos");
        }
        this.edad = edad;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if(semestre < 0 && semestre >10){
            throw new IllegalArgumentException("No se permiten numeros negativos");
        }
        this.semestre = semestre;
    }
    
    public String alineaTexto(){
        return cedula + "," + nombre + "," + apellido + "," + edad + "," + semestre;
    }
    
    @Override
    public String toString() {
        return "Cédula: " + cedula + " | Nombre: " + nombre + " " + apellido +
               " | Edad: " + edad + " | Semestre: " + semestre;
    }
}
