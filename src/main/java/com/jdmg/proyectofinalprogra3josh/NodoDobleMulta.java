package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
public class NodoDobleMulta {

    public Vehiculos vehiculo;
    public NodoDobleMulta siguiente, anterior;

    public NodoDobleMulta(Vehiculos v) {
        this(v, null, null);
    }

    public NodoDobleMulta(Vehiculos v, NodoDobleMulta s, NodoDobleMulta a) {
        vehiculo = v;
        siguiente = s;
        anterior = a;
    }
}
