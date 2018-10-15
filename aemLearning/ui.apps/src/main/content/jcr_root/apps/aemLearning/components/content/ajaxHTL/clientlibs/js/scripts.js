
$(document).ready(function() {
   
    $('body').hide().fadeIn(5000);
 
   $('#submit').click(function() {
    var failure = function(err) {
             alert("Unable to retrive data "+err);
   };
   
    //Get the user-defined values that represent claim data to persist in the Adobe CQ JCR
    var myFirst= $('#FirstName').val() ; 
    var myLast= $('#LastName').val() ; 

   
   
    //Use JQuery AJAX request to post data to a Sling Servlet
    $.ajax({
         type: 'POST',    
         url:'/bin/htlSearchServlet',
         data:'&firstName='+ myFirst+'&lastName='+ myLast,
         success: function(msg){
  
           var json = jQuery.parseJSON(msg); 
            var msgId=   json.id;
            var lastName = json.lastname;
            var firstName = json.firstname;
               
            $('#ClaimNum').val(msgId); 
            $('#json').val("Filed by " + firstName + " " + lastName);   
         }
     });
  });
 
});