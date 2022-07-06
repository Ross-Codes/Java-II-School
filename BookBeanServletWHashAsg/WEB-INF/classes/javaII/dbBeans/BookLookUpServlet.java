package javaII.dbBeans;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * This servlet will look-up Book titles using a java bean.
 *  
 *  
 *
 */


public class BookLookUpServlet extends HttpServlet {
	private javaII.dbBeans.BookBean dbBean = null;
	// This method is only called Once.
	public void init(){
		dbBean = new javaII.dbBeans.BookBean();
	}
	
	/**
	 *  Handles HTTP GET requests.
	 *
	 *@param  request               the HttpServletRequest object
	 *@param  response              the HttpServletResponse object
	 *@exception  ServletException  if there is a Servlet failure
	 *@exception  IOException       if there is an IO failure
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		// set the response type before sending data
		PrintWriter  out  = response.getWriter();
		// Begin writing html as the reponse
		out.write("<!-- Displays a form that gets its content from a java Bean     -->\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("<!-- begin document -->\r\n");
		out.write("<html>\r\n");
		out.write("\r\n");
		out.write("   <!-- specify html head element -->\r\n");
		out.write("   <head>\r\n");
		out.write("      <title> Book Look-Up </title>\r\n");
		out.write("   </head>\r\n");
		out.write("\r\n");
		out.write("   <!-- specify html body element -->\r\n");
		out.write("   <body>\r\n");
		out.write("      <h1>Book Web Application</h1>\r\n");
		out.write("\r\n");
		out.write("      <!-- create form -->\r\n");
		out.write("      <form method = \"post\" action = \"BookLookUpServlet\">\r\n");
		out.write("\t\r\n");
		out.write("         <p>Select a name from the list and click\r\n");
		out.write("            the Get Book button</p>\r\n");
		out.write("\r\n");
		out.write("         <!-- create list that contains titles -->\r\n");
		out.write("         <select name = \"titleName\">\r\n");
		out.write("\r\n");
		out.write("            ");
		out.write("\r\n");
		out.write("\t   ");
		javaII.dbBeans.BookBean dbBean = null;
		synchronized (this) {
			
			if (dbBean == null){
				dbBean = new javaII.dbBeans.BookBean();
				
			}
		}
		out.write(" \r\n");
		out.write("\r\n");
		out.write("            ");
		
		
		java.util.Iterator it = dbBean.getTitleList();
		
		while (it.hasNext()) {
			String currentName = (String) it.next();
			
			
			out.write(' ');
			out.write(' ');
			out.write("\r\n");
			out.write("                ");
			out.write("\r\n");
			out.write("\r\n");
			out.write("                     <option>");
			out.print( currentName );
			out.write("</option>\r\n");
			out.write("\r\n");
			out.write("            ");
		
			
		}
		
		
		
		
		out.write("\r\n");
		out.write("\r\n");
		out.write("         </select>\r\n");
		out.write("\r\n");
		out.write("         <!-- create View Information button -->\r\n");
		out.write("         <p><input type = \"submit\" value = \"Get Book\"></p>\r\n");
		out.write("      </form>\r\n");
		out.write("\r\n");
		out.write("   </body>\r\n");
		out.write("</html>\r\n");
		out.write("\r\n");
		out.write("      \r\n");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}
	
}

