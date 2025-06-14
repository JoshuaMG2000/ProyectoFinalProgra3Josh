# Proyecto SIRVE — Sistema Inteligente de Registro de Vehículos y Evaluación

**Autor:** Josué David Martínez Galdámez 
**Curso:** Programación III 
**Facultad:** Ingeniería en Sistemas, Universidad Mariano Gálvez Sede Mazatenango

---

## 1. Introducción

En este proyecto he desarrollado una aplicación de escritorio en **Java Swing** que permite:
- Registrar y gestionar vehículos utilizando **Árboles Binarios de Búsqueda (ABB)** y **Árboles AVL**.
- Asociar a cada vehículo su **historial de multas** (Lista Doblemente Enlazada) y **historial de traspasos** (Lista Circular Doblemente Enlazada).
- Medir tiempos de operación con la clase `Cronometro`.
- Exportar e importar datos en texto plano, así como encriptar/desencriptar su contenido con **Cifrado César**.
- Visualizar gráﬁcos de los árboles usando **Graphviz**.

### 1.1 Tecnologías y librerías

- **Java SE 23**: lenguaje y API principal.
- **Swing**: construcción de la interfaz de usuario (ventanas, diálogos, tablas).
- **Graphviz**: generación de gráﬁcos de estructuras de datos (DOT → PNG).
- **Maven**: gestión de dependencias y compilación.
- **AbsoluteLayout** (NetBeans): diseño de formularios.

## 2. Arquitectura General

El proyecto se organiza en tres capas principales:

1. **Modelo de Dominio**  
   Clases que representan entidades: `Vehiculos`, `Multa`, `Traspaso`.

2. **Estructuras de Datos**  
   - ABB: `ArbolBinario` y `NodoArbol`.  
   - AVL: `ArbolBinarioAVL` y `NodoArbolAVL`.  
   - Lista Doblemente Enlazada: `ListaDobleMultas` y `NodoDobleMulta`.  
   - Lista Circular Doblemente Enlazada: `ListaCircularTraspasos` y `NodoCircularTraspaso`.  

3. **Persistencia y Lógica de Negocio**  
   - `GestorArchivos`: carga/exporta datos desde archivos de texto.  
   - `CryptoUtils`: métodos de encriptación / desencriptación César.  
   - `Cronometro`: mide tiempos en milisegundos.

4. **Vista (GUI)**  
   - Ventanas principales y formularios (package `com.jdmg.proyectofinalprogra3josh`):  
     `ventanaPrincipal`, `ventanaMultas`, `ventanaTraspasos`, y sus formularios de CRUD.


