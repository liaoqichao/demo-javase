package demo.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileDemo implements IO {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * ֮ǰ��	FileReader,FileWriter;InputStream,OutputStream;
		 * 		BufferedReader,BufferWriter;BufferedInputStream,BufferedOutputStream
		 * 		InputStreamReader,OutputStreamWriter
		 * ��ֻ�ܶ�д����(�ļ�������),���ܲ����ļ��к��ļ�������
		 */
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		//demo7();
		//demo8();
	}
	@SuppressWarnings("unused")
	public void demo1(){		//���캯��
		/*
		 * File�����ļ������ļ���
		 * File�Ĺ��췽��
		 * File.separator		���Ʒָ���  	Windows \\		UNIX /
		 * File.pathSeparator	·���ָ���	Windows	;		UNIX :
		 */
		File f1 = new File("E:\\Eclipse\\IO\\File\\demo1_1.txt");
		File f2 = new File("E:\\Eclipse\\IO\\File\\","demo1_2");
		File f = new File("E:\\Eclipse"+File.separator+"IO"+File.separator+"File");//���Ʒָ���
		File f3 = new File(f,"demo1_1");
	}
	public void demo2() throws IOException{		//��ȡ;��ɾ;�ж�;������
		/*
		 * File����ĳ���������
		 * 1.��ȡ
		 * 2.��ɾ�ļ����ļ���
		 * 3.�ж�
		 * 4.������
		 */
		
		File f1 = new File("E:\\Eclipse\\IO\\File");
		File f2 = new File(f1,"demo2_1.txt");
		
		//�½��ļ��С��ļ�
		f1.mkdir();//��������Ŀ¼E:\\Eclipse\\IO\\File\\, �ļ����Ѵ����򲻴���,�����Ǵ������ļ��и���
		//mkdirs()�����༶Ŀ¼   E:\\Eclipse\\IO\\File\\A\\B\\C\\D\\E\\F
		//ɾ����ʱ��deleteֻɾ���������Ŀ¼,Ҳ����ֻɾ��F�ļ���
		//f2.createNewFile();//��ֱ��·�����½��ļ�
		
		//��ȡ�ļ���Ϣ
		/*
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");//��дH��24Сʱ��,Сдh��12Сʱ��
		System.out.println(f2.getName());//demo2_1.txt
		System.out.println(f2.getAbsolutePath());//E:\Eclipse\IO\File\demo2_1.txt
		System.out.println(f2.length());//�ļ���С
		System.out.println(f2.getFreeSpace());//ʣ��ռ�,���пռ� 90500427776
		System.out.println(sdFormat.format(f2.lastModified()));//�ϴ��޸�ʱ�� 2015��08��13�� 21ʱ05��47��
		*/
		
		//ɾ���ļ��С��ļ�
		/*
		 * Windows��ɾ���Ǵ�������ɾ��,���Ŀ¼����������,���Ŀ¼ɾ����
		 * delete��ɾ��������ȥ����վ
		 * ���ļ�����������ʱ��Ҳɾ����
		 */
		//f2.delete();			//ɾ���ļ�		��ɾf2��ɾf1,��ɾ��	
		//f1.deleteOnExit();	//ɾ���ļ��У�	��ɾ f1��ɾf2f2ɾ��,f1ûɾ��.deleteOnExit�򶼿���ɾ��
		
		//�ж�
		/*
		 * ������ж��Ƿ����,Ȼ�����ж����ļ�����Ŀ¼
		 */
		System.out.println(f2.exists());	//�����ڵĻ��Ȳ����ļ�Ҳ����Ŀ¼ 	T
		System.out.println(f2.isFile());	//�ǲ����ļ� 				T
		System.out.println(f2.isDirectory());//�ǲ���Ŀ¼				F
		
		//������
		File renameFile = new File(f1,"demo2_1rename.txt");			//ͬĿ¼��������
		//��ͬĿ¼�µĻ�,�����ƶ�(����ճ��)�����
		f2.renameTo(renameFile);	//demo2_1.txt  -> demo2_1rename.txt
	}
	public void demo3(){		//��Ŀ¼��������ȡ
		/*
		 * �г��ļ�����ϵͳ��
		 */
		File[] files = File.listRoots();
		Map<File,Long[]> rootFreeSpace = new HashMap<File,Long[]>();
		//foreach
		for(File file : files){
			Long[] space = new Long[3];
			space[0] = file.getFreeSpace();
			space[1] = file.getTotalSpace();
			space[2] = file.getUsableSpace();
			rootFreeSpace.put(file, space);
		}
		for(Iterator<Map.Entry<File, Long[]>> it = rootFreeSpace.entrySet().iterator();it.hasNext();){
			Map.Entry<File, Long[]> me = it.next();
			System.out.println(me.getKey()+"  �ܿռ䣺"+me.getValue()[1]+"  ,ʣ��ռ䣺"+me.getValue()[0]+"  ,��������õ��ֽ�����"+me.getValue()[2]);
		}
		/*
		 * C:\  28889350144    	c������ʣ��ռ�28889415680	����ȷ
		 * D:\  120054816768	d������ʣ��ռ�120054816768	��ȷ
		 * E:\  90502688768		e������ʣ��ռ�90502680576	����ȷ
		 * F:\  120629096448	f������ʣ��ռ�120629096448	��ȷ
		 * G:\  0										��ȷ
		 */
	}
	public void demo4(){		//��ȡĿ¼����
		
		/*
		 * list();��ȡ��ǰĿ¼���ļ����ļ��С�ϵͳ���ص��ļ����ļ��е�����.��Щ�ļ�����Ȩ��JAVA���ʲ���
		 * ���file���ļ������ļ��еĻ�������쳣(��ָ���쳣),��Ϊ�������û�����ɹ�
		 * �������ϵͳ��Ŀ¼Ҳ�ᷢ����ָ���쳣
		 * ���Ŀ¼����,����û�����ݣ��᷵��һ������,���ǳ���Ϊ0
		 */
		
		File file = new File("E:\\");
		String[] names = file.list();
		getFileName(names);
	}
	public void demo5(){		//������
		/*
		 * filter��������
		 * �����ļ���
		 * String[] list(FilenameFilter f)
		 * FilenameFilter�ӿھ�ֻ��1������
		 * boolean accept(File dir,String name);
		 * 
		 * �����ļ�
		 * File[] list(FileFilter f)
		 * public boolean accept(File pathname)
		 * 
		 * ��Щ��ֻ�����ڵ�ǰĿ¼�µ�
		 */
		//���˻�ȡ��ǰĿ¼��.java��β���ļ�����
//		File dir = new File("E:\\Eclipse\\workspace\\Demo\\src\\demo");
//		FilterNameByJAVA FilterNameByJAVA = new FilterNameByJAVA();
//		String[] names = dir.list(FilterNameByJAVA);//ֻ���õ�Ŀ¼�����ļ������ơ���list(filter);�Ĵ���
//		for(String name : names){
//			System.out.println(name);
//		}
		
		//���˻�ȡ��ǰĿ¼�����ļ��Ķ���
//		File dir1 = new File("C:\\");
//		File[] files = dir1.listFiles(new FilterByHidden());//�õ�Ŀ¼�����ļ��Ķ���
//		for(File file : files){
//			System.out.println(file);
//		}
		
		//���˻�ȡ��ǰĿ¼��һ����׺���������ļ�
		File dir2 = new File("E:\\Eclipse\\IO\\ByteStream");
		String[] suffix1 = dir2.list(new SuffixFilter(".wma"));
		System.out.println("��׺��Ϊ.wma���ļ���");
		getFileName(suffix1);
		System.out.println("��׺��Ϊ.txt���ļ���");
		String[] suffix2 = dir2.list(new SuffixFilter(".txt"));
		getFileName(suffix2);
		System.out.println("��׺��Ϊ.mp3���ļ���");
		String[] suffix3 = dir2.list(new SuffixFilter(".mp3"));
		getFileName(suffix3);
	}
	private void getFileName(String[] suffix) {
		for(String name : suffix){
			System.out.println(name);
		}
	}
	public void demo6(){
		/*
		 * ����ָ��Ŀ¼�������ļ�(������Ŀ¼�е�)
		 * 1.��ǰĿ¼�Ƿ�ǿ�.�������
		 * 2.��ȡ��ǰĿ¼�������ļ����ļ��С�
		 * 3.�����ȡ�����ļ�,�����ַ��뵽�ַ������顣������ļ��С���ȡ����ļ��е������ļ����ļ���
		 * 4.֪���ļ�������û���ļ���(�������ļ���û�ļ�)
		 */
		File dir = new File("E:\\Eclipse\\workspace\\Demo\\src");
		listAll(dir);
		/*�ݹ���õ�ʱ����ô���ܲ����б�����?
		List<String> list = listAll(dir);
		
		for(Iterator<String> it = list.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		*/
	}
	public static void listAll(File dir) {
		// TODO Auto-generated method stub
		//List<String>  list = new ArrayList<String>();
		File[] files = dir.listFiles();
		
		if(files.length==0){
			//return list;
		}
		
		for(int i = 0 ; i < files.length; i++){
			if(files[i].isFile()){
				System.out.println(files[i].getName());// Ϊʲôsop����  ���ϴ�Ͳ����ԣ��ݹ�������б��ϸı�
	//			list.add(files[i].getName());
			}
			if(files[i].isDirectory()){
				System.out.println(files[i].getName()+"...");
				listAll(files[i]);
			}		
		}

		//return list;
	}
	public void demo7(){		//ɾ��һ�������ݵ�Ŀ¼
		/*
		 * //ɾ��һ�������ݵ�Ŀ¼
		 */
		File dir = new File("E:\\Eclipse\\IO\\File\\demo7");
		System.out.println(deleteDir(dir));
		
	}
	private boolean deleteDir(File dir) {
		// TODO Auto-generated method stub
		if(!dir.exists())
			return false;

		if(dir.isDirectory()){
			File[] files = dir.listFiles();
			for(File file : files){
				deleteDir(file);//ɾ���ļ����������е��ļ�
			}
			dir.delete();//����ɾ���ļ���(ִ����ɾ�������ļ�)S
		}
		else{
			dir.delete();
		}
		return true;
			
		/*
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				deleteDir(file);
			}
			else{
				file.delete();
			}
			file.delete();
		}*/
	}
	public void demo8() throws Exception{		//io�ۺ���ϰ
		/*
		 * ��ȡָ��Ŀ¼��,ָ����չ�����ļ�(������Ŀ¼�е�)
		 * ��Щ�ļ��ľ���·��д�뵽һ���ı��ĵ���
		 * ���裺
		 * 1.��ȡָ��Ŀ¼
		 * 2.��ָ��Ŀ¼�±��������ļ���
		 * 3.������ļ�����������ļ���������ļ�����ָ����׺��β��,��ȡ�ļ��ľ���·��
		 * 4.���д����Ϣ��Ŀ���ļ��ļ��������򴴽�,����������
		 */
		
		File dir = new File("E:\\Eclipse\\workspace\\Demo\\src");		
		File destfile = new File("E:\\Eclipse\\IO\\File\\demo8.txt");	
		String suffix = ".java";
		List<File> list = new ArrayList<File>();
		
		getFiles(dir,suffix,list);
		write(destfile,list);
	}
	private void getFiles(File dir,String suffix,List<File> list) throws IOException {
		// TODO Auto-generated method stub
		File[] files = dir.listFiles();		//�õ�dirĿ¼�µ�Ŀ¼���ļ��� 
		for(File file : files){	
			if(file.isDirectory()){
				getFiles(file,suffix,list);
			}
			else{
				String filename = file.getName();
				if(filename.endsWith(suffix)){
					list.add(file);
				}
			}
		}
	}
	private void write(File destfile,List<File> list) throws FileNotFoundException,
	IOException {
		if(!destfile.exists()){	//Ŀ�겻�����򴴽�
			destfile.createNewFile();
		}
		if(!destfile.isFile()){
			System.out.println("Ŀ�겻���ļ�");
			throw new FileNotFoundException();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(destfile));
		for(Iterator<File> it = list.iterator();it.hasNext();){
			bw.write(it.next().getAbsolutePath());
			bw.newLine();
			bw.flush();
			}
		bw.close();
		}
	
}
class FilterNameByJAVA implements FilenameFilter{		//���˵�ǰĿ¼��׺��Ϊ.java���ļ�

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		/*
		 * name.startWith(string s);�ַ���name���ַ���s��ͷ��Ϊ�棬����Ϊ��
		 * name.endWith(string s);�ַ���name���ַ���s��β��Ϊ�棬����Ϊ��
		 */
		return name.endsWith(".java");	//�����ļ���,��.java��β���ļ�
	}
	
}
class FilterByHidden implements FileFilter{				//���˵�ǰĿ¼�������ļ�

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.isHidden();
	}
}
class SuffixFilter implements FilenameFilter{			//������һ����׺�����ļ�

	private String suffix;
	SuffixFilter(String suffix){
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(suffix);
	}
	
}
