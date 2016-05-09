<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="dropzone.js"></script>
<title>Drag and Drop</title>
<link rel="stylesheet" href="dropzone2.css">
<link rel="stylesheet" href="styles.css">

</head>
<body>
<div align="center">
	<s:form action="uploadfile" enctype="multipart/form-data" method="post" class="dropzone"> 
		<!--dropzone uses a default <input type="file" name="file" /> -->
	</s:form>
</div>
<br/>
<div align="center">
	<a href="getfiles" style="color: gray;">Refresh uploaded files</a>
	<br/>
	<div style="text-align: left; padding: 0 100px 0 100px;">
		<s:iterator value="fileList">
			 <s:url id="downloadfileid" action="downloadfile">
			 	<s:param name="fileName" value="%{fileName}" /> <!-- important to save the param value onto action --> 
			 </s:url>
			 <s:a href="%{downloadfileid}"><s:property value="fileName"/></s:a><br/>
		</s:iterator>
	</div>
</div>
<!--  		
<form action="uploadfile" method="post" enctype="multipart/form-data">
<label for="file">Upload your file</label>
<input type="file" name="file" />
<input type="submit" value="Upload" />
</form> -->	   	
	
</body>
</html>