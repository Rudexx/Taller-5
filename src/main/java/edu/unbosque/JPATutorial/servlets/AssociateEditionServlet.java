package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AssociateEditionServlet", value = "/associate-library")
public class AssociateEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String edition = request.getParameter("edi");
        String library = request.getParameter("libs");

        String[] editionInfo = edition.split(" ");
        String[] libraryInfo = library.split( " ");




        String edi = editionInfo[0].substring(0, editionInfo[0].length()/2);
        String lib = libraryInfo[0].substring(0, libraryInfo[0].length()/2);

        int editionId = Integer.parseInt(edi);
        int libraryId = Integer.parseInt(lib);

        LibraryService l = new LibraryService();
        l.assosiateEdition(editionId, libraryId);

        response.sendRedirect("./index.jsp");

    }

}
