package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.RentService;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.RentsByDatePOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "listRentsByDateServlet", value = "/list-rentsByDate")
public class ListRentsByDateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        System.out.println("hola aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        String year1 = request.getParameter("year1");
        String year2 = request.getParameter("year2");
        String email = request.getParameter("email");
        Date release_year1 = new Date();
        Date release_year2 = new Date();



        try {
            release_year1 =  new SimpleDateFormat("yyyy-MM-dd").parse(year1);
            release_year2 =  new SimpleDateFormat("yyyy-MM-dd").parse(year2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RentService r = new RentService();
        List<RentsByDatePOJO> rents =  r.rentByDate(release_year1, release_year2, email);

        String authorsJsonString = "nothing";

        if(rents.size() != 0){
          authorsJsonString = r.showInfo(rents);
        }






        if(authorsJsonString.equals("nothing")){
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>" + "<link rel='stylesheet' href='css/css.css'>" + "</head>");
            out.println("<body>");
            out.println("<h4>" + "No rentals were found in that date range</h4>");
            out.println("</body></html>");


            out.flush();
        }else{
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>" + "<link rel='stylesheet' href='css/css.css'>" + "</head>");
            out.println("<body>");
            out.println("<h1>" + "Rents Found :" + "</h1>");
            out.println("<p>" + authorsJsonString + "</p>");
            out.println("</body></html>");


            out.flush();
        }



    }

}
