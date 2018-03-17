package demo.reflect.demo6;

import java.lang.reflect.ParameterizedType;

public abstract class Demo6_A<T> {
	public Demo6_A(){
		/*
		 * 在这里获取子类传递的泛型信息，要得到一个class
		 */
		Class<?> clazz = this.getClass();//得到子类的类型
		System.out.println("this.getClass() = "+clazz);//new Demo6_B() 这里输出的是demo.reflect.demo6.Demo6_B
		
//		Type type = clazz.getGenericSuperclass();//获取的是传递给父类的参数化类型
//		ParameterizedType pType = (ParameterizedType)type;//这里获取的就是A<String>
//		Type[] types = pType.getActualTypeArguments();//这里返回的是class参数
//		Class c = (Class)types[0];
		
//		上面可以用一句话代替
		Class<?> c = (Class<?>)((ParameterizedType)this.getClass()//
				.getGenericSuperclass())//
				.getActualTypeArguments()[0];//背！！！
		System.out.println(c);
	}
}
