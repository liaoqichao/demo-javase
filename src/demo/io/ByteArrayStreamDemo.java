package demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo implements IO {

	/**
	 * ByteArrayInputStream	ByteArrayOutputStream
	 * ��������Դ��Ŀ�Ķ����ڴ����
	 * byte���鳤�ȿɱ�
	 * ����ʹ��toByteArray,toString ��ȡ����
	 * �ر�ByteArrayOutpuStream/InputStream��Ч.�رպ󻹿��Լ���ʹ��.��Ϊֻ���ڴ��������û�е��õײ���Դ(��Ӳ�̵���Դ),����IO�쳣
	 * 
	 * ByteArrayInputStream(byte[],int off,int len);����2����������ʡ��.��ΪԴ���ڴ�,���Բ��������鲻��������,�ļ�,·��
	 * 
	 * CharArrayReader		CharArrayWriter��StringReader		StringWriter
	 * ��ByteArrayInputStream	ByteArrayOutputStreamһ��,���Ǵ洢���������Ͳ�һ��
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
	public void demo1() throws IOException{
		byte[] buf = "abcdef".getBytes();
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int ch = 0;
		while((ch = bis.read())!=-1){
			bos.write(ch);
		}
		System.out.println(bos.toString());//abcdef
		
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteArrayStream\\demo1.txt");
		bos.writeTo(fos);
		fos.close();
		//�ر���Դ��Ч
		
		
	}

}
