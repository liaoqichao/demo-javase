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
		 * ��for����ۼ�
		 */
		int sum = 0;
		for(int i=1; i<10; i++)
			sum =sum + i;
		System.out.println("Sum = "+sum);
					
		/* 
		 * for��while������
		 * for(int x=1;i<=5;i++){���1~5}  ���x����    				//forѭ��������x�ڴ��ͷ�
		 * int y=5; while(y<=5){//���1~5;y++;} ���y ��yֵΪ6 	 	//
		 */
			
		/*
		 * ����ѭ��
		 * while(true){}
		 * for(;;){}  //for(����û��;û��Ĭ��true;����û��)
		 */
		
		/*
		 * for(��ʼ�����ʽ;ѭ���������ʽ;ѭ����Ĳ������ʽ){ѭ����}
		 * for(int a=0 ,b=1;a<3;a++,b--){}
		 */
	 }
	 public void demo2_for(){
		int a =0 ,b =0 ,c =0 ,d=0 ,x=1 ,y=1;
		for(System.out.println("��ʼ�����ʽ:"+a),x = a + x;			//��ʼ�����ʽ
				b<3&&d<4;											//�������ʽ
				System.out.println("ѭ����Ĳ������ʽ:"+c),y = y + c){	//ѭ����Ĳ������ʽ
			System.out.println("ѭ����:"+b);
			System.out.println("x = "+x);
			System.out.println("y = "+y);
			a++;
			b++;
			c++;
			d+=2;
		}
	}
	 public void demo1_dowhile(){
		 //while�����зֺ�
		 int x = 1;
		 do{
			 System.out.println("x = "+x);
			 x++;
		 }while(x<3);
	 }
	 public void demo1_nestedLoop(){
		 /*
		  * �ظ�->��ѭ��(x=1,2,3,...,n)
		  * �ظ���ÿ���������������ظ�(x=1,y=1;x=1,y=2;...x=1,y=m;
		  * 					x=2,y=1;x=2,y=2;...x=2,y=m;
		  * 					x=n,y=1;x=n,y=2;...;x=n,y=m)
		  */
		 //ð������
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
		  * �⳯��for(int j=0;j<i;j++)
		  * �⳯��for(int j=0;j<5-i;j++)
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
		 //�žų˷���
		 for(int i=1;i<=9;i++){
			 for(int j=1;j<=i;j++)
				 if(i*j<10&&j!=1)//ʹÿ��ʽ�ӿ�ͷ����,���ҵ�һ�к͵ڶ���֮��Ŀո�ͺ�����֮��Ŀո�һ��
					 System.out.print(i+"*"+j+"="+i*j+"   ");
				 else 
					 System.out.print(i+"*"+j+"="+i*j+"  ");
			 System.out.println();
		 }
	 }
	 public void demo7_nestedLoop(){
		a: for(int i = 0 ; i < 3 ; i++ ){	//�����������,ֻ������ѭ����
		b:	for( int j = 0 ; j < 4 ; j++){
				 if(i==2){
					 System.out.println("i = "+i);
					 break a;				//break���ѭ��,���û�и�ѭ��������Ĭ��������ǰѭ��(�������ڲ�ѭ��)
				 }
				 else if(j==3){
					System.out.println("j = "+j);
					break b;				//break�ڲ�ѭ��
				 }
			 }
		 }
	 }
	 public void demo1_continue(){
		 
		for(int i = 0 ; i <= 10 ; i++){
			if(i%2==1)
				continue;					//��������ѭ��,�����´�ѭ��,��������i++,Ȼ���ж�����
			System.out.println("i = "+i);
			 //���涼�ǲ��ɴ�����
		 }
	 }
	 @SuppressWarnings("unused")
	public void demo2_continue(){
		 
		a: for(int i = 0 ; i < 5 ; i++)
			 for(int j = 0 ; j < 4 ;  j++){
				System.out.println("i = "+ i);
				continue a;					//�����������ѭ�������´����ѭ��,Ҳ����˵�ڲ�ѭ��һֱ��j = 0 , ���ѭ��i=1,2,3,4
			}
	 }

}
