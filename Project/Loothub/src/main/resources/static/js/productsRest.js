$(document).ready(function () {
//    $.ajax({
//        url: "http://localhost:8080/api/productList"
//    }).then(function (data) {
//         
//
//        $('#category').append(data.category);
//        $('#description').append(data.description);
//        $('#name').append(data.name);
//        $('#id').append(data.id);
//        $('#price').append(data.price);
//    });
    
    $.ajax({ 
    type: 'GET', 
    url: "http://localhost:8080/api/productList",
    data: { get_param: 'value' }, 
    dataType: 'json',
    success: function (data) { 
        $.each(data, function(index, element) {
            var k = element.imagePath;
            $('main').append($('<h1>', {
                text: "Product{ Category" + element.category + 
                        ", Name"+element.name+
                        ", Price"+element.price+
                        ", Description"+element.description+
                        "Image path"+element.imagePath+
                        "}"
                
            }));
            $('main').append($('<h2>', {
                text: "Product{ Category" + element.category + 
                        ", Name"+element.name+
                        ", Price"+element.price+
                        ", Description"+element.description+
                        "}"
                
            }));
            $('main').append($('<img src="../../../../../../../../../../../../../../../tmp/images/3/leo_francis.jpeg">', {
                text: " Product{ Category" + element.category + 
                        ", Name"+element.name+
                        ", Price"+element.price+
                        ", Description"+element.description+
                        "}"
                
            }));
            
        });
    }
});
});