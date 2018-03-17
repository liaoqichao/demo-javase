package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import demo.DemoInterface;

public class AnnotationDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		/*
		 * 注解是由框架定义、我们使用、框架解析。用来代替配置文件。
		 */
		demo1();
		demo2();
		demo3();
		demo4();
		demo5();
	}

	@MyAnnotation // 使用注解
	// (age = 20, name = "zhangSan")//给注解的属性赋值
	(age = 20) // 给注解的属性赋值，name有默认值，所以可以不用给出值，如果给值就可以覆盖默认值
	public void demo1() {
		/*
		 * 注解可以在类、成员变量，成员方法，参数，局部变量，包（直接注解会报错）前使用。但是不能方法调用（执行语句）前使用。
		 */
	}

	@MyAnnotation2(100) // 这个注解只有一个属性，且属性名为value。可以这样给value赋值。
	public void demo2() {

	}

	@MyAnnotation3a(a = 100, b = "hello", c = MyEnum.B, d = String.class, e = @MyAnnotation3b(aa = 250, bb = "二百五") , f = {
			"alpha", "beta", "gamma" }, g = 100// 当数组元素只有一个时可以省略大括号
	)
	public void demo3() {

	}

	@MyAnnotation4
	public void demo4() {// 注解的作用目标限定
		/*
		 * 1.让一个注解，它只能作用于类，不能作用于其他地方。这叫做作用目标的限定 > 在定义注解时，给注解添加@Target注解
		 */

	}

	@MyAnnotation5
	public void demo5() {// 注解保存策略限定
		/*
		 * 2.保留策略限定 > 源代码文件(SOURCE)：注解只在源代码中存在，当编译时就被忽略了。这时候不能被反射。 >
		 * 字节码文件(CLASS)：注解在源代码文件和字节码文件中存在，但是在JVM加载时会忽略掉注解（加载到内存的时候就没了）。不能反射 >
		 * JVM中(RUNTIME)：注解在源代码、字节码文件中存在，并且在JVM加载类时会把注解加载到JVM内存中，可以被反射。
		 * 使用@Retention注解。
		 * 
		 * @Retention(value = RetentionPolicy.RUNTIME)
		 */
	}
}

@interface MyAnnotation { // 定义注解
	/*
	 * 定义了属性时，使用注解必须给属性赋值 注解属性的类型： 1.8种基本类型 2.String 3.Enum 4.Class 5.注解类型(嵌套)
	 * 6.以上类型一维数组
	 */
	int age();// 这个叫属性，不叫方法。括号不能省略，里面不能就加参数,不能加{}

	String name() default "zhangSan";// 默认值为zhangSan
}

@interface MyAnnotation2 {
	int value();// 如果这个注解只有这个属性，使用注解的时候可以不用写属性名，只写属性值
}

@interface MyAnnotation3a {

	int a();

	String b();

	MyEnum c();

	Class<?>d();

	MyAnnotation3b e();

	String[]f();

	int[]g();
}

@interface MyAnnotation3b {
	int aa();

	String bb();
}

enum MyEnum {
	A, B, C
}

@Target(value = { ElementType.TYPE, ElementType.METHOD, ElementType.FIELD }) // 注解可以放在类上，方法上,成员变量上
/*
 * 只知道应该给什么值的时候Ctrl+左键点击Target，看到里面ElementType[] value();应该想到是枚举类型。
 * 然后点点开看ElementType看里面的值
 */
@interface MyAnnotation4 {

}

@Retention(value = RetentionPolicy.RUNTIME) // 注解在JVM中还存在，可以被反射
@interface MyAnnotation5 {

}