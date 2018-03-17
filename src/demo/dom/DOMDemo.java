package demo.dom;

import demo.DemoInterface;

public class DOMDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub

//		DOM:文档对象模型    实现了页面的动态效果。  
//		浏览器中都有DOM解析引擎
//		用处：用来将标记型文档封装成对象，并将标记型文档中的所有的内容(标签,文本,属性等)都封装成对象。
//		封装成对象的目的：更方便的操作这些文档以及文档中的所有内容。因为对象的出现就可以有属性和行为被调用
//		文档对象模型
//		文档：标记型文档。
//		对象：封装属性和行为的实例,可以被直接调用。
//		模型：所有标记型文档都具备的共性特征的一个体现。
//		
//		标记型文档(标签，属性，标签封装的数据[文本])
//		只要是标记型文档,DOM都可以对其进行操作
//		常见的标记型文档：HTML，XML
//		
//		DOM解析：把标记型文档解析成一颗DOM树,树中的标签、文本及属性称为节点，并将树中的内容封装成节点对象
//		好处：可以对树中的节点进行任意操作，比如：增删改查。
//		弊端：这种解析需要将整个标记型文档加载进内存。意味着如果标记型文档体积大,较为浪费内存空间。
//		
//		另一种解析方式:SAX:不是W3C的标准,而DOM是W3C标准
//		SAX解析方式：基于事件驱动的解析。遇到标签开始则事件开始,遇到标签结束则事件结束。
//		好处：获取数据的速度快。
//		弊端：不能对标记进行增、删、改。只能查
//		
//		
//		DOM模型有三种：
//		DOM level 1：将HTML文档封装成对象。
//		DOM level 2：在level1基础上加入了新功能，比如解析名称空间(例如java的包,a包的demo,b包的demo)	
//				 	<html xmlns="my">	用xmlns划分名称空间,空间名尽量别重复(用域名,http://www.sina.com.cn)
//				 		<table></table>
//				 	</html>
//				 	<html xmlns="you">
//				 		<table></table>
//				 	</html>
//		DOM level 3:将XML文档封装成对象
//		
//		
//		DHTML:Dynamic HTML.(不是一门语言。是多项技术综合的简称)
//		其中包含了(HTML,CSS,DOM,JavaScript)
//		HTML:		负责提供标签,对数据进行封装。目的是便于该标签中的数据进行操作。
//						简单说:用标签封装数据。
//		CSS:		负责提供样式属性,对标签中的数据进行样式定义。
//						简单说:对数据进行样式定义。
//		DOM:		负责将标记型文档以及文档中的所有进行解析,并封装成对象。在对象中定义了更多的属性和行为,便于对对象操作。
//						简单说:将文档和标签以及其他内容变成对象。
//		JavaScript:	负责提供程序设计语言,对页面中的对象进行逻辑操作。
//						简单说:负责页面行为定义。就是页面的动态效果。
//						
//		DHTML + XMLhttpRequest(和服务器端进行通讯的对象) = AJAX
//		
//		BOM:Browser Object Model.这个模型方便与操作浏览器
//		浏览器对应的对象就是window对象。可以通过查找DHTML API知道
	}

}
