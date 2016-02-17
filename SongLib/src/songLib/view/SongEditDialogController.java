//Authors:
//Karthik Nair
//Siddharth Murali


package songLib.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import songLib.model.Song;
import songLib.application.*;


public class SongEditDialogController {
	
	@FXML
    private TextField songNameField;
    @FXML
    private TextField artistNameField;
    @FXML
    private TextField albumField;
    @FXML
    private TextField yearField;


    private Stage dialogStage;
    private Song song;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setSong(Song song) {
        this.song = song;

        songNameField.setText(song.getSongName());
        artistNameField.setText(song.getArtistName());
        albumField.setText(song.getAlbumName());
        yearField.setText(Integer.toString(song.getSongYear()));
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            song.setSongName(songNameField.getText());
            song.setArtistName(artistNameField.getText());
            song.setAlbumName(albumField.getText());
            song.setSongYear(Integer.parseInt(yearField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (songNameField.getText() == null || songNameField.getText().length() == 0) {
            errorMessage += "No valid song name!\n"; 
        }
        if (artistNameField.getText() == null || artistNameField.getText().length() == 0) {
            errorMessage += "No valid artist name!\n"; 
        }
        if (albumField.getText() == null || albumField.getText().length() == 0) {
            errorMessage += "No valid album name!\n"; 
        }

        if (yearField.getText() == null || yearField.getText().length() == 0) {
            errorMessage += "No valid song year!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(yearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid song year (must be an integer)!\n"; 
            }
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
	


