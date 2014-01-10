/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c_c_db_package;

import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HBB20
 */
public class pending_req {
     c_c_db ccd=null;
    Connection conn=null;
    public pending_req() {
        ccd=new c_c_db();
        conn=ccd.getDB();
        }
   public int set_new_pr(String user_id,String f_name,String l_name,String branch,String rl)
    {
        boolean b=false;
        int up=0;
        String query="insert into req_waiting values('"+user_id+"','"+f_name+"','"+l_name+"',curdate(),'"+branch+"','no','"+rl+"')";
        try {
            Statement st=conn.createStatement();
           // st.execute(query);
            up=st.executeUpdate(query);
        } catch (SQLException ex) {
           System.out.print("s1_verify_execption");
           up=5;
        }
        
        return up;
    }

   
      public boolean approve(String user_id)
    {
        boolean b=false;
        int up=0;
        String query="update req_waiting set approved='yes' where user_id='"+user_id+"'";
        try {
            Statement st=conn.createStatement();
            st.execute(query);
            up=st.executeUpdate(query);
             b=true;
           
            
                
            
        } catch (SQLException ex) {
           System.out.print("s1_verify_execption   "+ex);
           up=5;
        }
        
        return b;
    }

   
   
   
   
   
public void eraseWaitingRequest(String user_id)   

        
{        String query="delete from req_waiting where user_id='"+user_id+"'";
        try {
           
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(pending_req.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public String check_role_waiting(String user_id)
{   String role="Sorry, Some error occured in pojo";  
    try {
            ResultSet rs=null;
              
            String query="select * from req_waiting where user_id='"+user_id+"'";
            Statement st=conn.createStatement();
                      st.execute(query);
                      rs=st.executeQuery(query);
                      if(rs.next())
                      {
                          role=rs.getString("role");
                      }
                      if(role.equals("s"))
                      {
                          role="student";
                          
                      }
                      else if(role.equals("f"))
                      {
                          role="faculty";
                      }
                      else
                      {
                          role=user_id+"not found";
                      }
                      
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
    finally
    {
        return role;
    }
            
}


}
