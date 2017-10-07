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

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bhoopal
 */
@WebServlet(name = "connect1", urlPatterns = {"/connect1"})
public class connect1 extends HttpServlet {

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
        } finally {
            out.close();
        }
    }
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        String[] val = new String[20];
        int i = 0;
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\Symptoms.mdb");
            stmt = con.createStatement();
            
            pw.println("<html><body><head><link rel='stylesheet' type='text/css' href='css/align.css'></head><style>h1{color:white;font-weight:bold;}table{font-family: arial, sans-serif;width: 50%;color:white;float:left;table-layout: fixed;}");
            pw.println("td,th{border: 1px solid #dddddd;text-align: left;padding: 8px;font-style: normal;font-weight: bold;}");
            pw.println("tr:nth-child(odd,even) {background-color: #dddddd;}");
            pw.println("h5{color}</style>");
            pw.println("<h1>Symptoms Table</h1>");
            pw.println("<h5 class=note>Choose Multiple Symptoms</h5>");
            pw.println("<form method='post'>");
            rs = stmt.executeQuery("SELECT* FROM Table1 limit 0,7");
            
            /*pw.println("<style>table{font-family: arial, sans-serif;width: 100%;color: #FFF;}");
            pw.println("td,th{border: 1px solid #dddddd;text-align: left;padding: 8px;font-style: normal;font-weight: bold;}");
            pw.println("tr:nth-child(odd,even) {background-color: #dddddd;}");
            pw.println("</style>");*/
            pw.println("<a href='#' data-dismiss='modal' class='close-link'><i class='icon_close_alt2'></i></a>");
            pw.println("");
            pw.println("\n<table border=2><col width='12'><col width='55'><col width='21'><tr><th>Id</th><th>Name</th><th>Choice</th></tr>");
            
            
            while (rs.next()) {
                pw.println("<tr><td>" + rs.getInt("ID"));
                pw.println("</td><td>" + rs.getString("Symptom"));
                i++;
                pw.println("</td><td><input type='checkbox' name='symptoms' value=" + i);
                pw.println("</td></tr>");
            }
            
            
            rs1 = stmt.executeQuery("SELECT* FROM Table1 limit 7,14");
            
            pw.println("\n<table border=2><col width='12'><col width='55'><col width='21'><tr><th>Id</th><th>Name</th><th>Choice</th></tr>"); 
           while (rs1.next()) {
                pw.println("<tr><td>" + rs1.getInt("ID"));
                pw.println("</td><td>" + rs1.getString("Symptom"));
                i++;
                pw.println("</td><td><input type='checkbox' name='symptoms' value=" + i);
                pw.println("</td></tr>");
            }


            pw.println("</table><br><br>");
            //pw.println("<a href='selected' data-toggle='modal' data-target='myModal'>Select Symptoms</a>");
            pw.println("<input type='submit' formaction='selected'>");
            //pw.println("<button class='btn btn-primary' data-dismiss='modal' data-toggle='modal' data-target='#topModal'>Open Modal</button>");
            pw.println("</form>");
                  
                    pw.println("</body></html>");
        } catch (SQLException e) {
            pw.println(e.getNextException());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (Exception e) {
                pw.print(e);
                pw.close();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
