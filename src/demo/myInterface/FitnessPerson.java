package demo.myInterface;

public interface FitnessPerson {		//���:keep fit ���˻��߲�����,��Ҫkeep fit���ܵĶ�����������ӿ�
	/*public����ʡ��
	 *abstract interface��������
	 *��C����ͬʱ�̳���A����B,���ǽӿ�C����ͬʱ�̳нӿ�A�ͽӿ�B����������ͬʱ�̳�2���ӿ�
	 *��Ϊinterface A{public abstract String func();}
	 *	interface B{public abstract int func();}
	 *interface c extends A,B{}	 class D implements c{ String func();  int func(); }//ʵ����ʱ,ͬ������,��ͬ��������
	 *
	 *�ӿڵ��ص�:
	 *1.�ӿ��Ƕ��Ⱪ¶�Ĺ���
	 *2.�ӿ��ǳ���Ĺ�����չ
	 *3.�ӿڿ���������ʵ��
	 *4.1������Լ̳�1�������ͬʱʵ�ֶ���ӿ�
	 *5.�ӿںͽӿ�֮����Զ�̳�
	 *
	 *���еĹ��Զ���,�ü̳�,(�����˶�˯�� ) ; ��Щ��������Щ����û���ýӿ�(�����������Ǹ���).
	 *class Japanese extends Person implements GarbageClassficationPerson { 
	 *	void sleep();					//�̳еĵķ���,�����˶�˯��,�����ձ���Ҳ��˯��
	 *	void GarbageClassfication();	//ʵ�ֵķ���,���и��ָ����Ľ�ɫ,��ҽ��,��ʦ,����,�л������������,Ҳ�в�������������� ��
	 *									//������������˵�����չ����,��Ҫ��ʱ���ʵ��,���ǵ�ʱ��Ͳ���Ҫʵ��
	 *									//(����ʵ����GarbageClassficationPerson, �ձ��˶��ǻ������������)
	 *}
	 *class Chinese extends Person{
	 *	void sleep();					//�й���Ҳ����,ҲҪ˯��
	 *									//�й��˲���ȫ���˶��ǻ������������,���Բ���Ҫʵ��
	 *}
	 */

		//public static final int WEIGHT_STANDARD = 50;		//public static final ����ʡ��,���鷽���ͳ�������ʡ��
		public abstract void keepfit();					//public ��  abstract ����ʡ��

}
