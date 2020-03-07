/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alex
 */
public class Medicamento {
    private int idMedicamento;
    private String nombre;
    private int precio;
    private int gramos;
    private int laboratorio;
    private Laboratorio laboratorioID;
    private String fechaRecepcion;

    public Medicamento() {
    }

    public Medicamento(int idMedicamento, String nombre, int precio, int gramos, int laboratorio, Laboratorio laboratorioID, String fechaRecepcion) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.precio = precio;
        this.gramos = gramos;
        this.laboratorio = laboratorio;
        this.laboratorioID = laboratorioID;
        this.fechaRecepcion = fechaRecepcion;
    }

    public Medicamento(int idMedicamento, String nombre, int precio, int gramos, Laboratorio laboratorioID, String fechaRecepcion) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.precio = precio;
        this.gramos = gramos;
        this.laboratorioID = laboratorioID;
        this.fechaRecepcion = fechaRecepcion;
    }

    public Medicamento(String nombre, int precio, int gramos, int laboratorio, String fechaRecepcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.gramos = gramos;
        this.laboratorio = laboratorio;
        this.fechaRecepcion = fechaRecepcion;
    }

    public Medicamento(String nombre, int precio, int gramos, Laboratorio laboratorioID, String fechaRecepcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.gramos = gramos;
        this.laboratorioID = laboratorioID;
        this.fechaRecepcion = fechaRecepcion;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Laboratorio getLaboratorioID() {
        return laboratorioID;
    }

    public void setLaboratorioID(Laboratorio laboratorioID) {
        this.laboratorioID = laboratorioID;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "idMedicamento=" + idMedicamento + ", nombre=" + nombre + ", precio=" + precio + ", gramos=" + gramos + ", laboratorio=" + laboratorio + ", laboratorioID=" + laboratorioID + ", fechaRecepcion=" + fechaRecepcion + '}';
    }

    
    
    
}
