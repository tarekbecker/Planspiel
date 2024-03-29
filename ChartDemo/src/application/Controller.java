package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

	@FXML
	private PieChart					pieChart;

	@FXML
	private LineChart<String, Number>	lineChart;

	@FXML
	private CategoryAxis				xAxisLine;

	@FXML
	private NumberAxis					yAxisLine;

	@FXML
	private StackedBarChart<String, Double>				barChart;

	@FXML
	private CategoryAxis				xAxisBar;
	@FXML
	private NumberAxis					yAxisBar;
	
	private Stage dialogStage;
	private Stage primaryStage;

	public void initSBC() {
		final Integer r1 = 1;
		final Integer r2 = 2;
		final Integer r3 = 2;
		final Integer r4 = 4;
		final Integer r5 = 5;
		final XYChart.Series<Integer, Number> series1 = new XYChart.Series<Integer, Number>();
		final XYChart.Series<Integer, Number> series2 = new XYChart.Series<Integer, Number>();
		final XYChart.Series<Integer, Number> series3 = new XYChart.Series<Integer, Number>();
		/*barChart.setTitle("Gewinn nach Qualit�t");
		xAxisBar.setLabel("");
		xAxisBar.setCategories(FXCollections.observableArrayList(Arrays.asList(r1+"", r2+"", r3+"", r4+"",
				r5+"")));
		yAxisBar.setLabel("Value");
		series1.setName("Q1");
		series1.getData().add(new XYChart.Data<Integer, Number>(r1, 25601.34));
		series1.getData().add(new XYChart.Data<Integer, Number>(r2, 20148.82));
		series1.getData().add(new XYChart.Data<Integer, Number>(r3, 10000));
		series1.getData().add(new XYChart.Data<Integer, Number>(r4, 35407.15));
		series1.getData().add(new XYChart.Data<Integer, Number>(r5, 12000));
		series2.setName("Q4");
		series2.getData().add(new XYChart.Data<Integer, Number>(r1, 57401.85));
		series2.getData().add(new XYChart.Data<Integer, Number>(r2, 41941.19));
		series2.getData().add(new XYChart.Data<Integer, Number>(r3, 45263.37));
		series2.getData().add(new XYChart.Data<Integer, Number>(r4, 117320.16));
		series2.getData().add(new XYChart.Data<Integer, Number>(r5, 14845.27));
		series3.setName("Q8");
		series3.getData().add(new XYChart.Data<Integer, Number>(r1, 45000.65));
		series3.getData().add(new XYChart.Data<Integer, Number>(r2, 44835.76));
		series3.getData().add(new XYChart.Data<Integer, Number>(r3, 18722.18));
		series3.getData().add(new XYChart.Data<Integer, Number>(r4, 17557.31));
		series3.getData().add(new XYChart.Data<Integer, Number>(r5, 92633.68));
		barChart.getData().addAll(series1, series2, series3);
		*/
		ArrayList<HashMap<String, Double>> data = new ArrayList<HashMap<String, Double>>();
		
		for( int i=1; i<6; i++) {
			// Jede HashMap enhaelt die Daten einer Runde
			HashMap<String, Double> series = new HashMap<String, Double>();
			series.put("Q1",  i*10.0);
			series.put("Q2",  i*10.0);
			series.put("Q3", i*10.0);
			series.put("Q4",  i*10.0);
			series.put("Q5", i*10.0);
			data.add(series);
		}
		
		parseData( data,new String[] { "Runde 1","Runde 2", "Runde 3", "Runde 4", "Runde 5" }, xAxisBar, yAxisBar, barChart);
	}
	
	public void setStage( Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/**
	 * Diese Methode befuellt Kategorie-Orientierte Daten in ein BarChart
	 * @param data Eine Liste der Daten, die zu jeder Kategorie gehoeren.  
	 * @param categories Bezeichner der Kategorie (gleich lang wie data!)
	 * @param xAxisBar Die XAchse des Diagramms
	 * @param yAxisBar Die YAchse des Diagramms
	 * @param barChart Das Diagramm in dem die Daten erscheinen sollen
	 */
	public static <T> void parseData(ArrayList<HashMap<String, T>> data, String[] categories, CategoryAxis xAxisBar, NumberAxis yAxisBar, XYChart<String, T> barChart) {			
		
		HashMap<String, XYChart.Series<String, T>> seriesMaps = new HashMap<String, XYChart.Series<String, T>>();
		
		for( int i=0; i<data.size(); i++) {
			HashMap<String, T> roundMap = data.get(i);
			for(Map.Entry<String, T> entry : roundMap.entrySet()) {
				XYChart.Series<String, T> roundSeries = seriesMaps.get(entry.getKey());
				if( roundSeries == null) {
					XYChart.Series<String, T> newSerie = new XYChart.Series<>();
					newSerie.setName(entry.getKey());
					newSerie.getData().add(new XYChart.Data<String, T>(categories[i], entry.getValue()));
					seriesMaps.put(entry.getKey(), newSerie);
					barChart.getData().add(newSerie);
				} else {
					roundSeries.getData().add( new XYChart.Data<String, T>(categories[i], entry.getValue()));
				}
			}
		}
		
		xAxisBar.setCategories(FXCollections.observableArrayList(categories));
	}

	public void initPie() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Grapefruit",
				13), new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22),
				new PieChart.Data("Apples", 30));

		pieChart.setData(pieChartData);
	}

	public void initLine() {
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

		series.setName("Barwert");
		xAxisLine.setLabel("Monate");
		yAxisLine.setLabel("Y-Achse");

		series.getData().add(new XYChart.Data<String, Number>("Jan", 2300000));
		series.getData().add(new XYChart.Data<String, Number>("Feb", 1400000));
		series.getData().add(new XYChart.Data<String, Number>("Mar", 1500000));
		series.getData().add(new XYChart.Data<String, Number>("Apr", 2400000));
		series.getData().add(new XYChart.Data<String, Number>("May", 3400000));
		series.getData().add(new XYChart.Data<String, Number>("Jun", 3600000));
		series.getData().add(new XYChart.Data<String, Number>("Jul", 2200000));
		series.getData().add(new XYChart.Data<String, Number>("Aug", 4500000));
		series.getData().add(new XYChart.Data<String, Number>("Sep", 4300000));
		series.getData().add(new XYChart.Data<String, Number>("Oct", 1700000));
		series.getData().add(new XYChart.Data<String, Number>("Nov", 2900000));
		series.getData().add(new XYChart.Data<String, Number>("Dec", 2500000));

		lineChart.getData().add(series);
	}

	public void initialize() {
		initPie();
		initLine();
		initSBC();
	}
	
	@FXML
	public void mouseEntered(MouseEvent event) {
		try {
		    // Load the fxml file and create a new stage for the popup
		    FXMLLoader loader = new FXMLLoader(Main.class.getResource("Popup.fxml"));
		    AnchorPane page = (AnchorPane) loader.load();
		    Stage dialogStage = new Stage(StageStyle.TRANSPARENT);
		    dialogStage.setTitle("Edit Person");
		    dialogStage.initModality(Modality.NONE);
		    Scene scene = new Scene(page);
		    dialogStage.setScene(scene);
		    dialogStage.setX((event.getX() + primaryStage.getX()) + 75);
			dialogStage.setY((event.getY() + primaryStage.getY()) + 30);
		    // Set the person into the controller
		    PopController controller = loader.getController();
		    controller.setDialogStage(dialogStage);

		    // Show the dialog and wait until the user closes it
		    dialogStage.show();
		    this.dialogStage = dialogStage;

		  } catch (IOException e) {
		    // Exception gets thrown if the fxml file could not be loaded
		    e.printStackTrace();
		  }
	}
	
	@FXML
	public void mouseMoved(MouseEvent event) {
		dialogStage.setX((event.getX() + primaryStage.getX()) + 75);
		dialogStage.setY((event.getY() + primaryStage.getY()) + 30);
	}
	
	@FXML
	public void mouseExited(MouseEvent event) {
		dialogStage.close();
	}
}
