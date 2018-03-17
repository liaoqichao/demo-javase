package demo.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MyMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7131339766998360184L;
	private JPanel contentPane;
	private JFileChooser jFileChooser;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public MyMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Swing不是线程安全的,所以有可能出现异常
		setBounds(400, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 29, 484, 333);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 31);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6253\u5F00");
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jMenuItemActionPerformed(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void jMenuItemActionPerformed(ActionEvent e) throws IOException {//自己建的
				// TODO Auto-generated method stub
				
				/*jdk1.6例子
			   	jFileChooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");
			    jFileChooser.setFileFilter(filter);
			    int returnVal = jFileChooser.showOpenDialog(new JFrame());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	//这里换成真正的打开文件
			       System.out.println("You chose to open this file: " +
			    		jFileChooser.getSelectedFile().getName());
			    }*/
				
				//把读到的文件打印到TextArea
				jFileChooser = new JFileChooser();
				int returnValue = jFileChooser.showOpenDialog(new JFrame());
				if(returnValue == JFileChooser.CANCEL_OPTION){
					System.out.println("取消");
					return ;
				}
				File file = jFileChooser.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine())!= null){
					textArea.append(line+System.getProperty("line.separator"));
				}
				br.close();	
			}
		});
		mnMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FDD\u5B58");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem2ActionPerformed(e);//为什么windowbuilder没有在组件里面加方法的功能!!
			}

			private void jMenuItem2ActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jFileChooser = new JFileChooser();
				int returnValue = jFileChooser.showSaveDialog(new JFrame());
				if(returnValue == JFileChooser.CANCEL_OPTION){
					System.out.println("取消保存");
					return;
				}
				/*
				 * 在TextArea里面的换行是\n记事本解析不了换行,用word文档就可以
				 */
				File file = jFileChooser.getSelectedFile();
				String s = textArea.getText();
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(file));
					bw.write(s);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		
		JMenu mnMenu_1 = new JMenu("menu2");
		menuBar.add(mnMenu_1);
		
	}
}
