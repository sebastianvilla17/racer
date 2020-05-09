package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import model.Race;

public class RaceGUI {

	@FXML
	private BorderPane mainPanel;

	@FXML
	private TextField txtNumber;

	@FXML
	private RadioButton rbAdd;

	@FXML
	private ToggleGroup Algorithm;

	@FXML
	private RadioButton rbSearch;

	@FXML
	private RadioButton rbDelete;

	@FXML
	private RadioButton rbREC;

	@FXML
	private ToggleGroup Mode;

	@FXML
	private RadioButton rbITR;

	@FXML
	private Label laTime;

	@FXML
	private Label laTimeAl;

	@FXML
	private Label laTimeLL;

	@FXML
	private Label laTimeABB;

	@FXML
	private Circle circle1;

	@FXML
	private Circle circle2;

	private Race main;

	public RaceGUI(Race race) {

		main = race;
	}

	@FXML
	public void runRace(ActionEvent event) {

	}

	public void loadSettinWindow(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("settingWindow.fxml"));
		fxmlLoader.setController(this);
		Parent setting = fxmlLoader.load();

		mainPanel.getChildren().clear();
		mainPanel.setCenter(setting);

	}

}
