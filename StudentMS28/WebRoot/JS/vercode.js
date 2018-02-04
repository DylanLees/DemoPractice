function getCode(){
	var id = Math.random();
	document.getElementById("vercodeimg").src="PictureCheckCodeServlet?id="+id;
}
getCode();