package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo implements IO {

	/**
	 * util.Map->Hashtable->Properties
	 * Properties表示一个持久的属性集，可以保存在流中或在流中加载
	 * 特点：
	 * 1.该集合中的键和值都是字符串类型
	 * 2.集合中的数据可以保存在流中或在流中加载
	 * 
	 * 通常该集合用于操作以键值对形式存在的配置文件
	 * 保存数据的形式：	1.简单信息键值对		2.复杂信息用xml		3.很多信息用数据库
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();
		//demo4();
	}
	public void demo1(){		//Properties的存和取，list
		
		Properties prop = new Properties();
		
		//存储元素
		prop.setProperty("哞", "牛");
		prop.setProperty("喵", "猫");
		prop.setProperty("汪", "狗");
		prop.setProperty("吖", "鸭");
		prop.setProperty("哦", "鸡");
		
		//取元素
		Set<String> set = prop.stringPropertyNames(); //获取键集
		for(Iterator<String> it = set.iterator() ; it.hasNext() ;){
			String key = it.next();
			String value = prop.getProperty(key);
			System.out.println(key+"="+value);
		}
		
		//list(PrintStream ps);  System.out 是PrintStream类型,此方法一般用于调试
		prop.list(System.out);
		/*
		-- listing properties --
		吖=鸭
		哦=鸡
		喵=猫
		哞=牛
		汪=狗
		*/
		
	}
	public void demo2() throws IOException{		//store方法,持久化
		/*
		 *  持久化：把Properties里面的信息保存起来(保存到硬盘)方便下次使用
		 *  void store(OutputStream或者Writer out,String comments)throws IOException
		 *  comments属性列表的描述
		 */
		
		Properties prop = new Properties();
		
		prop.setProperty("牛", "哞");
		prop.setProperty("猫", "喵");
		prop.setProperty("狗", "汪");
		prop.setProperty("鸭", "吖");
		prop.setProperty("鸡", "哦");
		
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\Properties\\CryOfAnimals.ini");
		BufferedWriter bw = new BufferedWriter(fw);
		
		prop.store(bw, "Cry of Animals");//comments别写中文, 会出现  #\u8DA3\u39AD  \\u代表unicode码,4位16进制存储
		bw.close();
		
	}
	public void demo3() throws IOException{		//修改配置信息
		
		/*
		 * Properties可以保存到流中从流中获取
		 * 集合中的数据来自于一个文件
		 * 保证文件中的数据是键值对
		 * 需要读取流来完成 load(字符流或字节流)
		 */
		Properties prop = new Properties();
		File file = new File("E:\\Eclipse\\IO\\Properties\\CryOfAnimals.ini");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//加载文件的数据(只能加载键值对)到Properties对象中
		
		if(!file.exists())
			file.createNewFile();
		prop.load(br);
		
		//修改
		prop.setProperty("猫", "喵了个咪再咪了个喵");//怎么其他键值对没有了?因为new FileWriter的时候回覆盖掉之前的文件

		//写到文件
		//创建一个新对象,原来的文件会重新建立一次(覆盖掉之前的内容).所以要先load加载后才创建bw对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		prop.store(bw, "Modified Cry of Animals");//写的时候是全都写,不是指写被修改的部分
		br.close();
		bw.close();
	}
	public void demo4() throws IOException{
		/*
		 * 获取程序运行次数,如果超过5次,给出使用次数已到请注册(购买正版)的提示。并不要在运行程序
		 */

		runCode();
	}
	private void runCode() throws IOException {
		// TODO Auto-generated method stub
		if(canRun()){
			System.out.println("Running...");
		}	
	}
	private boolean canRun() throws IOException{
		File file = new File("E:\\Eclipse\\IO\\Properties\\demo4.ini");
		Properties prop = new Properties();
		//判断文件是否存在
		if(!file.exists()){
			file.createNewFile();
		}
		//载入文件信息
		BufferedReader br = new BufferedReader(new FileReader(file));
		prop.load(br);
		//判断键是否存在
		String value = prop.getProperty("time");
		if(value == null){			//不存在则新建键值对
			prop.setProperty("time", "4");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			prop.store(bw, "demo7");
			System.out.println("剩余4次试用次数,请购买本软件");
			bw.close();
			br.close();
			return true;
		}
		else{						//存在则获取键值对的值
			Integer uses = Integer.valueOf(prop.getProperty("time"));
			if(uses <= 0){			//值小于等于0则无法使用软件
				System.out.println("软件无法运行,剩余试用次数为0,请购买本软件");
				return false;
			}
			else{					//否则可以使用软件
				uses--;
				prop.setProperty("time", uses.toString());
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				prop.store(bw, "");
				System.out.println("剩余"+(uses)+"次使用,请购买本软件");
				bw.close();
				return true;
			}
		}
	}
}

