<%-- 
    Document   : j1_suspend
    Created on : 8 Dec, 2013, 2:01:16 PM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
    </head>
    <body>
        <div style="align:center">
            <h1 align="center">
                Sorry!
            </h1>
            <h3 align="center" style="margin-left: 20%;margin-right: 20%">
                Your Account has Been Suspended by the Departmental Admin.
                
            </h3>
            <form action="j1_home.jsp" method="post" >
                <input type="submit" value="Back To Home" style="margin-left: 45%" name="Back" />
        </form>
        </div>
    </body>
</html>
