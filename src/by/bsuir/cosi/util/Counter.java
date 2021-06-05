package by.bsuir.cosi.util;

public class Counter {
    private int count;

    public void inc() {
        count++;
    }

    @Override
    public String toString() {
        return count + "";
    }

    public int getCount() {
        return count;
    }
}
