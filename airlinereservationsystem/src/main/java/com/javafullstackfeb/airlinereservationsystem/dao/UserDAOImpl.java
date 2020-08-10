package com.javafullstackfeb.airlinereservationsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.javafullstackfeb.airlinereservationsystem.beans.UserBean;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	//New user can registered themselves
	@Override
	public boolean registerUser(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isRegistered = false;
		try {
			entityTransaction.begin();
			String role = "user";
			userBean.setUserRole(role);
			entityManager.persist(userBean);
			entityTransaction.commit();
			isRegistered=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isRegistered;
	}

	//Authentication of all type of users(customer,admin,executive)
	@Override
	public UserBean userLogin(String userId, String userPassword) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select u from UserBean u where u.userId =:userId and u.userPassword =: password";
			TypedQuery<UserBean> query = entityManager.createQuery(jpql, UserBean.class);
			query.setParameter("userId", userId);
			query.setParameter("password", userPassword);
			UserBean userBean=query.getSingleResult();
				return userBean;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
//		String role = null;
//		UserBean userBean = null;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "select user from UserBean user where user.userId = :userId and user.userPassword =:userPassword";
//		TypedQuery<UserBean> query = entityManager.createQuery(jpql, UserBean.class);
//		query.setParameter("userId", userId);
//		query.setParameter("password", userPassword);
//		userBean = (UserBean)query.getSingleResult();
//		return userBean;
////		String role = null;
//		UserBean userBean = null;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		userBean = entityManager.find(UserBean.class, userId);
//		if(userBean!=null) {
//			String password = userBean.getUserPassword();
//			if (password.equals(userPassword)) {
//				Query query = entityManager.createQuery("From UserBean where userId =:userId and userPassword =: password");
//				query.setParameter("userId", userId);
//				query.setParameter("password", userPassword);
//				userBean = (UserBean)query.getSingleResult();				
//				//return role = userBean.getUserRole();
//			}
//			return userBean;		
//		}
		//return "This user not exist";
//		return null;
	}// end of userLogin()

	//register the new admin or new executive only by the admin
	@Override
	public boolean registerByAdmin(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isRegistered = false;
		try {
			entityTransaction.begin();
			entityManager.persist(userBean);
			entityTransaction.commit();
			isRegistered=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isRegistered;
	}

}// end of class
