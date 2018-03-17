package demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo implements IO {

	/**
	 * 操作对象的流
	 * ObjectInputStream	ObjectOutputStream
	 * 堆内存里面的对象储存着数据(Person p.name  p.age);但是作用域结束后就被System.gc();回收,为了以后也能使用这对象的数据,
	 * 要把这些对象(数据)按照一定顺序(序列化)存储到硬盘(持久化).如果流是网络套接字流,则可以在另一台主机或另一个进程中重构对象
	 * 
	 * 之前的对象的数据还有用,不想每次都创建新的对象.则可以使用ObjectInputStream	ObjectOutputStream来存和取对象
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub

		//demo1();
		//demo2();

	}
	public void demo1() throws IOException{		//存对象,对象的序列化
		/*
		 * ObjectOutputStream(OutputStream out);
		 * Serializable 标记接口 实现了这个接口才能序列化
		 * oos.write(obj);默认写的是：
		 * 对象的类,类签名(底层做),以及非瞬态和非静态字段。
		 * private String s = "abc";				//非瞬态
		 * private transient String s = "abc";	 	//瞬态
		 * transient	短暂的
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Eclipse\\IO\\ObjectStream\\demo1.object"));
		//一般存对象的文件后缀是.objcet
		Person p1 = new Person("张三",11);
		Person p2 = new Person("李四",22);
		//Person要实现Serializable接口才能实现实例化 ,这里Person实现了Comparable 而Comparable实现了Serializable
		//这里Person的CompareTo是按年龄排序
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(new Person("王五",55));
		oos.close();
	}
	public void demo2() throws IOException, ClassNotFoundException{				//取对象,对象的反序列化
		/*
		 * 只能读ObjectOutputStream输出的文件
		 * 用普通的输入流读.object可以读出数据,但是不能组合成对象
		 * 为什么前面的Person实现的Serializable 会抛出 Person没实现Serializable的异常
		 * private static final long serialVersionUID 版本号不要用默认的
		 */

		//如果存了ExampleDemo2后,改变了这个类(增删功能,改变权限),读取文件的时候(老的类)会产生异常
		//因为SerialVersionID不同,可以改变SerialVersionID使之能被读取
		//ExampleDemo2的ID  private static final long serialVersionUID = 1L;
		
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ObjectStream\\demo1.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p1 = (Person)ois.readObject();
		Person p2 = (Person)ois.readObject();
		Person p3 = (Person)ois.readObject();
		//Person p4 = (Person)ois.readObject();//异常,文件一共就只有3个对象
		System.out.println(p1.getName()+" : "+p1.getAge());
		System.out.println(p2.getName()+" : "+p2.getAge());
		System.out.println(p3.getName()+" : "+p3.getAge());
		ois.close();

	}
}
