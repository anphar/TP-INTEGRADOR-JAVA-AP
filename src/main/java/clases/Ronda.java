package clases;

import javax.swing.*;
import java.util.List;

public class Ronda {

//ATRIBUTOS
    private int nroDeRonda;
    private int cantDeEquiposEnRonda;
    private int cantDeEquiposEnLLave;

//CONSTRUCTOR
    public Ronda() {
    }
    public Ronda(int nroDeRonda, int cantDeEquiposEnRonda, int cantDeEquiposEnLLave) {
        this.nroDeRonda = nroDeRonda;
        this.cantDeEquiposEnRonda = cantDeEquiposEnRonda;
        this.cantDeEquiposEnLLave = cantDeEquiposEnLLave;
    }

//GETTER
    public int getNroDeRonda() {
        return nroDeRonda;
    }
    public int getCantDeEquiposEnRonda() {
        return cantDeEquiposEnRonda;
    }
    public int getCantDeEquiposEnLLave() {
        return cantDeEquiposEnLLave;
    }

//SETTER
    public void setNroDeRonda(int nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }
    public void setCantDeEquiposEnRonda(int cantDeEquiposEnRonda) {
        this.cantDeEquiposEnRonda = cantDeEquiposEnRonda;
    }
    public void setCantDeEquiposEnLLave(int cantDeEquiposEnLLave) {
        this.cantDeEquiposEnLLave = cantDeEquiposEnLLave;
    }

//METODOS

    //CUARTOS DE FINAL
    public void cuartosDeFinal (Llave llaveIzquierda, Llave llaveDerecha) {
        this.nroDeRonda = 1;
        this.cantDeEquiposEnLLave = 4;
        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null, "Se jugarán los cuartos de final",
                "Cuartos", JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i < cantDeEquiposEnLLave; i+=2) {
            partido.simularPartido(llaveIzquierda.getEquipoDeLaLlave().get(i), llaveIzquierda.getEquipoDeLaLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquipoDeLaLlave().get(i), llaveDerecha.getEquipoDeLaLlave().get(i+1));
        }

        removerEquipos(llaveIzquierda.getEquipoDeLaLlave());
        removerEquipos(llaveDerecha.getEquipoDeLaLlave());
        this.cantDeEquiposEnLLave = 2;
    }

    public void removerEquipos(List<Equipo> equipos) {
        int contadorEquiposPorLlave = cantDeEquiposEnLLave;

        for (int i = 0; i < contadorEquiposPorLlave; i++) {
            Equipo auxiliar = equipos.get(i);
            if (!auxiliar.isAutorizacion()) {
                equipos.remove(auxiliar);
                contadorEquiposPorLlave --;
            }
        }
    }

    //SEMIFINAL
    public void semifinal(Llave llaveIzquierda,Llave llaveDerecha) {
        this.nroDeRonda = 2;
        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null, "Se jugarán las semifinales",
                "Semis", JOptionPane.INFORMATION_MESSAGE);

        partido.simularPartido(llaveIzquierda.getEquipoDeLaLlave().get(0), llaveIzquierda.getEquipoDeLaLlave().get(1));
        partido.simularPartido(llaveDerecha.getEquipoDeLaLlave().get(0), llaveDerecha.getEquipoDeLaLlave().get(1));

        removerEquipos(llaveDerecha.getEquipoDeLaLlave());
        removerEquipos(llaveIzquierda.getEquipoDeLaLlave());
    }

    //FINAL
    public void finalDelTorneo(Llave llaveIzquierda, Llave llaveDerecha) {
        this.nroDeRonda = 3;
        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null, "Se jugará la final",
                "Final", JOptionPane.INFORMATION_MESSAGE);

        Equipo equipo = partido.simularPartido(llaveDerecha.getEquipoDeLaLlave().get(0),llaveIzquierda.getEquipoDeLaLlave().get(0));

        JOptionPane.showMessageDialog(null, "El ganador del torneo es: " + equipo.getNombre(),
                "Final", JOptionPane.INFORMATION_MESSAGE);
    }
}
