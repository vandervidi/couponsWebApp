package com.oa.couponsWebApp;

import java.io.*;

public class Rectangle implements Serializable
{
	

	public static final long serialVersionUID = 42L;

	private double width;
	private double height;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	public Rectangle() {
		super();
	}

	
	
	public void setWidth(double wdth)
	{
		width = wdth;
	}

	public void setHeight(double hght)
	{
		height = hght;
	}

	public double getHeight()
	{
		return height;
	}

	public double getWidth()
	{
		return width;
	}

	public double area()
	{
		return height*width;
	}
}
