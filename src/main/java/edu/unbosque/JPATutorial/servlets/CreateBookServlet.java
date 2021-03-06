package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cretateBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        String year = request.getParameter("year");
        java.util.Date release_year = new java.util.Date();
        try {
            release_year =  new SimpleDateFormat("yyyy-MM-dd").parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String desc = request.getParameter("desc");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));


        BookService bookService = new BookService();
        bookService.saveBook(title, isbn, authorId , genre, release_year , desc);

        response.sendRedirect("./index.jsp");

    }

}
