$(function(){
	$(".change .fill-list input").focus(function(){
		$(this).parent().css("border","#b2b2b2 1px solid")
	})
	 $(".change .fill-list input").blur(function () {
        $(this).parent().css("border", "#e2e2e2 1px solid");
    });
    $(".change .fill-list-none input").focus(function () {
        $(this).css("border", "#b2b2b2 1px solid");
    });
    $(".change .fill-list-none input").blur(function () {
        $(this).css("border", "#e2e2e2 1px solid");
    });
	
})
var username=$("input[name='user']");
var userMail=$("input[name='userEmail']");
var password=$("input[name='password1']");
var passwordReg=$("input[name='password2']");
var emailYZM=$("input[name='userEmail-code']");
var captch=$(".change .fill-list-none .yzm");
var register=$("input[name='mail-reg']");
var reglogin=$("input[name='mail-login']");




$(function(){
	var login=new Login(username.val(),password.val());
	var lo=function(){
		var login=new Login(username.val(),password.val());
		login.userLogin(username.val(), password.val(), captch.val() , function (json) {
			json=json[0]
            state = json.state;
            message = json.message;
            if (state == 0) {
                location.href = location.href
            } else {
                
                if (state > 1000 && state < 2000) {
                    
                   login.message(username, message);
                    
                } else if (state > 2000 && state < 3000) {
                    login.message(password, message);
                } else if (state > 3000 && state < 4000) {
                    login.message(captch, message);
                }  else {
                    alert(message);
                    return false;
                }

            }
        });
//		if (password.val() != passwordReg.val()) {
//            login.message(passwordReg, '两次密码不一致');
//            return;
//        }
	}
	var reg = function () {
        var login = new Login(username.val(), password.val());
        
        login.mailreg(username.val(), password.val(), passwordReg.val(), userMail.val(), emailYZM.val(), function (json) {
        	json=json[0]
            state = json.state;
            message = json.message;
            if (state == 0) {
                location.href = message;
            } else {
               
                if (state > 1000 && state < 2000) {
                    login.message(username, message);
                    //}
                } else if (state > 2000 && state < 3000) {
                    login.message(password, message);
                } else if (state > 3000 && state < 4000) {
                    login.message(passwordReg, message);
                } else {
                    login.message(email, message);
                    return false;
                }
            }
        });
    };
	username.focus(function () {
        $(this).next().remove();
    }).blur(function () {
        if (username.val().length == 0) {
            login.message(username, '密码不能为空');
        }
    });
	password.focus(function () {
        $(this).next().remove();
    }).blur(function () {
		
        if (password.val().length == 0) {
            login.message(password, '密码不能为空');
        }
    })
	passwordReg.focus(function () {
        $(this).next().remove();
    }).blur(function () {
        if (passwordReg.val().length == 0) {
            login.message(passwordReg, '密码不能为空');
        }
    })
	userMail.focus(function () {
        $(this).next().remove();
    }).blur(function () {
        if (userMail.val().length == 0) {
            login.message(userMail, '密码不能为空');
        }
    })
	emailYZM.focus(function () {
        $(this).next().remove();
    }).blur(function () {
		
        if (emailYZM.val().length == 0) {
            login.message(emailYZM, '密码不能为空');
        }
    })
	register.click(reg);
	reglogin.click(lo)
	
})