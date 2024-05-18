import java.io.IOException;
import java.io.File;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "ResourceList", value = "/resources")
public class ResourceList extends HttpServlet{

    private static String admin_path = "/opt/tomcat/apache-tomcat-10.1.23/webapps/mywebbapp/data";
    private static String user_path = "/opt/tomcat/apache-tomcat-10.1.23/webapps/mywebbapp/normal_data";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        File directory;
        if("admin".equals(request.getSession().getAttribute("sessionPrivilage")))
            directory = new File(admin_path);
        else
            directory = new File(user_path);
        
        File[] files = directory.listFiles();
        request.setAttribute("file_count", files.length);
        request.setAttribute("files", files);
        request.getRequestDispatcher("/list_resource.jsp").forward(request, response);
        
    }
}
