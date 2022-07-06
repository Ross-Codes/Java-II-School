<!-- displays a form that gets it's content from a java bean -->
<%-- import java.util.* to get access to the iterator class --%>
<%@page import = "java.util.*" %>
<!-- begin html doc-->
<html>
<!-- specify html head element and title -->
  <head>
   <title> Book Look-Up </title>
  <head>
  <!-- specify html body element -->
  <body>
  <h1> Book Search Web Application</h1>
  <!-- create form -->
  <form method = "post" action = "./BookInfo.jsp">
  <p>Select a name from the list and click the Get Book button</p>
  <!-- create list that contains the titles -->
  <select name = "titleName">
  <%-- Use a jsp action to instantiate a Java Bean --%>
  <jsp:useBean id="dbBean" class="javaII.dbBeans.BookBean" scope="session"/>
  <%-- begin JSP scriptlet to get the data from the bean --%>
  <% java.util.Iterator it = dbBean.getTitleList();
    while(it.hasNext()){
      String currentName = (String)it.next();
  %>
  <%-- end scriptlet to insert HTML option tag --%>
    <%-- Use jsp expressions to output from this loop --%>
  <option><%=currentName %></option>
  <% //continue scriptlet to close out the while loop
    }
  %>
  </select>
  <!-- create View Information button -->
  <p><input type = "submit" value = "Get Book"></p>
  </form>
  </body>
</html>