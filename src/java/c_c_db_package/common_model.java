/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c_c_db_package;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HBB20
 */
public class common_model {
    c_c_db ccd=null;
    Connection conn=null;
    private Statement Statement;
    public common_model() {
        ccd=new c_c_db();
        conn=ccd.getDB();
        
        
    }
    
   public String check_status(String user_id)
    {   String query;
        String state="",table="req_waiting";
        query="select * from "+table+" where user_id='"+user_id+"' AND approved='no'";
        ResultSet rs=null;
        try {
            Statement st=conn.createStatement();
            st.execute(query);
            rs=st.executeQuery(query);
            if(rs.next())
            {
                state="waiting";
                return state;
            }
            
            table="users";
            query="select * from "+table+" where user_id='"+user_id+"'";
            st.execute(query);
            rs=st.executeQuery(query);
            if(rs.next())
            {
                state="member";
                return state;
            }
            
             table="req_suspend";
            query="select * from "+table+" where user_id='"+user_id+"'";
            st.execute(query);
            rs=st.executeQuery(query);
            if(rs.next())
            {
                state="suspended";
                return state;
            }
            
            
            
             table="req_waiting";
            query="select * from "+table+" where user_id='"+user_id+"' AND approved='yes'";
            st.execute(query);
            rs=st.executeQuery(query);
            if(rs.next())
            {
                state="approved";
                return state;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(common_model.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return "new";
    }
   
   public String is_exist(String user_id)
   {
       String ans="unimplemented";
       return ans;
   }
   
   
    
}
