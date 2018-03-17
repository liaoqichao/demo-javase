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
public void demo1(){				//泛型的使用
		
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
	public void demo2(){				//自定义泛型类
	
		Tool<Person> tool = new Tool<Person>();//改成woker person就用不了
		Person p1 = new Person("张三",19);
		Worker w1 = new Worker("张三",19);
		Worker w2 = new Worker("李四",15);
		tool.setQ(p1);
		tool.setQ(w1);	//Worker继承的Person所以可以
		tool.setQ(w2);
	}	
	public void demo3(){				//自定义泛型方法和自定义泛型接口
		
		//Tool<String> tool = new Tool<String>();
		//tool.show("abc");
		Tool<Integer> tool = new Tool<Integer>();
		tool.setQ(123);
		//tool.setQ("abc");		//只能Integer,没用用泛型确定类型的时候可以,但是有警告
		//泛型方法
		tool.show(134);			//show :134
		tool.show("abx");		//show :abx
		tool.show(new Person());//show :Person@5e3b8219
		
		tool.print(123); 		//不是泛型方法,跟着泛型类的接收类型。tool.print("213");不能接收String
		
		Tool.staShow(123);		//静态方法只能将泛型定义在方法上,不能调用类的泛型
		Tool.staShow("abc");
		
		tool.intershow("lalal");//参数只能是String类型
	}
	public void demo4(){				//泛型的通配符

		
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("xyz");
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(123);
		hs.add(678);
		
		/*	原本需要两个迭代器,但是迭代器的功能都一样
		for(Iterator<String> it = al.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
		for(Iterator<Integer> it = hs.iterator(); it.hasNext();){
			System.out.println(it.next());
		}*/
		
		//printCollection(al);	//一个迭代器,迭代器的类型根据参数而定,把printCollection()里面的extends Person去掉就不会报错
		//printCollection(hs);	
		//如果要求这个方法只打印Person类和它的子类的呢？  类型限定上限
		//如果要求这个方法只打印Person类和它的父类的呢？  类型限定下限

		/*
		 * 通配符例子
		 * containsAll(Collection<?> e) 
		 * 因为containsAll调用的是Object的equals方法,"abc".equals(new Person("p1",10));不同类型也能比较，比较的是地址
		 * 所以参数里面的Collection应该是任意类型 (Object类型) ? 
		 * 一般调用Object的方法的时候用<?>  或者返回一个集合,但是集合不知道是什么类型
		 */
	}
	public void demo5(){				//泛型限定上限例子
		/*
		 * 什么时候用泛型先顶上限? //********需要返回泛型类型的值（对象）时.简单的说就是返回值为泛型的方法可以用
		 * public void fun1(List<? extends Number> list){
		 * 	Number a = list.get(0);	//可以,父类类型得到子类对象，多态！
		 *  lit.add(new Integer(100));//不可以！如果是List<Double> list的话就错了
		 * }
		 */
		ArrayList<Worker> alw = new ArrayList<Worker>();
		alw.add(new Worker("张三",30));
		alw.add(new Worker("李四",20));
		ArrayList<Student> als = new ArrayList<Student>();
		als.add(new Student("喵了个咪",17));
		als.add(new Student("咪了个喵",14));
		ArrayList<Person> alp = new ArrayList<Person>();
		alp.add(new Person("学生です",18));
		alp.add(new Person("ワーカーです",28));
		
		printCollection(alw);
		printCollection(als);
		printCollection(alp);
		
		/*
		 * 泛型限定上限例子： public boolean addAll(Collection<? extends E> e)
		 * 数组列表类型是Person,所以Person和他的子类类型的Collection对象都能作为 addAll的参数
		 * Person类型的集合里面可以加入Student类型的集合里面的所有元素
		 * Person类型的集合里面可以加入Worker类型的集合里面的所有元素
		 */
		ArrayList<Person> alAll = new ArrayList<Person>();
		alAll.addAll(als);
		alAll.addAll(alw);
		alAll.addAll(alp);
		printCollection(alAll);
		
	}
	public void demo6(){				//泛型限定下限例子

		/*
		 * 类型限定下限例子： 构造方法TreeSet(Comparator<? super E> comparator);
		 * 什么时候用下限？	//参使为泛型的方法可以使用
		 * public void fun2(List<? super Integer) list){
		 * 	lit.add(new Integer(100));//调用这个方法的泛型类型都是Integer的父类，所以List<Number>、List<Object>可以add
		 * Number a = list.get(0); //不行！如果List<Object> 使用Number就错了
		 * }
		 * 存什么类型,可以用什么类型接收,也可以用父类型来接收
		 * 比较器是用来比较Person类。Student和Worker也属于Person,也可以用Person的比较规则来比较
		 * 所以Student,Worker类的TreeSet可以用本类型的比较器,也可以用父类的比较器
		 */
		
		TreeSet<Person> tsp = new TreeSet<Person>(Person.getCompareByAge());//这个比较器是用来比较Person类型的
		tsp.add(new Person("p1",17));
		tsp.add(new Person("p2",14));
		
		/*
		 * CompareByAge<Person> compareByAge = new CompareByAge<Person>(); 
		 * TreeSet<Worker> tsw = new TreeSet<Worker>(compareByAge);
		 * 这里的类型是worker,但是比较器的类型是Person
		 * class TreeSet<Worker>{
		 *  TreeSet(Comparator<? super Worker> comparator);	//本类型或者父类类型的比较器都可以用
		 *  //为什么不直接Comparator<? super Person> comparator
		 *  //因为这个TreeSet的类型是Worker不是Person
		 *  }
		 */
		TreeSet<Worker> tsw = new TreeSet<Worker>(Person.getCompareByAge());//虽然这个比较器是用来比较Person类型.但是TreeSet的构造函数
		tsw.add(new Worker("w1",22));					 //让比较器是Worker类型或者它的父类Person类型都可以用
		tsw.add(new Worker("w2",40));					 //泛型限定下限： <? super E>  这里的E是Worker
														 //所以Person类的比较器也可以用
		TreeSet<Student> tss = new TreeSet<Student>(Person.getCompareByAge());
		tss.add(new Student("s1",16));
		tss.add(new Student("s2",13));
		
		printCollection(tsp);
		printCollection(tsw);
		printCollection(tss);
		

	}
	private void printCollection(Collection<? extends Person> al) {		//泛型的通配符   ?。Person类和Person类的子类
		/*						(Collection<? super Student> al)		//Student类和Student类的父类
		 * 泛型的通配符   ?	未知类型
		 * 当不明确类型的时候可以用问号来表示
		 * 在<>里面 继承需要的类的父类,来限定传入的类型  
		 * private void printCollection(Collection<? extends Person> al) 
		 * ? 表示某个类型但不确定, 这个类型继承Person或者Person的子类， 
		 * 
		 * 也可以写成 private <T> void printCollection(Collection<T> al)
		 * 		for(Iterator<T> it = al.iterator(); it.hasNext();){
		 * 			T str = it.next();		//但是如果用问号不能  ? str = it.next();
		 * 									//T可以进行操作  T t = it.next(); return t;  
		 *			System.out.println(str);
		 *		}
		 *<? extends E>来限定接收类型为E或者子类的对象。上限  类型限定完后就可以用父类的方法
		 *<? super E>来限定接收E类型或者E类型的父类的对象。下限
		 * 一般定义存储的时候 用<? extends E>  例如 集合里面的addAll(Collection<? extends E>)
		 *  因为这样取出都是按照上限来取的，不会出现类型隐患(类型转换异常)
		 */
		
		for(Iterator<?> it = al.iterator(); it.hasNext();){
			Person p = (Person)it.next(	);
			System.out.println(p.getClass().getName()+"  "+p.getName()+":"+p.getAge());
		}
	}

}

class Tool<QQ> implements Inter<String>{		//自定义泛型类泛型类
	//这里的QQ代表的是某一种类型。
	private QQ q ;

	public QQ getQ() {
		return q;
	}

	public void setQ(QQ q) {
		this.q = q;
	}
	
	/*
	 * 泛型函数
	 * 逻辑方法相同,数据类型不同，可以使用泛型函数。
	 */
	public <WW> void show(WW w){			//<WW> 要在void 前面
		//<WW>表示它是泛型函数。WW w表示它接收的参数类型是WW。参数类型要和<>里面的一样
		System.out.println("show :"+w);
	}
	public void print(QQ q){				//这个跟着类的接收类型
		System.out.println("show :"+q);
	}
	public static <WW> void staShow(WW w){	//静态方法不能使用类上定义的泛型,只能将泛型定义在方法上
//		public  static void staShow(QQ q)	//错误。
		System.out.println("static show :"+w);
	}
	public void intershow(String str){		//这里的String要根据实现泛型接口的接收类型
		System.out.println("interface show :"+str);
	}
}
interface Inter<T>{
	
	public abstract void intershow(T t);
}


