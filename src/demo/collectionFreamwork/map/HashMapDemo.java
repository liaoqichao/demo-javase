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
		 * ��ѧ�������ѧ��������ͨ������ֵ�洢��Map��
		 */
	HashMap<Student,String> hm = new HashMap<Student,String>();
	hm.put(new Student("����",15), "����");
	hm.put(new Student("����",17), "�Ϻ�");
	hm.put(new Student("����",15), "����");
	hm.put(new Student("����",15), "����");
	hm.put(new Student("����",16), "����");
	
	Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
	for(Iterator<Map.Entry<Student,String>> it = entrySet.iterator();it.hasNext();){
		Map.Entry<Student, String> me = it.next();
		System.out.println(me.getKey()+" : "+me.getValue());//��Ψһ,StudentΨһ,���ֻ��4�����ɵ����ı��滻��
															//��ΪStudentΨһ�ı�׼�ӵ�ַ������������䶼��ͬ
	}
}
	public void demo2(){
		/*
		 * ��ȡ�ַ�����"t1q1uua1taubuta%aq%buut@qutu"��ÿ����ĸ�ĳ��ִ���,ֻҪ��ĸ��Ҫ�ַ�
		 * map��������  �������������ڼ�,���Ӣ�����ڼ���map.put("����һ","Mon");
		 * map.put("һ��",Set<Students>); 
		 * map.put("����",Set<Students>); 
		 */
		
		String s = "t1q1uua1taubuta%aq%buut@qutu";//q-3,b-2,t-5,a-4,u-8,1-3,%-2,@-1
		/*
		 * ���������	1. 	һ����ĸ����,��Map��,��ֵ��1,����Map�������Map
		 * 			2.	һ�����һ���ַ��ĳ��ִ���,����ټӽ�Map��
		 */
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
	
			/*
			 * ����put����,�ظ��������ȡ
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


