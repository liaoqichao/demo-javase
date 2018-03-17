/**
 * 
 */

/**
 *	求数组最大值 
 */
Array.prototype.getMax = function(){
	var max= 0;
	for(var i=1 ; i<this.length ; i++){
		if(this[i]>this[max]){
			max = i;
		}
	}
	return this[max];
}
/**
 *	求数组最小值 
 */
Array.prototype.getMin = function(){
	var min = this[0];
	for(var j=1 ; j<this.length ;j++){
		if(this[j]<min){
			min = this[j];
		}
	}
	return min;
}

/**
 * 数组字符串的表现形式
 */
Array.prototype.toString = function(){
	
	return this.join("");
}
