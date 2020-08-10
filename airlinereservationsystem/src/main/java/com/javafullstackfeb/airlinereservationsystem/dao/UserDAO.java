package com.javafullstackfeb.airlinereservationsystem.dao;

import com.javafullstackfeb.airlinereservationsystem.beans.UserBean;

public interface UserDAO {
	
	public boolean registerUser(UserBean userBean);
	
	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
