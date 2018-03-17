package demo.collectionFreamwork.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import demo.collectionFreamwork.CollectionFreamwork;

public class MapDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		
		//demo1();
		//demo2();

	}
public void demo1(){				//Map的增删判断获取
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		//添加
		System.out.println(map.put(1, "v1"));	//输出null
		System.out.println(map.put(1, "v2"));	//输出v1
		System.out.println(map.put(2, "v2"));	//输出null
		System.out.println(map.put(3, "v3"));	//输出null
		System.out.println(map);				//输出{1=v2, 2=v2,3=v3} 无序的。顺序变了,依然这个顺序
		//key的存储方式和哈希表一样
		
		//删除
		System.out.println("remove(key) : "+map.remove(2));//remove(key) : v2
		
		//判断
		System.out.println("contains(key) : "+map.containsKey(2));//false
		System.out.println("contains(value) : "+map.containsValue("v3"));//true
		
		//获取
		System.out.println("get(key) : "+map.get(1));//v2
	}
	public void demo2(){				//Map的遍历
		/*
		 * 
		 * 1.通过遍历键来遍历值。
		 * 	先通过Set keySet();方法获取所有的键,返回Set集合,再根据迭代器获取每个键,用get(key)方法获取对应的值
		 * 		因为key是唯一的,所以返回Set集合
		 *  Map.KEY-> Set ->iterator : key = it.next()->map.get(key) 
		 * 2.通过遍历键值对关系来遍历键和遍历值
		 * 	Set <Map.Entry<K,V> entrySet()  Map.Entry为键值关系类型,是Map的内部的静态接口
		 * 	将键值的映射关系存到Set集合中,这个映射关系的类型是Map.Entry
		 * 	通过迭代器获取每个映射关系  Map.Entry<Integer,String> me = it.next();
		 *  这个映射关系对象里面有获取key和value的方法 .  me.getKey(); me.getValue();
		 * 3.通过遍历值来遍历值
		 * Collection<V> values(); 这样就没有体现出键值映射关系.
		 * 虽然键唯一,但值不一定唯一,所以用Collection类
		 */
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(2, "v1");
		map.put(1, "v4");
		map.put(3, "v3");
		map.put(4, "v2");
		
		System.out.println("通过Set keySet()方法完成Map的遍历");
		Set<Integer> keySet = map.keySet();
		
		for(Iterator<Integer> it = keySet.iterator();it.hasNext();){
			Integer key = it.next();
			String value = map.get(key);
			System.out.println("key = "+key+"  , value = "+value);
		}
		/*
		 * key = 1  , value = v4
		 * key = 2  , value = v1
		 * key = 3  , value = v3
		 * key = 4  , value = v2
		 */
		
		System.out.println("通过Set<Map.Entry<K,Y> entrySet()方法完成Map的遍历");
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for(Iterator<Map.Entry<Integer, String>> it = entrySet.iterator(); it.hasNext();){
			Map.Entry<Integer, String> me = it.next();
			System.out.println("key = "+me.getKey()+" , value = "+me.getValue());
		}
		
		System.out.println("通过Collection<V> values()方法完成Map的遍历");
		Collection<String> valueSet = map.values();
		for(Iterator<String> it = valueSet.iterator();it.hasNext();){
			String value = it.next();
			System.out.println("value = "+value);
		}
	}
	
}
/*
 * Map<K,V>一次添加一对元素，也称为双列集合;Collection一次添加一个元素,也称单列集合。其实map集合存的就是键值对.
 * 键：你要存的值的编号	值：你要存放的数据	通过键来取值。
 * 一个映射不能包含重复的键,每个键最多只能映射到一个值。
 * 
 * 常用方法：
 * 1.添加
 * 	Value put(key,value);返回前一个和key关联的值,如果没有返回空		原来<k1,v1> put(k1,v2)后  k1映射v2, 函数返回值为v1
 * 2.删除
 * clear();
 * Value remove(key);	根据指定的key删除这个键值对
 * 3.判断
 * boolean containsKey(key);	键值对集合有这个键吗
 * boolean containsValue(value);键值对集合有这个值吗
 * isEmpty();					键值对集合为空吗
 * 4.获取
 * Value get(key);		通过键拿值,没有这个该键则返回null
 * int size();			获取键值对个数
 * 
 * Map的常用子类：
 * |--HashTable	：内部结构为哈希表,那时候还没集合框架。 单列集合只有Vector,双列结构只有HashTable。同步。不允许null作为键和值
 * 		|--Properties:用来存储键值对型的配置文件信息。可以和I/O技术相结合。
 * |--HashMap	：内部结构哈希表。不同步。允许null作为键和值
 * |--TreeMap	：内部结二叉树。不同步。可以对对Map中的键进行排序
 */

