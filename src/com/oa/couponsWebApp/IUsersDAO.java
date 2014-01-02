package com.oa.couponsWebApp;


import java.util.Iterator;

public interface IUsersDAO {
   public abstract User getUser(String username);
   public abstract boolean updateUser(User ob);
   public abstract Iterator<User> getAllUsers();
   public abstract boolean deleteUser(String username);
   public abstract boolean addUser(User ob);
}
