<%-- 
    Document   : frequency
    Created on : 20 Mar, 2017, 10:51:33 PM
    Author     : Bhoopal
--%>

<%@page import="java.awt.Desktop"%>
<%@page import="java.util.regex.Pattern"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.io.*,java.util.Comparator,java.util.HashMap,java.util.TreeMap"  %>
<%@ page import="org.apache.commons.io.FileUtils,java.sql.*,java.util.*,java.net.URL,org.jsoup.Jsoup,org.jsoup.nodes.Document,org.jsoup.select.Elements, java.io.*"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Term Frequency Tab</title><link rel="shortcut icon" href="img/favicons/favicon.ico">
        <link rel='stylesheet' type='text/css' href='css/bootstrap.css'><link rel='stylesheet' type='text/css' href='css/align.css'>
                    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>
                   <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>
    
        
        
        
        
    </head><body>
        
        <nav class="navbar navbar-inverse navbar-fixed-top"><div class="container-fluid"><div class="navbar-header">
        <a class="navbar-brand" href="index.jsp">MediAssist</a></div>
        <ul class="nav navbar-nav"><li class="active"><a href="index.jsp">Home</a></li>
        </ul></div></nav>
        
        
        
        
        
        <form action="SinglePass1.jsp">
      <%!public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
      static int i=0;
    static File folder = new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\output");
    static File[] listOfFiles = folder.listFiles();
    static  String Docs []=new String[listOfFiles.length];// = {"D:\\java programs\\count\\file\\file1.txt","D:\\java programs\\count\\file\\file1.txt"};
    static PrintWriter out1; 

    
      %> 
     
      
      
       <%
               out1=response.getWriter();
               File bb=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\frequency");
        FileUtils.cleanDirectory(bb);
 //database cleaning code
 try{
  Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\DataBases\\freq.accdb");
            int j=0;
            Statement stmt = con.createStatement();
            while(stmt.execute("Drop table D"+j))
            {
            j++;
            }
 }catch(Exception e){}
     /* try{
        
    
         Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\DataBases\\freq.accdb");
            Statement stmt = con.createStatement();
         String[] types = { "TABLE" };
    ResultSet resultSet = con.getMetaData().getTables(null, null, "%", types);
     String tableName = "";
     while (resultSet.next()) {
       tableName = resultSet.getString(3);
   out1.println("<br>Table Name = " + tableName);
   stmt.execute("drop table "+tableName);
   out1.println("deleted "+tableName);
     }}catch(Exception e){}
          
    */
         
               
    try{
        //out1.print("<br>List of Documents for Processing<br>");
        out1.print("<h2 class='h10'>Output Files of Conflation Algorithm</h2><hr>");

        for(File file : listOfFiles){         
      Docs[i]=file.toString();
         out1.println("<h4 class='margin'>Doc "+(i+1)+" => " +file.toString()+"</h4>");
      
       i++;
        
        
        }
        out1.print("<br><h2 class='h11'>Term Frequency Tables : </h2><hr>");
    }catch(Exception e ){//out.println(" exceptionffffffffff "+e);
        }
        
            

    //out1.print("<br>");
    /*    for (int j = 0; j < listOfFiles.length; j++) {
            out3.println("Doc >"+Docs[j]+"<br>");
        }*/
        
    	//invert r=new invert();
        // **THIS CREATES A TREE MAP**  
    	
       
        // **THIS CREATES A TREE MAP**  
        TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );

        Map[] mapArray = new Map[5];
        mapArray[0] = new HashMap<String, Integer>();

        readWordFile(frequencyData);
  //    printAllCounts(frequencyData);
        Map sortedMap = sortByValuesTree(frequencyData);

      
      
          // Get a set of the entries on the sorted map
    Set set = sortedMap.entrySet();
 
    // Get an iterator
    Iterator i = set.iterator();
        // out1.println("----------------------output In asending order-------------------------<br>");

    // Display elements
    while(i.hasNext()) {
        
      Map.Entry me = (Map.Entry)i.next();
       String abc=me.getValue().toString();
              if(Pattern.matches(".*[a-zA-Z]+.*", me.getKey().toString()) &&  (Integer.parseInt(abc)>1)){
      out1.print("<br>"+me.getKey() + ":    ");
      out1.println(me.getValue()+"<br>");
    }}
            %>
      <%!  
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
     public static void printAllCountsa(TreeMap<String, Integer> frequencyData,int fileName) throws IOException
    {
       //URL url=new URL(fileName);
        out1.println(fileName);
         File outfile=new File("C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\frequency\\freq of "+(fileName+1)+".txt");
         outfile.createNewFile();
         FileWriter fw3 = new FileWriter(outfile,true);
                            BufferedWriter bw3 = new BufferedWriter(fw3);
                            PrintWriter pw3 = new PrintWriter(bw3);
                            pw3.print("");
        
        pw3.println("Occurrences    :   Words");
        
        //sorting 
        Map sortedMap = sortByValuesTree(frequencyData);

        
        // Get a set of the entries on the sorted map
        Set set = sortedMap.entrySet();
 
        // Get an iterator
        Iterator i = set.iterator();
 
        // Display elements
        while(i.hasNext()) {
      Map.Entry me = (Map.Entry)i.next();
            String abc=me.getValue().toString();
if( (me.getKey().toString().length())>3){
              if(Pattern.matches(".*[a-zA-Z]+.*", me.getKey().toString()) &&  (Integer.parseInt(abc)>3) ){

      pw3.print(me.getKey() + " :   ");
      pw3.print(me.getValue());
      pw3.println();pw3.close();}
    }
        
    }
}
   public static void printAllCounts(TreeMap<String, Integer> frequencyData, int fileName){
      try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Bhoopal\\Documents\\NetBeansProjects\\MedAssist1\\DataBases\\freq.accdb");
            Statement stmt = con.createStatement();
       
    stmt.executeUpdate("CREATE TABLE D" + fileName + "(keyword varchar2(20),value int)");
               // flag=1;
            
            //URL url=new URL(fileName);
            out1.println("<h4 class='margin'>Table D"+fileName+"</h4>");
            //sorting 
            Map sortedMap = sortByValuesTree(frequencyData);
            // Get a set of the entries on the sorted map
            Set set = sortedMap.entrySet();
            // Get an iterator
            Iterator i = set.iterator();

            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                String abc=me.getValue().toString();
             if( (me.getKey().toString().length())>1){
                if(Pattern.matches(".*[a-zA-Z]+.*", me.getKey().toString()) &&  (Integer.parseInt(abc)>1)){
                stmt.executeUpdate("insert into D" + fileName + " (keyword,value) values('"+me.getKey()+"',"+me.getValue()+")");
            }}}
            con.close();
         //   }*/
      }catch(Exception e){}  
    }%>
    <script>
        alert("DataBase Created");
    </script>
    <%!

     
   
   
   
   public static Map<String, Integer> sortByValuesTree(final Map<String, Integer> map) {
        Comparator<String> valueComparator =  new Comparator<String>() {
            public int compare(String k1, String k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<String, Integer> sortedByValues = new TreeMap<String, Integer>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }


    public static void readWordFile(TreeMap<String, Integer> frequencyData) throws IOException{
        int total = 0;
        Scanner wordFile;
        String word;     // A word read from the file  
        int count;   // The number of occurrences of the word
        int counter = 0;
        int docs = 0;
       
//**FOR LOOP TO READ THE DOCUMENTS**  
        for(int x=0; x<Docs.length; x++)
        { //start of for loop [*  

            try
            {
                wordFile = new Scanner(new FileReader(Docs[x]));
            }
            catch (FileNotFoundException e)
            {
                System.err.println(e);
                return;
            }

            while (wordFile.hasNext( ))
            {
                // Read the next word and get rid of the end-of-line marker if needed:  
                word = wordFile.next( );

                // This makes the Word lower case.  
                word = word.toLowerCase();

                word = word.replaceAll("[^a-zA-Z0-9\\s]", "");

                // Get the current count of this word, add one, and then store the new count:  
                count = getCount(word, frequencyData) + 1;
                frequencyData.put(word, count);
                total = total + count;
                counter++;
                docs = x + 1;              
            }

            printAllCounts(frequencyData,x);
            //printAllCountsa(frequencyData,x);

    frequencyData.clear();

        } //End of for loop
       // out.println("There are " + total + " terms in the collection.");
       // out1.println("There are " + counter + " unique terms in the collection.");
        //out1.println("There are " + docs + " documents in the collection.");
        
}     %>
        <input type="submit" class="btn btn-blue-fill margin button" value="Preprocessing DataBase">
        </form>
        </div>
        </header>
    </body>
</html>
