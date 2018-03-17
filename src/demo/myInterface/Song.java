package demo.myInterface;

public class Song {
	private String songName;
	private String melody;
	private String lyric;
	Song(String songName){
		this.songName = songName;
	}
	public void writeSong(String melody,String lyric){
		this.melody = melody;
		this.lyric = lyric;
	}
	public String getSongName(){
		return songName;
	}
	public String getMelody(){
		return melody;
	}
	public String getLyric(){
		return lyric;
	}
}