package demo.packImpJAR.pack1;

import demo.packImpJAR.pack2.Pack2;

public class Pack1 extends Pack2{
	//���߲���import, ֱ��extends myPack2.Pack2

		public void show(){
			System.out.println("This is myPack1.Pack1");
		}
		public void p1Method(){
			method();						//��ͬ����������Ի����ʱ�protectedȨ�޵ķ���
		}

}
