package demo.collectionFreamwork.utilities;

import static java.lang.System.out;
import static java.util.Collections.max;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import demo.collectionFreamwork.CollectionFreamwork;
import demo.collectionFreamwork.example.Person;

public class UtilitiesDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		//demo7();
		//demo8();
		//demo9();
	}
	public void demo1(){		//����ͻ�λ
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("baka");
		al.add("123");
		al.add("xyz");
		al.add("abc");
		al.add("ddd");
		System.out.println(al);//[baka, 123, xyz, abc, ddd]
		/*
		 * ��ArrayList���Ͻ���ָ��˳������
		 * Collections.sort(List<T> list);
		 * Collections.sort(List<T> list,Comparator<? super T> comparator);//����ָ��˳������
		 * String����ʵ����comparable�ӿ�
		 * Person�಻�߱�����(�Ƚ�)����,��Ҫʵ��Comparable,����ʵ�ֱȽ��������򷽷�����ѱȽ�����Ϊ������
		 * ������������Ԫ�ز��߱��Ƚ��Ե�ʱ���÷���ͨ���������ܱȽ������,����Ӧ��  <T extends Comparable<? super T>>
		 * �� public static <T extendx Comparable<? super T> void mySort(List<T> list){ð������}
		 */
		Collections.sort(al);
		System.out.println(al);//[123, abc, baka, ddd, xyz]
		Collections.sort(al,new MySortComparator());
		System.out.println(al);//[xyz, ddd, baka, abc, 123]
		Collections.swap(al,2,3);//�±�2��3����λ��
		System.out.println(al);//[xyz, ddd, abc, baka, 123]  
		
	}
	public void demo2(){		//�۰����  Collections.BinarySearch(List<T> list);
		/*
		 * �۰����Ҫ��˳��
		 */
		ArrayList<Person> al = new ArrayList<Person>();
		Person p1 = new Person("ax",10);
		Person p2 = new Person("bd",5);
		Person p3 = new Person("dtt",11);
		Person p4 = new Person("ch",23);
		Person p5 = new Person("xh",2);
		Person p6 = new Person("ddy",10);
		al.add(p1);
		al.add(p2);
		al.add(p3);
		al.add(p4);
		al.add(p5);
		al.add(p6);
		System.out.println(al);
		Collections.sort(al, Person.getCompareByName());	//������˳������
		System.out.println(al);
		/*
		 * ���ֲ���
		 * ����Ҳ������ظ���,������һ{aa,aabb,aacc}����"aaa"�Ҳ���,����aaa�����λ��Ϊ1,ȡ����-1,�ټ�һ��return -2
		 * ��Ϊ��0�����Ļ��෴������0,��֪�����ҵ�����û�ҵ�,����Ҫ��һ��ȷ���Ǹ���
		 */
		System.out.println(Collections.binarySearch(al, p3));//-3
		//-3������Person��CompareTo,����������,����ǰ�水��������������,���Զ���������˵�������,�������ö��ֲ���
		System.out.println(Collections.binarySearch(al,p3,Person.getCompareByAge()));
		//4�����ڵ���
		
		/*
		 * ����ֵ,Person��CompareTo�ǰ�������������
		 */
		System.out.println(Collections.max(al));//Person ch:23
		System.out.println(Collections.max(al, Person.getCompareByName()));//Person xh:2
		
	}
	public void demo3(){		//����
		/*
		 * reverse(List<?> list) �Ƕ��б���з�ת
		 * reverseOrder();	reverseOrder(Comparator<?> c);�Ƕ������˳����з�ת��
		 * Collections.reverseOrder()����һ��ʵ��Comparable�����͵���Ȼ����ķ���
		 */
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());//����<>�������͵ĵ��򷽷��ıȽ���
		ts.add("ee");
		ts.add("ae");
		ts.add("aaaeaa");
		ts.add("ea");
		ts.add("aeea");
		ts.add("eaae");
		System.out.println(ts);	//[aaaeaa, ae, aeea, ea, eaae, ee]
								//[ee, eaae, ea, aeea, ae, aaaeaa]  TreeSet����Collections.reverseOrder()
		
		Person p1 = new Person("���˸���",5);
		Person p2 = new Person("���˸���",15);
		Person p3 = new Person("�����˸�",7);
		Person p4 = new Person("��������",5);
		TreeSet<Person> tsp = new TreeSet<Person>(Collections.reverseOrder(Person.getCompareByName()));
		//Personʵ��Comparable�ӿ�,�������������������ʽΪ�������ĵ�������
		tsp.add(p1);
		tsp.add(p2);
		tsp.add(p3);
		tsp.add(p4);
		System.out.println(tsp);//[Person �����˸�:7, Person ���˸���:5, Person ���˸���:15, Person ��������:5]
		
		/*
		 * replaceAll(List<T> list,T oldKey,T newKey);	//set(indexOf(old),new);
		 * ֻ������list���Ϻ������Ӽ�
		 */
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("cba");
		al.add("cba");
		Collections.replaceAll(al, "cba", "nba");
		System.out.println(al);//[abc, nba, nba]
		/*
		 * shuffle(List<?> list) ʹ��Ĭ�����Դ���б�Ԫ�ص�˳���滻
		 */
		Collections.shuffle(al);
		System.out.println(al);//[nba, nba, abc]ÿ�����н������һ��
		
		/*
		 * fill(List<? super T> list,T obj)
		 *  �Ѽ���list����ĵ�ȫ��Ԫ�ض���obj�滻
		 */
		Collections.fill(al, "xixi");
		System.out.println(al);//[xixi, xixi, xixi]
	
	}
	public void demo4(){		//����ͬ���ļ��ϼ���
		//Collections.synchronizedCollection(c);Map,List,Set ���ض�Ӧ��ͬ������
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abc");
		list.add("abcba");
		@SuppressWarnings("unused")
		List<String> synList = Collections.synchronizedList(list);//���ͬ�����б�
	}
	public void demo5(){		//Arrays������,�ر�������ת����Arrays.asList(����)
		
		/*
		 * Arrays ���Ͽ�ܵĹ�����,����ķ������Ǿ�̬��,����Ĳ���ȫ����������
		 * ��Ϊ���������и��ָ����ķ���,������û�з���������Arrays��������������ķ���
		 * ��Ҫ������	binarySearch();��������
		 * 			copyOf();��������
		 * 			equals(2������);��������,����Objecet��� 
		 * 			sort();��������
		 * 			deepEquals();��ȱȽ� ,�����Ƚ�ÿ��Ԫ��,���Ƚ�ÿ��Ԫ�ص�����
		 * 			toString(); sop(a[])������ǵ�ֵַ  sop(Arrays.toString(a[])); �������a������ �����int ��������������ǵ�ַ
		 * 
		 * 			public static <T> List<T> asList(T... a) ������ת��ΪList  Arrays
		 * ע�⣺����ĳ����ǹ̶��ģ����Լ��ϵ���ɾ�����ǲ�����ʹ�õķ���ᷢ��UnsupportedOperationException
		 */
		String[] str = {"aa","abc","haha","ddd"};
		List<String> list = Arrays.asList(str);	//Arrays����û���жϰ���Ԫ�صķ���.
		//list.add("abc");//java.lang.UnsupportedOperationException,���鳤���ǹ̶���
		System.out.println(list.contains("abc"));
		
		/*
		 * ��������е�Ԫ���Ƕ�����ôת�ɼ���ʱ��ֱ�ӽ������е�Ԫ����Ϊ�����е�Ԫ�ش洢
		 * ��������е�Ԫ���ǻ����������ͣ���ô�Ὣ��������Ϊ�����е�Ԫ�ؽ��д洢
		 */
		int[] arr = {21,233,44,66};
		List<int[]> newList = Arrays.asList(arr);//[[I@1cf38f09],���������ʵ��,���Ǵ������������
		System.out.println(newList);
	}
	public void demo6(){		//����ת����, Collection�ӿ�
		
		/*
		 * Object[] toArray();
		 * T<T> toArray(T[]);
		 * ����ת����,���ԶԼ����е�Ԫ�ز����ķ��������޶��������������ɾ
		 */
		Set<String> set = new HashSet<String>();
		set.add("abc");
		set.add("xyz");
		set.add("dsa");

		String[] arr = set.toArray(new String[1]);	//���鳤��Ϊ5[abc, dsa, xyz, null, null]
													//���鳤��С�ڻ���ڼ���Size�ᴴ��ͬ���ȵ�����[abc, dsa, xyz]
		System.out.println(Arrays.toString(arr));//����ToString�Ļ������[Ljava.lang.String;@10c1c428
	}
	public void demo7(){		//Iterable
		/*
		 * JDK1.5�� Collection�̳�Iterable,����ֻ��iterator()����
		 * ʵ������ӿ���������Ϊ"foreach"����Ŀ��
		 * ��ʽ��	for(���� ���� ��Collection���ϻ�����){
		 * 		}
		 * 
		 * ��ͳfor����ǿfor������
		 * ��ͳfor������ɶ����ִ�кܶ��,��Ϊ���Զ������ѭ��������������
		 * ��ǿfor��Ŀ������ǵ��м��ϻ�������
		 * ���ֻ�ǻ�ȡ����򼯺��е�Ԫ�ؿ���ʹ�ø߼�for�����Ҫ������ĽǱ���в�������ʹ�ô�ͳfor
		 */
		List<String> list  = new ArrayList<String>();
		list.add("avc");
		list.add("213");
		list.add("ddd");

		
		//ͨ��ֻ���ڱ���,��Ϊ���ܶ�Ԫ�ؽ��в���
		for(String s : list){		//������for(Iterator<T> it = list.iterator();it.hasNext;){}
			System.out.println(s);
		}
		int[] arr = {1,2,4,6,3,5};
		for(int i : arr){
			System.out.println(i);
		}
	}
	public void demo8(){		//������������
		
		int sum1 = add(1,2,3,4,5);
		System.out.println("sum1 = "+ sum1);//sum1 = 15
		int sum2 = add();
		System.out.println("sum2 = "+ sum2);//sum2 = 0
		
	}
	public void demo9(){
		/*
		 * Ҫ�õ�ĳ����ľ�̬����,ÿ�ζ�Ҫ����.���� ����鷳  ����Collections.sort();Collections.max();
		 * ����import static java.util.Collections.*; ���뾲̬��Ա(�����ͱ���)
		 * �����������ͻ��,��������ʡ��(��������ʡ��)
		 * improt static java.lang.System.*;  ����out.println(); ��Ϊout�Ǿ�̬��Ա  println()���Ǿ�̬��Ա,
		 * ���Բ���ʡ�Ե�print()
		 */
		List<Integer> list  = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(2);
		sort(list);
		out.println(list);		//[1, 2, 3, 4, 5] improt static java.lang.System.*; 
		out.println(max(list));	//5	
	}
	public static int add(int... arr){	//int... ������պܶ�int���͵Ĳ���,��ʵҲ��һ������,�ɱ��������������ͷ�װ�����ڲ����
										//int[] arr �Ļ�һ��Ҫ������������Ȼ����ܴ�����,������������ʱ��Ͱѳ��ȹ̶���
		/*
		 * �����Ŀɱ��������ʵ����һ������,���ǽ��ܵ��������Ԫ��,�Զ�����ЩԪ�ط�װ�����飬���˵����ߵ���д
		 * ע�⣺�ɱ�������ͱ��붨���ڲ����б�����һ��
		 * add(int a,int... arr)����			add(int... arr,inta)������
		 */
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}
}
class MySortComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);	//����	return o1.length()-o2.length();�����ַ�����������
	}

}

/*
 * Collections	�Ǽ��Ͽ�ܵĹ����࣬����ȫ���Ǿ�̬����
 * Arrays
 */
