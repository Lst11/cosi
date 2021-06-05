package by.bsuir.cosi.walsh;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class Charts {

    //Amplitude chart
    public LineChart<Number, Number> buildAmplitudeChart(double[] real, int n, String title) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number, Number> amplitudeChart = new LineChart<>(xAxis, yAxis);
        amplitudeChart.setTitle(title);
        XYChart.Series series = new XYChart.Series();
        series.setName("");
        for (int i = 0; i < n; i++) {
            series.getData().add(new XYChart.Data<>(i * n / (2 * Math.PI), Math.sqrt(Math.pow(real[i], 2))));
        }
        amplitudeChart.getData().add(series);
        amplitudeChart.setCreateSymbols(false);
        amplitudeChart.setLegendVisible(false);
        return amplitudeChart;
    }

    //Phase chart
    public LineChart<Number, Number> buildPhaseChart(double[] real, int n, String title) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number, Number> phaseChart = new LineChart<>(xAxis, yAxis);
        phaseChart.setTitle(title);
        XYChart.Series series = new XYChart.Series();
        series.setName("");
        for (int i = 0; i < n; i++) {
            series.getData().add(new XYChart.Data<>(i * n / (2 * Math.PI), Math.atan2(0, real[i])));
        }
        phaseChart.getData().add(series);
        phaseChart.setCreateSymbols(false);
        phaseChart.setLegendVisible(false);
        return phaseChart;
    }

    //Initial chart
    public LineChart<Number, Number> buildInitialChart(Point[] points, int n, String title) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("y");
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(title);
        XYChart.Series series = new XYChart.Series();
        series.setName("Points");
        for (int i = 0; i < n; i++) {
            series.getData().add(new XYChart.Data<>(points[i].getX(), points[i].getY()));
        }
        lineChart.getData().add(series);
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        return lineChart;
    }
}
