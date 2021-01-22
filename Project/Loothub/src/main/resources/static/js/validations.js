$().ready(function(){
    
   $("#validationsFront").validate({
       rules:{           
           firstname:"required",
           lastname:"required",
           username:{
               required:true,
               minlength:2
           },
           password:{
               required:true,
               rangelength:[5,20]
           },
           confirm_password:{
               required:true,
               equalTo:"#password"
           },
           email:{
               required: true,
               email:true
           },
           tel_phone:{
               required:true,
               rangelength:[10,12]
           },
           messages:{
               firstname:"Please enter your firstname",
               lastname:"Please enter your lastname",
               password:{
                   required:"Please provide password",                   
                   rangelength:"Your password must be at least 5  and max 20 characters long."
               },
               confirm_password:{
                   required:"Please provide a password",
                   rangelength:"Your password must be at least 5  and max 20 characters long.",
                   equalTo:"Confirmation password do not macht please retype."
               },
               tel_phone:{
                   tel_phone:"Your phone number or telephone number must 10 to 12 digits."
               }
           }
           
       }
       
   }); 
});