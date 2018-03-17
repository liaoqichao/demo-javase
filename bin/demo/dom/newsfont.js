/**
 * 设置新闻字体大小和颜色
 */

function changeFont(size,color){
	var oNewsText = document.getElementById("newstext");
	oNewsText.style.fontSize = size;	//obj.style.fontSize="24px"要引号,页面默认是16px
	oNewsText.style.color = color;
	//div节点有style属性
}

/**
 * 如果根据用户点击锁需要的效果不唯一。
 * 通过传递多个参数1.传参过多,阅读性差。2.js代码和css代码耦合性差。3.不利于扩展
 * 
 * 解决：将多个所需要的样式封装到选择器中。只给指定的标签加载不同的选择器就可以了
 * 1.预定义一些样式封装到选择器中。一般使用类选择器
 */
function changeFont2(selectorName){
	var oNewsText = document.getElementById("newstext");
	oNewsText.className = selectorName; /*不是obj.class而是用className来获取标签中的class属性*/
}