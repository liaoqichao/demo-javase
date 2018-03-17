/**
 * 
 */
/**
 * 去除字符串两端的空格
 */
String.prototype.trim = function(){	//this代表本string对象,不用传参数	为了以后都能用这个方法.放到js文件中,需要则调用
			var head=0;
			var tail=str.length-1;
			while(head<=tail && this.charAt(head)==" "){	//这里没有.equals方法.都是用==
				head++;
			}
			while(head<=tail && this.charAt(tail)==" "){
				tail--;
			}
			return this.substring(head,tail+1);
		}
/**
 * 字符串变字符数组
 */
String.prototype.toCharArray = function(){
	var length = this.length;
	var charArray = [];
	for(var i=0;i<length;i++){
		charArray[i] = this.charAt(i);
	}
	return charArray;
}
/**
 * 字符串反转
 */
String.prototype.reverse = function(){
	//javaScript中函数里面可以定义函数.
	//function swap(arr,x,y){ t=arr[x];arr[x]=arr[y];arr[y]=t; return arr;}
	//swap是一个单独的封装体类似java中的内部类,然后这个函数可以使用swap方法
	var charArray = this.toCharArray();
	var start,end,temp;
	for(start=0,end=this.length-1;	start<end	; start++,end--){
		temp = charArray[end];
		charArray[end] = charArray[start];
		charArray[start] = temp;
	}
	return charArray.join("");//Array对象的方法。arrayObj.join(separator) 无参数是逗号隔开
}
