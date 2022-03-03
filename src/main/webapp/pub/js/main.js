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


$(document).ready(function() {

    $('.fa-bars').click(function () {
        $(this).toggleClass('fa-times');
        $('.nav').toggleClass('nav-toggle');
    });

    $(window).on('load scroll', function () {

        $('.fa-bars').removeClass('fa-times');
        $('.nav').removeClass('nav-toggle');

        if ($(window).scrollTop() > 10) {
            $('header').addClass('header-active');
        } else {
            $('header').removeClass('header-active');
        }

    });

});

