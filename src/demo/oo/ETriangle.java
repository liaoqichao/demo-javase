package demo.oo;

public class ETriangle extends /*�̳�,����*/ EPolygon {
	
	private static final int edge = 3;
	//private int num = 8;			//�������� ���ุ��Ĺ��캯���ĵ���˳��
	ETriangle(){
		this(1);
	}
	ETriangle(double length){
		super(edge,length);			//һ��Ҫ���ڹ��캯���ĵ�һ��,����Ҳ����,new ERriangle()��ʱ����ڵ�һ���Զ�����super();
									//Ҳ����Ĭ�ϵ��ø������޲����Ĺ��캯��
		
									//��һ��һ���� super()���������и��๹�캯��,������֮������������Խ�����ʾ��ʼ��,
									//Ȼ�����������й��캯��
	}
	
	/*
	public String getArea(){		//���ø����getArea(),��д��������Ļ�Ĭ�ϵ��ø����getArea();
		String s = super.getArea();	//���ﲻ��super���εĻ��ͻ�ݹ���ñ����getArea(),����ջ��
									//Exception in thread "main" java.lang.StackOverflowError
		return s;
	}

	public int getNum(){			//������û��num, ����ʱ�ȵ��ø���,����û��num��Ĭ�ϳ�ʼ��(�����ʼ�����Ķ��������Ե�
									//��ʾ��ʼ��)num=0;���и��๹�캯��,Ȼ�����������๹�캯��,�ڵ��������getNum(),
									//���num=8
		return num;
	}
	*/
	

}
