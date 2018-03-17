/**
 * 
 */
function list1(node){
	//操作的是ul节点,参数是a节点.通过a的父亲的儿子来获取ul节点。尽量不要用兄弟节点
	
	//1,获取被操作的节点ul
	var oUlNode = node.parentNode.getElementsByTagName("ul")[0];
//	alert(oUlNode.nodeName);
	if(oUlNode.className == "open")
		oUlNode.className = "close";
	else
		oUlNode.className = "open";
}

//要求开1个关其他

function list(node){
	
	//1.获取当前的ul
	var oTabNode = document.getElementById("goodlist");
	var oUlNode = node.parentNode.getElementsByTagName("ul")[0];
	//2.获取1个表格中的所有ul
	
	var collUlNodes = oTabNode.getElementsByTagName("ul");
	for(var i=0 ; i<collUlNodes.length ; i++){
		if(collUlNodes[i] == oUlNode){
			if(oUlNode.className=="open")
				oUlNode.className = "close";
			else
				oUlNode.className = "open";
		}
		else{
			collUlNodes[i].className = "close";
		}
	}
}