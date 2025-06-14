package com.jdmg.proyectofinalprogra3josh;

import java.io.BufferedReader;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public void exportarTraspasos(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write("Departamento,Placa,DPI_Anterior,Nombre_Anterior,Fecha,DPI_Nuevo,Nombre_Nuevo");
            bw.newLine();
            NodoCircularTraspaso aux = getInicio();
            if (aux != null) {
                NodoCircularTraspaso primero = aux;
                do {
                    Traspaso t = aux.traspaso;
                    bw.write(String.join(",",
                            t.getDepartamento(),
                            t.getPlaca(),
                            t.getDpiAnterior(),
                            t.getNombreAnterior(),
                            t.getFecha(),
                            t.getDpiNuevo(),
                            t.getNombreNuevo()
                    ));
                    bw.newLine();
                    aux = aux.siguiente;
                } while (aux != primero);
            }
        }
    }

    public void importarTraspasosDesdeArchivo(File archivo, ListaCircularTraspasos listaTraspasos) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) { // descarta encabezado
                    primera = false;
                    continue;
                }
                String[] p = linea.split(",");
                if (p.length >= 7) {
                    Traspaso t = new Traspaso(
                            p[0],
                            p[1],
                            p[2],
                            p[3],
                            p[4],
                            p[5],
                            p[6]
                    );
                    listaTraspasos.insertarAlFinal(t);
                }
            }
        }
    }

    /**
     * Encripta todos los Traspasos en la lista circular.
     */
    public void encryptTraspasos() {
        if (ultimo == null) {
            return;
        }
        NodoCircularTraspaso primero = ultimo.siguiente;
        NodoCircularTraspaso aux = primero;
        do {
            Traspaso t = aux.traspaso;
            t.setDepartamento(CryptoUtils.encrypt(t.getDepartamento()));
            t.setPlaca(CryptoUtils.encrypt(t.getPlaca()));
            t.setDpiAnterior(CryptoUtils.encrypt(t.getDpiAnterior()));
            t.setNombreAnterior(CryptoUtils.encrypt(t.getNombreAnterior()));
            t.setFecha(CryptoUtils.encrypt(t.getFecha()));
            t.setDpiNuevo(CryptoUtils.encrypt(t.getDpiNuevo()));
            t.setNombreNuevo(CryptoUtils.encrypt(t.getNombreNuevo()));
            aux = aux.siguiente;
        } while (aux != primero);
    }

    /**
     * Desencripta todos los Traspasos en la lista circular.
     */
    public void decryptTraspasos() {
        if (ultimo == null) {
            return;
        }
        NodoCircularTraspaso primero = ultimo.siguiente;
        NodoCircularTraspaso aux = primero;
        do {
            Traspaso t = aux.traspaso;
            t.setDepartamento(CryptoUtils.decrypt(t.getDepartamento()));
            t.setPlaca(CryptoUtils.decrypt(t.getPlaca()));
            t.setDpiAnterior(CryptoUtils.decrypt(t.getDpiAnterior()));
            t.setNombreAnterior(CryptoUtils.decrypt(t.getNombreAnterior()));
            t.setFecha(CryptoUtils.decrypt(t.getFecha()));
            t.setDpiNuevo(CryptoUtils.decrypt(t.getDpiNuevo()));
            t.setNombreNuevo(CryptoUtils.decrypt(t.getNombreNuevo()));
            aux = aux.siguiente;
        } while (aux != primero);
    }
}
