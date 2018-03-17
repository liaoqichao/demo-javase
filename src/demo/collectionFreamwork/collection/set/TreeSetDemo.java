package demo.collectionFreamwork.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import demo.collectionFreamwork.CollectionFreamwork;
import demo.collectionFreamwork.example.Person;

public class TreeSetDemo implements CollectionFreamwork {
	/**
	 * TreeSet ���Զ�Set�е�Ԫ�ؽ�������
	 * Ԫ��Ҫimplements Comparable ʵ��public int compareTo()��������Ԫ�ؾ��пɱ���,����ts.add(obj)�����
	 * �Ƚ�ʱ��Ҫ������ͬҪ�Ƚϴ�Ҫ����.һ��Ҫ��Ҫ����
	 * TreeSet���ײ����ݽṹ�����������ƽ������������ԶԼ����е�Ԫ�ؽ�������
	 * ͨ��Ԫ�ص�compareTo()�������ж�Ԫ���Ƿ���ͬ��Ϊ0����ͬ,��Ϊ0����ͬ���͹�ϣֵû��ϵ
	 * 
	 * TreeSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ��ԡ�Ԫ��ʵ��Comparable�ӿڣ�����public int compareTo()������
	 * 					  ���ַ�ʽ��ΪԪ�ص���Ȼ˳�����Ԫ�ص�Ĭ��˳��
	 * TreeSet����ĵڶ��ַ�ʽ����Ԫ�ز��߱��Ƚ��Ի��߾߱��ıȽ��Բ�������Ҫ��,��Ҫ�ı�ȽϹ���(�����������ɰ���������)����ʱ
	 * 					��ʱ����Ҫ�ü�������߱��Ƚ��ԡ��ڼ��ϳ�ʼ��ʱ�����˱ȽϷ�ʽ����ʱ��Ҫ����Ƚ���Comparator��
	 * 					�ñȽ�����ΪTreeSet�Ĳ���.
	 * 					������ַ�ʽ���а��ձȽ����Ĺ�������
	 * Comparator����2��������1.int compare(T o1,T o2)  2. boolean equals(o);
	 */

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();

	}
public void demo1(){			//TreeSet��Ԫ��һ��Ҫ�пɱ���,��Ȼ��֪��˳��
		
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("ea1");
		ts.add("ed2");
		ts.add("eb3");
		ts.add("ec4");
		ts.add("ee5");
		ts.add("e6");
		ts.add("e61");
		
		for(Iterator<String> it = ts.iterator();it.hasNext() ;){
			System.out.println(it.next());
		}
		/*
		 * e6,e61,ea1,eb3,ec4,ed2,ee5 ����ASCII��������
		 */
	}
	public void demo2(){			//TreeSet�洢�Զ�������
		
		/*
		 * ���������������
		 * Ԫ�ش���˳���ȡ��˳��һ����Ԫ��compareTo����return 1;
		 */
		TreeSet<Person> ts = new TreeSet<Person>();

		/*
		 * ts.add(new Person("lisi02",22));
		 * Exception in thread "main" java.lang.ClassCastException: Person cannot be cast to java.lang.Comparable
		 * ��Ҫ�Զ����������.Ȼ��Personû����������ݡ�����Person��Ҫʵ��Comparable<Object>�ӿڣ�
		 * ʵ��public int compareTo(Object o)����,�����������׳��쳣,��Ϊ���󷽷�����û���׳��쳣
		 */
		
		ts.add(new Person("lisi09",20));
		ts.add(new Person("lisi09",19));			
		ts.add(new Person("lisi01",40));
		ts.add(new Person("lisi02",40));	
		/* old data
		ts.add(new Person("lisi02",22));
		ts.add(new Person("lisi007",20));
		ts.add(new Person("lisi09",19));
		ts.add(new Person("lisi09",19));			//��Ϊ�ظ�Ԫ��û����
		ts.add(new Person("lisi01",40));
		ts.add(new Person("lisi02",40));			//����ʱ����Ҫ������ͬʱ,Ҫ�Ƚϴ�Ҫ����,��Ҫ����Ҳ��ͬ���ж�ΪͬһԪ��
		*/
		/*
		 * lisi02::22..compareTo..lisi02::22		//����ֻ��1��ts.add()Ҳ����,��Ƶ��Ҫ2��ts.add()�ű���
		 * lisi007::20..compareTo..lisi02::22
		 * lisi09::19..compareTo..lisi02::22
		 * lisi09::19..compareTo..lisi007::20
		 * lisi01::40..compareTo..lisi007::20
		 * lisi01::40..compareTo..lisi02::22
		 */
		
		for(Iterator<Person> it = ts.iterator();it.hasNext();){
			Person person = it.next();
			//System.out.println(person);//����Ҳ������hashCode
			System.out.println(person.getName()+"::"+person.getAge());
		}
		/*
		 * lisi09::19...hashCode	System.out.println(person); ����Ҳ������hashCode,
		 * Person@be48e0c1			���ǲ���Person���hashCode,Ȼ�������ַ
		 * lisi007::20...hashCode
		 * Person@ad2dfd0
		 * lisi02::22...hashCode
		 * Person@be48e12f
		 * lisi01::40...hashCode
		 * Person@be48e3ec
		 * �Ѿ�������������
		 */
	}
	public void demo3(){			//������������,��Comparator
		
		Comparator<Person> c = new PersonComparator();
		TreeSet<Person> ts = new TreeSet<Person>(c);
		ts.add(new Person("lisi09",20));
		ts.add(new Person("lisi09",19));			
		ts.add(new Person("lisi01",40));
		ts.add(new Person("lisi02",40));		
		
		for(Iterator<Person> it = ts.iterator();it.hasNext();){
			Person person = it.next();
			System.out.println(person.getName()+"::"+person.getAge());
		}
	}
	public void demo4(){			//��TreeSet������ַ��������ַ�����������
		
		Comparator<String> c = new StrLenComparator();
		TreeSet<String> ts = new TreeSet<String>(c);
		ts.add("abc");
		ts.add("aabc");
		ts.add("abssc");
		ts.add("ac");
		ts.add("xyz");
		ts.add("abcdc");
		
		for(Iterator<String> it = ts.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
}

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		if(o1.getName()==o2.getName()){
			return o1.getAge()-o2.getAge();
		}	
		return o1.getName().compareTo(o2.getName());
	}
	
}
class StrLenComparator implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		if(arg0.length() == arg1.length()){
			return arg0.compareTo(arg1);
		}
		return arg0.length()-arg1.length();
	}
}
