package com.oa.couponsWebApp;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;

public class MyTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		out.print("<h2>Hello Students</h2>");
	}
}
