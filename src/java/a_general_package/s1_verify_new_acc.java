/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a_general_package;

import c_c_db_package.branch_model;
import c_c_db_package.common_model;
import c_c_db_package.pending_req;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HBB20
 */
public class s1_verify_new_acc extends HttpServlet {

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
        branch_model bm=new branch_model();
        pending_req pr=new pending_req();
        String next_page="j1_home.jsp";
        String found="no",role="",branch="unchanged";
        String user_id=request.getParameter("user_id");
        String f_name=request.getParameter("f_name");
        String l_name=request.getParameter("l_name");
        branch=request.getParameter("branch");
        String valid_enroll=bm.getBranch(user_id);
        try {
              found=cm.check_status(user_id);
              
               
              if(valid_enroll.equals("error"))
              {
               request.setAttribute("msg",user_id+" is invalid enrollment");
             next_page="j1_home.jsp";
             RequestDispatcher rd=request.getRequestDispatcher(next_page);
            System.out.print(branch);
                   rd.forward(request, response);
                  
              }
                  
              else
              {   
                  int b=pr.set_new_pr(user_id, f_name, l_name, branch,"s");
                 if(b==1)
                 {next_page="j1_waiting.jsp";
                  request.setAttribute("msg","Request sent Successfully ");
                 }
                 else
                 {
                     next_page="j1_acc_req.jsp";
                     request.setAttribute("msg", "Some Error occured"+b);
                 }
                     
              }
               System.out.print(branch);
            } finally { 
            RequestDispatcher rd=request.getRequestDispatcher(next_page);
            System.out.print(branch);
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
