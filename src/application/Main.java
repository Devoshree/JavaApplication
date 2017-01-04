package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {//launches the application
	Player player;
	FileChooser fileChooser;
	public void start(final Stage primaryStage) {// setting up the stages
		
		MenuItem open=new MenuItem("Open");
		Menu file=new Menu("File");
		MenuBar menu=new MenuBar();
		//Connecting the above three
		file.getItems().add(open);// it would connect open with file
		menu.getMenus().add(file);
		//Adding functionality to switch to different videos
		fileChooser=new FileChooser();		
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				player.player.pause();//Pausing the video while switching 
			File file=fileChooser.showOpenDialog(primaryStage);//Choosing the file to play
			if(file!=null){
				try {
					player=new Player(file.toURI().toURL().toExternalForm());
					Scene scene= new Scene(player,720,535,Color.BLACK);
					primaryStage.setScene(scene);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
			
		});
	    player=new Player("file:///F:/songs/srk.mp4");//player class taking the 
	                                                  //string argument
		player.setTop(menu);//Setting the menu at the top
		Scene scene= new Scene(player,720,535,Color.BLACK);//Adding player to the Scene
		                                                   //height and width of the video player
		                                                   //background color set to Black
		primaryStage.setScene(scene);//Setting the scene to stage
		primaryStage.show();         //Showing the stage
	}
	public static void main(String[] args){//Main function to launch the application
		launch(args);
	}
}
