package demo.collectionFreamwork.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import demo.collectionFreamwork.CollectionFreamwork;

public class ListDemo implements CollectionFreamwork {
	/**
	 * List : 元素是有序的,而且可以重复,因为该集合体系有索引(下标)
	 * Set	： 元素是无序的,而且不可以重复,该集合没有索引
	 * 
	 * ArrayList:	底层数据结构使用的是数组结构。特点：有编号，查询速度快,修改快(查到就可以改);但是增删慢。线程不同步
	 * 				默认初始容量为10，当放入的元素超过10,则会new一个长度为原来150%的数组，把原来的元素COPY到新数组,然后再加入新元素
	 * 				可变长度。而数组长度不可变
	 * LinkList:	底层使用的是链表结构。特点：增删快,改查慢
	 * Vector:		此层使用的是数组数据结构。ArrayList是JDK1.2才有的,Vector是JDK1.0就有的,那时候还没有集合框架
	 * 				JDK1.2后Vector加入集合框架。线程同步。已经被ArrayList替代
	 * 				Vector中的枚举Enumeration 相当于迭代器 Iterator 。枚举和迭代重复,迭代有新功能remove();迭代的方法名称较短
	 */

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();

	}
public void demo1(){
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("e1");
		al.add("e2");
		al.add("e3");
		al.add("e4");
		System.out.println(al);
		
		al.add(2, "newE");								//增,在e2和e3之间加入.  newE的下标为2
		System.out.println(al);
		
		al.remove(3);									//删
		System.out.println(al);
			
		al.set(1,"setE2");								//改
		System.out.println(al);
									
		System.out.println("al.get(3) = " + al.get(3));	//查,不修改al
		
		for(int i = 0 ; i < al.size() ; i++){			//查,遍历元素,不需要用迭代器
			System.out.println("al("+i+") = "+al.get(i));
		}
		
		for(Iterator<String> it = al.iterator() ; it.hasNext();){//通过迭代器遍历元素
			System.out.println(it.next());
			//it = al.iterater(); 让迭代器回到原点
		}
		
		System.out.println("e3的位置为 :" + al.indexOf("e3"));	//不在,-1
		
		List<String > sub = al.subList(1, 3);				//包括1不包括3
		System.out.println("sub = "+sub);
		
	}
	public void demo2(){									//listIterator
		/*
		 * ListIterator<E> lt = al.listIterator();
		 * 可以实现列表在遍历中的增删改查, 用Iterator会出现并发错误
		 */
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("e1");
		al.add("e2");
		al.add("e3");
		al.add("e4");
		System.out.println(al);
		/*
		 * for(Iterator<String> it = al.iterator;it.hasNext();){
		 * 		Object obj  = it.next();
		 * 		if(obj = "e4")
		 * 			al.add("e2Partner");	//报错,并发访问.迭代器it操作元素的同时al也操作元素，在声明it的时候,it已经知道元素
		 * 									//的个数,如果后面增加的话，it知道的元素个数就和实际不一样。
		 * 									//所以不能同时用迭代器和ArrayList的方法,迭代器只有判断,取出和移除3个方法,做不了添加动作
		 * 									//ListIterator继承Iterator,扩展了Iterator的功能
		 * 		sop("obj = "+obj);			//obj=e1;obj=e2;报错
		 * }
		 */
		for(ListIterator<String> lt = al.listIterator();lt.hasNext();){
			//hasPrevious()逆向遍历   lt.previous();取前一个元素

			Object obj = lt.next();
			if(obj == "e2"){
				//lt.add("e2Partner");			
				lt.set("changed");			//只能修改后增加,不能增加后修改
				lt.add("e2Partner");
			}
			System.out.println("obj = "+obj);
		}
		System.out.println(al);
		
	}

}
/*
 * 有index都是List特有的方法,因为List是有序的
 * add(int index,element e); 					列表可以在指定位置加入元素
 * get(int index);								通过索引返回元素
 * indexOf(Object o);							判断元素的位置,第一次出现 。lastInexOf(Object o) 判断最后一次出现的位置
 * remove(int index);							按照位置移除,Collection的是按照对象移除
 * set(index,e);								替换指定位置的元素
 * sublist(fromIndex,toIndex);					返回fromIndex(包括),toIndex(不包括)之间的List对象
 * 
 */

