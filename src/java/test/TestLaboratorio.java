/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.LaboratorioDAO;
import java.util.List;
import modelo.Laboratorio;

/**
 *
 * @author Alex
 */
public class TestLaboratorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Listar Laboratorios.
        LaboratorioDAO daoL = new LaboratorioDAO();
        //List<Laboratorio> laboratorios = daoL.getLaboratorios();
        //System.out.println(laboratorios.toString());
        //Buscar Laboratorios.
        Laboratorio buqueda = daoL.getLaboratorioByID(2);
        System.out.println(buqueda.toString());
    }
    
}
