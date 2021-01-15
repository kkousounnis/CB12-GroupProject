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
    var x = 1;
    $.ajax({ 
    type: 'GET', 
    url: "http://localhost:8080/api/productList",
    data: { get_param: 'value' }, 
    dataType: 'json',
    success: function (data) { 
        $.each(data, function(index, element) {
            var k = element.imagePath;
            $('main').append($('<h5>', {
                text: "Product{ Category" + element.category + 
                        ", Id"+element.id+
                        ", Name"+element.name+
                        ", Price"+element.price+
                        ", Description"+element.description+
                        ", Category"+element.category+
                        ", Product Id"+element.productImageId+
                        ", Image path"+element.imagePath+
                        ", FileName "+element.fileName+
                        ", User Id"+ element.userId+
                        "}"
                
            }));
            let newElement =  $(
                    ''+
                    '<div class="card p-3 mb-5 rounded" style="width: 18rem;">'+ 
                    '<img src="/img/products/1-leo_francis.jpeg" class="card-img-top" alt="...">'+
                    '<div class="card-body pull-left text-black">'+
                    '<h5 class="card-title">Card title</h5>'+
                    '<p class="card-text">Some quick example '+
                    'text to build on the card title and make'+
                    ' up the bulk of the cards content.</p>'+            
                    ' up the bulk of the cards content.</p>'+            
                    ' </div>'+            
                    +''
                    );
            $('.row.card-deck').append($(newElement, {
                
            }));  
            
//            newElement.appendTo("#container"+x);
//            if(x<=3){
//                x++;
//            }else{
//                
//                x=1;
//            }
            console.log(x);
            $('main').append($('<img src="/img/products/'+element.fileName+'">', {
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