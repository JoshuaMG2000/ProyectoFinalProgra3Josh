package com.jdmg.proyectofinalprogra3josh;

public class NodoCircularTraspaso {

    public Traspaso traspaso;
    public NodoCircularTraspaso siguiente;
    public NodoCircularTraspaso anterior;

    public NodoCircularTraspaso(Traspaso t) {
        this.traspaso = t;
        this.siguiente = this;
        this.anterior = this;
    }

    public Traspaso getTraspaso() {
        return traspaso;
    }

    public void setTraspaso(Traspaso traspaso) {
        this.traspaso = traspaso;
    }

    public NodoCircularTraspaso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularTraspaso siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircularTraspaso getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircularTraspaso anterior) {
        this.anterior = anterior;
    }
    
    
}
