$(document).ready(function () {
    // executes when HTML-Document is loaded and DOM is ready
    console.log("document is ready");


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
    var myurl = window.location;
    console.log(myurl);
    if (str.myurl.includes("#SigninProduct")==true) {
        $('#Signin').modal('show');
    }
});


function initPayPalButton() {
    paypal.Buttons({
        style: {
            shape: 'pill',
            color: 'blue',
            layout: 'vertical',
            label: 'paypal',

        },

        createOrder: function (data, actions) {
            return actions.order.create({
                purchase_units: [{"amount": {"currency_code": "EUR", "value": 3000}}]
            });
        },

        onApprove: function (data, actions) {
            return actions.order.capture().then(function (details) {
                alert('Transaction completed by ' + details.payer.name.given_name + '!');
            });
        },

        onError: function (err) {
            console.log(err);
        }
    }).render('#paypal-button-container');
}
initPayPalButton();


