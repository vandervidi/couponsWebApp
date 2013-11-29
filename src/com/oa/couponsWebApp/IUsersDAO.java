package com.oa.couponsWebApp;


import java.util.Iterator;

public interface IUsersDAO {
	
	public abstract boolean updateUser(Entity_User ob);
	public abstract boolean deleteUser(String userName);
	public abstract Entity_User getUser(String userName);
	public abstract boolean addUser(Entity_User ob);
	public abstract Iterator<Entity_User> getAllUsers();
}
