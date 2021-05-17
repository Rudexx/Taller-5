package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteBookServlet", value = "/delete-book")
public class DeleteBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");



        String info= request.getParameter("info");

        String[] words=info.split(" ");

        int bookId = Integer.parseInt(words[0]);
        int authorId = Integer.parseInt((words[1]));
        BookService bookService = new BookService();
       bookService.deleteBook(bookId, authorId);




       response.sendRedirect("./index.jsp");

    }

}
