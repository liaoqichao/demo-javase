package demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo implements IO {

	/**
	 * �����������
	 * ObjectInputStream	ObjectOutputStream
	 * ���ڴ�����Ķ��󴢴�������(Person p.name  p.age);���������������ͱ�System.gc();����,Ϊ���Ժ�Ҳ��ʹ������������,
	 * Ҫ����Щ����(����)����һ��˳��(���л�)�洢��Ӳ��(�־û�).������������׽�����,���������һ̨��������һ���������ع�����
	 * 
	 * ֮ǰ�Ķ�������ݻ�����,����ÿ�ζ������µĶ���.�����ʹ��ObjectInputStream	ObjectOutputStream�����ȡ����
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub

		//demo1();
		//demo2();

	}
	public void demo1() throws IOException{		//�����,��������л�
		/*
		 * ObjectOutputStream(OutputStream out);
		 * Serializable ��ǽӿ� ʵ��������ӿڲ������л�
		 * oos.write(obj);Ĭ��д���ǣ�
		 * �������,��ǩ��(�ײ���),�Լ���˲̬�ͷǾ�̬�ֶΡ�
		 * private String s = "abc";				//��˲̬
		 * private transient String s = "abc";	 	//˲̬
		 * transient	���ݵ�
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Eclipse\\IO\\ObjectStream\\demo1.object"));
		//һ��������ļ���׺��.objcet
		Person p1 = new Person("����",11);
		Person p2 = new Person("����",22);
		//PersonҪʵ��Serializable�ӿڲ���ʵ��ʵ���� ,����Personʵ����Comparable ��Comparableʵ����Serializable
		//����Person��CompareTo�ǰ���������
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(new Person("����",55));
		oos.close();
	}
	public void demo2() throws IOException, ClassNotFoundException{				//ȡ����,����ķ����л�
		/*
		 * ֻ�ܶ�ObjectOutputStream������ļ�
		 * ����ͨ����������.object���Զ�������,���ǲ�����ϳɶ���
		 * Ϊʲôǰ���Personʵ�ֵ�Serializable ���׳� Personûʵ��Serializable���쳣
		 * private static final long serialVersionUID �汾�Ų�Ҫ��Ĭ�ϵ�
		 */

		//�������ExampleDemo2��,�ı��������(��ɾ����,�ı�Ȩ��),��ȡ�ļ���ʱ��(�ϵ���)������쳣
		//��ΪSerialVersionID��ͬ,���Ըı�SerialVersionIDʹ֮�ܱ���ȡ
		//ExampleDemo2��ID  private static final long serialVersionUID = 1L;
		
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\IO\\ObjectStream\\demo1.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p1 = (Person)ois.readObject();
		Person p2 = (Person)ois.readObject();
		Person p3 = (Person)ois.readObject();
		//Person p4 = (Person)ois.readObject();//�쳣,�ļ�һ����ֻ��3������
		System.out.println(p1.getName()+" : "+p1.getAge());
		System.out.println(p2.getName()+" : "+p2.getAge());
		System.out.println(p3.getName()+" : "+p3.getAge());
		ois.close();

	}
}
