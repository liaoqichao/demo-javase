package demo.collectionFreamwork.collection.list;

import java.util.LinkedList;

import demo.collectionFreamwork.CollectionFreamwork;

public class LinkedListDemo implements CollectionFreamwork {

	
	/**
	 * LinkedList�����з���,��ͬ��
	 * addFirst
	 * addlast
	 * getFirst
	 * getlast
	 * getFirst
	 * getlast
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();

	}
public void demo1(){
		
		/*
		 * offerFirst()����addFirst();
		 * peekFirst()����getFirst()
		 * pollFirst()����removeFirst()
		 * ������Ϊ��ʱ��ǰ���3���������ؿ�, �����3���������׳��쳣
		 */
		LinkedList<String> ll = new LinkedList<String>();
		ll.addFirst("e1");
		ll.addFirst("e2");
		ll.addFirst("e3");
		ll.addFirst("e4");
		LinkedList<String> lla = ll;				//����ll�ı��� llaҲ���Ÿı�
		System.out.println(lla);	
		
		System.out.println(ll.removeFirst());		//e4����ȡԪ��,��Ԫ�ر�ɾ����������pollFirst(),û��Ԫ�ص�����������򷵻ؿ�
													//removeFirst()û��Ԫ�ص�������������׳��쳣
		System.out.println(ll);						//[e3, e2, e1]
		System.out.println("First = "+ll.getFirst()+"  ,Last = "+ll.getLast());
		//������ȡԪ��,û��Ԫ�ص�ʱ��������������׳��쳣
		//������peekFirst();����getFirst();
		while(!lla.isEmpty()){
			System.out.println(lla.removeFirst());	//���õ���������,e3,e2,e1.ǰ��ll.removeFirst(),llaҲ���Ÿı�
		}
		System.out.println(ll);						//lla�ı��llҲ�ı�
		
	}
	
	public void demo2(){				//������ģ��˳����к�ջ
		
		MyQueue<Character> queue = new MyQueue<Character>();
		
		//�������
		//(char)((int)(Math.random()*26)+97)���������ĸ
		queue.in('a');
		queue.in('b');
		queue.in('c');
		queue.in('d');
		queue.in('e');
		queue.in('f');

		System.out.println("size = "+queue.size());
		while(!queue.isEmpty()){
			System.out.print(queue.out()+" ");
		}
		System.out.println();
		
		if(queue.isEmpty())
			System.out.println("����Ϊ��");
	}
	public void demo3(){					//������ģ��ջ
		
		MyStack<Integer> stack = new MyStack<Integer>();
		//��ջ
		try {								//�����쳣��ִ��catch��ִ����catchִ�к���Ĵ���
			stack.in(Integer.valueOf(1));
			stack.in(Integer.valueOf(2));
			stack.in(Integer.valueOf(3));
			stack.in(Integer.valueOf(4));
			stack.in(Integer.valueOf(5));
		} catch (StackOverException e) {
			e.statement();
		}
		//��ջ
		//stack.out();
		//stack.out();
		//stack.out();
		
		//����
		while(!stack.isEmpty()){
			System.out.print(stack.out()+" ");
		}
		System.out.println();
		
		System.out.println("size = "+stack.size()+" ,ջ��?"+stack.isEmpty());
	}
}
class MyQueue<E>{
	
	private LinkedList<E> queue = new LinkedList<E>();
	MyQueue(){}
	public void in(E e){	
		queue.offerLast(e);
	}
	@SuppressWarnings({ "unchecked", "hiding" })
	public <E> E out(){
		return (E)queue.pollFirst();
	}
	@SuppressWarnings({ "unchecked", "hiding" })
	public <E> E getFirst(){
		return (E)queue.peekFirst();
	}
	public int size(){
		return queue.size();
	}
	public boolean isEmpty(){
		return queue.isEmpty();
	}
}
class MyStack<E> {
	
	private LinkedList<E> stack = new LinkedList<E>();
	public static int MAX = 2;
	
	MyStack(){}
	
	public void in(E e) throws StackOverException{
		if(stack.size()>=MAX)
			throw new StackOverException(); 
		stack.offerLast(e);
	}
	@SuppressWarnings({ "unchecked", "hiding" })
	public <E> E out(){
		return (E)stack.pollLast();
	}
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public boolean isFull(){
		if(stack.size()==100)
			return true;
		return false;
	}
	public int size(){
		return stack.size();
	}
	@SuppressWarnings({ "unchecked", "hiding" })
	public <E> E getTop(){
		return (E)stack.peekLast();
	}
}

class StackOverException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void statement(){
		System.out.println("ջ��,����ʧ��");
	}

}

