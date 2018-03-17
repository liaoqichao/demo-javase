/**
 * 
 */

var flag = true;
function list2(){
	
//	思路,将overflow：hidden变成visible
//	1.获取dl节点
//	2.改变dl节点中的style中的overflow属性的值
//	alert("list run");
	var oDlNode = document.getElementsByTagName("dl")[0];
	if(flag){	
		oDlNode.style.overflow = "visible";
		flag = false;
	}
	else{
		oDlNode.style.overflow = "hidden";
		flag = true;
	}
//	这样不合理
//IE浏览器显示不出来,用360浏览器
}


//降低js和css和耦合性
function list3(){
	
	//1
	var oDlNode = document.getElementsByTagName("dl")[0];
	
	//2,设置dl的className的属性值
//	oDlNode.className = "open";
	if(oDlNode.className == "open"){
		oDlNode.className = "close";
	}
	else{
		oDlNode.className = "open";
	}
}

function list4(oDtNode){
	//传进来的节点是dt对象
	var oDlNode = oDtNode.parentNode;
	if(oDlNode.className == "open"){
		oDlNode.className = "close";
	}
	else{
		oDlNode.className = "open";
	}
}

/*
 * 需求：在多个列表下,只展开一个列表，其他列表都关闭
 * 1.获取当前dl节点
 * 2.获取所有dl节点。
 * 3.遍历这些节点,只对当前的节点进行展开或者闭合,其他节点都闭合
 */
function list(oDtNode){
	//1.获取当前的dl节点
	var oDlNode = oDtNode.parentNode;
	
	//2.获取所有dl节点
	var collDlNodes = document.getElementsByTagName("dl");
	
	//3.遍历这些节点，只对当前的节点进行展开或者闭合,其他节点都闭合
	for(var i=0 ; i<collDlNodes.length ; i++){
		if(collDlNodes[i] == oDlNode){
			if(oDlNode.className == "open")
				oDlNode.className = "close";
			else
				oDlNode.className = "open";
		}
		else
			collDlNodes[i].className = "close";
	}
}