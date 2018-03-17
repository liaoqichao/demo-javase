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

	public void demo1_ArrayList() {		//去除重复元素
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

	public void demo2_ArrayList() {		//自定义类(Person)去除重复元素,同名同年龄视为重复
		// TODO Auto-generated method stub
		/*
		 * List集合判断元素是否相同，依据是元素的equals方法. 因为contains()调用的方法是Object类的equals
		 * 元素覆盖了Object的equals方法,而ArrayList<E>和ListIterator<E>的类型是元素的类型,所以调用it.contains(obj)
		 * 调用的是元素的equals方法。
		 * 除了contains()， remove(Object obj)也是调用了Object的equals方法
		 *  remove(Object obj)删除一个地址和obj地址一样的元素. 里面用了equals方法比较地址,元素可以覆盖equals,
		 *  把地址相同改成名字相同等
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
			Person person = it.next();//Object类 变成 Person类  下转型
			if(!newAl.contains(person))//contains调用的是equals方法,Person类覆盖了Objec的equals(比较地址)方法
				newAl.add(person);		//ListIterator的类型是Person,所以it的equals是Person的equals方法
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
