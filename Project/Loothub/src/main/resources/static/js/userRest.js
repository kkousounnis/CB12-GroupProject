$(document).ready(function () {
        $.ajax({
        type: 'GET',
                url: "http://localhost:8080/api/userList",
                data: { get_param: 'value' },
                dataType: 'json',
                success: function (data) {
                $.each(data, function(index, element) {
                    console.log(element.email + "HELLOOOOO");
                        let newElement = $(
                                '<tr>' +
                                '<td class="pl-4">1</td>' +
                                '<td>' +
                                '<h5 class="font-medium mb-0">' + element.firstName + " " + element.lastName + '</h5>' +
                                '</td>' +
                                '<td>' +
                                '<span class="text-muted">'  + element.email + '</span><br>' +
                                '</td>' +
                                '<td>' +
                                '<button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle"><i' +
                                'class="fa fa-key"></i> </button>' +
                                '<button type="button"' +
                                'class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"><i' +
                                'class="fa fa-trash"></i> </button>' +
                                '<button type="button"' +
                                'class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"><i' +
                                'class="fa fa-edit"></i> </button>' +
                                '<button type="button"' +
                                'class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"><i' +
                                'class="fa fa-upload"></i> </button>' +
                                '</td>' +
                                '</tr>'
                                );
                        $('.userListTable').append($(newElement, {

                }));
                });
                }
        });
        });
