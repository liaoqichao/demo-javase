/**
 * 
 */
function addFile(){
//	因为文件选取框定义在行对象中，所以只要给表格创建新的行和单元格即可
	
	var oTableNode = document.getElementById("fileid");
	
	//创建行
	var oTrNode = oTableNode.insertRow(-1);
//	alert("a");
	
	//创建单元格
	var oTdNode_file = oTrNode.insertCell(-1); 
	var oTdNode_del = oTrNode.insertCell(-1);
	
	oTdNode_file.innerHTML = "<input type='file'/>";
//	oTdNode_del.innerHTML = "<a href='javascript:void(0)' onclick='delFile(this)'>删除附件</a>"
	oTdNode_del.innerHTML = "<img src='img/delfile.bmp' alt='删除附件' onclick='delFile(this)'/>";
}

function delFile(node){
	
	//node.parentNode->td  node.parentNode.parentNode->tr
	var oTrNode = node.parentNode.parentNode;
	oTrNode.parentNode.removeChild(oTrNode);
}