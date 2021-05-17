package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.LibraryService;
import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "modifyAuthorServlet", value = "/modify-author")
public class ModifyAuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String author = request.getParameter("authorId");
        int authorId = Integer.parseInt(author);
        String name = request.getParameter("name");
        String country = request.getParameter("country");


        AuthorService authorService = new AuthorService();
        authorService.modifyAuthor(authorId,name,country);
        response.sendRedirect("./index.jsp");
    }
}
