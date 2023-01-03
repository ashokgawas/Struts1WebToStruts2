package com.struts2.custom;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport {

	private static final long serialVersionUID = -2262375406847716207L;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();// returns the instance of JspWriter
		try {
			out.print(Calendar.getInstance().getTime());// printing date and time using JspWriter
		} catch (Exception e) {
			System.err.println(e);
		}
		return SKIP_BODY;// will not evaluate the body content of the tag
	}

}
