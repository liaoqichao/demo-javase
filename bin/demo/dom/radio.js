/**
 * 
 */
function showContent(node){
	var oDivNode = document.getElementById("contentid");
	
	with(oDivNode.style){
		if(node.value =="yes"){
			display = "block";
		}
		else{
			display = "none";
		}
	}
}

function showResult(){
	
	//1,判断单选框是否被选中
	//获取所有no1的radio,并遍历判断checked的状态
	var collNo1Nodes = document.getElementsByName("no1");
	var flag = false;
	var value;
	for(var i=0; i<collNo1Nodes.length; i++){
		if(collNo1Nodes[i].checked){
			flag = true;
			value = collNo1Nodes[i].value;
			document.getElementById("score").innerHTML = "你的得分:"+value;
			break;
		}
	}
	
	if(flag){//被选中
		document.getElementById("errorinfo").innerHTML ="";
		if(value>=1 && value<=3){
			document.getElementById("result_1").className = "open";
			document.getElementById("result_2").className = "close";
		}
		else{
			document.getElementById("result_1").className = "close";
			document.getElementById("result_2").className = "open";			
		}
	}
	else{//没有被选中
		document.getElementById("errorinfo").innerHTML = "没有任何答案被选中".fontcolor("red");
	}
	
}