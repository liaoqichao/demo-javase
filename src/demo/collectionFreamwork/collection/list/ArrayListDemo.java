package demo.collectionFreamwork.collection.list;

import demo.collectionFreamwork.example.*;

import java.util.ArrayList;
import java.util.ListIterator;

import demo.collectionFreamwork.CollectionFreamwork;

public class ArrayListDemo implements CollectionFreamwork {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1_ArrayList();
		//demo2_ArrayList();

	}

	public void demo1_ArrayList() {		//ȥ���ظ�Ԫ��
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(Integer.valueOf(2));
		al.add(Integer.valueOf(1));
		al.add(Integer.valueOf(2));
		al.add(Integer.valueOf(2));
		al.add(Integer.valueOf(1));
		al.add(Integer.valueOf(2));
		al.add(Integer.valueOf(3));
		for(ListIterator<Integer> it = al.listIterator();it.hasNext();){
			System.out.print(it.next()+" ");
		}
		System.out.println();
		ArrayList<Integer> newAl = singleElements(al);
		for(ListIterator<Integer> it = newAl.listIterator();it.hasNext();){
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
	}

	public void demo2_ArrayList() {		//�Զ�����(Person)ȥ���ظ�Ԫ��,ͬ��ͬ������Ϊ�ظ�
		// TODO Auto-generated method stub
		/*
		 * List�����ж�Ԫ���Ƿ���ͬ��������Ԫ�ص�equals����. ��Ϊcontains()���õķ�����Object���equals
		 * Ԫ�ظ�����Object��equals����,��ArrayList<E>��ListIterator<E>��������Ԫ�ص�����,���Ե���it.contains(obj)
		 * ���õ���Ԫ�ص�equals������
		 * ����contains()�� remove(Object obj)Ҳ�ǵ�����Object��equals����
		 *  remove(Object obj)ɾ��һ����ַ��obj��ַһ����Ԫ��. ��������equals�����Ƚϵ�ַ,Ԫ�ؿ��Ը���equals,
		 *  �ѵ�ַ��ͬ�ĳ�������ͬ��
		 */
		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person("A",5));
		al.add(new Person("B",5));
		al.add(new Person("C",6));
		al.add(new Person("A",5));
		al.add(new Person("B",3));
		al.add(new Person("C",6));
		for(ListIterator<Person> it = al.listIterator();it.hasNext();){
			Person p = it.next();
			System.out.print(p.getName()+" + "+p.getAge()+"  ; ");
		}
		System.out.println();
		ArrayList<Person> newAl = new ArrayList<Person>();

		for(ListIterator<Person> it = al.listIterator();it.hasNext();){
			Person person = it.next();//Object�� ��� Person��  ��ת��
			if(!newAl.contains(person))//contains���õ���equals����,Person�า����Objec��equals(�Ƚϵ�ַ)����
				newAl.add(person);		//ListIterator��������Person,����it��equals��Person��equals����
		}
		for(ListIterator<Person> it = newAl.listIterator();it.hasNext();){
			Person p = it.next();
			System.out.print(p.getName()+" + "+p.getAge()+"  ; ");
		}
		System.out.println();
		
	}
	public <E> ArrayList<E> singleElements(ArrayList<E> al){
		ArrayList<E> newAl = new ArrayList<E>();
		E obj;
		for(ListIterator<E> iterator = al.listIterator(); iterator.hasNext() ;){
			obj = iterator.next();
			if(!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}

}
