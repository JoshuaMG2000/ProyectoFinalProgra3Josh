package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import java.io.*;
import java.util.*;

public class GestorArchivos {

    public List<Vehiculos> leerVehiculos(String rutaArchivo) {
        List<Vehiculos> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false; // Saltar encabezado
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length >= 8) {
                    Vehiculos v = new Vehiculos(
                            partes[0], // Placa
                            partes[1], // DPI
                            partes[2], // Nombre
                            partes[3], // Marca
                            partes[4], // Modelo
                            Integer.parseInt(partes[5]), // Año
                            Integer.parseInt(partes[6]), // Multas
                            Integer.parseInt(partes[7]) // Traspasos
                    );
                    lista.add(v);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}
