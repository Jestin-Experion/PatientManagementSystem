<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
    
<html>
<head>
<title></title>
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/cupertino/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>	
<script src="../resources/js/passwordchange.js"></script>
</head>
<div align="center">
	<!-- <div id="messages" style="color: white;font-size: 14px; background-color: gray; height: 28px;padding-top: 2px;"> </div>	 -->
		<div id="passwordChange" class=centerDiv>	
		<form:form commandName="passwordChangeForm" id="passwordChangeForm">			
		<div class="space" id="errors" style="color: white;font-size: 16px; padding-top: 20px;"></div>
			<div class="container"> 			
			
			<div class="table-row" style="height: 30px">
    				 <div class="col" align="center"><form:password path="oldPassword" cssClass="textStyle" maxlength="255" id="oldPassword" cssStyle="width:275px" placeholder="Old Password"/> </div>
    		</div>    				
    		
			<div class="table-row" style="height: 30px">
     				<div class="col" align="center" ><form:password path="newPassword" cssClass="textStyle" id="newPassword" maxlength="255" cssStyle="width:275px" placeholder="New Password"/></div>
    		</div>
    		<div class="table-row" style="height: 30px">
     				<div class="col" align="center" ><form:password path="confirmPassword" cssClass="textStyle" id="confirmPassword" maxlength="255" cssStyle="width:275px" placeholder="Confirm Password"/></div>
    		</div>
    		<div style="height: 10px"></div>
    		<div class="table-row">
    				<div class="col" align="center"><input type="button" onclick="changePass()" value="<spring:message code="passwordchange.button.changePassword"/>"> </div>			
			</div>	
			</div>	
			<div id="loading" style="color: blue; font-size: 14px;padding-top: 3px;" align="center"></div>	
		</form:form>
		<input type="hidden" id="enterOldPasswordMessage" value="<spring:message code="passwordchange.message.enterOldPassword"/>"/>
		<input type="hidden" id="enterNewPasswordMessage" value="<spring:message code="passwordchange.message.enterNewPassword"/>"/>
		<input type="hidden" id="passwordNotMatchingMessage" value="<spring:message code="passwordchange.message.passwordNotMatching"/>"/>
		<input type="hidden" id="passwordChangedSuccessfullyMessage" value="<spring:message code="passwordchange.message.passwordChangedSuccessfully"/>"/>
		<input type="hidden" id="enterdOldPasswordIncorrectMessage" value="<spring:message code="passwordchange.message.enteredOldPasswordIncorrect"/>"/>
		<input type="hidden" id="operationNotAllowdedMessage" value="<spring:message code="passwordchange.message.operationNotAllowded"/>"/>
	</div>	
	<div id="facilityDiv"></div>	
</div>

</body>
</html>
