package demo.collectionFreamwork.arrayDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import demo.collectionFreamwork.CollectionFreamwork;


public class ArrayDemo implements CollectionFreamwork {
	
	public void demo(){
		//demo1_array();
		//demo2_array();
		//demo3_array();
		//demo4_array();
		//demo5_array();
		//demo6_array();
	}

	public void demo1_array() {			//һά����Ͷ�ά����������Ͷ���
		// TODO Auto-generated method stub
		/*
		 * {int a;}��������a���ͷ��ڴ档 �ֲ�����飬�����޶���������������
		 * ջ�ڴ�洢�ֲ�����
		 * ���ڴ�malloc��new���������
		 * ��ʽ��
		 * Ԫ������[] ������ = new Ԫ������[Ԫ�ظ��������鳤��];
		 * int[] a =new int[5];
		 * Ԫ������[] ������ = new ��������[]{Ԫ��,Ԫ��,...,Ԫ��};
		 * int[] b =new int[]{1,2,3,4,5};//�����ʼ����ʽ
		 * int[] b ={1,2,3,4,5};//��̬��ʼ����ʽ
		 * ������ʵ�壬new������ʵ����һ������
		 * ����ʵ����һ������󣬶���������Ԫ�أ�ջ����ָ����������е�һ��Ԫ�صĵ�ַ
		 * 
		 * sop(arr); //ͨ�����ڲ��ԣ���@ǰ���ж���ʲô����ʵ��
		 * �����[I@3b280492
		 * [I��ʵ������ͣ�[->������ʵ�壬I->int��
		 * @�ֽ���
		 * 3b280492(ʮ������)������ʵ��Ĺ�ϣֵ���ù�ϣ�㷨����ʵ�����ڴ��д洢��λ��
		 */
		
		/*
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++)
			arr[i] = (i+1)*(i+1);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		 */
		
		//��ά���������ͳ�ʼ��1
		/*
		char[][] a = new char[][]{{'b','v'},{'e','d'},{'o','m'},{'p','q'},{'t','f'}};//a[5][2];����Ĵ������м���Ԫ��˵���м��У��м���{}���м���
		System.out.println("��ά����Ԫ��Ϊ ");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print("a["+i+"] ["+j+"] ="+a[i][j]+"    ");
			}
			System.out.println();
		}
		*/
		
		//��ά���������ͳ�ʼ��2
		/*
		int[][] a =new int[3][4];
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				a[i][j]=i+j;
				System.out.print("a["+i+"] ["+j+"] ="+a[i][j]+"   ");
			}
			System.out.println();
		}
		*/
		
		//��ά���������ͳ�ʼ��3
		/*
		String s[][];
		s =new String[3][];
		s[0] = new String[3];
		s[1] = new String[6];
		s[2] = new String[1];
		System.out.println("��ά���鳤��s.length = "+s.length);	//new String[3][] ,3���Ƕ�ά����ĳ���
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[i].length;j++){
				s[i][j] = new String("�ҵ�λ����"+i+","+j+"  ");
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		*/
		
	}

	public void demo2_array() {			//����ֵ����ֵ���±�
		// TODO Auto-generated method stub
		int temp ,max, min ,maxi = 0 ,mini = 0; 
		int[] arr = new int[5];
		for(int i=0;i<5;i++){	//��ʼ������
			temp = (int) (Math.random()*10+1);
			arr[i] = temp;
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		
		max = arr[0]; min = arr[0];
		for(int i=1;i<5;i++){
			if(arr[i]>max){		//���˱Ƚ�Ԫ�ػ����ԱȽ��±� if(arr[i]>arr[maxi]),ǰ���ʼ��maxi=0;
				max = arr[i];	// ԭ��Ԫ�غ��±��ж�Ӧ��ϵ
				maxi = i;
			}
			else if(arr[i]<min){
				min = arr[i];
				mini = i;
			}
		}
		System.out.println("�������ֵ�� "+max+"�����±��� "+maxi);
		System.out.println("������Сֵ�� "+min+"�����±��� "+mini);
		
	}

	public void demo3_array() {			//��������ʹ��.Arrays��ֻ֮���ṩ��Ĭ�ϵ��������У�û���ṩ��Ӧ�Ľ������з���
											//Arrays.sort(int[]);���Ż����Ŀ��������㷨�����ȶ�.ð���㷨�ȶ�(��ѭ����������)
											//����û�и����������͵�����(�����갴�պ�������������)
		int a[] = new int[5];
		System.out.print("ԭ����: ");
		for(int i=0;i<a.length;i++){
			a[i] = (int)(Math.random()*10+1);
			if(a[i]<10)
				System.out.print(" "+a[i]+" ");
			else
				System.out.print(a[i]+" ");
		}System.out.println();
		
		//��������
		Arrays.sort(a);						//���Ż����Ŀ��������㷨�����ȶ�
		System.out.print("����    : ");
		for(int i=0;i<a.length;i++)
			if(a[i]<10)
				System.out.print(" "+a[i]+" ");
			else
				System.out.print(a[i]+" ");
		System.out.println();
		
		//��������
														//	int temp;
		for(int i=0;i<a.length/2;i++){		//����temp�ռ�
			a[i] = a[i] + a[a.length-1-i];				//temp = a[i];					
			a[a.length-1-i] = a[i] - a[a.length-1-i];	//a[i] = a[a.length-1-i];		
			a[i] = a[i] - a[a.length-1-i];				//a[a.length-1-i] = temp;		
		}
		System.out.print("����    : ");
		for(int i=0;i<a.length;i++)
			if(a[i]<10)
				System.out.print(" "+a[i]+" ");
			else
				System.out.print(a[i]+" ");		
		
	}

	public void demo4_array() {			//����Ԫ�ؽ���λ�õķ��������鷴��
		// TODO Auto-generated method stub
		/*
		 * ����һ��^���
		 * 		a = a^b;
		 * 		b = a^b;
		 * 		a = a^b;
		 */
		char[] arr = new char []{'g','n','i','w','o','r','G'};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		for(int i=0;i<arr.length/2;i++){
			arr[i] = (char) (arr[i]^arr[arr.length-1-i]);
			arr[arr.length-1-i] = (char) (arr[i]^arr[arr.length-i-1]);
			arr[i] = (char) (arr[i]^arr[arr.length-i-1]);
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		
		/*
		 * ���������Ӽ���
		 * 		a = a + b;
		 * 		b = a - b;
		 * 		a = a - b;
		 */	
		char[] a = new char []{'k','o','n','a','n'};
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		for(int i=0;i<a.length/2;i++){
			a[i] = (char) (a[i] + a[a.length-1-i]);
			a[a.length-1-i] = (char) (a[i] - a[a.length-i-1]);
			a[i] = (char) (a[i] - a[a.length-i-1]);
		}
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		/*
		 * ����������ʱ����
		 * 		temp = a;
		 * 		a = b;
		 * 		b = temp;
		 */
		char[] b = new char []{'Y','u','-','G','i','-','O','h'};
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		char temp;
		for(int i=0;i<b.length/2;i++){
			temp = b[i];
			b [i] = b[b.length-1-i];
			b[b.length-1-i] = temp;
		}
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
		
	}

	public void demo5_array() {			//�������
											//���������е�Ԫ��  Arraysֻ���۰���� Arrays.binarySearch();
											//	int index = Arrays.binarySearch(a, key);ֻ���ҵ���һ�����ֵ�Ԫ�ء�
											//���key�ж����������洢���Ȳ��ö��壬��ArrayList
		int[] a ={2,3,5,7,1,9,8,6,1,1,5};
		List<Integer> list = new ArrayList<Integer>();//�������б�洢������key��λ��
		int key = 1;//(int)(Math.random()*10);
		//���ԭ����
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.println("key = "+key);
		
		//����,�������б�洢
		for(int i=0;i<a.length;i++)
			if(a[i] == key)
				list.add(i);
		
		//�������б�ת�����������					
		Object[] obj = list.toArray();			
		
		//���key������λ��
		if(list.size()>0){
			for(int i=0;i<list.size();i++)
				System.out.print(obj[i]+" ");
			System.out.println();
		}
		else
			System.out.println("û�ҵ�");	
	}

	public void demo6_array() {			//�����б���������֮ǰ�Ļ���ת��,��ȷ�����鳤�ȵ�ʱ���������б�
		// TODO Auto-generated method stub
		//����ת��Ϊ�����б�
		int[] a =new int[]{1,2,3,4,5,6,7,8};
		ArrayList<Integer> lista =new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++)
			lista.add(a[i]);
		for(int i=0;i<lista.size();i+=2){
			System.out.print("i = "+i+" ");	//
			lista.remove(i);		// remove���±�Ϊi��Ԫ��
		}
			System.out.println();
		
		//�����б�ת��Ϊ����
		Object[] object =lista.toArray();
		for(int i=0;i<object.length;i++)
			System.out.print(object[i]+" ");
		System.out.println();
		
		//�����б�ת��Ϊ����
		List<Integer> list =new ArrayList<Integer>();
		for(int i=0;i<5;i++)
			list.add(i);
		Object[] obj =list.toArray(); //�����б�ת��Ϊ����
		for(int i=0;i<obj.length;i++)
			System.out.print(obj[i]+" ");
		System.out.println();
		
	}

}
