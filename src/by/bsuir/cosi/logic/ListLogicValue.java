package by.bsuir.cosi.logic;

import by.bsuir.cosi.entity.Complex;
import by.bsuir.cosi.util.Counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static by.bsuir.cosi.logic.FourierFunction.getCosOriginalGraph;
import static by.bsuir.cosi.logic.FourierFunction.getSinOriginalGraph;

public class ListLogicValue {

    public static ArrayList<Double> sinList = new ArrayList<>();
    public static ArrayList<Double> cosList = new ArrayList<>();
    public static ArrayList<Complex> sinListComplex = new ArrayList<>();
    public static ArrayList<Complex> cosListComplex = new ArrayList<>();
    public static int N = 16;

    private static void initList(Map<Double, Double> map, ArrayList<Double> funList, ArrayList<Complex> funListComplex) {
        for (Object obj : map.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            funList.add((Double) entry.getValue());
            funListComplex.add(new Complex((Double) entry.getValue(), 0.0));
        }
    }

    public static void setSinValueList() {
        Map<Double, Double> map;
        map = getSinOriginalGraph();
        initList(map, sinList, sinListComplex);
    }

    public static void setCosValueList() {
        Map<Double, Double> map;
        map = getCosOriginalGraph();
        initList(map, cosList, cosListComplex);
    }

    public static HashMap<Double, Double> getDoubleHashMap(ArrayList<Complex> cz, HashMap<Double, Double> result, Counter mul, Counter add) {
        ArrayList<Complex> Z;
        Z = Fourier.fastFourier(cz, N, 1, mul, add);
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, Z.get(i).getRe());
        }
        return result;
    }


}
