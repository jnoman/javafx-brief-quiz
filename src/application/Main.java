package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;

import javafx.application.Application;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Group;


public class Main extends Application {
	
	static Players player1;
	static Timer t;
	String chemin;
	static Player player;
	static int cpt=0;
	static Group panel;
	static Label lapelTime;
	static Button btn_valider;
	static Label lapel_score;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ArrayList<Quiz> listeQuiz = new ArrayList<Quiz>();
			ArrayList<Player_QUIZ> listePlayer_QUIZ = new ArrayList<Player_QUIZ>();
			panel = new Group();
			Scene scene = new Scene(panel,800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Quiz");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public static void StopMusic()  throws JavaLayerException
	{
		if (player!=null){
		    player.close();
		    player = null;
		}
	}
	
	public static void playerMusic(String chemin,int frames)
	{
		try {
			FileInputStream fileInputStrem = new FileInputStream(chemin);
			player = new Player(fileInputStrem);
			player.play(frames);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(JavaLayerException e){
			e.printStackTrace();
		}
	}
}
