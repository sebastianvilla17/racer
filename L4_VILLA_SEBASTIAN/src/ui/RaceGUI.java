package ui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import thread.RaceThread;

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

	@FXML
	private Label timeKeeper;

	private Race main;

	private RaceThread AL;
	private RaceThread LL;
	private RaceThread ABB;

	public RaceGUI(Race race) {

		main = race;
	}

	@FXML
	public void runRace(ActionEvent event) {
		
		
		
		String timeAl = "-1";
		String timeLL = "-1";
		String timeABB = "-1";

		long timeS= System.currentTimeMillis();
		String algorithm = ((RadioButton)Algorithm.getSelectedToggle()).getText();
		String mode = ((RadioButton)Mode.getSelectedToggle()).getText();
		long number= Long.parseLong(txtNumber.getText());
		long seed= System.currentTimeMillis();
		
		AL= new RaceThread(main, "AL",algorithm , mode,  number,  seed);
		LL= new RaceThread(main, "LL",algorithm , mode,  number,  seed);
		ABB= new RaceThread(main, "ABB",algorithm , mode,  number,  seed);
		
		
	
		AL.start();		
		LL.start();
		ABB.start();
		
		int contador = 0;
		while(timeAl.equals("-1") || timeLL.equals("-1") || timeABB.equals("-1") )
		{
			System.out.println("***************************");
			System.out.println("Valida");
			try {			
				TimeUnit.SECONDS.sleep(1);
				timeAl = AL.getTime();
				timeLL = LL.getTime();
				timeABB = ABB.getTime();
				
				System.out.println(timeAl);
				System.out.println(timeLL);
				System.out.println(timeABB);
				
				long timeF= System.currentTimeMillis() - timeS;
				SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
				Date resultdate = new Date(timeF);
				String timeFinal = sdf.format(resultdate);
				timeKeeper.setText(timeFinal);
				System.out.println("->"+timeKeeper.getText());
				
				
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("Ocurrio Exception");
				break;
			}
		}
			
		long timeE= System.currentTimeMillis();
		
		long timeF= timeE- timeS;
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
		Date resultdate = new Date(timeF);
		String timeFinal = sdf.format(resultdate);
		
		
		laTimeAl.setText(timeAl);
		laTimeLL.setText(timeLL);
		laTimeABB.setText(timeABB);
		timeKeeper.setText(timeFinal);
		
	}

	public void loadSettinWindow(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("settingWindow.fxml"));
		fxmlLoader.setController(this);
		Parent setting = fxmlLoader.load();

		mainPanel.getChildren().clear();
		mainPanel.setCenter(setting);

	}

}
