package demo.collectionFreamwork.collection.list;

import java.util.LinkedList;

import demo.collectionFreamwork.CollectionFreamwork;

public class LinkedListDemo implements CollectionFreamwork {

	
	/**
	 * LinkedList的特有方法,不同步
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
		 * offerFirst()代替addFirst();
		 * peekFirst()代替getFirst()
		 * pollFirst()代替removeFirst()
		 * 当链表为空时，前面的3个方法返回空, 后面的3个方法则抛出异常
		 */
		LinkedList<String> ll = new LinkedList<String>();
		ll.addFirst("e1");
		ll.addFirst("e2");
		ll.addFirst("e3");
		ll.addFirst("e4");
		LinkedList<String> lla = ll;				//这样ll改变了 lla也跟着改变
		System.out.println(lla);	
		
		System.out.println(ll.removeFirst());		//e4。获取元素,且元素被删除。建议用pollFirst(),没有元素调用这个方法则返回空
													//removeFirst()没有元素调用这个方法则抛出异常
		System.out.println(ll);						//[e3, e2, e1]
		System.out.println("First = "+ll.getFirst()+"  ,Last = "+ll.getLast());
		//仅仅获取元素,没有元素调时调用这个方法则抛出异常
		//建议用peekFirst();代替getFirst();
		while(!lla.isEmpty()){
			System.out.println(lla.removeFirst());	//不用迭代器遍历,e3,e2,e1.前面ll.removeFirst(),lla也跟着改变
		}
		System.out.println(ll);						//lla改变后ll也改变
		
	}
	
	public void demo2(){				//用链表模拟顺序队列和栈
		
		MyQueue<Character> queue = new MyQueue<Character>();
		
		//进入队列
		//(char)((int)(Math.random()*26)+97)随进生成字母
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
			System.out.println("队列为空");
	}
	public void demo3(){					//用链表模拟栈
		
		MyStack<Integer> stack = new MyStack<Integer>();
		//入栈
		try {								//遇到异常就执行catch，执行完catch执行后面的代码
			stack.in(Integer.valueOf(1));
			stack.in(Integer.valueOf(2));
			stack.in(Integer.valueOf(3));
			stack.in(Integer.valueOf(4));
			stack.in(Integer.valueOf(5));
		} catch (StackOverException e) {
			e.statement();
		}
		//出栈
		//stack.out();
		//stack.out();
		//stack.out();
		
		//遍历
		while(!stack.isEmpty()){
			System.out.print(stack.out()+" ");
		}
		System.out.println();
		
		System.out.println("size = "+stack.size()+" ,栈空?"+stack.isEmpty());
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
		System.out.println("栈满,操作失败");
	}

}

