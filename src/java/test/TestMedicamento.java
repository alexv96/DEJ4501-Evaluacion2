/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.MedicamentoService;
import dao.MedicamentoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Medicamento;

/**
 *
 * @author Alex
 */
public class TestMedicamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MedicamentoDAO dao = new MedicamentoDAO();
        /*** Buscar Medicamento [FUNCIONA]***/
        /*boolean encontrado = dao.searchMedicamento("Paracetamol");
        if (encontrado) {
        System.out.println("Existe");
        }else{
        System.out.println("No existe");
        }*/
        /*** Eliminar Medicamento [FUNCIONA] ***/
        /*boolean elimino = dao.deleteMedicamento(7);
        if (elimino) {
        System.out.println("Elimino");
        }else{
        System.out.println("No elimino");
        }*/
        
        /*** Buscar medicamentos por Laboratorio [FUNCIONA]***/
        /*List<Medicamento> laboratoriosID = dao.listarMedicamentoByLaboratorioID(2);
        System.out.println(laboratoriosID.toString());*/
        
        /*** Agregar Medicamento [FUNCIONA]***/
        /*Date fechaActual = new Date();
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String fechaDelDia = formatoFechaHora.format(fechaActual);
        //System.out.println(fechaActual);
        
        Medicamento m1 = new Medicamento("Alex", 5000, 23, 1, fechaDelDia);
        
        if (dao.addMedicamento(m1)) {
            System.out.println("Agrego");
        }else{
            System.out.println("Error");
        }*/
        
        MedicamentoService s = new MedicamentoService();
        List<Medicamento> listarTodo = s.listarTodo();
        System.out.println(listarTodo);
    }
    
}
