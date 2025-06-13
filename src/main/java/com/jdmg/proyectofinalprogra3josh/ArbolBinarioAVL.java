package com.jdmg.proyectofinalprogra3josh;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jgald
 */
public class ArbolBinarioAVL {

    private NodoArbolAVL raiz;

    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    public void insertar(Vehiculos vehiculo) {
        raiz = insertarAVL(raiz, vehiculo);
    }

    //Para comparar duplicados y proteger al ABBAVL de los mismos , 
    public boolean insertarVehiculo(Vehiculos v) {
        if (BuscarVehiculoAVL(v.getPlaca()) != null) {
            return false; // Ya existe un vehículo con esa placa
        }
        insertar(v); // Inserta con balanceo AVL
        return true;
    }

    private NodoArbolAVL insertarAVL(NodoArbolAVL actual, Vehiculos nuevoVehiculo) {
        if (actual == null) {
            return new NodoArbolAVL(nuevoVehiculo);
        }

        int comparacion = nuevoVehiculo.getPlaca().compareTo(actual.vehiculo.getPlaca());

        if (comparacion < 0) {
            actual.izquierdo = insertarAVL(actual.izquierdo, nuevoVehiculo);
        } else if (comparacion > 0) {
            actual.derecho = insertarAVL(actual.derecho, nuevoVehiculo);
        } else {
            return actual; // No insertar duplicados
        }

        actualizarAlturaYFE(actual);

        // === Revisión de balance y rotaciones ===
        if (actual.fe < -1) {
            if (nuevoVehiculo.getPlaca().compareTo(actual.izquierdo.vehiculo.getPlaca()) < 0) {
                return rotacionDerecha(actual); // RD
            } else {
                actual.izquierdo = rotacionIzquierda(actual.izquierdo); // RI dentro de la izquierda
                return rotacionDerecha(actual); // RID
            }
        }

        if (actual.fe > 1) {
            if (nuevoVehiculo.getPlaca().compareTo(actual.derecho.vehiculo.getPlaca()) > 0) {
                return rotacionIzquierda(actual); // RI
            } else {
                actual.derecho = rotacionDerecha(actual.derecho); // RD dentro de la derecha
                return rotacionIzquierda(actual); // RDI
            }
        }

        return actual;
    }

    private void actualizarAlturaYFE(NodoArbolAVL nodo) {
        int alturaIzq = obtenerAltura(nodo.izquierdo);
        int alturaDer = obtenerAltura(nodo.derecho);

        nodo.altura = 1 + Math.max(alturaIzq, alturaDer);
        nodo.fe = alturaDer - alturaIzq;
    }

    private int obtenerAltura(NodoArbolAVL nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    //?Este método se usa solamente para cálculo temporal durante la eliminación, no sobrescribe el fe del nodo como lo hace actualizarAlturaYFE.
    private int calcularFE(NodoArbolAVL nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzq = obtenerAltura(nodo.izquierdo);
        int alturaDer = obtenerAltura(nodo.derecho);
        return alturaDer - alturaIzq;
    }

    // === ROTACIONES CON NOMBRES CLAROS ===
    // RI - Rotación Izquierda
    private NodoArbolAVL rotacionIzquierda(NodoArbolAVL nodoDesbalanceado) {
        NodoArbolAVL nuevoPadre = nodoDesbalanceado.derecho;
        NodoArbolAVL subArbolCentral = nuevoPadre.izquierdo;

        nuevoPadre.izquierdo = nodoDesbalanceado;
        nodoDesbalanceado.derecho = subArbolCentral;

        actualizarAlturaYFE(nodoDesbalanceado);
        actualizarAlturaYFE(nuevoPadre);

        return nuevoPadre;
    }

    // RD - Rotación Derecha
    private NodoArbolAVL rotacionDerecha(NodoArbolAVL nodoDesbalanceado) {
        NodoArbolAVL nuevoPadre = nodoDesbalanceado.izquierdo;
        NodoArbolAVL subArbolCentral = nuevoPadre.derecho;

        nuevoPadre.derecho = nodoDesbalanceado;
        nodoDesbalanceado.izquierdo = subArbolCentral;

        actualizarAlturaYFE(nodoDesbalanceado);
        actualizarAlturaYFE(nuevoPadre);

        return nuevoPadre;
    }

    // === BÚSQUEDA POR PLACA ===
    public NodoArbolAVL BuscarVehiculoAVL(String placa) {
        return buscarRecursivo(raiz, placa.toUpperCase());
    }

    private NodoArbolAVL buscarRecursivo(NodoArbolAVL nodo, String placa) {
        if (nodo == null) {
            return null;
        }

        int cmp = placa.compareTo(nodo.vehiculo.getPlaca());
        if (cmp == 0) {
            return nodo;
        } else if (cmp < 0) {
            return buscarRecursivo(nodo.izquierdo, placa);
        } else {
            return buscarRecursivo(nodo.derecho, placa);
        }
    }

    // === RECORRIDO INORDEN (Para JTable) ===
    public void inOrden(NodoArbolAVL nodo, java.util.List<Vehiculos> lista) {
        if (nodo != null) {
            inOrden(nodo.izquierdo, lista);
            lista.add(nodo.vehiculo);
            inOrden(nodo.derecho, lista);
        }
    }

    public boolean modificarDatosVehiculo(String placa) {
        NodoArbolAVL nodo = BuscarVehiculoAVL(placa);
        if (nodo == null) {
            return false;
        }

        Vehiculos v = nodo.vehiculo;

        try {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo propietario:", v.getNombrePropietario());
            String nuevoDPI = JOptionPane.showInputDialog("Nuevo DPI Propietario:", v.getDpi());
            String nuevaMarca = JOptionPane.showInputDialog("Nueva marca:", v.getMarca());
            String nuevoModelo = JOptionPane.showInputDialog("Nuevo modelo:", v.getModelo());
            int nuevoAnio = Integer.parseInt(JOptionPane.showInputDialog("Nuevo año:", v.getAnio()));
            int nuevasMultas = Integer.parseInt(JOptionPane.showInputDialog("Nuevas multas:", v.getCantidadMultas()));
            int nuevosTraspasos = Integer.parseInt(JOptionPane.showInputDialog("Nuevos traspasos:", v.getCantidadTraspasos()));

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

    public Vehiculos eliminarVehiculo(String placa) {
        Vehiculos[] eliminado = new Vehiculos[1];
        raiz = eliminarAVL(raiz, placa.toUpperCase(), eliminado);
        return eliminado[0]; // puede ser null si no se encontró
    }

    private NodoArbolAVL eliminarAVL(NodoArbolAVL nodo, String placa, Vehiculos[] eliminado) {
        if (nodo == null) {
            return null;
        }

        int cmp = placa.compareTo(nodo.vehiculo.getPlaca());

        if (cmp < 0) {
            nodo.izquierdo = eliminarAVL(nodo.izquierdo, placa, eliminado);
        } else if (cmp > 0) {
            nodo.derecho = eliminarAVL(nodo.derecho, placa, eliminado);
        } else {
            eliminado[0] = nodo.vehiculo; // Se encontró el nodo

            // Caso 1: Nodo hoja
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }

            // Caso 2: Un solo hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 3: Dos hijos – usar método separado obtenerReemplazo
            NodoArbolAVL reemplazo = obtenerReemplazo(nodo.derecho);
            nodo.vehiculo = reemplazo.vehiculo;
            nodo.derecho = eliminarAVL(nodo.derecho, reemplazo.vehiculo.getPlaca(), new Vehiculos[1]);
        }

        // Actualiza altura y balancea
        actualizarAlturaYFE(nodo);
        return reequilibrar(nodo);
    }

    private NodoArbolAVL obtenerReemplazo(NodoArbolAVL nodo) {
        NodoArbolAVL reemplazoPadre = nodo;
        NodoArbolAVL reemplazo = nodo;
        NodoArbolAVL actual = nodo;

        while (actual.izquierdo != null) {
            reemplazoPadre = reemplazo;
            reemplazo = actual.izquierdo;
            actual = actual.izquierdo;
        }

        return reemplazo;
    }

    private NodoArbolAVL reequilibrar(NodoArbolAVL nodo) {
        if (nodo.fe < -1) {
            if (calcularFE(nodo.izquierdo) <= 0) {
                return rotacionDerecha(nodo); // RD
            } else {
                nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
                return rotacionDerecha(nodo); // RID
            }
        }

        if (nodo.fe > 1) {
            if (calcularFE(nodo.derecho) >= 0) {
                return rotacionIzquierda(nodo); // RI
            } else {
                nodo.derecho = rotacionDerecha(nodo.derecho);
                return rotacionIzquierda(nodo); // RDI
            }
        }

        return nodo;
    }

    public boolean EstaVacio() {
        return raiz == null;
    }

   

    public void exportarAVL(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write("Departamento,Placa,DPI,Propietario,Marca,Modelo,Año,Multas,Traspasos");
            bw.newLine();
            List<Vehiculos> lista = new ArrayList<>();
            inOrden(raiz, lista);
            for (Vehiculos v : lista) {
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
            }
        }
    }

    /**
     * Encripta todos los Vehiculos en el AVL.
     */
    public void encryptAVL() {
        encryptNodoAVL(raiz);
    }

    private void encryptNodoAVL(NodoArbolAVL nodo) {
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
        encryptNodoAVL(nodo.izquierdo);
        encryptNodoAVL(nodo.derecho);
    }

    /**
     * Desencripta todos los Vehiculos en el AVL.
     */
    public void decryptAVL() {
        decryptNodoAVL(raiz);
    }

    private void decryptNodoAVL(NodoArbolAVL nodo) {
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

        decryptNodoAVL(nodo.izquierdo);
        decryptNodoAVL(nodo.derecho);
    }
}
