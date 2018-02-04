function Login(username,password){
	this.username=username;
	this.password=password;
}
Login.prototype={
	username:'',
	password:'',
	mailreg:function(username,password1,password2,email,captcha,callback){
		console.log(host+"/user");
		$.ajax({
			type:'post',
			url:host+"/user?method=regist",
			data:{
				'username':username,
				'password1':password1,
				'password2':password2,
				'email':email,
				'captcha':captcha,
				
			},
			dataType:'json'
			,
			success:callback
			
		})
		console.log("已发送")
	},
	userLogin:function(username,password,captcha,callback){
		$ajax({
			type:"post",
			url:host+"user/Login",
			data:{
				'username':username,
				'password':password,
				'captcha':captcha,
			},
			success:callback
		})
	}
	,
	message:function (target,message) {//信息显示
        if(message.length>12 && message.indexOf('登录')<=0 && message.indexOf('注册')<=0){
            alert(message);
            return ;
        }
        target.next().remove();
        if(target.parent().parent().hasClass('fill-list-none')){
            target.css("border","#ff6633 1px solid");
        }else{
            target.parent().css("border","#ff6633 1px solid");
        }
        target.after("<span style='z-index: 5;' class='posi-box'>"+message+"</span>");
        target.next().show();
    }
}