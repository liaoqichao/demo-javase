package demo.myInterface;

public class Cantonese extends Person implements SingerComposer, FitnessPerson {

	
	public Cantonese(String name, int weight) {
		super(name, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sing(Song s) {						//ʵ�ִ����͸��ֽ�ɫ�ĸ����ɫ���ֵĹ���
		// TODO Auto-generated method stub
		System.out.println(getName()+"�ڳ� "+s.getSongName()+" : "+s.getLyric());
	}

	@Override
	public Song writeSong(Song s, String melody, String lyric) {	//ʵ�ִ����¸��ֽ�ɫ�Ĺ���
		// TODO Auto-generated method stub
		s.writeSong(melody, lyric);
		return s;
	}
	public void hello(){
		System.out.println("Hello,I am "+getName()+". I am Cantonese.");
	}

	@Override
	public void keepfit() {
		// TODO Auto-generated method stub
		System.out.println("������");
		
	}

}
