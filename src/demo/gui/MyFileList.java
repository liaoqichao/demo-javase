package demo.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyFileList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8567533095774114954L;
	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public MyFileList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(30, 25, 291, 21);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					
					showDir(textArea);
					
				}
			}

			private void showDir(JTextArea textArea) {
				String dir_str = textField.getText();
				textArea.setText("");
				File dir = new File(dir_str);
				if(dir.exists() && dir.isDirectory()){
					String[] names = dir.list();
					for(String name : names ){
						//textArea.setText(name);������д
						textArea.append(name+System.getProperty("line.separator"));//���ǲ����Զ�����
					}
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton button = new JButton("\u8F6C \u5230");
		button.setBounds(331, 24, 93, 23);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				 * ͨ�������ť��ȡ�ı����е�Ŀ¼,��Ŀ¼�е�������ʾ���ı�������
				 * ��Ҫ������
				 */
				String dir_str = textField.getText();
				textArea.setText("");
				File dir = new File(dir_str);
				if(dir.exists() && dir.isDirectory()){
					String[] names = dir.list();
					for(String name : names ){
						//textArea.setText(name);������д
						textArea.append(name+System.getProperty("line.separator"));//���ǲ����Զ�����
					}
				}
			}
		});
		contentPane.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 69, 394, 183);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	}
}
