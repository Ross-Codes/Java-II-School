package project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *  This class demonstrates getting input fields from an HTML form
 *
 *@author    ddalsveen
 */
public class RequestParameterSample extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               The request object, the requesting client
     *@param  response              The response object, used to get a writer
     *@exception  ServletException  thrown when there is a Servlet failure
     *@exception  IOException       thrown when there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String  param1  = request.getParameter("param1");

        System.out.println("param1: " + param1);

        String  param2  = request.getParameter("param2");
        java.util.Enumeration e = request.getParameterNames();

        System.out.println("param2: " + param2);
        String docType =
            "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
            "Transitional//EN\">\n";
          out.println(docType +
                      "<HTML>\n" +
                      "<HEAD><TITLE>" + "Params" + "</TITLE></HEAD>\n" +
                      "<CENTER>\n" +
                      "<BODY BGCOLOR=\"#FCG5E6\">\n" +
                      "<H1>" + "Parameters" + "</H1>\n");
          
         	          
          out.println("<H2>" + "You entered \"" + param1 + "\" in parameter 1</H2>");
          out.println("<H2>" + "You entered \"" + param2 + "\" in parameter 2</H2>");
          // Get all parameter names and values
          while(e.hasMoreElements()){
        	  String name = (String)e.nextElement();
        	  String param = request.getParameter(name);
        	  out.println("<H2>" + "You entered \"" + param + "\" in " + name +" </H2>");
        	  out.println("<H2>" + "List all values associated with \"" + name + "\" </H2>");
        	  String [] paramValues = request.getParameterValues(name);
        	  out.println("<UL>");
        	  for(int i = 0; i < paramValues.length; i++){
        		  out.println("<LI>" + paramValues[i] + "</LI>");
        	  }
        	  out.println("</UL>");
          }
          	 
              
          
          out.println("</BODY></HTML>");
    }

}

