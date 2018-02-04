$(function(){
	getValidateCode();
});
/**
 * 获取验证码的函数
 */
function getValidateCode() {
	alert("66");
	var id = Math.random();
	document.getElementById("validateCode").src = "ValidateCodeServlet?id="
			+ id;
}

