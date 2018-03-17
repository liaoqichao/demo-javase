package demo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import lqcUtils.JDBCUtils;

/**
 * 演示转账
 * @author Administrator
 *
 */
public class Demo8_TransferService {

	/**
	 * 转账方法
	 * 业务层使用SQL？day19中自定义小工具，把conn隐藏起来
	 * @param from
	 * @param to
	 * @param money
	 */
	public void transfer(String from,String to,double money){
		//对事务的操作，需要得到Connection，要与AccountDao同一个Connection对象
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			//开始事务
			conn.setAutoCommit(false);
			Demo8_AccountDao dao = new Demo8_AccountDao();
			dao.updateBalance(conn,from, -money);	//给from减去相应金额
			
//			if(true){
//				throw new RuntimeException("不好意思");
//			}
			
			dao.updateBalance(conn,to, money);		//给to加上相应金额
			//提交事务
			conn.commit();
		} catch (Exception e) {
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}finally{
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
