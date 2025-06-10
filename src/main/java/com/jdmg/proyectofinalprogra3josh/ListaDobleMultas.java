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

    public void agregarAlFinal(Multa multa) {
        if (!estaVacia()) {
            fin = new NodoDobleMulta(multa, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoDobleMulta(multa);
        }
    }

    public void agregarAlInicio(Multa multa) {
        if (!estaVacia()) {
            inicio = new NodoDobleMulta(multa, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoDobleMulta(multa);
        }
    }

    public void mostrarListaInicioFin() {
        if (!estaVacia()) {
            StringBuilder datos = new StringBuilder("<-->");
            NodoDobleMulta aux = inicio;
            while (aux != null) {
                datos.append("[ ").append(aux.multa.toString()).append(" ]<-->");
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
                datos.append("[ ").append(aux.multa.toString()).append(" ]<-->");
                aux = aux.anterior;
            }
            JOptionPane.showMessageDialog(null, datos.toString(), "Multas de Fin a Inicio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Multa eliminarDelInicio() {
        Multa m = inicio.multa;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return m;
    }

    public Multa eliminarDelFinal() {
        Multa m = fin.multa;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return m;
    }

    public Multa eliminarEnPosicion(int posicion) {
        if (estaVacia() || posicion < 0) {
            return null;
        }

        if (posicion == 0) {
            return eliminarDelInicio();
        }

        NodoDobleMulta actual = inicio;
        int contador = 0;
        while (actual != null && contador < posicion) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual == null) {
            return null;
        }

        Multa eliminada = actual.multa;

        if (actual == fin) {
            fin = actual.anterior;
            if (fin != null) {
                fin.siguiente = null;
            }
        } else {
            actual.anterior.siguiente = actual.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            }
        }

        return eliminada;
    }

    public NodoDobleMulta getInicio() {
        return inicio;
    }

    public NodoDobleMulta getNodoEnPosicion(int posicion) {
        NodoDobleMulta actual = inicio;
        int contador = 0;
        while (actual != null && contador < posicion) {
            actual = actual.siguiente;
            contador++;
        }
        return actual;
    }
}
