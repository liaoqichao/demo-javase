package demo.function;

import java.util.Scanner;

import demo.DemoInterface;

public class Function implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub

		//demo1_function();
		//demo2_function();
		//demo3_function();
	}
	
	/*
	 * 1.��ȷ����������ʲô����ȷ�����ķ���ֵ����
	 * 	  ��ӡ������̨�������뵽�ļ��е���void��,����Ҫ�����������ظ�����������
	 * 2.��ȷ�������ʵ�ֵĹ������Ƿ���ҪһЩδ֪(��ȷ��)�����ݲ������㣿��ȷ�������������ͺͲ����ĸ���
	 * 
	 * �������أ�<��ͬһ������>������������ͬ��ֻҪ����<��������> �� <��������>��ͬ����
	 * ����������������������������ԵĶ�̬��
	 * �������ع�������,��������ظ�,��ʱ���Ե��ù��ܸ�ǿ��ĺ���,���ӡ�˷���
	 * print(int num){ // ��ӡnum * num�ĳ˷��� }
	 * print(){ print(9) } ���Ӳ�����Ĭ�ϴ�ӡ�žų˷���
	 * ����������(��2λ�ӷ���nλ�ӷ�,n*n�˷���;žų˷���)ͨ�����Ը��ô���,������������ͨ�������Ը��ô���
	 * 
	 * ��̬����������ǰ��û��public,protected,private������Ĭ��Ϊdefault(friendly,ͬ���ͬ��(package)���Է���,
	 * ���಻���Է���,java��û��friendly�ؼ���)
	 */
	
	
	public void demo1_function(){					//�������������ĺ�
		int a , b;
		Scanner in = new Scanner(System.in);
		System.out.println("��������������: ");
		a = in.nextInt();
		b = in.nextInt();
		int sum;
		sum = demo1_function(a,b);
		System.out.println(a+" + "+b+" = "+sum);
		in.close();
	}
	public int demo1_function(int a,int b){			
		return a+b;	
	}
	
	public void demo2_function(){					//�����������ϴ����
		int a ,b;
		char d ,e ;
		String s = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������������: ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		int c = demo2_function(a,b);
		System.out.println(c);
		
		System.out.println("�����������ַ�: ");
		s = scanner.next();
		d = s.charAt(0);
		s = scanner.next();
		e = s.charAt(0);
		char g = demo2_function(d,e);
		System.out.println(g);
		scanner.close();
	}
	public int demo2_function(int a,int b){			//ͬһ����,ͬһ������,����������ͬ,��������
		return a>b?a:b;								//��Ŀ�����������н��a��b,if else��һ���н��
	}
	public char demo2_function(char a,char b){		//ͬһ����,ͬһ������,����������ͬ,���������Ͳ�ͬ,��������
		return a>b?a:b;
	}
	
	public void demo3_function(){					//�ڿ���̨��ӡ������
		int a ,b;
		String s =null;
		char c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����볤���εĳ��Ϳ�ͱߵ���״: ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		s = scanner.next();
		c = s.charAt(0);
		demo3_function(a,b,c);
		scanner.close();
	}
	public void demo3_function(int row,int col,char c){
		for(int i=0;i<row;i++){
				if(i == 0 || i==row-1){
					for(int j=0;j<col;j++)
						System.out.print(c+" ");
				}
				else{
					for(int j=0;j<col;j++)
						if(j==0 || j== col-1)
							System.out.print(c+" ");
						else
							System.out.print("  ");					
				}
				System.out.println();
		}
	}	

}
