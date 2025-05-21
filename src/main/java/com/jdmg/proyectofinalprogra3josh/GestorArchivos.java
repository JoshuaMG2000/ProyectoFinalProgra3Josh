package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    public void cargarVehiculosDesdeArchivoABB(ArbolBinario arbolito) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo de vehículos");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = archivoSeleccionado.getAbsolutePath();

            List<Vehiculos> listaVehiculos = leerVehiculos(ruta);
            int cargados = 0;
            int duplicados = 0;

            for (Vehiculos v : listaVehiculos) {
                if (arbolito.BuscarVehiculo(v.getPlaca()) == null) {
                    arbolito.AgregarVehiculo(v);
                    cargados++;
                } else {
                    duplicados++;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Vehículos cargados: " + cargados + "\nPlacas duplicadas ignoradas: " + duplicados,
                    "Resultado de carga", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
        }
    }

    public void cargarVehiculosDesdeArchivoAVL(ArbolBinarioAVL arbolitoAVL) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo de vehículos");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = archivoSeleccionado.getAbsolutePath();

            List<Vehiculos> listaVehiculos = leerVehiculos(ruta);  // Asegúrate de que este método exista
            int cargados = 0;
            int duplicados = 0;

            for (Vehiculos v : listaVehiculos) {
                if (arbolitoAVL.buscar(v.getPlaca()) == null) {
                    arbolitoAVL.insertar(v);
                    cargados++;
                } else {
                    duplicados++;
                }
            }
            JOptionPane.showMessageDialog(null,
                    "Vehículos cargados: " + cargados + "\nPlacas duplicadas ignoradas: " + duplicados,
                    "Resultado de carga", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
        }
    }

}
