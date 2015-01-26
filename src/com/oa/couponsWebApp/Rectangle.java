package com.oa.couponsWebApp;

import java.io.*;

/**
 * Rectangle class
 */
public class Rectangle implements Serializable
{
	

	public static final long serialVersionUID = 42L;

	private double width;
	private double height;

	/**
	 * Rectangle constructor
	 */
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Rectangle default constructor
	 */
	public Rectangle() {
		super();
	}

	
	/**
	 * setWidth
	 */
	public void setWidth(double wdth)
	{
		width = wdth;
	}

	/**
	 * setHeight
	 */
	public void setHeight(double hght)
	{
		height = hght;
	}

	/**
	 * getHeight
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * getWidth
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * area
	 */
	public double area()
	{
		return height*width;
	}
}
