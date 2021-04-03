
package controller;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import baza.DB;
import model.Cennik;
 

public class MenuServ extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DB db;
 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "insert":
            	 wyswietl(request, response);
                break;
            default:
            	dodaj(request,response);
               
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void wyswietl(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Cennik> wyswietl = db.wyswietl();
        request.setAttribute( "wyswietl", wyswietl);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
        dispatcher.forward(request, response);
    }
 
    private void dodaj(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	int idCennik = Integer.parseInt(request.getParameter("idCennik"));
        String pizza = request.getParameter("pizza");
        String dodatkiPizza = request.getParameter("dodatkiPizza");
        String danie = request.getParameter("danie");
        String dodatkiDanie = request.getParameter("dodatkiDanie");
        String zupy = request.getParameter("zupy");
        String napoje = request.getParameter("napoje");
        String uwagi = request.getParameter("uwagi");
        String koszt = request.getParameter("koszt");
         
 
        Cennik c = new Cennik(idCennik,pizza, dodatkiPizza, danie,dodatkiDanie,zupy,napoje,uwagi,koszt);
        db.dodaj(c);
        response.sendRedirect("insert");
    }
 
}