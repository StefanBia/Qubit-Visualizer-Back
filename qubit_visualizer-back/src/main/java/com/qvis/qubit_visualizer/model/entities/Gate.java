package com.qvis.qubit_visualizer.model.entities;

public interface Gate {
    Integer[] changeState(Integer[] state);
    void changeBlochSphere();
}
