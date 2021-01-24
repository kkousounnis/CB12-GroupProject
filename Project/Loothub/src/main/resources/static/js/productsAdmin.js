$(document).ready(function () {
    var x = 1;
    $.ajax({ 
    type: 'GET', 
    url: "http://localhost:8080/api/productList",
    data: { get_param: 'value' }, 
    dataType: 'json',
    success: function (data) { 
        $.each(data, function(index, element) {
            let fileName = element.fileName;

            let newElement =  $(
                    ''+
                    '<div class="col-md-4">'+
                    '<figure class="card card-product-grid card-lg " >'+ 
                    '<a href="#" data-toggle="modal" \n\
                        data-target="#exampleModal" \n\
                        data-image="/img/products/'+fileName+'" \n\
                        data-name="'+element.name+'" \n\
                        data-description="'+element.description+'" \n\
                        data-price="'+element.price+'" \n\
                        data-productid="'+element.productId+'" class="img-wrap mx-auto d-block" data-abc="true">'+                                
                    '<img style="width: 200px;height: 200px" src="/img/products/'+fileName+'">'+                                
                    '</a>'+                                
                    '<figcaption class="info-wrap">'+                                
                    '<div class="row">'+                                
                    '<div class="col-md-8">'+                                
                    '<a href="#" class="title" data-abc="true" data-toggle="modal"\n\
                        data-target="#exampleModal" \n\
                        data-image="/img/products/'+fileName+'" \n\
                        data-name="'+element.name+'" \n\
                        data-description="'+element.description+'" \n\
                        data-price="'+element.price+'"\n\
                        data-productid="'+element.productId+'" value="'+element.name+'" >'+element.name+'</a>'+                    
                    '</div>'+                                
                    '<div class="col-md-4">'+                                
                    '<div style="font-size:80%;" class="rating text-right"><i> '+element.category+'</i></div>'+                                
                    '</div>'+                                
                    '</div>'+                                
                    '</figcaption>'+   
                    '<div class="bottom-wrap"> <button type="button" class="btn btn-danger float-right" onclick="deleteProduct('+ element.productId +')">Delete </button>'+                   
                    '<div class="price-wrap"> <span class="price h5" value="'+element.price+'">'+element.price+'&euro;</span> <br> <small class="text-success"> Product ID: '+ element.productId + '</small> </div>'+ 
                    '<small class="text-success"> Seller ID: '+ element.userId + '</small> </div>' +
                    '</div>'+                                
                    '</figure>'+                                
                    '</div>'+ 
                    +''
                    );
            $('.row.card-deck').append($(newElement, {
                
            }));  
            

            
        });
    }
});
});


function deleteProduct(id) {
$.ajax({
    url: 'http://localhost:8080/api/deleteProduct/' + id,
    type: 'DELETE',
    success: function(){
        alert("Succesfully deleted product!");
        location.reload(); 
    }
});
};