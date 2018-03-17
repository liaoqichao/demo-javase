package demo.collectionFreamwork.collection.set;

import demo.collectionFreamwork.example.*;

import java.util.HashSet;
import java.util.Iterator;

import demo.collectionFreamwork.CollectionFreamwork;

public class HashSetDemo implements CollectionFreamwork {

	
	/**
	 * Set:����(�����ȡ����˳��û��ϵ)�����ظ�
	 * Set�Ĺ��ܺ�Collection�Ĺ�����һ�µ�
	 * ���������ࣺ	HashSet���ײ����ݽṹ�ǹ�ϣ���̲߳�ͬ��,�ж�Ԫ���Ƿ���ͬ���������ж�hashCode���ж�equals
	 * 			TreeSet���ײ����ݽṹ�����������ƽ������������ԶԼ����е�Ԫ�ؽ�������
	 * ������������ʽ��	�ȸ���������������
	 * 				�и��������󣬸�����		��������
	 * 				������������ң���		
	 * ƽ�������������һ���ڵ㣬�������������������ĸ߶Ȳ�Ϊ1������ÿ�����ӽڵ��ʱ��,�����п��ܱ仯
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();

	}
	public void demo1(){
		/*
		 * HashSet ͨ�����ж�hashCode,���ж�equals ���2�ζ���ͬ,��Ϊ��ͬԪ��,�Ӷ�����֤Ԫ�ص�Ψһ��
		 */
		HashDemo h1 = new HashDemo();
		HashDemo h2 = new HashDemo();
		System.out.println(h1);//��дhashCode()ǰHashDemo@6deea96c����дhashCode()��HashDemo@c7  3c(hex)=60(decimal)
		System.out.println(h2);//��дhashCode()ǰHashDemo@4fb529d6����дhashCode()��HashDemo@c7
		//��ϣ���ж���������ͬһ����ַ֮��,�����ٽ����ж�,�ж�����ʱ����ͬһ����equals()��,�����,���Ǹ���ַ���һ������
	}	
	public void demo2(){
		
		HashSet<String>  hs  = new HashSet<String>();//����˳��1,2,3,4
		hs.add("e1");//true  ΪʲôCollection��add��boolean���ͣ�  ��һ������ɹ�,�ڶ�������ʧ��
		hs.add("e1");//false
		hs.add("e2");
		hs.add("e3");
		hs.add("e3");
		hs.add("e4");
		
		for(Iterator<String> it = hs.iterator();it.hasNext();){
			System.out.println(it.next());			//ȡ��˳��3,4,1,2  �ʹ���˳��һ��������ַ��Сȡ��
		}
	}
	public void demo3(){		//HashSet �����Զ�������Person  �����ֺ�������ͬ���ظ�
		
		/*
		 * ����demo1(); ���жϹ�ϣֵ�Ƿ��ظ�hashCode,Ȼ�����ж϶����Ƿ���ͬequals������Person��Ҫ��дhashCode��equal
		 * ���԰ѹ�ϣֵ��Ϊ������ÿ�ι�ϣֵ��ͬ��Ҫ�Ƚ϶����Ƿ���ͬ,����equals���ж϶���Ͳ��������ֺ�����ʱ����ͬ
		 * ��Ϊ�Զ������п��ܻ���뵽HashSet��,�����Զ����������ḴдObject�е�equals��hashCode����Ϊ���ݽṹ�ĵײ���Լ�����
		 * equals��hashCode���������ֹ�ϣֵΨһ���������Ч��
		 * 
		 * ���ݽṹ�����ϣֵ�ķ���ͨ���У�
		 * 1.ֱ��Ѱַ��
		 * 2.���ַ�����
		 * 3.ƽ��ȡ�з�
		 * 4.�۵���
		 * 5.�������
		 * 6.����ȡ�෨
		 * �������ֹ�ϣֵΨһ���������Ч�ʣ������ϣֵ��ͻ�ķ�����
		 * 1.����Ѱַ��
		 * 2.��ɢ�з�
		 * 3.����ַ��(������)
		 * 4.����һ�����������
		 *
		 */
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(new Person("e1",10));
		hs.add(new Person("e2",10));//e2::10..equals?..e1::10 : false  	(e2,10)����HashSet
		hs.add(new Person("e1",10));//e1::10..equals?..e2::10 : false
									//e1::10..equals?..e1::10 : true	(e1,10)���в�����HashSet
		hs.add(new Person("e2",20));//e2::20..equals?..e2::10 : false
									//e2::20..equals?..e1::10 : false	(e2,20)����HashSet
		hs.add(new Person("e2",10));//e2::10..equals?..e2::20 : false
									//e2::10..equals?..e2::10 : true	(e2,10)���в�����HashSet
									//(e2::10..equals?..e1::10 : flase)   ǰ���Ѿ�true,��Ȼ�����ж����
		
		/*
		 * ����1�Ƚϴ����Ƚ���
		 * ����1��hashCode = name.hasCode+age;
		 * e1::10...hashCode
		 * e2::10...hashCode
  		 * e1::10...hashCode
		 * e1::10..equals?..e1::10 : true
		 * e2::20...hashCode
		 * e2::10...hashCode
		 * e2::10..equals?..e2::10 : true
		 * e2.::20
		 * e2.::10
		 * 
		 * ����2��hashCode = 1;
		 * e1::10...hashCode
		 * e2::10...hashCode
		 * e2::10..equals?..e1::10 : false
		 * e1::10...hashCode
		 * e1::10..equals?..e2::10 : false
		 * e1::10..equals?..e1::10 : true
		 * e2::20...hashCode
		 * e2::20..equals?..e2::10 : false
		 * e2::20..equals?..e1::10 : false
		 * e2::10...hashCode
		 * e2::10..equals?..e2::20 : false
		 * e2::10..equals?..e2::10 : true
		 * e2.::20
		 * e2.::10
		 * e1.::10
		 */
		
		for(Iterator<Person> it = hs.iterator(); it.hasNext();){
			Person person = (Person)it.next();//��ת��
			System.out.println(person.getName()+".::"+person.getAge());
			/*
			 * e2.::20
			 * e2.::10
			 * e1.::10
			 */
		}
	}
	public void demo4(){			//HashSet�жϺ�ɾ��������
		/*
		 * HashSet�ж�contains��ɾ��remove������
		 * ��Ҫ���ж�hasCode,���ж�equals
		 * ��ArrayList��contains��removeֻ�ж�equals
		 */
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(new Person("e1",10));
		hs.add(new Person("e2",10));
		hs.add(new Person("e1",10));
		
		System.out.println(hs.contains(new Person("e1",10)));//true
		System.out.println(hs.remove(new Person("e2",10)));	//true
		/*
		 * HashSet��contains���ж����� ���ж�hashCode,���ж�equals
		 * e1::10...hashCode
		 * e1::10..equals?..e1::10 : true
		 * true
		 */
	}
}
class	HashDemo{		//��дhashCode() ,���Լ������ϣ�㷨
	
	public int hashCode(){
		return 60;
	}
	
}



