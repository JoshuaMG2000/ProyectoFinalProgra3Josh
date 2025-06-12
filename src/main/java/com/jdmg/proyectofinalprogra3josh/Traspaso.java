package com.jdmg.proyectofinalprogra3josh;

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
