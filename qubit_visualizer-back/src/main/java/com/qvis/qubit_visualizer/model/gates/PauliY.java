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

    public Integer[] changeState(Integer[] state) {
        Integer[][] matrix = getMatrix();
        Integer[] result = new Integer[2];

        result[0] = matrix[0][0] * state[0] + matrix[0][1] * state[1];
        result[1] = matrix[1][0] * state[0] + matrix[1][1] * state[1];
        return result;
    }

}
