<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<s:iterator value="fileList">
		 <s:url id="downloadfileid" action="downloadfile">
		 	<s:param name="fileName" value="%{fileName}" /> <!-- important to save the param value onto action --> 
		 </s:url>
		 <s:a href="%{downloadfileid}"><s:property value="fileName"/></s:a><br/>
		
</s:iterator>
</body>
</html>