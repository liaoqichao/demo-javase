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
		 * 之前的	FileReader,FileWriter;InputStream,OutputStream;
		 * 		BufferedReader,BufferWriter;BufferedInputStream,BufferedOutputStream
		 * 		InputStreamReader,OutputStreamWriter
		 * 都只能读写数据(文件的内容),不能操作文件夹和文件的属性
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
	public void demo1(){		//构造函数
		/*
		 * File建立文件或者文件夹
		 * File的构造方法
		 * File.separator		名称分隔符  	Windows \\		UNIX /
		 * File.pathSeparator	路径分隔符	Windows	;		UNIX :
		 */
		File f1 = new File("E:\\Eclipse\\IO\\File\\demo1_1.txt");
		File f2 = new File("E:\\Eclipse\\IO\\File\\","demo1_2");
		File f = new File("E:\\Eclipse"+File.separator+"IO"+File.separator+"File");//名称分隔符
		File f3 = new File(f,"demo1_1");
	}
	public void demo2() throws IOException{		//获取;增删;判断;重命名
		/*
		 * File对象的常见方法：
		 * 1.获取
		 * 2.增删文件、文件夹
		 * 3.判断
		 * 4.重命名
		 */
		
		File f1 = new File("E:\\Eclipse\\IO\\File");
		File f2 = new File(f1,"demo2_1.txt");
		
		//新建文件夹、文件
		f1.mkdir();//创建单级目录E:\\Eclipse\\IO\\File\\, 文件夹已存在则不创建,而不是创建新文件夹覆盖
		//mkdirs()创建多级目录   E:\\Eclipse\\IO\\File\\A\\B\\C\\D\\E\\F
		//删除的时候delete只删除最里面的目录,也就是只删除F文件夹
		//f2.createNewFile();//在直接路径下新建文件
		
		//获取文件信息
		/*
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");//大写H是24小时制,小写h是12小时制
		System.out.println(f2.getName());//demo2_1.txt
		System.out.println(f2.getAbsolutePath());//E:\Eclipse\IO\File\demo2_1.txt
		System.out.println(f2.length());//文件大小
		System.out.println(f2.getFreeSpace());//剩余空间,空闲空间 90500427776
		System.out.println(sdFormat.format(f2.lastModified()));//上次修改时间 2015年08月13日 21时05分47秒
		*/
		
		//删除文件夹、文件
		/*
		 * Windows的删除是从里往内删的,如果目录里面有内容,这个目录删不了
		 * delete的删除不会送去回收站
		 * 当文件被流操作的时候也删不了
		 */
		//f2.delete();			//删除文件		先删f2再删f1,都删掉	
		//f1.deleteOnExit();	//删除文件夹，	先删 f1再删f2f2删掉,f1没删掉.deleteOnExit则都可以删除
		
		//判断
		/*
		 * 最好先判断是否存在,然后再判断是文件还是目录
		 */
		System.out.println(f2.exists());	//不存在的话既不是文件也不是目录 	T
		System.out.println(f2.isFile());	//是不是文件 				T
		System.out.println(f2.isDirectory());//是不是目录				F
		
		//重命名
		File renameFile = new File(f1,"demo2_1rename.txt");			//同目录下重命名
		//不同目录下的话,则先移动(剪切粘贴)后改名
		f2.renameTo(renameFile);	//demo2_1.txt  -> demo2_1rename.txt
	}
	public void demo3(){		//根目录和容量获取
		/*
		 * 列出文件可用系统根
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
			System.out.println(me.getKey()+"  总空间："+me.getValue()[1]+"  ,剩余空间："+me.getValue()[0]+"  ,虚拟机可用的字节数："+me.getValue()[2]);
		}
		/*
		 * C:\  28889350144    	c盘属性剩余空间28889415680	不正确
		 * D:\  120054816768	d盘属性剩余空间120054816768	正确
		 * E:\  90502688768		e盘属性剩余空间90502680576	不正确
		 * F:\  120629096448	f盘属性剩余空间120629096448	正确
		 * G:\  0										正确
		 */
	}
	public void demo4(){		//获取目录内容
		
		/*
		 * list();获取当前目录的文件、文件夹、系统隐藏的文件和文件夹的名称.有些文件夹有权限JAVA访问不了
		 * 如果file是文件不是文件夹的话会出现异常(空指针异常),因为数组根本没创建成功
		 * 如果访问系统级目录也会发生空指针异常
		 * 如果目录存在,但是没有内容，会返回一个数组,但是长度为0
		 */
		
		File file = new File("E:\\");
		String[] names = file.list();
		getFileName(names);
	}
	public void demo5(){		//过滤器
		/*
		 * filter：过滤器
		 * 过滤文件名
		 * String[] list(FilenameFilter f)
		 * FilenameFilter接口就只有1个方法
		 * boolean accept(File dir,String name);
		 * 
		 * 过滤文件
		 * File[] list(FileFilter f)
		 * public boolean accept(File pathname)
		 * 
		 * 这些都只能是在当前目录下的
		 */
		//过滤获取当前目录以.java结尾的文件名称
//		File dir = new File("E:\\Eclipse\\workspace\\Demo\\src\\demo");
//		FilterNameByJAVA FilterNameByJAVA = new FilterNameByJAVA();
//		String[] names = dir.list(FilterNameByJAVA);//只能拿到目录所有文件的名称。看list(filter);的代码
//		for(String name : names){
//			System.out.println(name);
//		}
		
		//过滤获取当前目录隐藏文件的对象
//		File dir1 = new File("C:\\");
//		File[] files = dir1.listFiles(new FilterByHidden());//拿到目录所有文件的对象
//		for(File file : files){
//			System.out.println(file);
//		}
		
		//过滤获取当前目录任一个后缀名的所有文件
		File dir2 = new File("E:\\Eclipse\\IO\\ByteStream");
		String[] suffix1 = dir2.list(new SuffixFilter(".wma"));
		System.out.println("后缀名为.wma的文件：");
		getFileName(suffix1);
		System.out.println("后缀名为.txt的文件：");
		String[] suffix2 = dir2.list(new SuffixFilter(".txt"));
		getFileName(suffix2);
		System.out.println("后缀名为.mp3的文件：");
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
		 * 遍历指定目录的所有文件(包括子目录中的)
		 * 1.当前目录是否非空.是则结束
		 * 2.获取当前目录的所有文件、文件夹。
		 * 3.如果获取的是文件,把名字放入到字符串数组。如果是文件夹。获取这个文件夹的所有文件、文件夹
		 * 4.知道文件夹里面没有文件夹(包括有文件和没文件)
		 */
		File dir = new File("E:\\Eclipse\\workspace\\Demo\\src");
		listAll(dir);
		/*递归调用的时候怎么才能不让列表被覆盖?
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
				System.out.println(files[i].getName());// 为什么sop可以  集合存就不可以？递归过程中列表不断改变
	//			list.add(files[i].getName());
			}
			if(files[i].isDirectory()){
				System.out.println(files[i].getName()+"...");
				listAll(files[i]);
			}		
		}

		//return list;
	}
	public void demo7(){		//删除一个带内容的目录
		/*
		 * //删除一个带内容的目录
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
				deleteDir(file);//删除文件夹里面所有的文件
			}
			dir.delete();//本层删除文件夹(执行完删除所有文件)S
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
	public void demo8() throws Exception{		//io综合练习
		/*
		 * 获取指定目录下,指定拓展名的文件(包括子目录中的)
		 * 这些文件的绝对路径写入到一各文本文档中
		 * 步骤：
		 * 1.获取指定目录
		 * 2.在指定目录下遍历所有文件夹
		 * 3.如果是文件夹则遍历该文件夹如果是文件是以指定后缀结尾的,获取文件的绝对路径
		 * 4.如果写入信息的目标文件文件不存在则创建,存在则载入
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
		File[] files = dir.listFiles();		//得到dir目录下的目录或文件夹 
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
		if(!destfile.exists()){	//目标不存在则创建
			destfile.createNewFile();
		}
		if(!destfile.isFile()){
			System.out.println("目标不是文件");
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
class FilterNameByJAVA implements FilenameFilter{		//过滤当前目录后缀名为.java的文件

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		/*
		 * name.startWith(string s);字符串name以字符串s开头则为真，否则为假
		 * name.endWith(string s);字符串name以字符串s结尾则为真，否则为假
		 */
		return name.endsWith(".java");	//过滤文件名,以.java结尾的文件
	}
	
}
class FilterByHidden implements FileFilter{				//过滤当前目录的隐藏文件

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.isHidden();
	}
}
class SuffixFilter implements FilenameFilter{			//过滤任一个后缀名的文件

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
