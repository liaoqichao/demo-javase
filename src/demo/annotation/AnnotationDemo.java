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
		 * ע�����ɿ�ܶ��塢����ʹ�á���ܽ������������������ļ���
		 */
		demo1();
		demo2();
		demo3();
		demo4();
		demo5();
	}

	@MyAnnotation // ʹ��ע��
	// (age = 20, name = "zhangSan")//��ע������Ը�ֵ
	(age = 20) // ��ע������Ը�ֵ��name��Ĭ��ֵ�����Կ��Բ��ø���ֵ�������ֵ�Ϳ��Ը���Ĭ��ֵ
	public void demo1() {
		/*
		 * ע��������ࡢ��Ա��������Ա�������������ֲ�����������ֱ��ע��ᱨ��ǰʹ�á����ǲ��ܷ������ã�ִ����䣩ǰʹ�á�
		 */
	}

	@MyAnnotation2(100) // ���ע��ֻ��һ�����ԣ���������Ϊvalue������������value��ֵ��
	public void demo2() {

	}

	@MyAnnotation3a(a = 100, b = "hello", c = MyEnum.B, d = String.class, e = @MyAnnotation3b(aa = 250, bb = "������") , f = {
			"alpha", "beta", "gamma" }, g = 100// ������Ԫ��ֻ��һ��ʱ����ʡ�Դ�����
	)
	public void demo3() {

	}

	@MyAnnotation4
	public void demo4() {// ע�������Ŀ���޶�
		/*
		 * 1.��һ��ע�⣬��ֻ���������࣬���������������ط������������Ŀ����޶� > �ڶ���ע��ʱ����ע�����@Targetע��
		 */

	}

	@MyAnnotation5
	public void demo5() {// ע�Ᵽ������޶�
		/*
		 * 2.���������޶� > Դ�����ļ�(SOURCE)��ע��ֻ��Դ�����д��ڣ�������ʱ�ͱ������ˡ���ʱ���ܱ����䡣 >
		 * �ֽ����ļ�(CLASS)��ע����Դ�����ļ����ֽ����ļ��д��ڣ�������JVM����ʱ����Ե�ע�⣨���ص��ڴ��ʱ���û�ˣ������ܷ��� >
		 * JVM��(RUNTIME)��ע����Դ���롢�ֽ����ļ��д��ڣ�������JVM������ʱ���ע����ص�JVM�ڴ��У����Ա����䡣
		 * ʹ��@Retentionע�⡣
		 * 
		 * @Retention(value = RetentionPolicy.RUNTIME)
		 */
	}
}

@interface MyAnnotation { // ����ע��
	/*
	 * ����������ʱ��ʹ��ע���������Ը�ֵ ע�����Ե����ͣ� 1.8�ֻ������� 2.String 3.Enum 4.Class 5.ע������(Ƕ��)
	 * 6.��������һά����
	 */
	int age();// ��������ԣ����з��������Ų���ʡ�ԣ����治�ܾͼӲ���,���ܼ�{}

	String name() default "zhangSan";// Ĭ��ֵΪzhangSan
}

@interface MyAnnotation2 {
	int value();// ������ע��ֻ��������ԣ�ʹ��ע���ʱ����Բ���д��������ֻд����ֵ
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

@Target(value = { ElementType.TYPE, ElementType.METHOD, ElementType.FIELD }) // ע����Է������ϣ�������,��Ա������
/*
 * ֻ֪��Ӧ�ø�ʲôֵ��ʱ��Ctrl+������Target����������ElementType[] value();Ӧ���뵽��ö�����͡�
 * Ȼ���㿪��ElementType�������ֵ
 */
@interface MyAnnotation4 {

}

@Retention(value = RetentionPolicy.RUNTIME) // ע����JVM�л����ڣ����Ա�����
@interface MyAnnotation5 {

}