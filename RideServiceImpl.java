package ola.com.booking.service.impl;

import java.util.List;

import ola.com.booking.dao.RidesDao;
import ola.com.booking.dao.impl.RidesDaoImpl;
import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;

public class RideServiceImpl implements RideService {

	RidesDao rideDao = new RidesDaoImpl();
	
	public List<Ride> getRides() {

		return rideDao.getRides();
	}

	@Override
	public void saveRides(Ride ride) {
		// TODO Auto-generated method stub
		rideDao.saveRides(ride);
	}

}
