package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "modifyEditionServlet", value = "/modify-edition")
public class ModifyEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String year = request.getParameter("year");
        java.util.Date release_year = new java.util.Date();
        try {
            release_year =  new SimpleDateFormat("yyyy-MM-dd").parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String desc = request.getParameter("desc");
        Integer editionId = Integer.parseInt(request.getParameter("editionId"));


        EditionService e = new EditionService();
        e.modifyEdition(desc, release_year, editionId);


        response.sendRedirect("./index.jsp");

    }

}
