<%-- 
    Document   : home
    Created on : 8 Dec, 2013, 1:11:26 PM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
        <div align="right">
        <div style="background-image: url(./graphics/div_green.png);margin-left:75%;" >
            <form name="f1" action="s1_user_check" method="post">
                <table>
                    <tr>
                        <td colspan="2">
                            <h2 align="right">Access Account</h2>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            User ID
                        </td>
                        <td>
                            <input type="text" id="focus" name="user_id" value="" />
                        </td>
                        
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="Check" />
                        </td>
                    </tr>
                </table>              
            </form>
        </div>
           
            <div style="background-image: url(./graphics/div_blue.png);margin-left:75%  " >
            <form name="f1" action="s1_user_check" method="post">
                <table>
                    <tr>
                        <td colspan="2">
                            <h3 align="right">New Account?</h3>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Enter Enrollment
                        </td>
                        <td>
                            <input type="text" name="user_id" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right"><font style="font-style: italic;color: red"><%=msg%></font>
                            <input type="submit" value="Apply for account" />
                        </td>
                    </tr>
                </table>                               
            </form>
        </div>
     </div>     
    </body>
</html>
