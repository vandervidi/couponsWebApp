package com.oa.couponsWebApp;


import java.util.Iterator;

public interface IBusinessesDAO {
   
   public abstract boolean updateBusiness(Entity_Business ob);
   public abstract boolean deleteBusiness(int id);   
   public abstract Entity_Business getBusiness(int id);
   public abstract boolean addBusiness(Entity_Business ob);
   public abstract Iterator<Entity_Business> getAllBusinesses();
}
