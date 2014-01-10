/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c_c_db_package;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.text.Position;

/**
 *
 * @author HBB20
 */
public class branch_model {
  c_c_db ccd=null;
    Connection conn=null;
    private Statement Statement;
    public branch_model() {
        ccd=new c_c_db();
        conn=ccd.getDB();
    }
    
    public String getBranch(String user_id)
   {
       String ans="error";
       if(user_id.length()!=12)
           return ans;
       return "ok";
   }
}
