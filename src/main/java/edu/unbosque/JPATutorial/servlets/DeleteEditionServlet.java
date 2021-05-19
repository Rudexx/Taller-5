package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteEditionServlet", value = "/delete-edition")
public class DeleteEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");



        String info= request.getParameter("info");

        String[] words=info.split(" ");

        int editionId = Integer.parseInt(words[0]);
        int bookId = Integer.parseInt((words[1]));
        EditionService ed = new EditionService();
        ed.deleteEdition(editionId, bookId);




       response.sendRedirect("./index.jsp");

    }

}
