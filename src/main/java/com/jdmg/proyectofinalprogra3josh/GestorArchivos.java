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

    Cronometro cronometro = new Cronometro();

    public void cargarTodoDesdeCarpeta(String rutaBase, ArbolBinario abb, ArbolBinarioAVL avl) {
        System.out.println("📂 Iniciando carga desde carpeta: " + rutaBase);

        File base = new File(rutaBase);
        if (!base.isDirectory()) {
            JOptionPane.showMessageDialog(null, "❌ La ruta seleccionada no es una carpeta válida.");
            return;
        }

        int totalArchivos = 0;
        int totalVehiculos = 0;

        // Usamos LinkedHashMap para mantener el orden de inserción
        Map<String, Integer> resumenPorDepartamento = new LinkedHashMap<>();
        cronometro.iniciar();
        for (File carpetaDepto : base.listFiles(File::isDirectory)) {
            String nombreDepto = carpetaDepto.getName();
            int contadorDepto = 0;

            for (File archivo : carpetaDepto.listFiles()) {
                if (archivo.isFile() && archivo.getName().toLowerCase().endsWith("_vehiculos.txt")) {
                    totalArchivos++;

                    List<Vehiculos> lista = leerVehiculosConDepto(archivo.getAbsolutePath(), nombreDepto);
                    contadorDepto += lista.size();  // total de vehículos de este archivo
                    totalVehiculos += lista.size(); // acumulado general

                    for (Vehiculos v : lista) {
                        if (abb.insertarVehiculo(v)) {
                        }
                        if (avl.insertarVehiculo(v)) {
                        }
                    }
                }
            }

            // Solo agrega si hubo vehículos
            if (contadorDepto > 0) {
                resumenPorDepartamento.put(nombreDepto, contadorDepto);
            }
        }

        // === Generar resumen para JOptionPane ===
        StringBuilder mensaje = new StringBuilder("📋 RESUMEN DE CARGA DE VEHÍCULOS\n\n");

        for (Map.Entry<String, Integer> entry : resumenPorDepartamento.entrySet()) {
            mensaje.append("📍 ").append(entry.getKey())
                    .append(": ").append(entry.getValue()).append(" vehículos\n");
        }

        mensaje.append("\n🗂 Total archivos leídos: ").append(totalArchivos);
        mensaje.append("\n🚗 Total vehículos insertados: ").append(totalVehiculos);
        cronometro.detener();
        JOptionPane.showMessageDialog(null, mensaje.toString(), "✅ Carga Completada" , JOptionPane.INFORMATION_MESSAGE);
         JOptionPane.showMessageDialog(null, cronometro.detenerComoTexto(), null, JOptionPane.INFORMATION_MESSAGE);
    }

// Variantede leerVehiculos que incluye departamento
    public List<Vehiculos> leerVehiculosConDepto(String rutaArchivo, String departamento) {
        List<Vehiculos> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimera = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false;
                    continue; // saltar encabezado
                }

                String[] p = linea.split(",");
                if (p.length >= 8) {
                    Vehiculos v = new Vehiculos(
                            departamento,
                            p[0], p[1], p[2], p[3], p[4],
                            Integer.parseInt(p[5]),
                            Integer.parseInt(p[6]),
                            Integer.parseInt(p[7])
                    );
                    lista.add(v);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + rutaArchivo + " -> " + e.getMessage());
        }

        return lista;
    }

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
                if (partes.length >= 9) {
                    Vehiculos v = new Vehiculos(
                            partes[0], // Departamento
                            partes[1], // Placa
                            partes[2], // DPI
                            partes[3], // Nombre
                            partes[4], // Marca
                            partes[5], // Modelo
                            Integer.parseInt(partes[6]), // Año
                            Integer.parseInt(partes[7]), // Multas
                            Integer.parseInt(partes[8]) // Traspasos
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
