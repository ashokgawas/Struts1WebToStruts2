package com.struts2.web;

import java.util.Map;
import org.apache.struts2.action.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

//public class LoginAction extends org.apache.struts.action.Action {
public class LoginAction extends ActionSupport implements SessionAware {

	private String userName;

	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Map<String, Object> sessionMap;

	private static final long serialVersionUID = -5211206847577910129L;
	/* forward name="success" path="" */
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	public String execute() throws Exception {
		// LoginForm loginForm = (LoginForm) form;
		if (getUserName() == null && getPassword() == null) {
			return "input";
		} else if (getUserName().equals(getPassword())) {
			// sessionMap.put("", FAILURE)
			UserDetails details = new UserDetails();
			details.setUsername(getUserName());
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}

	public void validate() {
		if (getUserName() == null && getPassword() == null) {
			return;
		}
		if (getUserName().length() == 0) {
			addFieldError("userName", "User Name is required");
		} else if (!getUserName().equals("abc")) {
			addActionError("Unauthorized User!!");
		}
		if (getPassword().length() == 0) {
			addFieldError("password", getText("error.password.required"));
		}
	}

	@Override
	public void withSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
}
