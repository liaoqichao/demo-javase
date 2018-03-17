package demo.reflect.demo5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo5 {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws ReflectiveOperationException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		MainBoard mb = new MainBoard();
		mb.run();
		//ֱ�ӻ�ȡclass�ļ�,�ڲ�ʵ�ִ�������
		//�����޸�Դ����,ֻ���޸������ļ�
		File config = new File(
				"E:\\Eclipse\\workspace\\Demo\\bin\\demo\\reflect\\demo5\\PCI.properties");
		Properties prop = new Properties();
		FileReader fr = new FileReader(config);
		prop.load(fr);
		
		if(prop.size() == 0)
			return;
		for(int i = 0; i<prop.size(); i++){
			String pciName = prop.getProperty("pci"+(i+1));
			Class<?> clazz = Class.forName(pciName);
			Object object = clazz.newInstance();//������ǿղι��캯��
			PCI p = (PCI)object;//�ٷְ���PCI������
			mb.UsePCI(p);
		}
		
		fr.close();
	}

}
