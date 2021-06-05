package by.bsuir.cosi.drawing;

import by.bsuir.cosi.walsh.Charts;
import by.bsuir.cosi.walsh.Point;
import javafx.scene.layout.GridPane;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DrawingWalsh {
    private static int n = 16;
    private static Point[] points;
    private static Charts charts = new Charts();
    private static GridPane pane  = new GridPane();

    static public GridPane drawWalsh(){
        double step = 2 * Math.PI / n;
        double x;
        points = new Point[n];
        for(int i = 0; i < n; i++) {
            x = i * step;
            Point newPoint = new Point(x);
            points[i] = newPoint;
        }

        pane.add(charts.buildInitialChart(points, n, "y = sin(x) + cos(4x)"), 1, 1);

        double[] fastArray = new double[n];
        for(int i = 0; i < n; i++)
            fastArray[i] = points[i].getY();

        fastWalshTransform(fastArray, n);

        for(int i = 0; i < n; i++) {
            fastArray[i] /= n;
        }
        pane.add(charts.buildAmplitudeChart(fastArray, n, "БПУ:"), 2, 1);
        pane.add(charts.buildPhaseChart(fastArray, n, ""), 2, 2);
        printArray(fastArray, "Fast walsh:");

        double[] discreteArray = new double[n];
        for(int i = 0; i < n; i++)
            discreteArray[i] = points[i].getY();
        discreteArray = discreteWalshTransform(discreteArray);
        pane.add(charts.buildAmplitudeChart(discreteArray, n, "ДПУ:"), 3, 1);
        pane.add(charts.buildPhaseChart(discreteArray, n, ""), 3, 2);
        printArray(discreteArray, "Discrete walsh:");
        return pane;
    }

    static void fastWalshTransform(double[] a, int n) {
        if(n == 1) return;
        double[] b = new double[n/2];
        double[] c = new double[n/2];
        for(int i = 0; i < n/2; i++) {
            b[i] = a[i] + a[i + n/2];
            c[i] = a[i] - a[i + n/2];
        }
        fastWalshTransform(b, n/2);
        fastWalshTransform(c, n/2);
        for(int j = 0; j < n/2; j++) {
            a[j] = b[j];
            a[j + n/2] = c[j];
        }
    }

    public static double[] discreteWalshTransform(double[] initArray) {
        int[][] hadamarMatrix = getHadamarMatrix();
        double[] result = new double[n];
        for(int k = 0; k < n; k++) {
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                sum += initArray[i] * hadamarMatrix[k][i];
            }
            result[k] = sum / n;
        }
        return result;
    }

    public static int[][] getHadamarMatrix() {
        int[][] hadamar = new int[n][n];
        hadamar[0][0] = 1;
        for(int k = 1; k < n; k += k) {
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < k; j++) {
                    hadamar[i + k][j] = hadamar[i][j];
                    hadamar[i][j + k] = hadamar[i][j];
                    hadamar[i + k][j + k] = hadamar[i][j] * (-1);
                }
            }
        }

        return hadamar;
    }

    public static void printArray(double[] array, String title) {
        System.out.println("\n" + title);
        for(int i = 0; i < array.length; i++) {
            BigDecimal value = BigDecimal.valueOf(array[i]).setScale(2, RoundingMode.HALF_UP);
            System.out.println((i + 1) + ". " + value);
        }
    }

}
