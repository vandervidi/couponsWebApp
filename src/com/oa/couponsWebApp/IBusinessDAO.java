package com.oa.couponsWebApp;


import java.util.Iterator;

public interface IBusinessDAO {
   public abstract Business getBusiness(int id);
   public abstract boolean updateBusiness(Business ob);
   public abstract Iterator<Business> getAllBusinesses();
   public abstract boolean deleteBusiness(int id);
   public abstract boolean addBusiness(Business ob);
}
