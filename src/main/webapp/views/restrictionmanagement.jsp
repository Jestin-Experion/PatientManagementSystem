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
<script src="../resources/js/restrictionmanagement.js"></script>

</head>
<body>
<div class="backcolor" align="center">
	<div id="messages" style="color: white;font-size: 14px; background-color: gray; height: 28px;padding-top: 2px;"> </div>
	<h2><spring:message code="restriction.management"/></h2>
	<div style="width:800px;">		
			<table style="width:100%">
				<tr>			
				<th style="width: 50%"><spring:message code="restriction.name"/></th>
				<th style="width: 35%"><spring:message code="restriction.active"/></th>
				<th style="width: 15%"><spring:message code="restriction.edit"/></th>					
				</tr>
				</table>
				</div>
		<div style="width:800px;height:300px;overflow:auto;overflow-x: hidden;">	
			<form:form commandName="restrictionManagementForm">
				<form:hidden path="messageText" id="messageText"/>
				<c:set var="disp" value="display:block"/>		
				<table style="width:100%" class="tdBorder">
				<c:forEach var="restriction" items="${restrictions}">
				<tr><c:set var="flag" value="1" ></c:set>	
      			<td style="width: 50%">${restriction.restrictionName }</td>      			     			      			
     			<td style="width: 35%">${restriction.status }</td>     			
       			<td style="text-align: center;width: 15% ">    		
      			<a href="#" onclick="editRestriction('${restriction.id }')"><img src="../resources/images/edit.png" height="20px" width="20px" style="margin-top: -2px;opacity:.5;border:0px;"/></a>      		
       			</td>
       			</tr>
       			 </c:forEach>
       			 <c:if test="${flag!=1 }">
       			 <tr><td colspan="3" style="text-align: center;"><font color="red"><spring:message code="restriction.noRestriction"/></font></td></tr>
       			 </c:if>
			</table>
			</form:form>
			<input type="hidden" id="createdSuccessfully" value="<spring:message code="restriction.message.createdSuccesfully"/>"/>	
			<input type="hidden" id="updatedSuccessfully" value="<spring:message code="restriction.message.updatedSuccesfully"/>"/>					
			
</div>	
<div><input type="button" onclick="createNewRestriction()" value="<spring:message code="restriction.button.createNewRestriction"/>"> </div>


<div id="EditRestriction" style="width: 80%;overflow:auto;" align="center">

</div>
</div>
</body>
</html>
