/**
 * 
 */

function createTable2(){
	//最原始的方法,通过循环来5行6列。
	//思路：通过创建元素节点的形式来完成
	var oTableNode = document.createElement("table");
	var oTbodyNode = document.createElement("tbody");
	var oTrNode = document.createElement("tr");
	var oTdNode = document.createElement("td");
	oTdNode.innerHTML = "这是一个单元格";
	
//	让这些节点有关系，进行制定层次的节点添加
	oTrNode.appendChild(oTdNode);
	oTbodyNode.appendChild(oTrNode);
	oTableNode.appendChild(oTbodyNode);
	
	//添加到div区域
	document.getElementById("table").appendChild(oTableNode);
}

//既然操作的是表格,就用表格里面的属性和方法
//	表格是由行组成,表格节点中insertRow方法就完成创建行并添加的动作,添加到rows集合
function createTable(){
	//获取行数和列数
	//通常数字需要正则判断,判断输入是不是整数和整数的范围有没有符合规范。字符串12减数字1等于数字11
	var rowVal = document.getElementsByName("rownum")[0].value;
	var colVal = document.getElementsByName("colnum")[0].value;
	//新建表格元素
	var oTableNode = document.createElement("table");
	//给表格设置id,方便调用它
	oTableNode.setAttribute("id","tabid");
	
	for(var i=0;i<rowVal;i++){
		var oTrNode = oTableNode.insertRow(-1)//参数默认-1(把行添加到最后)，360浏览器不传-1则顺序倒过来
		for(var j=0;j<colVal;j++){
		//创建单元格行最清楚 insertCell,往cells集合添加单元格
		var oTdNode = oTrNode.insertCell(-1);
		oTdNode.innerHTML = "(" +i +"," +j  +")";
		}
	}
		
	//将表格节点天界到div区域
	document.getElementById("table").appendChild(oTableNode);
	
	//通过按钮的方法disabled(true),让按钮不再起作用。从而实现只能点一次的效果。其默认值是false。按钮的字变成灰色点不了
	document.getElementsByName("createButton")[0].disabled = true;
}

function delRow(){
	//获取表格对象,判断表格是否存在
	var oTableNode = document.getElementById("tabid");//没有则空
	if(oTableNode==null){//空位假
		alert("表格不存在");
		return;
	}
	//获取文本内容,文本的内容是value属性的值
	var delrow = document.getElementsByName("delrow")[0].value;
	//判断删除的行是否存在
	if(delrow>=1 && delrow<=oTableNode.rows.length)
		oTableNode.deleteRow(delrow-1);//下标从0开始
	else
		alert("要删除的行不存在");
}
function delCol(){
	//获取表格对象,判断表格是否存在
	var oTableNode = document.getElementById("tabid");
	if(oTableNode==null){
		alert("表格不存在");
		return;
	}
	
	//获取文本内容
	var delcol = document.getElementsByName("delcol")[0].value;
	
	//获取表格的行元素(tr)
	var oTrNodes = document.getElementsByTagName("tr");
//	这里可以用oTableNode.rows[i].length来遍历,这样就不需要oTrNodes变量
	
	//判断删除列的是否存在
	for(var j=0;j<oTrNodes.length;j++){
		if(delcol<1 || delcol>oTrNodes[j].cells.length){
			alert("要删除的列不存在");
			return;
		}
	}
	//删除列
	for(var i=0;i<oTrNodes.length;i++)
		oTrNodes[i].deleteCell(delcol-1);


}
function delCell(){
	//获取表格对象,判断表格是否存在
	var oTableNode = document.getElementById("tabid");
	if(oTableNode==null){
		alert("表格不存在");
		return;
	}
	
	//获取文本内容中的行和列,用逗号分开
	var delcell = document.getElementsByName("delcell")[0].value.split(",",2);
	var delrow = delcell[0];
	var delcol = delcell[1];
	
	//判断是否有该行
	if(delrow<1 || delrow>oTableNode.rows.length){
		alert("要删除的单元格不存在");
		return;
	}
	
	//获取指定行对象
	var oDelRow = document.getElementsByTagName("tr")[delrow-1];
	
	//判断是否有该列
	if(delcol<1 || delcol>oDelRow.cells.length){
		alert("要删除的单元格不存在");
		return;
	}
	
	//删除该行第delcol-1个单元格
	oDelRow.deleteCell(delcol-1);
}