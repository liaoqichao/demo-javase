/**
 * 
 */
function getSum(){
//	获取所有名称为item的复选框
//	判断checked状态,true表示被选择,获取该节点的value值进行累加
	var sum = 0;
	var collItems = document.getElementsByName("item");
	for(var x=0; x<collItems.length; x++){
		if(collItems[x].checked){
			
			sum += parseInt(collItems[x].value);
		}
	}
	var sSum = sum+"元"
	
	document.getElementById("sumid").innerHTML = sSum;
}
function checkAll(node){
	var collItems = document.getElementsByName("item");
	//当前全选的状态赋值给所有item的checked
		for(var x=0;x<collItems.length;x++){
			collItems[x].checked = node.checked;
		}

}