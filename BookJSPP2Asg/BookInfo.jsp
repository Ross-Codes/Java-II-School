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
  <% title = request.getParameter("titleName");
    dbBean.setTitle(title);
    javaII.dbBeans.Book b = dbBean.getBook();
  %>
  <p><h2>Title: <%= title %></h2></p>
  <p><h2>Author: <%= b.getAuthor() %></h2></p>
  <p><h2>ISBN: <%= b.getISBN() %></h2></p>
  <p><h2>Date: <%= b.getPubDate() %></h2></p>
<!-- create link to Book Look-up JSP -->
<p><a href="./BookLook.jsp">Back to Book Look-up</a></p>
 
  </body>
</html>