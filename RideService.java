package ola.com.booking.service;

import java.util.List;

import ola.com.booking.model.Ride;

public interface RideService {

	public List<Ride> getRides();
	
	public void saveRides(Ride ride);
	
}
