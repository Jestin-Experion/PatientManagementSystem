
/*Patient Search functions*/
$( document ).ready(function() {
	 message();
	 $("#visitDateFrom").addClass('textStyle');
	 $("#visitDateTo").addClass('textStyle');
	 $("#ageFrom").addClass('textStyle');
	 $("#ageTo").addClass('textStyle');
	 
	 $( "#visitDateFrom" ).datepicker({
		 dateFormat: "dd/mm/yy",
		 showAnim: "fadeIn",
		 changeMonth: true,
		 changeYear: true
	 });
	 $( "#visitDateTo" ).datepicker({
		 dateFormat: "dd/mm/yy",
		 showAnim: "fadeIn",
		 changeMonth: true,
		 changeYear: true
	 });
});	
$(document).ready(function() {
    $("#ageFrom").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    
    
    $("#ageTo").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
});
function message(){	
		//var msg= document.getElementById('messageText').value;	
		document.getElementById('messages').style.display = 'none';
		//window.history.pushState("", "", '/PatientManagementSystem/restriction/list');
}
function getSubClassification(){	
	var id=document.getElementById('diseaseClassification').value;	
	$.ajax({
  	  type: "GET",
          cache: false,
          url: 'subClass?id='+id,
          data: "",
          success: function(response){        	  
        	  var obj = jQuery.parseJSON(response); 
        	  var option = '<option value="0">All</option>';
        	  for (i = 0; i < obj.length; i++) {        		 
        		  option += '<option value="'+ obj[i].id + '">' + obj[i].name + '</option>';
        		}      	  
        	  $('#diseaseSubClassification').empty().append(option);           	
          }
     }); 	
}
function addDisease(){	
	var option = '';
	$("#arrowRight").attr('src',"../resources/images/arrowRight.png");
	$("#arrowLeft").attr('src',"../resources/images/arrowLeft.png");
	$("#diseaseList option:selected").each(function () {		   
		   var $this = $(this);
		   if ($this.length) {		   		
		    	var selValue = $this.val();
		    	var selText = $this.text();
		    	$('#diseaseSelected option').each(function(){
		    	    if (this.value == selValue) {
		    	        this.remove();
		    	    }
		    	});
		   	 	option += '<option value="'+ selValue + '">' + selText + '</option>';
		   }		   
		});
	$('#diseaseSelected').append(option); 
	
	var $r = $("#diseaseSelected option");
    $r.sort(function(a, b) {
        if (a.text < b.text) return -1;
        if (a.text == b.text) return 0;
        return 1;
    });
    $($r).remove();
    $("#diseaseSelected").append($($r));
	
}
function removeDisease(){
	$("#arrowRight").attr('src',"../resources/images/arrowRight.png");
	$("#arrowLeft").attr('src',"../resources/images/arrowLeft.png");
	$("#diseaseSelected option:selected").each(function () {		   
		   var $this = $(this);
		   if ($this.length) {		   		
		    	var selValue = $this.val();
		    	var selText = $this.text();
		    	$this.remove();
		   }		   
		});
	
}

$(function() {
	 $('#diseaseList').click(function(){
	   $("#arrowLeft").attr('src',"../resources/images/arrowLeft.png");
	   $("#arrowRight").attr('src',"../resources/images/arrowRightGreen.png");
	   return false;
	 });
	 $('#diseaseSelected').click(function(){
		   $("#arrowRight").attr('src',"../resources/images/arrowRight.png");
		   if( $('#diseaseSelected').has('option').length > 0 ) {
		   $("#arrowLeft").attr('src',"../resources/images/arrowLeftRed.png");
		   }
		   return false;
		 });
	 $('#visitDateFrom').click(function(){
		   $('#visitDateFrom').val('');
		   return false;
		 });
	 $('#visitDateTo').click(function(){
		   $('#visitDateTo').val('');
		   return false;
		 });
	
	});

function beforeSubmit(){
	var dateFrom=document.getElementById('visitDateFrom').value;
	var dateTo=document.getElementById('visitDateTo').value;
	var ageFrom=(document.getElementById('ageFrom').value).trim();
	var ageTo=(document.getElementById('ageTo').value).trim();
	
	var date1 = new Date(dateFrom);
	var date2 = new Date(dateTo);	
	var timeDiff=(date2.getTime()-date1.getTime());
	var diffDays=Math.ceil(timeDiff/(1000*3600*24))+1;	
	
	 $("#visitDateFrom").addClass('textStyle');
	 $("#visitDateTo").addClass('textStyle');
	 $("#ageFrom").addClass('textStyle');
	 $("#ageTo").addClass('textStyle');
	
	
	$("#visitDateFrom").removeClass('errorDateClass');
	$("#visitDateTo").removeClass('errorDateClass');
	$("#ageFrom").removeClass('errorDateClass');
	$("#ageTo").removeClass('errorDateClass');	
	
	$("#visitDateFrom").removeClass('errorClass');
	$("#visitDateTo").removeClass('errorClass');
	$("#ageFrom").removeClass('errorClass');
	$("#ageTo").removeClass('errorClass');
	
	if(dateFrom!="" && dateTo==""){		
		$("#visitDateFrom").removeClass('textStyle');
		$("#visitDateTo").removeClass('textStyle');
		$("#visitDateFrom").addClass('errorClass');
		$("#visitDateTo").addClass('errorClass');
		return false;
	}
	else if(dateFrom=="" && dateTo!=""){
		$("#visitDateFrom").removeClass('textStyle');
		$("#visitDateTo").removeClass('textStyle');
		$("#visitDateFrom").addClass('errorClass');
		$("#visitDateTo").addClass('errorClass');
		return false;
	}
	else if(diffDays < 0){
		$("#visitDateFrom").removeClass('textStyle');
		$("#visitDateTo").removeClass('textStyle');
		$("#visitDateFrom").addClass('errorDateClass');
		$("#visitDateTo").addClass('errorDateClass');
		return false;
	}
	else if(ageFrom!="" && ageTo==""){	
		$("#ageFrom").removeClass('textStyle');
		$("#ageTo").removeClass('textStyle');
		$("#ageFrom").addClass('errorClass');
		$("#ageTo").addClass('errorClass');
		return false;
	}
	else if(ageFrom=="" && ageTo!=""){
		$("#ageFrom").removeClass('textStyle');
		$("#ageTo").removeClass('textStyle');
		$("#ageFrom").addClass('errorClass');
		$("#ageTo").addClass('errorClass');
		return false;
	}
	else if(parseInt(ageFrom) > parseInt(ageTo)){
		$("#ageFrom").removeClass('textStyle');
		$("#ageTo").removeClass('textStyle');
		$("#ageFrom").addClass('errorDateClass');
		$("#ageTo").addClass('errorDateClass');
		return false;
	}	
	return true;
}
	
$(document).ready(function(){
		$('#patientSearchForm').on('submit',function(e) {
		
			selectBox = document.getElementById("diseaseSelected");

	        for (var i = 0; i < selectBox.options.length; i++) 
	        { 
	             selectBox.options[i].selected = true; 
	        } 			
			
		document.getElementById('searchResult').innerHTML="<img src='../resources/images/loading.gif'/>";	
		$.ajax({
		url:'searchPatients',
		data:$(this).serialize(),
		type:'POST',
		success:function(response){		
			 $('#searchControls').slideUp(500);
			 /*$('#searchControls').hide('slide', {direction: 'left'}, 500);*/
			 $('#searchResult').empty().html(response) //=== Show Success Message==
		},
		error:function(data){
			alert("failed") //===Show Error Message====
		}
		});
		e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
		});
	});

function back(){
	$('#details').slideUp(500);
	$('#searchControls').slideDown(500);
}
function clearForm(){
	$('#diseaseSelected').empty();
	$("#arrowRight").attr('src',"../resources/images/arrowRight.png");
	$("#arrowLeft").attr('src',"../resources/images/arrowLeft.png");
	$("#visitDateFrom").removeClass('errorDateClass');
	$("#visitDateTo").removeClass('errorDateClass');
	$("#ageFrom").removeClass('errorDateClass');
	$("#ageTo").removeClass('errorDateClass');
	$("#visitDateFrom").removeClass('errorClass');
	$("#visitDateTo").removeClass('errorClass');
	$("#ageFrom").removeClass('errorClass');
	$("#ageTo").removeClass('errorClass');
	 $("#visitDateFrom").addClass('textStyle');
	 $("#visitDateTo").addClass('textStyle');
	 $("#ageFrom").addClass('textStyle');
	 $("#ageTo").addClass('textStyle');
}
function getDiseses(patientId){	
	var btn="<input type='button' id='cancel' onClick='closePopup()' value='Close'/>";
	document.getElementById('disesePopup').innerHTML="<img src='../resources/images/loading.gif'/>";	
    $.ajax({
    	  type: "GET",
            cache: false,
            url: 'getDiseases?id='+patientId,
            data: "",
            success: function(response){
                $('#disesePopup').empty().html(response+btn);		            	
            }
       }); 		     
$(function() {
	$( "#disesePopup").dialog({
		modal: true,
		title: "Diseases",
		draggable: true,
		resizable: false,
		height: 400,
		width: 600,
		position: { my: "center top", at: "center top+50", of: window }
		});
	});   
}

function closePopup(){
	$('#disesePopup').empty();	
	$('#disesePopup').dialog('destroy');
	/*$('#disesePopup').dialog('close');*/
}
