package demo.collectionFreamwork.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import demo.collectionFreamwork.CollectionFreamwork;
import demo.collectionFreamwork.example.*;

public class TreeMapDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
public void demo1(){
		
		/*
		 * 将学生对象和学生归属地通过键和值存储到Map中，并按照学生的名字来排序
		 * 因为Person类实现了Comparable方法,所以Student具有可比性.
		 * 键要有可比性。
		 */
		//按照年龄排序,Person实现的Comparable方法
		System.out.println("按照年龄排序");
		TreeMap<Student,String> tm = new TreeMap<Student,String>();
		tm.put(new Student("张三",15), "北京");
		tm.put(new Student("张三",17), "上海");
		tm.put(new Student("李四",15), "北京");
		tm.put(new Student("李四",15), "深圳");
		tm.put(new Student("王五",16), "深圳");
		
		for(Iterator<Map.Entry<Student,String>> it = tm.entrySet().iterator();it.hasNext();){
			Map.Entry<Student, String> me = it.next();
			System.out.println(me.getKey()+" : "+me.getValue());
		}
		//按照姓名排序,实现比较器
		System.out.println("按照姓名排序");
		TreeMap<Student,String> tm1 = new TreeMap<Student,String>(Person.getCompareByName());
		tm1.put(new Student("张三",15), "北京");
		tm1.put(new Student("张三",17), "上海");
		tm1.put(new Student("李四",15), "北京");
		tm1.put(new Student("李四",15), "深圳");
		tm1.put(new Student("王五",16), "深圳");
		for(Iterator<Map.Entry<Student,String>> it = tm1.entrySet().iterator();it.hasNext();){
			Map.Entry<Student, String> me = it.next();
			System.out.println(me.getKey()+" : "+me.getValue());
		}
		
	}

}

