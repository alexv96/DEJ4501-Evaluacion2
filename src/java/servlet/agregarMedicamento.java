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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Laboratorio;
import modelo.Medicamento;

/**
 *
 * @author Alex
 */
public class agregarMedicamento extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet agregarMedicamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet agregarMedicamento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        LaboratorioService daoL = new LaboratorioService();
        List<Laboratorio> laboratorios = daoL.listarTodo();
        
        request.setAttribute("laboratorios", laboratorios);
        request.getRequestDispatcher("agregarMedicamento.jsp").forward(request, response);
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
        
        //List<String> err = new ArrayList<>();
        try {
            String nombre = request.getParameter("nombre");
            int precio = Integer.parseInt(request.getParameter("precio"));
            int gramos = Integer.parseInt(request.getParameter("gramos"));
            int laboratorio = Integer.parseInt(request.getParameter("laboratorio"));
            
            Date fechaActual = new Date();
            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            String fechaDelDia = formatoFechaHora.format(fechaActual);
            
            MedicamentoService servicio = new MedicamentoService();
            
            boolean buscarMedicamento = servicio.buscarMedicamento(nombre.toLowerCase());
            if (buscarMedicamento) {
                LaboratorioService daoL = new LaboratorioService();
                List<Laboratorio> laboratorios = daoL.listarTodo();

                String err = "<strong>ERROR!</strong> el medicamento "+ nombre +" ya existe en la lista.";
                
                request.setAttribute("err", err);
                request.setAttribute("laboratorios", laboratorios);
                request.getRequestDispatcher("agregarMedicamento.jsp").forward(request, response);
                return;
            }
            
            boolean agregado = servicio.agregarMedicamento(new Medicamento(nombre, precio, gramos, laboratorio, fechaDelDia));
            
            if (agregado) {
                LaboratorioService daoL = new LaboratorioService();
                List<Laboratorio> laboratorios = daoL.listarTodo();

                String mensaje = "Medicamento agregado exitosamente";
                
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("laboratorios", laboratorios);
                request.getRequestDispatcher("agregarMedicamento.jsp").forward(request, response);
                return;
            }else{
                LaboratorioService daoL = new LaboratorioService();
                List<Laboratorio> laboratorios = daoL.listarTodo();

                String err = "<strong>ERROR!</strong> al agregar el medicamento";
                
                request.setAttribute("err", err);
                request.setAttribute("laboratorios", laboratorios);
                request.getRequestDispatcher("agregarMedicamento.jsp").forward(request, response);
                return;
            }
            
        } catch (Exception e) {
        }
        
        
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

}
