package models;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxParams boxParams = (BoxParams) o;
        return Double.compare(boxParams.length, length) == 0 && Double.compare(boxParams.width, width) == 0 && Double.compare(boxParams.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, height);
    }
}
