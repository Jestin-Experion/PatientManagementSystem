
function loginMe(){	
	var email=$("#email").val().trim();
	var pass=$("#password").val().trim();
	
	if (!email.length > 0) {
		document.getElementById('loading').innerHTML=$("#enterEmailMessage").val();
		return false;
	}
	else if(!pass.length > 0){
		document.getElementById('loading').innerHTML=$("#enterPasswordMessage").val();
		return false;
	}
	else if(!validateEmail(email)){
		document.getElementById('loading').innerHTML=$("#invalidEmailMessage").val();
		return false;
	}
	else{
		document.getElementById('loading').innerHTML="<img src='../resources/images/loading.gif' width='200px' height='15px'/>";
		$.ajax({
            type: "POST",
            url: "loginMe",
            data: {emailId:email, password:pass}
            }).done(function( msg ) {						
               if(msg=="success"){            	   
            	   $('#loginControlls').fadeOut();
            	   getFacitily(); 	
  	               $('#facilityDiv').fadeIn(); 
               }      
               else if(msg=="failed"){
            	   document.getElementById('loading').innerHTML=$("#invalidEmailOrPasswordMessage").val();            	   
				}
               else if(msg=="new"){
            	   document.getElementById('loading').innerHTML=$("#notSignedUpMessage").val();            	   
				}
               else if(msg=="reset"){
            	   document.getElementById('loading').innerHTML=$("#notResetPasswordMessage").val();            	   
				}
               else if(msg=="inactive"){
            	   document.getElementById('loading').innerHTML=$("#accountInactiveMessage").val();            	   
				}
               else{
            	   document.getElementById('loading').innerHTML=$("#operationNotAllowdedMessage").val();
               }
        });	
	}
	
}

function validateEmail(email){
	var emailReg = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
	var valid = emailReg.test(email);

	if(!valid) {
        return false;
    } else {
    	return true;
    }
}

$(document).ready(function() {
	 $('#loginForm').keydown(function(e) {		 
	 var key = e.which;	 
	 if (key == 13) {	 
		 loginMe();
	 }
	});
});


function getFacitily(){	
		 $.ajax({
	            type: "GET",
	            cache: false,
	            url: 'facility',
	            data: "",
	            success: function(response){	            	
	                $('#facilityDiv').empty().html(response);
	            }
	       });
	
}

