package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaCircularTraspasos {

    private NodoCircularTraspaso ultimo;

    public ListaCircularTraspasos() {
        ultimo = null;
    }

    public boolean estaVacia() {
        return ultimo == null;
    }

    public NodoCircularTraspaso getInicio() {
        return (ultimo != null) ? ultimo.siguiente : null;
    }

    public void insertarAlFinal(Traspaso t) {
        NodoCircularTraspaso nuevo = new NodoCircularTraspaso(t);
        if (estaVacia()) {
            ultimo = nuevo;
        } else {
            NodoCircularTraspaso primero = ultimo.siguiente;
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            primero.anterior = nuevo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public void mostrarDesdeInicio() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "Lista vacía.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        NodoCircularTraspaso aux = ultimo.siguiente;
        do {
            sb.append(aux.traspaso.toString()).append("\n");
            aux = aux.siguiente;
        } while (aux != ultimo.siguiente);

        JOptionPane.showMessageDialog(null, sb.toString(), "Traspasos (Inicio ➡ Fin)", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarDesdeFin() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "Lista vacía.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        NodoCircularTraspaso aux = ultimo;
        do {
            sb.append(aux.traspaso.toString()).append("\n");
            aux = aux.anterior;
        } while (aux != ultimo);

        JOptionPane.showMessageDialog(null, sb.toString(), "Traspasos (Fin ➡ Inicio)", JOptionPane.INFORMATION_MESSAGE);
    }

    public NodoCircularTraspaso getUltimo() {
        return ultimo;
    }

    public NodoCircularTraspaso getPrimero() {
        return estaVacia() ? null : ultimo.siguiente;
    }

    public void setUltimo(NodoCircularTraspaso ultimo) {
        this.ultimo = ultimo;
    }

    public void eliminarNodo(NodoCircularTraspaso nodo) {
        if (nodo == null || estaVacia()) {
            return;
        }

        if (nodo == nodo.siguiente) { // Solo un nodo en la lista
            ultimo = null;
        } else {
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
            if (nodo == ultimo) {
                ultimo = nodo.anterior;
            }
        }

        // Limpiar referencias
        nodo.siguiente = null;
        nodo.anterior = null;
    }

    public void llenarTablaInicioFin(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar tabla

        NodoCircularTraspaso aux = getInicio();

        if (aux != null) {
            NodoCircularTraspaso primero = aux;
            do {
                Traspaso t = aux.traspaso;
                modelo.addRow(new Object[]{
                    t.getDepartamento(),
                    t.getPlaca(),
                    t.getDpiAnterior(),
                    t.getNombreAnterior(),
                    t.getFecha(),
                    t.getDpiNuevo(),
                    t.getNombreNuevo()
                });
                aux = aux.siguiente;
            } while (aux != primero);
        }
    }

    public void llenarTablaFinInicio(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar tabla

        NodoCircularTraspaso aux = getUltimo();
        if (aux != null) {
            NodoCircularTraspaso primero = aux.siguiente;
            do {
                Traspaso t = aux.traspaso;
                modelo.addRow(new Object[]{
                    t.getDepartamento(),
                    t.getPlaca(),
                    t.getDpiAnterior(),
                    t.getNombreAnterior(),
                    t.getFecha(),
                    t.getDpiNuevo(),
                    t.getNombreNuevo()
                });
                aux = aux.anterior;
            } while (aux != primero.anterior); // Hasta llegar al "antes" del primero
        }
    }

}
