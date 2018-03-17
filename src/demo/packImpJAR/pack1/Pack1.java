package demo.packImpJAR.pack1;

import demo.packImpJAR.pack2.Pack2;

public class Pack1 extends Pack2{
	//或者不用import, 直接extends myPack2.Pack2

		public void show(){
			System.out.println("This is myPack1.Pack1");
		}
		public void p1Method(){
			method();						//不同包的子类可以还访问被protected权限的方法
		}

}
