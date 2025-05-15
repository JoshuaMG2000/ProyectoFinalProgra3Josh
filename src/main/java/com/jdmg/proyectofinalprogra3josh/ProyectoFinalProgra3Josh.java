package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import java.util.List;

public class ProyectoFinalProgra3Josh {

    public static void main(String[] args) {
        int opcion = 0;
        ArbolBinario arbolito = new ArbolBinario();
        GestorArchivos gestor = new GestorArchivos();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar Vehículo Manualmente\n"
                        + "2. Cargar Vehículos desde Archivo\n"
                        + "3. Recorrer el Árbol InOrden\n"
                        + "4. Recorrer el Árbol PreOrden\n"
                        + "5. Recorrer el Árbol PostOrden\n"
                        + "6. Buscar Vehículo por Placa\n"
                        + "7. Salir\n"
                        + "Elige una Opción...", "SIRVE - Sistema Vehicular", JOptionPane.QUESTION_MESSAGE));

                switch (opcion) {
                    case 1:
                        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo");
                        String dpi = JOptionPane.showInputDialog("Ingrese el DPI del propietario");
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario");
                        String marca = JOptionPane.showInputDialog("Ingrese la marca");
                        String modelo = JOptionPane.showInputDialog("Ingrese el modelo");
                        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año"));
                        int multas = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de multas"));
                        int traspasos = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de traspasos"));

                        Vehiculos nuevo = new Vehiculos(placa, dpi, nombre, marca, modelo, anio, multas, traspasos);
                        arbolito.AgregarVehiculo(nuevo);
                        break;

                    case 2:
                        String ruta = JOptionPane.showInputDialog("Ingrese la ruta del archivo .txt");
                        List<Vehiculos> listaVehiculos = gestor.leerVehiculos(ruta);
                        for (Vehiculos v : listaVehiculos) {
                            arbolito.AgregarVehiculo(v);
                        }
                        JOptionPane.showMessageDialog(null, "Vehículos cargados: " + listaVehiculos.size());
                        break;

                    case 3:
                        if (!arbolito.EstaVacio()) {
                            System.out.println("Recorrido InOrden:");
                            arbolito.InOrden(arbolito.raiz);
                        }
                        break;

                    case 4:
                        if (!arbolito.EstaVacio()) {
                            System.out.println("Recorrido PreOrden:");
                            arbolito.PreOrden(arbolito.raiz);
                        }
                        break;

                    case 5:
                        if (!arbolito.EstaVacio()) {
                            System.out.println("Recorrido PostOrden:");
                            arbolito.PostOrden(arbolito.raiz);
                        }
                        break;

                    case 6:
                        if (!arbolito.EstaVacio()) {
                            String buscarPlaca = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar");
                            NodoArbol resultado = arbolito.BuscarVehiculo(buscarPlaca);
                            if (resultado != null) {
                                JOptionPane.showMessageDialog(null, "Vehículo encontrado:\n" + resultado.vehiculo.toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío.");
                        }
                        break;

                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicación Finalizada");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción Incorrecta");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }

        } while (opcion != 7);
    }
}
