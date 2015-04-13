<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />
	<title>Code Objects</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/jquery-ui-1.8.16.custom.css">
	<script type="text/javascript" src="../resources/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="../resources/js/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="../resources/js/jquery.qtip-1.0.0-rc3.min.js"></script>
	<script type="text/javascript">
	var selectedEmpCode;
	var previousClass;
	var preEl;
		$(function() {
			$( "#receivedDate" ).datepicker();
			
		});
		
		
		$(document).ready(function() {
			$('#btnQueryItem').click(function() {
				$("#overlay").fadeIn('fast');
				$("#middle").fadeIn('fast');
				$("#popup").fadeIn('fast');
			});
		});

		function saveItem() {
			document.forms[0].action = "saveItem";
			document.forms[0].submit();
		}

		function addItem() {
			document.getElementById("itemNumber").value = "";
			document.getElementById("receivedDate").value = "";
			document.getElementById("itemDescription").value = "";
			document.getElementById("shippingNotes").value = "";
			document.getElementById("packageInstruction").value = "";
			document.getElementById("deliveredOn").value = "";
			document.getElementById("deliveredBy").value = "";
			document.getElementById("deliveryTrackingNo").value = "";
			
			document.forms[0].action = "index";
			document.forms[0].submit();
		}
		
		function deleteItem() {
			var itemNumber = document.getElementById("itemNumber").value;
			if (itemNumber == "" || itemNumber == null) {
				document.getElementById("emptyItemNumberForDelete").innerHTML = "<spring:message code='co.error.emptyItemNo'/>";
			} else {
				document.forms[0].action = "deleteItem";
				document.forms[0].submit();
			}
		}

		function shipItem() {
			document.forms[0].action = "shipItem";
			document.forms[0].submit();
		}
		
		function getItemNumber() {
			var itemNo = $("#queryItemNumber").val();
			if (itemNo == "") {
				document.getElementById("emptyItemNumber").innerHTML = "<spring:message code='co.error.emptyItemNoForDelete'/>";
			} else {
				document.forms[0].action = "queryItem";
				document.forms[0].submit();
			}
		}

		function closePopup() {
			$("#middle").hide();
			$("#overlay").hide();
			$("#popup").hide();
		}
	</script>
</head>
<body>
	<form:form commandName="bookManagementForm">
		<c:set var="disp" value="display:block"/>
		<div style="width:100%;">
			<table>
				<tr>
					<td colspan="0">
						<input type="button" id="btnQueryItem" style="margin-left:10px; background:#FF7F27; color:#FAFAFA;" value="<spring:message code="co.button.queryItem"/>" class="Button" onclick="queryItem();"/>
						<input type="button" style="background:#22B14C; color:#FAFAFA;" value="<spring:message code="co.button.shipItem"/>" class="Button" onclick="shipItem();"/>
						<input type="button" style="margin-left:50px; background:#0080C0; color:#FAFAFA;" value="<spring:message code="co.button.addItem"/>" class="Button" onclick="addItem();"/>
						<input type="button" style="background:#0080C0; color:#FAFAFA;" value="<spring:message code="co.button.deleteItem"/>" class="Button" onclick="deleteItem();"/>
						<input type="button" style="background:#0080C0; color:#FAFAFA;" value="<spring:message code="co.button.saveItem"/>" class="Button" onclick="saveItem();"/>
					</td>
				</tr>
			</table>
		</div>
		
	<div id="addList" style="${disp}">
	
	<span style="float:right;color:#CC0000;font-size: 12px;margin-right: 530px;margin-top: 10px;">
			<spring:message code="co.msg.mandatory"/>
		</span>	
		<span style="color:#6E6E6E;font:20px Tahoma;font-weight: bold;float:left;margin-left: 5px;">
			<br/>
			<img src="../resources/images/Screenshot.png" height="50px" width="50px" style="position:absolute;margin-top: -15px;"/>&nbsp;&nbsp;<span style="margin-left: 45px;margin-top: 10px;">Manage Books</span>
		</span>
		<br/><br/>
		<table border="0px;" style="padding-left: 40px; width: 500px;">
			<tr>
				<td colspan="6" align="center" id="emptyItemNumberForDelete" class="errorMsg" style="font-size: 14px; width: 756px;">
						<spring:hasBindErrors name="bookManagementForm">
							<form:errors path="emptyRecords" id="emptyRecords"/>
						</spring:hasBindErrors>
						<!-- >div style="float: left;width: 756px;margin-top: 18px;margin-left: 47px;" id="gblMessageDiv">-->
						<spring:hasBindErrors name="bookManagementForm">
							<form:errors path="gblMsg" cssClass="successMsg"/>
						</spring:hasBindErrors>
					<br/>
				</td>
			</tr>
		</table>
		<br/>
		<table border="0px;" style="margin-left: 40px;font-family: Tahoma;color:#827B60;"  cellpadding="1px;">
			
			<tr>
				<td width="150px"><spring:message code="co.label.itemNumber" /></td><td>&nbsp;</td>
				<td  width="250px"><form:input path="itemNumber" id="itemNumber"  cssClass="textBox" readonly="true" style="background-color:#E6E6E6;" /></td>
				<!-- <td></td> -->
				<td width="100px;"><spring:message code="co.label.receivedDate" /></td><td>&nbsp;</td>
				<td width="100px"><form:input path="receivedDate" id="receivedDate" cssClass="textBox" readonly="true" style="background-color:#E6E6E6;"/></td>
			</tr>
			<tr height="10px;">
				<td></td><td></td>
				<td class="errorMsgAddEmployee">
						<spring:hasBindErrors name="bookManagementForm">
							<form:errors path="itemNumber" id="itemNumber"/>
						</spring:hasBindErrors>
					</td>
					<td></td><td></td>
					<td class="errorMsgAddEmployee">
						<spring:hasBindErrors name="bookManagementForm">
							<form:errors path="receivedDate" id="receivedDate"/>
						</spring:hasBindErrors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="co.label.itemDescription" /></td><td>&nbsp;</td>
				<td colspan="4"><form:textarea path="itemDescription" id="itemDescription"  cssClass="textArea"/></td>
			</tr>
			<tr  height="10px;">
				<td></td><td></td>
				<td class="errorMsgAddEmployee">
					<spring:hasBindErrors name="bookManagementForm">
						<form:errors path="itemDescription" id="itemDescription"/>
					</spring:hasBindErrors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="co.label.shMethod" /></td><td>&nbsp;</td>
				<td>
					<div class="styled-select">
							<form:select path="shippingMethod" id="shippingMethod" cssClass="textBox">
								<form:option value="Ground"><spring:message code="co.cmbShMethod.ground"/></form:option>
								<form:option value="Air"><spring:message code="co.cmbShMethod.air"/></form:option>
								<%-- <c:forEach var="desig" items="${designation}">
									<option value="${desig.designationDesc}">
										<c:out value="${desig.designationDesc}"/>
									</option>
								</c:forEach> --%>
							</form:select> 
						</div>
				</td>
				
				<td nowrap="nowrap"><spring:message code="co.label.shPriority" /></td><td>&nbsp;</td>
				<td nowrap="nowrap">
					<div class="styled-select">
							<form:select path="shippingPriority" id="shippingPriority" cssClass="textBox">
								<form:option value="0"><spring:message code="co.cmbShPriority.asap"/></form:option>
								<form:option value="1"><spring:message code="co.cmbShPriority.nextDay"/></form:option>
								<form:option value="2"><spring:message code="co.cmbShPriority.3Days"/></form:option>
							</form:select> 
						</div>
				</td>
			</tr>
			<tr  height="10px;">
				<td></td><td></td>
				<td class="errorMsgAddEmployee">
					<spring:hasBindErrors name="bookManagementForm">
						<form:errors path="shippingMethod" id="shippingMethod"/>
					</spring:hasBindErrors>
				</td>
				<td></td><td></td>
				<td class="errorMsgAddEmployee">
					<spring:hasBindErrors name="bookManagementForm">
						<form:errors path="shippingPriority" id="shippingPriority"/>
					</spring:hasBindErrors>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="co.label.shNotes"/></td><td>&nbsp;</td>
				<td colspan="4"><form:textarea path="shippingNotes" id="shippingNotes"  cssClass="textArea"/></td>
			</tr>
			<tr  height="10px;">
				<td></td><td></td>
				<td class="errorMsgAddEmployee">
					<spring:hasBindErrors name="bookManagementForm">
						<form:errors path="shippingNotes" id="shippingNotes"/>
					</spring:hasBindErrors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="co.label.packageInstruction"/></td><td>&nbsp;</td>
				<td colspan="4"><form:textarea path="packageInstruction" id="packageInstruction" cssClass="textArea"/></td>
			</tr>
			<tr  height="10px;">
				<td></td><td></td>
				<td class="errorMsgAddEmployee">
					<spring:hasBindErrors name="bookManagementForm">
						<form:errors path="packageInstruction" id="packageInstruction"/>
					</spring:hasBindErrors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="co.label.deliveredOn" /></td><td>&nbsp;</td>
				<td>
					<form:input path="deliveredOn" id="deliveredOn" cssClass="textBox" readonly="true" style="background-color:#E6E6E6;" />
				</td>
				<td><spring:message code="co.label.deliveredBy" /></td><td>&nbsp;</td>
				<td>
					<form:input path="deliveredBy" id="deliveredBy" cssClass="textBox" readonly="true" style="background-color:#E6E6E6;" />
				</td>
			</tr>
			<tr height="10px;">
				<td></td><td></td>
				<td>
					</td>
					<td></td><td></td>
					<td>
				</td>
			</tr>
			<tr>
				<td><spring:message code="co.label.deliveryTrackingNo"/></td><td>&nbsp;</td>
				<td>
					<form:input path="deliveryTrackingNo" id="deliveryTrackingNo" cssClass="textBox" readonly="true" style="background-color:#E6E6E6;" />
				</td>
			</tr>
		</table>
		
	</div>
	
	<div id="overlay" style="z-index:11;"></div>
		<div id="middle" style="background: transparent;display: none;left: 230px;position: absolute;top: 130px;width: 1000px;height:455px;z-index: 10;">
			<div align="center" id="popup">
				<!-- form:hidden path="selectedDate" id="selectedDate" /-->
				<table id="popupHeader" style="height:23px;width: 100%;font-weight: bold;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius:9px;border-bottom-left-radius:9px">
					<tr>
						<td style="padding-left: 10px; padding-top: 10px; width: 100%;" colspan="2"><spring:message code="co.label.enterItem"/></td>
					</tr>
					
					<tr>
						<td style="padding-left: 10px; padding-top: 15px;"><spring:message code="co.label.queryItemNo"/>&nbsp;</td>
						<td style="padding-top: 15px;"><form:input path="queryItemNumber" id="queryItemNumber"  cssClass="textBox" maxlength="9" /></td>
					</tr>
					<tr>
						<td align="center" id="emptyItemNumber" class="errorMsg" style="font-size: 14px;"></td>
					</tr>
					<tr id="buttons">
						<td style="padding-top: 15px;">&nbsp;</td>
						<td style="padding-top: 15px; padding-left: 45px;" align="right"><input type="button" style="background:#0080C0; color:#FAFAFA;;border: 1px solid #808080;" value="<spring:message code="co.button.ok"/>" onclick="getItemNumber();"/>
						<input type="button" style="background:#0080C0; color:#FAFAFA;border: 1px solid #808080;" value="<spring:message code="co.button.cancel"/>" onclick="closePopup();"/>
					</tr>
				</table> 
				
			</div>
		</div>
		
  
</form:form>
</body>
</html>
