package demo.xml;

import java.io.FileOutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Attribute;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import demo.DemoInterface;
import demo.xml.student.service.StuManageSys;
import demo.xml.student.vo.Student;

public class XMLDemo implements DemoInterface {

	/**
	 * 重点：dom4j
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//jasp的增和删都让XML文件的排版很乱
//		DOM的增删改查和元素的遍历
//		demo6_jasp_findNode();
//		demo7_jasp_addNode();
//		demo8_jasp_modifyNode();
//		demo9_jasp_delNode();
//		demo10_jasp_traversal();
		
//		SAX的查
//		demo12_jasp_SAX();
//		demo13_jasp_SAX_search();
		
//		使用DOM4J
//		demo14_dom4j_search();
//		demo15_dom4j_add();
//		demo16_dom4j_add2();
//		demo17_dom4j_modify();
//		demo18_dom4j_del();
//		demo19_dom4j_Attribute();
//		demo20_dom4j_XPath();
		
		//使用XML储存学生信息。实现简单的学生管理系统
		demo21_StuManageSys();
	}
	public void demo6_jasp_findNode() throws  Exception{
//		查询demo6_jasp_finNode.xml中所有name元素的值
		//1.创建解析器工厂
		//2.根据解析器工厂创建解析器
		//3.解析xml返回document
		
		//1.
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		//2.
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		//3.导入W3C的包
		Document document = builder.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		
		//4.根据document对象获取所有name节点
		NodeList nodeList = document.getElementsByTagName("name");
		
		//获取第一个name节点
//		Node node = document.getElementsByTagName("name").item(0);
//		System.out.println(node.getTextContent());
		
		
		//5.遍历数节点列表
		for(int i=0; i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
			//文本内容是name节点的一个子节点，他的值是文本的内容
//			System.out.println(node.getFirstChild().getNodeValue());
		}
		
	}
	public void demo7_jasp_addNode() throws Exception{
		/*
		 * 在第一个p1后加<sex>女</sex>
		 */
		//1.获取工厂对象
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		//2.获取DocumentBuilder对象
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		//3.获取Document对象
		Document document = documentBuilder.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		//4.找到第一个p1节点
		Node p1 = document.getElementsByTagName("p1").item(0);
		
		//5.创建sex节点,并设置它的文本内容。也可以createTextNode,sex.append(text)
//		Node sex = document.createElement("sex");
		Element sex = document.createElement("sex");//Element extends Node
		//Element有设置属性,获得属性节点。获得标签名的方法。这些都是Node没有的
		
//		方法1：
		sex.setTextContent("女");
		
//		方法2：
//		Text text = document.createTextNode("女");
//		sex.appendChild(text);
		
		//6.在p1节点内的末尾添加sex节点
		p1.appendChild(sex);
		
		//7.回写到XML中,因为现在操作的是内存的document
		//通过TransformerFactory抽象类的newInstance获得自己的实例，在通过实例的方法获得javax.xml.treansform.Transformer抽象类实例
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/demo/xml/demo6_jasp_findNode.xml"));
		
//		transformer.transform(Source接口, Result接口);
//		DOMSource实现Source接口,StreamResult实现Result接口。具体参数看API。
	}
	public void demo8_jasp_modifyNode() throws Exception{
//		把第一个p1中的sex中的文本改为男
		
		//1.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2.
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//3.
		Document document = db.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		//4.获取要被修改的节点
		Node sex = document.getElementsByTagName("sex").item(0);
		
		//5.
		sex.setTextContent("男");
		
		//6.回写到XML中
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/demo/xml/demo6_jasp_findNode.xml"));
	}
	public void demo9_jasp_delNode() throws Exception{
		/*
		 * 删除第一个p1的所有sex节点
		 */
		//1.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2.
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//3.
		Document document = db.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		//4.获取sex节点
		NodeList nodeList = document.getElementsByTagName("sex");
		for(int i=0; i<nodeList.getLength(); /*不要i++,因为一边删除,计数器一边再递增*/){
			//5.通过要删除节点的父节点来删除本节点
			Node sex = nodeList.item(i);
			sex.getParentNode().removeChild(sex);
		}
		
		//6.回写到XML中
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/demo/xml/demo6_jasp_findNode.xml"));
	}
	public void demo10_jasp_traversal() throws Exception{
		/*
		 * 遍历叶子节点。获取其文本内容
		 * 遍历。需要递归,都是找到子节点
		 */
		
		//1.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2.
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//3.
		Document document = db.parse("src/demo/xml/demo6_jasp_findNode.xml");
		//4.获取根节点
		//5.获取根节点的子节点
		//6.获取根节点的子节点的子节点. 根据5，6步所以需要递归
		
		list(document);
		
	}
	private void list(Node node) {
		// TODO Auto-generated method stub
		NodeList nodelist = node.getChildNodes();
		if(node.getNodeType() == Node.ELEMENT_NODE){//#text和XML注释不属于Node.ELEMENT_NODE
			System.out.println(node.getNodeName());
		}
		for(int i=0; i<nodelist.getLength(); i++){
			list(nodelist.item(i));
		}
	}
	
	public void demo12_jasp_SAX() throws Exception{
		/*
		 * 需求1：打印出标签的开始,文本内容,结束 
		 * 需求2：把XML文件打印出来
		 */
		/*
		 * 1.创建SAX解析器工厂实例
		 * 2.创建SAX解析器
		 * 3.执行parse方法
		 * 4.自己创建一个类来继承DefaultHandler
		 * 5.重写类的startElement,endElement,characters三个方法
		 */
		//1.
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		//2.
		SAXParser saxParser = saxParserFactory.newSAXParser();
		//3.
		saxParser.parse("src/demo/xml/demo6_jasp_findNode.xml", new MyDefaultHandler());
		//事件处理器需要创建一个新类继承DefaultHandler,然后重写3个方法。
	}
	
	public void demo13_jasp_SAX_search() throws Exception{
		
		/*
		 * 获取所有name的值
		 * 获取第i个name的值
		 */
		//1.
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		//2.
		SAXParser saxParser = saxParserFactory.newSAXParser();
		//3.
		saxParser.parse("src/demo/xml/demo6_jasp_findNode.xml", new MyDefaultHandler2());
	}
	
	public void demo14_dom4j_search() throws Exception{
		/*
		 * 需求：
		 * 1.查询所有name元素的值
		 * 步骤:
		 * 1.创建解析器
		 * 2.得到document
		 * 3.得到根节点
		 * 4.得到所有的p1
		 * 		element(qName);		表示获取标签下面的第一个qName标签
		 * 		elements(qName);	表示获取标签下面所有qName标签(当前这层,孙子节点找不到)
		 * 		elements();			表示获取标签下面的所有子标签(不包括孙子)
		 * 5.得到所有的name
		 * 6.得到所有name的值
		 * 
		 * 需求：
		 * 2.查询第二个name元素的值
		 * 步骤：
		 * 1.创建解析器
		 * 2.得到document
		 * 3.得到根节点
		 * 4.得到第二个p1元素
		 * 5.得到第二个p1的name元素
		 * 6.得到这个name元素的值
		 */
		//1.
		SAXReader saxReader = new SAXReader();
		//2.不能同时导入2个最后都是Document的包,所以这个写全名
		org.dom4j.Document document = saxReader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		
		//4.得到所有的p1,返回的是List集合
		List<org.dom4j.Element> list = root.elements("p1");
		org.dom4j.Element second = list.get(1);	//得到第二个p1
		
		//5.得到第二个p1的name元素
		org.dom4j.Element name2 = second.element("name");
		//6.
		System.out.println(name2.getText());
		
		//5.遍历list的方法：1.普通for,2.增强for(foreach),3.迭代器,4.listIterator()
//		for (org.dom4j.Element element : list) {
//			org.dom4j.Element name1 = element.element("name");//得到name元素,因为只有1个name,所有调用的是没有s的element方法
//			//6.
//			String s = name1.getText();
//			System.out.println(s);
//		}
	}
	
	public void demo15_dom4j_add() throws Exception{	//在标签内末尾添加元素
		/*
		 * 需求：在第一个p1标签内最后添加<sex>女</sex>元素
		 * 步骤：
		 * 1.创建解析器
		 * 2.得到document
		 * 3.得到root节点
		 * 4.得到第一个p1
		 * 5.在p1下添加元素
		 * 6.在新元素添加文本
		 * 7.回写XML文件
		 * 	 	XMLWriter(OutputStream out,OutputFormat format)
		 * 		XMLWriter是输出流，需要write(document)写到XML文件和close()关闭流
		 * 		第一个参数为输出的文件。第二个参数为格式。(jasp增删改后XML文件格式会乱)
		 * 		OutputFormat有2个静态方法： createCompactFormat();创建压缩格式
		 * 							   createPrettyPrint();漂亮的输出。(有格式)
		 */
		//1.创建解析器
		SAXReader reader = new SAXReader();
		//2.得到document
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.得到根节点
		org.dom4j.Element root = document.getRootElement();
		//4.
		org.dom4j.Element fir_p1 = root.element("p1");
		//5.在p1下直接添加元素。直接用addElement方法,不需要Element sex = new Elment("sex"),然后p1.add(sex);
		org.dom4j.Element sex1 = fir_p1.addElement("sex");
		//6.
		sex1.setText("女");
		//7.回写到XML
		XMLWriter xmlWriter = new XMLWriter(
				new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	public void demo16_dom4j_add2() throws Exception{	//在特定位置添加元素
		/*
		 * 在第一个p1下的age(第二个位置)标签前添加<school>ecit.edu.cn东华理工大学</school>
		 * 通过List的add(index,element)实现在特定位置添加元素
		 * 步骤：
		 * 1.
		 * 2.
		 * 3.
		 * 4.获取第一个p1
		 * 5.获取p1下所有元素
		 * 	5.1 获取age标签在list中的位置
		 * 6.创新school元素
		 * 7.在特点位置添加元素
		 * 8.回写XML
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.
		org.dom4j.Element fir_p1 = root.element("p1");
		//5.
		List<org.dom4j.Element> list = fir_p1.elements();
		//5.1 获得age标签的位置(list中的下标)
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			org.dom4j.Element element = list.get(i);
			if(element.getQName().getName().equals("age")){
				//getQName返回的是Elment
				index = i;
				break;
			}
		}
		//6.创建school元素使用DocumentHelper类
		org.dom4j.Element school = DocumentHelper.createElement("school");
		school.setText("ecit.edu.cn东华理工大学");
		//7.
		list.add(index,school);//为什么修改list的位置会影响到fir_p1里面子标签的位置?
		//8.回写到XML
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"), OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
	
	public void demo17_dom4j_modify() throws Exception{
		/*
		 * 修改第二个p1的age,30变成40
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.获取第二个p1元素
		List<org.dom4j.Element> list = root.elements("p1");
		org.dom4j.Element sec_p1 = list.get(1);
		//5.得到第二个p1元素的age元素,并修改文本为40
		sec_p1.element("age").setText("40");
		//6.回写XML
		XMLWriter writer = new XMLWriter(
				new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
	
	public void demo18_dom4j_del() throws Exception{
		/*
		 * 删除第二个p1标签,以及里面的内容
		 * 直接sec_p1.getParent().remove(sec_p1)就可以删除第二个p1标签,包括p1里面的子标签
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.得到第二个p1标签
		List<org.dom4j.Element> list = root.elements("p1");
		org.dom4j.Element sec_p1 = list.get(1);
		//5.删除第二个p1标签
		sec_p1.getParent().remove(sec_p1);
		//不需要知道sec_p1的父节点是谁。remove(子节点)。如果是p1.remove(p1)删不了
		//6.回写XML
		XMLWriter writer = new XMLWriter(
				new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
		
	}
	
	public void demo19_dom4j_Attribute() throws Exception{
		/*
		 * 属性的增删改查：
		 * 获取第一个p1的id1属性值
		 * 修改第一个p1的id1的属性值
		 * 增加第一个p1的属性id2,赋值为2222。为什么只有String类型？
		 * 删除第一个p1的id2属性
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.得到第一个p1
		org.dom4j.Element fir_p1 = root.element("p1");
		//5.得到id1的值
		String str = fir_p1.attributeValue("id1");
		
		//6.修改id1的属性值
		Attribute attribute = fir_p1.attribute("id1");
		attribute.setValue("aaaa");
		System.out.println(str);
		
		
		//7.增加id2属性,值为2222
		fir_p1.addAttribute("id2", "2222");
		
		//8.删除id2属性
		fir_p1.remove(fir_p1.attribute("id2"));
		
		//9.回写XML
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
	
	public void demo20_dom4j_XPath() throws Exception{
		/*
		 * 使用XPath查询XML中所有name元素的值
		 * 1.获得document
		 * 2.使用selectNodes("//name")得到所有name元素
		 */
		//1.1
		SAXReader reader = new SAXReader();
		//1.2
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//2.
		List<org.dom4j.Node> nodes =  document.selectNodes("//name");
		//3.遍历列表
		for(org.dom4j.Node node : nodes){
			String s = node.getText();//得到name元素里面的值
			System.out.println(s);
		}
		
		/*
		 * 获取第二个第一个p1下name的值(根据id1属性)
		 * //p1[@id1="aaaa"]/name
		 */
		org.dom4j.Node name = document.selectSingleNode("//p1[@id1='aaaa']/name");//这里用单引号或者\"转义的双引号都可以
		System.out.println("第一个p1(id1=\"aaaa\")下name的值: "+name.getText());
	}
	
	public void demo21_StuManageSys(){
		/*
		 * 学生管理系统：增删改查存储学生信息的XML文档
		 * 思路：
		 * 1.编写XML文档,用于存储数据
		 * 2.创建StuManageSys类。通过类的方法对XML进行增删改查
		 * 3.创建Student类用于存储对象值(对象指Student,值指标签的文本内容)。这样简化StuManageSys方法的参数。不然一个学生有
		 * 	 20条子元素且都要求非空 ,addStu()就要有20个参数。
		 * 总结：要操作的是节点则用StuManageSys,涉及到里面标签的值,则使用Student。1个管标签,1个管值。
		 */
		StuManageSys sys = new StuManageSys();
		//增
//		Student stu = new Student();
//		stu.setId("233");
//		stu.setName("接二连珊");
//		stu.setAge("28");
//		sys.addStu(stu);
		//删。删一群的话,遍历所有id,只要id值是"233"就删除.就是把remove()放到循环的判断语句里面
//		sys.delStuById("233");
		//改。批量修改也是讲setText放到循环的判断语句里面
//		sys.modifyAge("233", "3000");
		//查1,返回一个学生对象
//		Student stu = sys.searchById("105");
//		if(stu != null){
//			System.out.println("id:"+stu.getId());
//			System.out.println("name:"+stu.getName());
//			System.out.println("age:"+stu.getAge());
//		}
		//查2,返回一个学生列表
		List<Student> list = sys.searchByName("赵六");
		if(list.size()==0){
			System.out.println("没有找到");
			return;
		}
		for (Student student : list) {
//			System.out.println(student.getId()+":"+student.getName()+":"+student.getAge());
//			Student覆盖toString()方法
			System.out.println(student);
		}
		
	}
}
class MyDefaultHandler extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
//		System.out.println("start: "+qName);
		System.out.print("<"+qName+">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		System.out.println("end: "+qName);
		System.out.print("<"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
//		System.out.println("text: "+new String(ch ,start,length));
		System.out.print(new String(ch,start,length));
	}
	
}

class MyDefaultHandler2 extends DefaultHandler{

	boolean flag = false;//用来判断是标签头还是标签尾
	final int target = 2;
	int index = 0;	//获取第二个name元素
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if("name".equals(qName)){	//是name标签才开始
			flag = true;
			index++;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if(flag && index==target){
			System.out.println(new String(ch,start,length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if("name".equals(qName)){	//如果遇到标签为name的标签尾
			flag = false; 			
		}
	}
	
}

	



