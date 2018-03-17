package demo.singleton;

import demo.DemoInterface;

public class Singleton implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//test1();
		//test2();
		//test3();

	}
	public void test1(){
		
		SingleEHS s1 = SingleEHS.getInstance();
		SingleEHS s2 = SingleEHS.getInstance();
		s1.setNum(10);
		System.out.println("Demo1 : s1.getNum() = "+s1.getNum());
		System.out.println("Demo1 : s2.getNum() = "+s2.getNum());
		
	}
	public void test2(){
		
		SingleLHS s1 = SingleLHS.getInstance();
		SingleLHS s2 = SingleLHS.getInstance();
		
		s1.setNum(20);
		System.out.println("Demo2 : s1.getNum() = "+s1.getNum());
		System.out.println("Demo2 : s2.getNum() = "+s2.getNum());
		
	}
	public void test3(){
		
		SingleDoubleLock s1 = SingleDoubleLock.getInstance();
		SingleDoubleLock s2 = SingleDoubleLock.getInstance();
		SingleDoubleLock s3 = SingleDoubleLock.getInstance();
		SingleDoubleLock s4 = SingleDoubleLock.getInstance();
		s1.setNum(30);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread t4 = new Thread(s4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
/*
 * 	ģʽ��ƣ�	���ǵĴ�����Ƶľ�����ܽ�,�ձ��˶���Ϊ����д�����ô��롢�ô�������ױ�������⡢��֤����ɿ���
 * 	ΪʲôҪ�ᳫģʽ��ƣ�����ԭ������ߴ��븴��,���ӿ�ά����
 * 	java��23��ģʽ���
 * 	ģʽ��Ƶ�ԭ��
 * 	1."��������"ԭ��
 * 		����չ���뿪��,���޸Ĵ���ر�,�����ٸ�ԭ���Ĵ���
 * 	2.���ϴ���ԭ��
 * 		������ø���Ļ�,����Ҳ����ȫ����
 * 	3.�ϳɸ���ԭ��
 * 		���ü̳�,���úϳɹ�ϵ��ʵ��
 * 	4.������תԭ��
 * 		������������ϸ��,ϸ��Ӧ�������ڳ���Ҫ��Խӿڱ��,��Ҫ�����ʵ���
 * 	5.�ӿڸ���ԭ��
 * 		ʹ�ö��ר�ŵĽӿڱ�ʹ�õ�һ���ܽӿ�Ҫ�á�һ���������һ�����������Ӧ���ǽ�������С�Ľӿ��ϵ�
 * 	6.������
 * 		�õļ̳й�ϵ,Ӧ��ֻ��Ҷ�ӽڵ��Ǿ�����,�����඼�ǳ�����
 * 	7.�����ط���
 * 		һ������Ӧ�����������󾡿����ٵ��˽�
 * 
 *	����ģʽ���:һ������ֻ��1������(���ܿ�new����)
 *	Ϊ�˱�������������ཨ������Ķ���,�ȿ��ƽ��������������������
 *	Ϊ������������Է��ʵ�����Ķ���,ֻ���ڱ����Զ���һ������
 *	Ϊ�˷�����������Ը��Զ������ķ���,�����ṩһЩ���ʷ�ʽ
 *	ʵ�֣�
 *	�����캯��˽�л�
 *	�����д���һ������Ķ���
 *	�ṩһ���������Ի�ȡ���������
 *	��ʽ������ʽ,����ʽ,˫��������ʽ
 *	
 *	����ʽ������ʽ������
 *	����ʽ���̰߳�ȫ��,���ഴ����һ����̬�����ϵͳʹ��ʱ,�Ժ��ٸı�
 *	����ʽ����ڴ���ʵ������ʱ������synchronized,��ᵼ�¶���ķ��ʲ����̰߳�ȫ��
 */
