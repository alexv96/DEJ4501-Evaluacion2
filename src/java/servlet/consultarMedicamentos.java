/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.LaboratorioService;
import controlador.MedicamentoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.parser.TokenType;
import modelo.Laboratorio;
import modelo.Medicamento;

/**
 *
 * @author Alex
 */
public class consultarMedicamentos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("btnAccion");
        if (accion == null) {
            doGet(request, response);
        }
        
        
        switch(accion){
            case "Buscar":
                buscar(request,response);
                break;
            case "Eliminar":
                eliminar(request,response);
                break;
            default:
                doGet(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LaboratorioService daoL = new LaboratorioService();
            List<Laboratorio> laboratorios = daoL.listarTodo();

            MedicamentoService daoM = new MedicamentoService();
            List<Medicamento> medicamentos = daoM.listarTodo();
            
            request.setAttribute("laboratorios", laboratorios);
            request.setAttribute("medicamentos", medicamentos);
            request.getRequestDispatcher("consultarMedicamentos.jsp").forward(request, response);
            
        } catch (Exception e) {
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idMedicamento = Integer.parseInt(request.getParameter("id"));
        
        MedicamentoService servicio = new MedicamentoService();
        boolean eliminarMedicamento = servicio.eliminarMedicamento(idMedicamento);
        
        if (eliminarMedicamento) {
            LaboratorioService daoL = new LaboratorioService();
            List<Laboratorio> laboratorios = daoL.listarTodo();

            MedicamentoService daoM = new MedicamentoService();
            List<Medicamento> medicamentos = daoM.listarTodo();
            
            String mensaje = "Medicamento eliminado exitosamente";
            
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("laboratorios", laboratorios);
            request.setAttribute("medicamentos", medicamentos);
            request.getRequestDispatcher("consultarMedicamentos.jsp").forward(request, response);
            return;
        }else{
            LaboratorioService daoL = new LaboratorioService();
            List<Laboratorio> laboratorios = daoL.listarTodo();

            MedicamentoService daoM = new MedicamentoService();
            List<Medicamento> medicamentos = daoM.listarTodo();
            
            String error = "<strong>ERROR!</strong> al eliminar el medicamento";
            
            request.setAttribute("error", error);
            request.setAttribute("laboratorios", laboratorios);
            request.setAttribute("medicamentos", medicamentos);
            request.getRequestDispatcher("consultarMedicamentos.jsp").forward(request, response);
            return;
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String idLaboratorio = request.getParameter("laboratorio");
            
            if (idLaboratorio == null) {
                MedicamentoService servicio = new MedicamentoService();
                List<Medicamento> medicamentos = servicio.listarTodo();

                LaboratorioService daoL = new LaboratorioService();
                List<Laboratorio> laboratorios = daoL.listarTodo();
                
                String err = "Debe seleccionar un laboratorio valido";
                
                request.setAttribute("err", err);
                request.setAttribute("laboratorios", laboratorios);
                request.setAttribute("medicamentos", medicamentos);
                request.getRequestDispatcher("consultarMedicamentos.jsp").forward(request, response);
                return;
            }
            
            MedicamentoService servicio = new MedicamentoService();
            List<Medicamento> medicamentos = servicio.listarMedicamentosPorLaboratorio(Integer.parseInt(idLaboratorio));
            
            if (medicamentos != null) {
                LaboratorioService daoL = new LaboratorioService();
                List<Laboratorio> laboratorios = daoL.listarTodo();

                request.setAttribute("laboratorios", laboratorios);
                request.setAttribute("medicamentos", medicamentos);
                request.getRequestDispatcher("consultarMedicamentos.jsp").forward(request, response);
                return;
            }
            
                LaboratorioService daoL = new LaboratorioService();
                List<Laboratorio> laboratorios = daoL.listarTodo();
                
                String err = "Debe seleccionar un laboratorio valido";
                
                request.setAttribute("err", err);
                request.setAttribute("laboratorios", laboratorios);
                request.setAttribute("medicamentos", medicamentos);
                request.getRequestDispatcher("consultarMedicamentos.jsp").forward(request, response);
                return;
            
            
        } catch (Exception e) {
        }
    }

}
