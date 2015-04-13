
/*Disease Management functions*/
$( document ).ready(function() {
	 message();
});

function message(){	
	var msg= document.getElementById('messageText').value;	
	document.getElementById('messages').style.display = 'none';
	document.getElementById('EditDisease').style.display = 'none';
	window.history.pushState("", "", '/PatientManagementSystem/disease/list');
	if(msg=="updated"){
		 document.getElementById('messages').innerHTML=$("#updatedSuccessfullyMessage").val()+" &nbsp <a href='#' onClick='hideDiv()'><img src='../resources/images/uparrow.png' height='20px' width='20px'/></a>";			 
	}
	else if(msg=="saved"){
		 document.getElementById('messages').innerHTML=$("#addedSuccessfullyMessage").val()+" <a href='#' onClick='hideDiv()'><img src='../resources/images/uparrow.png' height='20px' width='20px'/></a>"; 
	}
	else{
		return;
	}
	
	$("#messages").slideDown(1000);		
}
function hideDiv(){
	$("#messages").slideUp(1000);
}

function addNewDisease(){
	document.getElementById("new_edit").innerHTML="";
	document.getElementById("new_edit").innerHTML="<h3>"+$("#addNewDiseaseMessage").val()+"</h3>";
	$("#diseaseId").val("");
	$('#addButton').slideUp(500);
	$('#EditDisease').slideDown(500);
	
	/*$(function() {
		$( "#EditDisease").dialog({
			modal: true,
			title: "Add Disease",
			draggable: true,
			resizable: false,
			height: 500,
			width: 1000,
			position: { my: "center top", at: "center top+50", of: window }
			});
		}); 
	 */
}
function submitDisease(){
	document.getElementById('errorDiv').innerHTML="";
	var diseaseId=$("#diseaseId").val().trim();	
	var diseaseName=$("#diseaseName").val().trim();
	var ayurvedaName=$("#ayurvedaName").val().trim();
	var classification=$("#classification").val().trim();
	var subclassification=$("#subClassification").val().trim();	
	if(diseaseName==""){
		document.getElementById('errorDiv').innerHTML=$("#enterDiseaseNameMessage").val();
		return false;
	}
	else if(ayurvedaName==""){
		document.getElementById('errorDiv').innerHTML=$("#enterAyurvedaNameMessage").val();
		return false;
	}
	else if(classification=="0"){
		document.getElementById('errorDiv').innerHTML=$("#selectClassificationMessage").val();
		return false;
	}
	else if(subclassification=="0"){
		document.getElementById('errorDiv').innerHTML=$("#selectSubClassificationMessage").val();
		return false;
	}
	if(diseaseId==""){
		$.ajax({
		 	  type: "GET",
		         cache: false,
		         url: 'diseseNameValidation?diseaseName='+diseaseName+'&id=0',
		         data: "",
		         success: function(response){         	   
		         	   if(response=='failed'){		 
		         		 document.getElementById('errorDiv').innerHTML=$("#enteredDiseaseNameExistsMessage").val();	         		 
		         	   }
		         	   else if(response=='success'){
		         		  document.forms['diseaseManagementForm'].action = "save";
		         		  document.forms['diseaseManagementForm'].submit();         		   
		         	   }
		         	   else{
		         		  document.getElementById('errorDiv').innerHTML=$("#operationNotAllowdedMessage").val();
		         	   }
		         }
		    });	 
	}
	else{
		$.ajax({
		 	  type: "GET",
		         cache: false,
		         url: 'diseseNameValidation?diseaseName='+diseaseName+'&id='+diseaseId,
		         data: "",
		         success: function(response){
		        	 
		         	   if(response=='failed'){		 
		         		 document.getElementById('errorDiv').innerHTML=$("#enteredDiseaseNameExistsMessage").val();	         		 
		         	   }
		         	   else if(response=='success'){
		         		  document.forms['diseaseManagementForm'].action = "update";
		         		  document.forms['diseaseManagementForm'].submit();         		   
		         	   }
		         	   else{
		         		  document.getElementById('errorDiv').innerHTML=$("#operationNotAllowdedMessage").val();
		         	   }
		         }
		    });	 
	}
}
function cancel(){	
	document.getElementById("diseaseManagementForm").reset();
	document.getElementById('errorDiv').innerHTML="";
	$('#EditDisease').slideUp(500);
    $('#addButton').slideDown(500); 
    document.getElementById("new_edit").innerHTML="";	
    return false;
}

function getSubClassification(){
	var id=document.getElementById('classification').value;	
	$.ajax({
  	  type: "GET",
          cache: false,
          url: 'subClass?id='+id,
          data: "",
          success: function(response){        	  
        	  var obj = jQuery.parseJSON(response); 
        	  var option = '<option value="0">-----Select-----</option>';
        	  for (i = 0; i < obj.length; i++) {        		 
        		  option += '<option value="'+ obj[i].id + '">' + obj[i].name + '</option>';
        		}      	  
        	  $('#subClassification').empty().append(option);           	
          }
     }); 	
}
function editDisease(id){
	document.getElementById("new_edit").innerHTML="";
	document.getElementById("new_edit").innerHTML="<h3>"+$("#editDiseaseMessage").val()+"</h3>";
	$.ajax({
	  	  type: "GET",
	          cache: false,
	          url: 'edit?id='+id,
	          data: "",
	          success: function(response){        	  
	        	  var obj = jQuery.parseJSON(response); 
	        	  for (i = 0; i < obj.length; i++) {
	        		  $("#diseaseId").val(obj[i].id);
	        		  $("#diseaseName").val(obj[i].diseaseName);
	        		  $("#ayurvedaName").val(obj[i].ayurvedaName);
	        		  $("#createdOn").val(obj[i].createdOn);
	        		  $("#createdBy").val(obj[i].createdBy);
	        		  $("select#classification").val(obj[i].classificationId);
	        		  var classId=obj[i].classificationId;
	        		  var subClassId=obj[i].subClassificationId;
	        		  //getSubClassification();	  
	        		  
	        		  if(obj[i].status=="Active"){
	        			  document.getElementById("status").checked = true;
	        		  }else{
	        			  document.getElementById("status").checked = false;
	        		  }
	        		  
	        		  $.ajax({
	        		  	  type: "GET",
	        		          cache: false,
	        		          url: 'subClass?id='+classId,
	        		          data: "",
	        		          success: function(response){        	  
	        		        	  var obj1 = jQuery.parseJSON(response); 
	        		        	  var option = '<option value="0">-----Select-----</option>';
	        		        	  for (i = 0; i < obj1.length; i++) {        		 
	        		        		  option += '<option value="'+ obj1[i].id + '">' + obj1[i].name + '</option>';
	        		        		}  
	        		        	  $('#subClassification').empty().append(option); 
	        		        	  
	        		        	  $("select#subClassification").val(subClassId);
	        		        	  $('#addButton').slideUp(500);
	        			          $('#EditDisease').slideDown(500);
	        		          }
	        		     }); 	
	        		 
	        		}
	        	
	          }
	     }); 	
}


