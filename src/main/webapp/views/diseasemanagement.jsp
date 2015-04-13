<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />	
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<title></title>	
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/cupertino/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>	
<script src="../resources/js/diseasemanagement.js"></script>

</head>
<body>
<div class="backcolor" align="center">
	<div id="messages" style="color: white;font-size: 14px; background-color: gray; height: 28px;padding-top: 2px;"> </div>
	<h2><spring:message code="disease.diseaseManagement"/></h2>
	<div style="width:1000px;">		
			<table style="width:100%">
				<tr>			
				<th style="width: 20%"><spring:message code="disease.name"/></th>
				<th style="width: 11%"><spring:message code="disease.classification"/></th>
				<th style="width: 11%"><spring:message code="disease.subClassification"/></th>	
				<th style="width: 18%"><spring:message code="disease.ayurvedaName"/></th>
				<th style="width: 10%"><spring:message code="disease.active"/></th>
				<th style="width: 10%"><spring:message code="disease.edit"/></th>				
				</tr>
				</table>
				</div>
		<div style="width:1000px;height:170px;overflow:auto;overflow-x: hidden;">
					
				<table style="width:100%" class="tdBorder">
				<c:forEach var="disease" items="${diseases}">
				<tr><c:set var="flag" value="1" ></c:set>	
      			<td style="width: 20%">${disease.diseaseName }</td> 
      			<td style="width: 11%">${disease.diseaseClassificationName.classification }</td> 
      			<td style="width: 11%">${disease.diseaseSubClassificationName.subClassification }</td>   
      			<td style="width: 18%">${disease.ayurvedaName }</td>      			     			      			
     			<td style="width: 10%">${disease.status }</td>     			
       			<td style="text-align: center;width: 10% ">    		
      			<a href="#" onclick="editDisease('${disease.id }')"><img src="../resources/images/edit.png" height="20px" width="20px" style="margin-top: -2px;opacity:.5;border:0px;"/></a>      		
       			</td>
       			</tr>
       			 </c:forEach>
       			 <c:if test="${flag!=1 }">
       			 <tr><td colspan="3" style="text-align: center;"><font color="red"><spring:message code="disease.noDisease"/></font></td></tr>
       			 </c:if>
			</table>					
</div>	
<div style="height: 6px;"></div>
<div id="addButton"><input type="button" onclick="addNewDisease()" value="<spring:message code="disease.button.newDisease"/>"> </div>
<div id="new_edit"></div>
<div id="EditDisease" style="width: 80%;overflow:auto;" align="center">	
	<div style="width:1000px;height:200px;overflow:auto;overflow-x: hidden;">	
	<form:form commandName="diseaseManagementForm" id="diseaseManagementForm">
		<form:hidden path="messageText" id="messageText"/>
		<table style="width:100%" class="noBorder">
		<tr><td colspan="4" align="center"><div id="errorDiv" style="color: red;font-size: 12px;"></div> </td></tr>
		<tr>
		<td><spring:message code="disease.diseaseName"/></td>
		<td><form:input path="diseaseName" maxlength="255" cssClass="textStyle" id="diseaseName"/></td>
		<td><spring:message code="disease.classification"/></td>
		<td><form:select path="classification" cssClass="selectStyle" id="classification" onchange="getSubClassification()">
		<option value="0">
		-----Select-----
		</option>
		<c:forEach var="diseaseClassification" items="${diseaseClassifications}">
		<option value="${diseaseClassification.id}">
		${diseaseClassification.classification}
		</option>
		</c:forEach>
		</form:select> </td>
		</tr>
		<tr>
		<td><spring:message code="disease.ayurvedaName"/></td>
		<td><form:input path="ayurvedaName" maxlength="255" cssClass="textStyle" id="ayurvedaName"/></td>
		<td><spring:message code="disease.subClassification"/></td>
		<td><form:select path="subClassification" cssClass="selectStyle" id="subClassification">
		<option value="0">
		-----Select-----
		</option>
		</form:select></td>
		</tr>
		<tr><td colspan="4"></td></tr>
		<tr>
		<td colspan="4" align="center">
		<spring:message code="disease.active"/>
		<form:checkbox path="status" id="status" value="Active" checked="checked"/>
		</td>
		</tr>
		<tr><td colspan="4"></td></tr>
		<tr>
		<td colspan="4" align="center">
		<input type="button" value="<spring:message code="disease.button.save"/>" onclick="return submitDisease()">
		<input type="button" value="<spring:message code="disease.button.cancel"/>" onclick="cancel()">	 
		<form:hidden path="diseaseId" id="diseaseId"/>
		<form:hidden path="createdOn" id="createdOn"/>
		<form:hidden path="createdBy" id="createdBy"/>		
		</td>
		</tr>
		</table>
		</form:form>
		<input type="hidden" id="updatedSuccessfullyMessage" value="<spring:message code="disease.message.updatedSuccessfully"/>"/>
		<input type="hidden" id="addedSuccessfullyMessage" value="<spring:message code="disease.message.addedSuccessfully"/>"/>
		<input type="hidden" id="addNewDiseaseMessage" value="<spring:message code="disease.addNew"/>"/>
		<input type="hidden" id="editDiseaseMessage" value="<spring:message code="disease.edit"/>"/>
		<input type="hidden" id="enterDiseaseNameMessage" value="<spring:message code="disease.message.enterDiseaseName"/>"/>
		<input type="hidden" id="enterAyurvedaNameMessage" value="<spring:message code="disease.message.enterAyurvedaName"/>"/>
		<input type="hidden" id="selectClassificationMessage" value="<spring:message code="disease.message.selectDiseaseClassification"/>"/>
		<input type="hidden" id="selectSubClassificationMessage" value="<spring:message code="disease.message.selectDiseaseSubClassification"/>"/>
		<input type="hidden" id="enteredDiseaseNameExistsMessage" value="<spring:message code="disease.message.diseaseExists"/>"/>
		<input type="hidden" id="operationNotAllowdedMessage" value="<spring:message code="disease.message.operationNotAllowded"/>"/>
	</div>
</div>
</div>
</body>
</html>
