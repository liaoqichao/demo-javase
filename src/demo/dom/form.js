/**
 * 
 */

/*
function checkUser(){
	var flag;
	
	var oUserNode = document.getElementsByName("user")[0];
	
	var name = oUserNode.value;
	
	//定义正则表达式
	var reg = new RegExp("^[a-z]{4}$","i");//必须是4个字母
	
	var oSpanNode = document.getElementById("userspan");
	
//	if(name == "abc"){
	if(reg.test(name)){
		oSpanNode.innerHTML = "用户名正确".fontcolor("green");//"<img src='ok.jpg' /> 勾的图片"
		flag = true;
	}else{
		oSpanNode.innerHTML = "用户名错误".fontcolor("red");
		flag = false;
	}
	return flag;
}
*/

//正则表达式：
//方式1.
//var regex = new RegExp("表达式/模式","g,i,m组合使用");//RegExp是一个对象
//g:查找全文中的模式/正则表达式
//i:忽略大小写
//m:多行查找
//var regex = new RegExp("a","gi");//匹配所有的a或A
//方式2.
//var re = /表达式/[g,i,m的组合];
//var re = /a/gi;

//进行匹配：
//regex.test("需要匹配的内容");//返回真或假
//regex.match("需要匹配的内容");//把查找结果作为数组返回,返回第一次出现匹配内容的地方

//^[a-z]{4}:以4个字母开头
//$abc:以abc结尾

//方式1和方式2的区别：
//new RegExp("\\d");参数是字符串需要转义
///\d/;不需要转移

//发现很多框的校验,除了内容不同,校验的过程是一样的。所以进行代码的提取
function check(name,regex,spanid,corrinfo,errinfo){//属性名,正则,spanid，正确提示，错误提示都不确定
	
	var flag;
	
	var value = document.getElementsByName(name)[0].value;//拿到name为参数name的值

	var oSpanNode = document.getElementById(spanid); //获取传过来的spanid
	
	//判断是否匹配并在各自span区域提示信息
	if(regex.test(value)){
		oSpanNode.innerHTML = corrinfo.fontcolor("green");
		flag = true;
	}else{
		oSpanNode.innerHTML = errinfo.fontcolor("red");
	}
	return flag;
}

//校验用户名
function checkUser(){
	//匹配要^模式$的形式,这样限定了头和尾，11abcd和abcd11字符串就不会被匹配
	var regex = /^[a-z]{4}$/i;	//i表示不区分大小写
	return check("user",regex,"userspan","用户名格式正确","用户名格式错误,应由4个字母组成,不区分大小写");
}
//校验密码
function checkPsw(){
	var regex = /^\d{4}$/;
	return check("psw",regex,"pswspan","密码格式正确","密码格式错误,应由4个数字组成");
}
//校验确认密码
function checkRepsw(){
	var flag;
	//获取密码框内容
	var psw = document.getElementsByName("psw")[0].value;
	
	//获取确认密码框内容
	var repsw = document.getElementsByName("repsw")[0].value;
	
	if(repsw == psw){
		document.getElementById("repswspan").innerHTML = "两次密码一致".fontcolor("green");
		flag = true;
	}else{
		document.getElementById("repswspan").innerHTML = "两次密码不一致".fontcolor("red");
		flag = false;
	}
	return flag;
}
//校验邮件
function checkMail(){
	var regex = /^\w+@\w+(\.\w+)+$/i;
	return check("mail",regex,"mailspan","邮箱地址正确","邮箱地址错误"); 
}

//提交事件处理
function checkForm(){
	//这里的if语句再校验了一次。防止前面都是输入正确,然后随便改了一些到错误然后立刻点提交
	if(checkUser() && checkPsw() && checkRepsw() && checkMail())
		return true;
	return false;
}

function mySubmit(){
	var oFormNode = document.getElementById("userinfo");
	
//	表单具备提交表单信息的方法
	oFormNode.submit();
}