package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.LibraryService;
import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.Library_EditionPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listLibrariesServlet", value = "/list-librariesEditions")
public class ListEditionLibrariesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        LibraryService libraryService = new LibraryService();
        List<Library_EditionPOJO> libraries =  libraryService.listLibraryEditions();

        String librariesJsonString = new Gson().toJson(libraries);

        PrintWriter out = response.getWriter();
        out.print(librariesJsonString);
        out.flush();

    }

}