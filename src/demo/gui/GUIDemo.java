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
	 * java��GUI������
	 * 
	 * 								Component
	 * 					|---------------------------|
	 * 			Container(������������������)			|----Button
	 * 				|								|----Label
	 * 			|--------|							|----CheckBoxe(��ѡ��)
	 * 		  Window	Panel						|----TextComponent
	 * 			|												|
	 * 		|--------|								|----------------------|
	 * 	  frame		Dialog						TextArea				TextField	
	 * 				 |
	 * 				FileDialog
	 * 
	 * 
	 * ���ֹ�������(���Ҫ��ô��?)
	 * FlowLayout(���ǲ��ֹ�����,������˳������),PanelĬ�ϵĲ��ֹ�����
	 * BorderLayout(�߽粼�ֹ�����,����������),frameĬ�ϵĲ��ֹ�����
	 * GridLayout(���񲼾ֹ�����,����ľ���)
	 * CardLayout(��Ƭ���ֹ�����,ѡ�)
	 * GridBagLayout(��������ֹ�����,�ǹ���ľ���)
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();//װ���,������ק���
		//demo7();
		//demo8();
		//demo9();
	}
	public void demo1(){		//frame
		/*
		 * 1����������,�����ô�С��λ��
		 * 2�����ò���
		 * 3��������
		 * 4��setVisible()��ʾ����
		 */
		Frame frame = new Frame("Demo1");//�е������߳̿���ͼ�ν��� , ���OVER��,ͼ�ν��滹����ʾ��Ҫ������̨��ǿ����ֹ�Ž�������
//		frame.setSize(500, 400);//��һ��������x��,�ڶ���������y��
//		frame.setLocation(400, 200);//���ô��ڳ��ֵ�λ��, Size��Location��x,y��������ֵ
		frame.setBounds(400, 200, 500, 400);//x,y,weight,length, ����ǰ���2��
		frame.setLayout(new FlowLayout());	//������ʽ����
		Button  button = new Button("һ����ť"); //�����ť�͸ղŵĴ���û��ϵ
		frame.add(button);					  //������������ť,�ᷢ�ְ�ť������������(��ΪFrameĬ�ϱ߽粼��,����û��ָ������������)
		
		frame.setVisible(true);
		
	}
	public void demo2(){		//�¼���������(�������)
		/*
		 * �¼��������ƵĻ������
		 * 1.�¼�Դ(���,�����¼�������)
		 * 2.�¼�(Event)
		 * 3.������(Listener)
		 * 4.�¼�����(�����¼�����ʽ)
		 */
		Frame frame = new Frame("demo2");		//�½�����
		frame.setBounds(400, 200, 500, 400);	//���ô�С
		frame.setLayout(new FlowLayout());		//���ò���
		
		frame.addWindowListener(new WindowAdapter(){
			/**
			 * ����������WindowAdapter Ϊ�˴���������(��ʵ�ֲ��ַ���)���������ĳ�����ķ��������ǳ��󷽷�,��Ϊ�˿���ѡ���override 
			 */
			
			public void windowClosing(WindowEvent e) {//���Ͻǵ�x
				//System.out.println("closing ...");
				System.exit(0);
			}
			
		});				//��Ӵ��������
		frame.setVisible(true);					//���ÿ���
	}
	public void demo3(){		//�ڰ�ť�ϼ���һ������(�����)
		
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

		Button button = new Button("�˳�");
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
	public void demo4(){		//�������¼�
		
		/*
		 * ��һ����ť�л�����¼����������¼�. �������������¼�
		 */
		Frame f = new Frame("demo4");
		f.setBounds(400,200,500,400);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter(){
			//��ΪWindowListener����3������Ҫoverride������WindowAdapter��ѡ��override������
			//XXListener����3����������XXAdapter��ѡ��XXListener�еķ�����override
			//���˻�����¼�,����һ�㶼��������

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		//����ı�������Ͱ�ť���
		final TextField tf = new TextField(15);
		f.add(tf);
		Button button = new Button("Button");
		f.add(button);
		//�ڰ�ť�����������
		button.addMouseListener(new MouseAdapter(){
			private int enteredCount = 1;
			private int doubleClickCount = 1;
			@Override
			public void mouseEntered(MouseEvent e) {	//����ƶ�����ť����ʹ����¼�,�Ƴ�������� MouseExited(MouseEvent e)�˳���ʱ�򴥷�ʱ��
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
				 * BUTTON1 �����2�Ҽ���3����  ClickCount �������
				 */
			}
			
		});
		f.setVisible(true);
	}
	public void demo5(){		//���̼����¼�
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
		//---------�ı�����Ӽ��̼����¼�
		tf.addKeyListener(new KeyAdapter(){

			/**
			 * keyPress		����
			 * keyRelease	�ɿ�
			 * keyType		�������ɿ�
			 */
			@Override
			public void keyPressed(KeyEvent e) {	 //ֻҪ���ı����ڰ��¼��̾��ڿ���̨���
				/*
				 * KeyEvent�Ѽ��̵����еļ���������˳���  VK_XX(VK_1��VK_HOME,VK_SPACE)
				 * ��ͨ�ĵ��Զ���F1~F12 ��Щ���͵Ļ���F24
				 */
				// TODO Auto-generated method stub
				super.keyPressed(e);
				//System.out.println("keyPressed.."+e.getKeyChar());//ֻ�ܽ����ַ����ܽ���Shift,F1��
				
				//System.out.println("keyPressed.."+KeyEvent.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
				//KeyEvent.getKeyText(e.getKeyCode())�������F1��Shift�ȼ�
				//ֻ��������
				int code = e.getKeyCode();
				if(!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)){
					e.consume();//�䲻�����������.ʹ�ô��¼�,�Ա㲻�ᰴ��Ĭ�Ϸ�ʽ�ɲ������¼���Դ������������¼�
				}
				if(e.isControlDown() && code==KeyEvent.VK_ENTER){//ͬʱ��Ctrl+Enter
					System.out.println("ctrl+enter :"+tf.getText());
				}
			}
			
		});
		f.add(tf);
		//---------��ť��Ӽ��̼����¼�
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
		 * ����1,2��װjiglooʧ��.Eclipse��JDK�汾����
		 * ����������װwindowbuilder
		 * Help->Install new SoftWare ���·�� http://download.eclipse.org/windowbuilder/WB/integration/4.5/
		 * Ȼ����һ��,��ͬ��,�����ز���װ
		 * ɾ����ʱ��Help->Install new SoftWare,�ҵ�What is already installed ѡ����Ҫ�Ĳ���������uninstall
		 * //�����װ�ɹ�
		 */
	}
	public void demo7(){
		//�Ӽ��˳��ļ�����.������������Ϊ������
		System.out.println("�򵥵�������");
		//��ͼ�ν���ķ���
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
		 * �ӹ�����������
		 * ��һ��JScrollPane sp;��sp�����JTextArea ta
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
