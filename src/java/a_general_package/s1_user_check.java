/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a_general_package;
import c_c_db_package.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.catalina.Session;

/**
 *
 * @author HBB20
 */
public class s1_user_check extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        common_model cm=new common_model();
        //String next_page="j1_home.jsp";
        String next_page="j1_acc_req.jsp";
        HttpSession s=request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            String status="",user_id="";
             
            user_id=request.getParameter("user_id");
            s.setAttribute("temp_id",user_id);
            status=cm.check_status(user_id);
            request.setAttribute("user_id",user_id);
            System.out.print("role is"+status);
            if(status=="new")
                next_page="j1_acc_req.jsp";
            else if(status=="approved")
                next_page="j1_approved.jsp";
            
            else if(status=="member")
                next_page="j1_login.jsp";
            else if(status=="suspended")
                next_page="j1_suspended.jsp";
            else if(status=="waiting")
                next_page="j1_waiting.jsp";
                    
                
           
            
            
           
        } finally {   
            RequestDispatcher rd=request.getRequestDispatcher(next_page);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
