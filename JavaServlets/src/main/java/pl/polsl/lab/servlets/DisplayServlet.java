package pl.polsl.lab.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Functions;
import model.NoticeBoard;

/**
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Display")//GIF
public class DisplayServlet extends HttpServlet {

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
        
        response.setContentType("text/html; charset=UTF-8");//charset=ISO-8859-2
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display noticeboard</title>");
       // out.println("<body style=\"background-color: cornsilk;\"></body>"); //style=\"background-color: burlywood\"
        out.println("<body>");
        out.println("<h1>Noticeboard: </h1>"); //Servlet WindowServlet at " + request.getContextPath() + "</h1>
        out.println("</body>");
        out.println("</head>");
        /*  String GIFfile = getServletContext().getRealPath("/WEB-INF/images/duke_swinging.gif");
            response.setContentType("image/gif");
            FileInputStream in = new FileInputStream(GIFfile);
            ServletOutputStream out = response.getOutputStream();
            byte buffer[] = new byte[512];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }*/
        NoticeBoard noticeBoard = new NoticeBoard();
        Scanner input = new Scanner(new File("/C:/Users/jwiec/Desktop/ProgramyJava/JavaServlets/Tytuly.txt"));
        List<String> titles = new ArrayList();
        Functions functions = new Functions();
        functions.uploadData(titles, input);
        noticeBoard.uploadNotices(titles, noticeBoard);
        for(int i =0;i<noticeBoard.getSize();i++)
        {
            //(noticeBoard.getObjectText(i)).replace("<br>", ".");
        }
         out.println("<link rel=\"stylesheet\" href=\"looks.css\"> "
                 +"<div class=\"container\">"
                 + "<body><table><tr><th>Author</th><th>Title</th><th>Text</th></tr>");
        for(int i =0;i<noticeBoard.getSize();i++)
        {
            out.println("<tr><td>"+noticeBoard.getObjectAuthor(i)+"</td><td>"+noticeBoard.getObjectTitle(i)+"</td><td>"+(noticeBoard.getObjectText(i)).replace(".", "<br>")+"</th></tr>");
        }
                out.println("</div></table></body></html>");

    }
}
