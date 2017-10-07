/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bhoopal
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "selected", urlPatterns = {"/selected"})
public class selected extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        try {
        } finally {
          //  out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String[] symptoms = request.getParameterValues("symptoms");

        PrintWriter pw = response.getWriter();
        //PrintWriter out = response.getWriter();
          

        //  pw.print("<html><head>Selected</head></html>");
        int i = 0;
        String[] selected = null;
        int[] a = new int[20];
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        HttpSession session=request.getSession();
        ArrayList<String> selectlist = new ArrayList<String>();
        ArrayList<String> option = new ArrayList<String>();
        ArrayList<String> query = new ArrayList<String>();

        try {
          //  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          //  con = DriverManager.getConnection("jdbc:odbc:aaa", "", "");
          
          con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\Symptoms.mdb");
            stmt = con.createStatement();
            pw.println("<html><head><title>Question Tab</title><link rel=\"shortcut icon\" href=\"img/favicons/favicon.ico\"><link rel='stylesheet' type='text/css' href='css/bootstrap.css'><link rel='stylesheet' type='text/css' href='css/align.css'>");
                    pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>");
                    pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script></head>");
            pw.println("<body>");
            
            pw.println("<nav class=\"navbar navbar-inverse navbar-fixed-top\"><div class=\"container-fluid\"><div class=\"navbar-header\">");
            pw.println("<a class=\"navbar-brand\" href=\"index.jsp\">MediAssist</a></div>");
            pw.println("<ul class=\"nav navbar-nav\"><li class=\"active\"><a href=\"index.jsp\">Home</a></li>");
            pw.println("</ul></div></nav>");
            pw.println("<header id=\"intro\">");
            pw.println("<div class=\"questiondiv \">");
            pw.println("<br><br><br><br><br><br><h1 class=h12>Questions </h1><hr>");
            for (String s : symptoms) {
                a[i] = Integer.parseInt(s);
                //   pw.println(a[i]);
                i++;
            }
           // pw.println("Count=" + i);
            //pw.println("You Have Selected folloing Symptoms");

            //for executing single query
            for (int j = 0; j < i; j++) {
                rs = stmt.executeQuery("Select * from Table1 where ID=" + a[j]);
                while (rs.next()) {
                    //pw.println(rs.getString("Symptom"));
                    // selected[count]=rs.getString("Symptom");   //PROBLEM WITH this code
                    // count++;
                    String select = rs.getString("Symptom");
                    selectlist.add(select);
                    //pw.println(select + " ");
                }
            }
            /*Iterator itr=selectlist.iterator();
            while(itr.hasNext()){
            pw.println(itr.next());
            }*/

            /*for(String obj:selectlist){
            pw.println(obj);
             */
        } catch (Exception e) {
            pw.println(e);
        }

        try {
            PrintWriter out = response.getWriter();
            File fXmlFile = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\src\\java\\tree.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
               String  words="";
            //out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("*");

            //pw.println("----------------------------");
            //pw.println(nList.getLength());
            int j = 0;
            pw.print("<form action='first' method='post'>");
            //for(int k=0;k<selected.length;k++){
            for (int l=0;l<selectlist.size();l++) {
                String obj=selectlist.get(l);
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if (obj.equals(nNode.getNodeName())) {
                       // pw.println("sucess " + nNode.getNodeName());
                        NodeList nList1 = nNode.getChildNodes();
                        pw.print("<h4 ><b>Is the selected symptom accompained with following "+obj+" ?</b></h4>");
                        for (int s = 0; s < nList1.getLength(); s++) {
                            if (!(nList1.item(s).getNodeName()).equals("#text")) {
                               // pw.println("<h1>" + nList1.item(s).getNodeName() + "</h1>");
                                option.add(nList1.item(s).getNodeName());
                                query.add(obj);
                                pw.print("<input type='radio' name="+obj+" value=" + nList1.item(s).getNodeName() + ">" + nList1.item(s).getNodeName());
                                pw.print("&nbsp;&nbsp;&nbsp;&nbsp;");

                            }
                        }
                    }
                }
               words=words+" "+selectlist.get(l);
               //pw.println(words);

            }
                   session.setAttribute("Query",words);

              //request.setAttribute("selectlist",selectlist);
              pw.print("<br><br><br><input type='submit' class='button' value='Next question'></form></div></header>");
              pw.print("<div class=xmldiv align=center>");
              pw.print("<br><img src=\"img/abdominalXML.png\" height=\"450px\" width=\"350px\" >");
              pw.print("<figcaption class=imgcap >Sample XML Tree view.</figcaption>");
              pw.print("</div>");
              
              pw.print("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

