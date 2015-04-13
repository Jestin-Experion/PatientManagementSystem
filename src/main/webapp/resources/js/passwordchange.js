
function changePass(){	
	var oldPass=$("#oldPassword").val().trim();
	var newPass=$("#newPassword").val().trim();
	var confirmPass=$("#confirmPassword").val().trim();
	document.getElementById('loading').innerHTML="";
	if (!oldPass.length > 0) {
		document.getElementById('loading').innerHTML=$("#enterOldPasswordMessage").val();
		return false;
	}
	else if(!newPass.length > 0){
		document.getElementById('loading').innerHTML=$("#enterNewPasswordMessage").val();
		return false;
	}
	else if(newPass!=confirmPass){
		document.getElementById('loading').innerHTML=$("#passwordNotMatchingMessage").val();
		return false;
	}	
	
	else{
		document.getElementById('loading').innerHTML="<img src='../resources/images/loading.gif' width='200px' height='15px'/>";
		$.ajax({
            type: "POST",
            url: "update",
            data: {oPass:oldPass, nPass:newPass}
            }).done(function( msg ) {						
               if(msg=="success"){
            	   document.getElementById('loading').innerHTML=$("#passwordChangedSuccessfullyMessage").val();
            	   setTimeout(function () {
            	       window.location.href = "../pms/logout"; //will redirect to your login page 
            	  }, 1000);
               }
               else if(msg=="failed"){
            	   document.getElementById('loading').innerHTML=$("#enterdOldPasswordIncorrectMessage").val();
               }
               else{
            	   document.getElementById('loading').innerHTML=$("#operationNotAllowdedMessage").val();
               }
        });	
	}
}

$(document).ready(function() {
	 $('#passwordChangeForm').keydown(function(e) {		 
	 var key = e.which;	 
	 if (key == 13) {	 
		 changePass();
	 }
	});
});