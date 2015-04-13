	<%@ include file="/views/common/taglibs.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
	<%@page import="org.apache.commons.lang.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
	
<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
<c:url var="contextPath" value="/" >
</c:url>
<script>
$( "li" ).hover(
		function() {
		$( this ).append( $( "<span> ***</span>" ) );
		}, function() {
		$( this ).find( "span:last" ).remove();
		}
		);

</script>
<div>
	<div id='cssmenu'>	
  		<ul>
  		<li class='last'><a href='../home/search'><img src="../resources/images/Home2.png" height="16px" width="16px" style="margin-top: -4px;"/>
  		<spring:message code="menu.home"/></a></li>
  			<c:forEach var="mainMenu" items="${menus}">
  			 	<li class='has-sub'><a href='${mainMenu.redirectionUrl}'><span>${mainMenu.menuName}</span></a>  		
  			 	<ul>
  			  	<c:forEach var="subMenu" items="${mainMenu.subMenus}">  
  			 	 		<li class='last'><a href='${subMenu.redirectionUrl}'><span >${subMenu.subMenuName}</span></a> </li>  
            	</c:forEach>
               </ul>
               </li>
            </c:forEach>
             <li style="float: right;" class='last'><a href='../pms/logout'><spring:message code="menu.logout"/></a></li>  
             <li style="float: right;padding-top: 10px;padding-bottom: 10px;background: black;" class="text"><spring:message code="menu.welcome"/> ${userName} | ${date} |</li>
  			 <li style="float: right;background: black;" class="text">
  			 <a href="#"><img src="../resources/images/settings.png" height="14px" width="14px"/></a>
  			 <ul>
  			 <li class='last'><a href="../password/change"><spring:message code="menu.changePassword"/></a></li>
  			 </ul>
  			 </li>
  		</ul>  		
		</div>
		
</div>

