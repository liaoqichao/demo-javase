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
		 * ��java����ͼ(��֤��)
		 * ��ͼƬ�йص��ࣺ
		 * Image��ImageIO��BufferedImage��Icon��ImageIcon
		 * ����֤��,��֤�����ã���ֹ����ע��(��ֹ�����ó��򲻶ϵ�ע��,�������ݿ������)�ͱ����ƽ�(��¼ʱ,ֱ������ip��¼��д�������˺ź�����)��
		 */
//		demo1();
//		demo2();
	}
	public void demo1() throws FileNotFoundException, IOException{
		/*
		 * ��������ַ�,���������ɫ,�����������,������ɸ�����
		 */
		//1.�õ�ͼƬ������
		BufferedImage bi = new BufferedImage(150, 70, BufferedImage.TYPE_INT_RGB);//ͼƬ�Ŀ�,��,����
		
		//2.�õ����ƻ���(����ͼƬ�ı�)
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		//3.������ɫ,3,4��Ͼ������ñ�����ɫ
		g2.setColor(Color.WHITE);
		//4.�������ͼƬ
		g2.fillRect(0, 0, 150, 70);//���Ͻ�����,��,��
		//4.1���߿�
		g2.setColor(Color.RED);
		g2.drawRect(0, 0, 149, 69);//��150��0~149
		
//		5.��������
		 g2.setFont(new Font("����",Font.BOLD + Font.ITALIC,18));
		 //��������,������ʽ,�����С.plain�޸�ʽ,BOLD����,ITALICб�壬��Щ��ʽ����int����,�������
		 g2.setColor(Color.BLACK);//������ɫ
		 
		 //6.��ͼƬд�ַ���
		 g2.drawString("Hello world", 3, 50);//�ַ���,�ַ�����(��/��?)�ǵ�����
	
		 //7.����ͼƬ	(BufferedImage bi,"�����ʽ",�ֽ������)
		 ImageIO.write(bi, "JPEG", new FileOutputStream("E:\\Eclipse\\IO\\paint\\demo1.jpg"));
	}
	public void demo2(){
		/*
		 * �������������֤��(�������,��С,��ɫ,������),��70,��35
		 */
		
		VerifyCode verifyCode = new VerifyCode();
		verifyCode.createImage();
		System.out.println(verifyCode.getText());
		
	}

}
