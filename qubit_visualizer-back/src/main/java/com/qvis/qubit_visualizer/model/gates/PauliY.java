package com.qvis.qubit_visualizer.model.gates;

import com.qvis.qubit_visualizer.model.entities.DefaultGate;

public class PauliY extends DefaultGate {

    public PauliY() {
        Integer[][] matrix = {
                {0,-7},
                {7,0}
        };
        this.setMatrix(matrix);
    }


}
