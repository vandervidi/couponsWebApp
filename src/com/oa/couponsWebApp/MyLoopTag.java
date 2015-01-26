package com.oa.couponsWebApp;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

/**
 * custom tag class
 */
public class MyLoopTag extends SimpleTagSupport {
	private int loops = 1;
	
	/**
	 * custom tag count to show
	 * @param str
	 */
	public void setCount(String str){
		loops = Integer.parseInt(str);
	}
	
	/**
	 * what to do with this tag
	 */
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<h2>start</h2>");
		for(int i=0; i<loops; i++) {
			getJspBody().invoke(null);
		}
		out.print("<h2>end</h2>");
	}
}
