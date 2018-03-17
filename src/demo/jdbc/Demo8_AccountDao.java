package demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo8_AccountDao {

	/**
	 * 修改指定用户的余额
	 */
	public void updateBalance(Connection conn, String name ,double balance){
		
		try {
			//2.给出SQL模板，创建pstmt
			String sql = "UPDATE account SET balance=balance+? WHERE name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.给参数赋值
			pstmt.setDouble(1, balance);//这里的balance和name都是函数的参数
			pstmt.setString(2, name);
			//4.执行语句
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
