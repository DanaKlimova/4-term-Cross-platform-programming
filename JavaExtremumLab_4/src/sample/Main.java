package sample;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main extends Application{

    private LineRenewableChart chart;
    private Label addXYLbl;
    private Label extremumsLbl;
    private Label minExtremumLbl;
    private Button addXYBtn;
    private Button extremumsBtn;
    private TextField xValue;
    private TextField yValue;
    private functionValue data;



    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Extremum");
        primaryStage.setScene(new Scene(root, 400, 650));
        initGUI(root);
        primaryStage.show();
        initGUI(root);
    }

    private void initGUI ( GridPane root) {
        data = new functionValue();
        chart = new LineRenewableChart();
        data.subscribe(chart);

        addXYLbl = new Label("Добавить точку");
        extremumsLbl = new Label("Экстремумы");
        minExtremumLbl = new Label("");
        addXYBtn = new Button("Добавить");
        extremumsBtn = new Button("Посчитать");
        xValue = new TextField();
        xValue.setPromptText("x");
        yValue = new TextField();
        yValue.setPromptText("y");

        root.add(chart.getChart(), 0, 0);
        root.add(addXYLbl, 0, 1);
        GridPane.setMargin(addXYLbl, new Insets(2,10,2,10));
        root.setAlignment(Pos.CENTER_LEFT);
        root.add(xValue, 0, 2);
        GridPane.setMargin(xValue, new Insets(2,10,2,10));
        root.add(yValue, 0, 3);
        GridPane.setMargin(yValue, new Insets(2,10,2,10));
        root.add(addXYBtn, 0, 4);
        GridPane.setMargin(addXYBtn, new Insets(2,10,2,10));
        root.add(extremumsLbl, 0, 5);

        GridPane.setMargin(extremumsLbl, new Insets(2,10,2,10));
        root.add(minExtremumLbl, 0, 6);
        GridPane.setMargin(minExtremumLbl, new Insets(2,10,2,10));

        root.add(extremumsBtn, 0, 8);
        GridPane.setMargin(extremumsBtn, new Insets(2,10,2,10));

        addXYBtn.setOnAction(event -> {
            if (yValue.getText().isEmpty() || xValue.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Внимание");
                alert.setHeaderText(null);
                alert.setContentText("Введите координаты точки");
                alert.showAndWait();
            } else {
                Integer x = Integer.parseInt(xValue.getText());
                Integer y = Integer.parseInt(yValue.getText());
                if (data.getxList().contains(x) || data.getyList().contains(y)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);

                    alert.setTitle("Внимание");
                    alert.setHeaderText(null);
                    alert.setContentText("Координаты не должны повторяться");
                    alert.showAndWait();
                    xValue.setText("");
                    yValue.setText("");
                } else {
                    data.getxList().add(x);
                    data.getyList().add(y);
                    xValue.setText("");
                    yValue.setText("");
                    data.notifySubscribers();
                }
            }
        });

        extremumsBtn.setOnAction(event -> {
            CalcExtremums calcExtremums = new CalcExtremums(data);
            minExtremumLbl.textProperty().bind(calcExtremums.messageProperty());
            new Thread(calcExtremums).start();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
