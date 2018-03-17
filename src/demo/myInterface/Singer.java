package demo.myInterface;

import demo.myInterface.Song;

public interface Singer {			//父类接口,身份：歌手
	void sing(Song s);
	//void train();					//接口的所有方法,实现的类都要把他实现

}
