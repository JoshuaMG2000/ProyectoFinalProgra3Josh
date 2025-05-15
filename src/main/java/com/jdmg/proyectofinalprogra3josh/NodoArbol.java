/**
 *
 * @author jgald
 */
package com.jdmg.proyectofinalprogra3josh;

public class NodoArbol {
    Vehiculos vehiculo;
    NodoArbol HijoIzquierdo, HijoDerecho;

    public NodoArbol(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
        this.HijoIzquierdo = null;
        this.HijoDerecho = null;
    }

    @Override
    public String toString() {
        return vehiculo.toString(); // Usa el toString del vehículo
    }
}
