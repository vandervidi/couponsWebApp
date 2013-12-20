package com.oa.couponsWebApp;


import java.util.Iterator;
/**
 * Business DAO interface.
 * @author Vidran & Ofir
 *
 */
public interface IBusinessDAO {
	/**
	 * This method return a business from a 
	 * database by its ID number.
	 * @param id		Business ID number.
	 * @return			Business instance.
	 */
   public abstract Business getBusiness(int id);
   /**
    * This method updates a Business instance in 
    * a database.
    * @param ob		Business instance to update.
    * @return		True if update is successfull and False if Update fails.
    */				
   public abstract boolean updateBusiness(Business ob);
   /**
    * This method returns all businesses.
    * @return		An iterator of businesses.
    */
   public abstract Iterator<Business> getAllBusinesses();
   /**
    * This method deletes a dsired business by its id.
    * @param id		The id number to be deleted.
    * @return		True if deleted sucessfully.Otherwise False.
    */
   public abstract boolean deleteBusiness(int id);
   /**
    * This method adds a new business object to the database.
    * @param ob		The business object to add.
    * @return		True if added sucessfully.Otherwise False.
    */			
   public abstract boolean addBusiness(Business ob);
}
