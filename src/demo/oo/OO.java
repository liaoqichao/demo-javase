package demo.oo;

import java.util.Scanner;

import demo.DemoInterface;

public class OO implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub

		
		//demo1_oo();
		//OO o =new OO();
		//o.demo2_oo();							//��������ǰ�治�ü�static	
		//demo3_oo();
		//demo4_oo();
		//demo5_oo();
		//demo6_oo();
		//demo7_oo();
	}

	public void demo1_oo(){						//��װ��,���ʵ�����͵������з���
		//** �½���,���캯������,�½�����,static�÷�
		//EPolygon p1 =new EPolygon();
		//System.out.println("p1���ܳ�Ϊ: "+p1.getPerimeter());
		//System.out.println("p1�����Ϊ: "+p1.getArea());
		System.out.println("�������������p2�ı����ͳ���  :");
		Scanner scanner =new Scanner(System.in);
		int edge =scanner.nextInt();
		double length = scanner.nextDouble();
		if(edge<3 || length<=0){ 
			edge =3 ; length =1 ; 
			System.out.println("���ܹ����������,��ʼ��Ϊ����Ϊ1��������");
		}
		EPolygon p2 =new EPolygon(edge,length);
		scanner.close();
		System.out.println("p2�ĶԽ�����Ϊ: "+p2.getDiagonal());
		System.out.println("p2�����Ϊ: "+p2.getArea());
		scanner.close();
	}
	
	public void demo2_oo(){							//�̳���,����private�����ͱ������Լ̳�,������ʹ��"super."����û�е�������
		
		System.out.println("������������(3)����������(4),���������ı߳�: ");
		Scanner scanner =new Scanner(System.in);
		int edge = scanner.nextInt();
		double length =scanner.nextDouble();
		if( (edge != 3 && edge !=4 )|| length<=0){	
			edge = 3;	length = 1;
			System.out.println("�������,Ĭ��Ϊ����Ϊ1����������");
		}
		if(edge == 3){
			ETriangle p1 = new ETriangle(length);
			System.out.println("�������ܳ�Ϊ: "+p1.getPerimeter());	//���ø���EPolygon�ķ���
			System.out.println("���������Ϊ: "+p1.getArea());		//���ø���EPolygon�ķ���
		}
		else if(edge == 4){
			Square p1 =new Square(length);
			System.out.println("�������ܳ�Ϊ: "+p1.getPerimeter());
			System.out.println("���������Ϊ: "+p1.getArea());		//getArea�õ���Square�ķ���,�����˸���ķ���
		}
		scanner.close();
	}
	
	public void demo3_oo(){						//������,ʵ�ֶ�̬��һ��;��
												//ͳһ�ó�������������ò�ͬ������󣬵�����ͬ�ķ��������ֵ�Ч����ͬ��ʵ�ֶ�̬
		int i = 77;
		Graph a =new EPolygon(i,2.33);			//Graph�ǳ�����,����ʵ����Graph,ֻ��ʵ������������EPolygon,Circle
		Graph b =new Circle(3);					//�Զ���������,Բ�ζ���������ͼ������,����Բ�ε����й����޷�����
		Graph c =new Square(6.66);				//����ֱ�Ӵ�үүʵ��������
		c.statement();							//���ó�����ķǳ��󷽷�
		/*
		 * a,b,c���õ�getPerimeter()��getArea()����Graph�еķ���
		 * a���ò���EPolygon���е�getDiagonal()��Խ��߷���
		 */
		System.out.println("��״a����"+i+"����,���ܳ�Ϊ "+a.getPerimeter()+" ,���Ϊ "+a.getArea());
		System.out.println("��״b��Բ��,���ܳ�Ϊ "+b.getPerimeter()+" ,���Ϊ "+b.getArea());
		System.out.println("��״c��������,���ܳ�Ϊ "+c.getPerimeter()+" ,���Ϊ "+c.getArea());
	}
	
	public void demo4_oo(){						//��̬
												//û�ö�̬ʱһ�����Ӧһ��getArea();a.getArea();b.getArea();
												//��̬��һ��duotai_getArea()��Ӧ�������
												//duotai_getArea(a);duotai_getArea(b);	
		Scanner scanner =new Scanner(System.in);
		//Բ��
		System.out.println("������Բ�εİ뾶 ��");
		double r = scanner.nextDouble();
		Circle c = new Circle(r);
		display(c);
			
		//�������
		System.out.println("��ֱ�����������εı����ͳ��� ��");
		int edge = scanner.nextInt();
		double length = scanner.nextDouble();
		EPolygon ep =new EPolygon(edge,length);
		display(ep);
		
		
		scanner.close();
		/*
		 * �����...
		 * ʵ��������a
		 * duotai_gerPerimeter(a);
		 * 
		 * �߶κ����߹��ɵ�ͼ��
		 * ʵ��������b
		 * duotai_getPerimeter(b);
		 * ...
		 * 
		 * ���Ƕ���Grap������,����ͬ���ķ���(���ܳ�,���...(������д�˷���)),����ͬ�Ľӿ�ʵ�ֶ�̬
		 * ֻҪ��ͼ�ε����඼����ͨ��duotai_getPerimeter(Graph g)������
		 */
	}
	private String duotai_getPerimeter(Graph g){	//��̬
		return g.getPerimeter();
	}
	
	private String duotai_getArea(Graph g){		//��̬
		return g.getArea();
	}
	
	public void demo5_oo(){						//ת��,����ת��,����ת��,ת�ͺ�������˼һ��

		
		
		Graph g = new EPolygon(12,1);			//"����ת��",�Զ���������,�����ζ��������˵ȱ߶��������,
												//���������ε����й����޷�����(��̬�ľ�����)
		EPolygon ep = (EPolygon)g;				//����g����ʹ��getDiagonal()�����õ��Խ�����
												//������øö�������й��ܿ��Խ���"����ת��"
		System.out.println("�����ε����Ϊ �� "+duotai_getArea(g));
		System.out.println("�����εĶԽ���Ϊ �� "+ep.getDiagonal());		
												//����ת����Ϊ����ӵ�ж�̬�ĺô�ͬʱ(��ά��,��չ��,�޶����๦��),ʹ�������е����з���
		/*
		 * ʼ�ն����������ͽ���ת��
		 * ת��  = ����
		 * 
		 * ����									���Խ�Բ��ת����Բ��
		 * Sector s =new Circle(3);				���ﴴ��Circle���ʵ��s,�Ѿ�ȷ����һ��Բ��(new Circle())
		 * 										��Բ������Ϊ����,Բ����һ������
		 * Circle c =(Circle)s;					�Ѿ�ʵ����(�Ѿ�ȷ����Բ��)�ٰ����ν���ΪԲ��
		 * 
		 * ����									����new Sector(3);���ܽ�����ת����Բ��
		 * Sector s =new Sector(3);				û������,�����������ʵ��s(����������Ҳ������Բ��)
		 * Circle c =(Circle)c;					���������ʵ��(����������,������Բ��)����ΪԲ��,Ȼ����һ����Բ��
		 * 	
		 * ����									���߱��̳й�ϵ,���ܰ��������תΪ����
		 * Graph g =new EPolygon();				
		 * Sector s =(Sector)g;					
		 */
	}
	
	public void demo6_oo(){						//instanceof �ж϶���������������

		
		Circle a =new Circle();					//obj instanceof class
		Sector s = new Sector();
		Sector ss = new Circle();
		if(a instanceof Graph)//ture			//����Ϊtrue������
			System.out.println("a��Graph����");	//obj �� class �Ķ������obj �� class ����Ķ���
		if (a instanceof Circle)//true
			System.out.println("a��Circle����");
		if(a instanceof Sector)//true
			System.out.println("a��Sector����");

		if(s instanceof Circle)//false
			System.out.println("s��Circle����");
		if(s instanceof Graph)//true
			System.out.println("s��Graph����");
		if(s instanceof Sector)//true
			System.out.println("s��Sector����");
		
		if(ss instanceof Circle)//true
			System.out.println("ss��Circl����");
		if (ss instanceof Sector)//true
			System.out.println("ss��Sector����");
		if(ss instanceof Graph)//true
			System.out.println("ss��Graph����");
	}
	private void display(Graph g){				//instanceof �����жϾ�������,ͨ������Ҫ��ת�͵�ʱ���ж�,Ԥ������ת��ʧ��,
												//��ǿ���뽡׳��
		
												//����  a; a instanceof ����  �Ƿ���true�����Ƿ���false
		
		if(g instanceof EPolygon){
			EPolygon ep = (EPolygon)g;			//��ת��,���Ե����������еķ���,����Խ�����
			System.out.println("�ܳ�Ϊ  "+duotai_getPerimeter(ep)+" ,���Ϊ "+duotai_getArea(ep)+" ,�Խ�����Ϊ "+ep.getDiagonal());
		}
		else if(g instanceof Sector){
			Sector s = (Sector)g;
			System.out.println("�ܳ�Ϊ  "+duotai_getPerimeter(s)+" ,���Ϊ "+duotai_getPerimeter(s)+" ,����Ϊ "+s.getRadian());
		}
		//else if ...
		else
			System.out.println("�ܳ�Ϊ  "+duotai_getPerimeter(g)+" ,���Ϊ "+duotai_getPerimeter(g));
	}
	public void demo7_oo(){						//����instanceof�ж϶��������,�ٸ��ݾ������Ϳ����Ƿ���Ҫ����ת����ʹ���������й���
		
		Square square =new Square();
		Graph g1 =new ETriangle();
		Graph g2 =new EPolygon(77,1);
		Graph g3 =new Sector(1,270);
		Sector sector =new Sector();
		display(square);
		display(g1);
		display(g2);
		display(g3);
		display(sector);
	}

}
