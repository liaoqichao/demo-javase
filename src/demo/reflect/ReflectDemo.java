package demo.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo.DemoInterface;
import demo.collectionFreamwork.example.Person;
import demo.reflect.demo6.Demo6_B;
import demo.reflect.demo6.Demo6_C;

public class ReflectDemo implements DemoInterface {

	/**
	 * 
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * ����һ������ͨ���ԱȽϸߵĴ����С��������ѧϰ���Ŀ�ܡ�
		 * �������ԭ��
		 * 1.��.java�ļ��浽����Ӳ��
		 * 2.����.java�ļ�,����.class�ļ�
		 * 3.ʹ��JVM��.class�ļ�ͨ������������ص��ڴ���
		 * 4..class�ļ�����ͨ��Class������ȡ.class�ļ������ж���Ϳ��Ի�ȡ�����������Ϣ��ʹ����������г�Ա��
		 * 
		 * JAVA�������:������״̬��,��������һ����(class�ļ�),���ܹ�֪���������������Ժͷ���
		 * ��������һ�����󣬶��ܹ�����������һ�����Ժͷ�����
		 * ���ֶ�̬��ȡ��Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�ΪJAVA�������
		 * 
		 * ��̬��ȡ���е���Ϣ,����java�������
		 * 
		 * ��������������ӿ�+�����ļ�
		 * 
		 * ���ã��Ѿ��������е�Ӧ�ó�����Ҫ��չ���ܵ�ʱ��������ʵ���˽ӿڡ�����ԭ����Ӧ�ó�����Ӧ�ó���,û��Դ����,������Ӧ�ó�������new����
		 * ʵ�ֶ�̬������ʵ����ӿں�,Ӧ���������ļ�д��������Ӧ�ó���Ӧ�ö�ȡ�����ļ�,��������(�ַ���)�ҵ�����.class�ļ�,�����ص�Ӧ�ó���
		 * Ȼ����new����,ʹ������ķ�����
		 * 
		 * ���ӣ�Tomcat��Servlet�ӿڡ���Aʵ��Servlet�ӿ�,�����ļ�(web.xml)����A����.Tomcat��ȡ�����ļ���A����,����A.class
		 * ������A.class����Ϣ(��������,���÷���)
		 * �����������˳������չ��
		 */
		//demo1();
		//demo2();
		//demo3();
		//demo4();
//		demo6();
		demo7();
	}
	public void demo1() throws ClassNotFoundException{		//�ֽ������Ļ�ȡ
		/*
		 * Class����Ի�ȡ.class�ļ��е��������� ����������������������ɵġ�
		 * ֻҪ�õ�demo.class�ļ���Class�����Ϳ������demo.class�ļ�����������(����,���캯��,��Ա����,��Ա����)
		 * 
		 * ��ȡ�ֽ������ķ�ʽ��
		 * 1.Object�е�getClass����
		 * 	 �������ַ�ʽ,������ȷ�������,����������
		 * 	 ����Animal�����Person p =new Person(); Class clazz = p.getClass();������չ
		 * 2.�κ��������Ͷ����о�̬����.class����ȡ��Ӧ��Class����
		 * 	   ��Լ�,������Ҫ�õ����еľ�̬��Ա��
		 *   ����Animal�����Person.class��������չ
		 * 3.ֻ��ͨ������������ַ������ƾͿ��Ի�ȡ����.�����������չ�ԡ�Class.forName(String str);
		 * 	 ���ַ�ʽֻҪ������(�ַ���)����
		 */
		
		//��ʽ1
		/*
		Person p = new Person();
		Class clazz = p.getClass();
		
		Person p1 = new Person();
		Class clazz1 = p1.getClass();
		System.out.println(clazz==clazz1);//true
		*/
		
		//��ʽ2
		/*
		Class clazz = Person.class;
		Class clazz1 = Person.class;
		System.out.println(clazz==clazz1);//true
		*/
		
		//��ʽ3
		String className = "demo.collectionFreamwork.example.Person";
		//�����PersonӦ���Ǵ������ļ��ж�ȡ,Ȼ��ֵ��className
		//���classPathͨ����src����binĿ¼��ʼ(���ǵ�����·��)
		//�鿴���������.classPath�ļ�
		Class<?> clazz = Class.forName(className);//������������׳��쳣
		Class<?> clazz1 = Class.forName(className);
		System.out.println(clazz);//class demo.collectionFreamwork.example.Person
		System.out.println(clazz1);//class demo.collectionFreamwork.example.Person
		
	}
	public void demo2() throws Exception{	//��ȡClass����Ĺ��캯��
		String className = "demo.collectionFreamwork.example.Person";
		
		//���캯������������ʵ��������
		//�ҵ�Person.class�ļ������ؽ��ڴ�,������Class����
//		Class clazz = Class.forName(className);
		
		//newInstance()�������Class�����ʾ�����һ����ʵ��,�������Ǹ���Ŀղι��캯��
		//һ�㱻�������ͨ�������ղ���
//		Object obj = clazz.newInstance();//��2���쳣
		
		
		//���캯����������ʵ��������
		/*
		 * ����ȡָ�����ƶ�Ӧ����Ķ���ʱ,��ʼ���������Ĺ��캯��
		 * ��Ȼ��ͨ��ָ���Ĺ��캯�����г�ʼ��,Ӧ���Ȼ�ȡ�ù��캯��
		 * getConstructor(parameterTypes);��ȡ���캯��
		 * getConstructors();��ȡ���й��캯��
		 * getDeclearedConstructor();��ȡ���й��캯������˽��
		 * reflect�аѹ��캯��,����,�ֶη�װ�ɶ���Constructor,Method,Field  ����������Զ���
		 */
		Class<?> clazz1 = Class.forName(className);
		Constructor<?> constructor = clazz1.getConstructor(String.class,int.class);
		//ͨ�������������newInstance�������ж���ĳ�ʼ��
		@SuppressWarnings("unused")
		Object obj = constructor.newInstance("���˸���",15);
		
		//����3�д������ Person p = new Person("���˸���",15);
	}
	public void demo3() throws Exception{	//��ȡClass������ֶ�
		
		String classname = "demo.collectionFreamwork.example.Person";
		Class<?> clazz = Class.forName(classname);
		
		Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
		Object c = constructor.newInstance("���˸���",15);
		
//		Field field = clazz.getField("age");//���ܷ���˽�е�
		Field field = clazz.getDeclaredField("age");//ֻ��ȡ����,������˽��
		System.out.println(field);//private int demo.collectionFreamwork.example.Person.age
		
		/*
		 * �������ʣ�
		 * ��˽���ֶεķ���ȡ��Ȩ�޼��
		 * AccessibleObject�ķ��� setAccessibel(boolean flag); flag = true ��ȡ��Ȩ�޼��
		 * AccessibleObject����������Constructor,Field,Method
		 */
		//��������:
		field.setAccessible(true);
		System.out.println(field.getInt(c));//�����15  age��˽�в���ֱ�ӷ���,��Ҫȡ��Ȩ�޼��
		field.setInt(c,16);//age��˽�в���ֱ�ӷ���
		System.out.println(field.getInt(c));//16
		
	}
	public void demo4() throws Exception{	//��ȡClass����ķ���
		
		String classname = "demo.collectionFreamwork.example.Person";
		Class<?> clazz = Class.forName(classname);
		
		Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
		Object c = constructor.newInstance("��Ī",1);
		
//		Method[] methods = clazz.getMethods();	//û��decleared��ȡ�Ķ��ǹ��еķ���
//		for(Method method : methods){
//			System.out.println(method);
//		}
		
//		public boolean demo.collectionFreamwork.example.Person.equals(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.toString()
//		public int demo.collectionFreamwork.example.Person.hashCode()
//		public int demo.collectionFreamwork.example.Person.compareTo(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.getName()
//		public int demo.collectionFreamwork.example.Person.getAge()
//		public static demo.collectionFreamwork.example.CompareByName demo.collectionFreamwork.example.Person.getCompareByName()
//		public static demo.collectionFreamwork.example.CompareByAge demo.collectionFreamwork.example.Person.getCompareByAge()
//		public void demo.collectionFreamwork.example.Person.chifan()
//		public final void java.lang.Object.wait() throws java.lang.InterruptedException
//		public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//		public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//		public final native java.lang.Class java.lang.Object.getClass()
//		public final native void java.lang.Object.notify()
//		public final native void java.lang.Object.notifyAll()
		
//		Method[] m = clazz.getDeclaredMethods();	//ֻ��ȡ����ķ���,����˽��
//		for(Method method : m){
//			System.out.println(method);
//		}
		
//		public boolean demo.collectionFreamwork.example.Person.equals(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.toString()
//		public int demo.collectionFreamwork.example.Person.hashCode()
//		public int demo.collectionFreamwork.example.Person.compareTo(java.lang.Object)
//		public java.lang.String demo.collectionFreamwork.example.Person.getName()
//		public int demo.collectionFreamwork.example.Person.getAge()
//		public static demo.collectionFreamwork.example.CompareByName demo.collectionFreamwork.example.Person.getCompareByName()
//		public static demo.collectionFreamwork.example.CompareByAge demo.collectionFreamwork.example.Person.getCompareByAge()
//		public void demo.collectionFreamwork.example.Person.chifan()

//		Method method clazz.getMethod(name, parameterTypes);
//		Method singleMethod =  clazz.getMethod("chifan", null);//�����null���βΣ�û�в������Բ�д
		Method singleMethod = clazz.getMethod("chifan");
//		singleMethod.invoke(c, null);//�����null��ʵ��  ������Է�,û�в������Բ�д
		singleMethod.invoke(c);//û�в������Բ�д
		//��һ��������ʵ��,�������������һ��ʵ��,Person p1
		//���chifan�Ǿ�̬����,��ô�Ͳ���Ҫʵ������	��
		//singleMethod.invoke(null,null);//��һ��null��ʾ���õ��Ǿ�̬����
		
		Method singleMethod1 = clazz.getMethod("equals", Object.class);
		System.out.println(singleMethod1.invoke(c, new Person("����",5)));
	}
	
	public void demo6(){	//���ͷ���
		/*
		 * Class��Type getGenericSuperClass()���������ص��ǲ���������(ParameterizedType)��
		 * ��Ҫ��TypeǿתΪParameterizedType
		 * ���������ͣ�����A<String>(����+����)
		 * ParameterizedType�ķ�����Type[] getAuctualTypeArgument()���õ�����A<String>��String��
		 * 	Map<String,Object>�е�{String,Object};
		 * ���ʱ�򷵻ص�Type[] ����Class[]
		 */
		
		new Demo6_B();
//		this.getClass() = class demo.reflect.demo6.Demo6_B
//		class java.lang.Integer
		new Demo6_C();
//		this.getClass() = class demo.reflect.demo6.Demo6_C
//		class java.lang.String
	}
	
	public void demo7() throws ClassNotFoundException, NoSuchMethodException, SecurityException{	//����ע��
		/*
		 * Ҫ���͵ı������Ա�����RetentionPolicy.RUNTIME
		 * 1.����ע����Ҫ������Ŀ���Ϸ���
		 * 	* ���ϵ�ע����Ҫ��Class�ϻ�ȡ
		 * 	* ������ע����Ҫ��Method��ȡ
		 *  * ��������ע����Ҫ��Constructor�ϻ�ȡ
		 *  * ��Ա������ע����Ҫ��Field�ϻ�ȡ
		 *  Class��getAnnotation����ط���
		 *  Method��Constructor��Field�Ĺ�ͬ���ࣺAccessibleObject��getAnnotation����ط���
		 */
		
		/*
		 * Class
		 */
		//1.�õ�����Ŀ��
		@SuppressWarnings("unchecked")
		Class<ClassDemo7> clazz = (Class<ClassDemo7>) Class.forName("demo.reflect.ClassDemo7");
		//2.��ȡָ�����͵�ע��
		AnnotationDemo7 anno1 = clazz.getAnnotation(AnnotationDemo7.class);
		//3.
		System.out.println(anno1.age()+", "+anno1.name()+", "+anno1.sex());
		//10, A��, ��
		
		/*
		 * AccessibleObject
		 */
		//1.�õ�����Ŀ��
		Class<ClassDemo7> c = ClassDemo7.class;
		Method method = c.getMethod("func1");
		//2.��ȡָ�����͵�ע��
		AnnotationDemo7 anno2 = method.getAnnotation(AnnotationDemo7.class);
		//3.
		System.out.println(anno2.age()+", "+anno2.name()+", "+anno2.sex());
		
		/*
		 * ��һ��֪��ע������ֵĻ�ֻ��getAnnotations��ȡ����Ŀ���µ�ȫ��ע��
		 */
	}

}

@AnnotationDemo7(age = 10, name = "A��", sex = "��")
class ClassDemo7{
	@AnnotationDemo7(age = 20, name = "fun1����", sex = "��")
	public void func1(){
		
	}
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface AnnotationDemo7{
	String name();
	int age();
	String sex();
}
