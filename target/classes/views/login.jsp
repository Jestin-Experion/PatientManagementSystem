<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />	
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<link rel="shortcut icon" href="../favicon-1.ico" type="image/x-icon"/>
<title>PMS - Patient Management System</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/cupertino/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>	
<script src="../resources/js/login.js"></script>
</head>
<body background="../resources/images/greenlogin.jpg">
<div align="center">
	<!-- <div id="messages" style="color: white;font-size: 14px; background-color: gray; height: 28px;padding-top: 2px;"> </div>	 -->
		<div id="loginControlls" class="centerDiv">	
		<div align="left"><img src="../resources/images/company_logo.png" width="160px" height="30px"/></div>
		<form:form commandName="loginForm" id="loginForm">			
		<div class="space" id="errors" style="color: white;font-size: 16px; padding-top: 20px;"></div>
			<div class="container"> 			
			
			<div class="table-row" style="height: 40px">
        			 <%-- <div class="col"><spring:message code="login.emailId"/></div> --%>
    				 <div class="col" align="center"><form:input path="email" value="jestin@gmail.com" cssClass="textStyle" maxlength="255" id="email" cssStyle="width:275px" placeholder="Email"/> </div>
    		</div> 
    				
    		
			<div class="table-row" style="height: 30px">
         			<%-- <div class="col"><spring:message code="login.password"/></div> --%>
     				<div class="col" align="center" ><form:password path="password" value="123" cssClass="textStyle" id="password" maxlength="255" cssStyle="width:275px" placeholder="Password"/></div>
    		</div>
    		<div class="table-row">
    				<!-- <div class="col"></div> -->
    				<div class="col" align="center"><a href="#" onclick="loginMe()"> <img src="../resources/images/login.png" width="120px" height="50px" /></a></div>			
			</div>	
			</div>	
			<div id="loading" style="color: blue; font-size: 14px;padding-top: 3px;" align="center"></div>	
			
		</form:form>
			<input type="hidden" id="invalidEmailMessage" value="<spring:message code="login.message.invalidEmail"/>"/>
			<input type="hidden" id="enterEmailMessage" value="<spring:message code="login.message.enterEmail"/>"/>
			<input type="hidden" id="enterPasswordMessage" value="<spring:message code="login.message.enterPassword"/>"/>
			<input type="hidden" id="invalidEmailOrPasswordMessage" value="<spring:message code="login.message.invalidEmailOrPassword"/>"/>
			<input type="hidden" id="notSignedUpMessage" value="<spring:message code="login.message.notSignedUp"/>"/>
			<input type="hidden" id="notResetPasswordMessage" value="<spring:message code="login.message.notResetPassword"/>"/>
			<input type="hidden" id="accountInactiveMessage" value="<spring:message code="login.message.accountInactive"/>"/>
			<input type="hidden" id="operationNotAllowdedMessage" value="<spring:message code="login.message.operationNotAllowed"/>"/>
			
	</div>	
	<div id="facilityDiv"></div>	
</div>

</body>
</html>
