package demo.myInterface;

import demo.DemoInterface;

public class Interface implements DemoInterface {

	@Override
	public void demo() {
		// TODO Auto-generated method stub

		//demo1_interface();
		//demo2_interface();
	}
	public void demo1_interface(){				//һ�����ж���ӿ�,ת���ӿڵ�����,����ӿڵ�ʵ��
			
			//����һ��ʵ�������
			Person tom = new Cantonese("tom",55);
			tom.hello();	
			
			//����ӿ�,����tom�����(ѧ��,����,������...)ת������,����һֱû��,ֻ�Ƕ���ı���<����>(tom,tomAs...)����
			//tom������ǽ�����,�������ʹӸ���Person ת���� ����Ľӿ� FitnessPerson ������ת����
			if(tom.overweight()){
				FitnessPerson tomAsFitnessPerson = (FitnessPerson)tom;
				tomAsFitnessPerson.keepfit();
			}
			
			
			Song s = new Song("An apple a day,Keep doctors away");
			
			//ת��,ʵ�����tom��������һ����ݴ����͸���
			SingerComposer tomAsSingerComposer = (SingerComposer)tom;
			tomAsSingerComposer.writeSong(s, "���ɿ�", "һ��һ��Сƻ��,ҽ������������");
			tomAsSingerComposer.sing(s);
			
			
			Cantonese timor = new Cantonese("timor",40);
			timor.hello();
			if(timor.overweight()){
				FitnessPerson timorAsFitnessPerson = (FitnessPerson)timor;
				timorAsFitnessPerson.keepfit();
			}
			Singer timorAsSinger = (Singer)timor;
			timorAsSinger.sing(s);
		}
	public void demo2_interface(){				//ͨ���̳���չ�ӿ�,û���޸�ԭ����
			Song s = new Song("�ӳ�֮��");
			s.writeSong("������", "1��2��3��4����Ī�ӳ���������");
			Person timor = new CantoneseRocker("timor",40);
			timor.hello();
			if(timor.overweight()){
				FitnessPerson timorAsFitnessPerson = (FitnessPerson)timor ;
				timorAsFitnessPerson.keepfit();
			}
			CantoneseRocker timorAsCantoneseRocker =(CantoneseRocker)timor;
			timorAsCantoneseRocker.sing(s);
		}
}

/*
 * �ӿںͳ����������
 * 1.�ӿڿ��Զ��ؼ̳�,�����಻����
 * 2.�ӿ�ȫ����������public abstract,������������з�public,��abstract�ķ���
 * 3.���������ʵ�ֽӿ�,���ӿڲ�����ʵ�ֳ�����
 * 
 * һ�������ʵ�ֶ���ӿ�,�ӿڱ�¶������Խ��Խ��
 * 
 * һ���ӿڴ���һ����ɫ(���)
 * ������ѧ��,��ѧϰ,��Ҳ������,��Ҳ�ᵯ��,����ѧУ��ʵ������ѧϰ���ܵĽӿ�,��(ѧУ)ֻ��עѧϰ,����ע�����᲻������,
 * ����������ʵ���������ܵĽӿ�,�ӿڲ����������᲻������,ֻ��������������
 * ...
 * ����һ��������ж���ӿ�(����ü̳еĻ�,ֻ�ܼ̳�һ������,�ýӿڵĻ�����ͬʱʵ�ֶ���ӿ�)
 * 
 * �ӿڼ̳нӿ�,��̳и��ӿڵ����г��󷽷�,ʵ���ӽӿ�ʱ,Ҫ��ȫ������(�����̳и��ӿڵ�)ʵ��
 * 
 * �ۺϹ�ϵ��has a
 * ��Ϲ�ϵ:contains a
 * 
 * 
 */

