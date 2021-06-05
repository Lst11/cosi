package by.bsuir.cosi.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Map;

public class Graph {
    private LineChart<Number, Number> graph;
    private ObservableList<XYChart.Data> data;
    private XYChart.Series series;

    public Graph(Map<Double, Double> graphHash, String title) {
        graph = new LineChart<>(new NumberAxis(), new NumberAxis());
        graph.setTitle(title);
        graph.setCreateSymbols(true);
        graph.setLegendVisible(false);
        series = new XYChart.Series();
        data = FXCollections.observableArrayList();

        for (Object o : graphHash.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            data.add(new XYChart.Data(pair.getKey(), pair.getValue()));
        }
        series.setData(data);
        graph.getData().add(series);
    }

    public LineChart<Number, Number> getGraphs() {
        return graph;
    }
}
