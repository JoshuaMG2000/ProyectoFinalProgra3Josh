package com.jdmg.proyectofinalprogra3josh;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
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

    // Recorridos
    public void PreOrden(NodoArbol r) {
        if (r != null) {
            System.out.println(r);
            PreOrden(r.HijoIzquierdo);
            PreOrden(r.HijoDerecho);
        }
    }

    public void InOrden(NodoArbol r) {
        if (r != null) {
            InOrden(r.HijoIzquierdo);
            System.out.println(r);
            InOrden(r.HijoDerecho);
        }
    }

    public void PostOrden(NodoArbol r) {
        if (r != null) {
            PostOrden(r.HijoIzquierdo);
            PostOrden(r.HijoDerecho);
            System.out.println(r);
        }
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

    public boolean modificarDatosVehiculo(String placa) {
        NodoArbol nodo = BuscarVehiculoABB(placa);
        if (nodo == null) {
            return false;
        }

        Vehiculos v = nodo.vehiculo;

        // Mostrar diálogos para editar 
        try {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo propietario:", v.getNombrePropietario());
            String nuevoDPI = JOptionPane.showInputDialog("Nuevo DPI Propietario:", v.getDpi());
            String nuevaMarca = JOptionPane.showInputDialog("Nueva marca:", v.getMarca());
            String nuevoModelo = JOptionPane.showInputDialog("Nuevo modelo:", v.getModelo());
            int nuevoAnio = Integer.parseInt(JOptionPane.showInputDialog("Nuevo año:", v.getAnio()));
            int nuevasMultas = Integer.parseInt(JOptionPane.showInputDialog("Nuevas multas:", v.getCantidadMultas()));
            int nuevosTraspasos = Integer.parseInt(JOptionPane.showInputDialog("Nuevos traspasos:", v.getCantidadTraspasos()));

            // Actualizar objeto
            v.setNombrePropietario(nuevoNombre);
            v.setDpi(nuevoDPI);
            v.setMarca(nuevaMarca);
            v.setModelo(nuevoModelo);
            v.setAnio(nuevoAnio);
            v.setCantidadMultas(nuevasMultas);
            v.setCantidadTraspasos(nuevosTraspasos);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en datos numéricos: " + e.getMessage());
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
            return false;
        }
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

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

}
