package demo.collectionFreamwork.collection.set;

import demo.collectionFreamwork.example.*;

import java.util.HashSet;
import java.util.Iterator;

import demo.collectionFreamwork.CollectionFreamwork;

public class HashSetDemo implements CollectionFreamwork {

	
	/**
	 * Set:无序(存入和取出的顺序没关系)，不重复
	 * Set的功能和Collection的功能是一致的
	 * 常见的子类：	HashSet：底层数据结构是哈希表，线程不同步,判断元素是否相同的依据先判断hashCode再判断equals
	 * 			TreeSet：底层数据结构是先序遍历的平衡二叉树，可以对集合中的元素进行排序
	 * 二叉树遍历方式：	先根遍历：根，左，右
	 * 				中根遍历：左，根，右		升序排序
	 * 				后根遍历：左，右，根		
	 * 平衡二叉树：任意一个节点，它的左子树和右子树的高度差为1。所以每次增加节点的时候,树都有可能变化
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();

	}
	public void demo1(){
		/*
		 * HashSet 通过先判断hashCode,在判断equals 如果2次都不同,则为不同元素,从而来保证元素的唯一性
		 */
		HashDemo h1 = new HashDemo();
		HashDemo h2 = new HashDemo();
		System.out.println(h1);//复写hashCode()前HashDemo@6deea96c，复写hashCode()后HashDemo@c7  3c(hex)=60(decimal)
		System.out.println(h2);//复写hashCode()前HashDemo@4fb529d6，复写hashCode()后HashDemo@c7
		//哈希表判断完他们是同一个地址之后,还会再进行判断,判断他们时候是同一对象（equals()）,如果是,在那个地址存多一个对象
	}	
	public void demo2(){
		
		HashSet<String>  hs  = new HashSet<String>();//存入顺序1,2,3,4
		hs.add("e1");//true  为什么Collection的add是boolean类型？  第一个加入成功,第二个加入失败
		hs.add("e1");//false
		hs.add("e2");
		hs.add("e3");
		hs.add("e3");
		hs.add("e4");
		
		for(Iterator<String> it = hs.iterator();it.hasNext();){
			System.out.println(it.next());			//取出顺序3,4,1,2  和存入顺序不一样，按地址大小取出
		}
	}
	public void demo3(){		//HashSet 存入自定义类型Person  ，名字和年龄相同则重复
		
		/*
		 * 根据demo1(); 先判断哈希值是否重复hashCode,然后再判断对象是否相同equals。所以Person类要复写hashCode和equal
		 * 可以把哈希值设为常量，每次哈希值相同都要比较对象是否相同,再用equals来判断对象和参数的名字和年龄时候相同
		 * 因为自定义类有可能会存入到HashSet中,所以自定义类往往会复写Object中的equals和hashCode，因为数据结构的底层会自己调用
		 * equals和hashCode。尽量保持哈希值唯一来代码提高效率
		 * 
		 * 数据结构中算哈希值的方法通常有：
		 * 1.直接寻址法
		 * 2.数字分析法
		 * 3.平方取中法
		 * 4.折叠法
		 * 5.随机数法
		 * 6.除留取余法
		 * 尽量保持哈希值唯一来代码提高效率，解决哈希值冲突的方法：
		 * 1.开放寻址法
		 * 2.再散列法
		 * 3.链地址法(拉链法)
		 * 4.建立一个公共溢出区
		 *
		 */
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(new Person("e1",10));
		hs.add(new Person("e2",10));//e2::10..equals?..e1::10 : false  	(e2,10)进入HashSet
		hs.add(new Person("e1",10));//e1::10..equals?..e2::10 : false
									//e1::10..equals?..e1::10 : true	(e1,10)已有不进入HashSet
		hs.add(new Person("e2",20));//e2::20..equals?..e2::10 : false
									//e2::20..equals?..e1::10 : false	(e2,20)进入HashSet
		hs.add(new Person("e2",10));//e2::10..equals?..e2::20 : false
									//e2::10..equals?..e2::10 : true	(e2,10)已有不进入HashSet
									//(e2::10..equals?..e1::10 : flase)   前面已经true,不然继续判断这个
		
		/*
		 * 方法1比较次数比较少
		 * 方法1：hashCode = name.hasCode+age;
		 * e1::10...hashCode
		 * e2::10...hashCode
  		 * e1::10...hashCode
		 * e1::10..equals?..e1::10 : true
		 * e2::20...hashCode
		 * e2::10...hashCode
		 * e2::10..equals?..e2::10 : true
		 * e2.::20
		 * e2.::10
		 * 
		 * 方法2：hashCode = 1;
		 * e1::10...hashCode
		 * e2::10...hashCode
		 * e2::10..equals?..e1::10 : false
		 * e1::10...hashCode
		 * e1::10..equals?..e2::10 : false
		 * e1::10..equals?..e1::10 : true
		 * e2::20...hashCode
		 * e2::20..equals?..e2::10 : false
		 * e2::20..equals?..e1::10 : false
		 * e2::10...hashCode
		 * e2::10..equals?..e2::20 : false
		 * e2::10..equals?..e2::10 : true
		 * e2.::20
		 * e2.::10
		 * e1.::10
		 */
		
		for(Iterator<Person> it = hs.iterator(); it.hasNext();){
			Person person = (Person)it.next();//下转型
			System.out.println(person.getName()+".::"+person.getAge());
			/*
			 * e2.::20
			 * e2.::10
			 * e1.::10
			 */
		}
	}
	public void demo4(){			//HashSet判断和删除的依据
		/*
		 * HashSet判断contains和删除remove的依据
		 * 都要先判断hasCode,再判断equals
		 * 而ArrayList的contains和remove只判断equals
		 */
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(new Person("e1",10));
		hs.add(new Person("e2",10));
		hs.add(new Person("e1",10));
		
		System.out.println(hs.contains(new Person("e1",10)));//true
		System.out.println(hs.remove(new Person("e2",10)));	//true
		/*
		 * HashSet的contains的判断依据 先判断hashCode,再判断equals
		 * e1::10...hashCode
		 * e1::10..equals?..e1::10 : true
		 * true
		 */
	}
}
class	HashDemo{		//复写hashCode() ,由自己定义哈希算法
	
	public int hashCode(){
		return 60;
	}
	
}



