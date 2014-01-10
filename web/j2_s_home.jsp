<%-- 
    Document   : j2_s_home
    Created on : 9 Dec, 2013, 12:57:08 AM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<%@page import="c_c_db_package.*" %>
<%
   student s=new student();
   student fetch=new student();
    fetch=s.fetchStudent((String)session.getAttribute("live_user"));
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student home</title>
    </head>
    <body>
        <h1 align="center">Student profile</h1>
        <input type="button" value="Log Out" name="log_out" style="margin-left: 90%" onclick="window.location.href='./s2_log_out'"/>
        <div style="background-image: url(./graphics/div_flat_pink.png);margin-left:30%;margin-right:30%  ">
            <table border="0" align="center">
              
                <tbody>
                    <tr>
                        <td>User ID</td>
                        <td><b><%=fetch.getUser_id()%></b></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><b><%=fetch.getF_name()%>&nbsp;<%=fetch.getM_name()%>&nbsp;<%=fetch.getL_name()%></b></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h3>Educational</h3></td>
                        
                    </tr>
                    <tr>
                        <td>Enrollment</td>
                        <td><%=fetch.getUser_id()%></td>
                    </tr>
                    <tr>
                        <td>Department</td>
                        <td><%=fetch.getDept()%></td>
                    </tr>
                    <tr>
                        <td>Batch Year</td>
                        <td><%=fetch.getBatch_year()%></td>
                    </tr>
                    <tr>
                        <td>Level</td>
                        <td><%=fetch.getLevel()%></td>
                    </tr>
                    <tr>
                        <td>Faculty Advisory</td>
                        <td><%=fetch.getFa()%></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h3>Personal</h3></td>
                        
                    </tr>
                    <tr>
                        <td>Self Mobile</td>
                        <td><%=fetch.getSelf_cell()%></td>
                    </tr>
                    <tr>
                        <td>Parents Mobile</td>
                        <td><%=fetch.getParent_cell()%></td>
                    </tr>
                    <tr>
                        <td>Current Add</td>
                        <td><%=fetch.getLocal_add()%></td>
                    </tr>
                    <tr>
                        <td>Native Add</td>
                        <td><%=fetch.getPer_add()%></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><%=fetch.getEmail()%></td>
                    </tr>
                </tbody>
            </table>

        </div>
    </body>
</html>
