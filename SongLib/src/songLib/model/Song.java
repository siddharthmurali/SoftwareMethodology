//Authors:
//Karthik Nair
//Siddharth Murali

package songLib.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
//import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


public class Song {
	
	private final StringProperty songName;
	private final StringProperty artistName;
	private final StringProperty albumName;
	private final IntegerProperty songYear;
	
	public Song(){
		this(null, null);
	}
	
	public Song(String songName, String artistName){
		this.songName = new SimpleStringProperty(songName);
		this.artistName = new SimpleStringProperty(artistName);
		
		this.albumName = new SimpleStringProperty("N/A");
		this.songYear = new SimpleIntegerProperty(0);
		
	}
	
	public Song(String songName, String artistName, String albumName){
		this.songName = new SimpleStringProperty(songName);
		this.artistName = new SimpleStringProperty(artistName);
		
		this.albumName = new SimpleStringProperty(albumName);
		this.songYear = new SimpleIntegerProperty(0);
		
	}

	public Song(String songName, String artistName, String albumName, int songYear){
		this.songName = new SimpleStringProperty(songName);
		this.artistName = new SimpleStringProperty(artistName);
		
		this.albumName = new SimpleStringProperty(albumName);
		this.songYear = new SimpleIntegerProperty(songYear);
		
	}
	
	public String getSongName() {
		return songName.get();
	}
	
	public StringProperty songNameProperty() {
		return songName;
	}
	
	public void setSongName(String songName){
		this.songName.set(songName);
	}

	public String getArtistName() {
		return artistName.get();
	}
	
	public StringProperty artistNameProperty() {
		return artistName;
	}
	
	public void setArtistName(String artistName){
		this.artistName.set(artistName);
	}

	public String getAlbumName() {
		return albumName.get();
	}
	
	public StringProperty albumNameProperty() {
		return albumName;
	}
	
	public void setAlbumName(String albumName){
		this.albumName.set(albumName);
	}

	public int getSongYear() {
		return songYear.get();
	}
	
	public IntegerProperty songYearProperty() {
		return songYear;
	}
	
	public void setSongYear(int songYear){
		this.songYear.set(songYear);
	}

}
