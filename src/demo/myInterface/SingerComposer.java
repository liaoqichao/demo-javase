package demo.myInterface;

import demo.myInterface.Song;

public interface SingerComposer extends Singer {		//�ӿڼ̳нӿ�,����ӿ�,���:�����͸���
	
	//void sing(Song s);								//���һ����ͬʱʵ�ֲ�ͬ�ӿ���ͬ��������������
	Song writeSong(Song s,String melody,String lyric);

}
