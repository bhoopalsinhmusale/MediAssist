/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bhoopal
 */
@WebServlet(name = "first", urlPatterns = {"/first"})
public class first extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet first</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet first at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        pw.print("<h1>ABC</h1>");
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter pw = response.getWriter();
        HttpSession session=request.getSession();
        String query="";
        pw.println("<html><head><title>Question Tab</title><link rel=\"shortcut icon\" href=\"img/favicons/favicon.ico\"><link rel='stylesheet' type='text/css' href='css/bootstrap.css'><link rel='stylesheet' type='text/css' href='css/align.css'>");
                    pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>");
                    pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script></head>");
            pw.println("<body><style>h1{color:black;font-weight:bold;}h4{color:black;font-weight:bold;}table{font-family: arial, sans-serif;width: 100%;color:black;}");
            pw.println("td,th{border: 1px solid #dddddd;text-align: left;padding: 8px;font-style: normal;font-weight: bold;}");
            pw.println("tr:nth-child(odd,even) {background-color: #dddddd;}");
            pw.println("</style>");
            
            pw.println("<nav class=\"navbar navbar-inverse navbar-fixed-top\"><div class=\"container-fluid\"><div class=\"navbar-header\">");
            pw.println("<a class=\"navbar-brand\" href=\"index.jsp\">MediAssist</a></div>");
            pw.println("<ul class=\"nav navbar-nav\"><li class=\"active\"><a href=\"index.jsp\">Home</a></li>");
            pw.println("</ul></div></nav>");
             pw.println("<header id=\"intro\">");
            pw.println("<div class=\"questiondiv bg-color\">");
            pw.println("<br><br><br><br><br><br><h1 >Question</h1><hr>");
        //pw.print("<h1>ABC</h1>");
        try {
            Enumeration en = request.getParameterNames();
            query=session.getAttribute("Query").toString();
            while (en.hasMoreElements()) {
                pw.print("<form action='second' method='post'>");

                Object objOri = en.nextElement();
                String param = (String) objOri;
                String value = request.getParameter(param);
               File fXmlFile = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\src\\java\\tree.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
                NodeList root = doc.getElementsByTagName(value);
                for (int i = 0; i < root.getLength(); i++) {
                    NodeList nList = root.item(i).getChildNodes();
                    pw.print("<h4><b>Is the selected symptom accompained with following " + value + " ?</b></h4>");
                    for (int s = 0; s < nList.getLength(); s++) {
                        if (!(nList.item(s).getNodeName()).equals("#text")) {
                            
                            // pw.println("<h1>" + nList1.item(s).getNodeName() + "</h1>");
                            
                            pw.print("<input type='radio'  name=" + value + " value=" + nList.item(s).getNodeName() + ">" + nList.item(s).getNodeName());
                             //session.setAttribute("Query1", nList.item(s).getNodeName());
                            pw.print("&nbsp;&nbsp;&nbsp;&nbsp");
                        }
                    }

                    // pw.println("Parameter Name is '" + param + "' and Parameter Value is '" + value + "'");
                }
                             query=query+" "+value;
              
            }
             //pw.println("<h1>"+query+"</h1>");
            session.setAttribute("Query", query);
               pw.print("<br><br><input type='submit' class='button' value='Next'></form></div></header>");
               
               pw.print("<div class=xmldiv align=center>");
              pw.print("<br><img src=\"img/abdominalXML.png\" height=\"450px\" width=\"350px\" >");
              pw.print("<figcaption class=imgcap >Sample XML Tree view.</figcaption>");
              pw.print("</div>");
              
              pw.print("</body></html>");
               
               
        } catch (Exception e) {
            pw.print(e);
        }
        //for(int i=0;i<selectlist.size();i++){
        //pw.print("<h1>"+selectlist.get(i)+"</h1>");
        //}
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
