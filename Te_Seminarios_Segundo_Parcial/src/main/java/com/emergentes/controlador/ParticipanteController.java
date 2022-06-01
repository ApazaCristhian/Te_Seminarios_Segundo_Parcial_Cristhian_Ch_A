
package com.emergentes.controlador;

import com.emergentes.dao.ParticipanteDAO;
import com.emergentes.dao.ParticipanteDAOimpl;
import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.Participantes;
import com.emergentes.modelo.Seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ParticipanteController", urlPatterns = {"/ParticipanteController"})
public class ParticipanteController extends HttpServlet {

   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
try {
            ParticipanteDAO dao = new ParticipanteDAOimpl();
            SeminarioDAO daoSeminario = new SeminarioDAOimpl();
            int id;
            List<Seminarios> lista_seminarios = null;
            Participantes par = new Participantes();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_seminarios = daoSeminario.getAll();
                    request.setAttribute("lista_seminarios", lista_seminarios);

                    request.setAttribute("participante", par);
                    request.getRequestDispatcher("frmparticipante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    par = dao.getById(id);
                    lista_seminarios = daoSeminario.getAll();
                    
                    request.setAttribute("lista_seminarios", lista_seminarios);
                    request.setAttribute("participante", par);
                    request.getRequestDispatcher("frmparticipante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));

                    dao.delete(id);

                    response.sendRedirect("ParticipanteController");
                    break;
                case "view":
                    //Obtener la lista de registros
                    List<Participantes> lista = dao.getAll();
                    request.setAttribute("participante", lista);
                    request.getRequestDispatcher("participante.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error Fatal" + ex.getMessage());
        } 
         
         
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
        String confirmado = request.getParameter("confirmado");
        String titulo = request.getParameter("titulo");
        

        Participantes p = new Participantes();

        p.setId(id);
        p.setApellidos(apellidos);
        p.setNombres(nombres);
        p.setId_seminario(id_seminario);
        p.setConfirmado(confirmado);
        p.setTitulo(titulo);

        ParticipanteDAO dao = new ParticipanteDAOimpl();

               if (id == 0) {
            //Nuevo
           
            try {
                // Nuevo registro
                dao.insert(p);
                response.sendRedirect("ParticipanteController");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
          
            try {
                dao.update(p);
                response.sendRedirect("ParticipanteController");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }
    }


    


