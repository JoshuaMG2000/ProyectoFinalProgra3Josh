
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

    // Eliminación se puede adaptar también si lo necesitas más adelante
}
