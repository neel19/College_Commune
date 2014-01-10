/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model_check;
import c_c_db_package.*;

/**
 *
 * @author HBB20
 */
public class student_model_check {
    public static void main(String args[])
    {
    student s=new student("f_name","m_name","l_name","9033","9898","email","loc_add","per_add","user_it_008",2010,4,"IT","uda");
    boolean stored=s.storeNewStudent(s);
    System.out.println("f_name:"+s.getF_name()+"m_name:"+s.getM_name()+"l_name:"+s.getL_name()+"self_call:"+s.getSelf_cell()+"par_call:"+s.getParent_cell()+"u_id:"+s.getUser_id()+"batch_year:"+s.getBatch_year()+"level:"+s.getLevel()+"dept:"+s.getDept()+"FA:"+s.getFa()+"local add:"+s.getLocal_add()+"per_add:"+s.getPer_add()+"email:"+s.getEmail());
 System.out.println("store:"+stored);
 
        
        
        
        
        
        
        
        //user store
     //   user_model um=new user_model("u_id","pass","test","test_autho","test_it");
        
     //   boolean b=um.storeUser(um);
     //   System.out.print(b);
        //   user_model um=new user_model();
  //  String deptO=um.getDept("it_admin");
  //  System.out.println("caught is="+deptO);
    }
    
   
}
