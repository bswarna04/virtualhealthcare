 const signinpassword = document.getElementById('signinpassword');
  const signinsubmit = document.getElementById('signinsubmit');
  signinsubmit.addEventListener("click",myFunction);
  function myFunction() {
    if(signinpassword.value.length < 8){
        signinpassword.innerText = "Password should be greater than 7  characters";
        alert('Password should be a minimum of 8 characters');
    }else if(signinpassword.value.length>20){
        signinpassword.innerText = "Password should be lesser than 20  characters";
        alert('Password should not be more than 20 characters');
    }

}

 // function validate_phone_number() {
 //     if (document.getElementById("phone").value === "") {
 //        alert("Enter your Phone Number");
 //        document.getElementById("phone").focus();
 //         return false;
 //     } else {
 //
 //         var phone = document.getElementById("phone").value;
 //         //alert(phone);
 //         //let re = new RegExp('/^[+][(]{0,1}[0-9]{1,3}[)]{0,1}[-\s./0-9]$/g');
 //         var phoneRe = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s.]{0,1}[0-9]{3}[-\s.]{0,1}[0-9]{4}$/;
 //
 //         if (phoneRe.test(phone) === phone) {
 //             alert("Enter your Phone number in (###)-###-#### format");
 //             document.getElementById("phone").focus();
 //             console.log("invalid number = " + document.getElementById("phone").value)
 //             return false;
 //         }
 //     }
 //
 //    return true;
 //
 // }

// $(document).ready(function() {
//
//     $('.fa-bars').click(function () {
//         $(this).toggleClass('fa-times');
//         $('.nav').toggleClass('nav-toggle');
//     });
//
//     $(window).on('load scroll', function () {
//
//         $('.fa-bars').removeClass('fa-times');
//         $('.nav').removeClass('nav-toggle');
//
//         if ($(window).scrollTop() > 10) {
//             $('header').addClass('header-active');
//         } else {
//             $('header').removeClass('header-active');
//         }
//
//     });
//
// });

