package demo.collectionFreamwork.genric;


import demo.collectionFreamwork.example.*;





import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import demo.collectionFreamwork.CollectionFreamwork;

public class GenericDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();

	}
public void demo1(){				//���͵�ʹ��
		
		TreeSet<Person> ts = new TreeSet<Person>(Person.getCompareByName());
		ts.add(new Person("ad",1));
		ts.add(new Person("ab",2));
		ts.add(new Person("cccc",3));
		ts.add(new Person("cdc",14));
		
		for(Iterator<Person> it = ts.iterator();it.hasNext();){
			Person person = it.next();
			System.out.println(person.getName()+"::"+person.getAge());
		}
	}
	public void demo2(){				//�Զ��巺����
	
		Tool<Person> tool = new Tool<Person>();//�ĳ�woker person���ò���
		Person p1 = new Person("����",19);
		Worker w1 = new Worker("����",19);
		Worker w2 = new Worker("����",15);
		tool.setQ(p1);
		tool.setQ(w1);	//Worker�̳е�Person���Կ���
		tool.setQ(w2);
	}	
	public void demo3(){				//�Զ��巺�ͷ������Զ��巺�ͽӿ�
		
		//Tool<String> tool = new Tool<String>();
		//tool.show("abc");
		Tool<Integer> tool = new Tool<Integer>();
		tool.setQ(123);
		//tool.setQ("abc");		//ֻ��Integer,û���÷���ȷ�����͵�ʱ�����,�����о���
		//���ͷ���
		tool.show(134);			//show :134
		tool.show("abx");		//show :abx
		tool.show(new Person());//show :Person@5e3b8219
		
		tool.print(123); 		//���Ƿ��ͷ���,���ŷ�����Ľ������͡�tool.print("213");���ܽ���String
		
		Tool.staShow(123);		//��̬����ֻ�ܽ����Ͷ����ڷ�����,���ܵ�����ķ���
		Tool.staShow("abc");
		
		tool.intershow("lalal");//����ֻ����String����
	}
	public void demo4(){				//���͵�ͨ���

		
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("xyz");
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(123);
		hs.add(678);
		
		/*	ԭ����Ҫ����������,���ǵ������Ĺ��ܶ�һ��
		for(Iterator<String> it = al.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
		for(Iterator<Integer> it = hs.iterator(); it.hasNext();){
			System.out.println(it.next());
		}*/
		
		//printCollection(al);	//һ��������,�����������͸��ݲ�������,��printCollection()�����extends Personȥ���Ͳ��ᱨ��
		//printCollection(hs);	
		//���Ҫ���������ֻ��ӡPerson�������������أ�  �����޶�����
		//���Ҫ���������ֻ��ӡPerson������ĸ�����أ�  �����޶�����

		/*
		 * ͨ�������
		 * containsAll(Collection<?> e) 
		 * ��ΪcontainsAll���õ���Object��equals����,"abc".equals(new Person("p1",10));��ͬ����Ҳ�ܱȽϣ��Ƚϵ��ǵ�ַ
		 * ���Բ��������CollectionӦ������������ (Object����) ? 
		 * һ�����Object�ķ�����ʱ����<?>  ���߷���һ������,���Ǽ��ϲ�֪����ʲô����
		 */
	}
	public void demo5(){				//�����޶���������
		/*
		 * ʲôʱ���÷����ȶ�����? //********��Ҫ���ط������͵�ֵ������ʱ.�򵥵�˵���Ƿ���ֵΪ���͵ķ���������
		 * public void fun1(List<? extends Number> list){
		 * 	Number a = list.get(0);	//����,�������͵õ�������󣬶�̬��
		 *  lit.add(new Integer(100));//�����ԣ������List<Double> list�Ļ��ʹ���
		 * }
		 */
		ArrayList<Worker> alw = new ArrayList<Worker>();
		alw.add(new Worker("����",30));
		alw.add(new Worker("����",20));
		ArrayList<Student> als = new ArrayList<Student>();
		als.add(new Student("���˸���",17));
		als.add(new Student("���˸���",14));
		ArrayList<Person> alp = new ArrayList<Person>();
		alp.add(new Person("ѧ���Ǥ�",18));
		alp.add(new Person("��`���`�Ǥ�",28));
		
		printCollection(alw);
		printCollection(als);
		printCollection(alp);
		
		/*
		 * �����޶��������ӣ� public boolean addAll(Collection<? extends E> e)
		 * �����б�������Person,����Person�������������͵�Collection��������Ϊ addAll�Ĳ���
		 * Person���͵ļ���������Լ���Student���͵ļ������������Ԫ��
		 * Person���͵ļ���������Լ���Worker���͵ļ������������Ԫ��
		 */
		ArrayList<Person> alAll = new ArrayList<Person>();
		alAll.addAll(als);
		alAll.addAll(alw);
		alAll.addAll(alp);
		printCollection(alAll);
		
	}
	public void demo6(){				//�����޶���������

		/*
		 * �����޶��������ӣ� ���췽��TreeSet(Comparator<? super E> comparator);
		 * ʲôʱ�������ޣ�	//��ʹΪ���͵ķ�������ʹ��
		 * public void fun2(List<? super Integer) list){
		 * 	lit.add(new Integer(100));//������������ķ������Ͷ���Integer�ĸ��࣬����List<Number>��List<Object>����add
		 * Number a = list.get(0); //���У����List<Object> ʹ��Number�ʹ���
		 * }
		 * ��ʲô����,������ʲô���ͽ���,Ҳ�����ø�����������
		 * �Ƚ����������Ƚ�Person�ࡣStudent��WorkerҲ����Person,Ҳ������Person�ıȽϹ������Ƚ�
		 * ����Student,Worker���TreeSet�����ñ����͵ıȽ���,Ҳ�����ø���ıȽ���
		 */
		
		TreeSet<Person> tsp = new TreeSet<Person>(Person.getCompareByAge());//����Ƚ����������Ƚ�Person���͵�
		tsp.add(new Person("p1",17));
		tsp.add(new Person("p2",14));
		
		/*
		 * CompareByAge<Person> compareByAge = new CompareByAge<Person>(); 
		 * TreeSet<Worker> tsw = new TreeSet<Worker>(compareByAge);
		 * �����������worker,���ǱȽ�����������Person
		 * class TreeSet<Worker>{
		 *  TreeSet(Comparator<? super Worker> comparator);	//�����ͻ��߸������͵ıȽ�����������
		 *  //Ϊʲô��ֱ��Comparator<? super Person> comparator
		 *  //��Ϊ���TreeSet��������Worker����Person
		 *  }
		 */
		TreeSet<Worker> tsw = new TreeSet<Worker>(Person.getCompareByAge());//��Ȼ����Ƚ����������Ƚ�Person����.����TreeSet�Ĺ��캯��
		tsw.add(new Worker("w1",22));					 //�ñȽ�����Worker���ͻ������ĸ���Person���Ͷ�������
		tsw.add(new Worker("w2",40));					 //�����޶����ޣ� <? super E>  �����E��Worker
														 //����Person��ıȽ���Ҳ������
		TreeSet<Student> tss = new TreeSet<Student>(Person.getCompareByAge());
		tss.add(new Student("s1",16));
		tss.add(new Student("s2",13));
		
		printCollection(tsp);
		printCollection(tsw);
		printCollection(tss);
		

	}
	private void printCollection(Collection<? extends Person> al) {		//���͵�ͨ���   ?��Person���Person�������
		/*						(Collection<? super Student> al)		//Student���Student��ĸ���
		 * ���͵�ͨ���   ?	δ֪����
		 * ������ȷ���͵�ʱ��������ʺ�����ʾ
		 * ��<>���� �̳���Ҫ����ĸ���,���޶����������  
		 * private void printCollection(Collection<? extends Person> al) 
		 * ? ��ʾĳ�����͵���ȷ��, ������ͼ̳�Person����Person�����࣬ 
		 * 
		 * Ҳ����д�� private <T> void printCollection(Collection<T> al)
		 * 		for(Iterator<T> it = al.iterator(); it.hasNext();){
		 * 			T str = it.next();		//����������ʺŲ���  ? str = it.next();
		 * 									//T���Խ��в���  T t = it.next(); return t;  
		 *			System.out.println(str);
		 *		}
		 *<? extends E>���޶���������ΪE��������Ķ�������  �����޶����Ϳ����ø���ķ���
		 *<? super E>���޶�����E���ͻ���E���͵ĸ���Ķ�������
		 * һ�㶨��洢��ʱ�� ��<? extends E>  ���� ���������addAll(Collection<? extends E>)
		 *  ��Ϊ����ȡ�����ǰ���������ȡ�ģ����������������(����ת���쳣)
		 */
		
		for(Iterator<?> it = al.iterator(); it.hasNext();){
			Person p = (Person)it.next(	);
			System.out.println(p.getClass().getName()+"  "+p.getName()+":"+p.getAge());
		}
	}

}

class Tool<QQ> implements Inter<String>{		//�Զ��巺���෺����
	//�����QQ�������ĳһ�����͡�
	private QQ q ;

	public QQ getQ() {
		return q;
	}

	public void setQ(QQ q) {
		this.q = q;
	}
	
	/*
	 * ���ͺ���
	 * �߼�������ͬ,�������Ͳ�ͬ������ʹ�÷��ͺ�����
	 */
	public <WW> void show(WW w){			//<WW> Ҫ��void ǰ��
		//<WW>��ʾ���Ƿ��ͺ�����WW w��ʾ�����յĲ���������WW����������Ҫ��<>�����һ��
		System.out.println("show :"+w);
	}
	public void print(QQ q){				//���������Ľ�������
		System.out.println("show :"+q);
	}
	public static <WW> void staShow(WW w){	//��̬��������ʹ�����϶���ķ���,ֻ�ܽ����Ͷ����ڷ�����
//		public  static void staShow(QQ q)	//����
		System.out.println("static show :"+w);
	}
	public void intershow(String str){		//�����StringҪ����ʵ�ַ��ͽӿڵĽ�������
		System.out.println("interface show :"+str);
	}
}
interface Inter<T>{
	
	public abstract void intershow(T t);
}


