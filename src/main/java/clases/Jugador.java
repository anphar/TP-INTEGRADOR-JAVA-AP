package clases;

import javax.swing.*;
import java.util.List;

public class Jugador {

//ATRIBUTOS
    private Equipo equipoSeleccionado;
    private int puntaje;

//CONSTRUCTOR
    public Jugador() {
    }
    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }

//GETTER
    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }
    public int getPuntaje() {
        return puntaje;
    }

//SETTER
    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

//METODO PANEL DE SELECCION DE EQUIPO

    public void elegirEquipo (List <Equipo> listaDeEquipos) {
        JOptionPane.showMessageDialog(null, "Seleccione su equipo", "Seleccion de equipo", JOptionPane.INFORMATION_MESSAGE);
        String listaDeLosEquiposEnMensaje = "Equipos: \n";

        for (int i = 0; i < listaDeEquipos.size(); i++) {
            listaDeLosEquiposEnMensaje += (i + 1) + ". " + listaDeEquipos.get(i).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaDeLosEquiposEnMensaje, "Seleccion de equipo", JOptionPane.INFORMATION_MESSAGE);

        int indiceEquipo = 0;

        do {
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice del equipo a seleccionar","Seleccion de quipo", JOptionPane.INFORMATION_MESSAGE)) - 1;
        }while (indiceEquipo < 1 | indiceEquipo > 8);
        JOptionPane.showMessageDialog(null, "El equipo elegido es: " + listaDeEquipos.get(indiceEquipo).getNombre(), "Seleccion de equipo", JOptionPane.INFORMATION_MESSAGE);

        this.equipoSeleccionado = listaDeEquipos.get(indiceEquipo);
    }

//METODO SUMAR PUNTOS
    public void sumarPuntos() {
        if (equipoSeleccionado.isAutorizacion()) {
            puntaje ++;
        }
    }
}
