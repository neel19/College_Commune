<%-- 
    Document   : j1_approved
    Created on : 8 Dec, 2013, 5:14:46 PM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Approved</title>
    </head>
    <%
    String msg="";
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
        
                    <h1 align="center">Approved</h1> 
                
                    <h3 align="center">Your <%=(String)session.getAttribute("temp_id")%> Account Has been Approved by the  Admin,<br/> Please Enter Profile Details</h3>
                
            
        <div align="center">
            <table>
                <tr>
                   <td><input type="button" value="Home" name="btn_home" onclick="window.location.href='./j1_home.jsp'"/></td>
                    <td>
            <form name="f1" action="s1_next_signup" method="POST">
                <input type="submit" value="Fill Details" name="btn1" />
            </form></td>
                <tr><td colspan="2"><%=msg%></td></tr>
            </table>    
        </div>
    </body>
</html>
