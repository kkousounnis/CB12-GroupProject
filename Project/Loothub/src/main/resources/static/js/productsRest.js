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
        data: {get_param: 'value'},
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, element) {
                let fileName = element.fileName;

                let newElement = $(
                        '' +
                        '<div class="col-md-4">' +
                        '<figure class="card card-product-grid card-lg " >' +
                        '<a href="#" class="img-wrap mx-auto d-block" data-abc="true">' +
                        '<img style="width: 200px;height: 200px" src="/img/products/' + fileName + '">' +
                        '</a>' +
                        '<figcaption class="info-wrap">' +
                        '<div class="row">' +
                        '<div class="col-md-8">' +
                        '<a href="#" class="title" data-abc="true" value="' + element.name + '">' + element.name + '</a>' +
                        '</div>' +
                        '<div class="col-md-4">' +
                        '<div class="rating text-right"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> </div>' +
                        '</div>' +
                        '</div>' +
                        '</figcaption>' +
                        '<div class="bottom-wrap"> <a href="/loginsignup#SigninProduct"  type="submit"  class="btn btn-primary float-right" data-abc="true" value="Buy now">Buy now </a>' +
                        '<div class="price-wrap"> <span class="price h5" value="' + element.price + '">' + element.price + '&euro;</span> <br> <small class="text-success">Free shipping</small> </div>' +
                        '</div>' +
                        '</figure>' +
                        '</div>' +
                        +''
                        );
                $('.row.card-deck').append($(newElement, {

                }));



            });
        }
    });
});