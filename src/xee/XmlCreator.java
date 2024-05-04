package xee;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.io.OutputStreamWriter;
import java.net.URL;

@WebServlet(name = "XmlCreator", value = "/makexmlrequest")

public class XmlCreator extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException{
            response.setContentType("text/html");

            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbBuider = dbFactory.newDocumentBuilder();
                Document doc = dbBuider.newDocument();

                Element rootElem = doc.createElement("User");
                doc.appendChild(rootElem);

                Element firstname = doc.createElement("firstname");
                rootElem.appendChild(firstname);
                firstname.appendChild(doc.createTextNode(fname));

                Element lastname = doc.createElement("lastname");
                rootElem.appendChild(lastname);
                lastname.appendChild(doc.createTextNode(lname));

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");

                // Use a StringWriter as the result stream
                StringWriter writer = new StringWriter();
                StreamResult result = new StreamResult(writer);
                DOMSource source = new DOMSource(doc);

                // Transform the XML
                transformer.transform(source, result);
                String xmlString = result.getWriter().toString();

                URL url = new URL("http://localhost:8080/mywebbapp/parseXML");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/xml");
                try (OutputStreamWriter OSwriter = new OutputStreamWriter(conn.getOutputStream())) {
                    OSwriter.write(xmlString);
                }

                int responseCode = conn.getResponseCode();
                response.getWriter().println(responseCode);
                response.getWriter().println(xmlString);
                // System.out.println("Response Code : " + responseCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
