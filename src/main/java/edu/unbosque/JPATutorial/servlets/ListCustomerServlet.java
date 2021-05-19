package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.ClientService;
import edu.unbosque.JPATutorial.services.EditionService;
import edu.unbosque.JPATutorial.servlets.pojos.ClientPojo;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listCustomerServlet", value = "/list-customer")
public class ListCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ClientService c = new ClientService();
        List<ClientPojo> customers = c.listclients();


        String authorsJsonString = new Gson().toJson(customers);

        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();

    }

}
