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
| **Maven**             | Gestión de dependencias y ciclo de vida de compilación (plugins, versiones, empaquetado `.jar`).                         |
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
    // + getters/setters, toString(), clonar()
}
```
- departamento: provincia de origen.
- placa: clave única para búsquedas y orden.
- dpi y nombrePropietario: datos del dueño.
- marca, modelo, anio: descripción del vehículo.
- cantidadMultas, cantidadTraspasos: contadores que se van actualizando.

El método clonar() devuelve una copia profunda de Vehiculos para insertar en AVL sin enlazar al mismo objeto del ABB.

