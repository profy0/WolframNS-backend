package com.NSiTeam.WolframNS.requests;

import java.util.List;

public class MatrixRequest {
    private List<List<Number>> matrix1;
    private List<List<Number>> matrix2;
    private String operation;

    public List<List<Number>> getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(List<List<Number>> matrix1) {
        this.matrix1 = matrix1;
    }

    public List<List<Number>> getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(List<List<Number>> matrix2) {
        this.matrix2 = matrix2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double[][] getMatrix1AsArray() {
        return convertToArray(matrix1);
    }

    public double[][] getMatrix2AsArray() {
        return convertToArray(matrix2);
    }

    private double[][] convertToArray(List<List<Number>> list) {
        if (list == null) {
            return null;
        }
        return list.stream()
                .map(l -> l.stream().mapToDouble(Number::doubleValue).toArray())
                .toArray(double[][]::new);
    }
}
