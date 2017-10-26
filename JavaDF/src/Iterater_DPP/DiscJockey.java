package Iterater_DPP;

import java.util.Iterator;

public class DiscJockey {
	SongsOfThe70s songs70s;
	SongsOfThe80s songs80s;
	SongsOfThe90s songs90s;
	
	SongIterator iter70sSongs;
	SongIterator iter80sSongs;
	SongIterator iter90sSongs;
	
	public DiscJockey(SongIterator songs70s, SongIterator songs80s, SongIterator songs90s) {
		this.iter70sSongs = songs70s;
		this.iter80sSongs = songs80s;
		this.iter90sSongs = songs90s;
	}
	
//	public void showTheSongs(){
//		ArrayList al70sSongs = songs70s.getBestSongs();
//		System.out.println("Songs of the 70s\n");
//		for (int i = 0; i < al70sSongs.size(); i++) {
//			SongInfo bestSongs = (SongInfo) al70sSongs.get(i);
//			System.out.println(bestSongs.getSongName());
//			System.out.println(bestSongs.getBandName());
//			System.out.println(bestSongs.getYearReleased());
//		}
//		
//		SongInfo[] array80sSongs = songs80s.getBestSongs();
//		System.out.println("Songs of the 80s/n");
//		for (int i = 0; i < array80sSongs.length; i++) {
//			SongInfo bestSongs = array80sSongs[i];
//			System.out.println(bestSongs.getSongName());
//			System.out.println(bestSongs.getBandName());
//			System.out.println(bestSongs.getYearReleased());
//		}
//		
//		Hashtable<Integer, SongInfo> ht90sSongs = songs90s.getBestSongs();
//		System.out.println("Songs of the 90s/n");
//		for (Enumeration<Integer> e = ht90sSongs.keys(); e.hasMoreElements();) {
//			SongInfo bestSongs = ht90sSongs.get(e.nextElement());
//			System.out.println(bestSongs.getSongName());
//			System.out.println(bestSongs.getBandName());
//			System.out.println(bestSongs.getYearReleased());
//		}
//	}
	
	public void showTheSongs2(){
		Iterator songs70 = iter70sSongs.createIterator();
		Iterator songs80 = iter80sSongs.createIterator();
		Iterator songs90 = iter90sSongs.createIterator();
		
		System.out.println("Songs of the 70s/n");
		printTheSongs(songs70);
		
		System.out.println("Songs of the 80s/n");
		printTheSongs(songs80);
		
		System.out.println("Songs of the 90s/n");
		printTheSongs(songs90);
	}

	public void printTheSongs(Iterator iterator) {
		while(iterator.hasNext()){
			SongInfo songIngo = (SongInfo) iterator.next();
			System.out.println(songIngo.getSongName());
			System.out.println(songIngo.getBandName());
			System.out.println(songIngo.getYearReleased());
		}
		
	}
	
	
}
