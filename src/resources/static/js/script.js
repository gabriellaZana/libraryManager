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
            $("#displayUserName").text((JSON.parse(response)).userName);
            $("#refToUserInfo").attr('href', '/userprofile/'+(JSON.parse(response)).id);
            $("#reglogbutton").attr("id", "logout");
            $("#logout").html('<a id="log-out" href="/logout">Logout</a>');
            $("#logout").wrap('<strong></strong>');
            location.reload(true);
            },

        errorRegistration: function (response) {
            console.log(response);
            let res = JSON.parse(response.responseText)
            alert("The emptied fields were wrong!");
            if (res.userName) {
                $("#username").val("");
            }
            if (res.firstName) {
                $("#firstname").val("");
            }
            if (res.lastName) {
                $("#lastname").val("");
            }
            if (res.address) {
                $("#address").val("");
            }
            if (res.email) {
                $("#newemail").val("");
            }
            if (res.phoneNumber) {
                $("#phonenum").val("");
            }
            if (res.dateOfBirth) {
                $("#dateOfBirth").val("");
            }
            if (res.password) {
                $("#newpwd").val("");
                $("#newpwd2").val("");
            }
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

function register(){
    $('#register-button').on('click', function (event) {
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
            success: responseHandler.successRegistration,
            error: responseHandler.errorRegistration
        })
    })
}


function login(){
    $('#loginButton').on('click', function (event) {
        let logData = {
            "logUserName" : $("#logusername").val(),
            "password" : $("#pwd").val()
        }

        $.ajax({
            url:'/login',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(logData),
            success: responseHandler.successLogin,
            error: responseHandler.errorLogin
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