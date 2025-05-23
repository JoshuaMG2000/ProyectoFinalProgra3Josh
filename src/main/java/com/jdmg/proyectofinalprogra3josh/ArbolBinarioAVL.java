package com.jdmg.proyectofinalprogra3josh;

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
        if (buscar(v.getPlaca()) != null) {
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
    public NodoArbolAVL buscar(String placa) {
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
        NodoArbolAVL nodo = buscar(placa);
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

}
