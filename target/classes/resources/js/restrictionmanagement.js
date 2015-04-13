
/*Restriction Management functions*/
$( document ).ready(function() {
	 message();
});
	
function editRestriction(restrictionId){
	
	document.getElementById('EditRestriction').innerHTML="<img src='../resources/images/loading.gif'/>";	
	        $.ajax({
	        	  type: "GET",
		            cache: false,
		            url: 'edit?id='+restrictionId,
		            data: "",
		            success: function(response){
		            	/* alert("success");  */
		                $('#EditRestriction').empty().html(response);		            	
		            }
		       }); 		     
	$(function() {
			$( "#EditRestriction").dialog({
				modal: true,
				title: "Edit Restriction",
				draggable: true,
				resizable: false,
				height: 500,
				width: 1000,
				position: { my: "center top", at: "center top+50", of: window }
				});
			});   
		
}
function createNewRestriction(){
	
	document.getElementById('EditRestriction').innerHTML="<img src='../resources/images/loading.gif'/>";
		 $.ajax({
	            type: "GET",
	            cache: false,
	            url: 'create',
	            data: "",
	            success: function(response){
	                $('#EditRestriction').empty().html(response);
	            }
	       });
	$(function() {
				$( "#EditRestriction").dialog({
					modal: true,
					title: "Create New Restriction",
					draggable: true,
					resizable: false,
					height: 500,
					width: 1000,
					position: { my: "center top", at: "center top+50", of: window }
				});
			}); 
}
function message(){	
		var msg= document.getElementById('messageText').value;	
		document.getElementById('messages').style.display = 'none';
		window.history.pushState("", "", '/PatientManagementSystem/restriction/list');
		if(msg=="updated"){
			 document.getElementById('messages').innerHTML=$("#updatedSuccessfully").val()+" &nbsp <a href='#' onClick='hideDiv()'><img src='../resources/images/uparrow.png' height='20px' width='20px'/></a>";			 
		}
		else if(msg=="saved"){
			 document.getElementById('messages').innerHTML=$("#createdSuccessfully").val()+" &nbsp <a href='#' onClick='hideDiv()'><img src='../resources/images/uparrow.png' height='20px' width='20px'/></a>"; 
		}
		else{
			return;
		}
		
		$("#messages").slideDown(1000);		
}
function hideDiv(){
   		 $("#messages").slideUp(1000);
}


/*New restriction functions */


