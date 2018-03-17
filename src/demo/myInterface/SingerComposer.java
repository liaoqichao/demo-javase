package demo.myInterface;

import demo.myInterface.Song;

public interface SingerComposer extends Singer {		//接口继承接口,子类接口,身份:创作型歌手
	
	//void sing(Song s);								//如果一个类同时实现不同接口中同名方法会怎样？
	Song writeSong(Song s,String melody,String lyric);

}
