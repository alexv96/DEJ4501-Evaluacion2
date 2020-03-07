/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import controlador.LaboratorioService;
import interfaz.IMedicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import modelo.Laboratorio;
import modelo.Medicamento;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Alex
 */
public class MedicamentoDAO implements IMedicamento{
    
    private Connection conexion;
    
    public MedicamentoDAO() {
        this.conexion = new Conexion().getConexion();
    }

    @Override
    public List<Medicamento> listarMedicamentos() {
        String sql = "SELECT * FROM MEDICAMENTO";
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("idmedicamento");
                String nombre = rs.getString("nombre_medicamento");
                int precio = rs.getInt("precio");
                int gramos = rs.getInt("gramos");
                int laboratorioSelect = rs.getInt("laboratorio");
                String fecha = rs.getString("fecha_recepcion");
                
                LaboratorioService laboratorioServicio = new LaboratorioService();
                Laboratorio laboratorio = laboratorioServicio.buscarLaboratorio(laboratorioSelect);
                
                medicamentos.add(new Medicamento(id, nombre, precio, gramos, laboratorio, fecha));
            }
            return medicamentos;
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean addMedicamento(Medicamento med) {
        String sql = "INSERT INTO MEDICAMENTO(nombre_medicamento,precio,gramos,laboratorio,fecha_recepcion) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, med.getNombre());
            stmt.setInt(2, med.getPrecio());
            stmt.setInt(3, med.getGramos());
            stmt.setInt(4, med.getLaboratorio());
            stmt.setString(5, med.getFechaRecepcion());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas>0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean deleteMedicamento(int id) {
        String sql = "DELETE FROM MEDICAMENTO WHERE idmedicamento = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            
            int resultado = stmt.executeUpdate();
            
            if (resultado > 0) {
                return true;
            }
                    
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List<Medicamento> listarMedicamentoByLaboratorioID(int id) {
        String sql = "SELECT * FROM MEDICAMENTO WHERE LABORATORIO = ?";
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                int idmed = rs.getInt("idmedicamento");
                String nombre = rs.getString("nombre_medicamento");
                int precio = rs.getInt("precio");
                int gramos = rs.getInt("gramos");
                int laboratorioSelect = rs.getInt("laboratorio");
                String fecha = rs.getString("fecha_recepcion");
                
                LaboratorioService laboratorioServicio = new LaboratorioService();
                Laboratorio laboratorio = laboratorioServicio.buscarLaboratorio(laboratorioSelect);
                
                medicamentos.add(new Medicamento(idmed, nombre, precio, gramos, laboratorio, fecha));
            }
            return medicamentos;
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean searchMedicamento(String nombreMedicamento) {
        try {
            List<Medicamento> listarMedicamentos = listarMedicamentos();
            
            for (Medicamento x : listarMedicamentos) {
                if (x.getNombre().toLowerCase().equals(nombreMedicamento.toLowerCase())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
