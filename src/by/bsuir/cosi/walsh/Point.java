package by.bsuir.cosi.walsh;

public class Point {
    private double x;
    private double y;

    public Point(double x) {
        this.x = x;
        y = Math.sin(x) + Math.cos(4 * x);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
