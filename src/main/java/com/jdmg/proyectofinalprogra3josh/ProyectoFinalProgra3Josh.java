package com.jdmg.proyectofinalprogra3josh;

public class ProyectoFinalProgra3Josh {

    public static void main(String[] args) {
        // Solo esto es necesario: ejecuta el JFrame en el hilo de interfaz gráfica (Swing)
        javax.swing.SwingUtilities.invokeLater(() -> {
            new ventanaPrincipal().setVisible(true);
        });
    }
}
