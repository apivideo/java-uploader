$(document).ready(function () {
    $("#login-clickable").click(function () {
        $("#login").toggle();
    });

    $("#loggedin-clickable").click(function () {
        $("#logged-in").toggle();
    });

    $("#log-out-button").click(function () {
            $.removeCookie('token', {path: '/'});
            window.location.assign(window.location.href);
        }
    );
    
    $("#login_form").submit(function () {
            var credentials = {
                email: $("#email_field").val(),
                password: $("#password_field").val()
            };
            $.ajax("/login", {
                    data: JSON.stringify(credentials),
                    contentType: 'application/json',
                    type: 'POST',
                    success: function (data) {
                        if (data.success) {
                            window.location.href = "/user/dash"
                        }
                        else {
                            var $loginMessage = $('#login-message');
                            $loginMessage.text(data.message);
                            $loginMessage.show();
                        }
                    }
                }
            );
            return false;
        }
    );
});