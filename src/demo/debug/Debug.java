package demo.debug;

import java.util.Arrays;

import demo.DemoInterface;

public class Debug implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * �ϵ����ģʽRun as debug��
		 * debug���ô���	1.	���Գ���
		 * 			 	2.	�鿴����Դ����
		 */
//		demo1();
//		demo2();
	}
	public void demo1(){
		/*
		 * ��1�ӵ�100
		 * 
		 * ��һ�������öϵ�(�ó���ֹͣ�ڶϵ����һ��),˫���к�,����һ�����㡣
		 * �ڶ�����Run as debug,�ᵯ��һ���Ƿ�������ģʽ��ȷ�Ͽ�ѡ��yes��Ŀǰ���öϵ����һ�б����ɫ�������ֹͣ����һ��(��һ��û��ִ��),
		 * û���������С�
		 * ��������˫��sum,�Ҽ�ѡ��watch�����Ͻǳ���Expressions�е�sum,û��ֵ��
		 * ���Ĳ�����F6(ִ����һ�����),sum��ֵ��0,��2�ΰ���һ��,ִ����sum+=i��һ�С�ֵ��1
		 * 		Step Into(f5) Step Over(f6) Step Return(f7) 
		 * 		Resume(f8)��ʾ���Խ���,ֱ���������е���һ���ϵ�,û�жϵ���ֱ�����н�����
		 * ���岽��������Ͻǵ�Java,�ص�Java����
		 */
		int sum = 0;
		for(int i=1; i<=100; i++){
			sum += i;
		}
		System.out.println(sum);
	}
	public void demo2(){
		/*
		 * ��������
		 * ��֪��sort������ʽ����sort���öϵ㡣
		 * Step Into(f5)����Դ����,Step Return(f7)����
		 */
		int[] a = {2,4,1,5,3};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
