package demo.oo;

public class ETriangle extends /*继承,延伸*/ EPolygon {
	
	private static final int edge = 3;
	//private int num = 8;			//用来解释 子类父类的构造函数的调用顺序
	ETriangle(){
		this(1);
	}
	ETriangle(double length){
		super(edge,length);			//一定要放在构造函数的第一句,不放也可以,new ERriangle()的时候会在第一句自动加上super();
									//也就是默认调用父类中无参数的构造函数
		
									//第一句一定是 super()代表先运行父类构造函数,运行完之后再子类的属性进行显示初始化,
									//然后再子类运行构造函数
	}
	
	/*
	public String getArea(){		//调用父类的getArea(),不写这个函数的话默认调用父类的getArea();
		String s = super.getArea();	//这里不用super修饰的话就会递归调用本类的getArea(),报错栈满
									//Exception in thread "main" java.lang.StackOverflowError
		return s;
	}

	public int getNum(){			//父类中没有num, 调用时先调用父类,父类没有num会默认初始化(父类初始化完后的对子类属性的
									//显示初始化)num=0;运行父类构造函数,然后再运行子类构造函数,在调用子类的getNum(),
									//最后num=8
		return num;
	}
	*/
	

}
