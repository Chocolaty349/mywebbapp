import java.io.*;
import java.sql.*;

import util.DBUtil;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "UpdateUser", value = "/update")
public class UpdateUser extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            PrintWriter out =  response.getWriter();
            try {
                Connection con = DBUtil.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "password");
                Statement stmt = con.createStatement();
                String sql = "insert into employees value (" 
                + request.getParameter("employeeNumber") + ",'"
                + request.getParameter("lastName") + "','"
                + request.getParameter("firstName") + "','"
                + request.getParameter("extension") + "','"
                + request.getParameter("email") + "','"
                + request.getParameter("officeCode") + "',"
                + request.getParameter("reportTo") + ",'"
                + request.getParameter("jobTitle") + "')";
                int state = stmt.executeUpdate(sql);
                if (state != 0) {
                    out.println("succes");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
