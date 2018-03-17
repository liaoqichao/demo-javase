package demo.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MySwing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1432415165439585187L;
	private JPanel contentPane;
	private JTextField textField;
	private double result = 0;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public boolean operation(String getText){
		/*
		 *  第二个数不能是负数
		 */
		/*
		 * 如果第一个数是负数：
		 * 				如果后面有符号：		int len = Double.valueOf(result).toString().length();
		 *								String neo = all.substring(len);
		 *								String sub = neo.substring(1);
		 * 				如果后面没符号：result = Double.valueOf(all);
		 * 如果第一个数不是负数：
		 * 				如果后面有符号：		。。。
		 * 				如果后面没有符号：result = Double.valueOf(all);
		 */
		String all = getText;//12+23,RESULT = 12
		//要不包含-开头的减号:去下标1开头的字串->如果字符串就1个字符??!
		if(!(all.contains("+")||all.contains("-")||all.contains("*")||all.contains("/"))){
			result = Double.valueOf(all);
			return false;
		}
		else if(all.contains("+")||all.contains("*")||all.contains("/")){
			int len = Double.valueOf(result).toString().length();//+23
			String neo = all.substring(len);
			String sub = neo.substring(1);
			if(neo.startsWith("+")){
				result = result + Double.valueOf(sub);
			}
//			else if(neo.startsWith("-")){
//				result = result - Double.valueOf(sub);
//			}
			else if(neo.startsWith("*")){
				result = result * Double.valueOf(sub);
			}
			else if(neo.startsWith("/")){
				if(sub.equals("0")){
					textField.setText("除数不能为0,请点C清空");
				}
				else{
					result = result / Double.valueOf(sub);
				}
			}
			else{
				result = Double.valueOf(all);
				System.out.println("错误");
				return false;
			}
			return true;
		}
		else if(all.contains("-")){
			int a = all.indexOf("-");
			int b = all.indexOf("-", 1);//没有返回-1
			if(a!=0 && b==-1){
				String sub = all.substring(a+1);
				result = result - Double.valueOf(sub);
			}
			else if(a==0 && b!=-1){//放在判断是否有加乘除后面,这样就避免了在判断第二个字符开始有没有符号,有的话又要运算
				String sub = all.substring(b+1);
				result = result - Double.valueOf(sub);
			}
			else if(a==0 && b==-1){//1个负号没有减号,但是又其他运算符呢?
				//如果没有其他符号则赋值到result,如果有其他符号则运算后赋值到result
				result = Double.valueOf(all);
				System.out.println("result  = " + result);
				return false;
			}
			else if(a!=0 && b!= -1){
				String sub = all.substring(a+1);
				result = result - Double.valueOf(sub);
			}
			else{
				System.out.println("状况外");
			}
			return true;
		}
		else{
			System.out.println("状况外");
			return false;
		}
	}
	public MySwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(100, 21, 300, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"1");
			}
		});
		btnNewButton.setBounds(30, 94, 44, 23);
		contentPane.add(btnNewButton);
		
		JButton button_8 = new JButton("2");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		button_8.setBounds(100, 94, 44, 23);
		contentPane.add(button_8);
		
		JButton button = new JButton("3");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		button.setBounds(171, 94, 44, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("4");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		button_1.setBounds(30, 127, 44, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("5");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		button_2.setBounds(100, 127, 44, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("6");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		button_3.setBounds(171, 127, 44, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("7");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		button_4.setBounds(30, 160, 44, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("8");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		button_5.setBounds(100, 160, 44, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("9");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		button_6.setBounds(171, 160, 44, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("0");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"0");
			}
		});
		button_7.setBounds(100, 193, 44, 23);
		contentPane.add(button_7);
		
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//如果前面有运算符则运算,没有运算符则把前面的字符串作为firNum
				operation(textField.getText());
				textField.setText(result+"+");
			}

		});
		btnNewButton_1.setBounds(243, 94, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button_9 = new JButton("-");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String s = textField.getText();
				if(s.endsWith("+")||s.endsWith("-")||s.endsWith("*")||s.endsWith("/")){
					textField.setText(s+"-");
				}
				else{
					operation(textField.getText());
					textField.setText(result+"-");
				}
			}
		});
		button_9.setBounds(243, 127, 93, 23);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("*");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				operation(textField.getText());
				textField.setText(result+"*");
			}
		});
		button_10.setBounds(243, 160, 93, 23);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("/");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				operation(textField.getText());
				String s = textField.getText();
				if(s.equals("除数不能为0,请点C清空")){
				}
				else{
					textField.setText(result+"/");
				}
			}
		});
		button_11.setBounds(243, 193, 93, 23);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("=");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				operation(textField.getText());
				String s = textField.getText();
				if(s.equals( "除数不能为0,请点C清空")){
					
				}
				else{
					textField.setText(Double.valueOf(result).toString());
				}
			}
		});
		button_12.setBounds(346, 94, 78, 122);
		contentPane.add(button_12);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				result = 0;
				textField.setText("0");
			}
		});
		btnC.setBounds(171, 193, 44, 23);
		contentPane.add(btnC);
		
		JButton btnB = new JButton(".");
		btnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+".");
			}
		});
		btnB.setBounds(30, 193, 44, 23);
		contentPane.add(btnB);
		
		JLabel lblResult = new JLabel("Result = ");
		lblResult.setFont(new Font("宋体", Font.PLAIN, 15));
		lblResult.setBounds(30, 27, 73, 27);
		contentPane.add(lblResult);
	}
}
