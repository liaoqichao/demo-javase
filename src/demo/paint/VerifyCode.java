package demo.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VerifyCode {

	private String alpha = "23456789abcdefghijkmnpqrstuvwxyz";
	private String[] fonts = {"����","���Ŀ���","����","΢���ź�","����_GB2312"};
	private String text="";
	
	private static final int WIDTH = 70;
	private static final int HEIGHT = 35;
	
	VerifyCode(){}
	
	private Color randomColor(){
		int red = (int)(Math.random()*256);//����0������1 *256 0~55
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		return new Color(red,green,blue);
	}
	
	private Font randomFont(){
		String font = fonts[(int)(Math.random()*5)];
		return new Font(font,Font.BOLD*randomFlag()+Font.ITALIC*randomFlag(),20);
	}
	
	private String randomSingleCode(){
		char ch =  alpha.charAt((int)(Math.random()*alpha.length()-1));
		text = text+String.valueOf(ch);
		return String.valueOf(ch);
	}
	
	private int randomFlag(){
		int[] arr ={0,1};
		return arr[(int)(Math.random()*2)];
	}
	
	private int[] randomLine(){
		int x1,y1,x2,y2;
		x1 = (int)(Math.random()*70);
		y1 = (int)(Math.random()*35);
		x2 = (int)(Math.random()*70);
		y2 = (int)(Math.random()*35);
		int[] arr ={x1,y1,x2,y2};
		return arr;
		
	}
	
	//-------------------�ⲿ���õ�------------------------------
	public void createImage(){
		try {
			
		//���ͼƬ������
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		//��û��ƻ���
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		//���ñ�����ɫ
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT);//rectangle ����
		
		for(int i=0;i<4;i++){
			//��������
			g2.setFont(randomFont());
			//����������ɫ
			g2.setColor(randomColor());
			
			//��ͼƬд���ַ���
			g2.drawString(randomSingleCode(), 10+15*i, 25);
			
			if(randomFlag()==1){
				g2.setColor(randomColor());	//����ɫ
				int[] arr = randomLine();	//��ȡ�ߵ���������
				g2.drawLine(arr[0], arr[1], arr[2], arr[3]);
			}
			
		}
		//����ͼƬ
			ImageIO.write(bi, "JPEG", new FileOutputStream("E:\\Eclipse\\IO\\paint\\demo2.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  String getText(){
		return text;
	}
}
