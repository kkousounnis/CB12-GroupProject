
function deleteAddress(id) {
$.ajax({
    url: 'http://localhost:8080/api/deleteAddress/' + id,
    type: 'DELETE',
    success: function(){
        alert("Succesfully deleted address!");
        location.reload(); 
    }
});
};
