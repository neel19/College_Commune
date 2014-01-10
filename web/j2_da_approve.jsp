<%-- 
    Document   : j2_da_home
    Created on : 9 Dec, 2013, 2:45:47 PM
    Author     : HBB20
--%>

<%@page import="java.awt.Desktop.Action"%>
<%@page import="java.lang.annotation.Target"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<%@page import="c_c_db_package.*,java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Dept Admin Request Page</title>
        <script>
         
        </script>
    </head>
    <%
    ResultSet rs=null;
    c_c_db ccd=new c_c_db();
    Connection conn=ccd.getDB();
    Statement st=conn.createStatement();
    String query="select * from req_waiting where dept='"+(String)session.getAttribute("live_dept")+"' and approved='no'";
   // String query="select * from req_waiting where dept='IT'";
    rs=st.executeQuery(query);
    
    

%>
<%  boolean checked=false;
    String msg="";
            String id="";
            String f_name="";
            String l_name="";
    try{
    msg=(String)request.getAttribute("msg");
       }
    catch(Exception e)
                       {
        msg="";
    }
     finally{
        request.removeAttribute("msg");
    }
         if(msg==null)
                                  {msg="";  }

    %>

    <body>
        <h1 align="centre">...<%=(String)session.getAttribute("live_dept")%>...Departmental Admin</h1>
        <input type="button" value="Log Out" name="log_out" style="margin-left: 90%" onclick="window.location.href='./s2_log_out'"/>
        <h3 style="color: green" align="center"><%=msg%></h3>
        <div align="center">
        
                  
                <% 
                   while(rs.next())
                        { checked=true;
                         id=rs.getString(1);
                         f_name=rs.getString(2);
                         l_name=rs.getString(3);
                         
                             %> <form name="<%=id%>" action="s2_approve_request" method="post"><table border="1" align="center">
                         <tr> <td><%=id%></td>
                          <td><%=f_name%></td>
                          <td><%=l_name%></td> 
                          <td><input type="submit" value="Approve Request" name="<%=rs.getString(1)%>" /></td>
                          <td><input type="hidden" name="user_id" value="<%=id%>" />
                      </tr></table></form>
                      <%}%>
            
        
        </div>
                      <% if(checked==false){%><h3 align="center">You have No waiting Request Form Department</h3><%}%>
    </body>
</html>
