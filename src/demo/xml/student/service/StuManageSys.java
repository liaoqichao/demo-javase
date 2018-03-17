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
		//1.����XML�ĵ�,���ڴ���ѧ����Ϣ
		//2.��ȡXML�ĵ�����document
		try {
			SAXReader reader = new SAXReader();
			document = reader.read("src/demo/xml/student/demo21_StuManageSys.xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addStu(Student stu){
		//3.��ȡ���ڵ�
		root = document.getRootElement();
		//4.�ڸ��ڵ������stu��ǩ
		Element element = root.addElement("stu");
		//5.��stu�����age,name,id��ǩ
		Element id = element.addElement("id");
		Element name = element.addElement("name");
		Element age = element.addElement("age");
		//6.���ֵ
		id.setText(stu.getId());
		name.setText(stu.getName());
		age.setText(stu.getAge());
		//7.��дXML
		overrideXML();
	}
	public void delStuById(String id){
		/*
		 * ����ʲô��ɾ���������idɾ�� 
		 */
		//3.ʹ��XPath����ÿ��id�ڵ㡣����ȡֵƥ��Ľڵ㡣
		List<Node> list = document.selectNodes("//stu/id");//����һ����document������root
		Element delEle = null;			//����ȫ��д��if�������
		for (Node node : list) {
			if(node.getText().equals(id)){
				delEle = node.getParent();//�õ�Ҫɾ����stu�ڵ㡣
				break;				//braek����remove��������ɾ��
			}
		}
		if(delEle == null){
			System.out.println("û�иñ�ǩ");
			return;
		}
		//5.ɾ������ڵ�ĸ��ڵ㡣ͨ��үү�ڵ�ɾ�����ڵ㡣
		delEle.getParent().remove(delEle);
		//6.��дXML
		overrideXML();
	}
	public void modifyAge(String id,String age){
		/*
		 * ����Id�޸�age
		 */
		//3.��������id,�ж�id���ڵı�ǩ,����ȡ���ĸ��ڵ�
		List<Node> list = document.selectNodes("//stu/id");
		Element modifyEle = null;
		for (Node node : list) {
			if(id.equals(node.getText())){
				modifyEle = node.getParent();
				break;
			}
		}
		if(modifyEle == null){
			System.out.println("û���ҵ�Ҫ�޸ĵı�ǩ");
			return;
		}
		//4.��ȡҪ�޸ĵ�age�ڵ�
		Element newAge = modifyEle.element("age");
		//5.�޸�ֵ
		newAge.setText(age);
		//6.��дXML
		overrideXML();
	}
	public Student searchById(String id){
		/*
		 * ����id��ѯѧ����������Ϣ
		 * ��Щ��Ϣ��Student����洢������Student����
		 */
		//3.��������id,�ж�id���ڵı�ǩ,���õ����ĸ��ڵ�
		List<Node> id_list = document.selectNodes("//stu/id");
		Element searchEle = null;	
		for (Node node : id_list) {
			if(id.equals(node.getText())){
				searchEle = node.getParent();
				break;
			}
		}
		if(searchEle == null){
			System.out.println("û���ҵ�"+id+"��Ӧ�ı�ǩ");
			return null;
		}
		//4.����ѧ������,���ڴ洢stu�����ӱ�ǩ��ֵ
		Student stu = new Student();
		//5.��ȡ�����ӱ�ǩ��ֵ,������stu����
		stu.setId(searchEle.element("id").getText());
		stu.setName(searchEle.element("name").getText());
		stu.setAge(searchEle.element("age").getText());
		//6.����stu����
		return stu;
	}
	public List<Student> searchByName(String name){
		/*
		 * �������ֲ�ѯ,�������з��ϵ�ѧ����������Ϣ
		 */
		//3.�������ص�ѧ���б�,���ڴ洢ѧ������
		List<Student> stu_list = new ArrayList<Student>();
		//4.��������name�ڵ�,��ȡ���ϵĽڵ�ĸ��ڵ�,�����뵽ѧ���б���
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
