$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready


    $(".card").hover(
            function () {
                $(this).addClass('shadow-lg').css('cursor', 'pointer');
            }, function () {
        $(this).removeClass('shadow-lg');
    }
    );


    $("#search").hover(
            function () {
                $(this).css("background-color", "rgb(33, 182, 231)");
            }, function () {
        $(this).css("background-color", " rgb(88,203,241)");
    }
    );

    $("#searchbar").hover(
            function () {
                $(this).css("border-color", "rgb(33, 182, 231)");
            }, function () {
        $(this).css("border-color", "");
    }
    );

    // document ready  
});

$(document).ready(function () {
    $('.add_phone').click(function () {
        $('p.number:last').after('<p class="number">' + $('p.number').html() + '</p>');
    });
});


var popup = document.getElementById('popupsignup');
if (popup !== null) {
    $(document).ready(function () {
        $('#Signup').modal('show');
    });
}

var popup = document.getElementById('popupsignin');
if (popup !== null) {
    $(document).ready(function () {
        $('#Signin').modal('show');
    });
}

$(document).ready(function () {
    let myurl = window.location;

    //check if url contains with index 
    if (window.location.href.indexOf("#SigninProduct") > -1) {
        $('#Signin').modal('show');
    }
});

$('#exampleModal').on('show.bs.modal', function (event) {
    let button = $(event.relatedTarget); // Button that triggered the modal
    let name = button.data('name'); // Extract info from data-* attributes
    let productId = button.data('productid'); // Extract info from data-* attributes
    let productPrice = button.data('price');
    let productDescritpion = button.data('description');


    let imgSrc = button.data('image');
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.


    document.getElementById("product-name").innerHTML = name;
    document.getElementById("product-title").innerHTML = name;
    document.getElementById("myImage1").src = imgSrc;
    document.getElementById("product-description").innerHTML = productDescritpion;
    document.getElementById("product-price").innerHTML = productPrice + "&euro;";
    document.getElementById("productBuy").href = "http://localhost:8080/order/" + productId;




});

(function () {




    'use strict';
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');

        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

function searchFunction() {


    let searchText = document.getElementById("searchbar").value;

    window.location.href = "http://localhost:8080/products" + "?searchbar=" + searchText;
}





$(document).ready(function () {
    if (window.location.pathname == '/buy') {
        function initPayPalButton() {

            paypal.Buttons({
                style: {
                    shape: 'pill',
                    color: 'blue',
                    layout: 'vertical',
                    label: 'paypal',

                },

                createOrder: function (data, actions) {
                    let productPrice = document.getElementById("productPrice").innerText;

                    return actions.order.create({

                        purchase_units: [{"amount": {"currency_code": "EUR", "value": parseFloat(productPrice.replace(/,/g, ''))}}]

                    });
                },

                onApprove: function (data, actions) {
                    return actions.order.capture().then(function (details) {
                        document.getElementById("hiddenpaybutton").click();
                    });
                },

                onError: function (err) {
                    console.log(err);
                }
            }).render('#paypal-button-container');
        }
        initPayPalButton();

    }
});


function checkPasswordMatch(fieldConfirmPassword) {
    if (fieldConfirmPassword.value != $("#password").val()) {
        fieldConfirmPassword.setCustomValidity("Passwords do not match!");
    } else {
        fieldConfirmPassword.setCustomValidity("");
    }
}


$(document).ready(function () {
    if (window.location.pathname.includes('/order/')) {
        var connecteUser = document.getElementById("connecteduser").innerHTML;

        if (connecteUser !== null) {
            var displayPassword = document.getElementById("emailCheck").value;


            if (displayPassword !== '') {

                document.getElementById("passwordLabel").style.display = "none";
                document.getElementById("confirm_password").style.display = "none";
                document.getElementById("confirm_passwordLabel").style.display = "none";
                document.getElementById("password").style.display = "none";


                document.getElementById("firstname").readOnly = true;
                document.getElementById("lastName").readOnly = true;
                document.getElementById("emailCheck").readOnly = true;
                document.getElementById("phoneNumber").readOnly = true;

                document.getElementById("password").value = "123456";
                document.getElementById("confirm_password").value = "123456";
            }
        }
    }
});

$(document).ready(function () {
    if (window.location.pathname.includes('/profile')) {
        document.getElementById("id").style.display = "none";
        
}
});

$('#editAddress').on('show.bs.modal', function (event) {
    let button = $(event.relatedTarget); // Button that triggered the modal
    let id = button.data('id'); // Extract info from data-* attributes
    let country = button.data('country'); // Extract info from data-* attributes
    let city = button.data('city'); // Extract info from data-* attributes
    let streetName = button.data('streetn'); // Extract info from data-* attributes
    let streetNumber = button.data('streetnu'); // Extract info from data-* attributes
    let postalCode = button.data('postal'); // Extract info from data-* attributes
    
    document.getElementById("id").value = id;
    document.getElementById("country").value = country;
    document.getElementById("city").value = city;
    document.getElementById("streetName").value = streetName;
    document.getElementById("streetNumber").value = parseInt(streetNumber);
    document.getElementById("postalCode").value = postalCode;
});





