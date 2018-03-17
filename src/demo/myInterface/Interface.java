package demo.myInterface;

import demo.DemoInterface;

public class Interface implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub

		//demo1_interface();
		//demo2_interface();
	}
	public void demo1_interface(){				//一个类有多个接口,转换接口的类型,输出接口的实现
			
			//创建一个实体对象人
			Person tom = new Cantonese("tom",55);
			tom.hello();	
			
			//面向接口,根据tom的身份(学生,歌手,健身者...)转换类型,对象一直没变,只是对象的变量<引用>(tom,tomAs...)变了
			//tom的身份是健身者,对象类型从父类Person 转换到 子类的接口 FitnessPerson 算是下转型吗？
			if(tom.overweight()){
				FitnessPerson tomAsFitnessPerson = (FitnessPerson)tom;
				tomAsFitnessPerson.keepfit();
			}
			
			
			Song s = new Song("An apple a day,Keep doctors away");
			
			//转型,实体对象tom换了另外一个身份创作型歌手
			SingerComposer tomAsSingerComposer = (SingerComposer)tom;
			tomAsSingerComposer.writeSong(s, "旋律咯", "一天一首小苹果,医生不敢来看我");
			tomAsSingerComposer.sing(s);
			
			
			Cantonese timor = new Cantonese("timor",40);
			timor.hello();
			if(timor.overweight()){
				FitnessPerson timorAsFitnessPerson = (FitnessPerson)timor;
				timorAsFitnessPerson.keepfit();
			}
			Singer timorAsSinger = (Singer)timor;
			timorAsSinger.sing(s);
		}
	public void demo2_interface(){				//通过继承拓展接口,没有修改原代码
			Song s = new Song("队长之歌");
			s.writeSong("啦啦啦", "1，2，3，4，提莫队长正在送命");
			Person timor = new CantoneseRocker("timor",40);
			timor.hello();
			if(timor.overweight()){
				FitnessPerson timorAsFitnessPerson = (FitnessPerson)timor ;
				timorAsFitnessPerson.keepfit();
			}
			CantoneseRocker timorAsCantoneseRocker =(CantoneseRocker)timor;
			timorAsCantoneseRocker.sing(s);
		}
}

/*
 * 接口和抽象类的区别：
 * 1.接口可以多重继承,抽象类不可以
 * 2.接口全部方法都是public abstract,而抽象类可以有非public,非abstract的方法
 * 3.抽象类可以实现接口,而接口不可以实现抽象类
 * 
 * 一个类可以实现多个接口,接口暴露的内容越少越好
 * 
 * 一个接口代表一个角色(身份)
 * 张三是学生,来学习,他也会做饭,他也会弹琴,但是学校是实现张三学习功能的接口,它(学校)只关注学习,不关注张三会不会其他,
 * 厨房是张三实现做饭功能的接口,接口不关心张三会不会其他,只关心他做饭功能
 * ...
 * 所以一个类可以有多个接口(如果用继承的话,只能继承一个父类,用接口的话可以同时实现多个接口)
 * 
 * 接口继承接口,会继承父接口的所有抽象方法,实现子接口时,要把全部方法(包括继承父接口的)实现
 * 
 * 聚合关系：has a
 * 组合关系:contains a
 * 
 * 
 */

