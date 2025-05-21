package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
public class NodoArbolAVL {

    Vehiculos vehiculo;
    int altura;
    int fe; // factor de equilibrio: altura derecha - altura izquierda
    NodoArbolAVL izquierdo;
    NodoArbolAVL derecho;

    public NodoArbolAVL(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
        this.altura = 1;
        this.fe = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return vehiculo.toString(); // Usa el toString del vehículo
    }
}
