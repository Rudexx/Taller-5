package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createCustomerServlet", value = "/create-customer")
public class CreateClientServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String first_name = request.getParameter("firstN");
        String last_name = request.getParameter("lastN");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));

        ClientService clientService = new ClientService();
        clientService.Crearcliente(email,first_name,last_name,gender,age);

        response.sendRedirect("./index.jsp");
    }

}
