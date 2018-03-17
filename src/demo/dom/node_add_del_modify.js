/**
 * 
 */
	
//创建并添加节点
//需求：在div_1节点中添加一个文本节点
function crtAndAdd(){
	
	//1.创建一个文本节点
	//2.获取div_1节点
	//3.将文本区域节点添加到div_1节点中
	
	//1
	var oTextNode = document.createTextNode("这是一个新文本");
	
	//2
	var oDivNode = document.getElementById("div_1");
	
	//3
	oDivNode.appendChild(oTextNode);
}

//创建并添加元素
//需求:在div_1中创建并添加按钮节点
function crtAndAdd2(){
	
	//1.创建一个按钮
	var oButton = document.createElement("input");
	
	//2.设置input的属性
	oButton.type="button";
	oButton.value="这是一个新按钮";
	
	//3.获取div_1节点
	var oDivNode = document.getElementById("div_1");
	
	//4.将按钮节点添加到div_1节点中
	oDivNode.appendChild(oButton);
}

//用容器型标签的innerHTML属性,这个属性可以设置HTML文本(不是添加或追加,再按会覆盖掉之前的),这种方式用得比较多
function crtAndAdd3(){
	
	//1.
	var oDivNode = document.getElementById("div_1");
	
	//2.
	oDivNode.innerHTML = "<input type='button' value='新按钮2'/>";
	
	
}

//需求,将div_2节点删除
function delNode(){
	//容器型标签
//	removeAttribute
//	removeAttributeNode
//	removeBehavior		分离行为?
//	removeChild
//	removeExpression	表达式
//	removeNode
	
	//1.获取div_2节点
	var oDivNode = document.getElementById("div_2");
	
	//2.删除节点
	
//	oDivNode.removeNode(false);
//	//删除了本节点,但是没有删除该节点的子孙
//	oDivNode.removeNode(true);
	//删除本节点以及节点的子孙,较少用
	
//	一般使用removeChild(),删除子节点
//	获取div_2的父节点,然后再用父节点的removeChild删除div_2
	oDivNode.parentNode.removeChild(oDivNode);
}


//需求：用div_3节点,替换div_1节点
function modifyNode(){
	
//	replaceNode、replaceChild
	
	//1.获取div_3和div_1
	//2.使用replaceNode进行替换
	
	var oDivNode_1 = document.getElementById("div_1");
	var oDivNode_3 = document.getElementById("div_3");
	
//	oDivNode_1.replaceNode(oDivNode_3); //用div_3替换div_1,  不建议使用
//	1.删除div_1(包括子节点) ，2.把div_3(包括子节点)移到div_1的位置
	
//	建议使用旧.parentNode.replaceChilde(新,旧)
	oDivNode_1.parentNode.replaceChild(oDivNode_3,oDivNode_1);
}

//需求：希望用div_3替换div_1,并保留div_3节点
//其实就是克隆div_3
function modifyNode2(){
	
	var oDivNode_1 = document.getElementById("div_1");
	var oDivNode_3 = document.getElementById("div_3");
	var oCopyDiv_3 = oDivNode_3.cloneNode(true);//true包括子孙都克隆,default只克隆本节点
	
	//用克隆的去替换
	oDivNode_1.parentNode.replaceChild(oCopyDiv_3,oDivNode_1);
}