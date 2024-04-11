package xee;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "XMLParser", value = "/parseXML")
public class XmlParser extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            // Prepare to parse XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse XML from request input stream
            Document doc = dBuilder.parse(request.getInputStream());

            // Your XML parsing logic here
            // For example, extract data, process it, etc.
            doc.getDocumentElement().normalize();

            out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("User");
            out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    out.println("First Name : "
                            + eElement
                                    .getElementsByTagName("firstname")
                                    .item(0)
                                    .getTextContent());
                    out.println("Last Name: " + eElement
                                                        .getElementsByTagName("lastname")
                                                        .item(0)
                                                        .getTextContent()); 
                }
            }
            // Respond back
            // response.setContentType("text/html");
            // out.println("<html><body>");
            // out.println("XML processed successfully!");
            // out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
