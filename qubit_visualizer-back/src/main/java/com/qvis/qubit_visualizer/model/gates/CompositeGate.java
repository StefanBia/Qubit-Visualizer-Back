package com.qvis.qubit_visualizer.model.gates;

import com.qvis.qubit_visualizer.model.entities.Gate;

import java.util.ArrayList;
import java.util.List;

public class CompositeGate implements Gate {
    private List<Gate> gates = new ArrayList<>();

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public void removeGate(Gate gate) {
        gates.remove(gate);
    }

    @Override
    public Integer[] changeState(Integer[] state) {
        System.out.println("Applying composite gate...");
        for (Gate gate : gates) {
            gate.changeState(state);
        }
        return null;
    }

    @Override
    public void changeBlochSphere() {
        System.out.println("Updating Bloch Sphere with composite gate...");
        for (Gate gate : gates) {
            gate.changeBlochSphere();
        }
    }
}
