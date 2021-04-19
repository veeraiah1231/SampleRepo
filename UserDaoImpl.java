package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn= ConectionManager.getConnection();
	
	@Override
	public void saveUser(User user) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into User (userId, email, name, password, phoneNo) values (?,?,?,?,?)");
			stmt.setInt(1, user.getuserId());
			stmt.setString(2, user.getEmail());
			stmt.setString(3,user.getName());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getPhoneNo());
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public int validateUser(String username, String password) {
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE name=? and password=?");
		    stmt.setString(1, username);
		    stmt.setString(2, password);
		    
		    
		    
		    ResultSet resultSet = stmt.executeQuery();
		    
		    if(resultSet.next()) {
//		    	System.out.println("Shivam" +resultSet.getInt("userId"));
		    	return resultSet.getInt("userId");
		    }
		   // return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
//create table user(userId int primary key auto_increment, email varchar(250), name varchar(250), password varchar(250), phoneNo varchar(250));