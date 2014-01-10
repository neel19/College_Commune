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
public class pending_request_model_check {
    public static void main(String arg[])
    {
        pending_req pr=new pending_req();
//        boolean i=pr.approve("t_waiting");
//        if(i)
//        {
//            System.out.print("Updated successfully");
//        }
//        else
//        {
//             System.out.print("Update fail");
//        }
        
        
        
        //earase waiting request
        pr.eraseWaitingRequest("as");
        
    }
}
