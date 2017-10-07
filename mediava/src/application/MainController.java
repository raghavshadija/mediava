package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

public class MainController implements Initializable{
	private String filepath;
	@FXML
	private MediaPlayer mediaplayer;
	@FXML
	private MediaView mediaView;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		}
		@FXML
		public void handleButtonAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		FileChooser.ExtensionFilter extensionfilter = new FileChooser.ExtensionFilter("Mp4 files only","*.mp4");
		filechooser.getExtensionFilters().add(extensionfilter);
		
		File file = filechooser.showOpenDialog(null);
		filepath =file.toURI().toString();
		if(filepath!=null)
		{
		Media media = new Media(filepath);	
		mediaplayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaplayer);
		DoubleProperty width=mediaView.fitWidthProperty();
		DoubleProperty height= mediaView.fitHeightProperty();
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));		
		mediaplayer.play();
		} 
		
		}
		@FXML public void playbutton(ActionEvent event) {mediaplayer.play(); mediaplayer.setRate(1);}
		@FXML public void pausebutton(ActionEvent event) {mediaplayer.pause();}
		@FXML public void stopbutton(ActionEvent event) {mediaplayer.stop();} 	
		@FXML public void forwardbutton(ActionEvent event) {}
		@FXML public void rewindbutton(ActionEvent event) {}
		@FXML public void fasterbutton(ActionEvent event) {mediaplayer.setRate(2);}
		@FXML public void slowerbutton(ActionEvent event) {mediaplayer.setRate(0.5);}
		@FXML public void exitbutton(ActionEvent event) {System.exit(0);}
	
	}

