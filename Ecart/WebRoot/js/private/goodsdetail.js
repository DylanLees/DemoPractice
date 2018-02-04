$(document).ready(function() {
	findGoodsById();
});
// 根据商品id找到商品信息
function findGoodsById() {
	var goodsId = $("#goodsId").text();// 定义一个变量用于获取当前页面的商品id
	$.ajax({
		// 服务器地址
		url : 'ShowGoodsDetailServlet',
		// 请求方式
		type : 'POST',
		data : {
			time : new Date().getTime(),// 展示当前系统时间
			goodsId : goodsId,// 把当前商品id传递到servlet中
		},
		// 返回的数据类型
		dataType : "json",
		// servlet响应成功以后调用的函数
		success : function(data) {
			// 如果根据传入的商品id找到了商品信息，则展示商品详细信息。并调用showGoodsDetail()方法，并传入参数。
			showGoodsDetail(data);
		},
		// 如果servlet未响应成功则调用响应失败的函数
		error : function() {
			alert("服务器未响应")
		},
	});
}
//
function showGoodsDetail(data) {
	// data.goods.picture_name表示获取商品图片地址，并把地址中对应的图片内容展示到goodsdetail.jsp中id=picture_name所在位置。
	$("#picture_name").attr("src", data.goods.picture_name);
	// 获取商品的名称
	$("#goodsName").text("商品名称：" + data.goods.goodsName);
	// 获取商品价格
	$("#price").text("价格：" + data.goods.price);
	// 获取商品库存
	$("#inventory").text("库存：" + data.goods.inventory);
	// 获取商品特点
	$("#feature").text("特点：" + data.goods.feature);
	// 获取商品产地
	$("#product_site").text("产地：" + data.goods.product_site);

}