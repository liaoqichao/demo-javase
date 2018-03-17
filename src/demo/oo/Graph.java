package demo.oo;


public abstract class Graph {						//抽象类不能实例化对象

	 Graph(){}
	 public abstract String getPerimeter();
	 public abstract String getArea();
	 public void statement(){ System.out.println("调用抽象类的非抽象方法"); }
}
/*
 * 注意：
 * 1.抽象类的方法不一定全部都是抽象方法
 * 2.如果抽象类的子类是非抽象类,子类一定要实现所有父类中的抽象方法;如果抽象类的子类也是抽象类,可以只实现一部分抽象方法
 * 
 * 抽象类的作用：
 * 1.可以进行类型隐藏,构造出出一组固定的抽象描述,但这组固定抽象描述会有任意个具体实现方式
 * 2.通过抽象类派生,也可以拓展此模块的行为功能。抽象类是实现开放关闭原则(Open-Closed Principle)的关键。
 * 	开放关闭原则(Open-Closed Principle)
 * 		对扩展开放  : 模块的行为可以被扩展从而满足新的需求
 * 		对修改关闭 : 不允许修改模块的源代码。（或者尽量使修改最小化）
 * 3.抽象类往往用来表征对问题领域进行分析、设计中得出的抽象概念，是对一系列看上去不同，但是本质上相同的具体概念的抽象。
 * 
 * 
 */ 