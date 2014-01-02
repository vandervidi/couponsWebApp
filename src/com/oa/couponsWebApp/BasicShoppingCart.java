package com.oa.couponsWebApp;



import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class BasicShoppingCart implements IShoppingCart{

	Vector<ShoppingCartRow> rows = new Vector<ShoppingCartRow>(); 
	
	
	@Override
	public void addCoupon(Coupon coupon) throws CouponsPlatformException {
		/*check if there is already a row with this product
		and update that row (if exists) or create a new one */
		
		//iterating all rows finding the row to work on (if exists)
		Iterator<ShoppingCartRow> iterator = rows.iterator();
		ShoppingCartRow rowToWorkOn = null;
		while(iterator.hasNext()) {
			ShoppingCartRow row = iterator.next();
			if(row.getCoupon().getId()==coupon.getId())
			{
				rowToWorkOn = row; 
				break;
			}
		}
		
		if(rowToWorkOn!=null)
		{
			//row exists
			rowToWorkOn.setQuantity(rowToWorkOn.getQuantity()+1);
		}
		else
		{
			//new row should be crearted
			ShoppingCartRow row = new ShoppingCartRow(coupon,1);
			rows.add(row);
		}
		
	}


	@Override
	public Collection<ShoppingCartRow> getShoppingCartRows()
			throws CouponsPlatformException {
		return rows;
	}

}
