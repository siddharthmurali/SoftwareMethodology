//Authors:
//Karthik Nair
//Siddharth Murali

package songLib.view;

import songLib.application.SongLib;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import songLib.application.SongLib;
import songLib.model.Song;

public class SongListViewController {
	@FXML
	private TableView<Song> songTable;
	@FXML
	private TableColumn<Song, String> songNameColumn;
	
	@FXML private Label songNameLabel;
	@FXML private Label artistNameLabel;
	@FXML private Label albumNameLabel;
	@FXML private Label yearLabel;
	@FXML private Label addError;
	
	@FXML private Button addSong;
	@FXML private Button deleteSong;
	@FXML private Button editSong;
	
	
	
	private SongLib songLib;
	
	public SongListViewController(){
		
	}
	
	@FXML
	private void initialize(){
		songNameColumn.setCellValueFactory(songData -> songData.getValue().songNameProperty());
		
		showSongDetails(null);
		songTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue, newValue) -> showSongDetails(newValue));
		
	}
	
	public void setSongLib(SongLib songLib){
		this.songLib = songLib;
		songTable.setItems(songLib.getSongData());
	}
	
	private void showSongDetails(Song song){
		if(song != null){
			songNameLabel.setText(song.getSongName());
			artistNameLabel.setText(song.getArtistName());
			albumNameLabel.setText(song.getAlbumName());
			yearLabel.setText(Integer.toString(song.getSongYear()));
				
		}else{
			songNameLabel.setText("");
			artistNameLabel.setText("");
			albumNameLabel.setText("");
			yearLabel.setText("");
		}
	}
	
	class SortSongByname implements Comparator<Song>
	{
	    @Override
	    public int compare(Song song1, Song song2) 
	    {
	        int value = song1.getSongName().compareTo(song2.getSongName());
	        return value;
	            
	     }
	}
	

	@FXML
	private void handleDeleteSong() {
	    int selectedIndex = songTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        songTable.getItems().remove(selectedIndex);
	        FXCollections.sort(SongLib.getSongData(), new SortSongByname());
	        songLib.updateFile(SongLib.getSongData());
	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(SongLib.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Song Selected");
	        alert.setContentText("Please make sure you have selected a song!");

	        alert.showAndWait();
	    }
	}
	
	@FXML
	private void handleAddSong() {
	    Song tempSong = new Song();
	    boolean okClicked = SongLib.showSongEditDialog(tempSong);
	 	    
	    if (okClicked) {
	 
	    	ObservableList<Song> y = SongLib.getSongData();
	    
		    for(int x=0; x<y.size();  x++){
		    	
		    	//System.out.println(y.get(x));
		    	
		    	if(y.get(x).getSongName().trim().equals(tempSong.getSongName().trim()) && y.get(x).getArtistName().trim().equals(tempSong.getArtistName().trim())){
		    		Alert alert = new Alert(AlertType.WARNING);
			        alert.initOwner(SongLib.getPrimaryStage());
			        alert.setTitle("Duplicate");
			        alert.setHeaderText("Duplicate Entry");
			        alert.setContentText("This song already exists in the library!");
			        
			        alert.showAndWait();
			        return;
		    	}
		    }
		    
		    int tempSongPlace = 0;
		    SongLib.getSongData().add(tempSong);
		    FXCollections.sort(SongLib.getSongData(), new SortSongByname());
		    songLib.updateFile(SongLib.getSongData());
		    
		    for(int i=0; i< SongLib.getSongData().size(); i++){
		    	if(SongLib.getSongData().get(i).getSongName().equals(tempSong.getSongName())){
		    		tempSongPlace = i;
		    	}
		    }
		    songTable.getSelectionModel().select(tempSongPlace);
	    }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditSong() {
	    Song selectedSong = songTable.getSelectionModel().getSelectedItem();
	    if (selectedSong != null) {
	        boolean okClicked = SongLib.showSongEditDialog(selectedSong);
	        if (okClicked) {
	            showSongDetails(selectedSong);
	            FXCollections.sort(SongLib.getSongData(), new SortSongByname());
	            songLib.updateFile(SongLib.getSongData());
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(SongLib.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Song Selected");
	        alert.setContentText("Make sure you select a song!");

	        alert.showAndWait();
	    }
	}
	
	

}
