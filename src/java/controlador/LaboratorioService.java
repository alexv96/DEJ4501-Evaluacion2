/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.LaboratorioDAO;
import java.util.List;
import modelo.Laboratorio;

/**
 *
 * @author Alex
 */
public class LaboratorioService {
    private static LaboratorioDAO dao;

    public LaboratorioService() {
        this.dao = new LaboratorioDAO();
    }
    
    
    
    public List<Laboratorio> listarTodo(){
        return dao.getLaboratorios();
    }
    
    public Laboratorio buscarLaboratorio(int id){
        return dao.getLaboratorioByID(id);
    }
}
