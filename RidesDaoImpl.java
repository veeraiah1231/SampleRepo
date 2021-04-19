package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RidesDao;
import ola.com.booking.model.Ride;
import ola.com.booking.model.Route;

public class RidesDaoImpl implements RidesDao {
	
Connection conn= ConectionManager.getConnection();
	
	public List<Ride> getRides(){
	
		List<Ride> rideList = new ArrayList<Ride>();
		try {
			ResultSet result = conn.createStatement().executeQuery("select * from ride");
			while(result.next()) {
				Ride route = new Ride();
				route.setRideId(result.getInt("rideId"));
				route.setUserId(result.getString("userId"));
				route.setRouteId(result.getString("routeId"));
				route.setDateTime(result.getDate("dateTime"));
				rideList.add(route);
				
			}
			return rideList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	}


	public void saveRides(Ride ride) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into ride (rideId,userId,routeId) values (?,?,?)");
			stmt.setInt(1,ride.getRideId());
			stmt.setString(2, ride.getUserId());
			stmt.setString(3,ride.getRouteId());
			//stmt.setDateTime(4, ride.getDateTime());
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	


}
