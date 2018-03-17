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
public void demo1(){				//Map����ɾ�жϻ�ȡ
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		//���
		System.out.println(map.put(1, "v1"));	//���null
		System.out.println(map.put(1, "v2"));	//���v1
		System.out.println(map.put(2, "v2"));	//���null
		System.out.println(map.put(3, "v3"));	//���null
		System.out.println(map);				//���{1=v2, 2=v2,3=v3} ����ġ�˳�����,��Ȼ���˳��
		//key�Ĵ洢��ʽ�͹�ϣ��һ��
		
		//ɾ��
		System.out.println("remove(key) : "+map.remove(2));//remove(key) : v2
		
		//�ж�
		System.out.println("contains(key) : "+map.containsKey(2));//false
		System.out.println("contains(value) : "+map.containsValue("v3"));//true
		
		//��ȡ
		System.out.println("get(key) : "+map.get(1));//v2
	}
	public void demo2(){				//Map�ı���
		/*
		 * 
		 * 1.ͨ��������������ֵ��
		 * 	��ͨ��Set keySet();������ȡ���еļ�,����Set����,�ٸ��ݵ�������ȡÿ����,��get(key)������ȡ��Ӧ��ֵ
		 * 		��Ϊkey��Ψһ��,���Է���Set����
		 *  Map.KEY-> Set ->iterator : key = it.next()->map.get(key) 
		 * 2.ͨ��������ֵ�Թ�ϵ���������ͱ���ֵ
		 * 	Set <Map.Entry<K,V> entrySet()  Map.EntryΪ��ֵ��ϵ����,��Map���ڲ��ľ�̬�ӿ�
		 * 	����ֵ��ӳ���ϵ�浽Set������,���ӳ���ϵ��������Map.Entry
		 * 	ͨ����������ȡÿ��ӳ���ϵ  Map.Entry<Integer,String> me = it.next();
		 *  ���ӳ���ϵ���������л�ȡkey��value�ķ��� .  me.getKey(); me.getValue();
		 * 3.ͨ������ֵ������ֵ
		 * Collection<V> values(); ������û�����ֳ���ֵӳ���ϵ.
		 * ��Ȼ��Ψһ,��ֵ��һ��Ψһ,������Collection��
		 */
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(2, "v1");
		map.put(1, "v4");
		map.put(3, "v3");
		map.put(4, "v2");
		
		System.out.println("ͨ��Set keySet()�������Map�ı���");
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
		
		System.out.println("ͨ��Set<Map.Entry<K,Y> entrySet()�������Map�ı���");
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for(Iterator<Map.Entry<Integer, String>> it = entrySet.iterator(); it.hasNext();){
			Map.Entry<Integer, String> me = it.next();
			System.out.println("key = "+me.getKey()+" , value = "+me.getValue());
		}
		
		System.out.println("ͨ��Collection<V> values()�������Map�ı���");
		Collection<String> valueSet = map.values();
		for(Iterator<String> it = valueSet.iterator();it.hasNext();){
			String value = it.next();
			System.out.println("value = "+value);
		}
	}
	
}
/*
 * Map<K,V>һ�����һ��Ԫ�أ�Ҳ��Ϊ˫�м���;Collectionһ�����һ��Ԫ��,Ҳ�Ƶ��м��ϡ���ʵmap���ϴ�ľ��Ǽ�ֵ��.
 * ������Ҫ���ֵ�ı��	ֵ����Ҫ��ŵ�����	ͨ������ȡֵ��
 * һ��ӳ�䲻�ܰ����ظ��ļ�,ÿ�������ֻ��ӳ�䵽һ��ֵ��
 * 
 * ���÷�����
 * 1.���
 * 	Value put(key,value);����ǰһ����key������ֵ,���û�з��ؿ�		ԭ��<k1,v1> put(k1,v2)��  k1ӳ��v2, ��������ֵΪv1
 * 2.ɾ��
 * clear();
 * Value remove(key);	����ָ����keyɾ�������ֵ��
 * 3.�ж�
 * boolean containsKey(key);	��ֵ�Լ������������
 * boolean containsValue(value);��ֵ�Լ��������ֵ��
 * isEmpty();					��ֵ�Լ���Ϊ����
 * 4.��ȡ
 * Value get(key);		ͨ������ֵ,û������ü��򷵻�null
 * int size();			��ȡ��ֵ�Ը���
 * 
 * Map�ĳ������ࣺ
 * |--HashTable	���ڲ��ṹΪ��ϣ��,��ʱ��û���Ͽ�ܡ� ���м���ֻ��Vector,˫�нṹֻ��HashTable��ͬ����������null��Ϊ����ֵ
 * 		|--Properties:�����洢��ֵ���͵������ļ���Ϣ�����Ժ�I/O�������ϡ�
 * |--HashMap	���ڲ��ṹ��ϣ����ͬ��������null��Ϊ����ֵ
 * |--TreeMap	���ڲ������������ͬ�������ԶԶ�Map�еļ���������
 */

