package com.qvis.qubit_visualizer.model.login;

import org.springframework.http.HttpStatus;

public class LoginResponse {
    private HttpStatus status;
    private String selectedGate;


    public LoginResponse() {
    }

    public LoginResponse(HttpStatus status) {
        this.status = status;
    }

    public LoginResponse(String selectedGate) {
        this.selectedGate = selectedGate;
    }

    public LoginResponse(HttpStatus status, String selectedGate) {
        this.status = status;
        this.selectedGate = selectedGate;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getSelectedGate() {
        return selectedGate;
    }

    public void setSelectedGate(String selectedGate) {
        this.selectedGate = selectedGate;
    }
}
