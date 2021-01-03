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
console.log(popup);
if (popup !== null) {
    $(document).ready(function () {
        $('#Signup').modal('show');
    });
}

var popup = document.getElementById('popupsignin');
console.log(popup);
if (popup !== null) {
    $(document).ready(function () {
        $('#Signin').modal('show');
    });
}