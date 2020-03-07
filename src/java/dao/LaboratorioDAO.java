/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaz.ILaboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Laboratorio;

/**
 *
 * @author Alex
 */
public class LaboratorioDAO implements ILaboratorio{

    private Connection conexion;
    
    public LaboratorioDAO() {
        this.conexion = new Conexion().getConexion();
    }

    @Override
    public List<Laboratorio> getLaboratorios() {
        List<Laboratorio> laboratorios = new ArrayList<>();
        String sql = "SELECT * FROM LABORATORIO";
        
        try {
            PreparedStatement ps = conexion.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Laboratorio l = new Laboratorio();
                l.setId(rs.getInt("idlaboratorio"));
                l.setNombre(rs.getString("nombre_laboratorio"));
                laboratorios.add(l);
            }
            
            return laboratorios;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Laboratorio getLaboratorioByID(int id) {
        try {
            String sql = "SELECT * FROM LABORATORIO WHERE IDLABORATORIO = ?";
            
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Laboratorio l = new Laboratorio();
                l.setId(rs.getInt("idlaboratorio"));
                l.setNombre(rs.getString("nombre_laboratorio"));
                
                return l;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    
}
