$().ready(function(){
    
   $("#demo").validate({
       rules:{
           firstname:"required",
           lastname:"required",
           username:{
               required:true,
               minlength:2
           },
           password:{
               required:true,
               rangelength:[4,20],
               minlength:5
           },
           confirm_password:{
               required:true,
               equalTo:"#password"
           },
           email:{
               required: true,
               email:true
           },
           messages:{
               firstname:"Please enter your firstname",
               lastname:"Please enter your lastname",
               password:{
                   required:"Please provide password",
                   minlength:"Your password must be at least 5 characters long.",
                   rangelength:" 4 and 20"
               },
               confirm_password:{
                   required:"Please provide a password",
                   minlength:"Your password must be at least 5 char long",
                   equalTo:"Please enter the same password as above"
               }
           }
           
       }
       
   }); 
});