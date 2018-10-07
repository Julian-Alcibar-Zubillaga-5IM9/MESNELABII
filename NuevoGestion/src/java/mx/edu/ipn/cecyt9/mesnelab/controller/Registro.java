/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ipn.cecyt9.mesnelab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.ipn.cecyt9.mesnelab.utils.ConectaDB;
import mx.edu.ipn.cecyt9.mesnelab.utils.DataBase;

/**
 *
 * @author Alumno
 */
public class Registro extends HttpServlet {


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        DataBase db = new DataBase();
        ResultSet rs;
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String correo = request.getParameter("correo");
        String nombre = request.getParameter("nombre");
        String AP = request.getParameter("ApePat");
        String AM = request.getParameter("ApeMat");
        String tel = request.getParameter("telefono");
        try{
        db.connect();
        db.insert("insert into usuario (`usuario`, `contraseña`, `correo`, `nombre`, `apellido_paterno`, `apellido_materno`, `telefono`) values('"+usuario+"','"+contrasena+"','"+correo+"','"+nombre+"','"+AP+"','"+AM+"','"+tel+"');");
        db.closeConnection();
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>alert('Registro hecho con exito'); </script>");
            out.print("<META HTTP-EQUIV='REFRESH' CONTENT='0.00000001;URL=http://localhost:8080/Mesne/index.jsp'>");
        }} catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
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
