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

/**
 *
 * @author HBB20
 */
public class student {
     c_c_db ccd=new c_c_db();
    Connection conn=ccd.getDB();
    private Statement Statement;
    
    
    
    String f_name,m_name,l_name,self_cell,parent_cell,email,local_add,per_add,user_id,batch_year_s,level_s,dept,fa;
    Integer level,batch_year;
   public student()
   {
       
   }
   public student(String f_name,String m_name,String l_name,String self_cell,String parent_cell,String email,String local_add,String per_add,String user_id,String batch_year_s,String level_s,String dept,String fa)
    {
        int tlevel=Integer.parseInt(level_s);
        int tbatch_year=Integer.parseInt(batch_year_s);
        studentAdd(f_name,m_name,l_name,self_cell,parent_cell,email,local_add,per_add,user_id,tbatch_year,tlevel,dept,fa);
    }
   public student(String f_name,String m_name,String l_name,String self_cell,String parent_cell,String email,String local_add,String per_add,String user_id,Integer batch_year_s,Integer level_s,String dept,String fa)       
    {
       studentAdd(f_name,m_name,l_name,self_cell,parent_cell,email,local_add,per_add,user_id,batch_year_s,level_s,dept,fa); 
    }
    
    private void studentAdd(String f_name,String m_name,String l_name,String self_cell,String parent_cell,String email,String local_add,String per_add,String user_id,Integer batch_year,Integer level,String dept,String fa)
    {
        this.f_name=f_name;
        this.m_name=m_name;
        this.l_name=l_name;
        this.self_cell=self_cell;
        this.parent_cell=parent_cell;
        this.email=email;
        this.local_add=local_add;
        this.per_add=per_add;
        this.user_id=user_id;
        this.batch_year=batch_year;
        this.level=level;
        this.dept=dept;
        this.fa=fa;
                
    }
    
    public boolean storeNewStudent(student stud)
    {
        boolean rtrn=false;
        Integer count=0;
     String query="insert into student values('"+user_id+"','"+stud.f_name+"','"+stud.m_name+"','"+stud.l_name+"',"+stud.level+",'"+stud.self_cell+"','"+stud.parent_cell+"','"+stud.local_add+"','"+stud.per_add+"','no avtar',"+stud.batch_year+",'"+stud.email+"','"+stud.dept+"','"+stud.fa+"')";
     //  String query="insert into student values('t_id2_ok','t_fname','t_mname','t_lname',2,'t_scell','t_pcell','t_ladd','t_padd','no avtar',3,'try_email','try_dept','UDA')";
        try {
           Statement St=conn.createStatement();
            count=St.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(count!=0)
            {
                rtrn=true;
            }
            return rtrn;
        }
    }
    
    
    public student fetchStudent(String user_id)
    {
        
        Integer count=0;
        ResultSet rs=null;
        student stud=null;
     String query="select * from student where user_id='"+user_id+"'";
     //  String query="insert into student values('t_id2_ok','t_fname','t_mname','t_lname',2,'t_scell','t_pcell','t_ladd','t_padd','no avtar',3,'try_email','try_dept','UDA')";
        try {
           Statement St=conn.createStatement();
            rs=St.executeQuery(query);
            if(rs.next())
            {
            stud=new student(rs.getString("f_name"), rs.getString("m_name"), rs.getString("l_name"), rs.getString("call_self"),rs.getString("call_parent"),rs.getString("email"), rs.getString("local_add"),rs.getString("per_add"),rs.getString("user_id"), rs.getInt("batch_year"),rs.getInt("current_level"),rs.getString("dept"),rs.getString("fa"));
            }
            else
            {
                stud=new student("0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000", user_id, 0, 0, "0000", "0000");
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            
            return stud;
        }
    }

        
        
        
        


    public String getF_name() {
        return f_name;
    }

    public String getM_name() {
        return m_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getSelf_cell() {
        return self_cell;
    }

    public String getParent_cell() {
        return parent_cell;
    }

    public String getEmail() {
        return email;
    }

    public String getLocal_add() {
        return local_add;
    }

    public String getPer_add() {
        return per_add;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getDept() {
        return dept;
    }

    public String getFa() {
        return fa;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getBatch_year() {
        return batch_year;
    }
    
    
    
    
    
            
 }
