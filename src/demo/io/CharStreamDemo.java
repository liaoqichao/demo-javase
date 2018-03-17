package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CharStreamDemo implements IO {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * 
	 */
	@Override
	public void demo() throws Exception {			
		// TODO Auto-generated method stub
		/*
		 * ����(��)��Ӳ�̡���ӡ��->�ڴ�
		 * ���(д)���ڴ�->Ӳ�̡���ӡ��
		 * �ֽ������ܴ����ֽڵ����������ֽ�Ϊ��λ�Ķ����ƴ��䡣�ܴ����������ݡ��ֽ�������ԪΪ1���ֽڣ� �����ֽں��ֽ�����
		 * �ַ������ַ�������ĵ�ԪΪ2���ֽڵ�Unicode�ַ����ֱ�����ַ����ַ�������ַ������򵥵�˵���ֽ���+�����
		 * 
		 * �ֽ����ĳ������(���㸸��)��InputStream��OutputStream
		 * �ַ����ĳ������(���㸸��)��Reader(������)��Writer(�����).���������������,���ȿ����ַ���
		 * 
		 */
		//demo1_CharStream();
		//demo2_CharStream();
		//demo3_CharStream();		//���ַ�Ϊ��λһ�ζ�ȡ����ַ�(�ַ�����)
		//demo4_CharStream();		//���ַ�Ϊ��λһ�ζ�ȡһ���ַ�
		//���ֽ�Ϊ��λһ�ζ�ȡһ���ֽ�
		//���ֽ�Ϊ��λһ�ζ�ȡ����ֽ�
		//demo5_CharStream();		//�ļ�����,���Ƕ�д����
		//demo6_CharStream();		//BufferedWriter
		//demo7_CharStream();		//BufferedReader
		//demo8_CharStream();		//�������ļ�����
		//demo9_CharStream();		//�ַ���������,װ�����ģʽ	
	}


	public void demo1_CharStream()  {			//����̨���������
		// TODO Auto-generated method stub
		int  a ,total ,counta = 0 ,countb = 0;
		Scanner in =new Scanner(System.in);
		System.out.println("������ѧ�������� ");
		total =in.nextInt();
		for(int i=0;i<total;i++){
			System.out.println("�������"+(i+1)+"��ѧ���ĳɼ�");
			if(in.hasNextInt()){	//
				a = in.nextInt();	//Ҫ��hasNextInt()���棬��Ȼ ��һ���ɼ�Ҫ�������������Żᵽ����ڶ���ѧ���ĳɼ�
				if(a>=60 && a<=100)
					counta++;
				else if(a>=0 && a<60)
					countb++;
				else{
					System.out.println("�������"); break;}
			}	
		}
		System.out.println("��������"+counta+"��");
		System.out.println("����������"+countb+"��");
		in.close();
		
	}
	public void demo2_CharStream()  {			//д��Ļ��к���д��IO�쳣����
	
		//Ӳ�̵����ݵĻ����������ļ����ļ������FileWriter��java.lang.io->Writer->OutputStreamWriter->FileWriter
		FileWriter writer = null;
		try {
			 writer = new FileWriter("E:\\Eclipse\\IO\\CharStream\\CharStream\\demo2.txt",true);
			//û���򴴽�/��Input.txt������������						//  Windows��"/r/n"����
			writer.write("��д"+System.getProperty("line.separator"));
			for(int i = 0 ; i<3;i++){
				writer.write("abcdef׼������"+System.getProperty("line.separator")+"�������"+System.getProperty("line.separator"));
				writer.flush();
			}
		} catch (IOException e) {
			System.out.println("д������쳣");
		}finally{
			if(writer != null)				//��Ȼ���п�ָ���쳣
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("���ر��쳣");
				}
		}

		/*
		 * ����write(String str)����ʱ��ʵ��д�뵽��ʱ�洢�������С�
		 * flush();����ˢ��ֱ�ӽ�����д�뵽Ŀ�ĵ��У��൱��txt����ı��档û��flush��close�Ļ����൱��д��֮��û�б���
		 * close()�൱�ڹرռ��±���ʱ����ʾ�Ƿ�Ҫ����,Ȼ��ѡ�񱣴档�رռ��±���Ͳ����ټ��±�д
		 */
		
	}
	public void demo3_CharStream() throws IOException	{			//���ַ�Ϊ��λһ�ζ�ȡ����ַ�
		
		//java.lang.io->Reader->InputStreamReader->FileReader
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo3.txt");//�ļ�Ҫ�Ѵ��ڣ���Ȼ���׳��ļ��Ҳ����쳣
		char[] buf = new char[7];//���鳤��Ҫ1024��������
		int len = 0;
		while((len=fr.read(buf))!=-1){
			System.out.print(new String(buf,0,len));//��Ҫprintln,�����з�
		}
		fr.close();
	}
	public void demo4_CharStream() throws IOException {				//���ַ�Ϊ��λһ�ζ�ȡһ���ַ�
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo4.txt");
		char c;							//��ʱ�ַ�
		int len = 0;					//��ȡ�ַ���Ӧ��ASCII��,���������ж��ļ�ʱ�����
		while((len = fr.read())!= -1 ){
			c = (char)len;
			System.out.print(c);
		}
		fr.close();
		
	}
	public void demo5_CharStream() throws IOException{
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo5_Read.txt");//���ֱ�д�� .[�ļ�������������]
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\CharStream\\demo5_Write.txt");//[�ļ�����������������ʱ��2����û�й�ϵ]
		//һ�ζ�ȡ����ַ�
		
		char[] buf = new char[1024];//[��ϵ2��������תվ(����������תվ��û����)]
		//����һ��������¼��ȡ�����ַ���,(��ʵ��������������װ���ַ�����)
		int len = 0;
		while((len=fr.read(buf))!=-1){		//read(char [])���ض�ȡ�����ַ�����������귵��-1��[fr������תվ������ϵ]
			fw.write(new String(buf,0,len));//[fw������תվ������ϵ]
		}
		//һ�ζ�ȡһ���ַ�
		/*
		int len = 0;
		while((len=fr.read())!=-1){
			char c = (char)len;	//[char c �� int len ��ϵ2��������תվ]
			fw.write(c);
		}
		*/
		fr.close();
		fw.close();
		//�������ɾ��ԭ�ļ���Ϊ����,ճ��
		//File file = new File("E:\\Eclipse\\IO\\CharStream\\demo5_CharStreamRead.txt");
		//file.delete();
	}
	public void demo6_CharStream() throws IOException{				//BufferedWriter
		/*
		 * //�ַ����Ļ�����,����ǰ���char[] buf��int len;	
		 * BufferedReader��BufferedWriter   Buffered ��ס��ed ���ã����Ч��
		 * ������Ҫ������ſ���ʹ��
		 * ������ʵ�����ӣ����е����Ƴ� . ��N����Ʒ,��1��ȥ����1�Ρ���N����Ʒ,��ʱ�������Ƴ�,һ����ȥ����.
		 * �������Ż�ʵ�����ӣ����Ƴ��Ŀ�����ó���,����1��1���ó�������(��������Ա��rfid���ȴ����Ƴ��ö���������)��
		 * �Ż�������Ż����ع�����,�ô��������չ�Ժ͸�����,ͨ���������ģʽ����ɴ���Ĺ������������Ż�������ֶ�֮һ����������
		 * 
		 * û�б����������û�л�������
		 */
		
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\CharStream\\demo6.txt");
		//Ϊ�����Ч��,ʹ��BufferedWriter
		//����������,���ͱ������fw�������
		BufferedWriter bw = new BufferedWriter(fw);//�����ֻ�û������Ķ���
		//ʹ�û�������д�뷽��
		bw.write("abcdef"+LINE_SEPARATOR+"GGGG");
		bw.newLine();
		bw.flush();
		
		bw.write("abcdef");
		bw.newLine();//����System.getPorperty("line.separator");
		bw.write("GGGGGG");
		//ʹ�û�������flush����,������д�뵽fw��
		//bw.flush();
		//�رջ�����,��ʵ�ǵ���fw.close()����Ϊbwֻ�����Ч������,��д������fw����
		bw.close();
	}
	public void demo7_CharStream() throws IOException{				//BufferedReader
		
		//read(),read(ch[],int off,int len)��д��,read(ch[])û����д,���Ƕ��ǿն�����-1
		//read()��read(ch[],int off,int len)�Ǵӻ�����(�ڴ�)�����Ǵ�ԭ�ļ�(Ӳ��)��
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo7.txt");
		BufferedReader br = new BufferedReader(fr);
		//һ�ζ�һ��
		
		String str = null;
		while((str = br.readLine())!=null){
			System.out.println(str);//readLine()ֻ�жϻس�,�����س�,��������Ҫprintln
		}
	
		//һ�ζ�ȫ��
		/*
		char[] cbuf = new char[1024];
		int len = 0;
		while((len = br.read(cbuf, 0, cbuf.length))!=-1){
		//��Ϊbr.read(cbuf)�������û����д,������ԭ�ļ������ݲ��ǻ�����������,������������������������������Ч��
			System.out.print(new String(cbuf,0,len));
		}
		*/
		br.close();
		
	}
	public void demo8_CharStream() throws IOException{				//�������ļ�����
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo8_Read.txt");
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\CharStream\\demo8_Write.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String sbuf = null;
		while((sbuf = br.readLine())!=null){	//��readLine()�Ļ�,д��һ��һ��ҪnewLine()����
			bw.write(sbuf);
			bw.newLine();
			bw.flush();
		}
		//�����ַ������
		/*
		char[] cbuf = new char[1024];
		int len = 0;
		while((len = br.read(cbuf, 0, cbuf.length))!=-1){
			bw.write(new String(cbuf,0,len));
			bw.flush();
		}*/
		//����len, while(br.read(cbuf,0,cbuf.length)!=-1){bw.write(cbuf);bw.flush();}Ҳ����,Ϊʲô Ҫ��len?
		br.close();
		bw.close();
	}
	public void demo9_CharStream()	{			//װ�����ģʽ
		
		/*
		 * װ�����ģʽ����һ�����Ĺ��ܽ�����ǿʱ,�Ϳ���ʹ��װ�����ģʽ�������
		 * BufferedReader��BufferWriterʹ����װ�����ģʽ
		 * װ��ģʽ�ͼ̳ж���ʵ�ֹ�����չ����ǿ.
		 * 			Writer
		 * 				|-TextWriter
		 * 					|-BufferedTextWriter
		 * 				|- MediaWriter
		 * 					|-BufferedMediaWriter
		 * ���ֻΪ����ǿһ�㹦�ܾͽ��м̳�,���¼�����ϵӷ��
		 * �����������һ���̳�,�����Buffer������װ��һ����,��Ҫ����Writer�ͺ�����Writer����
		 * class BufferedWriter extends Writer{//��ЧдҲ��д,���Լ̳�д
		 * 		BufferedWriter(Writer w){} Writer���������඼����Ϊ����
		 * }
		 * ��ϵ������������þ��ã������þͲ���,���ò�����ϵ(һ��������ϵ���������ϵ)
		 * 			Writer
		 * 				|-TextWriter
		 * 				|- MediaWriter
		 * 				|-BufferedWriter
		 * �ص㣺װ����ͱ�װ���඼������ͬһ���ӿڻ��߸���,װ����ͱ�װ����ͨ��������ͬһ��ϵ��
		 * 
		 * �ӿڣ�һ����,���Ƿ�����ȷ��,��ʵ��������֪����ʲô�����������.����һ����������,Ҫʵ���������,����ʵ������ӿ�,���Լ��ķ�����������¡�
		 * 		�ܵ���˵,������µķ�����ȷ��,��ʵ��������ӿھ���ζ������������������(���϶���)
		 * 		�ӿ���һ�ֽ�ɫ��������ѧ����Ҳ�Ǹ�ĸ�ĺ��ӡ�����ʵ��ѧ�������ӽӿڡ�����������̳�ѧ��������
		 * 		Writer��
		 * �̳У����಻����ȡ��ͬ�㡣��������ת��,��������
		 * 		д�ı�,дý��,�ڻ�����д����ͬ�㶼��д,���Լ̳���д
		 * װ�����ģʽ�����ܵ���ǿ�����ʲ���
		 * 
		 */
		Person p = new Person("����",15);
		p.chifan();//�Է�
		NewPerson np = new NewPerson(p);//��۸ı���np����,ʵ��û��(����p����ķ���,Ȼ���һЩ����)
		np.chifan();//��θ��,�Է�,���
		
	}
}
