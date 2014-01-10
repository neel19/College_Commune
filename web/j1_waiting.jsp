<%-- 
    Document   : j1_waiting
    Created on : 8 Dec, 2013, 4:42:16 PM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Keep Patience </title>
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
    
         if(msg==null)
                                  {msg="";  }

    %>
    
    <body>
        <div>
        <h1 align="center">Still Waiting!!!</h1>
        <h2 style="color: greenyellow" align="center"><%=msg%></h2>
        <h3 align="center"> Your Account Request Has been placed...<br/>
            please Wait until DA response
        </h3>
        <form action="j1_home.jsp" method="post">
            <input type="submit" value="Back To Home" name="Back" style="margin-left: 45%" />
        </form>
        </div>
    </body>
</html>
