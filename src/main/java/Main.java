import clases.*;

import javax.swing.*;
import java.util.ArrayList;

//PROGRAMA
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "Bienvenidos al Torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
        menu();
    }

    public static void mostrarOpciones(){
        JOptionPane.showMessageDialog(null,"Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "0. Salir","Opciones",JOptionPane.INFORMATION_MESSAGE);
    }


    public static void menu() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Menu\nSelecciona una de las siguientes opciones:","Menú", JOptionPane.INFORMATION_MESSAGE);

        // Se inicializan las variables que se utilizarán durante la ejecución del programa.
        boolean salir = true;
        ArrayList<Equipo> listaDeEquipos = null;
        Jugador jugador = null;
        Llave llaveDerecha = null;
        Llave llaveIzquierda = null;
        Ronda ronda = null;
        String opcion="";

        do {
            mostrarOpciones();

            // Se utiliza la función mostrarOpciones() para mostrar las opciones disponibles.
            opcion = JOptionPane.showInputDialog(null,"Ingrese la opcion: ",
                    "Opciones",JOptionPane.INFORMATION_MESSAGE);
            switch (opcion) {
                case "1":

                  listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
//0. SALIR
                    JOptionPane.showMessageDialog(null, "Saliendo...", "Salida", JOptionPane.CLOSED_OPTION);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingreso invalido","Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (salir);
    }


    public static void bienvenidaAlTorneo() {
        JOptionPane.showMessageDialog(null, "Bienvenidos al Torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
    }

//1. CREAR LISTA DE EQUIPOS
    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {

        if (listaDeEquipos == null) {
            return new ArrayList<Equipo>();
        } else {
            JOptionPane.showMessageDialog(null,"Ya hay una lista creada","Información",JOptionPane.INFORMATION_MESSAGE);
            return listaDeEquipos;
        }
    }

//2. CARGAR EQUIPOS
    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {
        if(!
                listaDeEquipos.isEmpty()){
            String cargaDeEquipos=JOptionPane.showInputDialog(null,"Ya hay una lista cargada\n ¿Desea cargarla nuevamente? SI | NO","Lista Cargada",JOptionPane.INFORMATION_MESSAGE);

            if(cargaDeEquipos.equalsIgnoreCase("SI")){
                listaDeEquipos.clear();
            }
        }

        String opcion = "";
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "Bienvenido a la carga de equipos\n¿Desea cargar los equipos manualmente? SI | NO",
                    "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
            if (opcion == null || opcion.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en la casilla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion == null || opcion.equals(""));

        // Si el usuario selecciona "si", cargamos los equipos manualmente
        if (opcion.equalsIgnoreCase("si")) {
            cargarEquipoManualmente(listaDeEquipos);
        }
        // Si el usuario selecciona "no", cargamos los equipos automáticamente
        else {

            listaDeEquipos.add(new Equipo("Belgica"));
            listaDeEquipos.add(new Equipo("Francia"));
            listaDeEquipos.add(new Equipo("Portugal"));
            listaDeEquipos.add(new Equipo("Alemania"));
            listaDeEquipos.add(new Equipo("Brasil"));
            listaDeEquipos.add(new Equipo("Italia"));
            listaDeEquipos.add(new Equipo("Argelia"));
            listaDeEquipos.add(new Equipo("Argentina"));
        }
    }

//3. ELEGIR EQUIPO
    public static Jugador elegirEquipo(ArrayList<Equipo> listaDeEquipos) {
        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos);
        return jugador;
    }

//4. CREAR LLAVE DERECHA
    public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos) {
        // Crea una Llave derecha y la arma utilizando la lista de equipos que se le pasa como parámetro.
        Llave llaveDerecha = new Llave("Llave Derecha");
        llaveDerecha.armarLlave(listaDeEquipos, 0);
        return llaveDerecha;
    }

//5. CREAR LLAVE IZQUIERDA
    public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {
        // Crea una Llave izquierda y la arma utilizando la lista de equipos que se le pasa como parámetro.
        Llave llaveIzquierda = new Llave("Llave Izquierda");
        llaveIzquierda.armarLlave(listaDeEquipos, 4);
        return llaveIzquierda;
    }

//6. CREAR RONDAS
    public static Ronda crearRondas() {
        // Crea una Ronda
        return new Ronda();
    }

//7. JUGAR TORNEO
    public static void jugarTorneo(Ronda ronda, Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();

    }

//8. RESULTADO DEL TORNEO
    public static void resultadoDelTorneo(Jugador jugador) {
        // Muestra un mensaje en una ventana emergente con el puntaje obtenido por el jugador y el nombre del equipo seleccionado.
        JOptionPane.showMessageDialog(null, "Has conseguido " + jugador.getPuntaje()
                        + " puntos por elegir al equipo: " + jugador.getEquipoSeleccionado().getNombre(), "Puntaje",
                JOptionPane.INFORMATION_MESSAGE);
    }

//2. OPCION CARGAR MANUALMENTE
    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos){
        String nombreEquipo=null;
        for (int i = 0; i < 8; i++) {
            do{
                nombreEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo",
                        "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
                if(nombreEquipo==null || nombreEquipo.equals("")){
                    JOptionPane.showMessageDialog(null,"Ingrese un valor en la casilla","Error",JOptionPane.ERROR_MESSAGE);
                }
            }while(nombreEquipo==null || nombreEquipo.equals(""));
            listaDeEquipos.add(new Equipo(nombreEquipo));
        }
    }
}
