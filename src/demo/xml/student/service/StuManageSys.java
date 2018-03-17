package demo.xml.student.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import demo.xml.student.vo.Student;

public class StuManageSys {
	private Document document;
	private Element root;
	public StuManageSys(){
		//1.创建XML文档,用于储存学生信息
		//2.获取XML文档对象document
		try {
			SAXReader reader = new SAXReader();
			document = reader.read("src/demo/xml/student/demo21_StuManageSys.xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addStu(Student stu){
		//3.获取根节点
		root = document.getRootElement();
		//4.在根节点下添加stu标签
		Element element = root.addElement("stu");
		//5.在stu下添加age,name,id标签
		Element id = element.addElement("id");
		Element name = element.addElement("name");
		Element age = element.addElement("age");
		//6.添加值
		id.setText(stu.getId());
		name.setText(stu.getName());
		age.setText(stu.getAge());
		//7.回写XML
		overrideXML();
	}
	public void delStuById(String id){
		/*
		 * 根据什么来删？这里根据id删除 
		 */
		//3.使用XPath遍历每个id节点。并获取值匹配的节点。
		List<Node> list = document.selectNodes("//stu/id");//这里一定是document而不是root
		Element delEle = null;			//可以全部写在if语句里面
		for (Node node : list) {
			if(node.getText().equals(id)){
				delEle = node.getParent();//得到要删除的stu节点。
				break;				//braek换成remove就是批量删除
			}
		}
		if(delEle == null){
			System.out.println("没有该标签");
			return;
		}
		//5.删除这个节点的父节点。通过爷爷节点删除父节点。
		delEle.getParent().remove(delEle);
		//6.回写XML
		overrideXML();
	}
	public void modifyAge(String id,String age){
		/*
		 * 根据Id修改age
		 */
		//3.遍历所有id,判断id所在的标签,并获取它的父节点
		List<Node> list = document.selectNodes("//stu/id");
		Element modifyEle = null;
		for (Node node : list) {
			if(id.equals(node.getText())){
				modifyEle = node.getParent();
				break;
			}
		}
		if(modifyEle == null){
			System.out.println("没有找到要修改的标签");
			return;
		}
		//4.获取要修改的age节点
		Element newAge = modifyEle.element("age");
		//5.修改值
		newAge.setText(age);
		//6.回写XML
		overrideXML();
	}
	public Student searchById(String id){
		/*
		 * 根据id查询学生的所有信息
		 * 这些信息用Student对象存储。返回Student对象
		 */
		//3.遍历所有id,判断id所在的标签,并得到它的父节点
		List<Node> id_list = document.selectNodes("//stu/id");
		Element searchEle = null;	
		for (Node node : id_list) {
			if(id.equals(node.getText())){
				searchEle = node.getParent();
				break;
			}
		}
		if(searchEle == null){
			System.out.println("没有找到"+id+"对应的标签");
			return null;
		}
		//4.创建学生对象,用于存储stu所有子标签的值
		Student stu = new Student();
		//5.获取所有子标签的值,并传到stu对象
		stu.setId(searchEle.element("id").getText());
		stu.setName(searchEle.element("name").getText());
		stu.setAge(searchEle.element("age").getText());
		//6.返回stu对象
		return stu;
	}
	public List<Student> searchByName(String name){
		/*
		 * 根据名字查询,返回所有符合的学生的所有信息
		 */
		//3.创建返回的学生列表,用于存储学生对象
		List<Student> stu_list = new ArrayList<Student>();
		//4.遍历所有name节点,获取符合的节点的父节点,并加入到学生列表中
		List<Node> name_list = document.selectNodes("//stu/name");
		for (Node node : name_list) {
			if(name.equals(node.getText())){
				Element stu = node.getParent();
				Student student = new Student();
				student.setId(stu.element("id").getText());
				student.setName(stu.element("name").getText());
				student.setAge(stu.element("age").getText());
				stu_list.add(student);
			}
		}
		return stu_list;
	}
	private void overrideXML(){
		try {
			XMLWriter writer = new XMLWriter(
					new FileOutputStream("src/demo/xml/student/demo21_StuManageSys.xml"),
					OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
