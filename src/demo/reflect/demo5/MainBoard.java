package demo.reflect.demo5;

public class MainBoard {

	public void run(){
		System.out.println("main board is running...");
	}
	public void UsePCI(PCI pci){
		if(pci!=null){
			pci.open();
			pci.close();
		}
	}
}
