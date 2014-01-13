package com.oa.couponsWebApp;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.*;

/**
 * custom Tag called MyTag
 */
public class MyTag extends SimpleTagSupport {
	
	/**
	 * someting to do
	 */
//	public void doTag() throws JspException, IOException {
//		JspWriter out = getJspContext().getOut();
//		out.print("<h2>Hello user!<br>this is new custom Tag</h2>");
//	}
	public void doTag() throws JspException, IOException
	{
		JspFragment body = getJspBody();
		System.out.println(body.toString());
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=1>");
		for(int row=1;row<=10;row++)
		{
			sb.append("<tr>");
			for(int col=1;col<=10;col++)
			{
				sb.append("<td>"+(row*col)+"</td>");
			}
			sb.append("</tr>");
		}
		sb.append("</table>");
		JspWriter out = getJspContext().getOut();
		out.write(sb.toString());
	}
}
