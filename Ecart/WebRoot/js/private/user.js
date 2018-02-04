function getVerCodePicture() {
	//获取随机验证码
	document.getElementById("verCodePicture").src = "PictureCheckCodeServlet?num=" + Math.random();
}
//调用函数
$(function(){
	getVerCodePicture(); //调用获取验证码的方法
})


/*
 * 定义登录的方法
 */
function login() { 
	$.ajax({
		//服务器地址
		url : 'LoginServlet',
		//请求方式
		type : 'POST',
		data : {
			userName : $("#userName").val(),
			password : $("#password").val(),
			verCode : $("#verCode").val()
		},
		//数据类型
		dataType : "json",
		success : function(data) {
			//登录成功之后跳转到商品展示页面
			window.location.href = 'jsp/goodsdisplay.jsp';
		}
	});
}
/*
 * 定义注册的函数
 */
function register() {
	$.ajax({
		//服务器地址
		url : 'RegisterServlet',
		//请求方式
		type : 'POST',
		data : {
			userName : $("#userName").val(),
			password : $("#password").val(),
			confirmPass : $("#confirmPass").val(),
			contact : $("#contact").val(),
			tel : $("#tel").val(),
			mail : $("#mail").val(),
			address : $("#address").val()
		},
		//数据类型
		dataType : "json",
		success : function(data) {
			alert("注册成功");
			//注册成功之后跳转值登录界面
			window.location.href = 'jsp/login.jsp';
		}
	});
}