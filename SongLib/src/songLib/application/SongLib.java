//Authors:
//Karthik Nair
//Siddharth Murali



package songLib.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import songLib.model.*;
import songLib.view.SongEditDialogController;
import songLib.view.SongListViewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SongLib extends Application {

	private static Stage primaryStage;
	private BorderPane rootLayout;

	private static ObservableList<Song> songData = FXCollections.observableArrayList();

	public SongLib(){
		try {
			
			File file = new File("SongList.txt");

			if(file != null){
				BufferedReader in = new BufferedReader(new FileReader(file));
				String str;
				str = in.readLine();
				while (str != null) {
					String[] ar=str.split(",");
					songData.add(new Song(ar[0], ar[1], ar[2], Integer.parseInt(ar[3])));
					str = in.readLine();
				}
					in.close();	
			}

		} catch (IOException e) {
			//System.out.println("File Read Error");
		}
	}

	public void updateFile(ObservableList<Song> songData){

		try {

			String content = "";
			Song tmp = null;

			File file = new File("SongList.txt");


			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i<songData.size(); i++){
				tmp = songData.get(i);
				content = tmp.getSongName() + "," + tmp.getArtistName() + "," + tmp.getAlbumName() + "," + tmp.getSongYear() + "\n";
				bw.write(content);
				content = "";
			}
			bw.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ObservableList<Song> getSongData(){
		return songData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Song Library");

		initRootLayout();
		showSongListView();
	}

	public void initRootLayout(){
		try{
			//Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SongLib.class.getResource("/songLib/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			//Set Up Scene
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();


		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showSongListView(){
		try{
			//Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SongLib.class.getResource("/songLib/view/SongListView.fxml"));
			AnchorPane songListView = (AnchorPane) loader.load();


			//Set Up Scene
			rootLayout.setCenter(songListView);

			SongListViewController controller = loader.getController();
			controller.setSongLib(this);


		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public static boolean showSongEditDialog(Song song) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SongLib.class.getResource("/SongLib/view/SongEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Song");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SongEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSong(song);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}



	public static Stage getPrimaryStage(){
		return primaryStage;
	}

	public static void main(String[] args){
		launch(args);
	}

}
