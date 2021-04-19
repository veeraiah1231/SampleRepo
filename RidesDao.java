package ola.com.booking.dao;

import java.util.List;

import ola.com.booking.model.Ride;

public interface RidesDao {

	public List<Ride> getRides();
	
	public void saveRides(Ride ride);
	
}