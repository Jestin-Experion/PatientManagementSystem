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

function submitRestriction() {	
	
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
	 $.ajax({
 	  type: "GET",
         cache: false,
         url: 'restrictionNameValidation?restrictionName='+restrictioName+'&id=0',
         data: "",
         success: function(response){         	   
         	   if(response=='failed'){		 
         		 document.getElementById('errors').innerHTML=$("#restrictionNameExistsMessage").val();
         		 document.getElementById('EditRestriction').scrollTop = 0;
         	   }
         	   else if(response=='success'){
         		  document.forms['restrictionPopup'].action = "save";
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
<%-- <spring:message code="restriction.new.createNewRestriction"/> --%>
	<form:form id="restrictionPopup" action="save" commandName="newRestrictionForm" >	
	<div style="width: 960px;">
	<table style="width:100%">					   
	<tr>
	<td><spring:message code="restriction.new.name"/></td><td>&nbsp;</td>
	<td><form:input path="restrictionName" id="restrictionName" maxlength="255" class="textBox"/></td><td>&nbsp;</td>
	<td><spring:message code="restriction.new.description"/></td><td>&nbsp;</td>
	<td><form:textarea path="description" id="description" maxlength="4000"/></td><td>&nbsp;</td>
	<td><spring:message code="restriction.new.active"/></td><td>&nbsp;</td>
	<td><form:checkbox path="status" value="Active" checked="checked"/> </td><td>&nbsp;</td>
	</tr></table>	
	</div>
	<div style="height: 10px"></div>
	<div id="foods" style="width:960px;height:290px;overflow: auto;overflow-x: hidden;border: 1px ridge;border-color: black;">	
			<table style="width:100%" class="tdBorder">				
				<tr>
				<td class="errorMsgAddEmployee" colspan="2">
					<spring:hasBindErrors name="restrictionManagementForm">
						<form:errors path="restrictionName" id="restrictionName"/>
					</spring:hasBindErrors>					
				</td>
				</tr>
				<tr>
				<% int i=0;
				pageContext.setAttribute("i",i);
				%>
				
				<c:forEach var="category" items="${categories}" >
				<th colspan="2">${category.categoryName }</th>									
				<c:forEach var="foodProduct" items="${category.foodProducts}">
				<tr> 
				<td width="300">${foodProduct.foodName}</td> 				 
				<td><%-- <form:radiobuttons path="foodRestrictions[${i}].restrictionType" items="${restrictionTypes}" /> --%>
				<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Do" /><spring:message code="restriction.new.do"/>					
				<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Dont" checked="checked" /><spring:message code="restriction.new.dont"/>
				<form:radiobutton path="foodRestrictions[${i}].restrictionType" value="Occasionally" /><spring:message code="restriction.new.occasionally"/>
				<form:hidden path="foodRestrictions[${i}].foodProductId" value="${foodProduct.id }"/>
				<% 	pageContext.setAttribute("i",++i);%>				
				</td>				
				</tr>
				</c:forEach>				
				</c:forEach>	
				</tr>       			
			</table>	
	</div>	
	<div style="height: 10px"></div>
	<input type="button" value="<spring:message code="restriction.new.save"/>" onclick="return submitRestriction()">
	<input type="button" value="<spring:message code="restriction.new.cancel"/>" id="cancel">
	</form:form>	
	<input type="hidden" id="restrictionNameMessage" value="<spring:message code="restriction.new.message.enterRestrictionName"/>"/>
	<input type="hidden" id="restrictionDescriptionMessage" value="<spring:message code="restriction.new.message.enterRestrictionDescription"/>"/>
	<input type="hidden" id="restrictionNameExistsMessage" value="<spring:message code="restriction.new.message.restrictionNameExists"/>"/>
	
</div>
</body>
</html>
