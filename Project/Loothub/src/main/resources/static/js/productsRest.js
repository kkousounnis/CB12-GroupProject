$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/api/productList",
        data: {get_param: 'value'},
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, element) {
                let fileName = element.fileName;
                let cardName = element.name;
                console.log(cardName);
                
                const queryString = window.location.search;
                const urlParams = new URLSearchParams(queryString);
                let urlid = urlParams.get('searchbar')
                let y = urlid.trim().toLowerCase().replace(/\s/g,'') ;
                let z = cardName.trim().toLowerCase().replace(/\s/g,'') ;
                let d = z.includes(y);
                //console.log(y);
                //console.log(z);

                if(!urlid){
                    let x= el(fileName,element);
                    $('.row.card-deck').append($(x, {}));
                }else if( (z === y || d ===true)&& y.length>=3){ 
                    let x= el(fileName,element);
                    $('.row.card-deck').append($(x, {}));
                }
            });
        }
    });
});

function el(fileName,element){
    let newElement = $(
                        '' +
                        '<div class="col-md-4">' +
                        '<figure class="card card-product-grid card-lg " >' +
                        '<a href="#" data-toggle="modal" \n\
                        data-target="#exampleModal" \n\
                        data-image="/img/products/' + fileName + '" \n\
                        data-name="' + element.name + '" \n\
                        data-description="' + element.description + '" \n\
                        data-price="' + element.price + '" \n\
                        data-productid="' + element.productId + '" class="img-wrap mx-auto d-block" data-abc="true">' +
                        '<img style="width: 200px;height: 200px" src="/img/products/' + fileName + '">' +
                        '</a>' +
                        '<figcaption class="info-wrap">' +
                        '<div class="row">' +
                        '<div class="col-md-8">' +
                        '<a href="#" class="title" data-abc="true" data-toggle="modal"\n\
                        data-target="#exampleModal" \n\
                        data-image="/img/products/' + fileName + '" \n\
                        data-name="' + element.name + '" \n\
                        data-description="' + element.description + '" \n\
                        data-price="' + element.price + '"\n\
                        data-productid="' + element.productId + '" value="' + element.name + '" >' + element.name + '</a>' +
                        '</div>' +
                        '<div class="col-md-4">' +
                        '<div class="rating text-right"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> </div>' +
                        '</div>' +
                        '</div>' +
                        '</figcaption>' +
                        '<div class="bottom-wrap"> <a href="/order/' + element.productId + '"  type="submit"  class="btn btn-primary float-right" data-abc="true" value="Buy now">Buy now </a>' +
                        '<div class="price-wrap"> <span class="price h5" value="' + element.price + '">' + element.price + '&euro;</span> <br> <small class="text-success">Free shipping</small> </div>' +
                        '</div>' +
                        '</figure>' +
                        '</div>' +
                        +''
                        );

return newElement;
};