function checkPass() {
    var pass1 = document.getElementById('newpwd');
    var pass2 = document.getElementById('newpwd2');
    var message = document.getElementById('confirmMessage');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";

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


const responseHandler = {
    login : {
        errorLogin: function (response) {
            alert("Incorrect password or username!");
            $("#logusername").val("");
            $("#pwd").val("");
        },

        successLogin: function (response) {
            console.log(response)
            alert("Logged in, welcome:)");
            $(function () {
                $('#myLoginModal').modal('toggle');
            });
            $('.modal-backdrop').remove();
            $("#logusername").val("");
            $("#pwd").val("");
            $("#reglogbutton").hide();
            $("#logoutbutton").show();
            $("#user").text(logData.logUserName);

            $("#reglogbutton").attr("id", "logout");
            $("#logout").html('<a id="log-out" href="/logout">Logout</a>');
            $("#logout").wrap('<strong></strong>');
        },

    registration : {
            errorRegistration: function (response) {
                alert("Something is not quite right! :)");
                $("#newpwd").val("");
                $("#newpwd2").val("");
                $("#newemail").val("");
            },

            successRegistration: function (response) {
                alert("Thank you for registering!");
                $(function () {
                    $('#myLoginModal').modal('toggle');
                });
                $('.modal-backdrop').remove();
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
},



};

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
            success: responseHandler.registration.successRegistration,
            error: responseHandler.registration.errorRegistration
        })
    })
}


function login(){
    $('#login').on('submit', function (event) {
        event.preventDefault();
        let logData = {
            "logUserName" : $("#logusername").val(),
            "password" : $("#pwd").val()
        }

        $.ajax({
            url:'/login',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(logData),
            success: responseHandler.login.successLogin,
            error: responseHandler.login.errorLogin
        })
    })
}


function getCookie() {
    console.log(document.cookie);
}


$(document).ready(function () {
    getCookie();
    login();
    register();
});