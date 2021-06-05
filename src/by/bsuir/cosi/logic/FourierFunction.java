package by.bsuir.cosi.logic;

import by.bsuir.cosi.util.Counter;
import by.bsuir.cosi.entity.Complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourierFunction {
    private static ArrayList<Complex> list;
    private static int N = 16;

    public static HashMap<Double, Double> getOriginalGraph() {
        HashMap<Double, Double> graphHash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graphHash.put(2 * i * Math.PI / N, Math.sin(2 * i * Math.PI / N) + Math.cos(4 * (2 * i * Math.PI / N)));
        }
        return graphHash;
    }

    public static Map<Double, Double> getCosOriginalGraph() {
        Map<Double, Double> graphHash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graphHash.put(2 * i * Math.PI / N, Math.cos(4 * 2 * i * Math.PI / N));
        }
        return graphHash;
    }

    public static Map<Double, Double> getSinOriginalGraph() {
        Map<Double, Double> graphHash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graphHash.put(2 * i * Math.PI / N, Math.sin(2 * i * Math.PI / N));
        }
        return graphHash;
    }

    public static HashMap<Double, Double> getDiscreteFourierGraph(HashMap<Double, Double> source) {
        ArrayList<Complex> temp = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        Counter mul = new Counter();
        Counter add = new Counter();
        for (int i = 0; i < N; i++) {
            temp.add(new Complex(source.get(2 * i * Math.PI / N), 0.0));
        }
        fouirierList = Fourier.discreteFourier(temp, N, -1, mul, add);
        //  System.out.println("Discrete transform: add - "+add+" mul - "+mul);
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).abs());
        }
        return result;
    }

    public static HashMap<Double, Double> getFastFourierGraph(HashMap<Double, Double> source) {
        ArrayList<Complex> temp = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        Counter mul = new Counter();
        Counter add = new Counter();
        for (int i = 0; i < N; i++) {
            temp.add(new Complex(source.get(2 * i * Math.PI / N), 0.0));
        }
        fouirierList = Fourier.fastFourier(temp, N, -1, mul, add);
        //  System.out.println("Fast transform: add - "+add+" mul - "+mul);
        for (int i = 0; i < fouirierList.size(); i++) {
            fouirierList.set(i, fouirierList.get(i).divides(N));
        }
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).abs());
        }
        return result;
    }

    public static HashMap<Double, Double> getReverseFourier(int fourierType) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fourierList;
        if (fourierType == 0) {
            Counter mul = new Counter();
            Counter add = new Counter();
            fourierList = Fourier.fastFourier(list, N, 1, mul, add);
        } else {
            Counter mul = new Counter();
            Counter add = new Counter();
            fourierList = Fourier.discreteFourier(list, N, 1, mul, add);
        }
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fourierList.get(i).getRe());
        }
        return result;
    }

    public static HashMap<Double, Double> getPhaseCharacteristics(int fourierType) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fourierList;
        if (fourierType == 0) {
            Counter mul = new Counter();
            Counter add = new Counter();
            fourierList = Fourier.fastFourier(list, N, -1, mul, add);
        } else {
            Counter mul = new Counter();
            Counter add = new Counter();
            fourierList = Fourier.discreteFourier(list, N, -1, mul, add);
        }
        for (int i = 0; i < N; i++) {
            result.put(2 * i * Math.PI / N, fourierList.get(i).phase());
        }

        return result;
    }
}
