package demo.collectionFreamwork.collection.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

import demo.collectionFreamwork.CollectionFreamwork;

public class LinkedHashSetDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();

	}
	public void demo1(){
		
		//按照顺序加入就按照顺序取出..有序的set
		 LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		 lhs.add("xyz");
		 lhs.add("qwe");
		 lhs.add("qwer");
		 lhs.add("xba");
		 lhs.add("abc");
		 lhs.add("abc");
		 
		 for(Iterator<String> it = lhs.iterator();it.hasNext();){
			 String str = it.next();
			 System.out.println(str);
		 }
		
	}
	
//	@Test
//	public void testDemo1(){
//		demo1();
//	}
}
/*
 * LinkedHashSet 具有可预知的迭代顺序的Set接口的哈希表和链表实现。
 */