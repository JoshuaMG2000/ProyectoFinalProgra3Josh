package com.jdmg.proyectofinalprogra3josh;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jgald
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    //Para comparar duplicados y proteger al ABB de los mismos , 
    public boolean insertarVehiculo(Vehiculos v) {
        if (BuscarVehiculoABB(v.getPlaca()) != null) {
            return false; // Ya existe una placa igual
        }
        AgregarVehiculo(v);
        return true;
    }

    // Inserta usando la placa como clave
    public void AgregarVehiculo(Vehiculos v) {
        NodoArbol nuevo = new NodoArbol(v);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;

            while (true) {
                padre = auxiliar;

                // Comparación por placa, ordenada alfabéticamente, si es menor va a la izquierda.
                if (v.getPlaca().compareTo(auxiliar.vehiculo.getPlaca()) < 0) {
                    auxiliar = auxiliar.HijoIzquierdo;
                    if (auxiliar == null) {
                        padre.HijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.HijoDerecho;
                    if (auxiliar == null) {
                        padre.HijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean EstaVacio() {
        return raiz == null;
    }

    // Búsqueda por placa
    public NodoArbol BuscarVehiculoABB(String placa) {
        NodoArbol auxiliar = raiz;

        while (auxiliar != null && !auxiliar.vehiculo.getPlaca().equals(placa)) {
            if (placa.compareTo(auxiliar.vehiculo.getPlaca()) < 0) {
                auxiliar = auxiliar.HijoIzquierdo;
            } else {
                auxiliar = auxiliar.HijoDerecho;
            }
        }
        return auxiliar;
    }

    public Vehiculos EliminarVehiculo(String placa) {
        NodoArbol actual = raiz;
        NodoArbol padre = null;
        boolean esHijoIzquierdo = true;

        // Buscar el nodo
        while (actual != null && !actual.vehiculo.getPlaca().equals(placa)) {
            padre = actual;
            if (placa.compareTo(actual.vehiculo.getPlaca()) < 0) {
                esHijoIzquierdo = true;
                actual = actual.HijoIzquierdo;
            } else {
                esHijoIzquierdo = false;
                actual = actual.HijoDerecho;
            }
        }

        if (actual == null) {
            return null; // No se encontró
        }

        Vehiculos eliminado = actual.vehiculo;

        // Caso 1: El nodo es una hoja
        if (actual.HijoIzquierdo == null && actual.HijoDerecho == null) {
            if (actual == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = null;
            } else {
                padre.HijoDerecho = null;
            }
        } // Caso 2: El nodo tiene un solo hijo (derecho)
        else if (actual.HijoIzquierdo == null) {
            if (actual == raiz) {
                raiz = actual.HijoDerecho;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = actual.HijoDerecho;
            } else {
                padre.HijoDerecho = actual.HijoDerecho;
            }
        } // Caso 2: El nodo tiene un solo hijo (izquierdo)
        else if (actual.HijoDerecho == null) {
            if (actual == raiz) {
                raiz = actual.HijoIzquierdo;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = actual.HijoIzquierdo;
            } else {
                padre.HijoDerecho = actual.HijoIzquierdo;
            }
        } // Caso 3: El nodo tiene dos hijos
        else {
            NodoArbol reemplazo = obtenerReemplazo(actual);
            if (actual == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = reemplazo;
            } else {
                padre.HijoDerecho = reemplazo;
            }
            reemplazo.HijoIzquierdo = actual.HijoIzquierdo;
        }

        return eliminado;
    }

    private NodoArbol obtenerReemplazo(NodoArbol nodoReemplazar) {
        NodoArbol reemplazoPadre = nodoReemplazar;
        NodoArbol reemplazo = nodoReemplazar;
        NodoArbol actual = nodoReemplazar.HijoDerecho;

        while (actual != null) {
            reemplazoPadre = reemplazo;
            reemplazo = actual;
            actual = actual.HijoIzquierdo;
        }

        if (reemplazo != nodoReemplazar.HijoDerecho) {
            reemplazoPadre.HijoIzquierdo = reemplazo.HijoDerecho;
            reemplazo.HijoDerecho = nodoReemplazar.HijoDerecho;
        }

        return reemplazo;
    }

    public void generarDotABB(NodoArbol nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            String etiqueta = nodo.vehiculo.getPlaca();
            writer.write("\"" + etiqueta + "\" [label=\"" + etiqueta + "\"];\n");

            if (nodo.HijoIzquierdo != null) {
                writer.write("\"" + etiqueta + "\" -> \"" + nodo.HijoIzquierdo.vehiculo.getPlaca() + "\";\n");
                generarDotABB(nodo.HijoIzquierdo, writer);
            }

            if (nodo.HijoDerecho != null) {
                writer.write("\"" + etiqueta + "\" -> \"" + nodo.HijoDerecho.vehiculo.getPlaca() + "\";\n");
                generarDotABB(nodo.HijoDerecho, writer);
            }
        }
    }

    public void exportarABBComoImagen(ArbolBinario arbolito) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("arbolABB.dot"));
            writer.write("digraph G {\n");
            writer.write("node [shape=ellipse, style=filled, color=lightblue];\n");
            generarDotABB(arbolito.raiz, writer);
            writer.write("}\n");
            writer.close();

            // Ejecutar Graphviz para generar PNG
            Process p = Runtime.getRuntime().exec("dot -Tpng arbolABB.dot -o arbolABB.png");
            p.waitFor();

            // Mostrar imagen generada
            Desktop.getDesktop().open(new File("arbolABB.png"));
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el gráfico: " + e.getMessage());
        }
    }

    //EXPORTAR PARA .TXT
    public void exportarABB(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // encabezado
            bw.write("Departamento,Placa,DPI,Propietario,Marca,Modelo,Año,Multas,Traspasos");
            bw.newLine();
            exportarNodoABB(raiz, bw);
        }
    }

    //EXPORTAR PARA .TXT
    private void exportarNodoABB(NodoArbol nodo, BufferedWriter bw) throws IOException {
        if (nodo == null) {
            return;
        }
        exportarNodoABB(nodo.HijoIzquierdo, bw);
        Vehiculos v = nodo.vehiculo;
        bw.write(String.join(",",
                v.getDepartamento(),
                v.getPlaca(),
                v.getDpi(),
                v.getNombrePropietario(),
                v.getMarca(),
                v.getModelo(),
                String.valueOf(v.getAnio()),
                String.valueOf(v.getCantidadMultas()),
                String.valueOf(v.getCantidadTraspasos())
        ));
        bw.newLine();
        exportarNodoABB(nodo.HijoDerecho, bw);
    }

    /**
     * Recorre todo el ABB y encripta todos los campos String de cada Vehiculos.
     */
    public void encryptABB() {
        encryptNodo(raiz);
    }

    private void encryptNodo(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        Vehiculos v = nodo.vehiculo;
        v.setDepartamento(CryptoUtils.encrypt(v.getDepartamento()));
        v.setPlaca(CryptoUtils.encrypt(v.getPlaca()));
        v.setDpi(CryptoUtils.encrypt(v.getDpi()));
        v.setNombrePropietario(CryptoUtils.encrypt(v.getNombrePropietario()));
        v.setMarca(CryptoUtils.encrypt(v.getMarca()));
        v.setModelo(CryptoUtils.encrypt(v.getModelo()));
        // encriptar año
        String sAnio = Integer.toString(v.getAnio());
        v.setAnio(Integer.parseInt(CryptoUtils.encrypt(sAnio)));

        // encriptar cantidadMultas
        String sMultas = Integer.toString(v.getCantidadMultas());
        v.setCantidadMultas(Integer.parseInt(CryptoUtils.encrypt(sMultas)));

        // encriptar cantidadTraspasos
        String sTrans = Integer.toString(v.getCantidadTraspasos());
        v.setCantidadTraspasos(Integer.parseInt(CryptoUtils.encrypt(sTrans)));
        encryptNodo(nodo.HijoIzquierdo);
        encryptNodo(nodo.HijoDerecho);
    }

    /**
     * Recorre todo el ABB y desencripta todos los campos String de cada
     * Vehiculos.
     */
    public void decryptABB() {
        decryptNodo(raiz);
    }

    private void decryptNodo(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        Vehiculos v = nodo.vehiculo;
        v.setDepartamento(CryptoUtils.decrypt(v.getDepartamento()));
        v.setPlaca(CryptoUtils.decrypt(v.getPlaca()));
        v.setDpi(CryptoUtils.decrypt(v.getDpi()));
        v.setNombrePropietario(CryptoUtils.decrypt(v.getNombrePropietario()));
        v.setMarca(CryptoUtils.decrypt(v.getMarca()));
        v.setModelo(CryptoUtils.decrypt(v.getModelo()));
        // desencriptar año
        v.setAnio(Integer.parseInt(CryptoUtils.decrypt(Integer.toString(v.getAnio()))));
        // desencriptar multas
        v.setCantidadMultas(Integer.parseInt(CryptoUtils.decrypt(Integer.toString(v.getCantidadMultas()))));
        // desencriptar traspasos
        v.setCantidadTraspasos(Integer.parseInt(CryptoUtils.decrypt(Integer.toString(v.getCantidadTraspasos()))));

        decryptNodo(nodo.HijoIzquierdo);
        decryptNodo(nodo.HijoDerecho);
    }
}
