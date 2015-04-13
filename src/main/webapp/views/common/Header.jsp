	<%@ include file="/views/common/taglibs.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%
	/*  response.setDateHeader("Expires", 0);  
	 response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
	 response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
	 response.setHeader("Pragma", "no-cache");   */
	%>	
	<META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>; URL=../pms/login" />
<link rel="stylesheet" href="${contextPath}resources/css/style.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}resources/css/menustyles.css" type="text/css" />
<div id="header">
	<a href="../home/search"><img src="../resources/images/company_logo.png" align="left" style="margin-left: 20px;margin-top: 10px;border: 0px;"/></a>
</div>

		
	
