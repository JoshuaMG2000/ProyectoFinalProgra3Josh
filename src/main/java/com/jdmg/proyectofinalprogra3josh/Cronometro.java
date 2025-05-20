package com.jdmg.proyectofinalprogra3josh;

public class Cronometro {

    private long inicio;

    public void iniciar() {
        inicio = System.currentTimeMillis();
    }

    public long detener() {
        return System.currentTimeMillis() - inicio;
    }

    public String detenerComoTexto() {
        long ms = detener();
        return "Tiempo transcurrido: " + ms + " ms";
    }
}
