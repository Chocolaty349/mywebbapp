<!DOCTYPE html>
<html>
<%@ page import="jakarta.servlet.*" language="java" %>
    <head>
        <title>
            welcome page
        </title>
    </head>
    <body>
    <h1 align="center">Your information</h1>
    <table border=1 align="center">
        <tr>
            <th>Field list</th><th>VALUE</th>
        </tr>
        <tr>
            <td>name</td><td><%= request.getParameter("username")%></td>
        </tr>
        <tr>
            <td>Session attribute</td><td></td>
        </tr>
    </table>
    </body>
</html>

