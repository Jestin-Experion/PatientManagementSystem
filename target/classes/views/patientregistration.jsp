<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />	
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<title></title>	
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/cupertino/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>	
<script src="../resources/js/patientsearch.js"></script>

</head>
<body>
<div class="backcolor" align="center">
	<div id="messages" style="color: white;font-size: 14px; background-color: gray; height: 28px;padding-top: 2px;"> </div>	
		<div style="width:1000px;" id="searchControls">	
		<h2><spring:message code="patientRegistration.patientRegistration"/></h2>
		<form:form commandName="patientSearchForm" id="patientSearchForm" action="searchPatients">	
			<table style="width:100%;" class="noBorder">
				<tr><td>:)</td></tr>
			</table>
	</form:form>
	</div>
	<div id="searchResult">
	
	</div>	
</div>
</body>
</html>
