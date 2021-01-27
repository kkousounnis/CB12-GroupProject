$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/api/getAllUsers",
        data: {get_param: 'value'},
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, element) {
                let newElement = $(
                        '<tr>' +
                        '<td class="pl-4">' + element.id + '</td>' +
                        '<td>' +
                        '<h5 class="font-medium mb-0">' + element.firstName + " " + element.lastName + '</h5>' +
                        '</td>' +
                        '<td>' +
                        '<span class="text-muted">' + element.email + '</span><br>' +
                        '</td>' +
                        '<td>' +
                        '<button type="button"' +
                        'class="delete btn btn-outline-info btn-circle btn-lg btn-circle ml-2" onclick="deleteUser(' + this.id + ')">' +
                        '<i class="fa fa-trash"></i> </button>'
                        );
                $('.userListTable').append($(newElement, {

                }));
            });
        }
    });

});

function deleteUser(id) {
    if(id !== 1) {
$.ajax({
    url: 'http://localhost:8080/api/deleteUser/' + id,
    type: 'DELETE',
    success: function(){
        alert("Succesfully deleted user!");
        location.reload(); 
    }
});
    } else {
        alert("You can't delete yourself dummy!");
    }
};


