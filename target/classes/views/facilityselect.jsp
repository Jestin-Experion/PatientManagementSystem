<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript">
$('document').ready(function(){	
	$.ajax({
           type: "POST",
           cache: false,
           url: 'getUserFacilityId',
           data: "",
           success: function(response){         	   
        	   $("select#facility").val(response);
           	}
	   });
	$( "#facility" ).focus();
	});

function home(){
	document.getElementById('facilityLoading').innerHTML="<img src='../resources/images/loading.gif' width='200px' height='15px'/>";
	var id=$("#facility").val();
	$.ajax({
        type: "GET",
        cache: false,
        url: 'setFacility?id='+id,
        data: "",
        success: function(response){  
        	$('#facilityDiv').fadeOut(500);    	
        	setTimeout(function () {
        	       window.location.href = "../home/search"; //will redirect to your home page 
        	  }, 200); //will call the function after 200 millisecs.
        	//$( location ).attr("href", "../home/search")
        	}
	   });	
}
	
$(document).ready(function() {
	 $('#selectFacility').keydown(function(e) {		 
	 var key = e.which;	 
	 if (key == 13) {	 
		 home();
	 }
	});
});


</script>
	
</head>
<body>
<div align="center">
<div id="errors" style="color: red;font-size: 16px"></div>
	<div class="centerDiv">
		<form:form id="selectFacility" commandName="facilitySelectForm">
		<div align="center" style="color: white;padding-top :6px; font-size: 16px">Facility</div>
		<div align="center" style="padding-top: 10px;">
		<form:select path="facilityName" class="textStyle" id="facility">
		<c:forEach var="facility" items="${facilities}">
		<option value="${facility.id}">
		${facility.facilityName}
		</option>	
		</c:forEach>	
		</form:select>
		</div>
		<div><a href="#" onclick="home()"> <img src="../resources/images/go.png" width="60px" height="65px" /></a></div>
		<div id="facilityLoading"></div>
		</form:form>
	</div>
</div>
</body>
</html>
