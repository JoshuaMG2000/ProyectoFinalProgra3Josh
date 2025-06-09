package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import javax.swing.JOptionPane;

public class ListaDobleMultas {
    private NodoDobleMulta inicio, fin;

    public ListaDobleMultas() {
        inicio = fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void agregarAlFinal(Vehiculos vehiculo) {
        if (!estaVacia()) {
            fin = new NodoDobleMulta(vehiculo, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoDobleMulta(vehiculo);
        }
    }

    public void agregarAlInicio(Vehiculos vehiculo) {
        if (!estaVacia()) {
            inicio = new NodoDobleMulta(vehiculo, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoDobleMulta(vehiculo);
        }
    }

    public void mostrarListaInicioFin() {
        if (!estaVacia()) {
            StringBuilder datos = new StringBuilder("<-->");
            NodoDobleMulta aux = inicio;
            while (aux != null) {
                datos.append("[ ").append(aux.vehiculo.toString()).append(" ]<-->");
                aux = aux.siguiente;
            }
            JOptionPane.showMessageDialog(null, datos.toString(), "Multas de Inicio a Fin", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarListaFinInicio() {
        if (!estaVacia()) {
            StringBuilder datos = new StringBuilder("<-->");
            NodoDobleMulta aux = fin;
            while (aux != null) {
                datos.append("[ ").append(aux.vehiculo.toString()).append(" ]<-->");
                aux = aux.anterior;
            }
            JOptionPane.showMessageDialog(null, datos.toString(), "Multas de Fin a Inicio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Vehiculos eliminarDelInicio() {
        Vehiculos v = inicio.vehiculo;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return v;
    }

    public Vehiculos eliminarDelFinal() {
        Vehiculos v = fin.vehiculo;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return v;
    }

    public Vehiculos eliminarEnPosicion(int posicion) {
        if (estaVacia() || posicion < 0) return null;

        if (posicion == 0) return eliminarDelInicio();

        NodoDobleMulta actual = inicio;
        int contador = 0;
        while (actual != null && contador < posicion) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual == null) return null;

        Vehiculos eliminado = actual.vehiculo;

        if (actual == fin) {
            fin = actual.anterior;
            fin.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        return eliminado;
    }
}

