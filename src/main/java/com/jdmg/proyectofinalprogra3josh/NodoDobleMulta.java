package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
public class NodoDobleMulta {

    public Multa multa;
    public NodoDobleMulta siguiente, anterior;

    public NodoDobleMulta(Multa multa) {
        this(multa, null, null);
    }

    public NodoDobleMulta(Multa multa, NodoDobleMulta sig, NodoDobleMulta ant) {
        this.multa = multa;
        this.siguiente = sig;
        this.anterior = ant;
    }
}
