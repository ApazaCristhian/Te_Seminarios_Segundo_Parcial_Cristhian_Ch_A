
package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.Seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "SeminarioController", urlPatterns = {"/SeminarioController"})
public class SeminarioController extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {

            Seminarios se = new Seminarios();
            int id;
            SeminarioDAO dao = new SeminarioDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("seminario", se);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));

                    se = dao.getById(id);

                    request.setAttribute("seminario", se);
                    
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));

                    dao.delete(id);

                    response.sendRedirect("SeminarioController");
                    break;
                case "view":
                    
                    List<Seminarios> lista = dao.getAll();

                    request.setAttribute("seminario", lista);
                    request.getRequestDispatcher("seminario.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
       

        Seminarios s = new Seminarios();

        s.setId(id);
        s.setTitulo(titulo);
        s.setFecha(convierteFecha(fecha));
        s.setCupo(cupo);
        
  if (id == 0) {
            //Nuevo
            SeminarioDAO dao = new SeminarioDAOimpl();
            try {
                // Nuevo registro
                dao.insert(s);
                response.sendRedirect("SeminarioController");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            SeminarioDAO dao = new SeminarioDAOimpl();
            try {
                dao.update(s);
                response.sendRedirect("SeminarioController");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        
    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {

            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(SeminarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }
}
