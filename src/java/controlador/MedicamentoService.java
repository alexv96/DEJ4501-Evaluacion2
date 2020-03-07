/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.MedicamentoDAO;
import java.util.List;
import modelo.Medicamento;

/**
 *
 * @author Alex
 */
public class MedicamentoService {
    
    private static MedicamentoDAO dao;

    public MedicamentoService() {
        this.dao = new MedicamentoDAO();
    }
    
    public List<Medicamento> listarTodo(){
        return dao.listarMedicamentos();
    }
    
    public List<Medicamento> listarMedicamentosPorLaboratorio(int id){
        return dao.listarMedicamentoByLaboratorioID(id);
    }
    
    public boolean agregarMedicamento(Medicamento m){
        return dao.addMedicamento(m);
    }
    
    public boolean eliminarMedicamento(int id){
        return dao.deleteMedicamento(id);
    }
    
    public boolean buscarMedicamento(String nombre){
        return dao.searchMedicamento(nombre);
    }
}
