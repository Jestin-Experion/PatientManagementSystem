<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />	
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />	
<link rel="stylesheet" href="../resources/css/pagination.css" type="text/css" />	
<title></title>	
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/cupertino/jquery-ui.css">
<script src="../resources/js/tablepagination.js"></script>

</head>
<body>
<div class="backcolor" align="center" id="details">
	<div style="width:800px;" id="searchControls">		
		<h2>
		<spring:message code="search.result.searchResult"/></h2>			
			<table style="width:100%">
			<tr>
			<th width="270px"><spring:message code="search.result.name"/></th>
			<th width="80px"><spring:message code="search.result.regNo"/></th>
			<th width="50px"><spring:message code="search.result.gender"/></th>
			<th width="30px"><spring:message code="search.result.age"/></th>
			<%-- <th><spring:message code="search.result.lastVisitDate"/></th> --%>
			<th width="75px"><spring:message code="search.result.diseases"/></th>
			<%-- <th width="60px"><spring:message code="search.result.details"/></th> --%>
			<th width="60px"><spring:message code="search.result.createConsultation"/></th>						
			</tr>
			</table>
			</div>
			<div style="width:800px;height:300px;overflow:auto;overflow-x: hidden;">
			<form:form>
			<table style="width: 100%" class="tdBorder" id="searchResultTable">	
			<tr><td colspan="5"></td></tr>		
			<c:forEach var="patient" items="${patientLists}" varStatus="status">
			<tr><c:set var="flag" value="1" ></c:set>
			<td width="270px"><a href="#">${patient.patientName}</a></td>
			<td width="80px">${patient.registrationNumber}</td>
			<td width="50px">${patient.gender}</td>
			<td width="30px">${patient.dob}</td>
			<!-- <td></td> -->
			<td width="60px" align="center"><a href="#" onclick="getDiseses('${patient.id}')"><img src="../resources/images/list.png" width="15px" height="15px"/></a></td>
			<%-- <td width="60px"><a href="#"><spring:message code="search.result.clickHere"/></a></td> --%>
			<td width="80px" align="center"><a href="#"><img src="../resources/images/consultation.png" width="18px" height="18px"/></a></td>
			</tr>
			</c:forEach>
			<c:if test="${flag!=1 }">
       			<tr><td colspan="8" style="text-align: center;"><font color="red"><spring:message code="search.result.noResults"/></font></td></tr>
       		</c:if>
			</table>
			<div id="pageNavPosition" style="padding-top: 20px" align="center"></div>
			<script type="text/javascript">
			var pager = new Pager('searchResultTable', 8);
				pager.init();
				pager.showPageNav('pager', 'pageNavPosition');
				pager.showPage(1);
			</script>
			
		</form:form>
	</div>
	<input type="button" onclick="back()" value="<spring:message code="search.button.back"/>"/>
<div id="disesePopup" align="center" style="width: 80%;height: 350px;overflow:auto;"></div>

</div>
</body>
</html>
