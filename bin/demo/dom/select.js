/**
 * 
 */
function changeColor(node){
//	alert(node.style.backgroundColor);
	document.getElementById("text").style.color = node.style.backgroundColor;
}

function changeColor2(){
	
	//获取下拉菜单节点
	var oSelectNode = document.getElementsByName("selectColor")[0];
	
	//获取所有的Option节点
	var collOptionNodes = oSelectNode.options;
	
	//select对象的属性：selectedIndex获取被选中的选项的位置
	document.getElementById("text").style.color = collOptionNodes[oSelectNode.selectedIndex].value;

}

function changeColor3(){
		 
	//获取下来菜单节点
	var oSelectNode = document.getElementsByName("selectColor2")[0];
	
	//获取所有option节点
	var collOptionNodes = oSelectNode.options;
	
	//获取被选中的节点
	var oOptionNode = collOptionNodes[oSelectNode.selectedIndex];
	
	//获取被选中的位置的背景颜色
	var color = oOptionNode.style.backgroundColor;
	
	//赋值到text区域的样式的颜色
	document.getElementById("text").style.color = color;
	
	//把下拉菜单的颜色变成和选中一样的颜色
	oSelectNode.style.backgroundColor = color;
}