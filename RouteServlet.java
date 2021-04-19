package ola.com.booking;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.helper.UserHelper;
import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;
import ola.com.booking.service.RouteService;
import ola.com.booking.service.impl.RideServiceImpl;
import ola.com.booking.service.impl.RouteServiceImpl;

@WebServlet("/routes")
public class RouteServlet extends HttpServlet{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	RouteService routeService = new RouteServiceImpl();
	
	RideService rideService = new RideServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//u have userId
		//Date d=new Date();
	
	        if(req.getParameter("action").equals("saveRides")) {
				Ride ride = new Ride();
				ride.setRideId(UserHelper.getIncrement());
				ride.setRouteId(req.getParameter("routeId"));
				ride.setUserId(req.getParameter("userId"));
				//ride.setDateTime(d);
				
				rideService.saveRides(ride);	
				RequestDispatcher rd1 = req.getRequestDispatcher("BookRideServlet");
		        rd1.forward(req, resp);
			
			}else {

				req.setAttribute("userId",req.getAttribute("userId")); //all rout info + userId
				req.setAttribute("rList", routeService.getRoutes()); //all rout info + userId
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/routeview.jsp");
		        rd.forward(req, resp);
		
			}
	
		
		
	}

	
}
