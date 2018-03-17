package demo.myInterface;

public class Cantonese extends Person implements SingerComposer, FitnessPerson {

	
	public Cantonese(String name, int weight) {
		super(name, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sing(Song s) {						//实现创作型歌手角色的父类角色歌手的功能
		// TODO Auto-generated method stub
		System.out.println(getName()+"在唱 "+s.getSongName()+" : "+s.getLyric());
	}

	@Override
	public Song writeSong(Song s, String melody, String lyric) {	//实现创作新歌手角色的功能
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
		System.out.println("健身中");
		
	}

}
