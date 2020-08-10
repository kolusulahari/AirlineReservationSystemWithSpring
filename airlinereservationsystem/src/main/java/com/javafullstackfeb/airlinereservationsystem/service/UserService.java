package com.javafullstackfeb.airlinereservationsystem.service;

import com.javafullstackfeb.airlinereservationsystem.beans.UserBean;

public interface UserService {

	public boolean registerUser(UserBean userBean);

	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
