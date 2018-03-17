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

	public void demo1_array() {			//一维数组和二维数组的声明和定义
		// TODO Auto-generated method stub
		/*
		 * {int a;}大括号外a已释放内存。 局部代码块，用来限定变量的生命周期
		 * 栈内存存储局部变量
		 * 堆内存malloc和new申请的区域
		 * 格式：
		 * 元素类型[] 数组名 = new 元素类型[元素个数或数组长度];
		 * int[] a =new int[5];
		 * 元素类型[] 数组名 = new 数组类型[]{元素,元素,...,元素};
		 * int[] b =new int[]{1,2,3,4,5};//常规初始化方式
		 * int[] b ={1,2,3,4,5};//静态初始化方式
		 * 容器是实体，new的作用实例化一个对象
		 * 声明实例化一个数组后，堆里存放数组元素，栈里存放指向堆里数组中第一个元素的地址
		 * 
		 * sop(arr); //通常用于测试，看@前面判断是什么类型实体
		 * 输出：[I@3b280492
		 * [I：实体的类型，[->数组型实体，I->int型
		 * @分界线
		 * 3b280492(十六进制)：数组实体的哈希值，用哈希算法定义实体在内存中存储的位置
		 */
		
		/*
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++)
			arr[i] = (i+1)*(i+1);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		 */
		
		//二维数组声明和初始化1
		/*
		char[][] a = new char[][]{{'b','v'},{'e','d'},{'o','m'},{'p','q'},{'t','f'}};//a[5][2];里面的大括号有几个元素说明有几列，有几个{}就有几行
		System.out.println("二维数组元素为 ");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print("a["+i+"] ["+j+"] ="+a[i][j]+"    ");
			}
			System.out.println();
		}
		*/
		
		//二维数组声明和初始化2
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
		
		//二维数组声明和初始化3
		/*
		String s[][];
		s =new String[3][];
		s[0] = new String[3];
		s[1] = new String[6];
		s[2] = new String[1];
		System.out.println("二维数组长度s.length = "+s.length);	//new String[3][] ,3就是二维数组的长度
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[i].length;j++){
				s[i][j] = new String("我的位置是"+i+","+j+"  ");
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		*/
		
	}

	public void demo2_array() {			//找最值及最值的下标
		// TODO Auto-generated method stub
		int temp ,max, min ,maxi = 0 ,mini = 0; 
		int[] arr = new int[5];
		for(int i=0;i<5;i++){	//初始化数组
			temp = (int) (Math.random()*10+1);
			arr[i] = temp;
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		
		max = arr[0]; min = arr[0];
		for(int i=1;i<5;i++){
			if(arr[i]>max){		//除了比较元素还可以比较下标 if(arr[i]>arr[maxi]),前面初始化maxi=0;
				max = arr[i];	// 原因：元素和下标有对应关系
				maxi = i;
			}
			else if(arr[i]<min){
				min = arr[i];
				mini = i;
			}
		}
		System.out.println("数组最大值是 "+max+"数组下标是 "+maxi);
		System.out.println("数组最小值是 "+min+"数组下标是 "+mini);
		
	}

	public void demo3_array() {			//排序函数的使用.Arrays类之只是提供了默认的升序排列，没有提供相应的降序排列方法
											//Arrays.sort(int[]);用优化过的快速排序算法，不稳定.冒泡算法稳定(在循环工程里面)
											//这里没有复合数据类型的排序(如坐标按照横坐标优先排序)
		int a[] = new int[5];
		System.out.print("原数组: ");
		for(int i=0;i<a.length;i++){
			a[i] = (int)(Math.random()*10+1);
			if(a[i]<10)
				System.out.print(" "+a[i]+" ");
			else
				System.out.print(a[i]+" ");
		}System.out.println();
		
		//升序排序
		Arrays.sort(a);						//用优化过的快速排序算法，不稳定
		System.out.print("升序    : ");
		for(int i=0;i<a.length;i++)
			if(a[i]<10)
				System.out.print(" "+a[i]+" ");
			else
				System.out.print(a[i]+" ");
		System.out.println();
		
		//降序排序
														//	int temp;
		for(int i=0;i<a.length/2;i++){		//减少temp空间
			a[i] = a[i] + a[a.length-1-i];				//temp = a[i];					
			a[a.length-1-i] = a[i] - a[a.length-1-i];	//a[i] = a[a.length-1-i];		
			a[i] = a[i] - a[a.length-1-i];				//a[a.length-1-i] = temp;		
		}
		System.out.print("降序    : ");
		for(int i=0;i<a.length;i++)
			if(a[i]<10)
				System.out.print(" "+a[i]+" ");
			else
				System.out.print(a[i]+" ");		
		
	}

	public void demo4_array() {			//数组元素交换位置的方法，数组反序
		// TODO Auto-generated method stub
		/*
		 * 方法一：^异或
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
		 * 方法二：加减法
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
		 * 方法三：临时变量
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

	public void demo5_array() {			//数组查找
											//查找数组中的元素  Arrays只有折半查找 Arrays.binarySearch();
											//	int index = Arrays.binarySearch(a, key);只能找到第一个发现的元素。
											//如果key有多个，用数组存储长度不好定义，用ArrayList
		int[] a ={2,3,5,7,1,9,8,6,1,1,5};
		List<Integer> list = new ArrayList<Integer>();//用数组列表存储数组中key的位置
		int key = 1;//(int)(Math.random()*10);
		//输出原素组
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.println("key = "+key);
		
		//查找,用数组列表存储
		for(int i=0;i<a.length;i++)
			if(a[i] == key)
				list.add(i);
		
		//把数组列表转化成数组对象					
		Object[] obj = list.toArray();			
		
		//输出key的所有位置
		if(list.size()>0){
			for(int i=0;i<list.size();i++)
				System.out.print(obj[i]+" ");
			System.out.println();
		}
		else
			System.out.println("没找到");	
	}

	public void demo6_array() {			//数组列表和数组对象之前的互相转化,不确定数组长度的时候用数组列表
		// TODO Auto-generated method stub
		//数组转化为数组列表
		int[] a =new int[]{1,2,3,4,5,6,7,8};
		ArrayList<Integer> lista =new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++)
			lista.add(a[i]);
		for(int i=0;i<lista.size();i+=2){
			System.out.print("i = "+i+" ");	//
			lista.remove(i);		// remove掉下标为i的元素
		}
			System.out.println();
		
		//数组列表转化为数组
		Object[] object =lista.toArray();
		for(int i=0;i<object.length;i++)
			System.out.print(object[i]+" ");
		System.out.println();
		
		//数组列表转化为数组
		List<Integer> list =new ArrayList<Integer>();
		for(int i=0;i<5;i++)
			list.add(i);
		Object[] obj =list.toArray(); //数组列表转化为数组
		for(int i=0;i<obj.length;i++)
			System.out.print(obj[i]+" ");
		System.out.println();
		
	}

}
