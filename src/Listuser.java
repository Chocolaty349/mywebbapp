import java.io.*;
import java.sql.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import util.DBUtil;

@WebServlet(name = "Listuser", value = "/showuser")
public class Listuser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Connection con = DBUtil.getConnection("jdbc:mysql://localhost:3306/User", "root", "password");
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<table border='1'><tr><th>number</th><th>lastname</th><th>firstname</th></tr>");

            while (rs.next()) {

                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                out.println("<tr><td>" + name + "</td><td>" + email + "</td>" + "<td>" + password + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}