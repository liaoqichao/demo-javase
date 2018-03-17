/**
 * 
 */
function selectProvince(){
	var collCities = [["选择城市"],
	                  ["海淀区","朝阳区","东城区","西城区"],
	                  ["济南","青岛","烟台","威海"],
	                  ["广州","深圳","东莞"],
	                  ["沈阳","大连","鞍山","抚顺"]];
//	var arr ={"beijing":["海淀区","朝阳区","东城区","西城区"]};
	//键值对形式也可以,beijing为option的value值,建议用这种方式
	
	//获取2个下拉菜单对象
	var oSelectNode = document.getElementById("provinceid");
	var oSubSelectNode = document.getElementById("cityid");
	
	//获取被选择的省份
	var index = oSelectNode.selectedIndex;
	
	//通过角标,到容器中获取对应的城市数组
	var arrCities = collCities[index];
	
	//在添加之前将之前的子下拉菜单的内容清空
	//方式1：
//	for(var x=0; x<oSubSelectNode.length; ){
//		oSubSelectNode.removeChild(oSubSelectNode.options[x]);
//	}
	//方式2：
	oSubSelectNode.length = 0;
	
	//遍历这个数组。并将这个数组的元素封装成option对象添加到子下拉菜单中
	for(var i=0; i<arrCities.length; i++){
		
		var oOptionNode = document.createElement("option");
		oOptionNode.innerHTML = arrCities[i];
		
		oSubSelectNode.appendChild(oOptionNode);
	}
}