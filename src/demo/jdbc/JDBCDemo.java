package demo.jdbc;

import java.beans.PropertyVetoException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import demo.DemoInterface;
import lqcUtils.JDBCUtils;

public class JDBCDemo implements DemoInterface{

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
//		demo6();
//		demo7();
//		demo8();
//		demo9();
//		demo10();
//		demo11();
//		demo12();
//		demo13();
//		demo14();
	}

	public void demo1() throws ClassNotFoundException, SQLException  {	//连接数据库
		/**
		 * classNotFoundException：
		 * 	> 没驱动导包
		 * 	> Driver打错
		 * 
		 * SQLException：
		 * 	> 检查url、username、password是否正确
		 *  > 检查MySQL服务器是否开启
		 */
		/*
		 * jdbc四大配置参数：
		 * > driverClassName:com.mysql.jdbc.Driver
		 * > url:jdbc:mysql://localhost:3306/数据库名称(mydb1)
		 * > username:root
		 * > password:123
		 * 
		 * 把这4个参数改成别的数据库的参数就可以连接别的数据库。！连接所有数据库的步骤都一样，就是参数不一样！！！
		 * 
		 * 1.加载驱动类
		 * 2.通过DriverManager，使用url、username、password得到Connection对象
		 */
		//1. JAR包是JDBC4，第一步不用也可以。JDBC4.0后每个jar包驱动中,在META-INF/services目录下提供了
//		java.sql.Driver文件。而文件的内容就是该接口实现类的名称。
		Class.forName("com.mysql.jdbc.Driver");	//加载驱动类(注册驱动)
		
//		Class.forName("com.mysql.jdbc.Driver");等于下面两行代码
//		因为Driver有静态代码块，里面：java.sql.DriverManager.registerDriver(new Driver());一加载类这个代码块就执行了。
//		com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		/*
		 * 所有的java.sql.Driver实现类,都提供了static块,块内代码就是把自己注册到DriverManager中！
		 * java.sql.DriverManager.registerDriver(new Driver()); 这里的Driver是各个厂商的实现类
		 */
		
		//2.
		String url = "jdbc:mysql://localhost:3306/mydb1";
		String username = "root";
		String password = "123";
		
		//java.sql.Connection 不是 jdbc.mysql.Connection。因为java.sql.Connection是通用的接口
//		而 jdbc.mysql.Connection只是一个实现类。
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);//com.mysql.jdbc.JDBC4Connection@31cefde0
		
		conn.close();
	}
	
	public void demo2() throws ClassNotFoundException, SQLException{	//数据库的增、删、改
		/*
		 * 一、得到Connection
		 * 	1.准备四大参数
		 * 	2.加载驱动类
		 * 	3.得到Connection
		 * 
		 */
		//1.准备四大参数
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb1";//jdbc协议的格式
		String username = "root";
		String password = "123";
		//2.加载驱动类
		Class.forName(driverClassName);
		//3.得到Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		/*
		 * 二、增、删、改数据库
		 * 	1.通过connection对象创建statement(翻译：语句，不要翻译为声明)对象
		 * 		> statement的功能是向数据库发送sql语句。
		 * 	2.调用 statement的int executeUpdate(String sql)，发送DML和DDL。但是通常只对记录操作,不对表结构操作。
		 * 	  其返回值是影响多少行，返回3说明sql语句影响三行记录。
		 */
		
		//1.导java.sql.Statement包
		Statement stmt = conn.createStatement();
		//2.这里字符串的SQL语句不能加分号，只能写1条SQL语句
		String sql = "INSERT INTO tb_stu VALUES('ITCAST_0005','liQi','88','male')";
//		String sql = "UPDATE tb_stu SET gender='male',age=20 WHERE name='liQi'";
//		String sql = "DELETE FROM tb_stu";
		int r = stmt.executeUpdate(sql);
		System.out.println(r);//1. 修改了1行记录。
		
		stmt.close();
		conn.close();
	}
	
	public void demo3() throws ClassNotFoundException, SQLException{	//数据库的查询
		
		/*
		 * 一、得到Connection
		 * 二、得到statement发送select对象
		 * 三、对查询返回的结果进行解析。
		 */
		
		//一、
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//二、
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM emp";
		ResultSet rs = stmt.executeQuery(sql);
		
//		System.out.println(rs);//com.mysql.jdbc.JDBC4ResultSet@439f5b3d
		
		/*
		 * 三、解析ResultSet
		 * 	1.把行光标移动到第一行,可以调用boolean next()方法。返回值为true表示当前行(已经移动后的)存在。
		 * 		BeforeFirst和Afterlast都是不存在的
		 * 		rs.getInt(1)获取第一列、rs.getInt("empno");
		 * 		rs.getString(2)、rs.getString("ename);
		 */
		while(rs.next()){ //把光标移动到下一行，并判断移动到的那一行是否存在.
			
			int empno = rs.getInt(1);//获取第一列的值(rs.next已经锁定是在第一行)
			String ename = rs.getString("ename");//获取第一行第二列的值。
			double sal = rs.getDouble("sal");
			
			System.out.println(empno+", "+ename+", "+sal);
			
		}
		
		/*
		 * 四、关闭资源
		 * 	a,b,c,d顺序创建，d,c,b,a顺序关闭
		 */
		rs.close();
		stmt.close();
		conn.close();//这个必须要关.因为后面写的程序都不会结束（服务器）,所以进程不结束，不会自动释放资源，需要手动关闭。
	}
	
	public void demo4(){	//代码规范化和ResultSet
		
		/*
		 * try外定义引用
		 * try内实例化对象
		 * finally关闭流
		 */
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
		
			String driverClassName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/exam";
			String username = "root";
			String password = "123";
			
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			
			stmt = conn.createStatement();
			String sql = "SELECT * FROM emp";
			rs = stmt.executeQuery(sql);
			
			
			//获取数据集行数
			rs.last();							
			System.out.println(rs.getRow());	//通过获取最后一行的行数来获取结果集一共有多少行
			rs.beforeFirst();					//返回到beforeFirst位置,不然下面直接跳出循环。
			
			//获取数据集元数据(列/字段/属性)
			ResultSetMetaData rsmd = rs.getMetaData();//得到元数据
			int colCount = rsmd.getColumnCount();	//获取结果集的列数
			for(int i=1 ; i<=colCount ; i++){		//结果集的行和列都是从1开始计数
				System.out.print(rsmd.getColumnName(i)+" ");
				//empno ename job mgr hiredate sal COMM deptno 
			}
			System.out.println();
			
			while(rs.next()){
				for(int i = 1; i<=colCount ; i++){
					System.out.print(rs.getObject(i)+"  ");
				}
				System.out.println();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			try{
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
				if(conn!=null)	conn.close();
			}catch(SQLException e){
				e.getStackTrace();
			}
		}
	}
	
	public void demo5() throws Exception{	//PreparedStatement，提高效率，防SQL攻击，提高代码可读性
//		String username = "张三";
//		String password = "123";
		
		//SQL攻击:用这组结果也是正确的，因为OR 'a'='a 一直都是真。
//		PreparedStatement可以防止SQL攻击，字符串判断不准出现空格等也可以解决
		String username1 = "a' OR 'a'='a";
		String password1 = "a' OR 'a'='a";
		System.out.println(login(username1,password1));//true
		
		System.out.println(login2(username1,password1));//false

	}
	
	private boolean login(String username, String password) throws Exception{
		/*
		 * 使用username和password查询数据库。如果查询出结果返回true
		 * 查不出结果，返回false
		 * 
		 * 1.得到Connection
		 * 2.得到statement
		 * 3.得到ResultSet
		 * 4.rs.next()返回什么我们就返回什么。因为结果集就只有0行和1行的情况。
		 */
		
		//
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo1";
		String user = "root";
		String psw = "123";
				
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, user, psw);
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM t_user "
				+ "WHERE username='"+username+"' AND `password`='"+password+"'";
		ResultSet rs = stmt.executeQuery(sql);
		return rs.next();
		
	}
	
	private boolean login2(String username, String password)throws Exception{
		
		String driverClassName = "com.mysql.jdbc.Driver";
		//使用预处理功能,使用预处理缓存
		String url = "jdbc:mysql://localhost:3306/demo1?useServerPrepStmts=true&cachePrepStmts=true";
		String user = "root";
		String psw = "123";
				
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, user, psw);
		
		/*
		 * 一、得到PreparedStatement对象
		 * 1.给出SQL模板：所有的参数使用?问号来代替
		 * 2.调用conn.preparedStatment(sql);得到PreparedStatement对象
		 */
		String sql = "SELECT * FROM t_user WHERE username=? AND password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*
		 * 二、为参数赋值
		 */
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs.next();
		
	}

	public void demo6() throws Exception{	//向数据库存mp3
		/*
		 * Blob -> binary large object
		 * Clob -> character large object
		 * 需要在MySQL的my.ini配置最大上传包大小。默认1M，文件里没有这个参数要自己添加。
		 * max_allowed_packet = 20M
		 */
		save();//File -> Blob
		load();//Blob -> File
	}
	
	private void save() throws Exception{	//把mp3保存到数据库中
		
		// 1.得到Connection 
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo1";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//2.给出SQL模板，得到pstmt
		String sql = "INSERT INTO t_bin VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//3.设置sql模板的参数
		pstmt.setInt(1, 1);
		pstmt.setString(2, "Safest Place.mp3");
		/**
		 * 怎么从.mp3文件  -> blob对象？
		 * 1.把文件变成byte[]数组
		 * 2.Blob blob = new Blob(byte[])
		 */
		File file = new File("E:/Eclipse/db/Demo58/Safest Place.mp3");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[bis.available()];
		bis.read(buf);	
		//Blob:binary larg object 二进制大对象
		Blob blob = new SerialBlob(buf);
		pstmt.setBlob(3, blob);
		
		//4.调用pstmt的executeUpdate();
		pstmt.executeUpdate();
		bis.close();
	}
	private void load() throws Exception{	//从数据库读取mp3
		//1.得到Connection
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo1";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		//2.给出SQL模板,得到pstmt
		String sql = "SELECT * FROM t_bin";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//3.得到结果集
		ResultSet rs = pstmt.executeQuery();
		
		//4.获取rs中Data列(字段、属性)的数据
		if(rs.next()){
			Blob blob = rs.getBlob("DATA");
			/*
			 * 5.把变成硬盘上的文件
			 *	> 通过Blob得到输入流对象
			 *  > 自己创建输出流对象
			 *  > 把输入流的数据写到输出流中
			 */
			File file = new File("E:/Eclipse/db/Demo58/DB-Safest Place.mp3");
			InputStream in = blob.getBinaryStream();
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf))!=-1){
				out.write(buf, 0, len);
				out.flush();
			}
			out.close();
		}
	}
	
	public void demo7() throws Exception{	//批处理把SQL语句发送到数据库
		/*
		 * pstmt内部有集合(批)
		 * 1.用循环向pstmt添加SQL参数,它有模板，使用一组参数与模板组合，就可以变成多条语句
		 * 2.调用执行批方法，向数据库发送。
		 * 
		 * MySQL的批处理默认是关闭的，需要在URL添加参数rewriteBatchStatements=true
		 */
		// 得到Connection 
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo1?rewriteBatchedStatements=true";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// 1.
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 2.
		for(int i=0 ; i<1000 ; i++){
			pstmt.setInt(1, i+1);
			pstmt.setString(2, "stu_"+i);
			pstmt.setInt(3, (int)(Math.random()*100));
			pstmt.setString(4, i%2==0?"男":"女");
			
			pstmt.addBatch();//添加到批
		}
		
		// 3.
		long start = System.currentTimeMillis();
		pstmt.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end-start);//没打开批处理6517毫秒，5535毫秒。 打开批处理60毫秒
		
		
	}
	
	public void demo8() {	//jdbc中处理事务
		Demo8_TransferService trans = new Demo8_TransferService();
		trans.transfer("zs", "ls", 100);
		//Demo/lib/LQCUtils.jar/dbconfig.properties
	}
	
	public void demo9() throws SQLException{	//数据库连接池	commons-dbcp连接池
//		数据库连接池都实现了javax.sql.DataSource接口
		/*
		 * 1.创建连接池对象
		 * 2.配置四大参数
		 * 3.配置池参数
		 * 4.得到池对象
		 * 
		 * 池返回的Connection对象的close()方法不是关闭连接，而是把连接归还给池
		 * 连接池一个就够了。
		 */
		//1.
		BasicDataSource ds = new BasicDataSource();
		//2.
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/demo1");
		ds.setUsername("root");
		ds.setPassword("123");
		
		//3.
		ds.setMaxActive(20);//最大连接
		ds.setMinIdle(3);//最小空闲连接
//		ds.setInitialSize(5);//池初始化大小(初始化连接数)
		ds.setMaxWait(1000);//最大等待时间
		
		//4.
		Connection conn = ds.getConnection();
//		System.out.println(conn);//jdbc:mysql://localhost:3306/demo1, UserName=root@localhost, MySQL-AB JDBC Driver
//		System.out.println(conn.getClass().getName());//org.apache.commons.dbcp.PoolingDataSource$PoolGuardConnectionWrapper
		
		//..得到pstmt，查询，得到rs...
		
		//5.归还连接池
		conn.close();
		/*
		 * ds.getConnection();返回的conn使用了装饰设计模式
		 * 连接池使用四大参数创建连接调用mysql驱动得到conn对象
		 * 连接池对mysql的连接对象进行装饰，只增强(修改)了close()方法。从连接关闭变成连接归还给连接池。
		 */
		
	}
	
	public void demo10() throws PropertyVetoException, SQLException{	//手动配置c3p0连接池
		/*
		 * 以后用c3p0连接池,不用dbcp连接池
		 */
		//1.创建连接池对象
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//2.配置四大参数
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/demo1");
		cpds.setUser("root");
		cpds.setPassword("123");
		
		//3.配置池参数，可以不陪都有默认值
		cpds.setAcquireIncrement(5);//增量
		cpds.setInitialPoolSize(5);//初始化连接数
		cpds.setMinPoolSize(2);//最小连接数
		cpds.setMaxPoolSize(20);//最大连接数
		
		//4.得到conn
		Connection conn = cpds.getConnection();
		
		System.out.println(conn);
		
		//5.归还给池
		conn.close();
	}
	
	public void demo11() throws Exception{	//使用配置文件默认配置c3p0连接池
		
		/**
		 * 在创建连接池时,这个对象就会自动加载配置文件,不用代码来设置。如果设置了池参数会覆盖掉加载配置信息
		 * 命名配置，构造器的参数为<named-config name="oracle-config"> 中name的值
		 */
//		ComboPooledDataSource cpds = new ComboPooledDataSource();
		ComboPooledDataSource cpds = new ComboPooledDataSource("oracle-config");
		Connection conn = cpds.getConnection();
		System.out.println(conn);
		conn.close();
	}

	public void demo12() {	//commons-dbutils包的原理
		
		/*
		 * 发现addStu,updateStu,deleteStu,都是只变SQL模板和SQL模板中的参数
		 * 所以(Demo12_QR)：	1.通过连接池得到连接对象conn
		 * 					2.通过conn和sql模板创建pstmt
		 * 					3.通过pstmt给模板的参数赋值
		 * 					4.执行pstmt.executeUpdate();
		 */

//		增
		Stu stu = new Stu(1001,"zhangSan_1001",99,"男");
		addStu(stu);
//		改
		Stu stu1 = new Stu(1,"zhangSan",2,"男");
		updateStu(stu1);
//		删
		deleteStu(1001);
//		查
		Stu stu2 = load(777);
		System.out.println(stu2);
	}
	private void addStu(Stu stu){
	
		Demo12_QR<Stu> qr = new Demo12_QR<Stu>(JDBCUtils.getDataSource());
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";
		Object[] params = {stu.getSid(),stu.getSname(),stu.getAge(),stu.getGender()};
		
//		String sql = "UPDATE stu SET sname=?,age=?,gender=? WHERE sid=?";
//		Object[] params = {stu.getSname(),stu.getAge(),stu.getGender(),stu.getSid()};
		qr.update(sql, params);
	}
	
	private void updateStu(Stu stu){
		
		Demo12_QR<Stu> qr = new Demo12_QR<Stu>(JDBCUtils.getDataSource());
		String sql = "UPDATE stu SET sname=?,age=?,gender=? WHERE sid=?";
		Object[] params = {stu.getSname(),stu.getAge(),stu.getGender(),stu.getSid()};
		qr.update(sql, params);
	}
	
	private void deleteStu(int sid){
		Demo12_QR<Stu> qr = new Demo12_QR<Stu>(JDBCUtils.getDataSource());
		String sql = "DELETE FROM stu WHERE sid = ?";
		Object[] params = {sid};
		qr.update(sql, params);
	}
	
	private Stu load(int sid){
		Demo12_QR<Stu> qr = new Demo12_QR<Stu>(JDBCUtils.getDataSource());//得到QR对象
		String sql = "SELECT * FROM stu WHERE sid=?";// 给出SQL模板
		Object[] params = {sid};	//	给出参数 sid
		
		RsHandler<Stu> rh = new RsHandler<Stu>(){

			@Override
			public Stu handle(ResultSet rs) throws SQLException{
				if(!rs.next()) return null;
				Stu stu = new Stu();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getString("gender"));
				
				return stu;
			}
			
		};
		
		return (Stu) qr.query(sql, rh, params);
	}
	
	public void demo13() throws SQLException{	//common-dbutils的使用
		//使用dbutils的QueryRunner对数据库进行增、删、改
		//1.创建qr对象，需要提供连接池对象
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		//2.设置sql模板
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";
		//3.设置sql参数
		Object[] params = {1001,"张三",88,"妖"};
		//4.执行增删改
		qr.update(sql,params);
		
		//-------------割-------------------------------
		
		//使用dbutils的QueryRunner对数据库进行查询
		//1.创建qr对象，需要提供连接池对象
		QueryRunner qr1 = new QueryRunner(JDBCUtils.getDataSource());
		//2.
		String sql1  = "SELECT * FROM stu WHERE sid=?";
		//3.
		Object[] params1 = {777};
		//4.实现ResultSetHandler接口
//		ResultSetHandler<Stu> rsh = new ResultSetHandler<Stu>(){
//
//			@Override
//			public Stu handle(ResultSet rs) throws SQLException {
//				Stu stu = new Stu();
//				stu.setSid(rs.getInt("sid"));
//				stu.setSname(rs.getString("sname"));
//				stu.setAge(rs.getInt("age"));
//				stu.setGender(rs.getString("gender"));
//				return stu;
//			}
//		};
		//5.执行查询,返回泛型对象
//		Stu stu = qr.query(sql1, rsh, params1);
		
		//查询第四步和第五步结合，BeanHandler实现了ResultSetHandler，参数是类型
		Stu stu = qr1.query(sql1, new BeanHandler<Stu>(Stu.class), params1);
		System.out.println(stu);
		
	}
	
	public void demo14() throws SQLException{	//演示ResultSetHandler的几个实现类
		
		/**
		 * BeanHandler,
		 * BeanListHandler,对应多条查询记录的的结果集处理器
		 * MapHandler
		 * MapListHandler
		 * ScalarHandler(单行单列),通常用于select count(*) from stu。结果集是单行单列，返回一个Object
		 */
		//BeanListHandler
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from stu";
		List<Stu> stu_list = qr.query(sql, new BeanListHandler<Stu>(Stu.class));
		System.out.println(stu_list.size());//1001
		
		//MapHandler
		String sql1 = "SELECT * FROM stu WHERE sid=?";
		Object[] params = {1001};
		Map<String,Object> map = qr.query(sql1, new MapHandler(), params);
		System.out.println(map);//{sid=1001, sname=张三, age=88, gender=妖}
		
		//MapListHandler
		List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
		System.out.println(list.size());//1001
		
		//ScalarHandler
		String sql2 = "SELECT COUNT(*) FROM stu";
//		Object obj = qr.query(sql2, new ScalarHandler<>());
//		System.out.println(obj.getClass().getName()+":"+obj);//java.lang.Long:1001		
		/**
		 * count先转换为number，然后根据情况转换到自己想要的类型
		 */
		Number count = (Number)qr.query(sql2, new ScalarHandler<>());
		System.out.println(count.intValue());//1001
		/**
		 * MySQL驱动包不同，count(*)对应类型也不同。之前是Integer现在是Long。oracle的是BigInteger
		 * 但是这些类型都用共同的父类Number
		 */
	}
	
}

/*
 * 
 * JDBC(Java Database Connectivity)。使用Java操作数据库。
 * 一、JAVA连接MySQL步骤：
 * 1.导入jar包：驱动！	mysql-connector-java-5.1.13-bin
 * 2.加载驱动类Class.forName("类名");
 * 3.给出url、username、password
 * 4.使用DriverManager类来得到Connection对象。
 * 
 * 二、结果集的特性：当使用conn.createStatement(int,int)或者无参方法就决定了生成的stmt是什么特性。
 * 	1.是否可滚动：不可滚动时游标只能逐步向前next(),firs,last和虚拟位置和判断,否则抛出SQLException
 * 	2.是否敏感：敏感表示已经获得的结果集会随着数据库的变化而变化；不敏感表示获取结果集后如果数据库变化了，结果集依然不变。
 * 	3.是否可更新：结果集是否可以更新，更新后反过来影响数据库
 * 	但是MySQL默认createStatement()可以使用previous(),relative(int rowNum),absolute(int rouNum)
 * 	Statement stmt = conn.createStatement();生成的结果集不可滚动，不敏感，不可更新，但是最常用。
 * 	createStatement(int resultSetType , int resultSetConcurrency)//Concurrency：并发
 * 	resultSetType值：
 * 		ResultSet.TYPE_FORWARD_ONLY	: 不可滚动结果集
 * 		ResultSet.TYPE_SCROLL_INSENSITIVE : 滚动结果集，不敏感
 * 		ResultSet.TYPE_SCROLL_SENSITIVE	： 滚动结果集，敏感，没有驱动支持，因为要实时跟踪数据库浪费资源
 *	resultSetConcurrency的值：
 *		CONCUR_READ_ONLY: 结果集只读，不可更新。
 *		CONCUR_UPDATABLE: 结果集可以更新，更新后还会造成数据库的更新
 *
 * 三、PreparedStatement
 * 1.是statement接口的子接口
 * 用处：	> 防止SQL攻击
 * 		> 提高代码的可读性和可维护性
 * 		> 提高效率
 * 2.得到PreparedStatement对象
 * 	> 给出SQL模板
 *  > 调用Connection的preparedStatement(String sql模板);
 *  > 调用pstmt中的setXxx()方法给sql模板中的?赋值。 pstmt.setString(parameterIndex, x);
 *  > 调用pstmt的executeUpdate()或者executeQuery方法执行。这2个方法都没有参数，因为有模板
 * 3.预处理的原理
 * 	> 服务器工作：
 * 		1.校验sql语句语法！
 * 		2.编译：一个与函数相似的东西
 * 		3.执行：调用函数
 * 	> 使用的前提：
 * 		1.连接的数据库必须支持预处理。几乎没有不支持的
 * 		2.每个stmt都与sql模板绑定在一起。先把模板给数据库,数据库进行校验，再进行编译。执行时只是传递参数而已。
 * 		3.第二次执行时，就不用再次校验语法和再次编译。
 * 4.MySQL预处理默认是关闭的
 * 	需要设置URL的参数来打开
 * 1.使用预处理语句useServerPrepStmts=true
 * 2.使用缓存：cachePrepStmts=true	还可以指定缓存大小
 * 3.打开批处理：
 * 	jdbc:mysql://localhost:3306/demo1?useServerPrepStmts=true&cachePrepStmts=true
 * 
 * 四、java.tuil.Date 与  java.sql.Date转换
 * > 为什么需要sql.Date和java.util.Date类型转换？
 * 因为值会赋值到JavaBean中，而JavaBean穿梭在各层,而数据访问层之外不能出现sql包。
 * 所以JavaBean从服务层到数据访问层再到数据库时，数据访问层要把
 * 		utils.Date --> sql.Date/Time/Timestamp,
 * 		> 转换：	1.把util.Date转化成long型的毫秒值
 * 				2.使用毫秒值创建sql.Date/Time/Timestamp
 * 				java.util.Date date = new java.util.Date();
 * 				long time = date.getTime();
 * 				java.sql.Date sql_date = new java.sql.Date(time);
 * 数据库的数据到数据访问层再通过JavaBean到服务层时，数据访问层需要把
 * 		sql.Date/Time/Timestamp --> utils.Date
 * 		> 转换：因为sql.Date/Time/Timestamp是utils.Date的子类。所以转换时：
 * 		utils.Date date = rs.getDate("date");
 * 
 * 五、事务
 * 	1.事务的四大特性(ACID)：*面试！
 * 		> 原子性：一件事要么全成功，要么全不成功，不会成功一半。例如银行转账不能够只修改一条数据就抛异常结束。简单地说就事务是不可以分割。
 * 		> 一致性：事务发生前后，数据状态和业务规则要保持一致。例如转账前和转账后2人的余额之和是一样的。
 * 		> 隔离性：并发执行中的事务不会互相干扰。
 * 		> 持久性：事务一旦完成后，事务中的数据操作都持久化到数据库中。即使是提交后数据库立刻崩溃，数据库重启后也能恢复数据。
 * 	2.MySQL中操作事务：
 * 		> 开启事务：start transaction
 * 		> 结束事务： commit(提交)或rollback(回滚)
 * 	3.JDBC中操作事务：
 * 		> jdbc中的事务都是通过connection完成的
 * 			a. conn.setAutoCommit(false)表示开启事务。默认是关闭的(true)。事务是一批语句，自动提交是一条一条的提交。
 * 			b. conn.commit()提交
 * 			c. conn.rollback()回滚
 * 		> jdbc处理事务格式
 * 			try{
 * 				conn.setAutoCommit(false);//开启事务
 * 				...
 * 				conn.commit();//提交事务
 * 			} catch(Exception e){
 * 				conn.rollback();//出现异常回滚事务
 * 			}	
 * 		> 同一事务的所有操作都需要用同一个conn对象
 * 
 * 		> 事务的隔离级别：
 * 			a.事务的并发读问题：
 * 				* 脏读：读取到另一个事务未提交的数据(后果最严重)
 * 				* 不可重复读：两次读取同一数据不一致，因为另一事务对该任务进行了修改。
 * 				* 幻读(虚读)：对同一张表两次查询结果不一致。因为另一条事务插入了条记录
 * 			b.四个隔离级别：
 * 				* 串行化（不可并发）：不会出现并发问题，性能：*，最容易引起死锁。
 * 				* 可重复读(MySQL默认)：防止脏读和不可重复读，读取的都是事务开始的状态，其他事务改变了数据看不到，只看到
 * 					本事务一开始的数据状态。性能：**
 * 				* 读已提交数据(Oracle默认)：防止脏读，已提交的数据就可以读。性能：***。
 * 				* 读未提交数据：不能解决并发问题，只要数据改了，事务还没提交就可以读，但是万一不是事务提交而是事务回滚。
 * 					那么数据就不一样了。性能：****。
 * 			c.MySQL设置隔离级别
 * 				查看隔离级别：SELECT @@tx_isolation;
 * 				设置隔离级别：SET transaction isolation[..];
 * 			d.jdbc设置隔离级别
 * 				conn.setTransactionIsolation(int level);
 * 				level:	Connection.TRANSACTION_READ_UNCOMMITED;
 * 						Connection.TRANSACTION_READ_COMMITED;
 * 						Connection.TRANSACTION_REPEATABLE_READ;
 * 						Connection.TRANSACTION_SERIALIZABLE;
 * 六、数据库连接池
 * 	常量池、线程池、数据库连接池、XX池目标都是为了实现可重用。通常是用Map实现池放在对象中。
 * 	为什么要可重用？因为这些创建和销毁都是非常麻烦的。
 * 	数据库连接池用来管理连接的生命周期，用来创建连接和销毁连接。
 * 1.池参数 (所有池参数都有默认值)
 * 	初始化大小：初始化池有的连接数
 *  最小空闲连接数：快借完了，需要创建来补充。
 *  增量：一次创建的最小单位。一次可以创建多个连接
 *  最大空闲连接数：创建+归还的连接数导致池里总数太多，浪费资源，所以要销毁一些连接数。
 *  最大连接数：就算池里的的连接都借完了也不创建了，一共就这么多，等着归还连接。
 *  最大等待时间：等了1000毫秒后还没有人归还连接，就抛异常
 *  
 * 	池被创建后有个初始化大小(5)个连接数，有程序需要连接就借出去，借到最小空闲连接数(3)，就创建连接，每次创建5个连接(增量为5，假设创建2次),
 * 	借出去的连接还回来了一共有15个连接，但是又太多了，所以销毁一些连接(销毁3个)，到最大空闲连接数(12)。如果总共连接数到达20，就算最小空闲
 *  连接数为0也不创建新连接。如果池空了1000毫秒后还没有连接被归还就抛出异常。
 * 2.数据库连接池的创建
 * 	> 连接池也是需要driverClassName,url,username,password来创建连接。
 * 	> 通过apache提供的commons-dbcp-1.4.jar创建连接池
 * 
 * 七、装饰设计模式
 * 1.对象增强手段：
 * 	> 继承：缺点：增强的内容是不能修改的的，被增强的对象也是不能修改的。导致继承会使类增多。
 * 		* 有糖、加奶、加袜子、加盐咖啡，排列组合来继承的话要写很多类，后面多个加橙汁，又加很多类。
 * 	> 装饰设计模式：增强的内容是不能修改的，被增强的对象是任意的(不用知道被增强的对象的类型,只知道它的父类或者接口就够了)。
 * 		* 咖啡 a =new 加糖(); 咖啡 b = new 加盐(a);  咖啡 c = new 加奶(b); 
 *  > 动态代理(AOP)：增强的内容可以切换(事务处理)，被增强的的对象也可以切换(Service),
 *  	
 *  八、c3p0
 *  1.dbcp使用的是装饰设计模式，c3p0使用动态代理
 *  2.c3p0指定配置文件
 *  	> 文件名必须为：c3p0-config.xml
 *  	> 文件路径必须在src下
 *  
 *  九、Tomcat配置JNDI资源 JavaWebDemo35
 *  1.JNDI Java Naming and Directory Interface
 *  2.JNDI作用：在服务器上配置资源，然后通过统一的方式获取资源。 简单的说就是对资源的存，取。
 *  3.目标：把数据库连接池配置到Tomcat，通过JNDI获取资源
 *  
 *  十、common-dbutils.jar
 *  1.最核心的类：QueryRunner
 *  	> int update(String sql, Object[] params)//可以执行增、删、改
 *  	> int update(Connection conn,String sql, Object[] params)//内部不使用连接池创建,conn作为参数可以保证调用2次
 *  		conn对象是相同的，就是支持事务。
 *  	> T query(Sting sql, ResultSetHandler rsh, Object... params)//执行查询
 *  	> T query(Connection conn, Sting sql, ResultSetHandler rsh, Object... params)//执行查询，支持事务。
 *  		* 先得到ResultSet，然后调用ResultSetHandler的handle()把rs转换为需要的类型
 *  2.ResultSetHandler接口：
 *  	> 实现类BeanHandler,构造器需要Class类型的参数，把结果集转换为javabean对象。用于数据库查询到1条记录
 *  	> BeanListHandler,构造器也需要Class类型的参数，用来把结果集转换为javabean对象的list。用于数据库查询到多条记录
 *  	> MapHandler,把结果集转换为map对象{sid:1001,sname:"zhangSan",age:18,gender:male}数据库查询到一条记录变成一个Map
 *  	> MapListHandler,数据库查询到多条记录变成List<Map>
 *  	> ScalarHandler(单行单列),通常用于select count(*) from stu。结果集是单行单列，返回一个Object
 *  
 */