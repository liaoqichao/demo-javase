package demo.oo;

import java.util.Scanner;

import demo.DemoInterface;

public class OO implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub

		
		//demo1_oo();
		//OO o =new OO();
		//o.demo2_oo();							//这样函数前面不用加static	
		//demo3_oo();
		//demo4_oo();
		//demo5_oo();
		//demo6_oo();
		//demo7_oo();
	}

	public void demo1_oo(){						//封装性,类的实例化和调用类中方法
		//** 新建类,构造函数重载,新建对象,static用法
		//EPolygon p1 =new EPolygon();
		//System.out.println("p1的周长为: "+p1.getPerimeter());
		//System.out.println("p1的面积为: "+p1.getArea());
		System.out.println("请输入正多边形p2的边数和长度  :");
		Scanner scanner =new Scanner(System.in);
		int edge =scanner.nextInt();
		double length = scanner.nextDouble();
		if(edge<3 || length<=0){ 
			edge =3 ; length =1 ; 
			System.out.println("不能构成正多边形,初始化为长度为1的三角形");
		}
		EPolygon p2 =new EPolygon(edge,length);
		scanner.close();
		System.out.println("p2的对角线数为: "+p2.getDiagonal());
		System.out.println("p2的面积为: "+p2.getArea());
		scanner.close();
	}
	
	public void demo2_oo(){							//继承性,父类private方法和变量可以继承,但不能使用"super."后面没有弹出东西
		
		System.out.println("输入正三角形(3)或者正方形(4),再输入它的边长: ");
		Scanner scanner =new Scanner(System.in);
		int edge = scanner.nextInt();
		double length =scanner.nextDouble();
		if( (edge != 3 && edge !=4 )|| length<=0){	
			edge = 3;	length = 1;
			System.out.println("输入错误,默认为长度为1的正三角形");
		}
		if(edge == 3){
			ETriangle p1 = new ETriangle(length);
			System.out.println("三角形周长为: "+p1.getPerimeter());	//调用父类EPolygon的方法
			System.out.println("三角形面积为: "+p1.getArea());		//调用父类EPolygon的方法
		}
		else if(edge == 4){
			Square p1 =new Square(length);
			System.out.println("正方形周长为: "+p1.getPerimeter());
			System.out.println("正方形面积为: "+p1.getArea());		//getArea用的是Square的方法,覆盖了父类的方法
		}
		scanner.close();
	}
	
	public void demo3_oo(){						//抽象类,实现多态的一种途径
												//统一用抽象类对象来引用不同子类对象，调用相同的方法，出现的效果不同，实现多态
		int i = 77;
		Graph a =new EPolygon(i,2.33);			//Graph是抽象类,不能实例化Graph,只能实例化它的子类EPolygon,Circle
		Graph b =new Circle(3);					//自动类型提升,圆形对象提升了图形类型,但是圆形的特有功能无法访问
		Graph c =new Square(6.66);				//可以直接从爷爷实例化孙子
		c.statement();							//调用抽象类的非抽象方法
		/*
		 * a,b,c调用的getPerimeter()和getArea()都是Graph中的方法
		 * a调用不了EPolygon类中的getDiagonal()求对角线方法
		 */
		System.out.println("形状a是正"+i+"边形,它周长为 "+a.getPerimeter()+" ,面积为 "+a.getArea());
		System.out.println("形状b是圆形,它周长为 "+b.getPerimeter()+" ,面积为 "+b.getArea());
		System.out.println("形状c是正方形,它周长为 "+c.getPerimeter()+" ,面积为 "+c.getArea());
	}
	
	public void demo4_oo(){						//多态
												//没用多态时一个类对应一个getArea();a.getArea();b.getArea();
												//多态后一个duotai_getArea()对应多个对象
												//duotai_getArea(a);duotai_getArea(b);	
		Scanner scanner =new Scanner(System.in);
		//圆形
		System.out.println("请输入圆形的半径 ：");
		double r = scanner.nextDouble();
		Circle c = new Circle(r);
		display(c);
			
		//正多边形
		System.out.println("请分别输入正多边形的边数和长度 ：");
		int edge = scanner.nextInt();
		double length = scanner.nextDouble();
		EPolygon ep =new EPolygon(edge,length);
		display(ep);
		
		
		scanner.close();
		/*
		 * 多边形...
		 * 实例化对象a
		 * duotai_gerPerimeter(a);
		 * 
		 * 线段和曲线构成的图形
		 * 实例化对象b
		 * duotai_getPerimeter(b);
		 * ...
		 * 
		 * 他们都是Grap的子类,都有同样的方法(求周长,面积...(子类重写了方法)),用相同的接口实现多态
		 * 只要是图形的子类都可以通过duotai_getPerimeter(Graph g)传进来
		 */
	}
	private String duotai_getPerimeter(Graph g){	//多态
		return g.getPerimeter();
	}
	
	private String duotai_getArea(Graph g){		//多态
		return g.getArea();
	}
	
	public void demo5_oo(){						//转型,向上转型,向下转型,转型和造型意思一样

		
		
		Graph g = new EPolygon(12,1);			//"向上转型",自动类型提升,正方形对象提升了等边多边形类型,
												//但是正方形的特有功能无法访问(多态的局限性)
		EPolygon ep = (EPolygon)g;				//但是g不能使用getDiagonal()函数得到对角线数
												//如果想用该对象的特有功能可以进行"向下转型"
		System.out.println("正方形的面积为 ： "+duotai_getArea(g));
		System.out.println("正方形的对角线为 ： "+ep.getDiagonal());		
												//向下转型是为了在拥有多态的好处同时(易维护,拓展性,限定子类功能),使用子类中的特有方法
		/*
		 * 始终都是子类类型进行转化
		 * 转型  = 造型
		 * 
		 * 可以									可以将圆形转换成圆形
		 * Sector s =new Circle(3);				这里创建Circle类的实例s,已经确定是一个圆形(new Circle())
		 * 										把圆形提升为扇形,圆形是一种扇形
		 * Circle c =(Circle)s;					已经实例化(已经确定是圆形)再把扇形降低为圆形
		 * 
		 * 不行									不能new Sector(3);不能将扇形转换成圆形
		 * Sector s =new Sector(3);				没有提升,创建扇形类的实例s(可能是扇形也可能是圆形)
		 * Circle c =(Circle)c;					把这个扇形实例(可能是扇形,可能是圆形)降低为圆形,然而不一定是圆形
		 * 	
		 * 不行									不具备继承关系,不能把正多边形转为扇形
		 * Graph g =new EPolygon();				
		 * Sector s =(Sector)g;					
		 */
	}
	
	public void demo6_oo(){						//instanceof 判断对象属于哪种类型

		
		Circle a =new Circle();					//obj instanceof class
		Sector s = new Sector();
		Sector ss = new Circle();
		if(a instanceof Graph)//ture			//返回为true的条件
			System.out.println("a是Graph类型");	//obj 是 class 的对象或者obj 是 class 子类的对象
		if (a instanceof Circle)//true
			System.out.println("a是Circle类型");
		if(a instanceof Sector)//true
			System.out.println("a是Sector类型");

		if(s instanceof Circle)//false
			System.out.println("s是Circle类型");
		if(s instanceof Graph)//true
			System.out.println("s是Graph类型");
		if(s instanceof Sector)//true
			System.out.println("s是Sector类型");
		
		if(ss instanceof Circle)//true
			System.out.println("ss是Circl类型");
		if (ss instanceof Sector)//true
			System.out.println("ss是Sector类型");
		if(ss instanceof Graph)//true
			System.out.println("ss是Graph类型");
	}
	private void display(Graph g){				//instanceof 用于判断具体类型,通常在需要下转型的时候判断,预防出现转型失败,
												//增强代码健壮性
		
												//父类  a; a instanceof 子类  是返回true，不是返回false
		
		if(g instanceof EPolygon){
			EPolygon ep = (EPolygon)g;			//下转型,可以调用子类特有的方法,如求对角线数
			System.out.println("周长为  "+duotai_getPerimeter(ep)+" ,面积为 "+duotai_getArea(ep)+" ,对角线数为 "+ep.getDiagonal());
		}
		else if(g instanceof Sector){
			Sector s = (Sector)g;
			System.out.println("周长为  "+duotai_getPerimeter(s)+" ,面积为 "+duotai_getPerimeter(s)+" ,弧长为 "+s.getRadian());
		}
		//else if ...
		else
			System.out.println("周长为  "+duotai_getPerimeter(g)+" ,面积为 "+duotai_getPerimeter(g));
	}
	public void demo7_oo(){						//先用instanceof判断对象的类型,再根据具体类型考虑是否需要向下转型来使用子类特有功能
		
		Square square =new Square();
		Graph g1 =new ETriangle();
		Graph g2 =new EPolygon(77,1);
		Graph g3 =new Sector(1,270);
		Sector sector =new Sector();
		display(square);
		display(g1);
		display(g2);
		display(g3);
		display(sector);
	}

}
