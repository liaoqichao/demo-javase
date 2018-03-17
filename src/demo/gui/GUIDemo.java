package demo.gui;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import demo.DemoInterface;

public class GUIDemo implements DemoInterface {

	/**
	 * java的GUI不常用
	 * 
	 * 								Component
	 * 					|---------------------------|
	 * 			Container(里面可以添加组件的组件)			|----Button
	 * 				|								|----Label
	 * 			|--------|							|----CheckBoxe(复选框)
	 * 		  Window	Panel						|----TextComponent
	 * 			|												|
	 * 		|--------|								|----------------------|
	 * 	  frame		Dialog						TextArea				TextField	
	 * 				 |
	 * 				FileDialog
	 * 
	 * 
	 * 布局管理器：(组件要怎么放?)
	 * FlowLayout(流是布局管理器,从左到右顺序排列),Panel默认的布局管理器
	 * BorderLayout(边界布局管理器,东南西北中),frame默认的布局管理器
	 * GridLayout(网格布局管理器,规则的矩阵)
	 * CardLayout(卡片布局管理器,选项卡)
	 * GridBagLayout(网格包布局管理器,非规则的矩阵)
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();//装插件,可以拖拽组件
		//demo7();
		//demo8();
		//demo9();
	}
	public void demo1(){		//frame
		/*
		 * 1：创建窗体,并设置大小和位置
		 * 2：设置布局
		 * 3：添加组件
		 * 4：setVisible()显示窗体
		 */
		Frame frame = new Frame("Demo1");//有单独的线程控制图形界面 , 输出OVER后,图形界面还在显示，要按控制台的强制终止才结束进程
//		frame.setSize(500, 400);//第一个参数是x轴,第二个参数是y轴
//		frame.setLocation(400, 200);//设置窗口出现的位置, Size和Location的x,y都是像素值
		frame.setBounds(400, 200, 500, 400);//x,y,weight,length, 等于前面的2句
		frame.setLayout(new FlowLayout());	//设置流式布局
		Button  button = new Button("一个按钮"); //这个按钮和刚才的窗体没关系
		frame.add(button);					  //窗体添加这个按钮,会发现按钮充满整个窗体(因为Frame默认边界布局,而且没有指定东南西北中)
		
		frame.setVisible(true);
		
	}
	public void demo2(){		//事件监听机制(窗体监听)
		/*
		 * 事件监听机制的基本组成
		 * 1.事件源(组件,承载事件的载体)
		 * 2.事件(Event)
		 * 3.监听器(Listener)
		 * 4.事件处理(引发事件后处理方式)
		 */
		Frame frame = new Frame("demo2");		//新建窗体
		frame.setBounds(400, 200, 500, 400);	//设置大小
		frame.setLayout(new FlowLayout());		//设置布局
		
		frame.addWindowListener(new WindowAdapter(){
			/**
			 * 窗体适配器WindowAdapter 为了创建监听器(并实现部分方法)，所以他的抽象父类的方法都不是抽象方法,是为了可以选择的override 
			 */
			
			public void windowClosing(WindowEvent e) {//右上角的x
				//System.out.println("closing ...");
				System.exit(0);
			}
			
		});				//添加窗体监听器
		frame.setVisible(true);					//设置可视
	}
	public void demo3(){		//在按钮上加上一个监听(活动监听)
		
		Frame f = new Frame("demo3");
		f.setBounds(400, 200, 500, 400);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
			
		});

		Button button = new Button("退出");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		f.add(button);
		
		f.setVisible(true);
		
	}
	public void demo4(){		//鼠标监听事件
		
		/*
		 * 当一个按钮有活动监听事件和鼠标监听事件. 先运行鼠标监听事件
		 */
		Frame f = new Frame("demo4");
		f.setBounds(400,200,500,400);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter(){
			//因为WindowListener超过3个方法要override所以有WindowAdapter来选择override的内容
			//XXListener超过3个方法都有XXAdapter来选择XXListener中的方法来override
			//除了活动监听事件,其他一般都有适配器

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		//添加文本框组件和按钮组件
		final TextField tf = new TextField(15);
		f.add(tf);
		Button button = new Button("Button");
		f.add(button);
		//在按钮上添加鼠标监听
		button.addMouseListener(new MouseAdapter(){
			private int enteredCount = 1;
			private int doubleClickCount = 1;
			@Override
			public void mouseEntered(MouseEvent e) {	//鼠标移动到按钮那里就触发事件,移出不会出发 MouseExited(MouseEvent e)退出的时候触发时间
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				//System.out.println("Mouse Entered..."+count++);
				tf.setText("Mouse Entered..."+enteredCount++);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(e.getClickCount() ==2){
					tf.setText("Double click "+doubleClickCount++);
				}
				//System.out.println(e);
				//java.awt.event.MouseEvent[MOUSE_CLICKED,(33,14),absolute(725,249),
				//button=1,modifiers=Button1,clickCount=1] on button0
				/*
				 * BUTTON1 左键，2右键，3滚轮  ClickCount 点击次数
				 */
			}
			
		});
		f.setVisible(true);
	}
	public void demo5(){		//键盘监听事件
		Frame f = new Frame("demo5");
		f.setBounds(400, 200, 500, 400);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		final TextField tf = new TextField(15);
		//---------文本框添加键盘监听事件
		tf.addKeyListener(new KeyAdapter(){

			/**
			 * keyPress		按下
			 * keyRelease	松开
			 * keyType		按下再松开
			 */
			@Override
			public void keyPressed(KeyEvent e) {	 //只要在文本框内按下键盘就在控制台输出
				/*
				 * KeyEvent把键盘的所有的键都定义成了常量  VK_XX(VK_1，VK_HOME,VK_SPACE)
				 * 普通的电脑都是F1~F12 有些大型的机到F24
				 */
				// TODO Auto-generated method stub
				super.keyPressed(e);
				//System.out.println("keyPressed.."+e.getKeyChar());//只能接受字符不能接受Shift,F1等
				
				//System.out.println("keyPressed.."+KeyEvent.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
				//KeyEvent.getKeyText(e.getKeyCode())可以输出F1，Shift等键
				//只输入数字
				int code = e.getKeyCode();
				if(!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)){
					e.consume();//输不了数字以外的.使用此事件,以便不会按照默认方式由产生此事件的源代码来处理此事件
				}
				if(e.isControlDown() && code==KeyEvent.VK_ENTER){//同时按Ctrl+Enter
					System.out.println("ctrl+enter :"+tf.getText());
				}
			}
			
		});
		f.add(tf);
		//---------按钮添加键盘监听事件
		Button button = new Button("Button");
		button.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					System.out.println("enter");
				}
			}
			
		});
		f.add(button);
		f.setVisible(true);
	}
	public void demo6(){
		/*
		 * 方法1,2安装jigloo失败.Eclipse和JDK版本过高
		 * 方法三：安装windowbuilder
		 * Help->Install new SoftWare 添加路径 http://download.eclipse.org/windowbuilder/WB/integration/4.5/
		 * 然后下一步,我同意,就下载并安装
		 * 删除的时候Help->Install new SoftWare,找到What is already installed 选择需要的插件点下面的uninstall
		 * //结果安装成功
		 */
	}
	public void demo7(){
		//加减乘除的计算器.两个数均可以为正负数
		System.out.println("简单的运算器");
		//打开图形界面的方法
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing frame = new MySwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void demo8(){
		/*
		 * 加滚动条方法：
		 * 加一个JScrollPane sp;在sp里面放JTextArea ta
		 */
		System.out.println("demo8");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFileList frame = new MyFileList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void demo9(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMenu frame = new MyMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
}
