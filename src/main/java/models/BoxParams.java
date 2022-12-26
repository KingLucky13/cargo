package models;

import java.util.Arrays;

public class BoxParams {
    private double length;
    private double width;
    private double height;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public BoxParams(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public double getParam(int id){
        double[] params={this.getLength(),this.getWidth(), this.getHeight()};
        Arrays.sort(params);
        return params[id];
    }
}
