package clases;

import enumeraciones.Resultado;

import javax.swing.*;

public class Partido {

//ATRIBUTOS
    private int golesEquipoLocal = 2;
    private int golesEquipoVisitante = 3;

//CONSTRUCTOR
    public Partido() {
    }
    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

//GETTER
    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }
    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

//SETTER
    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }
    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

//METODO DEL RESULTADO DEL PARTIDO

    public Equipo simularPartido (Equipo equipoLocal, Equipo equipoVisitante) {
        JOptionPane.showMessageDialog(null, equipoLocal.getNombre() + " " + this.golesEquipoLocal + " "
                + this.golesEquipoVisitante + " " + equipoVisitante.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

    //SUMA DE GOLES

        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);

    //LOGICA DEL PARTIDO

        if (this.golesEquipoLocal > this.golesEquipoVisitante) {
            
            equipoVisitante.setAutorizacion(false);
            equipoVisitante.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipoLocal.setResultadoEnElPartido(Resultado.GANADOR);

            return equipoLocal;
        } else if (this.golesEquipoLocal == this.golesEquipoVisitante) {

            JOptionPane.showMessageDialog(null, "Se jugara el desempate entre " + equipoLocal.getNombre()
                    + "-"+ equipoVisitante.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            equipoLocal.setResultadoEnElPartido(Resultado.EMPATE);
            equipoVisitante.setResultadoEnElPartido(Resultado.EMPATE);

            simularPartido(equipoLocal, equipoVisitante);

        }else {

            equipoLocal.setAutorizacion(false);
            equipoLocal.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipoVisitante.setResultadoEnElPartido(Resultado.GANADOR);
            return equipoVisitante;
        }
        return null;
    }
}
