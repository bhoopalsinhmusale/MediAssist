/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileDeleteStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bhoopal
 */
@WebServlet(urlPatterns = {"/ParseHtmlServlet1"})
public class ParseHtmlServlet1 extends HttpServlet {

    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
//ParseHtml.jsp

    public static String extractHtml(String url1, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        url1 = "http" + url1.substring(url1.indexOf(":"));
        PrintWriter sout = response.getWriter();
        Document doc = Jsoup.parse(new URL(url1),5999000);
        Elements body = doc.select("head");
        String s = body.text();
        body = doc.select("h1");
        s += ". " + body.text();
        // sout.print(s);

        body = doc.select("p");
        s += ". " + body.text();

        s = s.replace("|", ".");
        s = s.replace("-", ".");
        s = s.replace(":", ".");

        sout.print("  ");
        //sout.print(s);

        return s;

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,HttpSession session)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        /* TODO output your page here. You may use following sample code. */
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result Link Tab</title><link rel=\"shortcut icon\" href=\"img/favicons/favicon.ico\"><link rel='stylesheet' type='text/css' href='css/bootstrap.css'><link rel='stylesheet' type='text/css' href='css/align.css'>");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script></head>");
        out.println("<title>Servlet Parse</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<nav class=\"navbar navbar-inverse navbar-fixed-top\"><div class=\"container-fluid\"><div class=\"navbar-header\">");
        out.println("<a class=\"navbar-brand\" href=\"index.jsp\">MediAssist</a></div>");
        out.println("<ul class=\"nav navbar-nav\"><li class=\"active\"><a href=\"index.jsp\">Home</a></li>");
        out.println("</ul></div></nav>");
        out.println("<header id=\"intro\">");
           out.println("<div class=\"questiondiv \">");
            out.println("<br><br><br><br><br><br><h1 class=h12>Web Search Results</h1><hr>");
        
         out.print("<form id='parseHtml1' name='parseHtml1' action='frequency.jsp' method='POST'>");
  
         
    String termName = session.getAttribute("Query").toString();
    termName="Diagnosis for "+termName;
//sahilback.jsp
            //String termName = session.getAttribute("Query").toString();
        //String termName = "headache";
      
       
        int count = 40;
        String[] urlthis = new String[count];
        String searchURL = GOOGLE_SEARCH_URL + "?q=" + termName + "&num=" + count;

        int i = 0;    int j = 0;
        try {
            Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

            Elements results = doc.select("h3.r >a");
        

            for (Element result : results) {

                String linkHref = result.attr("href");
                if(!linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("https://patient.info/") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).endsWith(".pdf") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("http://www.academia.edu/") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).endsWith("pdf") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("https://www.omicsonline") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).endsWith("text") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("http://www.scielo")  && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).endsWith("download")){
                if (!linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("?q=" + termName) && j<10) {
                     if (!linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("/") ) {
                     if (!linkHref.substring(6, linkHref.indexOf("&")).substring(1).endsWith(".txt") && !linkHref.substring(6, linkHref.indexOf("&")).substring(1).contains("pdf")) {
                     if(linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("http://www.")  || linkHref.substring(6, linkHref.indexOf("&")).substring(1).startsWith("https://www.")){
                    String linkText = result.text();
                    urlthis[j] = linkHref.substring(6, linkHref.indexOf("&")).substring(1);
                  
                    // response.sendRedirect("ParseHtml.jsp?val="+url);
 j++;
                }}}}}}
            
        } catch (Exception e) {
            out.println("++++++++Exception++++++" + e);
        }
       File fin1 = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files");

         for (File file : fin1.listFiles()) {
         FileDeleteStrategy.FORCE.delete(file);
         } 
         File fin2 = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\output");

         for (File file : fin2.listFiles()) {
         FileDeleteStrategy.FORCE.delete(file);
         } 
         File fin3 = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\urls");

         for (File file : fin3.listFiles()) {
         FileDeleteStrategy.FORCE.delete(file);
         } 
         File fin4 = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\frequency");

         for (File file : fin4.listFiles()) {
         FileDeleteStrategy.FORCE.delete(file);
         } 

        PrintWriter out1 = response.getWriter();
        int zz = 0;
//out1.write("<br><h1> Total URLs Fetched=>"+j);
        for (zz = 0; zz <j; zz++) {
            out1.write("<br><h4> Link "+zz+" =>"+ urlthis[zz] + "</h4>");
        }
        int z = 0;
         //File bb3=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\urls");
        //       FileUtils.cleanDirectory(bb3);

        File outfile1 = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\urls\\reterivedURLS.txt");
        outfile1.createNewFile();
        FileWriter fw6 = new FileWriter(outfile1, true);
        BufferedWriter bw6 = new BufferedWriter(fw6);
        PrintWriter pw6 = new PrintWriter(bw6);
        for (z = 0; z <j; z++) {
            //write url in urls/reterivedURLS.txt
            pw6.println("D" + (z+1) + "=" + urlthis[z]);

            String p = extractHtml(urlthis[z], request, response);

            URL htmlpatseroutputfileUrl = new URL(urlthis[z]);
            //File htmlparseroutputfile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files\\htmlparseroutputfile of "+htmlpatseroutputfileUrl.getHost()+".txt");
               File htmlparseroutputfile = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files\\D" + z  + ".txt");

            FileWriter fw = new FileWriter(htmlparseroutputfile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(p);
            pw.close();

            URL urlout = new URL(urlthis[z]);
            URL urlstopwordfile = new URL(urlthis[z]);
          //File outfile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files\\output of "+urlout.getHost()+".txt");
            // File outfile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\output\\output of "+urlout.getHost()+".txt");
           File outfile = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\output\\O" + z + ".txt");

            //File stopwordfile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files\\stopwords of "+urlstopwordfile.getHost()+".txt");
            outfile.createNewFile();
            //stopwordfile.createNewFile();
            FileWriter fw1 = new FileWriter(outfile, false);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
            pw1.print("");
            pw1.close();
            String data = new String();
            String[] x = null;
            try {
                                // Open the file that is the first
                // command line parameter
                FileInputStream fstream = new FileInputStream(htmlparseroutputfile);

                                // Convert our input stream to a
                // DataInputStream
                DataInputStream in = new DataInputStream(fstream);

                                // Continue to read lines while
                // there are still some left to read
                while (in.available() != 0) {
                    // Print file line to screen
                    data = in.readLine();
                    //out.println ("Input File Data :\n"+data);
                }
                out.println("\n");
                in.close();
            } catch (Exception e) {
                System.err.println("File input error");
            }

                        //**********************MS Access Connectivity***************
            Connection con;
            Statement stmt;
            ResultSet rs;

            try {
                con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\db11.accdb", "", "");
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM stopwordtable");
                //out.println("database stopwords:");
                i = 0;
                x = new String[1024];              // table of stop words

                while (rs.next()) {
                    x[i] = rs.getString("word");

                    //out.println(" "+x[i]);
                    i++;
                }
                //out.println("\n");
            } catch (SQLException e) {
                out.println("Hello World!" + e);
            }

         //****************Stop word removal********************************
            char[] fdata = data.toCharArray();
            char[] temp = new char[1024];
            String newdata = new String();
            String tem;
            int k = 0, n;

            for (i = 0; i < data.length(); i++) {
                if (fdata[i] == ' ' || fdata[i] == '.' || fdata[i] == ',' || fdata[i] == '!' || fdata[i] == ':' || fdata[i] == ';' || fdata[i] == '"' || fdata[i] == '\'' || fdata[i] == '?' || fdata[i] == '[' || fdata[i] == ']' || Character.isDigit(fdata[i])) {
                    tem = new String(temp, 0, k);
                    //out.println("current word: " +tem);
                    k = 0;
                    int flag = 0;
                    //code for comapring word with stoptable words....
                    for (n = 0; n < 320; n++) {
                        if (x[n].equalsIgnoreCase(tem)) {

                            // out.println("n: " +(n+1));
                            //out.println("Stop word: " +x[n]);
                            flag = 1;
                            break;

                        } else {
                              //out.println("n: " +(n+1));
                            //out.println("else tem: " +tem);
                            continue;

                        }

                    }
                    if (flag == 1) {
                        /*  FileWriter fw2 = new FileWriter(stopwordfile,true);
                         BufferedWriter bw2 = new BufferedWriter(fw2);
                         PrintWriter pw2 = new PrintWriter(bw2);
                         pw2.println("");
                         pw2.println(x[n]);
                         pw2.close();*/

                    } else {
                        FileWriter fw3 = new FileWriter(outfile, true);
                        BufferedWriter bw3 = new BufferedWriter(fw3);
                        PrintWriter pw3 = new PrintWriter(bw3);
                        pw3.print(" ");
                        pw3.print(tem);
                        pw3.close();

                    }

                } else {
                    temp[k] = fdata[i];
                    k++;
                }
            }

            tem = new String(temp, 0, k);
            //out.println("current word: " +tem);
            k = 0;
            int flag = 0;
            //code for comapring word with stoptable words....
            for (n = 0; n < 5; n++) {

                if (x[n].equalsIgnoreCase(tem)) {

                           // out.println("n: " +(n+1));
                    //out.println("Stop word: " +x[n]);
                    flag = 1;
                    break;

                } else {
                              //out.println("n: " +(n+1));
                    //out.println("else tem: " +tem);
                    continue;

                }

            }
            if (flag == 1) {
                /* FileWriter fw4 = new FileWriter(stopwordfile,true);
                 BufferedWriter bw4 = new BufferedWriter(fw4);
                 PrintWriter pw4 = new PrintWriter(bw4);
                 pw4.println("");
                 pw4.println(x[n]);
                 pw4.close();*/

            } else {
                FileWriter fw5 = new FileWriter(outfile, true);
                BufferedWriter bw5 = new BufferedWriter(fw5);
                PrintWriter pw5 = new PrintWriter(bw5);
                pw5.print(" ");
                pw5.print(tem);
                pw.close();

            }

        }

        pw6.close();
   
        
        out.print("<script >alert('processing done'); </script>");
          out.println("<input type='Submit' class='button' value='Create Database'>");
          out.print("</form>");
        out.println("</div></header></body>");
        out.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session=request.getSession();
            processRequest(request, response,session);
        } catch (Exception ex) {
          //  Logger.getLogger(Parse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
