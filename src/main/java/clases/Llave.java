package clases;

import java.util.ArrayList;
import java.util.List;

public class Llave {

//ATRIBUTOS
    private List<Equipo> equipoDeLaLlave;
    private String nombreDeLaLlave;

//CONSTRUCTOR
    public Llave() {
    }

    public Llave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    public Llave(List<Equipo> equipoDeLaLlave, String nombreDeLaLlave) {
        this.equipoDeLaLlave = equipoDeLaLlave;
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    //GETTER
    public List<Equipo> getEquipoDeLaLlave() {
        return equipoDeLaLlave;
    }
    public String getNombreDeLaLlave() {
        return nombreDeLaLlave;
    }

//SETTER
    public void setEquipoDeLaLlave(List<Equipo> equipoDeLaLlave) {
        this.equipoDeLaLlave = equipoDeLaLlave;
    }
    public void setNombreDeLaLlave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

//METODO

    public void armarLlave(List <Equipo> listaGeneral, int indiceInicial) {
        List<Equipo> equiposLlave = new ArrayList<>();
        for (int i = indiceInicial; i < indiceInicial + 4; i++) {
            equiposLlave.add(listaGeneral.get(i));
        }

        this.equipoDeLaLlave = equiposLlave;
    }
}
