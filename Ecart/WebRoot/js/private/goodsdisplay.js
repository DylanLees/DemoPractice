$(document).ready(function(){
	showPage();//调用该方法展示当前页面
	previous();//调用该方法展示上一页
	next();//调用该方法展示下一页
});
//创建显示当前页面的商品信息函数
function currentPageGoods(goods){ //传入一个goods对象
	for(var i=0;i<6;i++){
		var picture_name="#picture_name"+i;//定义用于接收图片id的变量
		var goodsName="#goodsName"+i;      //定义用于接收商品名称id的变量
		var goodsdetail="#goodsdetail"+i;  //定义用于接收商品详情的id变量
		//定义goodsdetail、picture_name、goodsName三个元素的在css页面的展示属性。none表示不展示
		$(picture_name).css("display","none");//不显示picture_name的内容
		$(goodsName).css("display","none");  //不显示goodsName的内容
		$(goodsdetail).css("display","none"); //不显示商品详情goodsdetail
	}
	for(var i=0;i<goods.length;i++){
		var picture_name="#picture_name"+i;//定义用于接收图片id的变量
		var goodsName="#goodsName"+i; 		//定义用于接收商品名称id的变量
		var goodsdetail="#goodsdetail"+i;	//定义用于接收商品详情的id变量
		//获取商品在数据库中的id，并在页面跳转到商品详情展示界面的时候，把id传过去。
		$(goodsdetail).attr("href","jsp/goodsdetail.jsp?id="+goods[i].id);
		//获取商品对应的图片地址
		$(picture_name).attr("src",goods[i].picture_name);
		//获取商品对应的商品名称
		$(goodsName).text(goods[i].goodsName);
		//定义goodsdetail、picture_name、goodsName三个元素的在css页面的展示属性。block表示展示
		$(goodsdetail).css("display","block");
		$(picture_name).css("display","block");
		$(goodsName).css("display","block");
	}
	
}
//定义展示商品页面的函数
function showPage(){
	var page=$("#assign").text();//获取当前页面的页码
	$.ajax({
		//服务器地址
		url : 'ShowGoodsByPageServlet',
		//请求方式
		type : 'POST',
		//传入到servlet的值
		data : {
			time:new Date().getTime(),//获取系统当前时间
			//把page参数传入到servlet中
			page:page
			
		},
		//返回的数据类型
		dataType : "json",
		//servlet响应成功的函数
		success : function(data) {
			//获取总页数
			$("#total").text(data.totalPage);//text(data.totalPage)表示获取text括号里面参数的值并传到对应的jsp页面id=total中。
			//获取当前页面页码
			var assign=$("#assign").text();//assign表示在jsp页面中的id=assign
			//调用获取当前页展示信息的方法，并传入参数
			currentPageGoods(data.goods);
			
		},
		//定义响应失败时的执行的方法
		error:function(){
			
		}
	});
};
//定义显示上一页的函数
function previous(){
	//$("#previous").click(function()表示在点击了jsp页面id=previous以后执行该方法。
	$("#previous").click(function(){
		//获取当前页码
		var assign=$("#assign").text();//该处获取的是一个字符串
		//判断当前页面页码小于2的时候将1赋值给assign作为当前页码。
		if(parseInt(assign)<2){
			$("#assign").text(1);
		}else{
			//该语句表示当前页面页码不在assign<2的范围内时，将当前页面的页码减1并赋值给id=assign
			$("#assign").text(parseInt(assign)-1);
			//在跳转到上一页之后要调用showPage()方法展示跳转后页面的信息。
			showPage();
		}
	});
};
//定义显示下一页的函数
function next(){
	//表示在点击id=next的按钮以后调用click方法。
	$("#next").click(function(){
		var totalPage=$("#total").text();//获取总的页数
		var assign=$("#assign").text();  //获取当前页的页码
		//判断当前页面页码小于总页数的时候执行if条件句里面的内容。
		if(parseInt(assign)<parseInt(totalPage)){
			//当前页面页码的值加上1并赋值给id=assign
			$("#assign").text(parseInt(assign)+1);
			//在跳转到下一页之后，调用showPage()方法展示跳转后的页面信息。
			showPage();
		}
		
	});
	
}
