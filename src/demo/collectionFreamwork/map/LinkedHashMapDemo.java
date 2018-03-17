package demo.collectionFreamwork.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import demo.collectionFreamwork.CollectionFreamwork;

public class LinkedHashMapDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();

	}
	public void demo1(){
		/*
		 * 有序是指什么顺序存入就什么顺序取出。
		 * 按大小的叫排序不叫有序
		 */
		LinkedHashMap<Integer,String> lhm = new LinkedHashMap<Integer,String>();
		
		lhm.put(2, "v1");//key唯一,被后面的(2,v3)取代
		lhm.put(2, "v3");
		lhm.put(4, "v2");
		lhm.put(3, "v4");
		lhm.put(1, "v2");
		
		for(Iterator<Map.Entry<Integer,String>> it = lhm.entrySet().iterator();it.hasNext();){
			
			Map.Entry<Integer, String> me = it.next();
			System.out.println(me.getKey()+" : "+me.getValue());
			
		}
	}


}
