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
	 * �ص㣺dom4j
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//jasp������ɾ����XML�ļ����Ű����
//		DOM����ɾ�Ĳ��Ԫ�صı���
//		demo6_jasp_findNode();
//		demo7_jasp_addNode();
//		demo8_jasp_modifyNode();
//		demo9_jasp_delNode();
//		demo10_jasp_traversal();
		
//		SAX�Ĳ�
//		demo12_jasp_SAX();
//		demo13_jasp_SAX_search();
		
//		ʹ��DOM4J
//		demo14_dom4j_search();
//		demo15_dom4j_add();
//		demo16_dom4j_add2();
//		demo17_dom4j_modify();
//		demo18_dom4j_del();
//		demo19_dom4j_Attribute();
//		demo20_dom4j_XPath();
		
		//ʹ��XML����ѧ����Ϣ��ʵ�ּ򵥵�ѧ������ϵͳ
		demo21_StuManageSys();
	}
	public void demo6_jasp_findNode() throws  Exception{
//		��ѯdemo6_jasp_finNode.xml������nameԪ�ص�ֵ
		//1.��������������
		//2.���ݽ�������������������
		//3.����xml����document
		
		//1.
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		//2.
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		//3.����W3C�İ�
		Document document = builder.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		
		//4.����document�����ȡ����name�ڵ�
		NodeList nodeList = document.getElementsByTagName("name");
		
		//��ȡ��һ��name�ڵ�
//		Node node = document.getElementsByTagName("name").item(0);
//		System.out.println(node.getTextContent());
		
		
		//5.�������ڵ��б�
		for(int i=0; i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
			//�ı�������name�ڵ��һ���ӽڵ㣬����ֵ���ı�������
//			System.out.println(node.getFirstChild().getNodeValue());
		}
		
	}
	public void demo7_jasp_addNode() throws Exception{
		/*
		 * �ڵ�һ��p1���<sex>Ů</sex>
		 */
		//1.��ȡ��������
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		//2.��ȡDocumentBuilder����
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		//3.��ȡDocument����
		Document document = documentBuilder.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		//4.�ҵ���һ��p1�ڵ�
		Node p1 = document.getElementsByTagName("p1").item(0);
		
		//5.����sex�ڵ�,�����������ı����ݡ�Ҳ����createTextNode,sex.append(text)
//		Node sex = document.createElement("sex");
		Element sex = document.createElement("sex");//Element extends Node
		//Element����������,������Խڵ㡣��ñ�ǩ���ķ�������Щ����Nodeû�е�
		
//		����1��
		sex.setTextContent("Ů");
		
//		����2��
//		Text text = document.createTextNode("Ů");
//		sex.appendChild(text);
		
		//6.��p1�ڵ��ڵ�ĩβ���sex�ڵ�
		p1.appendChild(sex);
		
		//7.��д��XML��,��Ϊ���ڲ��������ڴ��document
		//ͨ��TransformerFactory�������newInstance����Լ���ʵ������ͨ��ʵ���ķ������javax.xml.treansform.Transformer������ʵ��
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/demo/xml/demo6_jasp_findNode.xml"));
		
//		transformer.transform(Source�ӿ�, Result�ӿ�);
//		DOMSourceʵ��Source�ӿ�,StreamResultʵ��Result�ӿڡ����������API��
	}
	public void demo8_jasp_modifyNode() throws Exception{
//		�ѵ�һ��p1�е�sex�е��ı���Ϊ��
		
		//1.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2.
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//3.
		Document document = db.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		//4.��ȡҪ���޸ĵĽڵ�
		Node sex = document.getElementsByTagName("sex").item(0);
		
		//5.
		sex.setTextContent("��");
		
		//6.��д��XML��
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/demo/xml/demo6_jasp_findNode.xml"));
	}
	public void demo9_jasp_delNode() throws Exception{
		/*
		 * ɾ����һ��p1������sex�ڵ�
		 */
		//1.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2.
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//3.
		Document document = db.parse("src/demo/xml/demo6_jasp_findNode.xml");
		
		//4.��ȡsex�ڵ�
		NodeList nodeList = document.getElementsByTagName("sex");
		for(int i=0; i<nodeList.getLength(); /*��Ҫi++,��Ϊһ��ɾ��,������һ���ٵ���*/){
			//5.ͨ��Ҫɾ���ڵ�ĸ��ڵ���ɾ�����ڵ�
			Node sex = nodeList.item(i);
			sex.getParentNode().removeChild(sex);
		}
		
		//6.��д��XML��
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/demo/xml/demo6_jasp_findNode.xml"));
	}
	public void demo10_jasp_traversal() throws Exception{
		/*
		 * ����Ҷ�ӽڵ㡣��ȡ���ı�����
		 * ��������Ҫ�ݹ�,�����ҵ��ӽڵ�
		 */
		
		//1.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2.
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//3.
		Document document = db.parse("src/demo/xml/demo6_jasp_findNode.xml");
		//4.��ȡ���ڵ�
		//5.��ȡ���ڵ���ӽڵ�
		//6.��ȡ���ڵ���ӽڵ���ӽڵ�. ����5��6��������Ҫ�ݹ�
		
		list(document);
		
	}
	private void list(Node node) {
		// TODO Auto-generated method stub
		NodeList nodelist = node.getChildNodes();
		if(node.getNodeType() == Node.ELEMENT_NODE){//#text��XMLע�Ͳ�����Node.ELEMENT_NODE
			System.out.println(node.getNodeName());
		}
		for(int i=0; i<nodelist.getLength(); i++){
			list(nodelist.item(i));
		}
	}
	
	public void demo12_jasp_SAX() throws Exception{
		/*
		 * ����1����ӡ����ǩ�Ŀ�ʼ,�ı�����,���� 
		 * ����2����XML�ļ���ӡ����
		 */
		/*
		 * 1.����SAX����������ʵ��
		 * 2.����SAX������
		 * 3.ִ��parse����
		 * 4.�Լ�����һ�������̳�DefaultHandler
		 * 5.��д���startElement,endElement,characters��������
		 */
		//1.
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		//2.
		SAXParser saxParser = saxParserFactory.newSAXParser();
		//3.
		saxParser.parse("src/demo/xml/demo6_jasp_findNode.xml", new MyDefaultHandler());
		//�¼���������Ҫ����һ������̳�DefaultHandler,Ȼ����д3��������
	}
	
	public void demo13_jasp_SAX_search() throws Exception{
		
		/*
		 * ��ȡ����name��ֵ
		 * ��ȡ��i��name��ֵ
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
		 * ����
		 * 1.��ѯ����nameԪ�ص�ֵ
		 * ����:
		 * 1.����������
		 * 2.�õ�document
		 * 3.�õ����ڵ�
		 * 4.�õ����е�p1
		 * 		element(qName);		��ʾ��ȡ��ǩ����ĵ�һ��qName��ǩ
		 * 		elements(qName);	��ʾ��ȡ��ǩ��������qName��ǩ(��ǰ���,���ӽڵ��Ҳ���)
		 * 		elements();			��ʾ��ȡ��ǩ����������ӱ�ǩ(����������)
		 * 5.�õ����е�name
		 * 6.�õ�����name��ֵ
		 * 
		 * ����
		 * 2.��ѯ�ڶ���nameԪ�ص�ֵ
		 * ���裺
		 * 1.����������
		 * 2.�õ�document
		 * 3.�õ����ڵ�
		 * 4.�õ��ڶ���p1Ԫ��
		 * 5.�õ��ڶ���p1��nameԪ��
		 * 6.�õ����nameԪ�ص�ֵ
		 */
		//1.
		SAXReader saxReader = new SAXReader();
		//2.����ͬʱ����2�������Document�İ�,�������дȫ��
		org.dom4j.Document document = saxReader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		
		//4.�õ����е�p1,���ص���List����
		List<org.dom4j.Element> list = root.elements("p1");
		org.dom4j.Element second = list.get(1);	//�õ��ڶ���p1
		
		//5.�õ��ڶ���p1��nameԪ��
		org.dom4j.Element name2 = second.element("name");
		//6.
		System.out.println(name2.getText());
		
		//5.����list�ķ�����1.��ͨfor,2.��ǿfor(foreach),3.������,4.listIterator()
//		for (org.dom4j.Element element : list) {
//			org.dom4j.Element name1 = element.element("name");//�õ�nameԪ��,��Ϊֻ��1��name,���е��õ���û��s��element����
//			//6.
//			String s = name1.getText();
//			System.out.println(s);
//		}
	}
	
	public void demo15_dom4j_add() throws Exception{	//�ڱ�ǩ��ĩβ���Ԫ��
		/*
		 * �����ڵ�һ��p1��ǩ��������<sex>Ů</sex>Ԫ��
		 * ���裺
		 * 1.����������
		 * 2.�õ�document
		 * 3.�õ�root�ڵ�
		 * 4.�õ���һ��p1
		 * 5.��p1�����Ԫ��
		 * 6.����Ԫ������ı�
		 * 7.��дXML�ļ�
		 * 	 	XMLWriter(OutputStream out,OutputFormat format)
		 * 		XMLWriter�����������Ҫwrite(document)д��XML�ļ���close()�ر���
		 * 		��һ������Ϊ������ļ����ڶ�������Ϊ��ʽ��(jasp��ɾ�ĺ�XML�ļ���ʽ����)
		 * 		OutputFormat��2����̬������ createCompactFormat();����ѹ����ʽ
		 * 							   createPrettyPrint();Ư���������(�и�ʽ)
		 */
		//1.����������
		SAXReader reader = new SAXReader();
		//2.�õ�document
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.�õ����ڵ�
		org.dom4j.Element root = document.getRootElement();
		//4.
		org.dom4j.Element fir_p1 = root.element("p1");
		//5.��p1��ֱ�����Ԫ�ء�ֱ����addElement����,����ҪElement sex = new Elment("sex"),Ȼ��p1.add(sex);
		org.dom4j.Element sex1 = fir_p1.addElement("sex");
		//6.
		sex1.setText("Ů");
		//7.��д��XML
		XMLWriter xmlWriter = new XMLWriter(
				new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	public void demo16_dom4j_add2() throws Exception{	//���ض�λ�����Ԫ��
		/*
		 * �ڵ�һ��p1�µ�age(�ڶ���λ��)��ǩǰ���<school>ecit.edu.cn��������ѧ</school>
		 * ͨ��List��add(index,element)ʵ�����ض�λ�����Ԫ��
		 * ���裺
		 * 1.
		 * 2.
		 * 3.
		 * 4.��ȡ��һ��p1
		 * 5.��ȡp1������Ԫ��
		 * 	5.1 ��ȡage��ǩ��list�е�λ��
		 * 6.����schoolԪ��
		 * 7.���ص�λ�����Ԫ��
		 * 8.��дXML
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
		//5.1 ���age��ǩ��λ��(list�е��±�)
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			org.dom4j.Element element = list.get(i);
			if(element.getQName().getName().equals("age")){
				//getQName���ص���Elment
				index = i;
				break;
			}
		}
		//6.����schoolԪ��ʹ��DocumentHelper��
		org.dom4j.Element school = DocumentHelper.createElement("school");
		school.setText("ecit.edu.cn��������ѧ");
		//7.
		list.add(index,school);//Ϊʲô�޸�list��λ�û�Ӱ�쵽fir_p1�����ӱ�ǩ��λ��?
		//8.��д��XML
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"), OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
	
	public void demo17_dom4j_modify() throws Exception{
		/*
		 * �޸ĵڶ���p1��age,30���40
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.��ȡ�ڶ���p1Ԫ��
		List<org.dom4j.Element> list = root.elements("p1");
		org.dom4j.Element sec_p1 = list.get(1);
		//5.�õ��ڶ���p1Ԫ�ص�ageԪ��,���޸��ı�Ϊ40
		sec_p1.element("age").setText("40");
		//6.��дXML
		XMLWriter writer = new XMLWriter(
				new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
	
	public void demo18_dom4j_del() throws Exception{
		/*
		 * ɾ���ڶ���p1��ǩ,�Լ����������
		 * ֱ��sec_p1.getParent().remove(sec_p1)�Ϳ���ɾ���ڶ���p1��ǩ,����p1������ӱ�ǩ
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.�õ��ڶ���p1��ǩ
		List<org.dom4j.Element> list = root.elements("p1");
		org.dom4j.Element sec_p1 = list.get(1);
		//5.ɾ���ڶ���p1��ǩ
		sec_p1.getParent().remove(sec_p1);
		//����Ҫ֪��sec_p1�ĸ��ڵ���˭��remove(�ӽڵ�)�������p1.remove(p1)ɾ����
		//6.��дXML
		XMLWriter writer = new XMLWriter(
				new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
		
	}
	
	public void demo19_dom4j_Attribute() throws Exception{
		/*
		 * ���Ե���ɾ�Ĳ飺
		 * ��ȡ��һ��p1��id1����ֵ
		 * �޸ĵ�һ��p1��id1������ֵ
		 * ���ӵ�һ��p1������id2,��ֵΪ2222��Ϊʲôֻ��String���ͣ�
		 * ɾ����һ��p1��id2����
		 */
		//1.
		SAXReader reader = new SAXReader();
		//2.
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//3.
		org.dom4j.Element root = document.getRootElement();
		//4.�õ���һ��p1
		org.dom4j.Element fir_p1 = root.element("p1");
		//5.�õ�id1��ֵ
		String str = fir_p1.attributeValue("id1");
		
		//6.�޸�id1������ֵ
		Attribute attribute = fir_p1.attribute("id1");
		attribute.setValue("aaaa");
		System.out.println(str);
		
		
		//7.����id2����,ֵΪ2222
		fir_p1.addAttribute("id2", "2222");
		
		//8.ɾ��id2����
		fir_p1.remove(fir_p1.attribute("id2"));
		
		//9.��дXML
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/demo/xml/demo6_jasp_findNode.xml"),
				OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
	
	public void demo20_dom4j_XPath() throws Exception{
		/*
		 * ʹ��XPath��ѯXML������nameԪ�ص�ֵ
		 * 1.���document
		 * 2.ʹ��selectNodes("//name")�õ�����nameԪ��
		 */
		//1.1
		SAXReader reader = new SAXReader();
		//1.2
		org.dom4j.Document document = reader.read("src/demo/xml/demo6_jasp_findNode.xml");
		//2.
		List<org.dom4j.Node> nodes =  document.selectNodes("//name");
		//3.�����б�
		for(org.dom4j.Node node : nodes){
			String s = node.getText();//�õ�nameԪ�������ֵ
			System.out.println(s);
		}
		
		/*
		 * ��ȡ�ڶ�����һ��p1��name��ֵ(����id1����)
		 * //p1[@id1="aaaa"]/name
		 */
		org.dom4j.Node name = document.selectSingleNode("//p1[@id1='aaaa']/name");//�����õ����Ż���\"ת���˫���Ŷ�����
		System.out.println("��һ��p1(id1=\"aaaa\")��name��ֵ: "+name.getText());
	}
	
	public void demo21_StuManageSys(){
		/*
		 * ѧ������ϵͳ����ɾ�Ĳ�洢ѧ����Ϣ��XML�ĵ�
		 * ˼·��
		 * 1.��дXML�ĵ�,���ڴ洢����
		 * 2.����StuManageSys�ࡣͨ����ķ�����XML������ɾ�Ĳ�
		 * 3.����Student�����ڴ洢����ֵ(����ָStudent,ֵָ��ǩ���ı�����)��������StuManageSys�����Ĳ�������Ȼһ��ѧ����
		 * 	 20����Ԫ���Ҷ�Ҫ��ǿ� ,addStu()��Ҫ��20��������
		 * �ܽ᣺Ҫ�������ǽڵ�����StuManageSys,�漰�������ǩ��ֵ,��ʹ��Student��1���ܱ�ǩ,1����ֵ��
		 */
		StuManageSys sys = new StuManageSys();
		//��
//		Student stu = new Student();
//		stu.setId("233");
//		stu.setName("�Ӷ���ɺ");
//		stu.setAge("28");
//		sys.addStu(stu);
		//ɾ��ɾһȺ�Ļ�,��������id,ֻҪidֵ��"233"��ɾ��.���ǰ�remove()�ŵ�ѭ�����ж��������
//		sys.delStuById("233");
		//�ġ������޸�Ҳ�ǽ�setText�ŵ�ѭ�����ж��������
//		sys.modifyAge("233", "3000");
		//��1,����һ��ѧ������
//		Student stu = sys.searchById("105");
//		if(stu != null){
//			System.out.println("id:"+stu.getId());
//			System.out.println("name:"+stu.getName());
//			System.out.println("age:"+stu.getAge());
//		}
		//��2,����һ��ѧ���б�
		List<Student> list = sys.searchByName("����");
		if(list.size()==0){
			System.out.println("û���ҵ�");
			return;
		}
		for (Student student : list) {
//			System.out.println(student.getId()+":"+student.getName()+":"+student.getAge());
//			Student����toString()����
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

	boolean flag = false;//�����ж��Ǳ�ǩͷ���Ǳ�ǩβ
	final int target = 2;
	int index = 0;	//��ȡ�ڶ���nameԪ��
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if("name".equals(qName)){	//��name��ǩ�ſ�ʼ
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
		if("name".equals(qName)){	//���������ǩΪname�ı�ǩβ
			flag = false; 			
		}
	}
	
}

	



