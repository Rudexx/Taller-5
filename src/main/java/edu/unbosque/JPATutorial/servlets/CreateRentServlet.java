package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.RentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "createRentServlet", value = "/create-rent")
public class CreateRentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String edition = request.getParameter("editions");

        String[] editionInfo = edition.split(" ");
        String edi = editionInfo[0].substring(0, editionInfo[0].length()/2);


        int editionId = Integer.parseInt(edi);

        RentService r = new RentService();
        r.saveRent(email, editionId);




        response.sendRedirect("./index.jsp");

    }

}
