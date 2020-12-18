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
      $(this).css("background-color", "rgb(24, 127, 161)");
    }, function () {
      $(this).css("background-color", " rgb(88,203,241)");
    }
  );




  // document ready  
});

