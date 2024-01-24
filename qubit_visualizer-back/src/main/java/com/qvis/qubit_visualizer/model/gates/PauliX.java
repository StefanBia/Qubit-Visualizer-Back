package com.qvis.qubit_visualizer.model.gates;

import com.qvis.qubit_visualizer.model.entities.DefaultGate;

public class PauliX extends DefaultGate {
    public PauliX() {
        Integer[][] matrix = {
                {0,1},
                {1,0}
        };
        super.setMatrix(matrix);
    }
}
