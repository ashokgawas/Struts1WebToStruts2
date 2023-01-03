<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%> --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="WEB-INF/mytags.tld" prefix="m"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.errors li {
	list-style: none;
}
</style>
</head>
<body>
	<s:form action="login">
		<m:today />
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
		<s:textfield name="userName" label="User Name"></s:textfield>
		<s:textfield name="password" label="Password" type="password"></s:textfield>
		<h3>
			<s:property value="getText(error.userName.required)" />
		</h3>
		<s:submit value="Login" />
	</s:form>
</body>
</html>
