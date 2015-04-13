<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript">
$('#cancel').click(function () {
    $('#EditRestriction').dialog('close');
    return false;
});
function submitRestrictionUpdate() {	
	
	if(document.getElementById('restrictionName').value.trim()==""){		
		document.getElementById('errors').innerHTML=$("#restrictionNameMessage").val();	
		document.getElementById('EditRestriction').scrollTop = 0;
		return false;
	}
	else if(document.getElementById('description').value.trim()==""){
		document.getElementById('errors').innerHTML=$("#restrictionDescriptionMessage").val();	
		document.getElementById('EditRestriction').scrollTop = 0;
		return false;
	}
	
	var restrictioName=document.getElementById('restrictionName').value;
	var id=document.getElementById('restrictionId').value;
	 $.ajax({
	  type: "GET",
        cache: false,
        url: 'restrictionNameValidation?restrictionName='+restrictioName+'&id='+id,
        data: "",
        success: function(response){         	   
        	   if(response=='failed'){		 
        		  document.getElementById('errors').innerHTML=$("#restrictionNameExistsMessage").val();
        		 document.getElementById('EditRestriction').scrollTop = 0;
        	   }
        	   else if(response=='success'){
        		  document.forms['restrictionPopup'].action = "update";
        		  document.forms['restrictionPopup'].submit();         		   
        	   }
        }
   });	 
}
function scrollToTop(){
	document.getElementById('EditRestriction').scrollTop = 0;
}
</script>	
</head>
<body>
<div align="center">
<div id="errors" style="color: red;font-size: 16px"></div>
<%-- <spring:message code="restriction.edit.editRestriction"/> --%>
	<form:form id="restrictionPopup" action="update" commandName="newRestrictionForm" >	
	<div style="width: 960px;">
	<table style="width:100%">				   
	<tr>
	<td><spring:message code="restriction.edit.name"/></td><td>&nbsp;</td>
	<td><form:input path="restrictionName" id="restrictionName" maxlength="255" class="textBox"/></td><td>&nbsp;</td>
	<td><spring:message code="restriction.edit.description"/></td><td>&nbsp;</td>
	<td><form:textarea path="description" id="description" maxlength="4000"/></td><td>&nbsp;</td>
	<td><spring:message code="restriction.edit.active"/></td><td>&nbsp;
	<form:hidden path="restrictionId" id="restrictionId"/>
	<form:hidden path="createdOn"/>
	<form:hidden path="createdBy"/>
	</td>
	<td>
	<c:if test="${restrictiondetails.status == 'Active' }">
	<form:checkbox path="status" value="Active" checked="checked"/> 
	</c:if>
	<c:if test="${restrictiondetails.status == 'Inactive' }">
	<form:checkbox path="status" value="Active"/> 
	</c:if>		
	</td><td>&nbsp;</td>
	</tr></table>	
	</div>
	<div style="height: 10px"></div>
	<div id="foods" style="width:960px;height:290px;overflow: auto;overflow-x: hidden;border: 1px ridge;border-color: black;">	
			<table style="width:100%"  class="tdBorder">				
				<tr>
				<td class="errorMsgAddEmployee" colspan="2">
					<spring:hasBindErrors name="restrictionManagementForm">
						<form:errors path="restrictionName" id="restrictionName"/>
					</spring:hasBindErrors>					
				</td>
				</tr>
								
				<% int i=0;				
				pageContext.setAttribute("i",i);				
				%>		
						
				<c:forEach var="list" items="${restrictiondetails.restrictionLists}" >						
						<c:if test="${list.foodProduct.foodCategory.categoryName !=  category}">
							<tr><th colspan="2">${list.foodProduct.foodCategory.categoryName }</th></tr>							
							<c:set var="category" value="${list.foodProduct.foodCategory.categoryName }" ></c:set>						
						</c:if>							
					<tr>
					<td width="300">${list.foodProduct.foodName }</td>
					<td>
					
					<c:choose>
					<c:when test="${list.restrictionType == 'Do'}">
					<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Do" checked="checked"/><spring:message code="restriction.edit.do"/>					
					</c:when>		
					<c:otherwise>
					<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Do"/><spring:message code="restriction.edit.do"/>						
					</c:otherwise>
					</c:choose>
					
					<c:choose>
					<c:when test="${list.restrictionType == 'Dont'}">
					<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Dont" checked="checked"/><spring:message code="restriction.edit.dont"/>					
					</c:when>		
					<c:otherwise>
					<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Dont"/><spring:message code="restriction.edit.dont"/>				
					</c:otherwise>
					</c:choose>
					
					<c:choose>
					<c:when test="${list.restrictionType == 'Occasionally'}">
					<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Occasionally" checked="checked"/><spring:message code="restriction.edit.occasionally"/>					
					</c:when>		
					<c:otherwise>
					<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Occasionally"/><spring:message code="restriction.edit.occasionally"/>			
					</c:otherwise>
					</c:choose>					
					
					<form:hidden path="foodRestrictions[${i}].foodProductId" value="${list.foodProduct.id }"/>
					<form:hidden path="foodRestrictions[${i}].restrictionListId" value="${list.id }"/>
					<% 	pageContext.setAttribute("i",++i);%>				
					</td>						
				</c:forEach>							
			</table>			
	</div>	
	<div style="height: 10px"></div>
	<input type="button" value="<spring:message code="restriction.edit.save"/>" onclick="return submitRestrictionUpdate()">
	<input type="button" value="<spring:message code="restriction.edit.cancel"/>" id="cancel">	
	</form:form>
	<input type="hidden" id="restrictionNameMessage" value="<spring:message code="restriction.edit.message.enterRestrictionName"/>"/>
	<input type="hidden" id="restrictionDescriptionMessage" value="<spring:message code="restriction.edit.message.enterRestrictionDescription"/>"/>
	<input type="hidden" id="restrictionNameExistsMessage" value="<spring:message code="restriction.edit.message.restrictionNameExists"/>"/> 	
		
</div>
</body>
</html>
