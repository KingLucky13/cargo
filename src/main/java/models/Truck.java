package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Truck {
    private static List<Box> boxList;
    private static double costOfCall; // стоимость подачи
    private static  double costOfLoadingPerKilo; // стоимость загрузки килограма
    private static double costOfUnloadingPerKilogram; // стоимость разгрузки за кг
    private static double pricePerKilometer; // стоимость траспортировки за 1 км

    private static BoxParams maxBoxParams; //максимальная вместительность
    public Truck(double costOfCall, double costOfLoadingPerKilo, double costOfUnloadingPerKilogram, double pricePerKilometer, BoxParams maxBoxParams) {
        this.costOfCall = costOfCall;
        this.costOfLoadingPerKilo = costOfLoadingPerKilo;
        this.costOfUnloadingPerKilogram = costOfUnloadingPerKilogram;
        this.pricePerKilometer = pricePerKilometer;
        this.maxBoxParams = maxBoxParams;
        boxList=new ArrayList<>();
    }

    public static boolean hasEnoughSpaceToPlace(Box box){
        double[] givenParams={box.getLength(),box.getWidth(), box.getHeight()};
        double[] maxParams={maxBoxParams.getLength(), maxBoxParams.getWidth(), maxBoxParams.getHeight()};
        Arrays.sort(givenParams);
        Arrays.sort(maxParams);
        if(givenParams[0]<=maxParams[0]&&givenParams[1]<=maxParams[1]&&givenParams[2]<=maxParams[2]){
            return true;
        }
        return false;
    }

    public static Double priceForTransportation(double kmDistance, Box box){
        if(!hasEnoughSpaceToPlace(box)){
            throw new RuntimeException("нет места");
        }
        double m= box.getLength()* box.getWidth()* box.getHeight()* box.getDensity();
        double cost=costOfCall+(costOfLoadingPerKilo+costOfUnloadingPerKilogram)*m+kmDistance*pricePerKilometer;
        return cost;
    }

    public static Object loadingOfCargo(Box box){
        if(!hasEnoughSpaceToPlace(box)) {
            throw new RuntimeException("нет места");
        }
        else {
            boxList.add(box);
            if(box.getParam(2)<=maxBoxParams.getParam(0)){
                maxBoxParams.setLength(maxBoxParams.getParam(0));
                maxBoxParams.setWidth(maxBoxParams.getParam(1));
                maxBoxParams.setHeight(maxBoxParams.getParam(2)-box.getParam(0));
                }
            else if(box.getParam(2)<=maxBoxParams.getParam(1)){
                maxBoxParams.setLength(maxBoxParams.getParam(0));
                maxBoxParams.setWidth(maxBoxParams.getParam(1));
                maxBoxParams.setHeight(maxBoxParams.getParam(2)-box.getParam(1));
            }
            else{
                maxBoxParams.setLength(maxBoxParams.getParam(0));
                maxBoxParams.setWidth(maxBoxParams.getParam(1));
                maxBoxParams.setHeight(maxBoxParams.getParam(2)-box.getParam(2));
            }
            return null;
            //уменьшить место
        }
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public double getCostOfCall() {
        return costOfCall;
    }

    public double getCostOfLoadingPerKilo() {
        return costOfLoadingPerKilo;
    }

    public double getCostOfUnloadingPerKilogram() {
        return costOfUnloadingPerKilogram;
    }

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public BoxParams getMaxBoxParams() {
        return maxBoxParams;
    }

}
