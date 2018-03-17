/**
 * 
 */
//行间隔显示功能
var name;
function trColor(){
	//1.获取表格对象
	oTableNode = document.getElementById("mailtable");
	
	//2.获取所有行对象
	collTrNodes = oTableNode.rows;

	//3.
	for(var i=1; i<collTrNodes.length-1; i++){
		if(i%2==0){
			collTrNodes[i].className = "one";
		}
		else{
			collTrNodes[i].className = "two";
		}
		//实现高亮功能,添加鼠标悬停事件和鼠标离开事件
		collTrNodes[i].onmouseover = function(){
			name = this.className;
			this.className = "over";
		}
		collTrNodes[i].onmouseout = function(){
			this.className = name;
		}

	}
}
onload = function(){
	trColor();
}

function selectAll(node){
	
	//1.获取所有name为mail的元素
	var collMailNodes = document.getElementsByName("mail");
	
	//2.把本节点的checked状态赋值到全部name="mail"的复选框的状态
	for(var i=0; i<collMailNodes.length; i++){
		collMailNodes[i].checked = node.checked;
	}
	
}

function selectAllByBut(num){
	//if num>1 反选  else .checked=num; 因为在else情况下num=1或者num=0，而1为真,0为假
	var collMailNodes = document.getElementsByName("mail");
	if(num>1){
		for(var i=0; i<collMailNodes.length; i++){
			collMailNodes[i].checked = !collMailNodes[i].checked;
		}
	}
	else{
		for(var i=0; i<collMailNodes.length; i++){
			collMailNodes[i].checked = num;
		}
	}
//	switch(num){
//	case 0:
//		for(var i=0; i<collMailNodes.length;i++){
//			collMailNodes[i].checked = true;
//		}
//		break;
//	case 1:
//		for(var i=0; i<collMailNodes.length;i++){
//			collMailNodes[i].checked = false;
//		}
//		break;
//	case 2:
//		for(var i=0; i<collMailNodes.length;i++){
//			collMailNodes[i].checked = !collMailNodes[i].checked;
//		}
//		break;
//	default:
//		alert("switch参数错误");
//	}
}


function delMail(){
	if(confirm("确认删除所选邮件?")){
		var collMailNodes = document.getElementsByName("mail");
	//	alert("a");
		for(var i=0; i<collMailNodes.length; i++){
			if(collMailNodes[i].checked){
				var oTrNode = collMailNodes[i].parentNode.parentNode;
				oTrNode.parentNode.removeChild(oTrNode);
				//只要remove就会改变长度,而i又在递增。就会出现隔行删除
				i--;
			}
			//方法2,不i--,也不删除先,先用集合记录要删除的行的地址，再遍历容器然后删除
		}
		trColor();//删完后颜色可能没有间隔变色,所以要再调用这个函数
	}
}