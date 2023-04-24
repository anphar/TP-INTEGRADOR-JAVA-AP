package clases;

import enumeraciones.Resultado;

public class Equipo {

//ATRIBUTOS
    private String nombre;
    private boolean autorizacion = true;
    private Resultado resultadoEnElPartido;
    private int cantGolesEnElTorneo;

//CONSTRUCTOR
    public Equipo() {
    }
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    public Equipo(String nombre, boolean autorizacion, Resultado resultadoEnElPartido, int cantGolesEnElTorneo) {
        this.nombre = nombre;
        this.autorizacion = autorizacion;
        this.resultadoEnElPartido = resultadoEnElPartido;
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

//GETTER
    public String getNombre() {
        return nombre;
    }
    public boolean isAutorizacion() {
        return autorizacion;
    }
    public Resultado getResultadoEnElPartido() {
        return resultadoEnElPartido;
    }
    public int getCantGolesEnElTorneo() {
        return cantGolesEnElTorneo;
    }

//SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }
    public void setResultadoEnElPartido(Resultado resultadoEnElPartido) {
        this.resultadoEnElPartido = resultadoEnElPartido;
    }
    public void setCantGolesEnElTorneo(int cantGolesEnElTorneo) {
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

//METODO SUMAR GOLES

    public void sumarGolesNuevos(int nuevosGoles) {
        this.cantGolesEnElTorneo += nuevosGoles;
    }
}
