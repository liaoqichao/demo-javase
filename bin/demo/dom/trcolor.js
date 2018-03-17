/**
 * 
 */
var name;//记录之前的样式
function trColor(){
	//思路：
//	1.因为要操作行的样式,所以要先获取表格对象
//	2.获取所有被操作的行对象
//	3.遍历行并给每行指定样式
	//1.
	 var oTableNode = document.getElementById("info");//加载js的时候还没读到html的body,还不知道有info
	 
//	 alert(oTableNode);
	 //2.
	 var collTrNodes = oTableNode.rows;
	 
	 //3.遍历的时候从第二行开始遍历
	 for(var i=1 ;i<collTrNodes.length ;i++){
		 if(i%2==1){//奇数行
			 collTrNodes[i].className = "one";
		 }
		 else{
			 collTrNodes[i].className = "two";
		 }
		 //给每一个行对象都添加鼠标悬停事件和鼠标离开事件
		 collTrNodes[i].onmouseover = function(){
			 name = this.className;//得到老的样式
			 this.className = "over";
		 }
		 collTrNodes[i].onmouseout = function(){
			 this.className = name;//样式还原
		 }
	 }
}


onload = function(){
	//没有onload的话,直接调用trColor,oTableNode的值为null
	trColor();
}


//高亮
//function over(node){
//	name = node.className;//得到老的样式
//	node.className = "over";
//}
//function out(node){
//	node.className = name;
//}