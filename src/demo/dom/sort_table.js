/**
 * 
 */
var flag = true;
function sortTable(){
//	排序思路：
//	1.排序就需要数组。获取需要参与需要排序的对象数组。
//	2.对行数组中的每一行的年龄单元格的数据进行比较，并完成行对象在数组中的对象置换
//	3.将排好序的数组,重新添加回表格
	
//	1.1,获取表格对象
	var oTableNode = document.getElementById("info");
	
//	1.2,获取数组
	var collTrNodes = oTableNode.rows;
	
//	1.3,定义一个临时容器存储需要排序的行对象
	var trArr = [];
	
	for(var i=1 ; i<collTrNodes.length ;i++){
		trArr[i-1] = collTrNodes[i];
		//赋值地址,所以后面appendChild的时候,只是原来的地址排序,改变的是之前的行。前面的行移动到末尾,空了位置顶上去。
	}
//	2,对临时容器排序
	mySort(trArr);
	
//	3,排好序的行对象添加回表格
	if(flag){
		for(var x=0;x<trArr.length;x++){
	//		oTableNode.childNode[0].appendChild(trArr[x]);
			trArr[x].parentNode.appendChild(trArr[x]);
		}
		flag = !flag;
	}
	else{
		for(var x=trArr.length-1;x>=0;x--)
			trArr[x].parentNode.appendChild(trArr[x]);
		flag = !flag;
	}
	
}

function mySort(arr){
	for(var x=0;x<arr.length-1;x++){
		for(var y=x+1;y<arr.length;y++){
			if(parseInt(arr[x].cells[1].innerHTML)>parseInt(arr[y].cells[1].innerHTML)){
				//如果没有parseInt的话,拿到的是字符串文本。字符串6比字符串16大（因为字符串6大于字符串1）
				var temp = arr[x];
				arr[x] = arr[y];
				arr[y] = temp;
			}
		}
	}
}