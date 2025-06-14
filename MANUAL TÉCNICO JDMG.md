# Proyecto SIRVE — Sistema Inteligente de Registro de Vehículos y Evaluación

**Autor:** Josué David Martínez Galdámez 
**Carnét:** 3090-23-8686
**Curso:** Programación III 
**Facultad:** Ingeniería en Sistemas, Universidad Mariano Gálvez Sede Mazatenango


## Índice

1. [Introducción](#introducción)  
2. [Tecnologías y Librerías](#tecnologías-y-librerías)  
3. [Arquitectura General](#arquitectura-general)  
4. [Modelo de Dominio](#modelo-de-dominio)  
5. [Estructuras de Datos](#estructuras-de-datos)  
   - ABB  
   - AVL  
   - Lista Doblemente Enlazada (Multas)  
   - Lista Circular Doblemente Enlazada (Traspasos)  
6. [Persistencia y Utilidades](#persistencia-y-utilidades)  
   - Gestor de Archivos  
   - Cronómetro  
   - CryptoUtils  
7. [Interfaz de Usuario (GUI)](#interfaz-de-usuario-gui)  
   - `ventanaPrincipal`  
   - `ventanaMultas`  
   - `ventanaTraspasos`  
   - Formularios de Inserción/Modificación  
8. [Flujo de Interacción](#flujo-de-interacción)  
9. [Compilación y Ejecución](#compilación-y-ejecución)  
10. [Cómo Contribuir](#cómo-contribuir)  

---

## 1. Introducción

Este documento describe en detalle la arquitectura, clases y métodos de la aplicación **SIRVE** (Sistema Inteligente de Registro de Vehículos y Evaluación). La aplicación, desarrollada en Java usando POO y Swing, implementa:

- **Árbol Binario de Búsqueda (ABB)**  
- **Árbol AVL** con balanceo automático  
- **Lista Doblemente Enlazada** para historial de multas  
- **Lista Circular Doblemente Enlazada** para historial de traspasos  
- **Persistencia** a archivo texto y exportación/importación  
- **Encriptación** César (shift=7) y desencriptación  
- **Interfaz Gráfica** con menús, tablas (`JTable`) y formularios (`JDialog`)  

El objetivo es ofrecer un sistema descentralizado que:
1. Carga y valida datos desde archivos .txt por departamentos.  
2. Permite operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre cada estructura.  
3. Mide tiempos de ejecución de cada operación (cronómetro).  
4. Exporta, encripta y recupera datos en su estado actual.  

---

## 2. Tecnologías y Librerías

Para llevar a cabo el proyecto, utilizamos:

| Librería / API        | Uso principal                                                                                                             |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------|
| **Java SE 23**        | Lenguaje de programación. Todas las clases, excepciones y estructuras.                                                    |
| **Swing**             | Framework de GUI: `JFrame`, `JPanel`, `JTable`, `JDialog`, `JOptionPane`, `JFileChooser`.                                 |
| **Maven**             | Gestión de dependencias y ciclo de vida de compilación (plugins, versiones, empaquetado `.jar`).                          |
| **Graphviz** (dot)    | Generación opcional de gráficos de árboles (exportar `.dot` y PNG).                                                       |
| **AbsoluteLayout**    | Layout manager externo (NetBeans) para posicionamiento absoluto de componentes en formularios.                            |

Y paquetes de Java estándar:

```java
import java.io.*;                  // File, FileReader/Writer, BufferedReader/Writer
import java.util.*;                // List, ArrayList, Map (LinkedHashMap)
import javax.swing.*;              // JFrame, JTable, JOptionPane, JFileChooser
import javax.swing.table.*;        // DefaultTableModel, TableCellRenderer, JTableHeader
```

## 3. Modelo de Dominio y Estructuras de Datos

### 3.1. Clase `Vehiculos`

Representa un vehículo con sus atributos principales:
```java
public class Vehiculos {
    private String departamento;
    private String placa;
    private String dpi;
    private String nombrePropietario;
    private String marca;
    private String modelo;
    private int anio;
    private int cantidadMultas;
    private int cantidadTraspasos;

    private ListaDobleMultas listaMultas;
    private ListaCircularTraspasos listaTraspasos;

    public Vehiculos(
            String departamento,
            String placa,
            String dpi,
            String nombrePropietario,
            String marca,
            String modelo,
            int anio,
            int cantidadMultas,
            int cantidadTraspasos) {
        this.departamento = departamento;
        this.placa = placa;
        this.dpi = dpi;
        this.nombrePropietario = nombrePropietario;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cantidadMultas = cantidadMultas;
        this.cantidadTraspasos = cantidadTraspasos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ListaDobleMultas getListaMultas() {
        return listaMultas;
    }

    public void setListaMultas(ListaDobleMultas listaMultas) {
        this.listaMultas = listaMultas;
    }

    public ListaCircularTraspasos getListaTraspasos() {
        return listaTraspasos;
    }

    public void setListaTraspasos(ListaCircularTraspasos listaTraspasos) {
        this.listaTraspasos = listaTraspasos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantidadMultas() {
        return cantidadMultas;
    }

    public void setCantidadMultas(int cantidadMultas) {
        this.cantidadMultas = cantidadMultas;
    }

    public int getCantidadTraspasos() {
        return cantidadTraspasos;
    }

    public void setCantidadTraspasos(int cantidadTraspasos) {
        this.cantidadTraspasos = cantidadTraspasos;
    }

    public Vehiculos clonar() {
    return new Vehiculos(
        this.departamento,
        this.placa,
        this.dpi,
        this.nombrePropietario,
        this.marca,
        this.modelo,
        this.anio,
        this.cantidadMultas,
        this.cantidadTraspasos
    );
}

    //Mostrar Datos Vehiculo
    @Override
    public String toString() {
        return "Vehículo ["
                + "Depto: " + departamento + ", "
                + "Placa: " + placa + ", "
                + "DPI: " + dpi + ", "
                + "Propietario: " + nombrePropietario + ", "
                + "Marca: " + marca + ", "
                + "Modelo: " + modelo + ", "
                + "Año: " + anio + ", "
                + "Multas: " + cantidadMultas + ", "
                + "Traspasos: " + cantidadTraspasos
                + "]";
    }
}

```
- departamento: provincia de origen.
- placa: clave única para búsquedas y orden.
- dpi y nombrePropietario: datos del dueño.
- marca, modelo, anio: descripción del vehículo.
- cantidadMultas, cantidadTraspasos: contadores que se van actualizando.

El método clonar() devuelve una copia profunda de Vehiculos para insertar en AVL sin enlazar al mismo objeto del ABB.

### 3.2. Clase `Multa`

Registro de una sanción de tráfico:
```java
public class Multa {
    private String departamento;
    private String placa;
    private String fecha;
    private String descripcion;
    private double monto;

    public Multa(String departamento, String placa, String fecha, String descripcion, double monto) {
        this.departamento = departamento;
        this.placa = placa;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    // Getters y setters
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    @Override
    public String toString() {
        return departamento + " | " + placa + " | " + fecha + " | " + descripcion + " | Q" + monto;
    }
}
```
-departamento: indica la procedencia de la multa.
-placa: referencia al vehículo sancionado.
-fecha, descripcion, monto: detalles de la infracción.


### 3.3. Clase `Traspaso`

Registro de una sanción de tráfico:
```java
public class Traspaso {

    private String departamento;
    private String placa;
    private String dpiAnterior;
    private String nombreAnterior;
    private String fecha;
    private String dpiNuevo;
    private String nombreNuevo;

    public Traspaso(String departamento, String placa, String dpiAnterior, String nombreAnterior,
            String fecha, String dpiNuevo, String nombreNuevo) {
        this.departamento = departamento;
        this.placa = placa;
        this.dpiAnterior = dpiAnterior;
        this.nombreAnterior = nombreAnterior;
        this.fecha = fecha;
        this.dpiNuevo = dpiNuevo;
        this.nombreNuevo = nombreNuevo;
    }

    
    // Getters y setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDpiAnterior() {
        return dpiAnterior;
    }

    public void setDpiAnterior(String dpiAnterior) {
        this.dpiAnterior = dpiAnterior;
    }

    public String getNombreAnterior() {
        return nombreAnterior;
    }

    public void setNombreAnterior(String nombreAnterior) {
        this.nombreAnterior = nombreAnterior;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDpiNuevo() {
        return dpiNuevo;
    }

    public void setDpiNuevo(String dpiNuevo) {
        this.dpiNuevo = dpiNuevo;
    }

    public String getNombreNuevo() {
        return nombreNuevo;
    }

    public void setNombreNuevo(String nombreNuevo) {
        this.nombreNuevo = nombreNuevo;
    }

    
    @Override
    public String toString() {
        return departamento + " | " + placa + " | " + dpiAnterior + " | " + nombreAnterior + " | "
                + fecha + " | " + dpiNuevo + " | " + nombreNuevo;
    }
}
```
-dpiAnterior, nombreAnterior, dpiNuevo, nombreNuevo: datos antes y después de la transferencia.
-fecha: momento en que se realiza el traspaso.

### 3.4. Árbol Binario de Búsqueda (ABB)

El **Árbol Binario de Búsqueda (ABB)** almacena objetos `Vehiculos` ordenados por su placa, lo que permite búsquedas, inserciones y eliminaciones en tiempo promedio O(log n).

```java
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    //Para comparar duplicados y proteger al ABB de los mismos , 
    public boolean insertarVehiculo(Vehiculos v) {
        if (BuscarVehiculoABB(v.getPlaca()) != null) {
            return false; // Ya existe una placa igual
        }
        AgregarVehiculo(v);
        return true;
    }

    // Inserta usando la placa como clave
    public void AgregarVehiculo(Vehiculos v) {
        NodoArbol nuevo = new NodoArbol(v);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;

            while (true) {
                padre = auxiliar;

                // Comparación por placa, ordenada alfabéticamente, si es menor va a la izquierda.
                if (v.getPlaca().compareTo(auxiliar.vehiculo.getPlaca()) < 0) {
                    auxiliar = auxiliar.HijoIzquierdo;
                    if (auxiliar == null) {
                        padre.HijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.HijoDerecho;
                    if (auxiliar == null) {
                        padre.HijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean EstaVacio() {
        return raiz == null;
    }

    // Búsqueda por placa
    public NodoArbol BuscarVehiculoABB(String placa) {
        NodoArbol auxiliar = raiz;

        while (auxiliar != null && !auxiliar.vehiculo.getPlaca().equals(placa)) {
            if (placa.compareTo(auxiliar.vehiculo.getPlaca()) < 0) {
                auxiliar = auxiliar.HijoIzquierdo;
            } else {
                auxiliar = auxiliar.HijoDerecho;
            }
        }
        return auxiliar;
    }

    public Vehiculos EliminarVehiculo(String placa) {
        NodoArbol actual = raiz;
        NodoArbol padre = null;
        boolean esHijoIzquierdo = true;

        // Buscar el nodo
        while (actual != null && !actual.vehiculo.getPlaca().equals(placa)) {
            padre = actual;
            if (placa.compareTo(actual.vehiculo.getPlaca()) < 0) {
                esHijoIzquierdo = true;
                actual = actual.HijoIzquierdo;
            } else {
                esHijoIzquierdo = false;
                actual = actual.HijoDerecho;
            }
        }

        if (actual == null) {
            return null; // No se encontró
        }

        Vehiculos eliminado = actual.vehiculo;

        // Caso 1: El nodo es una hoja
        if (actual.HijoIzquierdo == null && actual.HijoDerecho == null) {
            if (actual == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = null;
            } else {
                padre.HijoDerecho = null;
            }
        } // Caso 2: El nodo tiene un solo hijo (derecho)
        else if (actual.HijoIzquierdo == null) {
            if (actual == raiz) {
                raiz = actual.HijoDerecho;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = actual.HijoDerecho;
            } else {
                padre.HijoDerecho = actual.HijoDerecho;
            }
        } // Caso 2: El nodo tiene un solo hijo (izquierdo)
        else if (actual.HijoDerecho == null) {
            if (actual == raiz) {
                raiz = actual.HijoIzquierdo;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = actual.HijoIzquierdo;
            } else {
                padre.HijoDerecho = actual.HijoIzquierdo;
            }
        } // Caso 3: El nodo tiene dos hijos
        else {
            NodoArbol reemplazo = obtenerReemplazo(actual);
            if (actual == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.HijoIzquierdo = reemplazo;
            } else {
                padre.HijoDerecho = reemplazo;
            }
            reemplazo.HijoIzquierdo = actual.HijoIzquierdo;
        }

        return eliminado;
    }

    private NodoArbol obtenerReemplazo(NodoArbol nodoReemplazar) {
        NodoArbol reemplazoPadre = nodoReemplazar;
        NodoArbol reemplazo = nodoReemplazar;
        NodoArbol actual = nodoReemplazar.HijoDerecho;

        while (actual != null) {
            reemplazoPadre = reemplazo;
            reemplazo = actual;
            actual = actual.HijoIzquierdo;
        }

        if (reemplazo != nodoReemplazar.HijoDerecho) {
            reemplazoPadre.HijoIzquierdo = reemplazo.HijoDerecho;
            reemplazo.HijoDerecho = nodoReemplazar.HijoDerecho;
        }

        return reemplazo;
    }

    public void generarDotABB(NodoArbol nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            String etiqueta = nodo.vehiculo.getPlaca();
            writer.write("\"" + etiqueta + "\" [label=\"" + etiqueta + "\"];\n");

            if (nodo.HijoIzquierdo != null) {
                writer.write("\"" + etiqueta + "\" -> \"" + nodo.HijoIzquierdo.vehiculo.getPlaca() + "\";\n");
                generarDotABB(nodo.HijoIzquierdo, writer);
            }

            if (nodo.HijoDerecho != null) {
                writer.write("\"" + etiqueta + "\" -> \"" + nodo.HijoDerecho.vehiculo.getPlaca() + "\";\n");
                generarDotABB(nodo.HijoDerecho, writer);
            }
        }
    }

    public void exportarABBComoImagen(ArbolBinario arbolito) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("arbolABB.dot"));
            writer.write("digraph G {\n");
            writer.write("node [shape=ellipse, style=filled, color=lightblue];\n");
            generarDotABB(arbolito.raiz, writer);
            writer.write("}\n");
            writer.close();

            // Ejecutar Graphviz para generar PNG
            Process p = Runtime.getRuntime().exec("dot -Tpng arbolABB.dot -o arbolABB.png");
            p.waitFor();

            // Mostrar imagen generada
            Desktop.getDesktop().open(new File("arbolABB.png"));
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el gráfico: " + e.getMessage());
        }
    }

    //EXPORTAR PARA .TXT
    public void exportarABB(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // encabezado
            bw.write("Departamento,Placa,DPI,Propietario,Marca,Modelo,Año,Multas,Traspasos");
            bw.newLine();
            exportarNodoABB(raiz, bw);
        }
    }

    //EXPORTAR PARA .TXT
    private void exportarNodoABB(NodoArbol nodo, BufferedWriter bw) throws IOException {
        if (nodo == null) {
            return;
        }
        exportarNodoABB(nodo.HijoIzquierdo, bw);
        Vehiculos v = nodo.vehiculo;
        bw.write(String.join(",",
                v.getDepartamento(),
                v.getPlaca(),
                v.getDpi(),
                v.getNombrePropietario(),
                v.getMarca(),
                v.getModelo(),
                String.valueOf(v.getAnio()),
                String.valueOf(v.getCantidadMultas()),
                String.valueOf(v.getCantidadTraspasos())
        ));
        bw.newLine();
        exportarNodoABB(nodo.HijoDerecho, bw);
    }

    public void importarABBEDesdeArchivo(File archivo, ArbolBinario abb) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) { // descarta encabezado
                    primera = false;
                    continue;
                }
                String[] p = linea.split(",");
                if (p.length >= 9) {
                    Vehiculos v = new Vehiculos(
                            p[0],
                            p[1],
                            p[2],
                            p[3],
                            p[4],
                            p[5],
                            Integer.parseInt(p[6]),
                            Integer.parseInt(p[7]),
                            Integer.parseInt(p[8])
                    );
                    abb.insertarVehiculo(v);
                }
            }
        }
    }

    /**
     * Recorre todo el ABB y encripta todos los campos String de cada Vehiculos.
     */
    public void encryptABB() {
        encryptNodo(raiz);
    }

    private void encryptNodo(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        Vehiculos v = nodo.vehiculo;
        v.setDepartamento(CryptoUtils.encrypt(v.getDepartamento()));
        v.setPlaca(CryptoUtils.encrypt(v.getPlaca()));
        v.setDpi(CryptoUtils.encrypt(v.getDpi()));
        v.setNombrePropietario(CryptoUtils.encrypt(v.getNombrePropietario()));
        v.setMarca(CryptoUtils.encrypt(v.getMarca()));
        v.setModelo(CryptoUtils.encrypt(v.getModelo()));
        // encriptar año
        String sAnio = Integer.toString(v.getAnio());
        v.setAnio(Integer.parseInt(CryptoUtils.encrypt(sAnio)));

        // encriptar cantidadMultas
        String sMultas = Integer.toString(v.getCantidadMultas());
        v.setCantidadMultas(Integer.parseInt(CryptoUtils.encrypt(sMultas)));

        // encriptar cantidadTraspasos
        String sTrans = Integer.toString(v.getCantidadTraspasos());
        v.setCantidadTraspasos(Integer.parseInt(CryptoUtils.encrypt(sTrans)));
        encryptNodo(nodo.HijoIzquierdo);
        encryptNodo(nodo.HijoDerecho);
    }

    /**
     * Recorre todo el ABB y desencripta todos los campos String de cada
     * Vehiculos.
     */
    public void decryptABB() {
        decryptNodo(raiz);
    }

    private void decryptNodo(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        Vehiculos v = nodo.vehiculo;
        v.setDepartamento(CryptoUtils.decrypt(v.getDepartamento()));
        v.setPlaca(CryptoUtils.decrypt(v.getPlaca()));
        v.setDpi(CryptoUtils.decrypt(v.getDpi()));
        v.setNombrePropietario(CryptoUtils.decrypt(v.getNombrePropietario()));
        v.setMarca(CryptoUtils.decrypt(v.getMarca()));
        v.setModelo(CryptoUtils.decrypt(v.getModelo()));
        // desencriptar año
        v.setAnio(Integer.parseInt(CryptoUtils.decrypt(Integer.toString(v.getAnio()))));
        // desencriptar multas
        v.setCantidadMultas(Integer.parseInt(CryptoUtils.decrypt(Integer.toString(v.getCantidadMultas()))));
        // desencriptar traspasos
        v.setCantidadTraspasos(Integer.parseInt(CryptoUtils.decrypt(Integer.toString(v.getCantidadTraspasos()))));

        decryptNodo(nodo.HijoIzquierdo);
        decryptNodo(nodo.HijoDerecho);
    }
}
```
-InsertarVehiculo: evita duplicados.
-BuscarVehiculo: iterativo, compara placas.
-EliminarVehiculo: maneja los cuatro casos (hoja, un hijo, dos hijos).
-inOrden: vuelca los vehículos en orden ascendente de placas.



