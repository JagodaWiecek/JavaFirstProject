package pl.polsl.lab.servlets;

import java.io.*;
import java.util.Date;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.File;
import static java.io.File.separator;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Functions;
import model.NoticeBoard;

/**
 * 
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Add")//First
public class AddServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {

        Scanner input = new Scanner(new File("/C:/Users/jwiec/Desktop/ProgramyJava/JavaServlets/Tytuly.txt")); //"/C:/Users/jwiec/Desktop/ProgramyJava/JavaServlets/Tytuly.txt"
        List<String> titles = new ArrayList();
        Functions functions = new Functions();
        functions.uploadData(titles, input);

        response.setContentType("text/html; charset=ISO-8859-2");

        PrintWriter out = response.getWriter();
        /*response.setHeader("Refresh", "1");
        String date = new Date().toString();*/

        // out.println("<html>\n<body>\n" + date + "\n<h1>Hello !!!</h1><br>\n"
        //       + "<img border=\"0\" src=\"" + request.getContextPath()
        //     + "/images/duke.thumbsup.gif\">\n</body>\n</html>");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add Notice</title>");

        out.println("<body>");
        out.println("<link rel=\"stylesheet\" href=\"looks.css\"> "
                 +"<div class=\"container\">");
        out.println("<h1> Create a notice: </h1>"); //Servlet WindowServlet at " + request.getContextPath() + "</h1>
        out.println("</body>");
        out.println("</head>");

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        title = title.trim();
        text = text.trim();
        if (title.isBlank() && text.isBlank()) {
            out.println("<big><body>Title and test is empty, fill them</big><br><br>");
            title = "null";
            text = "null";
        } else if (title.isBlank()) {
            out.println("<big><body>Title is empty, fill it</big><br><br>");
            title = "null";
        } else if (text.isBlank()) {
            out.println("<big><body>Text is empty, fill it</big><br><br>");
            text = "null";
        } else {
            if (functions.checkTitles(title, titles)) {
                author = functions.checkWhiteSigns(author);
                titles.add(title);
                PrintWriter save = new PrintWriter("/C:/Users/jwiec/Desktop/ProgramyJava/JavaServlets/Tytuly.txt");
                functions.saveTitles(titles, save);
                PrintWriter newNotice = new PrintWriter("/C:/Users/jwiec/Desktop/ProgramyJava/JavaServlets/Ogloszenia" + separator + title + ".txt"); ///creating new file
                functions.newNoticeMake(title, author, text, newNotice);
                out.println("<big><body> new notice is created</big><br><br>");

            } else {
                out.println("<big><body>Title is occupied, choose another one<br>");
            }
        }

        out.println("Author:" + functions.checkWhiteSigns(author) + "<br>Title:    " + title);
        out.println("<br>Text:    " + text.replace(".", "\n") + "</div></body>");
        out.println("</html>");
    }

   /* private void getRealPath(String ty) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
