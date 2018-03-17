package demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Demo12_QR<T> {

	private DataSource dataSource;
	public Demo12_QR() {
		super();
	}

	public Demo12_QR(DataSource dataSource) {
		super();
		this.dataSource = dataSource;


	}

	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object... params){

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();	//通过连接池得到连接对象
			
			pstmt = conn.prepareStatement(sql);	//使用sql创建pstmt
			initParams(pstmt,params);			//设置参数
			
			return pstmt.executeUpdate();	//执行
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally{
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 给参数赋值
	 * @param pstmt
	 * @param params
	 */
	private void initParams(PreparedStatement pstmt, Object... params) {
		for(int i=0 ; i<params.length ; i++){
			try {
				pstmt.setObject(i+1, params[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public T query(String sql,RsHandler<T> rh,Object... params){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();	//通过连接池得到连接对象
			
			pstmt = conn.prepareStatement(sql);	//使用sql创建pstmt
			initParams(pstmt,params);			//设置参数
			
			rs = pstmt.executeQuery();	//执行
			
			return rh.handle(rs);	//把结果集变成javabean
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally{
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//把结果集转换为JavaBean
interface RsHandler<T>{
	public T handle(ResultSet rs) throws SQLException;
}
