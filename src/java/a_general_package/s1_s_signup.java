/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a_general_package;

import c_c_db_package.pending_req;
import c_c_db_package.student;
import c_c_db_package.user_model;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HBB20
 */
public class s1_s_signup extends HttpServlet {

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
        String f_name,m_name,l_name,self_cell,parent_cell,email,local_add,per_add,user_id,batch_year_s,level_s,dept,fa;
        String pass=request.getParameter("pwd1");
        f_name=request.getParameter("f_name");
        m_name=request.getParameter("m_name");
        l_name=request.getParameter("l_name");
        self_cell=request.getParameter("self_cell");
        parent_cell=request.getParameter("parent_cell");
        email=request.getParameter("email");
        local_add=request.getParameter("local_add");
        per_add=request.getParameter("per_add");
        user_id=request.getParameter("user_id");
        batch_year_s=request.getParameter("batch_year");
        level_s=request.getParameter("level");
        dept=request.getParameter("dept");
        fa=request.getParameter("fa");
        String next_page="j1_s_signup.jsp";
        String msg="Some error occured";
        Integer level=Integer.parseInt(level_s);
        Integer batch_year=Integer.parseInt(batch_year_s);
        
        try {
          student s=new student(f_name, m_name, l_name, self_cell, parent_cell, email, local_add, per_add, user_id, batch_year, level, dept, fa);  
          s.storeNewStudent(s);
          out.print(f_name+m_name+l_name+self_cell+parent_cell+email+local_add+per_add+user_id+batch_year+level+dept+fa);
          
              
              user_model user=new user_model(user_id, pass,"s","s", dept);
             user.storeUser(user);
           
             {    next_page="j1_login.jsp";
              HttpSession hs=request.getSession();
              hs.setAttribute("temp_id",s.getUser_id());
              pending_req pr=new pending_req();
              pr.eraseWaitingRequest(user_id);
              msg="Successfully Created Account";
             
             
          }
          
        } finally {  
            request.setAttribute("msg",msg);
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
