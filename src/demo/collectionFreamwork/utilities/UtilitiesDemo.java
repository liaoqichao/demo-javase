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
	public void demo1(){		//排序和换位
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("baka");
		al.add("123");
		al.add("xyz");
		al.add("abc");
		al.add("ddd");
		System.out.println(al);//[baka, 123, xyz, abc, ddd]
		/*
		 * 对ArrayList集合进行指定顺序排序
		 * Collections.sort(List<T> list);
		 * Collections.sort(List<T> list,Comparator<? super T> comparator);//按照指定顺序排序
		 * String本身实现了comparable接口
		 * Person类不具备排序(比较)能力,需要实现Comparable,或者实现比较器在排序方法里面把比较器作为参数。
		 * 当方法操作的元素不具备比较性的时候用泛型通配符如果不能比较则出错,所以应该  <T extends Comparable<? super T>>
		 * 如 public static <T extendx Comparable<? super T> void mySort(List<T> list){冒泡排序}
		 */
		Collections.sort(al);
		System.out.println(al);//[123, abc, baka, ddd, xyz]
		Collections.sort(al,new MySortComparator());
		System.out.println(al);//[xyz, ddd, baka, abc, 123]
		Collections.swap(al,2,3);//下标2和3交换位置
		System.out.println(al);//[xyz, ddd, abc, baka, 123]  
		
	}
	public void demo2(){		//折半查找  Collections.BinarySearch(List<T> list);
		/*
		 * 折半查找要有顺序
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
		Collections.sort(al, Person.getCompareByName());	//按名字顺序排序
		System.out.println(al);
		/*
		 * 二分查找
		 * 如果找不到返回负数,插入点减一{aa,aabb,aacc}中找"aaa"找不到,但是aaa插入的位置为1,取负数-1,再减一。return -2
		 * 因为在0点插入的话相反数还是0,不知道是找到还是没找到,所以要减一来确保是负数
		 */
		System.out.println(Collections.binarySearch(al, p3));//-3
		//-3，调用Person的CompareTo,按年龄排序,但是前面按照名字来排序了,所以对于年龄来说是乱序的,乱序不能用二分查找
		System.out.println(Collections.binarySearch(al,p3,Person.getCompareByAge()));
		//4，排在第五
		
		/*
		 * 求最值,Person的CompareTo是按照年龄来排序
		 */
		System.out.println(Collections.max(al));//Person ch:23
		System.out.println(Collections.max(al, Person.getCompareByName()));//Person xh:2
		
	}
	public void demo3(){		//倒序
		/*
		 * reverse(List<?> list) 是对列表进行反转
		 * reverseOrder();	reverseOrder(Comparator<?> c);是对排序的顺序进行反转。
		 * Collections.reverseOrder()返回一个实现Comparable的类型的自然排序的反序
		 */
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());//返回<>里面类型的倒序方法的比较器
		ts.add("ee");
		ts.add("ae");
		ts.add("aaaeaa");
		ts.add("ea");
		ts.add("aeea");
		ts.add("eaae");
		System.out.println(ts);	//[aaaeaa, ae, aeea, ea, eaae, ee]
								//[ee, eaae, ea, aeea, ae, aaaeaa]  TreeSet加了Collections.reverseOrder()
		
		Person p1 = new Person("喵了个咪",5);
		Person p2 = new Person("咪了个喵",15);
		Person p3 = new Person("喵咪了个",7);
		Person p4 = new Person("了喵个咪",5);
		TreeSet<Person> tsp = new TreeSet<Person>(Collections.reverseOrder(Person.getCompareByName()));
		//Person实现Comparable接口,按年龄排序。这里的排序方式为按姓名的倒序排序
		tsp.add(p1);
		tsp.add(p2);
		tsp.add(p3);
		tsp.add(p4);
		System.out.println(tsp);//[Person 喵咪了个:7, Person 喵了个咪:5, Person 咪了个喵:15, Person 了喵个咪:5]
		
		/*
		 * replaceAll(List<T> list,T oldKey,T newKey);	//set(indexOf(old),new);
		 * 只能用于list集合和他的子集
		 */
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("cba");
		al.add("cba");
		Collections.replaceAll(al, "cba", "nba");
		System.out.println(al);//[abc, nba, nba]
		/*
		 * shuffle(List<?> list) 使用默认随机源把列表元素的顺序替换
		 */
		Collections.shuffle(al);
		System.out.println(al);//[nba, nba, abc]每次运行结果都不一样
		
		/*
		 * fill(List<? super T> list,T obj)
		 *  把集合list里面的的全部元素都被obj替换
		 */
		Collections.fill(al, "xixi");
		System.out.println(al);//[xixi, xixi, xixi]
	
	}
	public void demo4(){		//给非同步的集合加锁
		//Collections.synchronizedCollection(c);Map,List,Set 返回对应的同步集合
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abc");
		list.add("abcba");
		@SuppressWarnings("unused")
		List<String> synList = Collections.synchronizedList(list);//获得同步的列表
	}
	public void demo5(){		//Arrays工具类,特别是数组转集合Arrays.asList(数组)
		
		/*
		 * Arrays 集合框架的工具类,里面的方法都是静态的,里面的参数全部包含数组
		 * 因为集合里面有各种各样的方法,而数组没有方法。所以Arrays是用来补充数组的方法
		 * 主要方法：	binarySearch();各种重载
		 * 			copyOf();各种重载
		 * 			equals(2个参数);各种重载,不是Objecet类的 
		 * 			sort();各种重载
		 * 			deepEquals();深度比较 ,不仅比较每个元素,还比较每个元素的内容
		 * 			toString(); sop(a[])输出的是地址值  sop(Arrays.toString(a[])); 输出的是a的类型 如果是int 则输出整数而不是地址
		 * 
		 * 			public static <T> List<T> asList(T... a) 把数组转化为List  Arrays
		 * 注意：数组的长度是固定的，所以集合的增删方法是不可以使用的否则会发生UnsupportedOperationException
		 */
		String[] str = {"aa","abc","haha","ddd"};
		List<String> list = Arrays.asList(str);	//Arrays里面没有判断包换元素的方法.
		//list.add("abc");//java.lang.UnsupportedOperationException,数组长度是固定的
		System.out.println(list.contains("abc"));
		
		/*
		 * 如果数组中的元素是对象：那么转成集合时，直接将数组中的元素作为集合中的元素存储
		 * 如果数组中的元素是基本数据类型：那么会将该数组作为集合中的元素进行存储
		 */
		int[] arr = {21,233,44,66};
		List<int[]> newList = Arrays.asList(arr);//[[I@1cf38f09],存的是数组实体,不是存基本数据类型
		System.out.println(newList);
	}
	public void demo6(){		//集合转数组, Collection接口
		
		/*
		 * Object[] toArray();
		 * T<T> toArray(T[]);
		 * 集合转数组,可以对集合中的元素操作的方法进行限定。不允许对其增删
		 */
		Set<String> set = new HashSet<String>();
		set.add("abc");
		set.add("xyz");
		set.add("dsa");

		String[] arr = set.toArray(new String[1]);	//数组长度为5[abc, dsa, xyz, null, null]
													//数组长度小于或等于集合Size会创建同长度的数组[abc, dsa, xyz]
		System.out.println(Arrays.toString(arr));//不用ToString的话会输出[Ljava.lang.String;@10c1c428
	}
	public void demo7(){		//Iterable
		/*
		 * JDK1.5后 Collection继承Iterable,里面只有iterator()方法
		 * 实现这个接口允许对象成为"foreach"语句的目标
		 * 格式：	for(类型 变量 ：Collection集合或数组){
		 * 		}
		 * 
		 * 传统for和增强for的区别：
		 * 传统for可以完成对语句执行很多次,因为可以定义控制循环的增量和条件
		 * 增强for的目标必须是单列集合或者数组
		 * 如果只是获取数组或集合中的元素可以使用高级for，如果要对数组的角标进行操作建议使用传统for
		 */
		List<String> list  = new ArrayList<String>();
		list.add("avc");
		list.add("213");
		list.add("ddd");

		
		//通常只用于遍历,因为不能对元素进行操作
		for(String s : list){		//代替了for(Iterator<T> it = list.iterator();it.hasNext;){}
			System.out.println(s);
		}
		int[] arr = {1,2,4,6,3,5};
		for(int i : arr){
			System.out.println(i);
		}
	}
	public void demo8(){		//求任意个数相加
		
		int sum1 = add(1,2,3,4,5);
		System.out.println("sum1 = "+ sum1);//sum1 = 15
		int sum2 = add();
		System.out.println("sum2 = "+ sum2);//sum2 = 0
		
	}
	public void demo9(){
		/*
		 * 要用到某个类的静态方法,每次都要类名.方法 会很麻烦  例如Collections.sort();Collections.max();
		 * 可以import static java.util.Collections.*; 导入静态成员(方法和变量)
		 * 如果方法名冲突了,类名不能省略(包名不能省略)
		 * improt static java.lang.System.*;  可以out.println(); 因为out是静态成员  println()不是静态成员,
		 * 所以不能省略到print()
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
	public static int add(int... arr){	//int... 代表接收很多int类型的参数,其实也是一个数组,可变参数。创建数组和封装动作内部完成
										//int[] arr 的话一定要先声明了数组然后才能传进来,这样在声明的时候就把长度固定了
		/*
		 * 函数的可变参数，其实就是一个数组,但是接受的是数组的元素,自动将这些元素封装成数组，简化了调用者的书写
		 * 注意：可变参数类型必须定义在参数列表的最后一个
		 * add(int a,int... arr)可以			add(int... arr,inta)不可以
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
		return o2.compareTo(o1);	//倒序	return o1.length()-o2.length();按照字符串长度排序
	}

}

/*
 * Collections	是集合框架的工具类，里面全都是静态方法
 * Arrays
 */
