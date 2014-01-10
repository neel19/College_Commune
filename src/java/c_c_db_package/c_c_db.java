package c_c_db_package;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.*;
import java.sql.*;
/**
 *
 * @author HBB20
 */
public class c_c_db {
     Connection db;
   public c_c_db()
    {
        String url="jdbc:odbc:cc_project_dsn";
        try
        {    Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            db=DriverManager.getConnection(url,"root","");
           
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
   public Connection getDB()
    {
        return db;
    }
  
}
