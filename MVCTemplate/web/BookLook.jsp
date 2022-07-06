<!-- Displays a form that gets its content from a java Bean     -->
<%-- import java.util.*  to get access to the Iterator class --%>
<%@ page import = "java.util.*" %>
<!-- begin html document -->
<html> 
<!-- specify html head element and title -->
   <head>
      <title> Book Look-Up </title>
   </head>
<!-- specify html body element -->
   <body background="images/paperbac.gif">
   <h1>Book Search Web Application</h1>
<!-- create form -->
  <form method = "post" action = "Book">
<p>Select a name from the list and click
            the Get Book button</p>

<!-- create list that contains titles -->
         <select name = "titleName">
 
<%-- begin JSP scriptlet to get the data from the bean --%>
            <%
  
		java.util.Iterator it = (Iterator)request.getAttribute("names");
	        while (it.hasNext()) {
             		 String currentName = (String) it.next();
	 
	     %>  <%-- end scriptlet to insert HTML option tag --%>
                <%-- Use JSP expressions to output from this loop    --%>
                    <option><%= currentName %></option>
	    
  
	    <%  // continue scriptlet to close out the while loop
                  
                }

            %>
      </select>
      <!-- create View Information button -->
      <p><input type = "submit" value = "Get Book"></p>
    </form>

   </body>
</html>
  
