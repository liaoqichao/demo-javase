package demo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import lqcUtils.JDBCUtils;

/**
 * ��ʾת��
 * @author Administrator
 *
 */
public class Demo8_TransferService {

	/**
	 * ת�˷���
	 * ҵ���ʹ��SQL��day19���Զ���С���ߣ���conn��������
	 * @param from
	 * @param to
	 * @param money
	 */
	public void transfer(String from,String to,double money){
		//������Ĳ�������Ҫ�õ�Connection��Ҫ��AccountDaoͬһ��Connection����
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			//��ʼ����
			conn.setAutoCommit(false);
			Demo8_AccountDao dao = new Demo8_AccountDao();
			dao.updateBalance(conn,from, -money);	//��from��ȥ��Ӧ���
			
//			if(true){
//				throw new RuntimeException("������˼");
//			}
			
			dao.updateBalance(conn,to, money);		//��to������Ӧ���
			//�ύ����
			conn.commit();
		} catch (Exception e) {
			//�ع�����
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
