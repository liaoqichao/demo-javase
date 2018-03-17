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

	public void demo1() throws ClassNotFoundException, SQLException  {	//�������ݿ�
		/**
		 * classNotFoundException��
		 * 	> û��������
		 * 	> Driver���
		 * 
		 * SQLException��
		 * 	> ���url��username��password�Ƿ���ȷ
		 *  > ���MySQL�������Ƿ���
		 */
		/*
		 * jdbc�Ĵ����ò�����
		 * > driverClassName:com.mysql.jdbc.Driver
		 * > url:jdbc:mysql://localhost:3306/���ݿ�����(mydb1)
		 * > username:root
		 * > password:123
		 * 
		 * ����4�������ĳɱ�����ݿ�Ĳ����Ϳ������ӱ�����ݿ⡣�������������ݿ�Ĳ��趼һ�������ǲ�����һ��������
		 * 
		 * 1.����������
		 * 2.ͨ��DriverManager��ʹ��url��username��password�õ�Connection����
		 */
		//1. JAR����JDBC4����һ������Ҳ���ԡ�JDBC4.0��ÿ��jar��������,��META-INF/servicesĿ¼���ṩ��
//		java.sql.Driver�ļ������ļ������ݾ��Ǹýӿ�ʵ��������ơ�
		Class.forName("com.mysql.jdbc.Driver");	//����������(ע������)
		
//		Class.forName("com.mysql.jdbc.Driver");�����������д���
//		��ΪDriver�о�̬����飬���棺java.sql.DriverManager.registerDriver(new Driver());һ���������������ִ���ˡ�
//		com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		/*
		 * ���е�java.sql.Driverʵ����,���ṩ��static��,���ڴ�����ǰ��Լ�ע�ᵽDriverManager�У�
		 * java.sql.DriverManager.registerDriver(new Driver()); �����Driver�Ǹ������̵�ʵ����
		 */
		
		//2.
		String url = "jdbc:mysql://localhost:3306/mydb1";
		String username = "root";
		String password = "123";
		
		//java.sql.Connection ���� jdbc.mysql.Connection����Ϊjava.sql.Connection��ͨ�õĽӿ�
//		�� jdbc.mysql.Connectionֻ��һ��ʵ���ࡣ
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);//com.mysql.jdbc.JDBC4Connection@31cefde0
		
		conn.close();
	}
	
	public void demo2() throws ClassNotFoundException, SQLException{	//���ݿ������ɾ����
		/*
		 * һ���õ�Connection
		 * 	1.׼���Ĵ����
		 * 	2.����������
		 * 	3.�õ�Connection
		 * 
		 */
		//1.׼���Ĵ����
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb1";//jdbcЭ��ĸ�ʽ
		String username = "root";
		String password = "123";
		//2.����������
		Class.forName(driverClassName);
		//3.�õ�Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		/*
		 * ��������ɾ�������ݿ�
		 * 	1.ͨ��connection���󴴽�statement(���룺��䣬��Ҫ����Ϊ����)����
		 * 		> statement�Ĺ����������ݿⷢ��sql��䡣
		 * 	2.���� statement��int executeUpdate(String sql)������DML��DDL������ͨ��ֻ�Լ�¼����,���Ա�ṹ������
		 * 	  �䷵��ֵ��Ӱ������У�����3˵��sql���Ӱ�����м�¼��
		 */
		
		//1.��java.sql.Statement��
		Statement stmt = conn.createStatement();
		//2.�����ַ�����SQL��䲻�ܼӷֺţ�ֻ��д1��SQL���
		String sql = "INSERT INTO tb_stu VALUES('ITCAST_0005','liQi','88','male')";
//		String sql = "UPDATE tb_stu SET gender='male',age=20 WHERE name='liQi'";
//		String sql = "DELETE FROM tb_stu";
		int r = stmt.executeUpdate(sql);
		System.out.println(r);//1. �޸���1�м�¼��
		
		stmt.close();
		conn.close();
	}
	
	public void demo3() throws ClassNotFoundException, SQLException{	//���ݿ�Ĳ�ѯ
		
		/*
		 * һ���õ�Connection
		 * �����õ�statement����select����
		 * �����Բ�ѯ���صĽ�����н�����
		 */
		
		//һ��
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//����
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM emp";
		ResultSet rs = stmt.executeQuery(sql);
		
//		System.out.println(rs);//com.mysql.jdbc.JDBC4ResultSet@439f5b3d
		
		/*
		 * ��������ResultSet
		 * 	1.���й���ƶ�����һ��,���Ե���boolean next()����������ֵΪtrue��ʾ��ǰ��(�Ѿ��ƶ����)���ڡ�
		 * 		BeforeFirst��Afterlast���ǲ����ڵ�
		 * 		rs.getInt(1)��ȡ��һ�С�rs.getInt("empno");
		 * 		rs.getString(2)��rs.getString("ename);
		 */
		while(rs.next()){ //�ѹ���ƶ�����һ�У����ж��ƶ�������һ���Ƿ����.
			
			int empno = rs.getInt(1);//��ȡ��һ�е�ֵ(rs.next�Ѿ��������ڵ�һ��)
			String ename = rs.getString("ename");//��ȡ��һ�еڶ��е�ֵ��
			double sal = rs.getDouble("sal");
			
			System.out.println(empno+", "+ename+", "+sal);
			
		}
		
		/*
		 * �ġ��ر���Դ
		 * 	a,b,c,d˳�򴴽���d,c,b,a˳��ر�
		 */
		rs.close();
		stmt.close();
		conn.close();//�������Ҫ��.��Ϊ����д�ĳ��򶼲����������������,���Խ��̲������������Զ��ͷ���Դ����Ҫ�ֶ��رա�
	}
	
	public void demo4(){	//����淶����ResultSet
		
		/*
		 * try�ⶨ������
		 * try��ʵ��������
		 * finally�ر���
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
			
			
			//��ȡ���ݼ�����
			rs.last();							
			System.out.println(rs.getRow());	//ͨ����ȡ���һ�е���������ȡ�����һ���ж�����
			rs.beforeFirst();					//���ص�beforeFirstλ��,��Ȼ����ֱ������ѭ����
			
			//��ȡ���ݼ�Ԫ����(��/�ֶ�/����)
			ResultSetMetaData rsmd = rs.getMetaData();//�õ�Ԫ����
			int colCount = rsmd.getColumnCount();	//��ȡ�����������
			for(int i=1 ; i<=colCount ; i++){		//��������к��ж��Ǵ�1��ʼ����
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
	
	public void demo5() throws Exception{	//PreparedStatement�����Ч�ʣ���SQL��������ߴ���ɶ���
//		String username = "����";
//		String password = "123";
		
		//SQL����:��������Ҳ����ȷ�ģ���ΪOR 'a'='a һֱ�����档
//		PreparedStatement���Է�ֹSQL�������ַ����жϲ�׼���ֿո��Ҳ���Խ��
		String username1 = "a' OR 'a'='a";
		String password1 = "a' OR 'a'='a";
		System.out.println(login(username1,password1));//true
		
		System.out.println(login2(username1,password1));//false

	}
	
	private boolean login(String username, String password) throws Exception{
		/*
		 * ʹ��username��password��ѯ���ݿ⡣�����ѯ���������true
		 * �鲻�����������false
		 * 
		 * 1.�õ�Connection
		 * 2.�õ�statement
		 * 3.�õ�ResultSet
		 * 4.rs.next()����ʲô���Ǿͷ���ʲô����Ϊ�������ֻ��0�к�1�е������
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
		//ʹ��Ԥ������,ʹ��Ԥ������
		String url = "jdbc:mysql://localhost:3306/demo1?useServerPrepStmts=true&cachePrepStmts=true";
		String user = "root";
		String psw = "123";
				
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, user, psw);
		
		/*
		 * һ���õ�PreparedStatement����
		 * 1.����SQLģ�壺���еĲ���ʹ��?�ʺ�������
		 * 2.����conn.preparedStatment(sql);�õ�PreparedStatement����
		 */
		String sql = "SELECT * FROM t_user WHERE username=? AND password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*
		 * ����Ϊ������ֵ
		 */
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs.next();
		
	}

	public void demo6() throws Exception{	//�����ݿ��mp3
		/*
		 * Blob -> binary large object
		 * Clob -> character large object
		 * ��Ҫ��MySQL��my.ini��������ϴ�����С��Ĭ��1M���ļ���û���������Ҫ�Լ���ӡ�
		 * max_allowed_packet = 20M
		 */
		save();//File -> Blob
		load();//Blob -> File
	}
	
	private void save() throws Exception{	//��mp3���浽���ݿ���
		
		// 1.�õ�Connection 
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo1";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//2.����SQLģ�壬�õ�pstmt
		String sql = "INSERT INTO t_bin VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//3.����sqlģ��Ĳ���
		pstmt.setInt(1, 1);
		pstmt.setString(2, "Safest Place.mp3");
		/**
		 * ��ô��.mp3�ļ�  -> blob����
		 * 1.���ļ����byte[]����
		 * 2.Blob blob = new Blob(byte[])
		 */
		File file = new File("E:/Eclipse/db/Demo58/Safest Place.mp3");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[bis.available()];
		bis.read(buf);	
		//Blob:binary larg object �����ƴ����
		Blob blob = new SerialBlob(buf);
		pstmt.setBlob(3, blob);
		
		//4.����pstmt��executeUpdate();
		pstmt.executeUpdate();
		bis.close();
	}
	private void load() throws Exception{	//�����ݿ��ȡmp3
		//1.�õ�Connection
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo1";
		String username = "root";
		String password = "123";
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		//2.����SQLģ��,�õ�pstmt
		String sql = "SELECT * FROM t_bin";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//3.�õ������
		ResultSet rs = pstmt.executeQuery();
		
		//4.��ȡrs��Data��(�ֶΡ�����)������
		if(rs.next()){
			Blob blob = rs.getBlob("DATA");
			/*
			 * 5.�ѱ��Ӳ���ϵ��ļ�
			 *	> ͨ��Blob�õ�����������
			 *  > �Լ��������������
			 *  > ��������������д���������
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
	
	public void demo7() throws Exception{	//�������SQL��䷢�͵����ݿ�
		/*
		 * pstmt�ڲ��м���(��)
		 * 1.��ѭ����pstmt���SQL����,����ģ�壬ʹ��һ�������ģ����ϣ��Ϳ��Ա�ɶ������
		 * 2.����ִ���������������ݿⷢ�͡�
		 * 
		 * MySQL��������Ĭ���ǹرյģ���Ҫ��URL��Ӳ���rewriteBatchStatements=true
		 */
		// �õ�Connection 
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
			pstmt.setString(4, i%2==0?"��":"Ů");
			
			pstmt.addBatch();//��ӵ���
		}
		
		// 3.
		long start = System.currentTimeMillis();
		pstmt.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end-start);//û��������6517���룬5535���롣 ��������60����
		
		
	}
	
	public void demo8() {	//jdbc�д�������
		Demo8_TransferService trans = new Demo8_TransferService();
		trans.transfer("zs", "ls", 100);
		//Demo/lib/LQCUtils.jar/dbconfig.properties
	}
	
	public void demo9() throws SQLException{	//���ݿ����ӳ�	commons-dbcp���ӳ�
//		���ݿ����ӳض�ʵ����javax.sql.DataSource�ӿ�
		/*
		 * 1.�������ӳض���
		 * 2.�����Ĵ����
		 * 3.���óز���
		 * 4.�õ��ض���
		 * 
		 * �ط��ص�Connection�����close()�������ǹر����ӣ����ǰ����ӹ黹����
		 * ���ӳ�һ���͹��ˡ�
		 */
		//1.
		BasicDataSource ds = new BasicDataSource();
		//2.
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/demo1");
		ds.setUsername("root");
		ds.setPassword("123");
		
		//3.
		ds.setMaxActive(20);//�������
		ds.setMinIdle(3);//��С��������
//		ds.setInitialSize(5);//�س�ʼ����С(��ʼ��������)
		ds.setMaxWait(1000);//���ȴ�ʱ��
		
		//4.
		Connection conn = ds.getConnection();
//		System.out.println(conn);//jdbc:mysql://localhost:3306/demo1, UserName=root@localhost, MySQL-AB JDBC Driver
//		System.out.println(conn.getClass().getName());//org.apache.commons.dbcp.PoolingDataSource$PoolGuardConnectionWrapper
		
		//..�õ�pstmt����ѯ���õ�rs...
		
		//5.�黹���ӳ�
		conn.close();
		/*
		 * ds.getConnection();���ص�connʹ����װ�����ģʽ
		 * ���ӳ�ʹ���Ĵ�����������ӵ���mysql�����õ�conn����
		 * ���ӳض�mysql�����Ӷ������װ�Σ�ֻ��ǿ(�޸�)��close()�����������ӹرձ�����ӹ黹�����ӳء�
		 */
		
	}
	
	public void demo10() throws PropertyVetoException, SQLException{	//�ֶ�����c3p0���ӳ�
		/*
		 * �Ժ���c3p0���ӳ�,����dbcp���ӳ�
		 */
		//1.�������ӳض���
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//2.�����Ĵ����
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/demo1");
		cpds.setUser("root");
		cpds.setPassword("123");
		
		//3.���óز��������Բ��㶼��Ĭ��ֵ
		cpds.setAcquireIncrement(5);//����
		cpds.setInitialPoolSize(5);//��ʼ��������
		cpds.setMinPoolSize(2);//��С������
		cpds.setMaxPoolSize(20);//���������
		
		//4.�õ�conn
		Connection conn = cpds.getConnection();
		
		System.out.println(conn);
		
		//5.�黹����
		conn.close();
	}
	
	public void demo11() throws Exception{	//ʹ�������ļ�Ĭ������c3p0���ӳ�
		
		/**
		 * �ڴ������ӳ�ʱ,�������ͻ��Զ����������ļ�,���ô��������á���������˳ز����Ḳ�ǵ�����������Ϣ
		 * �������ã��������Ĳ���Ϊ<named-config name="oracle-config"> ��name��ֵ
		 */
//		ComboPooledDataSource cpds = new ComboPooledDataSource();
		ComboPooledDataSource cpds = new ComboPooledDataSource("oracle-config");
		Connection conn = cpds.getConnection();
		System.out.println(conn);
		conn.close();
	}

	public void demo12() {	//commons-dbutils����ԭ��
		
		/*
		 * ����addStu,updateStu,deleteStu,����ֻ��SQLģ���SQLģ���еĲ���
		 * ����(Demo12_QR)��	1.ͨ�����ӳصõ����Ӷ���conn
		 * 					2.ͨ��conn��sqlģ�崴��pstmt
		 * 					3.ͨ��pstmt��ģ��Ĳ�����ֵ
		 * 					4.ִ��pstmt.executeUpdate();
		 */

//		��
		Stu stu = new Stu(1001,"zhangSan_1001",99,"��");
		addStu(stu);
//		��
		Stu stu1 = new Stu(1,"zhangSan",2,"��");
		updateStu(stu1);
//		ɾ
		deleteStu(1001);
//		��
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
		Demo12_QR<Stu> qr = new Demo12_QR<Stu>(JDBCUtils.getDataSource());//�õ�QR����
		String sql = "SELECT * FROM stu WHERE sid=?";// ����SQLģ��
		Object[] params = {sid};	//	�������� sid
		
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
	
	public void demo13() throws SQLException{	//common-dbutils��ʹ��
		//ʹ��dbutils��QueryRunner�����ݿ��������ɾ����
		//1.����qr������Ҫ�ṩ���ӳض���
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		//2.����sqlģ��
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";
		//3.����sql����
		Object[] params = {1001,"����",88,"��"};
		//4.ִ����ɾ��
		qr.update(sql,params);
		
		//-------------��-------------------------------
		
		//ʹ��dbutils��QueryRunner�����ݿ���в�ѯ
		//1.����qr������Ҫ�ṩ���ӳض���
		QueryRunner qr1 = new QueryRunner(JDBCUtils.getDataSource());
		//2.
		String sql1  = "SELECT * FROM stu WHERE sid=?";
		//3.
		Object[] params1 = {777};
		//4.ʵ��ResultSetHandler�ӿ�
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
		//5.ִ�в�ѯ,���ط��Ͷ���
//		Stu stu = qr.query(sql1, rsh, params1);
		
		//��ѯ���Ĳ��͵��岽��ϣ�BeanHandlerʵ����ResultSetHandler������������
		Stu stu = qr1.query(sql1, new BeanHandler<Stu>(Stu.class), params1);
		System.out.println(stu);
		
	}
	
	public void demo14() throws SQLException{	//��ʾResultSetHandler�ļ���ʵ����
		
		/**
		 * BeanHandler,
		 * BeanListHandler,��Ӧ������ѯ��¼�ĵĽ����������
		 * MapHandler
		 * MapListHandler
		 * ScalarHandler(���е���),ͨ������select count(*) from stu��������ǵ��е��У�����һ��Object
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
		System.out.println(map);//{sid=1001, sname=����, age=88, gender=��}
		
		//MapListHandler
		List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
		System.out.println(list.size());//1001
		
		//ScalarHandler
		String sql2 = "SELECT COUNT(*) FROM stu";
//		Object obj = qr.query(sql2, new ScalarHandler<>());
//		System.out.println(obj.getClass().getName()+":"+obj);//java.lang.Long:1001		
		/**
		 * count��ת��Ϊnumber��Ȼ��������ת�����Լ���Ҫ������
		 */
		Number count = (Number)qr.query(sql2, new ScalarHandler<>());
		System.out.println(count.intValue());//1001
		/**
		 * MySQL��������ͬ��count(*)��Ӧ����Ҳ��ͬ��֮ǰ��Integer������Long��oracle����BigInteger
		 * ������Щ���Ͷ��ù�ͬ�ĸ���Number
		 */
	}
	
}

/*
 * 
 * JDBC(Java Database Connectivity)��ʹ��Java�������ݿ⡣
 * һ��JAVA����MySQL���裺
 * 1.����jar����������	mysql-connector-java-5.1.13-bin
 * 2.����������Class.forName("����");
 * 3.����url��username��password
 * 4.ʹ��DriverManager�����õ�Connection����
 * 
 * ��������������ԣ���ʹ��conn.createStatement(int,int)�����޲η����;��������ɵ�stmt��ʲô���ԡ�
 * 	1.�Ƿ�ɹ��������ɹ���ʱ�α�ֻ������ǰnext(),firs,last������λ�ú��ж�,�����׳�SQLException
 * 	2.�Ƿ����У����б�ʾ�Ѿ���õĽ�������������ݿ�ı仯���仯�������б�ʾ��ȡ�������������ݿ�仯�ˣ��������Ȼ���䡣
 * 	3.�Ƿ�ɸ��£�������Ƿ���Ը��£����º󷴹���Ӱ�����ݿ�
 * 	����MySQLĬ��createStatement()����ʹ��previous(),relative(int rowNum),absolute(int rouNum)
 * 	Statement stmt = conn.createStatement();���ɵĽ�������ɹ����������У����ɸ��£�������á�
 * 	createStatement(int resultSetType , int resultSetConcurrency)//Concurrency������
 * 	resultSetTypeֵ��
 * 		ResultSet.TYPE_FORWARD_ONLY	: ���ɹ��������
 * 		ResultSet.TYPE_SCROLL_INSENSITIVE : �����������������
 * 		ResultSet.TYPE_SCROLL_SENSITIVE	�� ��������������У�û������֧�֣���ΪҪʵʱ�������ݿ��˷���Դ
 *	resultSetConcurrency��ֵ��
 *		CONCUR_READ_ONLY: �����ֻ�������ɸ��¡�
 *		CONCUR_UPDATABLE: ��������Ը��£����º󻹻�������ݿ�ĸ���
 *
 * ����PreparedStatement
 * 1.��statement�ӿڵ��ӽӿ�
 * �ô���	> ��ֹSQL����
 * 		> ��ߴ���Ŀɶ��ԺͿ�ά����
 * 		> ���Ч��
 * 2.�õ�PreparedStatement����
 * 	> ����SQLģ��
 *  > ����Connection��preparedStatement(String sqlģ��);
 *  > ����pstmt�е�setXxx()������sqlģ���е�?��ֵ�� pstmt.setString(parameterIndex, x);
 *  > ����pstmt��executeUpdate()����executeQuery����ִ�С���2��������û�в�������Ϊ��ģ��
 * 3.Ԥ�����ԭ��
 * 	> ������������
 * 		1.У��sql����﷨��
 * 		2.���룺һ���뺯�����ƵĶ���
 * 		3.ִ�У����ú���
 * 	> ʹ�õ�ǰ�᣺
 * 		1.���ӵ����ݿ����֧��Ԥ��������û�в�֧�ֵ�
 * 		2.ÿ��stmt����sqlģ�����һ���Ȱ�ģ������ݿ�,���ݿ����У�飬�ٽ��б��롣ִ��ʱֻ�Ǵ��ݲ������ѡ�
 * 		3.�ڶ���ִ��ʱ���Ͳ����ٴ�У���﷨���ٴα��롣
 * 4.MySQLԤ����Ĭ���ǹرյ�
 * 	��Ҫ����URL�Ĳ�������
 * 1.ʹ��Ԥ�������useServerPrepStmts=true
 * 2.ʹ�û��棺cachePrepStmts=true	������ָ�������С
 * 3.��������
 * 	jdbc:mysql://localhost:3306/demo1?useServerPrepStmts=true&cachePrepStmts=true
 * 
 * �ġ�java.tuil.Date ��  java.sql.Dateת��
 * > Ϊʲô��Ҫsql.Date��java.util.Date����ת����
 * ��Ϊֵ�ḳֵ��JavaBean�У���JavaBean�����ڸ���,�����ݷ��ʲ�֮�ⲻ�ܳ���sql����
 * ����JavaBean�ӷ���㵽���ݷ��ʲ��ٵ����ݿ�ʱ�����ݷ��ʲ�Ҫ��
 * 		utils.Date --> sql.Date/Time/Timestamp,
 * 		> ת����	1.��util.Dateת����long�͵ĺ���ֵ
 * 				2.ʹ�ú���ֵ����sql.Date/Time/Timestamp
 * 				java.util.Date date = new java.util.Date();
 * 				long time = date.getTime();
 * 				java.sql.Date sql_date = new java.sql.Date(time);
 * ���ݿ�����ݵ����ݷ��ʲ���ͨ��JavaBean�������ʱ�����ݷ��ʲ���Ҫ��
 * 		sql.Date/Time/Timestamp --> utils.Date
 * 		> ת������Ϊsql.Date/Time/Timestamp��utils.Date�����ࡣ����ת��ʱ��
 * 		utils.Date date = rs.getDate("date");
 * 
 * �塢����
 * 	1.������Ĵ�����(ACID)��*���ԣ�
 * 		> ԭ���ԣ�һ����Ҫôȫ�ɹ���Ҫôȫ���ɹ�������ɹ�һ�롣��������ת�˲��ܹ�ֻ�޸�һ�����ݾ����쳣�������򵥵�˵�������ǲ����Էָ
 * 		> һ���ԣ�������ǰ������״̬��ҵ�����Ҫ����һ�¡�����ת��ǰ��ת�˺�2�˵����֮����һ���ġ�
 * 		> �����ԣ�����ִ���е����񲻻ụ����š�
 * 		> �־��ԣ�����һ����ɺ������е����ݲ������־û������ݿ��С���ʹ���ύ�����ݿ����̱��������ݿ�������Ҳ�ָܻ����ݡ�
 * 	2.MySQL�в�������
 * 		> ��������start transaction
 * 		> �������� commit(�ύ)��rollback(�ع�)
 * 	3.JDBC�в�������
 * 		> jdbc�е�������ͨ��connection��ɵ�
 * 			a. conn.setAutoCommit(false)��ʾ��������Ĭ���ǹرյ�(true)��������һ����䣬�Զ��ύ��һ��һ�����ύ��
 * 			b. conn.commit()�ύ
 * 			c. conn.rollback()�ع�
 * 		> jdbc���������ʽ
 * 			try{
 * 				conn.setAutoCommit(false);//��������
 * 				...
 * 				conn.commit();//�ύ����
 * 			} catch(Exception e){
 * 				conn.rollback();//�����쳣�ع�����
 * 			}	
 * 		> ͬһ��������в�������Ҫ��ͬһ��conn����
 * 
 * 		> ����ĸ��뼶��
 * 			a.����Ĳ��������⣺
 * 				* �������ȡ����һ������δ�ύ������(���������)
 * 				* �����ظ��������ζ�ȡͬһ���ݲ�һ�£���Ϊ��һ����Ը�����������޸ġ�
 * 				* �ö�(���)����ͬһ�ű����β�ѯ�����һ�¡���Ϊ��һ���������������¼
 * 			b.�ĸ����뼶��
 * 				* ���л������ɲ�������������ֲ������⣬���ܣ�*������������������
 * 				* ���ظ���(MySQLĬ��)����ֹ����Ͳ����ظ�������ȡ�Ķ�������ʼ��״̬����������ı������ݿ�������ֻ����
 * 					������һ��ʼ������״̬�����ܣ�**
 * 				* �����ύ����(OracleĬ��)����ֹ��������ύ�����ݾͿ��Զ������ܣ�***��
 * 				* ��δ�ύ���ݣ����ܽ���������⣬ֻҪ���ݸ��ˣ�����û�ύ�Ϳ��Զ���������һ���������ύ��������ع���
 * 					��ô���ݾͲ�һ���ˡ����ܣ�****��
 * 			c.MySQL���ø��뼶��
 * 				�鿴���뼶��SELECT @@tx_isolation;
 * 				���ø��뼶��SET transaction isolation[..];
 * 			d.jdbc���ø��뼶��
 * 				conn.setTransactionIsolation(int level);
 * 				level:	Connection.TRANSACTION_READ_UNCOMMITED;
 * 						Connection.TRANSACTION_READ_COMMITED;
 * 						Connection.TRANSACTION_REPEATABLE_READ;
 * 						Connection.TRANSACTION_SERIALIZABLE;
 * �������ݿ����ӳ�
 * 	�����ء��̳߳ء����ݿ����ӳء�XX��Ŀ�궼��Ϊ��ʵ�ֿ����á�ͨ������Mapʵ�ֳط��ڶ����С�
 * 	ΪʲôҪ�����ã���Ϊ��Щ���������ٶ��Ƿǳ��鷳�ġ�
 * 	���ݿ����ӳ������������ӵ��������ڣ������������Ӻ��������ӡ�
 * 1.�ز��� (���гز�������Ĭ��ֵ)
 * 	��ʼ����С����ʼ�����е�������
 *  ��С������������������ˣ���Ҫ���������䡣
 *  ������һ�δ�������С��λ��һ�ο��Դ����������
 *  ������������������+�黹�����������³�������̫�࣬�˷���Դ������Ҫ����һЩ��������
 *  ������������������ĵ����Ӷ�������Ҳ�������ˣ�һ������ô�࣬���Ź黹���ӡ�
 *  ���ȴ�ʱ�䣺����1000�����û���˹黹���ӣ������쳣
 *  
 * 	�ر��������и���ʼ����С(5)�����������г�����Ҫ���Ӿͽ��ȥ���赽��С����������(3)���ʹ������ӣ�ÿ�δ���5������(����Ϊ5�����贴��2��),
 * 	���ȥ�����ӻ�������һ����15�����ӣ�������̫���ˣ���������һЩ����(����3��)����������������(12)������ܹ�����������20��������С����
 *  ������Ϊ0Ҳ�����������ӡ�����ؿ���1000�����û�����ӱ��黹���׳��쳣��
 * 2.���ݿ����ӳصĴ���
 * 	> ���ӳ�Ҳ����ҪdriverClassName,url,username,password���������ӡ�
 * 	> ͨ��apache�ṩ��commons-dbcp-1.4.jar�������ӳ�
 * 
 * �ߡ�װ�����ģʽ
 * 1.������ǿ�ֶΣ�
 * 	> �̳У�ȱ�㣺��ǿ�������ǲ����޸ĵĵģ�����ǿ�Ķ���Ҳ�ǲ����޸ĵġ����¼̳л�ʹ�����ࡣ
 * 		* ���ǡ����̡������ӡ����ο��ȣ�����������̳еĻ�Ҫд�ܶ��࣬�������ӳ�֭���ּӺܶ��ࡣ
 * 	> װ�����ģʽ����ǿ�������ǲ����޸ĵģ�����ǿ�Ķ����������(����֪������ǿ�Ķ��������,ֻ֪�����ĸ�����߽ӿھ͹���)��
 * 		* ���� a =new ����(); ���� b = new ����(a);  ���� c = new ����(b); 
 *  > ��̬����(AOP)����ǿ�����ݿ����л�(������)������ǿ�ĵĶ���Ҳ�����л�(Service),
 *  	
 *  �ˡ�c3p0
 *  1.dbcpʹ�õ���װ�����ģʽ��c3p0ʹ�ö�̬����
 *  2.c3p0ָ�������ļ�
 *  	> �ļ�������Ϊ��c3p0-config.xml
 *  	> �ļ�·��������src��
 *  
 *  �š�Tomcat����JNDI��Դ JavaWebDemo35
 *  1.JNDI Java Naming and Directory Interface
 *  2.JNDI���ã��ڷ�������������Դ��Ȼ��ͨ��ͳһ�ķ�ʽ��ȡ��Դ�� �򵥵�˵���Ƕ���Դ�Ĵ棬ȡ��
 *  3.Ŀ�꣺�����ݿ����ӳ����õ�Tomcat��ͨ��JNDI��ȡ��Դ
 *  
 *  ʮ��common-dbutils.jar
 *  1.����ĵ��ࣺQueryRunner
 *  	> int update(String sql, Object[] params)//����ִ������ɾ����
 *  	> int update(Connection conn,String sql, Object[] params)//�ڲ���ʹ�����ӳش���,conn��Ϊ�������Ա�֤����2��
 *  		conn��������ͬ�ģ�����֧������
 *  	> T query(Sting sql, ResultSetHandler rsh, Object... params)//ִ�в�ѯ
 *  	> T query(Connection conn, Sting sql, ResultSetHandler rsh, Object... params)//ִ�в�ѯ��֧������
 *  		* �ȵõ�ResultSet��Ȼ�����ResultSetHandler��handle()��rsת��Ϊ��Ҫ������
 *  2.ResultSetHandler�ӿڣ�
 *  	> ʵ����BeanHandler,��������ҪClass���͵Ĳ������ѽ����ת��Ϊjavabean�����������ݿ��ѯ��1����¼
 *  	> BeanListHandler,������Ҳ��ҪClass���͵Ĳ����������ѽ����ת��Ϊjavabean�����list���������ݿ��ѯ��������¼
 *  	> MapHandler,�ѽ����ת��Ϊmap����{sid:1001,sname:"zhangSan",age:18,gender:male}���ݿ��ѯ��һ����¼���һ��Map
 *  	> MapListHandler,���ݿ��ѯ��������¼���List<Map>
 *  	> ScalarHandler(���е���),ͨ������select count(*) from stu��������ǵ��е��У�����һ��Object
 *  
 */