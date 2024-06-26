import java.io.IOException;
import java.io.File;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "ResourceList", value = "/resources")
public class ResourceList extends HttpServlet{

    private static String admin_path = "/usr/local/tomcat/webapps/mywebbapp/data";
    private static String user_path = "/usr/local/tomcat/webapps/mywebbapp/normal_data";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        File directory;
        String id = request.getParameter("adminSecretToken");
        String request_session = String.valueOf(request.getSession().getAttribute("sessionPrivilage"));
        if(id.equals("S3cre7"))
            directory = new File(admin_path);
        else
            directory = new File(user_path);
        
        File[] files = directory.listFiles();
        request.setAttribute("session_name", request_session);
        request.setAttribute("files", files);
        request.getRequestDispatcher("list_resource.jsp").forward(request, response);
    }
}
