function checkPass() {
    var pass1 = document.getElementById('newpwd');
    var pass2 = document.getElementById('newpwd2');
    var message = document.getElementById('confirmMessage');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    var registerButton = document.getElementById('register-button');

    if(pass1.value === pass2.value){
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
        $("#register-button").show();
    }else{
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
        $("#register-button").hide();
    }
}

function register(){
    $('#register').on('submit', function (event) {
        event.preventDefault();
        let regData = {
            "userName": $("#username").val(),
            "firstName": $("#firstname").val(),
            "lastName": $("#lastname").val(),
            "address": $("#address").val(),
            "email": $("#newemail").val(),
            "phoneNumber": $("#phonenum").val(),
            "dateOfBirth": $("#dateOfBirth").val(),
            "password": $("#newpwd").val()
        };

        $.ajax({
            url:'/register',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(regData),
            success: function (response) {
                console.log(response);
                if(response === "failure"){
                    alert("Email is already in use!");
                    $("#newpwd").val("");
                    $("#newpwd2").val("");
                    $("#newemail").val("");
                } else {
                    $("#myLoginModal").hide();
                    $(".modal-backdrop fade in").hide();
                    alert("Thank you for registering!");
                    $(function () {
                        $('#myLoginModal').modal('toggle');
                    });
                    $("#username").val("");
                    $("#firstname").val("");
                    $("#lastname").val("");
                    $("#address").val("");
                    $("#newemail").val("");
                    $("#phonenum").val("");
                    $("#dateOfBirth").val("");
                    $("#newpwd").val("");
                    $("#newpwd2").val("");
                }
            }
        })
    })
}


$(document).ready(function () {
    register();
});