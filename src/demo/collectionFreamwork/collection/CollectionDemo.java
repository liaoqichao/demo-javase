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

	public void demo1() {				//Collection��ܵĹ��Է���,Collection���ӿڵķ���
		// TODO Auto-generated method stub
		//�½�����
		ArrayList<String> al = new ArrayList<String>();		//�� add(Object e);addAll(Collection c);
		ArrayList<String> al1 = new ArrayList<String>();
		//����Ԫ��
		al.add("e1");//�����漯�ϴ�Ĳ��Ƕ���,�Ƕ���ĵ�ַ				//ɾclear();���    remove(o);�Ƴ�һ��,  remove(c);�Ƴ�һ�����ϵ�Ԫ��
		al.add("e2");										//retainAll(c)�󽻼�,contain(e);containAll(c);�жϰ���,isEmpty()�жϿ�,size();Ԫ�ظ���
		al.add("e3");										//toArray();���ؼ����а���Ԫ�ص�����
															//iterator ������,ȡ��
		al1.add("e2");
		al1.add("e3");
		al1.add("e4");
		al1.add("e5");
		//��ȡԪ�ظ���
		sop("size = "+al.size());
		
		//��ӡ
		sop("ԭ����"+al);										//[e1, e2, e3]
		
		//ɾ��Ԫ��
		al.remove("e2");
		sop("ɾ��һ��Ԫ�غ�ļ���"+al);
		//al.clear();
		//sop("clear(); "+al);
		
		//�ж�Ԫ��
		sop("al.contains(\"e3\") : "+al.contains("e3"));
		sop("isEmpty() : "+al.isEmpty());
		
		al.retainAll(al1);									//�󽻼�
		sop("al : "+al);									//����Ԫ�ر仯��alԪ�ش�e1,e3���ֻ�н�����Ԫ��e3
		sop("al1 : "+al1);									//����Ԫ��û�б仯
		
	}

	public void demo2() {				//Collection���ӿڵķ��� ������ iterator
		// TODO Auto-generated method stub
		/*
		 * public interface Iterator<E> ȡ�����ϵ�Ԫ��,���ص��Ƿ�������д������(Integer��String,Person)
		 * ����������ȡ������Ԫ�صķ�ʽ
		 * ����ժҪ:
		 * 1.hasNext();		�����Ԫ�ؿ��Ե����򷵻�true
		 * 2.next();		���ص�������һ��Ԫ��
		 * 3.remove();		�ӵ�����ָ���c���Ƴ����������ص����һ��Ԫ��
		 */
		ArrayList<String> al = new ArrayList<String>();
		al.add("e1");
		al.add("e2");
		al.add("e3");
		al.add("e4");
		al.add("e5");
		
		Iterator<String> it = al.iterator();				//���ﷺ�͵�����Ҫ��ArrayList�����ͱ���һ��
		while(it.hasNext()){								//�жϵ�����ָ���Ԫ��,û��ָ�򷵻�false
			System.out.print(it.next()+" ");				//���ص�����ָ��collection��Ԫ��
		}	
		System.out.println();
		it = al.iterator();									//����֮ǰ��it,�õ������ص�ԭ��
		for(int i = 0 ; i < 3 ; i++){
			it.next();	//i=0,it->e1;i=1,it->t2;i=2,it->e3;i=3����ѭ��
		}
		it.remove();	//��ȥe3������ǰ���Ԫ�ص�λ�����Ƴ�Ԫ��,collection.remove�ǰ��ն������Ƴ�Ԫ��
		sop(al);
		/*
		 * for����while while�����it �����ڴ���,forѭ��������it���ͷ��ڴ�
		 * for(Iterator it = al.iterator();it.hasNext;)
		 * 		sop(it.next());
		 */
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}

}
