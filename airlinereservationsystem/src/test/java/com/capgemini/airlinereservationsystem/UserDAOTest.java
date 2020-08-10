package com.capgemini.airlinereservationsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javafullstackfeb.airlinereservationsystem.beans.UserBean;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
	
	@Autowired
	
	private UserDAO dao;
	
	
	@Test
	public void registerTest() {
		UserBean userBean = new UserBean();
		userBean.setUserFirstName("Sandeep");
		userBean.setUserLastName("Tiwari");
		userBean.setUserEmail("admin@gmail.com");
		userBean.setUserContact(9582848408l);
		userBean.setUserId("sandy123");
		userBean.setUserPassword("sandy123");
		userBean.setUserRole("admin");
		assertEquals(true, dao.registerByAdmin(userBean));
	}
	

}
