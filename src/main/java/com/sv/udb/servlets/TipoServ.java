/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import com.sv.udb.modelos.Tipos;
import comv.sv.udb.controladores.CtrlTipos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
@WebServlet(name = "TipoServ", urlPatterns = {"/TipoServ"})
public class TipoServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("TipoBton");
            if(CRUD.equals("Guardar"))
            {
                Tipos obje = new Tipos();
                obje.setNombTipo(request.getParameter("nomb"));
                mens = new CtrlTipos().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else if(CRUD.equals("Consultar"))
            {
                //Para un objeto
                Integer codi = Integer.parseInt(request.getParameter("codi"));
                Tipos obje = new CtrlTipos().cons(codi);
             
               if(obje != null)
               {
                    request.setAttribute("codi", obje.getCodiTipo());
                    request.setAttribute("nomb", obje.getNombTipo());
                      
               }
                              
            }
             else if(CRUD.equals("Eliminar"))
            {
             
                  Tipos obj = new Tipos();
               obj.setCodiTipo(Integer.parseInt(request.getParameter("codiEquiRadi").isEmpty()?"-1":request.getParameter("codiEqui")));
               if (new CtrlTipos().dele(obj)) 
                {
                    mens = "Eliminar";
                }
            }
               request.setAttribute("mensAlert", mens);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
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
        processRequest(request, response);
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

}
