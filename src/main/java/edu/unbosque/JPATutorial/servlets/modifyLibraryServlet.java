package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.LibraryService;
import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "modifyLibrariesServlet", value = "/modify-library")
public class modifyLibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("libraryId"));
        String name = request.getParameter("name");

        LibraryService libraryService = new LibraryService();
        libraryService.changelibrary(name, id);

        response.sendRedirect("./index.jsp");

    }

}