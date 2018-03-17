package demo.reflect.demo6;

import java.lang.reflect.ParameterizedType;

public abstract class Demo6_A<T> {
	public Demo6_A(){
		/*
		 * �������ȡ���ഫ�ݵķ�����Ϣ��Ҫ�õ�һ��class
		 */
		Class<?> clazz = this.getClass();//�õ����������
		System.out.println("this.getClass() = "+clazz);//new Demo6_B() �����������demo.reflect.demo6.Demo6_B
		
//		Type type = clazz.getGenericSuperclass();//��ȡ���Ǵ��ݸ�����Ĳ���������
//		ParameterizedType pType = (ParameterizedType)type;//�����ȡ�ľ���A<String>
//		Type[] types = pType.getActualTypeArguments();//���ﷵ�ص���class����
//		Class c = (Class)types[0];
		
//		���������һ�仰����
		Class<?> c = (Class<?>)((ParameterizedType)this.getClass()//
				.getGenericSuperclass())//
				.getActualTypeArguments()[0];//��������
		System.out.println(c);
	}
}
