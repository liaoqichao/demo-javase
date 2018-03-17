package demo.collectionFreamwork.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import demo.collectionFreamwork.example.*;

import demo.collectionFreamwork.CollectionFreamwork;

public class HashMapDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();

	}
	public void demo1(){
		/*
		 * 将学生对象和学生归属地通过键和值存储到Map中
		 */
	HashMap<Student,String> hm = new HashMap<Student,String>();
	hm.put(new Student("张三",15), "北京");
	hm.put(new Student("张三",17), "上海");
	hm.put(new Student("李四",15), "北京");
	hm.put(new Student("李四",15), "深圳");
	hm.put(new Student("王五",16), "深圳");
	
	Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
	for(Iterator<Map.Entry<Student,String>> it = entrySet.iterator();it.hasNext();){
		Map.Entry<Student, String> me = it.next();
		System.out.println(me.getKey()+" : "+me.getValue());//键唯一,Student唯一,输出只有4个，旧的李四被替换了
															//因为Student唯一的标准从地址变成姓名和年龄都相同
	}
}
	public void demo2(){
		/*
		 * 获取字符串中"t1q1uua1taubuta%aq%buut@qutu"中每个字母的出现次数,只要字母不要字符
		 * map常用与查表法  如输入中文星期几,输出英语星期几。map.put("星期一","Mon");
		 * map.put("一班",Set<Students>); 
		 * map.put("二班",Set<Students>); 
		 */
		
		String s = "t1q1uua1taubuta%aq%buut@qutu";//q-3,b-2,t-5,a-4,u-8,1-3,%-2,@-1
		/*
		 * 解决方法：	1. 	一个字母出现,在Map中,则值加1,不在Map中则进入Map
		 * 			2.	一次算出一个字符的出现次数,最后再加进Map中
		 */
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
	
			/*
			 * 都有put操作,重复则可以提取
			if(c>='a'&&c<='z' ||  c>='A'&&c<='Z'){
				if(hm.containsKey(c)){
					int value = hm.get(c)+1;
					hm.put(c, value);
				}
				else{
					hm.put(c, 1);
				}
			}*/
			if(c>='a'&&c<='z' ||  c>='A'&&c<='Z'){
				int value = 1;
				if(hm.containsKey(c))
					value = hm.get(c)+1;
				hm.put(c, value);
			}
		}
		
		for(Iterator<Map.Entry<Character, Integer>> it = hm.entrySet().iterator(); it.hasNext();){
			Map.Entry<Character, Integer> em = it.next();
			System.out.println(em.getKey()+"("+em.getValue()+")");
		}
	}
}


