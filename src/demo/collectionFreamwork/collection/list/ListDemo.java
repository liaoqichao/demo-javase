package demo.collectionFreamwork.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import demo.collectionFreamwork.CollectionFreamwork;

public class ListDemo implements CollectionFreamwork {
	/**
	 * List : Ԫ���������,���ҿ����ظ�,��Ϊ�ü�����ϵ������(�±�)
	 * Set	�� Ԫ���������,���Ҳ������ظ�,�ü���û������
	 * 
	 * ArrayList:	�ײ����ݽṹʹ�õ�������ṹ���ص㣺�б�ţ���ѯ�ٶȿ�,�޸Ŀ�(�鵽�Ϳ��Ը�);������ɾ�����̲߳�ͬ��
	 * 				Ĭ�ϳ�ʼ����Ϊ10���������Ԫ�س���10,���newһ������Ϊԭ��150%�����飬��ԭ����Ԫ��COPY��������,Ȼ���ټ�����Ԫ��
	 * 				�ɱ䳤�ȡ������鳤�Ȳ��ɱ�
	 * LinkList:	�ײ�ʹ�õ�������ṹ���ص㣺��ɾ��,�Ĳ���
	 * Vector:		�˲�ʹ�õ����������ݽṹ��ArrayList��JDK1.2���е�,Vector��JDK1.0���е�,��ʱ��û�м��Ͽ��
	 * 				JDK1.2��Vector���뼯�Ͽ�ܡ��߳�ͬ�����Ѿ���ArrayList���
	 * 				Vector�е�ö��Enumeration �൱�ڵ����� Iterator ��ö�ٺ͵����ظ�,�������¹���remove();�����ķ������ƽ϶�
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
		
		al.add(2, "newE");								//��,��e2��e3֮�����.  newE���±�Ϊ2
		System.out.println(al);
		
		al.remove(3);									//ɾ
		System.out.println(al);
			
		al.set(1,"setE2");								//��
		System.out.println(al);
									
		System.out.println("al.get(3) = " + al.get(3));	//��,���޸�al
		
		for(int i = 0 ; i < al.size() ; i++){			//��,����Ԫ��,����Ҫ�õ�����
			System.out.println("al("+i+") = "+al.get(i));
		}
		
		for(Iterator<String> it = al.iterator() ; it.hasNext();){//ͨ������������Ԫ��
			System.out.println(it.next());
			//it = al.iterater(); �õ������ص�ԭ��
		}
		
		System.out.println("e3��λ��Ϊ :" + al.indexOf("e3"));	//����,-1
		
		List<String > sub = al.subList(1, 3);				//����1������3
		System.out.println("sub = "+sub);
		
	}
	public void demo2(){									//listIterator
		/*
		 * ListIterator<E> lt = al.listIterator();
		 * ����ʵ���б��ڱ����е���ɾ�Ĳ�, ��Iterator����ֲ�������
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
		 * 			al.add("e2Partner");	//����,��������.������it����Ԫ�ص�ͬʱalҲ����Ԫ�أ�������it��ʱ��,it�Ѿ�֪��Ԫ��
		 * 									//�ĸ���,����������ӵĻ���it֪����Ԫ�ظ����ͺ�ʵ�ʲ�һ����
		 * 									//���Բ���ͬʱ�õ�������ArrayList�ķ���,������ֻ���ж�,ȡ�����Ƴ�3������,��������Ӷ���
		 * 									//ListIterator�̳�Iterator,��չ��Iterator�Ĺ���
		 * 		sop("obj = "+obj);			//obj=e1;obj=e2;����
		 * }
		 */
		for(ListIterator<String> lt = al.listIterator();lt.hasNext();){
			//hasPrevious()�������   lt.previous();ȡǰһ��Ԫ��

			Object obj = lt.next();
			if(obj == "e2"){
				//lt.add("e2Partner");			
				lt.set("changed");			//ֻ���޸ĺ�����,�������Ӻ��޸�
				lt.add("e2Partner");
			}
			System.out.println("obj = "+obj);
		}
		System.out.println(al);
		
	}

}
/*
 * ��index����List���еķ���,��ΪList�������
 * add(int index,element e); 					�б������ָ��λ�ü���Ԫ��
 * get(int index);								ͨ����������Ԫ��
 * indexOf(Object o);							�ж�Ԫ�ص�λ��,��һ�γ��� ��lastInexOf(Object o) �ж����һ�γ��ֵ�λ��
 * remove(int index);							����λ���Ƴ�,Collection���ǰ��ն����Ƴ�
 * set(index,e);								�滻ָ��λ�õ�Ԫ��
 * sublist(fromIndex,toIndex);					����fromIndex(����),toIndex(������)֮���List����
 * 
 */

