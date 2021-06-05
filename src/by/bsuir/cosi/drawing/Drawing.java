package by.bsuir.cosi.drawing;

import by.bsuir.cosi.entity.Graph;
import by.bsuir.cosi.logic.*;
import javafx.scene.Group;

public class Drawing extends Group {

    public Drawing() {
        //todo first lab
        Graph graph1 = new Graph(FourierFunction.getFastFourierGraph(FourierFunction.getOriginalGraph()), "FFT");
        graph1.getGraphs().setTranslateX(10);


        Graph graph2 = new Graph(FourierFunction.getReverseFourier(0), "Reverse transform (FFT)");
        graph2.getGraphs().setTranslateX(510);

        Graph graph3 = new Graph(FourierFunction.getDiscreteFourierGraph(FourierFunction.getOriginalGraph()), "DFT");
        graph3.getGraphs().setTranslateX(10);
        graph3.getGraphs().setTranslateY(400);

        Graph graph4 = new Graph(FourierFunction.getReverseFourier(1), "Reverse transform (DFT)");
        graph4.getGraphs().setTranslateX(510);
        graph4.getGraphs().setTranslateY(400);

        Graph graph5 = new Graph(FourierFunction.getOriginalGraph(), "Phase Characteristics(FFT)");
        graph5.getGraphs().setTranslateX(1010);

        Graph graph6 = new Graph(FourierFunction.getPhaseCharacteristics(1), "Phase Characteristics(DFT)");
        graph6.getGraphs().setTranslateX(1010);
        graph6.getGraphs().setTranslateY(400);

        getChildren().addAll(
                graph1.getGraphs(),
                graph2.getGraphs(),
                graph3.getGraphs(),
                graph4.getGraphs(),
                graph5.getGraphs(),
                graph6.getGraphs()
        );

/*
        // todo second lab
        ListLogicValue.setCosValueList();
        ListLogicValue.setSinValueList();

        Graph graph = new Graph(FourierFunction.getCosOriginalGraph(), "cos(4x)");
        Graph graph1 = new Graph(FourierFunction.getSinOriginalGraph(), "sin(x)");
        graph1.getGraphs().setTranslateY(400);

        Graph graph2 = new Graph(Convolution.getConvolution(), "Convolution");
        graph2.getGraphs().setTranslateX(500);

        Graph graph3 = new Graph(Convolution.getConvolutionFFT(), "Convolution with FFT");
        graph3.getGraphs().setTranslateY(400);
        graph3.getGraphs().setTranslateX(500);

        Graph graph4 = new Graph(Correlation.getCorrelation(), "Correlation");
        graph4.getGraphs().setTranslateX(1000);

        Graph graph5 = new Graph(Correlation.getCorrelationFFT(), "Correlation with FFT");
        graph5.getGraphs().setTranslateY(400);
        graph5.getGraphs().setTranslateX(1000);

        getChildren().addAll(
                graph.getGraphs(),
                graph1.getGraphs(),
                graph2.getGraphs(),
                graph3.getGraphs(),
                graph4.getGraphs(),
                graph5.getGraphs());
        */
    }

}
