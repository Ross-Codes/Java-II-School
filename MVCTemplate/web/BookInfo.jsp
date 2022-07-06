<!--  BookInfo.jsp -->
<!-- Displays book information     -->
<%@ page import = "javaII.dbBeans.*" %>

<!-- begin document -->
<html>

   <!-- specify head element -->
   <head>
      <title>Book Info</title>
   </head>

   <!-- specify body element -->
   <body background="images/JavaBook.JPG">
	<h1> Book Search Web Application Results Page</h1>
 <%-- The following parameters and attributes are sent by the BookControl Servlet. --%>
 <jsp:useBean id="book" type = "javaII.dbBeans.Book" scope="request"/>

        <%--  replaces the following
          javaII.dbBeans.Book b  = (Book) request.getAttribute("book");
        --%>
            
        <table border="2">
            <thead>
                <tr>
                    <th>Your Selected Book</th>
                    <th>Enjoy!</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Title</td>
                    <td><jsp:getProperty name="book"
                                         property="title" /></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><jsp:getProperty name="book"
                                         property="author" /></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td><jsp:getProperty name="book"
                                         property="publisher" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><jsp:getProperty name="book"
                                         property="price" /></td>
                </tr>
                <tr>
                    <td>ISBN</td>
                    <td><jsp:getProperty name="book"
                                         property="ISBN" /></td>
                </tr>
            </tbody>
        </table>
        
		
             <!-- create link to Book Look-up JSP -->
       <p><a href = "./Book?titleName=-List-"> Back to Book Look-up</a></p>
       <a href="./index.jsp">Back to the Home Page</a>
      

   </body>
</html>

