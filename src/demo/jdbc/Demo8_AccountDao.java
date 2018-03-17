package demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo8_AccountDao {

	/**
	 * �޸�ָ���û������
	 */
	public void updateBalance(Connection conn, String name ,double balance){
		
		try {
			//2.����SQLģ�壬����pstmt
			String sql = "UPDATE account SET balance=balance+? WHERE name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.��������ֵ
			pstmt.setDouble(1, balance);//�����balance��name���Ǻ����Ĳ���
			pstmt.setString(2, name);
			//4.ִ�����
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
