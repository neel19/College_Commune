<%-- 
    Document   : j1_s_signup
    Created on : 9 Dec, 2013, 1:53:12 AM
    Author     : HBB20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="main_header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Sign Up</title>
    </head>
    <body>
        <h1 align="center">Student Sign up</h1>
        <form action="s1_s_signup" method="post">
          <table align="center">
              <tr><td>  
            <div style="background-image: url(./graphics/div_flat_pink.png);margin-left:30%;margin-right:30%  ">
                <table>
                    <tr><td colspan="3"><h3>Name</h3></td></tr>
                    <tr>
                        <td>First Name</td>
                        <td>Middle Name</td>
                        <td>Last Name</td>
                   </tr>
                   <tr>
                       <td align="right"><input type="text" name="f_name" value="" size="12"  /></td>
                       <td><input type="text" name="m_name" value="" size="12" /></td>
                       <td><input type="text" name="l_name" value="" size="12" /></td>
                   
                   </tr>
                   <tr></tr>
                   <tr><td>
                   <h3> Contact Details:</h3></td>
                   </tr>
                   <tr><td align="right"> Self cell</td>
                       <td colspan="2"><input type="text" name="self_cell" value="" /></td>
                   <tr>
                       <td align="right">Parent Cell</td>
                       <td colspan="2"><input type="text" name="parent_cell" value="" /></td>
                   </tr>
                    <tr>
                       <td align="right">Email</td>
                       <td colspan="2"><input type="text" name="email" value="" /></td>
                    </tr>
                   <tr></tr>
                   <tr><td align="right"><h3>Address</h3></td></tr>
                   <tr>
                       <td align="right">Local</td>
                       <td colspan="2"><input type="text" name="local_add" value="" /></td>
                   </tr>
                   <tr>
                       <td align="right">Native</td>
                       <td colspan="2"><input type="text" name="per_add" value="" /></td>
                   </tr>
                   
                </table>
            </div>
                  </td>
                  <td colspan="12"></td>
                  <td>
            <div style="background-image: url(./graphics/div_flat_pink.png);margin-left:30%;margin-right:30%  ">
            <table>
                <tr>
                    <td colspan="3"><h2>Educational</h2></td>                  
                </tr>
                <tr>
                    <td align="right">GTU enrollment</td> 
                    <td><input type="text" name="user_id" value="<%=(String)session.getAttribute("temp_id")%>" readonly="readonly">
                    
                </tr>
                <tr>
                    <td align="right">Batch year</td>
                    <td> <select name="batch_year">
                            <option value="2008">2008</option>
                            <option value="2009">2009</option>
                            <option value="2010">2010</option>
                            <option value="2011">2011</option>
                            <option value="2012">2012</option>
                            <option value="2013">2013</option>
                            
                        </select>
                        
                </tr>
                <tr>
                    <td align="right"> Current Level</td>
                    <td> <select name="level">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                                                       
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Department
                    </td>
                <td><select name="dept">
                          <option value="IT">Info. Tech.</option>
                    <option value="CE">Computer Eng.</option>
                    <option value="EC">Electronics & Comm.</option>
                    <option value="FT">Food Processing</option>
                </select></td>
              </tr>
                <tr>
                    <td align="right">Faculty Advisory</td>
                    <td><input name="fa" type="text"></td>
                </tr>
                <tr><td><input type="text" hidden="hidden"><td></tr>
                
                <tr><td colspan="2"><h2>Authentication</h2></td></tr>
                <tr>
                    <td align="right">User ID</td> 
                    <td><input type="text" name="user_id" value="<%=(String)session.getAttribute("temp_id")%>" readonly="readonly">
                    
                </tr>
                <tr><td>password</td><td><input type="password" name="pwd1" value="" /></td></tr>
                <tr><td>RE-password</td><td><input type="password" name="pwd2" value="" /></td></tr>

                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr><td align="right"><input type="button" value="Back" name="btn_back" onclick="window.location.href='./j1_approved.jsp'"/></td>
                   <td><input type="submit" value="Submit" name="btn_submit" /></td></tr>
                <tr><td><input type="hidden" name="hh" value="" /><td></tr>
            </table>
        </div>
              </tr></table><!-- first name,middle,last,self mobile,parent mobile,local address,permenent -->
        </form>
                    
    </body>
</html>
