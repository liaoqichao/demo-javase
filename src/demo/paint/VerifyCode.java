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
	private String[] fonts = {"宋体","华文楷体","黑体","微软雅黑","楷体_GB2312"};
	private String text="";
	
	private static final int WIDTH = 70;
	private static final int HEIGHT = 35;
	
	VerifyCode(){}
	
	private Color randomColor(){
		int red = (int)(Math.random()*256);//包括0不包括1 *256 0~55
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
	
	//-------------------外部调用的------------------------------
	public void createImage(){
		try {
			
		//获得图片缓冲区
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		//获得绘制环境
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		//设置背景颜色
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT);//rectangle 矩形
		
		for(int i=0;i<4;i++){
			//设置字体
			g2.setFont(randomFont());
			//设置字体颜色
			g2.setColor(randomColor());
			
			//向图片写入字符串
			g2.drawString(randomSingleCode(), 10+15*i, 25);
			
			if(randomFlag()==1){
				g2.setColor(randomColor());	//换颜色
				int[] arr = randomLine();	//获取线的两点坐标
				g2.drawLine(arr[0], arr[1], arr[2], arr[3]);
			}
			
		}
		//保存图片
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
