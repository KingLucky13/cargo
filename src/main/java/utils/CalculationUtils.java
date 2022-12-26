package utils;

import models.Box;
import models.BoxParams;
import models.Truck;

import java.util.List;

public class CalculationUtils {
    public static BoxParams getMaxDimensionsOfFitableBox(Truck truck){

        BoxParams MaxBox = truck.getMaxBoxParams();
                return MaxBox;
    }

    public static boolean hasEnoughSpace(Box box, BoxParams boxParams){
        if(( box.getParam(0)<= boxParams.getParam(0)) && (box.getParam(1)<= box.getParam(1)) && (box.getParam(2)<= box.getParam(2))){
            return true;
        }
        return false;
    }

    public static Truck findBestTruckForTransportation(List<Truck> trucks, Box box, Double kmDistance){
        double minprice = 100000000000.0;
        int idbox = 0;
        for (int i = 0; i < trucks.size();i++){
            if (minprice > trucks.get(i).priceForTransportation(kmDistance,box)){
                minprice =  trucks.get(i).priceForTransportation(kmDistance,box);
                idbox=i;
            }
        }
        return trucks.get(idbox);

    }
}

