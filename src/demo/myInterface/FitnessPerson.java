package demo.myInterface;

public interface FitnessPerson {		//身份:keep fit 的人或者不是人,需要keep fit功能的都可以用这个接口
	/*public可以省略
	 *abstract interface纯抽象类
	 *类C不能同时继承类A和类B,但是接口C可以同时继承接口A和接口B，但不建议同时继承2个接口
	 *因为interface A{public abstract String func();}
	 *	interface B{public abstract int func();}
	 *interface c extends A,B{}	 class D implements c{ String func();  int func(); }//实现类时,同名函数,不同返回类型
	 *
	 *接口的特点:
	 *1.接口是对外暴露的规则
	 *2.接口是程序的功能拓展
	 *3.接口可以用来多实现
	 *4.1个类可以继承1个类而且同时实现多个接口
	 *5.接口和接口之间可以多继承
	 *
	 *所有的共性都有,用继承,(所有人都睡觉 ) ; 有些方法有有些方法没有用接口(不是所有人是歌手).
	 *class Japanese extends Person implements GarbageClassficationPerson { 
	 *	void sleep();					//继承的的方法,所有人都睡觉,所有日本人也都睡觉
	 *	void GarbageClassfication();	//实现的方法,人有各种各样的角色,有医生,老师,歌手,有会垃圾分类的人,也有不会垃圾分类的人 。
	 *									//把垃圾分类的人当做扩展功能,需要的时候就实现,不是的时候就不需要实现
	 *									//(这里实现了GarbageClassficationPerson, 日本人都是会垃圾分类的人)
	 *}
	 *class Chinese extends Person{
	 *	void sleep();					//中国人也是人,也要睡觉
	 *									//中国人不是全部人都是会垃圾分类的人,所以不需要实现
	 *}
	 */

		//public static final int WEIGHT_STANDARD = 50;		//public static final 可以省略,建议方法和常量都不省略
		public abstract void keepfit();					//public 和  abstract 可以省略

}
