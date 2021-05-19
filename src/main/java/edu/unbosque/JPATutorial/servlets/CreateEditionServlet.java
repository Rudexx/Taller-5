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
import java.util.Date;

@WebServlet(name = "createEditionServlet", value = "/create-edition")
public class CreateEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");


        String year = request.getParameter("year");
        Date release_year = new Date();
        try {
            release_year =  new SimpleDateFormat("yyyy-MM-dd").parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String desc = request.getParameter("desc");
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));


        EditionService ser = new EditionService();
        ser.saveEdition(bookId, release_year, desc);



        response.sendRedirect("./index.jsp");

    }

}
