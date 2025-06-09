package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return departamento + " | " + placa + " | " + fecha + " | " + descripcion + " | Q" + monto;
    }
}
