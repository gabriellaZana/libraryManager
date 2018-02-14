function checkPass() {
    var pass1 = document.getElementById('newpwd');
    var pass2 = document.getElementById('newpwd2');
    var message = document.getElementById('confirmMessage');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";

    if(pass1.value == pass2.value){
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}

function register(){
    $('#register').on('submit', function (event) {
        event.preventDefault();
        var userData = new Map();

        userData.set("username", $("#username").val());
        userData.set("firstname", $("#firstname").val());
        userData.set("lastname", $("#lastname").val());
        userData.set("address", $("#address").val());
        userData.set("email", $("#newemail").val());
        userData.set("phonenum", $("#phonenum").val());
        userData.set("dateofbirth", $("#dateOfBirth").val());
        userData.set("password", $("#newpwd").val());

        $.ajax({
            url:'/register',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data:JSON.stringify(userData),
            success: function (response) {
                if(response == '"failure"'){
                    alert("Email is already in use!");
                    $("#newpwd").val("");
                    $("#newpwd2").val("");
                    $("#newemail").val("");
                } else {
                    $("#myLoginModal").hide();
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