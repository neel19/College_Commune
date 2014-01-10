/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c_c_db_package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.catalina.connector.Request;

/**
 *
 * @author HBB20
 */
public class user_model {
      c_c_db ccd=null;
    Connection conn=null;
    private Statement statement;
    
    private String user_id,pass,role,authority,dept;
   
    public String getDept(String user_id) {
        String rtrn="none";
    
        String query="select * from users where user_id='"+user_id+"'";
        try {
            statement=conn.createStatement();
            statement.execute(query);
            ResultSet rs=statement.executeQuery(query);
              rs.next();
                  rtrn=rs.getString(5);
                  System.out.print("dept set to="+rtrn);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return rtrn;
        }
    }

    public void setDept(String dept) {
        
        this.dept = dept;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPass() {
        
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        String role="Sorry, Some error occured";  
    try {
            ResultSet rs=null;            
            String query="select * from users where user_id='"+this.user_id+"'";
            Statement st=conn.createStatement();
                      st.execute(query);
                      rs=st.executeQuery(query);
                      if(rs.next())
                      {
                          role=rs.getString(3);
                      }
                      if(role.equals("s"))
                      {
                          role="student";
                      }
                      else if(role.equals("f"))
                      {
                          role="faculty";
                      }
                      else if(role.equals("da"))
                      {
                          role="da";
                      }
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
    finally
    {
        return role;
    }
        
     
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
       
        String role="Sorry, Some error occured";  
    try {
            ResultSet rs=null;
              
            String query="select * from users where user_id='"+user_id+"'";
            Statement st=conn.createStatement();
                      st.execute(query);
                      rs=st.executeQuery(query);
                      if(rs.next())
                      {
                          role=rs.getString(3);
                      }
                      if(role.equals("s"))
                      {
                          role="student";
                      }
                      else if(role.equals("f"))
                      {
                          role="faculty";
                      }
                      else if(role.equals("da"))
                      {
                          role="da";
                      }
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
    finally
    {
        return authority;
    }
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    
    public user_model() {
        ccd=new c_c_db();
        conn=ccd.getDB();
    }
    public user_model(String user_id,String password,String role,String autho,String dept)
    {    ccd=new c_c_db();
        conn=ccd.getDB();
        this.setUser_id(user_id);
        this.setPass(password);
        this.setRole(role);
        this.setAuthority(autho);
        this.setDept(dept);
    }
    
    public boolean storeUser(user_model user)
    {
        boolean rtrn=false;
        String query;
        Integer count=0;
        try {
            Statement st=conn.createStatement();
            query="insert into users values('"+user.user_id+"','"+user.pass+"','"+user.role+"','"+user.authority+"','"+user.dept+"')";
            count=st.executeUpdate(query);
            if(count!=0)
            {
                rtrn=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return rtrn;
        }
        
        
    }
    
public String check_role_user(String user_id)
{   String role="Sorry, Some error occured";  
    try {
            ResultSet rs=null;
              
            String query="select * from users where user_id='"+user_id+"'";
            Statement st=conn.createStatement();
                      st.execute(query);
                      rs=st.executeQuery(query);
                      if(rs.next())
                      {
                          role=rs.getString(3);
                      }
                      if(role.equals("s"))
                      {
                          role="student";
                      }
                      else if(role.equals("f"))
                      {
                          role="faculty";
                      }
                      else if(role.equals("da"))
                      {
                          role="da";
                      }
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
    finally
    {
        return role;
    }
            
}


public String verify_user(String user_id,String pass)
{     String valid="",password="";
    try {
            ResultSet rs=null;
              
            String query="select password from users where user_id='"+user_id+"'";
            Statement st=conn.createStatement();
                      st.execute(query);
                      rs=st.executeQuery(query);
                      if(rs.next())
                      {
                          password=rs.getString(1);
                      }
                      else
                      {
                          valid="fail";
                      }
                      
                      if(pass.equals(password))
                      {
                          valid="ok";
                      }
                      else
                      {
                          valid="pass_wrong";
                      }
                      
        } catch (SQLException ex) {
            Logger.getLogger(user_model.class.getName()).log(Level.SEVERE, null, ex);
        }
    finally
    {
        return valid;
    }
            
  }

}
