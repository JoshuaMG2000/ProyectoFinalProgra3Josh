package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class GestorArchivos {

    Cronometro cronometro = new Cronometro();

    // Método que carga vehículos desde múltiples carpetas (una por departamento)
    public void cargarTodoDesdeCarpeta(String rutaBase, ArbolBinario abb, ArbolBinarioAVL avl,
            ListaDobleMultas listaMultas, ListaCircularTraspasos listaTraspasos) {
        // Se crea un objeto File con la ruta que recibe como parámetro
        File carpetaPrincipal = new File(rutaBase);
        // Si la ruta no es una carpeta, muestra error y sale del método
        if (!carpetaPrincipal.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Ruta no válida.");
            return;
        }
        // Variables para llevar la cuenta de archivos leídos y vehículos insertados
        int totalArchivos = 0;
        int totalVehiculos = 0;
        int totalMultas = 0;
        int totalTraspasos = 0;

        // Mensaje acumulado por departamentos
        StringBuilder resumenPorDeptos = new StringBuilder("📋 RESUMEN POR DEPARTAMENTO:\n\n");

        // Recorre cada subcarpeta dentro de la carpeta principal (una por cada departamento)
        cronometro.iniciar();
        for (File carpeta : carpetaPrincipal.listFiles()) {
            if (!carpeta.isDirectory()) {// si no es carpeta, la ignora
                continue;
            }

            // Obtiene el nombre del departamento desde el nombre de la carpeta
            String nombreDepto = carpeta.getName();
            int contadorDepto = 0;
            int contadorDeptoMultas = 0;
            int contadorDeptoTraspasos = 0;

            //VEHICULOS
            // Recorre cada archivo dentro de esa subcarpeta
            for (File archivo : carpeta.listFiles()) {
                // Solo procesa archivos que terminan en "_vehiculos.txt"
                if (archivo.getName().endsWith("_vehiculos.txt")) {
                    totalArchivos++;// suma archivo leído

                    // Lee los vehículos desde el archivo, asociando el nombre del departamento
                    List<Vehiculos> lista = leerVehiculosConDepto(archivo.getAbsolutePath(), nombreDepto);
                    contadorDepto += lista.size();  // Total por este departamento
                    totalVehiculos += lista.size(); // Total general

                    // Inserta cada vehículo tanto en el ABB como en el AVL , antes hacía el mismo vehiculo para cada uno misma referencia del contenido
                    //Perdo despues el Inge me comento que tenian que ser separados independientes.
                    for (Vehiculos v : lista) {
                        abb.insertarVehiculo(v);              // Original
                        avl.insertarVehiculo(v.clonar());     // Copia separada
                    }
                } //MULTAS 
                else if (archivo.getName().endsWith("_multas.txt")) {
                    List<Multa> lista = leerMultasConDepto(archivo.getAbsolutePath(), nombreDepto);
                    contadorDeptoMultas += lista.size();
                    totalMultas += lista.size();

                    for (Multa m : lista) {
                        listaMultas.agregarAlFinal(m);
                    }

                } else if (archivo.getName().endsWith("_traspasos.txt")) {
                    List<Traspaso> lista = leerTraspasosConDepto(archivo.getAbsolutePath(), nombreDepto);
                    contadorDeptoTraspasos += lista.size();
                    totalTraspasos += lista.size();

                    for (Traspaso t : lista) {
                        listaTraspasos.insertarAlFinal(t);
                    }
                }
            }
            // Si el departamento tiene al menos un vehículo cargado...
            if (contadorDepto > 0) {
                // Agrega al mensaje un resumen de ese departamento: ejemplo "📍 Chimaltenango: 50 vehículos"
                resumenPorDeptos.append("📍 ").append(nombreDepto).append(": ")
                        .append(contadorDepto).append(" vehículos\n");
            }
            if (contadorDeptoMultas > 0) {
                resumenPorDeptos.append("   ↪ Multas: ").append(contadorDeptoMultas).append("\n");
            }

            if (contadorDeptoTraspasos > 0) {
                resumenPorDeptos.append("   ↪ Traspasos: ").append(contadorDeptoTraspasos).append("\n");
            }

        }

        // Al final del recorrido de todos los departamentos:
        resumenPorDeptos.append("\n🗂 Total archivos leídos: ").append(totalArchivos);
        // Agrega al mensaje el total de archivos leídos, ejemplo: "🗂 Total archivos leídos: 10"

        // Agrega al mensaje el total general de vehículos insertados, ejemplo: "🚗 Total vehículos insertados: 850"
        resumenPorDeptos.append("\n🚗 Total vehículos insertados: ").append(totalVehiculos);

        resumenPorDeptos.append("\n💸 Total multas insertadas: ").append(totalMultas);
        resumenPorDeptos.append("\n🔄 Total traspasos insertados: ").append(totalTraspasos);

        // Muestra un resumen al finalizar la carga
        JOptionPane.showMessageDialog(null, resumenPorDeptos.toString() + "\n\n" + cronometro.detenerComoTexto(), "✅ Carga Completada", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Traspaso> leerTraspasosConDepto(String rutaArchivo, String departamento) {
        List<Traspaso> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) {
                    primera = false;
                    continue; // Saltar encabezado
                }

                String[] p = linea.split(",");
                if (p.length >= 6) {
                    Traspaso t = new Traspaso(
                            departamento,
                            p[0], // placa
                            p[1], // DPI anterior
                            p[2], // nombre anterior
                            p[3], // fecha
                            p[4], // DPI nuevo
                            p[5] // nombre nuevo
                    );
                    lista.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo de traspasos: " + rutaArchivo + " -> " + e.getMessage());
        }

        return lista;
    }

    // leerVehiculos que incluye departamento
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

    public List<Multa> leerMultasConDepto(String rutaArchivo, String departamento) {
        List<Multa> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) {
                    primera = false;
                    continue;
                }

                String[] p = linea.split(",");
                if (p.length >= 4) {
                    Multa m = new Multa(
                            departamento,
                            p[0], // placa
                            p[1], // fecha
                            p[2], // descripcion
                            Double.parseDouble(p[3]) // monto
                    );
                    lista.add(m);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo de multas: " + rutaArchivo + " -> " + e.getMessage());
        }

        return lista;
    }

}


/*
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
                if (arbolito.BuscarVehiculoABB(v.getPlaca()) == null) {
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
                if (arbolitoAVL.BuscarVehiculoAVL(v.getPlaca()) == null) {
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
 */
 /*
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
 */
