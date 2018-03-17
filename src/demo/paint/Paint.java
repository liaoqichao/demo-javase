package demo.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import demo.DemoInterface;

public class Paint implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 用java来画图(验证码)
		 * 和图片有关的类：
		 * Image、ImageIO、BufferedImage、Icon、ImageIcon
		 * 画验证码,验证码作用：防止恶意注册(防止别人用程序不断的注册,挤爆数据库服务器)和暴力破解(登录时,直接输入ip登录和写程序试账号和密码)。
		 */
//		demo1();
//		demo2();
	}
	public void demo1() throws FileNotFoundException, IOException{
		/*
		 * 随机生成字符,随机生成颜色,随机生成字体,随机生成干扰线
		 */
		//1.得到图片缓冲区
		BufferedImage bi = new BufferedImage(150, 70, BufferedImage.TYPE_INT_RGB);//图片的宽,高,类型
		
		//2.得到绘制环境(这张图片的笔)
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		//3.设置颜色,3,4组合就是设置背景颜色
		g2.setColor(Color.WHITE);
		//4.填充整张图片
		g2.fillRect(0, 0, 150, 70);//左上角坐标,宽,高
		//4.1画边框
		g2.setColor(Color.RED);
		g2.drawRect(0, 0, 149, 69);//宽150是0~149
		
//		5.设置字体
		 g2.setFont(new Font("宋体",Font.BOLD + Font.ITALIC,18));
		 //字体名称,字体样式,字体大小.plain无格式,BOLD粗体,ITALIC斜体，这些样式都是int类型,可以相加
		 g2.setColor(Color.BLACK);//设置颜色
		 
		 //6.向图片写字符串
		 g2.drawString("Hello world", 3, 50);//字符串,字符串左(下/上?)角的坐标
	
		 //7.保存图片	(BufferedImage bi,"保存格式",字节输出流)
		 ImageIO.write(bi, "JPEG", new FileOutputStream("E:\\Eclipse\\IO\\paint\\demo1.jpg"));
	}
	public void demo2(){
		/*
		 * 需求：生成随机验证码(随机字体,大小,颜色,干扰线),宽70,高35
		 */
		
		VerifyCode verifyCode = new VerifyCode();
		verifyCode.createImage();
		System.out.println(verifyCode.getText());
		
	}

}
