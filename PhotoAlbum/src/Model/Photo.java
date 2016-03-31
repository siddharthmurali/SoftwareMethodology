package Model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Photo {

	private final StringProperty photoDate;
	private final StringProperty photoName;
	private final StringProperty photoTag;
	
	
	public Photo(){
		this(null);
	}

	public Photo(String photoDate){
		this.photoDate = new SimpleStringProperty(photoDate);
		
		this.photoName = new SimpleStringProperty("N/A");
		this.photoTag = new SimpleStringProperty("N/A");
	}

	public Photo(String photoDate, String photoName){
		this.photoDate = new SimpleStringProperty(photoDate);
		this.photoName = new SimpleStringProperty(photoName);
		
		this.photoTag = new SimpleStringProperty("N/A");
	}
	
	
	public Photo(String photoDate, String photoName, String photoTag){
		this.photoDate = new SimpleStringProperty(photoDate);
		this.photoName = new SimpleStringProperty(photoName);
		this.photoTag = new SimpleStringProperty(photoTag);
	}
	
	
}
