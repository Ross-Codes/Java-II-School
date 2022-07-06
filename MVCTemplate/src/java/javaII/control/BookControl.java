/*
 * BookControl.java
 *
 * Created on April 25, 2007, 8:21 AM
 *Author: Cassidy Jones
 */

package javaII.control;

import java.io.*;
import java.net.*;
import javaII.dbBeans.Book;
import javaII.dbBeans.BookBean;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Cassidy Jones
 * @version
 */
public class BookControl extends HttpServlet {
    private String target = null; // the jsp target (the view)
    private BookBean bookBean = null; // the reference variable for the bean(model)
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    public void init(){
        
    }
    
    
    
    /** Processes requests for both HTTP GET and POST
     *   requests.
     * @param request servlet request
     * @param response servlet response
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        target =  "/BookLook.jsp";
        String msg = "";  // to hold log messages.
        if(bookBean == null){
            synchronized(this){
                bookBean = new BookBean();
            }
        }
        
        // get the value of the name parameter
        String name = request.getParameter("titleName");
        
        System.out.println("name = " +name);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
        if(!bookBean.isPopulated()){
            msg = "Book Information Not Available" ;
            log(msg);
            // point the target to an error page.
            target = "error1.jsp";
        } else if(name == null || name.trim()== ""
                || name.equalsIgnoreCase("-List-") ){
            
            target = "/BookLook.jsp";
            request.setAttribute("names",(java.util.Iterator)bookBean.getTitleList());
            
        } //close the else- if construct.
        // If name exists, check for book name.
        else{
            
            // set the requested title in the bean.
            bookBean.setTitle(name);
            Book book = (Book)bookBean.getBook();
            book = null;
            if(book != null){
                request.setAttribute("book", (Book) book);
                target = "/BookInfo.jsp";
            } else{
                target = "error2.jsp";
                // set target to an error page.
            }
            
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(target);
        dispatcher.forward(request,response);
        
    }
    /** Handles the HTTP GET request.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    /** Handles the HTTP POST request.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    
    
    
    
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
    
    
}
