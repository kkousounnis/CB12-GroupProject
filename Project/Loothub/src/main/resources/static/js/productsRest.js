$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/productList"
    }).then(function(data) {
       
       $('#category').append(data.category);
       $('#description').append(data.description);
       $('#id').append(data.id);
       $('#price').append(data.price);
    });
});