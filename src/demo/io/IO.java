package demo.io;

import demo.DemoInterface;

public interface IO extends DemoInterface {
	/**
	 * ����û��
	 * 																					IO
	 * 								|--------------------------------------------------------------------------------------------------------|
	 * 	  							�ֽ���																									�ַ���
	 * 			|-------------------------------------------------------------|												  |------------------------------------------------|
	 * 		InputStream													OutputStream										Reader											Writer
	 * 	|-------|---------|--------|----|----------|			|-------|------|-------|-------|				|--------|-----------|----------|		 	|------------------|--------|-------------|
	 * File-   Filter-	Object-	Piped- Sequence-  ByteArray-	File- Filter- Object- Piped-  ByteArray-	Buffered-	CharArray- String-	InputStream-	Buffered-	OutputStream-   CharArray-   String-   
	 * 			|														|										|															|
	 * 		|----------|									 |----------|-------|							 	|															|
	 * 	Buffered-	Data-									Buffered- Data-	PrintStream						FileReader													FileWriter
	 * 
	 * IO����,IO��ϵ�����
	 * RandomAcessFile	ֻ�̳�Object��,ͨ�����ڶ��߳�д��
	 * 
	 * Ӧ�����ĸ���?
	 * 1.��ȷԴ��Ŀ��(��) ������(��)�������(д)?
	 * 		Դ��Reader,InputStream		Ŀ��:Writer,OutputStream
	 * 2.��ȷ�����Ƿ��Ǵ��ı�����
	 * 		���ı����ݣ�Reader,Writer		�Ǵ��ı����ݣ�InputStream,OutputStream
	 * 3.��ȷ�����豸(���ݶ��������豸)[����Դ]	
	 * 		Դ�豸:
	 * 			Ӳ�̣�File
	 * 			���̣�System.in
	 * 			�ڴ棺����
	 * 			���磺Socket��
	 * 		Ŀ���豸��
	 * 			Ӳ�̣�File
	 * 			����̨��System.out
	 * 			�ڴ棺����
	 * 			���磺Socket��
	 * 4.�Ƿ���Ҫ�������⹦��
	 * 		1.�Ƿ���Ҫ��Ч(������)	�ǣ�����buffered
	 * 		2.
	 *
	 */
}
