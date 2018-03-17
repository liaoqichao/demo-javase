package demo.loop;

import demo.DemoInterface;

public class Loop implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		//demo1_for();
		//demo2_for();
		//demo1_dowhile();
		//demo1_nestedLoop();
		//demo2_nestedLoop();
		//demo3_nestedLoop();
		//demo4_nestedLoop();
		//demo5_nestedLoop();
		//demo6_nestedLoop();
		//demo7_nestedLoop();
		//demo1_continue();
		//demo2_continue();

	}
	 public void demo1_for(){
		/*
		 * 用for完成累加
		 */
		int sum = 0;
		for(int i=1; i<10; i++)
			sum =sum + i;
		System.out.println("Sum = "+sum);
					
		/* 
		 * for和while的区别
		 * for(int x=1;i<=5;i++){输出1~5}  输出x报错    				//for循环结束，x内存释放
		 * int y=5; while(y<=5){//输出1~5;y++;} 输出y ，y值为6 	 	//
		 */
			
		/*
		 * 无限循环
		 * while(true){}
		 * for(;;){}  //for(可以没有;没有默认true;可以没有)
		 */
		
		/*
		 * for(初始化表达式;循环条件表达式;循环后的操作表达式){循环体}
		 * for(int a=0 ,b=1;a<3;a++,b--){}
		 */
	 }
	 public void demo2_for(){
		int a =0 ,b =0 ,c =0 ,d=0 ,x=1 ,y=1;
		for(System.out.println("初始化表达式:"+a),x = a + x;			//初始化表达式
				b<3&&d<4;											//条件表达式
				System.out.println("循环后的操作表达式:"+c),y = y + c){	//循环后的操作表达式
			System.out.println("循环体:"+b);
			System.out.println("x = "+x);
			System.out.println("y = "+y);
			a++;
			b++;
			c++;
			d+=2;
		}
	}
	 public void demo1_dowhile(){
		 //while后面有分号
		 int x = 1;
		 do{
			 System.out.println("x = "+x);
			 x++;
		 }while(x<3);
	 }
	 public void demo1_nestedLoop(){
		 /*
		  * 重复->用循环(x=1,2,3,...,n)
		  * 重复的每种情况都有另外的重复(x=1,y=1;x=1,y=2;...x=1,y=m;
		  * 					x=2,y=1;x=2,y=2;...x=2,y=m;
		  * 					x=n,y=1;x=n,y=2;...;x=n,y=m)
		  */
		 //冒泡排序
		 int [] array ={3,5,7,1,9,0,4,6,8,2};
		 int temp =0;
		 for(int x=0;x<array.length-1;x++)
			 for(int y=1;y<array.length-x;y++){
				 if(array[y]<array[y-1]){
					temp =array[y-1];
					array[y-1] =array[y];
					array[y] =temp;
				 }
			 }
		 for(int i=0;i<array.length;i++)
		 	System.out.print(array[i]+" ");
	 }
	 public void demo2_nestedLoop(){
		 /*
		  * *****
		  * *****
		  * *****
		  * *****
		  */
		 for(int i=0;i<4;i++){
			 for(int j=0;j<5;j++)
				 System.out.print("*");
			 System.out.println();
		 }		 
	 }
	 public void demo3_nestedLoop(){
		 /*
		  * 54321
		  * 5432
		  * 543
		  * 54
		  * 5
		  */
		 //1
		 for(int x=0;x<5;x++){			
			 for(int y=5;y>x;y--)			
				 System.out.print(y);			
			 System.out.println();
		 }

		 
		 /*
		 //2
		 for(int x=0;x<5;x++){
			 for(int y=0;y<5-x;y++)
				 System.out.print(5-y);
			 System.out.println();
		 }
		 */	 
	 }
	 public void demo4_nestedLoop(){
		 /*
		  * 1
		  * 22
		  * 333
		  * 4444
		  * 55555
		  */
		 for(int i=1;i<=5;i++){
			 for(int j=0;j<i;j++)
				 System.out.print(i);
			 System.out.println();
		 }
	 }
	 public void demo5_nestedLoop(){
		 /*
		  * 尖朝上for(int j=0;j<i;j++)
		  * 尖朝下for(int j=0;j<5-i;j++)
		  * * * * * *
		  *  * * * * 
		  *   * * *
		  *    * *
		  *     *
		  */
		 for(int i=0;i<5;i++){
			 for(int j=0;j<i;j++)
				 System.out.print(" ");
			 for(int k=0;k<5-i;k++) 
			 	System.out.print("* ");
			 System.out.println();
		 }
	 }
	 public void demo6_nestedLoop(){
		 //九九乘法表
		 for(int i=1;i<=9;i++){
			 for(int j=1;j<=i;j++)
				 if(i*j<10&&j!=1)//使每个式子开头对齐,并且第一列和第二列之间的空格和后面列之间的空格一样
					 System.out.print(i+"*"+j+"="+i*j+"   ");
				 else 
					 System.out.print(i+"*"+j+"="+i*j+"  ");
			 System.out.println();
		 }
	 }
	 public void demo7_nestedLoop(){
		a: for(int i = 0 ; i < 3 ; i++ ){	//给语句起名字,只能用在循环上
		b:	for( int j = 0 ; j < 4 ; j++){
				 if(i==2){
					 System.out.println("i = "+i);
					 break a;				//break外层循环,如果没有给循环起名字默认跳出当前循环(这里是内层循环)
				 }
				 else if(j==3){
					System.out.println("j = "+j);
					break b;				//break内层循环
				 }
			 }
		 }
	 }
	 public void demo1_continue(){
		 
		for(int i = 0 ; i <= 10 ; i++){
			if(i%2==1)
				continue;					//结束本次循环,继续下次循环,立刻跳到i++,然后判断条件
			System.out.println("i = "+i);
			 //下面都是不可达的语句
		 }
	 }
	 @SuppressWarnings("unused")
	public void demo2_continue(){
		 
		a: for(int i = 0 ; i < 5 ; i++)
			 for(int j = 0 ; j < 4 ;  j++){
				System.out.println("i = "+ i);
				continue a;					//结束本次外层循环继续下次外层循环,也就是说内层循环一直是j = 0 , 外层循环i=1,2,3,4
			}
	 }

}
