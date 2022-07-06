<!-- BookInfo.jsp -->
<!-- Displays book information -->
<!-- BEGIN -->
<html>
<!-- specify head element -->
  <head>
    <title>Book Info</title>
  </head>
<!-- Specify body element -->
  <body>
    <h1> Book Search Web Application Results Page</h1>
  <%-- Use a declaration construct to create a String reference variable --%>
  <%! private String title = null; %>
  <jsp:useBean id="dbBean"
    class="javaII.dbBeans.BookBean"
    scope="session"/>
    <jsp:useBean id="book" class="javaII.dbBeans.Book" scope="session" />
    <jsp:setProperty name="book" property="title" value="<%= dbBean.getBook().getTitle() %>" />
    
  <% title = request.getParameter("titleName");
    dbBean.setTitle(title);
    javaII.dbBeans.Book b = dbBean.getBook();
  %>
  
  <p><h2>Title: <%= title %></h2></p>
  <p><h2>Author: <jsp:getProperty name="book" property="author"  /></h2></p><br />
  <p><h2>ISBN: <jsp:getProperty name="book" property="isbn"  /></h2></p><br />
  <p><h2>Publisher: <jsp:getProperty name="book" property="publisher"  /></h2></p><br />
  <p><h2>Date: <jsp:getProperty name="book" property="Date"  /></h2></p>
  <p><h2>Price:  <jsp:getProperty name="book" property="price"  /></h2></p>
  
<!-- create link to Book Look-up JSP -->
<p><a href="./BookLook.jsp">Back to Book Look-up</a></p>
 
  </body>
</html>