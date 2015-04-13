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
		<h2><spring:message code="search.patientSearch"/></h2>
		<form:form commandName="patientSearchForm" id="patientSearchForm" action="searchPatients">	
			<table style="width:100%;" class="noBorder">
				<tr><td colspan="6"></td></tr><tr>
				<td><spring:message code="search.patientname"/></td>
				<td><form:input path="patientName" maxlength="255" id="patientName" cssClass="textStyle"/> </td>
				<td rowspan="5"><spring:message code="search.diseases"/></td>
				<td rowspan="5"><form:select path="diseaseList" multiple="multiple" id="diseaseList" cssClass="multiSelStyle">
				<c:forEach var="disease" items="${diseases}">
				<option value="${disease.id}">
				${disease.diseaseName}
				</option>
				</c:forEach>						
				</form:select> </td>
				<td rowspan="5">
				<a href="#" onclick="removeDisease()"><img id="arrowLeft" alt="" src="../resources/images/arrowLeft.png" width="25px" height="25px"/>	</a> 			
				<a href="#" onclick="addDisease()"> <img id="arrowRight" alt="" src="../resources/images/arrowRight.png" width="25px" height="25px"/> </a> 
				</td>		
				<td rowspan="5"><form:select path="diseaseSelected" multiple="multiple" id="diseaseSelected" cssClass="multiSelStyle"/>				
				</td>
				</tr>
				<tr>
				<td><spring:message code="search.gender"/></td>
				<td><form:select path="gender" cssClass="selectStyle">
				<option value="">
				<spring:message code="search.all"/>
				</option>
				<option value="Male">
				Male
				</option>	
				<option value="Female">
				Female
				</option>			
				</form:select> </td>								
				</tr>
				<tr>
				<td><spring:message code="search.facility"/></td>
				<td><form:select path="facilityName" cssClass="selectStyle">
				<option value="0">
				<spring:message code="search.all"/>
				</option>
				<c:forEach var="facility" items="${facilities}">
				<option value="${facility.id}">
				${facility.facilityName}
				</option>
				</c:forEach>
				</form:select></td>			
				</tr>
				<tr>
				<td><spring:message code="search.diseaseClassification"/></td>
				<td><form:select path="diseaseClassification" id="diseaseClassification" onchange="getSubClassification()" cssClass="selectStyle">
				<option value="0">
				<spring:message code="search.all"/>
				</option>
				<c:forEach var="diseaseClassification" items="${diseaseClassifications}">
				<option value="${diseaseClassification.id}">
				${diseaseClassification.classification}
				</option>
				</c:forEach>
				</form:select></td>
				
				</tr>
				<tr>
				<td><spring:message code="search.diseaseSubClassification"/></td>
				<td><form:select path="diseaseSubClassification" id="diseaseSubClassification" cssClass="selectStyle">	
				<option value="0">All</option>
				</form:select>							
				</td>				
				</tr>
				<tr>
				<td><spring:message code="search.resgistrationNumber"/></td>
				<td><form:input path="registrationNumber" maxlength="480" cssClass="textStyle"/></td>
				<td><spring:message code="search.visitDateRange"/></td>
				<td><form:input path="visitDateFrom" id="visitDateFrom" readonly="true" maxlength="255"/> </td>
				<td><spring:message code="search.to"/></td>
				<td><form:input path="visitDateTo" id="visitDateTo" readonly="true" maxlength="255"/> </td>
				</tr>
				<tr>
				<td><spring:message code="search.fileNumber"/></td>
				<td><form:input path="fileNumber" maxlength="480" cssClass="textStyle"/></td>
				<td><spring:message code="search.ageRange"/></td>
				<td><form:input path="ageFrom" id="ageFrom" maxlength="3"/> </td>
				<td><spring:message code="search.to"/></td>
				<td><form:input path="ageTo" id="ageTo" maxlength="3"/> </td>				
				</tr>
				<tr>
				<td align="center" colspan="6"><input type="submit" onclick="return beforeSubmit()" value="<spring:message code="search.button.search"/>">
				<input type="reset" onclick="clearForm()">
				</td>
				<tr><td colspan="6"></td>
				</tr>				
			</table>
	</form:form>
	</div>
	<div id="searchResult">
	
	</div>	
</div>
</body>
</html>
