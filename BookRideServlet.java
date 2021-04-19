package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

/**
 * Servlet implementation class BookRideServlet
 */
@WebServlet("/BookRideServlet")
public class BookRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RideService rideService = new RideServiceImpl();
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	//	response.setContentType("text/html;charset=UTF-8");
    //    PrintWriter out = response.getWriter();
    //	out.println("<font color='red'><b>Ride Id</b></font>"+request.getParameter("routeId"));
    
		
		request.setAttribute("myRides", rideService.getRides()); //all rout info + userId
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rides.jsp");
        rd.include(request, response);
        
        
    
	}

}
