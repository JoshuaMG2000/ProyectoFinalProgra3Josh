package com.jdmg.proyectofinalprogra3josh;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
//import javax.swing.JOptionPane;
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

    public void eliminarNodo(NodoDobleMulta nodo) {
        if (nodo == null) {
            return;
        }

        if (nodo == inicio) {
            inicio = nodo.siguiente;
            if (inicio != null) {
                inicio.anterior = null;
            }
        } else if (nodo == fin) {
            fin = nodo.anterior;
            if (fin != null) {
                fin.siguiente = null;
            }
        } else {
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
        }
        // Opcionalmente limpia el nodo
        nodo.siguiente = null;
        nodo.anterior = null;
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

    // Mostrar de inicio a fin en JTable
    public void llenarTablaInicioFin(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar tabla
        NodoDobleMulta aux = inicio;
        while (aux != null) {
            Multa m = aux.multa;
            modelo.addRow(new Object[]{
                m.getDepartamento(),
                m.getPlaca(),
                m.getFecha(),
                m.getDescripcion(),
                m.getMonto()
            });
            aux = aux.siguiente;
        }
    }

// Mostrar de fin a inicio en JTable
    public void llenarTablaFinInicio(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar tabla
        NodoDobleMulta aux = fin;
        while (aux != null) {
            Multa m = aux.multa;
            modelo.addRow(new Object[]{
                m.getDepartamento(),
                m.getPlaca(),
                m.getFecha(),
                m.getDescripcion(),
                m.getMonto()
            });
            aux = aux.anterior;
        }
    }

    /*
    public void agregarAlInicio(Multa multa) {
        if (!estaVacia()) {
            inicio = new NodoDobleMulta(multa, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoDobleMulta(multa);
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
     */
}
