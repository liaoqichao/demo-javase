package demo.collectionFreamwork.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import demo.collectionFreamwork.CollectionFreamwork;
import demo.collectionFreamwork.example.*;

public class TreeMapDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
public void demo1(){
		
		/*
		 * ��ѧ�������ѧ��������ͨ������ֵ�洢��Map�У�������ѧ��������������
		 * ��ΪPerson��ʵ����Comparable����,����Student���пɱ���.
		 * ��Ҫ�пɱ��ԡ�
		 */
		//������������,Personʵ�ֵ�Comparable����
		System.out.println("������������");
		TreeMap<Student,String> tm = new TreeMap<Student,String>();
		tm.put(new Student("����",15), "����");
		tm.put(new Student("����",17), "�Ϻ�");
		tm.put(new Student("����",15), "����");
		tm.put(new Student("����",15), "����");
		tm.put(new Student("����",16), "����");
		
		for(Iterator<Map.Entry<Student,String>> it = tm.entrySet().iterator();it.hasNext();){
			Map.Entry<Student, String> me = it.next();
			System.out.println(me.getKey()+" : "+me.getValue());
		}
		//������������,ʵ�ֱȽ���
		System.out.println("������������");
		TreeMap<Student,String> tm1 = new TreeMap<Student,String>(Person.getCompareByName());
		tm1.put(new Student("����",15), "����");
		tm1.put(new Student("����",17), "�Ϻ�");
		tm1.put(new Student("����",15), "����");
		tm1.put(new Student("����",15), "����");
		tm1.put(new Student("����",16), "����");
		for(Iterator<Map.Entry<Student,String>> it = tm1.entrySet().iterator();it.hasNext();){
			Map.Entry<Student, String> me = it.next();
			System.out.println(me.getKey()+" : "+me.getValue());
		}
		
	}

}

