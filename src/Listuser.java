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
            // Class.forName("com.mysql.jdbc.Driver");
            // Connection con = DriverManager.getConnection(url, user, password);
            Connection con = DBUtil.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "password");
            Statement stmt = con.createStatement();
            // String sql = "SELECT employeeNumber, lastName, firstName FROM employees where
            // employeeNumber = "
            // + request.getParameter("number")
            // + " and firstName = '" + request.getParameter("firstName")
            // + "' and lastName = '" + request.getParameter("lastName") + "'";
            String sql = "SELECT employeeNumber, lastName, firstName FROM employees where employeeNumber = "
                    + request.getParameter("number");
            ResultSet rs = stmt.executeQuery(sql);

            out.println("<html><body>");
            out.println("<table border='1'><tr><th>number</th><th>lastname</th><th>firstname</th></tr>");

            while (rs.next()) {

                int number = rs.getInt("employeeNumber");
                String lastname = rs.getString("lastName");
                String firstname = rs.getString("firstName");

                out.println("<tr><td>" + number + "</td><td>" + lastname + "</td>" + "<td>" + firstname + "</td></tr>");
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