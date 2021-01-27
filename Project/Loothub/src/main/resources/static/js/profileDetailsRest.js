var counter = 0; 

function add() {
    counter += 1;
  return counter;
}
 
$(document).ready(function () {
    
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/api/getSellDetails",
        data: {get_param: 'value'},
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, element) {
                
                let newElement = $(
                        ' <tr>' +
                        '<th scope="row">'+(add())+'</th>' +
                        '<td>'+element.productName+'</td>' +
                        '<td>'+element.price+'&euro;</td>' +
                        '</tr>'
                        );
                $('.orderListTable').append($(newElement, {

                }));
            });
        }
    });

});

