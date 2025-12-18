
package modelo;

public class Persona {

    private String nombre;
    private int edad;

    public Persona() {// por defecto
        this.nombre = "por defecto";
        this.edad = 18;
    }

    public Persona(String nombre, int edad) {// Parametrizado
        this.nombre = nombre;
        this.edad = edad;
    }

    public String toString() {
        return "Nombre: " + nombre + " con" + edad + " años.";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void llamar(Animal pet) {
        pet.despertar();
    }

    public void alimentar(Animal pet, double aumentoEnGramos) {
        pet.comer(aumentoEnGramos);
    }

    public void jugar(Animal pet, int cantidadMinutos) {
        if (cantidadMinutos > 180) {
            cantidadMinutos = 180;
        }
        pet.jugar(cantidadMinutos);
    }

}
