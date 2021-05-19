package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteClientServlet", value = "/delete-client")
public class DeleteClientServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String client = request.getParameter("client");

        ClientService clientService= new ClientService();
        clientService.deleteCustomer(client);

        response.sendRedirect("./index.jsp");
    }

}
