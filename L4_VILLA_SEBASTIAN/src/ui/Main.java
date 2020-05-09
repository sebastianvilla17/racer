package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Race;

public class Main extends Application {

	private RaceGUI raceGUI;
	private static Race race;

	public Main() {

		race= new Race();
		raceGUI = new RaceGUI(race);

	}

	public static void main(String[] args) {

		launch(args);
		
		}

	

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

		loader.setController(raceGUI);
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Tech Suvery");
		raceGUI.loadSettinWindow(null);
		stage.show();

	}

}
