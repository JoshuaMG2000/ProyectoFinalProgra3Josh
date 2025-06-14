package com.jdmg.proyectofinalprogra3josh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void exportarMultas(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write("Departamento,Placa,Fecha,Descripcion,Monto");
            bw.newLine();
            NodoDobleMulta aux = inicio;
            while (aux != null) {
                Multa m = aux.multa;
                bw.write(String.join(",",
                        m.getDepartamento(),
                        m.getPlaca(),
                        m.getFecha(),
                        m.getDescripcion(),
                        String.valueOf(m.getMonto())
                ));
                bw.newLine();
                aux = aux.siguiente;
            }
        }
    }

    public void importarMultasDesdeArchivo(File archivo, ListaDobleMultas listaMultas) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) { // descarta encabezado
                    primera = false;
                    continue;
                }
                String[] p = linea.split(",");
                if (p.length >= 5) {
                    Multa m = new Multa(
                            p[0],
                            p[1],
                            p[2],
                            p[3],
                            Double.parseDouble(p[4])
                    );
                    listaMultas.agregarAlFinal(m);
                }
            }
        }
    }

    /**
     * Encripta todas las Multas en la lista doble.
     */
    public void encryptMultas() {
        NodoDobleMulta aux = inicio;
        while (aux != null) {
            Multa m = aux.multa;
            m.setDepartamento(CryptoUtils.encrypt(m.getDepartamento()));
            m.setPlaca(CryptoUtils.encrypt(m.getPlaca()));
            m.setFecha(CryptoUtils.encrypt(m.getFecha()));
            m.setDescripcion(CryptoUtils.encrypt(m.getDescripcion()));

            String sMonto = Double.toString(m.getMonto());
            m.setMonto(Double.parseDouble(CryptoUtils.encrypt(sMonto)));

            aux = aux.siguiente;
        }
    }

    /**
     * Desencripta todas las Multas en la lista doble.
     */
    public void decryptMultas() {
        NodoDobleMulta aux = inicio;
        while (aux != null) {
            Multa m = aux.multa;
            m.setDepartamento(CryptoUtils.decrypt(m.getDepartamento()));
            m.setPlaca(CryptoUtils.decrypt(m.getPlaca()));
            m.setFecha(CryptoUtils.decrypt(m.getFecha()));
            m.setDescripcion(CryptoUtils.decrypt(m.getDescripcion()));
            m.setMonto(Double.parseDouble(CryptoUtils.decrypt(Double.toString(m.getMonto()))));
            aux = aux.siguiente;
        }
    }
}
