package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyClientServlet", value = "/modify-customer")
public class ModifyClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String oldEmail = request.getParameter("oldEmail");
        String first_name = request.getParameter("firstN");
        String last_name = request.getParameter("lastN");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));

        ClientService clientService= new ClientService();
        clientService.modifyCustomer(first_name,last_name,gender,age, oldEmail);

        response.sendRedirect("./index.jsp");
    }

}
