package demo.collectionFreamwork.collection;

import java.util.ArrayList;
import java.util.Iterator;

import demo.collectionFreamwork.CollectionFreamwork;

public class CollectionDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub

		//demo1();
		//demo2();
	}

	public void demo1() {				//Collection框架的共性方法,Collection根接口的方法
		// TODO Auto-generated method stub
		//新建容器
		ArrayList<String> al = new ArrayList<String>();		//增 add(Object e);addAll(Collection c);
		ArrayList<String> al1 = new ArrayList<String>();
		//增加元素
		al.add("e1");//堆里面集合存的不是对象,是对象的地址				//删clear();清空    remove(o);移除一个,  remove(c);移除一个集合的元素
		al.add("e2");										//retainAll(c)求交集,contain(e);containAll(c);判断包涵,isEmpty()判断空,size();元素个数
		al.add("e3");										//toArray();返回集合中包涵元素的数组
															//iterator 迭代器,取出
		al1.add("e2");
		al1.add("e3");
		al1.add("e4");
		al1.add("e5");
		//获取元素个数
		sop("size = "+al.size());
		
		//打印
		sop("原集合"+al);										//[e1, e2, e3]
		
		//删除元素
		al.remove("e2");
		sop("删除一个元素后的集合"+al);
		//al.clear();
		//sop("clear(); "+al);
		
		//判断元素
		sop("al.contains(\"e3\") : "+al.contains("e3"));
		sop("isEmpty() : "+al.isEmpty());
		
		al.retainAll(al1);									//求交集
		sop("al : "+al);									//集合元素变化，al元素从e1,e3变成只有交集的元素e3
		sop("al1 : "+al1);									//集合元素没有变化
		
	}

	public void demo2() {				//Collection根接口的方法 迭代器 iterator
		// TODO Auto-generated method stub
		/*
		 * public interface Iterator<E> 取出集合的元素,返回的是泛型里面写的类型(Integer，String,Person)
		 * 迭代器就是取出集合元素的方式
		 * 方法摘要:
		 * 1.hasNext();		如果有元素可以迭代则返回true
		 * 2.next();		返回迭代的下一个元素
		 * 3.remove();		从迭代器指向的c中移除迭代器返回的最后一个元素
		 */
		ArrayList<String> al = new ArrayList<String>();
		al.add("e1");
		al.add("e2");
		al.add("e3");
		al.add("e4");
		al.add("e5");
		
		Iterator<String> it = al.iterator();				//这里泛型的类型要和ArrayList的类型保持一致
		while(it.hasNext()){								//判断迭代器指向的元素,没有指向返回false
			System.out.print(it.next()+" ");				//返回迭代器指向collection的元素
		}	
		System.out.println();
		it = al.iterator();									//覆盖之前的it,让迭代器回到原点
		for(int i = 0 ; i < 3 ; i++){
			it.next();	//i=0,it->e1;i=1,it->t2;i=2,it->e3;i=3跳出循环
		}
		it.remove();	//除去e3，这个是按照元素的位置来移除元素,collection.remove是按照对象来移除元素
		sop(al);
		/*
		 * for代替while while里面的it 还在内存中,for循环结束后it就释放内存
		 * for(Iterator it = al.iterator();it.hasNext;)
		 * 		sop(it.next());
		 */
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}

}
