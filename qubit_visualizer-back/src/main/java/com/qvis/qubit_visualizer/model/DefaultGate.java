package com.qvis.qubit_visualizer.model;

import java.io.Serializable;
import java.lang.reflect.Array;

public abstract class DefaultGate implements Gate, Serializable {

    Integer[][] matrix = {
            {1,0},
            {0,1}
    };

    @Override
    public void changeState() {

    }

    @Override
    public void changeBlochSphere() {

    }
}
