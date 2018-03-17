package demo.collectionFreamwork.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import demo.collectionFreamwork.CollectionFreamwork;
import demo.collectionFreamwork.example.Person;

public class TreeSetDemo implements CollectionFreamwork {
	/**
	 * TreeSet 可以对Set中的元素进行排序
	 * 元素要implements Comparable 实现public int compareTo()方法，让元素具有可比性,否则ts.add(obj)会出错
	 * 比较时主要条件相同要比较次要条件.一定要次要条件
	 * TreeSet：底层数据结构是先序遍历的平衡二叉树，可以对集合中的元素进行排序
	 * 通过元素的compareTo()方法来判断元素是否相同，为0则相同,不为0则不相同，和哈希值没关系
	 * 
	 * TreeSet排序的第一种方式：让元素自身具备比较性。元素实现Comparable接口，覆盖public int compareTo()方法。
	 * 					  这种方式称为元素的自然顺序或者元素的默认顺序。
	 * TreeSet排序的第二种方式：当元素不具备比较性或者具备的比较性不是所需要的,需要改变比较规则(按年龄排序变成按名称排序)。这时
	 * 					这时候需要让集合自身具备比较性。在集合初始化时就有了比较方式。这时需要定义比较器Comparator，
	 * 					让比较器作为TreeSet的参数.
	 * 					如果两种方式都有按照比较器的规则排序
	 * Comparator中有2个方法：1.int compare(T o1,T o2)  2. boolean equals(o);
	 */

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();

	}
public void demo1(){			//TreeSet的元素一定要有可比性,不然不知道顺序
		
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
		 * e6,e61,ea1,eb3,ec4,ed2,ee5 根据ASCII码来排序
		 */
	}
	public void demo2(){			//TreeSet存储自定义类型
		
		/*
		 * 按照年龄进行排序
		 * 元素存入顺序和取出顺序一样，元素compareTo方法return 1;
		 */
		TreeSet<Person> ts = new TreeSet<Person>();

		/*
		 * ts.add(new Person("lisi02",22));
		 * Exception in thread "main" java.lang.ClassCastException: Person cannot be cast to java.lang.Comparable
		 * 需要对对象进行排序.然而Person没有排序的依据。所以Person类要实现Comparable<Object>接口，
		 * 实现public int compareTo(Object o)函数,函数名不能抛出异常,因为抽象方法那里没有抛出异常
		 */
		
		ts.add(new Person("lisi09",20));
		ts.add(new Person("lisi09",19));			
		ts.add(new Person("lisi01",40));
		ts.add(new Person("lisi02",40));	
		/* old data
		ts.add(new Person("lisi02",22));
		ts.add(new Person("lisi007",20));
		ts.add(new Person("lisi09",19));
		ts.add(new Person("lisi09",19));			//视为重复元素没进来
		ts.add(new Person("lisi01",40));
		ts.add(new Person("lisi02",40));			//排序时当主要条件相同时,要比较次要条件,次要条件也相同才判断为同一元素
		*/
		/*
		 * lisi02::22..compareTo..lisi02::22		//所以只有1句ts.add()也报错,视频中要2句ts.add()才报错
		 * lisi007::20..compareTo..lisi02::22
		 * lisi09::19..compareTo..lisi02::22
		 * lisi09::19..compareTo..lisi007::20
		 * lisi01::40..compareTo..lisi007::20
		 * lisi01::40..compareTo..lisi02::22
		 */
		
		for(Iterator<Person> it = ts.iterator();it.hasNext();){
			Person person = it.next();
			//System.out.println(person);//这里也调用了hashCode
			System.out.println(person.getName()+"::"+person.getAge());
		}
		/*
		 * lisi09::19...hashCode	System.out.println(person); 这里也调用了hashCode,
		 * Person@be48e0c1			但是不是Person类的hashCode,然后输出地址
		 * lisi007::20...hashCode
		 * Person@ad2dfd0
		 * lisi02::22...hashCode
		 * Person@be48e12f
		 * lisi01::40...hashCode
		 * Person@be48e3ec
		 * 已经根据年龄排序
		 */
	}
	public void demo3(){			//按照姓名排序,用Comparator
		
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
	public void demo4(){			//往TreeSet里面存字符串，按字符串长度排序
		
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
