import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", value = "/servlet1")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        LoginDao ld = new LoginDao();

        String n = request.getParameter("username");
        String p = request.getParameter("userpass");
        boolean valid = false;
        try {
            valid = ld.validate(n, p);
        } catch (SQLException e) {
            out.println("Error message: " + e.getMessage());
            out.println("Error code: " + e.getErrorCode());
            out.println("SQL state: " + e.getSQLState());
        } catch (Exception ee){
            out.println(ee.getMessage());
        }


        if (valid) {
            RequestDispatcher rd = request.getRequestDispatcher("welcom_page.jsp");
            HttpSession sess = request.getSession();
            if(n == "admin"){
                sess.setAttribute("sessionPrivilage", "admin");
            }
            else
                sess.setAttribute("sessionPrivilage", "user");
            rd.forward(request, response);
        } else {
            out.print("Sorry username or password error");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }

        out.close();
    }

}