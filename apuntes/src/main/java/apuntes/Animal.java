package modelo;

import java.time.LocalDate;

public class Animal {

    // Atributos de clase
    //static final String[] TIPOSPERMITIDOS = { "gato", "perro", "lagarto", "cobaya", "periquito" };
    //static final String[] ESTADOSPERMITIDOS = { "comiendo", "durmiendo", "reposando", "jugando" };

    public enum Tipo{
        GATO,
        PERRO,
        LAGARTO,
        COBAYA,
        PERIQUITO,
    }

    public enum Estado{
        COMIENDO,
        DURMIENDO,
        REPOSANDO,
        JUGANDO,
    }

    // Atributos de instancia
    private LocalDate fechaNacimientoAnimal; // Entre 01/01/2000 y hoy
    private String nombreAnimal;
    private double pesoEnGramos; // Entre 0.10 gramos y 100.000 gramos.
    private final Tipo tipoAnimal; // "gato", "perro", "lagarto", "cobaya", "periquito"
    private Estado estadoAnimal; // "comiendo", "durmiendo", "reposando" o "jugando".

    public Animal() { // Creamos una plantilla por defecto.
        this.fechaNacimientoAnimal = LocalDate.of(2001, 2, 2);
        this.nombreAnimal = "Nombre por defecto";
        this.pesoEnGramos = 100;
        this.tipoAnimal = Tipo.GATO;
        this.estadoAnimal = Estado.REPOSANDO;
    }

    public Animal(String nombreAnimal, LocalDate fechaNacimientoAnimal, Tipo tipoAnimal, double pesoEnGramos,
            Estado estadoAnimal) {// Parametrizado

        // Lo primero es controlar los parametros y lanzar las posibles excepciones

        if (fechaNacimientoAnimal.isBefore(LocalDate.of(2000, 1, 1))// Si la fecha es anterior al 2000 y post a hoy.
                || fechaNacimientoAnimal.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser ni anterior al 1-1-2000 ni posterior a hoy.");
        }

        if (pesoEnGramos < 0.10 || pesoEnGramos > 100000) {
            throw new IllegalArgumentException("El peso debe ser entre 0.10 y 100000");
        }

        // Constructor parametrizado.
        this.nombreAnimal = nombreAnimal;
        this.fechaNacimientoAnimal = fechaNacimientoAnimal;
        this.tipoAnimal = tipoAnimal;
        this.pesoEnGramos = pesoEnGramos;
        this.estadoAnimal = estadoAnimal;
    }

    public String toString() {
        return "Nombre: " + nombreAnimal +
                ", nacido el: " + fechaNacimientoAnimal +
                ", tipo: " + tipoAnimal +
                ", con peso: " + pesoEnGramos +
                ", está: " + estadoAnimal;
    }

    public Animal(Animal origen) {// Constructor copia
        this.nombreAnimal = origen.nombreAnimal;
        this.fechaNacimientoAnimal = origen.fechaNacimientoAnimal;
        this.tipoAnimal = origen.tipoAnimal;
        this.pesoEnGramos = origen.pesoEnGramos;
        this.estadoAnimal = origen.estadoAnimal;
    }

    public static Animal clonar(Animal pet) {
        if (pet == null) {
            throw new NullPointerException("El animal que desea clonar no puede ser null");
        }

        return new Animal(pet);
    }

    public Tipo getTipospermitidos() {
        return tipoAnimal;
    }

    public Estado getEstadospermitidos() {
        return estadoAnimal;
    }

    public LocalDate getFechaNacimientoAnimal() {
        return fechaNacimientoAnimal;
    }

    public void setFechaNacimientoAnimal(LocalDate fechaNacimientoAnimal) {
        this.fechaNacimientoAnimal = fechaNacimientoAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public double getPesoEnGramos() {
        return pesoEnGramos;
    }

    public void setPesoEnGramos(double pesoEnGramos) {
        if (pesoEnGramos < 0.10 || pesoEnGramos > 100000) {
            throw new IllegalArgumentException("Peso no válido");
        }
        this.pesoEnGramos = pesoEnGramos;
    }

    public Tipo getTipoAnimal() {
        return tipoAnimal;
    }

    public Estado getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(Estado estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    public void comer(double aumentoEnGramos) {

        aumentoEnGramos = Math.abs(aumentoEnGramos);

        this.estadoAnimal = Estado.COMIENDO;
        System.out.println("Tu mascota esta comiendo.");
        setPesoEnGramos(this.pesoEnGramos + aumentoEnGramos);
    }

    public void dormir() {
        this.estadoAnimal = Estado.DURMIENDO;
        System.out.println("Tu mascota esta dormido.");
    }

    public void despertar() {
        this.estadoAnimal = Estado.REPOSANDO;
    }

    public void reposando() {
        this.estadoAnimal = Estado.REPOSANDO;
        System.out.println("Tu mascota esta descansando.");
    }

    public void jugar(int cantidadMinutos) {
        if (pesoEnGramos > 10) {
            this.estadoAnimal = Estado.JUGANDO;
            System.out.println("El animal esta jugando");
            cantidadMinutos = Math.abs(cantidadMinutos);
            if (cantidadMinutos > 180) {
                throw new IllegalArgumentException("El animal no puede jugar mas de 180 minutos.");
            }

            if (cantidadMinutos < 30) {
                this.pesoEnGramos *= 0.90;
            } else {
                int bloquesDe30 = cantidadMinutos / 30;
                this.pesoEnGramos *= (0.80 * bloquesDe30);
            }
        } else {
            System.out.println("El animal esta muy delgado, debe comer antes de jugar.");
        }
    }

}