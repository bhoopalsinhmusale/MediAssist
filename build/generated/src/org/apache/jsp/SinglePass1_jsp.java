package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public final class SinglePass1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 static String[] doc2;
        TreeMap<String, Integer> frequencyData=new TreeMap<String, Integer>();
    public static int getCount(String word, TreeMap<String, Integer> frequencyData)
    {
    	
        if (frequencyData.containsKey(word))
        {  // The word has occurred before, so get its count from the map  
            return frequencyData.get(word); // Auto-unboxed  
        }
        else
        {  // No occurrences of this word  
            return 0;
        }
    }
        
        
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Clustering Tab</title><link rel=\\\"shortcut icon\\\" href=\\\"img/favicons/favicon.ico\\\">s\n");
      out.write("        <link rel='stylesheet' type='text/css' href='css/bootstrap.css'><link rel='stylesheet' type='text/css' href='css/align.css'>\n");
      out.write("        <script src=\\\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\\\"></script>\n");
      out.write("        <script src=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\\\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\"><div class=\"container-fluid\"><div class=\"navbar-header\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"index.jsp\">MediAssist</a></div>\n");
      out.write("        <ul class=\"nav navbar-nav\"><li class=\"active\"><a href=\"index.jsp\">Home</a></li>\n");
      out.write("        </ul></div></nav>\n");
      out.write("        \n");
      out.write("        <form action=\"SnipetsGenration.jsp\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

           
        Connection  con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\DataBases\\freq.accdb");
         
        Statement stmt = con.createStatement();
        
        int keywordCount=0;
        int TableCount=0;

        DatabaseMetaData md = con.getMetaData();
    ResultSet rs = md.getTables(null, null, "%", null);
    ResultSet rs1;
    String temp;
  while (rs.next()) {
        temp = rs.getString(3);
        if(!temp.contains("MSys")) {
            TableCount++;
            //out.print(temp);
            rs1=stmt.executeQuery("select keyword from "+rs.getString(3));
            while(rs1.next())
            {
                //out.print(rs1.getString("keyword"));
//                keyword[i]=rs1.getString("keyword");
                keywordCount++;
            }
                           

        }
  }
      
    

      // out.print("<br>Keyword count "+keywordCount);
        //out.println(" Table count "+TableCount+"<br>");
        
        String tableNames[]=new String[TableCount];
        String keyword12[]=new String[keywordCount];
rs.close();
stmt.close();




int k=0,m=0;
 stmt = con.createStatement();
 ResultSet rs2=md.getTables(null, null, "%", null);
    ResultSet rs3;
    while (rs2.next()) {
        temp = rs2.getString(3);
        if(!temp.contains("MSys")) {
                tableNames[m]=temp;
                m++;
            //out.print(temp);
            rs3=stmt.executeQuery("select keyword from "+rs2.getString(3));
            //out.print("<br>++++"+rs2.getString(3));
            while(rs3.next())
            {
                   //out.print(rs3.getString("keyword"));
               String abc=rs3.getString("keyword");
               int  countofkeywordintreemap=getCount(abc, frequencyData);
                  if(countofkeywordintreemap==0){frequencyData.put(abc, countofkeywordintreemap+1);
                   //out.print("<br>++++++++++++++++++++++++++++++++++++++++=="+countofkeywordintreemap);
               
            }
            }
                           

        }
    
      
    }

    //displaykeyword matrix
     Set set = frequencyData.entrySet();
                                                 Iterator iterator1 = set.iterator();
                                                 while(iterator1.hasNext()) {
                                                    Map.Entry mentry = (Map.Entry)iterator1.next();
                                                    //out.print("<br><br>key is: "+ mentry.getKey() + " & Value is: ");
                                                    //out.println(mentry.getValue());
                                                 keyword12[k]=mentry.getKey().toString();
                k++;
    
                                                 
                                                 }
                                                 
             /*                                    
                                                     for(int o=0;o<keyword12.length;o++){
        out.println("<br>################"+keyword12[o]);
    }*/
                                                     
  List<String> list = new ArrayList<String>(Arrays.asList(keyword12));
//out.println(list);
list.removeAll(Arrays.asList("", null));
//out.println(list);


String keyword[]=list.toArray(new String[0]);


                                       /*           for(int o=0;o<keyword.length;o++){
        out.println("<br>///////////////////"+keyword[o]);
    }
       */
keywordCount=keyword.length;





          double matrix[][]=new double[TableCount][keywordCount];
         stmt = con.createStatement();
          ResultSet rs4,rs5;
          //boolean rs5;
int i,j;
      
       for( i=0;i<TableCount;i++){

            for ( j = 0; j <keywordCount; j++) {
          
               
                           rs5=stmt.executeQuery("select * from "+tableNames[i]+" where keyword='"+keyword[j]+"'");
               int count=0;
                           while(rs5.next())
                           {count++;}
         if(count==0){       
            
              
                matrix[i][j]=0;
                //out.print("&nbspmatrix["+i+"]["+j+"]="+matrix[i][j]);
            
            }
            else{
                   rs4=stmt.executeQuery("select * from "+tableNames[i]+" where keyword='"+keyword[j]+"'");  
                    while(rs4.next()){
                        matrix[i][j]=(rs4.getInt("value"));
           }  
               // out.print("&nbspmatrix["+i+"]["+j+"]="+matrix[i][j]);
           }
                
                
            }
                
            
            }
       
       //++++++++++++++++++++++++++++++++++++++
       //out.println("<br><br>Input Matrix For SinglePass Clustering : <br><br>"+TableCount+" "+keywordCount+"<br>");
       for (i = 0; i< TableCount ;i++) 
		{
                   //out.println("{");
            for (j = 0; j< keywordCount; j++) 
            {
                //out.print("["+matrix[i][j]+"]");
            }
           // out.println("},<br>");

                }
     //out.println(" <br><br>");
       
        double [][]doc=matrix;//{{1,2,0,0,1},{3,1,2,3,0},{3,0,0,0,1},{2,1,0,3,0},{2,2,1,5,1}};
        
        double cluster[][]=new double[TableCount][TableCount];
        
        double CR[][]=new double[TableCount][keywordCount];
        
        int flag[]={0,0,0,0,0,0,0,0,0,0};
        //int i,j,k;
        double threshold;
        
        for(i=0;i<TableCount;i++)
        {
            for(j=0;j<TableCount;j++)
            {
                cluster[i][j]=-1;// let initially no cluster cluster={{-1,-1,-1,-1,-1},{}}
            }
        }
        
        //Step 1:
        for(i=0;i<keywordCount;i++)
        {
            CR[0][i]=doc[0][i];
        }
        
        
        cluster[0][0]=0;
        int row_cnt=0,col_cnt=0;
        for(int count=1;count<TableCount;count++)
        {
            
            int p=row_cnt+1;
            
            for(i=0;i<p;i++)
            {
                double num=0,den1=0,den2=0;
                if(flag[count]==0)
                {
                    for(j=0;j<keywordCount;j++)
                    {
                        num=num+(CR[i][j]*doc[count][j]);
                        
                        den1=den1+(CR[i][j]*CR[i][j]);
                        den2=den2+(doc[count][j]*doc[count][j]);
                    }
                    
                    double denom=Math.sqrt(den1*den2);
                      
                    double sim=num/denom;
                   //out.println("<br>Similarity between doc"+count+"and CR"+i+"is "+sim);
                   threshold=0.65;
                    if(sim>=threshold) //0.70
                    {
                        
                      double avg=0;
                        
                        cluster[row_cnt][++col_cnt]=count;
                        
                        for(j=0;j<keywordCount;j++)
                        {
                            avg=((CR[row_cnt][j]+doc[count][j])/2);
                            CR[row_cnt][j]=avg;
                        }
                    }
                    else
                    {
                        col_cnt=0;
                    
                       cluster[++row_cnt][col_cnt++]=count;
                    
                        flag[count]=1;
                        
                        for(j=0;j<keywordCount;j++)
                        {
                            CR[col_cnt][j]=doc[count][j];        
                            
                        }
                    
                    
                     }
         
                }
                
                
            }
               
            
        }
        
   
        
        
        
        
        
        
           
        out.println("<h2 class='h10'>Clustred Document<h2>");
        
        for(i=0;i<TableCount;i++)
        {
          //out.println("<br>Cluster "+i+" contains folowing docs ");
            
            for(j=0;j<TableCount;j++)
            {
                      // out.println(cluster[i][j]);

            
            }
        }
        
    /* out.println("<br><br>Cluster Representatives are");
        
        for(i=0;i<TableCount;i++)
        {
            
            out.print("<br><br>CR "+i+" is "+"<br>");
            for(j=0;j<keywordCount;j++)
            {
                       //out.print(CR[i][j]+"  ,  ");
                

            /*
            }
           out.println();
        }
        
      out.println(" <br>");
        
     */
        
      // out.println("<br>Clusters are");
        
        String doc3[]={"","","","","","","","","",""};
        String doc1[]=doc3;
        String doc2[]=doc3;
        for(i=0;i<TableCount;i++)
        {
             doc3[i]="";
            for(j=0;j<TableCount;j++)
            {
                      //  out.println("<br> cluster["+i+"]["+j+"]=>"+cluster[i][j]);
                       if(cluster[i][j]!=-1.0 && j<=doc3[i].length()){
                       doc3[i]= doc3[i]+","+Double.toString(cluster[i][j]).substring(0,1);
                    // out.println("<br>Cluster "+i+"{ "+doc3[i]+"}");
                     char[] chars = doc3[i].toCharArray();
                    Set<Character> charSet = new LinkedHashSet<Character>();
                    for (char c : chars) {
                        charSet.add(c);
                    }

                    StringBuilder sb = new StringBuilder();
                    for (Character character : charSet) {
                        sb.append(character).append(",");
                    }
                  //out.println(">>>>>>>>>>>>>>>>>>>>>>"+sb.toString());
                       
                       doc2[i]=sb.toString();
                       }
                       else
                       {
                           continue;
                       }
                        
                      
            }
        }
        int g;
    
        for (g = 0; g < i-1; g++) {
            if(doc2[g].substring(0).length()>=1){
                   // out.println("<br>mmmmmmmmm>>>>"+doc2[g].substring(2));
                    doc1[g]=doc2[g].substring(2,doc2[g].length()-1);
        }
        }
    
       for (int z = 0; z < doc1.length-1; z++) {
                    out.println("<h4 class=margin>Cluster "+z+"={"+doc1[z]+"}</h4>");
                    
        }
        
        
      out.write("\n");
      out.write("        ");

        
 
    
            
   

         out.println("<br>");
        
           try{   
                PrintWriter out1=response.getWriter();
                //File bb1=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster");
                //FileUtils.cleanDirectory(bb1);
                
                PrintWriter writer = new PrintWriter("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster\\output of clustering(SinglePass1).txt");
                writer.print("");
                writer.close();
                //out1.print("<br>********working here********");

                File outfile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster\\output of clustering(SinglePass1).txt");
                outfile.createNewFile();
                     FileWriter fw33 = new FileWriter(outfile,true);
                       BufferedWriter bw33 = new BufferedWriter(fw33);
                       PrintWriter pw33 = new PrintWriter(bw33);

                       for(int x=0;x<doc1.length;x++){

                 if(doc1[x].length()==1){
                    
                    //out1.print("<br>********In cluster "+x+"********");
                     pw33.println("cluster C"+x);
                     
                    // out1.print("<br>########Doc numbers==>"+doc1[x]+"########");
                     pw33.println("Document D"+doc1[x]);
                     
                     
                     Statement stmt1=con.createStatement();
                            ResultSet rs7;
                            rs7=stmt1.executeQuery("select value from D"+doc1[x]+" ORDER BY value DESC");
                            int valuesum=0;int count=0;
                                                  while(rs7.next()){
                                                      valuesum=valuesum+rs7.getInt("value");
                                                  //out1.println("<br>Value Sum="+valuesum+".................");
                                                      count++;
                                                  } 
                                                  int avg=(valuesum/count);
                                                 //out1.println("Avg of Value Sum="+avg);
                                                  ResultSet rs8;
                                                  rs8=stmt1.executeQuery("select * from D"+doc1[x]+" ORDER BY value DESC");
                                                  while(rs8.next()){
                                                 if(rs8.getInt("value")>=avg){
                                                     String keyword1=rs8.getString("keyword");
                                                     if(Pattern.matches(".*[a-zA-Z]+.*", keyword1)){
                                                  // out1.println("<br>Keyword="+keyword1);
                                                   pw33.println(keyword1);
                                                  
                                                  
                                                 }}

                                        }}
                              

                                        
                 else if(doc1[x].length()>1){       //for cluster having more than one documents in it
                                           
                                            String[] docnos=doc1[x].split(",");
                                            
                                            for(int f=0;f<docnos.length;f++){
                                           // out1.print("<br>********In cluster "+x+"********");
                                            pw33.println("cluster C"+x);
                                            
                                            
                                           // out1.print("<br>########Doc numbers==>"+docnos[f]+"########");
                                            pw33.println("Document D"+docnos[f]);
                                          
                                            Statement stmt1=con.createStatement();
                            ResultSet rs8;
                            rs8=stmt1.executeQuery("select value from D"+docnos[f]+" ORDER BY value DESC");
                            int valuesum=0;int count=0;
                                                  while(rs8.next()){
                                                      valuesum=valuesum+rs8.getInt("value");
                                                  //out1.println("<br>Value Sum="+valuesum+".................");
                                                      count++;
                                                  } 
                                                  int avg=(valuesum/count);
                                                 //out1.println("Avg of Value Sum="+avg);
                                                  ResultSet rs9;
                                                  rs9=stmt1.executeQuery("select * from D"+docnos[f]+" ORDER BY value DESC");
                                                  while(rs9.next()){
                                                 if(rs9.getInt("value")>=avg){
                                                     String keyword1=rs9.getString("keyword");
                                                   if(Pattern.matches(".*[a-zA-Z]+.*", keyword1)){
                                                //   out1.println("<br>Keyword="+keyword1);
                                                   pw33.println(keyword1);
                                                     }
                                                 }}
                                             
                                            }
                                        }
                                    
             }
             pw33.close();
             }catch(Exception e){}
     /* String docnumber="";
       for(int z=0;z<doc1.length;z++){
            docnumber=docnumber.concat(" "+doc1[z]).replace(",", " ");
         }           
       out1.print("<br>Doc numbers==>"+docnumber);
       String[] finaldocstring=docnumber.split(" ");
       for(int z=1;z<finaldocstring.length;z++){
        out1.print("<br>Doc numbers=======================>"+finaldocstring[z]);
       }
     try{
     Statement stmt1=con.createStatement();
     ResultSet rs7;
       for(int z=1;z<finaldocstring.length;z++){
                  
        rs7=stmt1.executeQuery("select value from D"+finaldocstring[z]);
        out1.print("<br><br>*******Result of Table D"+finaldocstring[z]+"********");

        int valuesum=0;int count=0;
                           while(rs7.next())
                           {
                               valuesum=valuesum+rs7.getInt("value");
                           out1.println("<br>Value Sum="+valuesum+".................");
                               count++;
                           } 
                           int avg=(valuesum/count);
                          out1.println("Avg of Value Sum="+avg);
                          if(avg>=rs7.getInt("value")){
                              
                          }
						
         }
       }catch(Exception e){}*/
        
      out.write("\n");
      out.write("  <input type=\"submit\" class=\"btn btn-blue-fill margin button\" value=\"View Diagnosis Information\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script >\n");
      out.write("        alert(\"processing done\");\n");
      out.write(" \n");
      out.write("        </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
