<%-- 
    Document   : j1_login
    Created on : 8 Dec, 2013, 2:38:22 PM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
         <script>window.onload=function(){
             document.getElementById("focus").focus();
        }</script>
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
        <div align="center" style="background-image: url(./graphics/div_flat_back_pink.png);margin-left:30%;margin-right:30%  ">
            <form action="s1_login_check" method="post">
                <table align="center">
                    
                        <tr>
                            <td colspan="2" align="center">
                                <h3> Enter Details</h3>
                            </td>
                            
                        </tr>
                        <tr>
                            <td>User Id</td>
                            <td><input type="text" name="user_id" value="<%=(String)session.getAttribute("temp_id")%>" readonly="readonly" /></td>
                            
                    </tr>
                    <tr>
                            <td>Password</td>
                            <td><input type="password" id="focus" name="password" value="" tabindex="-1" /></td>
                            
                    </tr>
                    <tr><td style="color: #3300ff" colspan="2"><%=msg%></td></tr>
                    <tr><td style="color: #00ffff" colspan="2">The account has been registered already.</td></tr>
                    <tr>
                        <td><input type="button" value="Home" name="btn_home" onclick="window.location.href='./j1_home.jsp'"/></td>
                        <td><input type="submit" value="GetIn" /></td>
                    </tr>
                </table>
            </form>
            
        </div>
    </body>
</html>
