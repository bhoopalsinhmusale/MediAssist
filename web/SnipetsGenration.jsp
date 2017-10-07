<%-- 
    Document   : SnipetsGenration
    Created on : 26 Apr, 2017, 9:29:18 PM
    Author     : Bhoopal
--%>

<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.util.NavigableMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.BreakIterator"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1'>
       <link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
       <link rel='stylesheet' type='text/css' href='css/align.css'>
       
        <title>Summary Tab</title><link rel=\"shortcut icon\" href=\"img/favicons/favicon.ico\">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top"><div class="container-fluid"><div class="navbar-header">
        <a class="navbar-brand" href="#">MediAssist</a></div>
        <ul class="nav navbar-nav"><li class="active"><a href="#">Home</a></li>
        </ul></div></nav>
       
        
        <%!BufferedReader br = null;
		FileReader fr = null;
            BufferedReader br1 = null;
              BufferedReader br3 =null;
              BufferedReader br4 =null;
                TreeMap< String ,Integer> clusterMap = new TreeMap<String, Integer>( );
                public static int getCount(String word, TreeMap<String, Integer> clusterMap)
    {
    	
        if (clusterMap.containsKey(word))
        {  // The word has occurred before, so get its count from the map  
            return clusterMap.get(word); // Auto-unboxed  
        }
        else
        {  // No occurrences of this word  
            return 0;
        }
    }
        %>
        <%
          BufferedReader brForQuery = new BufferedReader(new FileReader(("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\query.txt")));
          String query="";
            while ((query = brForQuery.readLine()) != null) {
                out.print( "<h2 class='multihead' >Search Query : "+query+"</h2>");
            }out.print("<hr style='background-color:black;color:white;padding:2px;'>");
             out.print("<h4 class=h11>Diagnosis Information</h4>");
          try {
                  int resultCount=1;
              
              String[] keywordArray=new String[100];
              String[] snippetArray=new String[100];
              int keyworArrayCount=0,snippetArrayCount=0;
                     int keywordcount1=0;
                    int c=0;
                    int counter=0;
                    String links="";
                    String[] linkArray=new String[100];
                     br4 = new BufferedReader(new FileReader(("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\urls\\reterivedURLS.txt")));
                     while ((links = br4.readLine()) != null) {
                     //out.println(links.substring(3));
                     linkArray[c]=links.substring(3);c++;
                     }
                     //out.print(Arrays.deepToString(linkArray));
                                                
			 fr = new FileReader("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster\\output of clustering.txt");
			br = new BufferedReader(fr);
			//br1 = new BufferedReader(fr);
                      
                      
		 BufferedWriter  bwOfCluster=null ;
                PrintWriter pwOfCluster=null ;   
                     String currentCluster="";
                      String nameofdoc="";
			String sCurrentLine;
                        String sCurrentLine1;
                        int  documentNo=0;
                        int cflag=0;int dflag=0;
                        String[] fileArray=new String[1000];
                        String line1="";
                        int fileArrayCounter=0;
                       BufferedReader brFileArray = new BufferedReader(new FileReader("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster\\output of clustering(SinglePass1).txt"));
                                                while ((line1 = br.readLine()) != null) {
                                                    fileArray[fileArrayCounter]=line1;
                                                    fileArrayCounter++;
                                                }
                      

 File outfileForDivInput=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster\\inputToDiv.txt");
         outfileForDivInput.createNewFile();
         FileWriter fw3 = new FileWriter(outfileForDivInput,false);
                            BufferedWriter bw3 = new BufferedWriter(fw3);
                            PrintWriter pwForDiv = new PrintWriter(bw3);
                            pwForDiv.print("");
  
    			br = new BufferedReader(new FileReader("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster\\output of clustering(SinglePass1).txt"));
                        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
			while ((sCurrentLine = br.readLine()) != null) {
				     if(!sCurrentLine.contains("cluster C")) { 
                                          if(!sCurrentLine.contains("Document D")&& keywordcount1<4 ){ //for extracting keywords from out of cluster.txt
                                           keywordcount1++;
                                           fileArray[fileArrayCounter]=sCurrentLine;
                                                    fileArrayCounter++;
                                              // out.print("<keyword data-role='collapsible'><h4>Keyword : "+sCurrentLine+"</h4>" );
                                               keywordArray[keyworArrayCount]=sCurrentLine;
                                               keyworArrayCount++;
                                              // out.println("<br>Snipets : ");
                                            
                                             //Genratig snipets
                                                String line;
                                              br3 = new BufferedReader(new FileReader(("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files\\D"+(nameofdoc.substring(10))+".txt")));
                                                while ((line = br3.readLine()) != null) {
                                                   TreeMap<Integer, String> keywordcountSnippetLine =  new TreeMap<Integer, String>();
                                                    if (line.toLowerCase().contains(sCurrentLine.toLowerCase())){
                                                  
                                                     
                                                        //out.println("<br>&&&"+line);
                                                         iterator.setText(line);
                                                            int start = iterator.first();
                                                            int count=0;
                                                            for (int end = iterator.next();end != BreakIterator.DONE;start = end, end = iterator.next()) {
                                                              //out.println("<br>&&&"+line.substring(start,end));
                                                             
                                                                if (line.substring(start,end).toUpperCase().contains(sCurrentLine.toUpperCase())){
                                                                String snippetLine=line.substring(start,end).toUpperCase();
                                                                    int keywordcount=0;
                                                                  // out.println("<br>Line========>"+snippetLine);
                                                                    for (String word : snippetLine.split("\\s"))
                                                                    {
                                                                         if(word.contains(sCurrentLine.toUpperCase())){
                                                                             keywordcount++;
                                                                         }
                                                                    }
                                                                    keywordcountSnippetLine.put(keywordcount, line.substring(start,end));
                                                    
                                                                    count++;
       
                                                                  /* out.println("<br>["+line.substring(start,end)+"]"); 
                                                       out.println("<br>xount========>"+keywordcount);*/

                                                                }}
                                                    }                                              
                                           //   out.print("<br><br>Map Output+++++++++++++++++++++++++++=");   
                                              
                                                /* Display content using Iterator*/

                                                int printcount=0;
                                                 Set set = keywordcountSnippetLine.descendingMap().entrySet();
                                                 Iterator iterator1 = set.iterator();
                                                 while(iterator1.hasNext()&&printcount<2) {
                                                    Map.Entry mentry = (Map.Entry)iterator1.next();
                                                   // out.print("<br>"+ mentry.getKey() + " times keyword occured in this snippet ==>");
                                                   // out.println(mentry.getValue().toString().replaceAll("(?i)"+sCurrentLine, "<b>"+sCurrentLine+"</b>")+"<br>");
                                                    snippetArray[snippetArrayCount]="<p class=pjustify>"+mentry.getValue().toString().replaceAll("(?i)"+sCurrentLine, "<b>"+sCurrentLine+"</b>")+"</p>";
                                                    snippetArrayCount++;
                                                    printcount++; 
                                                 } //for single keyword div end
                                               
                                          
                                          }//out.print("</keyword>");
                                       
                                          
                                          }
                                          else  if(sCurrentLine.contains("Document D") ){     
                                       
                                             fileArray[fileArrayCounter]=sCurrentLine;
                                                    fileArrayCounter++;
                                              keywordcount1=0;//for extracting documents from out of cluster.txt
                                       
                                              nameofdoc=sCurrentLine;
                                            // out.println("<br>name ====>"+nameofdoc.substring(10));
                                           br1 = new BufferedReader(new FileReader("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\files\\D"+(nameofdoc.substring(10))+".txt"));
                                    //  out.println( "");
                                      /* out.print( "</file><file data-role='collapsible'>");
                                       if(!linkArray[Integer.parseInt(nameofdoc.substring(10))].startsWith("="))
                                           out.println("<br><h4>File D"+(Integer.parseInt(nameofdoc.substring(10)))+" : </h4><a href="+linkArray[Integer.parseInt(nameofdoc.substring(10))]+" target='_blank' style='color:#006621;'>"+linkArray[Integer.parseInt(nameofdoc.substring(10))]+"</a>");
                                       else
                                         out.println("<br><h4>File D"+(Integer.parseInt(nameofdoc.substring(10)))+" : </h4><a href="+linkArray[Integer.parseInt(nameofdoc.substring(10))].substring(1)+" target='_blank' style='color:#006621;'>"+linkArray[Integer.parseInt(nameofdoc.substring(10))].substring(1)+"</a>");

                                            /*while ((sCurrentLine1 = br1.readLine()) != null) {
                                                out.println("<br>"+sCurrentLine1);
                                          }*/
                                            
                                            
                               
                                          }
                                            
			}
                                     else  if(sCurrentLine.contains("cluster C")){  
                                     int clusterCount=getCount(sCurrentLine, clusterMap);
                                      //  out.print( "<script>alert("+clusterCount+");</script>");
                                     clusterMap.put(sCurrentLine, clusterCount+1);
                                      StringBuilder builder = new StringBuilder();
                                    for(String s : snippetArray) {
                                          
                                        builder.append(s); 
                                    }
                                     String finalsnippets = builder.toString();
                                   
                                 
                                         if(clusterCount==0){
                                              if(snippetArrayCount!=0){
                                                  out.print("<div class=snippetdiv>");
                                                   out.print("<b>Result "+resultCount+" : </b><br>");
                                             for(int b=0;b<snippetArrayCount;b++){
                                                out.print(snippetArray[b]);
                                             }
                                             resultCount++;
                                             snippetArrayCount=0;
                                          
                                             if(keywordArray!=null ){//out.println("<br><br>Keywords : ");
                                                   out.println("<br><b> Medical Phrases : </b>");
                                             for(int s=0;s<keyworArrayCount;s++)
                                             {
                                                 out.println("<b>"+keywordArray[s]+"</b>,");
                                             }
                                             }}
                                              out.print("</div>");
                                               out.println("<hr>");
                                               //out.println("<br><h3 class=h11>*****"+sCurrentLine+"*****<br><h3>");
                                            keyworArrayCount=0;
                                             snippetArrayCount=0;
                                           /*  keywordArray=null;
                                             snippetArray=null;*/
                                       File clusterFile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\cluster files\\Cluster C"+sCurrentLine.substring(9)+".txt");
                                        clusterFile.createNewFile();
                                        FileWriter fwOfCluster = new FileWriter(clusterFile,true);
                                                        bwOfCluster = new BufferedWriter(fwOfCluster);
                                                       pwOfCluster = new PrintWriter(bwOfCluster);
                                                           pwOfCluster.println("Cluster C"+sCurrentLine.substring(9));
                                         if(!currentCluster.equals(sCurrentLine.substring(9)))
                                         {
                                             
                                           //  out.print( "</cluster> <cluster   data-role='collapsible'>");
                                            //      out.println("<br><h4>Cluster C"+sCurrentLine.substring(9)+"</h4>");
                                               
                                                  currentCluster=sCurrentLine.substring(9);
                                                   fileArray[fileArrayCounter]=sCurrentLine;
                                                    fileArrayCounter++;
                                         }
                                        }
                                     }
                       counter++; 
                        
                        
                        
                        }
                       
                         if(snippetArrayCount!=0){
                             out.print("<div class=snippetdiv>");
                              out.print("<b>Result "+resultCount+" : </b><br>");
                                             for(int b=0;b<snippetArrayCount;b++){
                                              out.print(snippetArray[b]);
                                             }
                                             snippetArrayCount=0;
                                          
                                             if(keywordArray!=null ){//out.println("<br><br>Keywords : ");
                                                   out.println("<br><b> Medical Phrases : </b>");
                                             for(int s=0;s<keyworArrayCount;s++)
                                             {
                                                 out.println("<b>"+keywordArray[s]+"</b>,");
                                             }
                                             }
                                              out.print("</div>");
                         }
               
                 pwOfCluster.close();
                 
                 
                } catch (Exception e) {

			e.printStackTrace();} 
            
           

                        %><br>
                        
                        <a href="SnipetsGenration1.jsp" class="btn btn-blue-fill margin button">Multi-Level Search Result</a>
                        
    </body>
</html>
