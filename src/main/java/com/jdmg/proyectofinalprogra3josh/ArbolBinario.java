
package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
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
    public NodoArbol BuscarVehiculo(String placa) {
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
    }
    // Caso 2: El nodo tiene un solo hijo (derecho)
    else if (actual.HijoIzquierdo == null) {
        if (actual == raiz) {
            raiz = actual.HijoDerecho;
        } else if (esHijoIzquierdo) {
            padre.HijoIzquierdo = actual.HijoDerecho;
        } else {
            padre.HijoDerecho = actual.HijoDerecho;
        }
    }
    // Caso 2: El nodo tiene un solo hijo (izquierdo)
    else if (actual.HijoDerecho == null) {
        if (actual == raiz) {
            raiz = actual.HijoIzquierdo;
        } else if (esHijoIzquierdo) {
            padre.HijoIzquierdo = actual.HijoIzquierdo;
        } else {
            padre.HijoDerecho = actual.HijoIzquierdo;
        }
    }
    // Caso 3: El nodo tiene dos hijos
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

}
