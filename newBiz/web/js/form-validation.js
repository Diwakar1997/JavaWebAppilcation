$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      firstName: "required",
      lastName: "required",
      email: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      password: {
        required:true,
        minlength: 5
      },
      password_confirmation : {
                    required:true,
                    minlength:5,
                    passwordMatch: true
                },
      sponseName:{
          required: true,
          
      },
      userId:{
          minlength:10,
          required:true
      },
      aadhar:{
          minlength:12,
          required:true
      },
      sponseId: "required",
      address:"required"
    },
    // Specify validation error messages
    messages: {
      firstName: "Please enter your firstname",
      lastName: "Please enter your lastname",
      password: {
        
        minlength: "Your password must be at least 5 characters long"
      },
      password_confirmation:
              {
               minlength:"Your password must be at least 5 characters long",
               passwordMatch:"password and confirm password didnot matched"
              },
      userId:
              {
               required:"Please provide your contact details" ,
               minlength:"Contact No must be atleast 10 digits"
              },
      aadhar:
              {
               required:"Please provide your Aadhar ID" ,
               minlength:"Aadhar No must be atleast 12 digits"
              },
              
      
      email: "Please enter a valid email address",
      sponseName:"Enter the name of your Sponse",
      sponseId:"Enter Id of your sponse if admin then enter 0 as sponseId",
      address:"Enter your permanent address"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});