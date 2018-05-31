package sample;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineRenewableChart implements Subscriber{
    private LineChart<Number, Number> chart;
    private XYChart.Series<Number, Number> series;

    LineRenewableChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("y");
        this.chart = new LineChart<>(xAxis, yAxis);
        series = new XYChart.Series();
        chart.getData().add(series);
        initChart();
    }

    public void initChart () {
//        chart.setAnimated(false);
        chart.setTitle("Дискретная функция");
        chart.setPrefSize(300, 300);
        chart.setLegendVisible(false);
    }

    public LineChart<Number, Number> getChart() {
        return chart;
    }

    @Override
    public void update(functionValue data) {
        int index = data.getxList().size() - 1;
        series.getData().add(new XYChart.Data<>(data.getxList().get(index), data.getyList().get(index)));
    }
}
