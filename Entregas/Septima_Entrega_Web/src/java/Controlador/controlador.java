/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author patri
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"}, initParams = {
    @WebInitParam(name = "op", value = "")})
public class controlador extends HttpServlet {

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
        
            String oper = request.getParameter("op");
            if(oper==null){ oper = "";}
            
            RequestDispatcher rd;

            switch (oper){
                case "altaCiudad":
                    response.sendRedirect("frmNuevaCiudad.jsp");
                    break;
                case "insertCiudad":
                    rd = request.getRequestDispatcher("procNuevaCiudad.jsp");
                    rd.forward(request,response);
                    break;
                case "muestraCiudad":
                    rd = request.getRequestDispatcher("muestraCiudad.jsp");
                    rd.forward(request,response);
                    break;
                case "actualizarCiudad":
                    //response.sendRedirect("frmActualizarCiudad.jsp");
                    rd = request.getRequestDispatcher("frmActualizarCiudad.jsp");
                    rd.forward(request,response);
                    break;
                case "actCiudad":
                    rd = request.getRequestDispatcher("procActualizarCiudad.jsp");
                    rd.forward(request,response);
                    break;
                case "eliminarCiudad":
                    ORM.Ciudad ciudadBean = new ORM.Ciudad();
                    ciudadBean.setIdCiudad(Integer.parseInt(request.getParameter("idCiudad")));
                    Transaction t = null;
                    Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
                    try  {
                        t = s.beginTransaction();
                        if (ciudadBean != null) {
                            s.delete(ciudadBean);
                            t.commit();
                        }
                    }catch (Exception e) {
                        e.printStackTrace(System.err);
                        if (t != null) {
                            t.rollback();
                        }
                    }  
                default:
                    response.sendRedirect("home.jsp");
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
