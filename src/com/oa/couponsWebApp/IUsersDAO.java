package com.oa.couponsWebApp;


import java.util.Iterator;

/**
 * interface to be implements by DAO class
 */
public interface IUsersDAO {
	/**
	 * get user
	 */
   public abstract User getUser(String username);
   /**
    * update user
    */
   public abstract boolean updateUser(User ob);
   /**
    * get all users
    */
   public abstract Iterator<User> getAllUsers();
   /**
    * delete user
    */
   public abstract boolean deleteUser(String username);
   /**
    * add user
    */
   public abstract boolean addUser(User ob);
}
