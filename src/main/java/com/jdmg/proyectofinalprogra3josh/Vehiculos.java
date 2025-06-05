package com.jdmg.proyectofinalprogra3josh;

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
