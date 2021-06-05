package by.bsuir.cosi.logic;

import by.bsuir.cosi.entity.Complex;
import by.bsuir.cosi.util.Counter;

import java.util.ArrayList;
import java.util.HashMap;

import static by.bsuir.cosi.logic.ListLogicValue.*;

public class Convolution {

    public static HashMap<Double, Double> getConvolution() {
        HashMap<Double, Double> result = new HashMap<>();
        Counter mul = new Counter();
        Counter add = new Counter();
        for (int m = 0; m < N; m++) {
            Double Zn = 0.0;
            for (int h = 0; h < N; h++) {
                Zn += sinList.get(h) * cosList.get((m - h + N) % N);
                mul.inc();
                add.inc();
            }
            result.put(2 * Math.PI * m / N, Zn / N);
        }
        return result;
    }


    public static HashMap<Double, Double> getConvolutionFFT() {

        ArrayList<Complex> Cz = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();

        Counter mul = new Counter();
        Counter add = new Counter();

        ArrayList<Complex> Cx = Fourier.fastFourier(sinListComplex, N, -1, mul, add);
        ArrayList<Complex> Cy = Fourier.fastFourier(cosListComplex, N, -1, mul, add);

        for (int i = 0; i < N; i++) {
            Cx.set(i, Cx.get(i).divides(N));
            Cy.set(i, Cy.get(i).divides(N));
            Cz.add(Cx.get(i).times(Cy.get(i)));
        }

        return getDoubleHashMap(Cz, result, mul, add);
    }
}
