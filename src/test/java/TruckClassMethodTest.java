import models.Box;
import models.BoxParams;
import models.Truck;
import org.junit.jupiter.api.Test;
import utils.CalculationUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.CalculationUtils.hasEnoughSpace;
public class TruckClassMethodTest {
    @Test
    public void truckHasEnoughSpaceTest(){
        Truck truck = new Truck(10,2,4,8,new BoxParams(100,100,100));
        Box tooBigBox = new Box(100, 100, 100, 1000);
        assertEquals(true,truck.hasEnoughSpaceToPlace(tooBigBox));

    }
    @Test
    public void transportaionPriceTest(){
        Truck truck = new Truck(10,1,2,5,new BoxParams(10,10,10));
        Box box = new Box(5, 5, 5, 0.8);
        assertEquals(335.0,truck.priceForTransportation(5.0,box));
    }
    @Test
    public void loadingCargoTest(){
        Truck truck = new Truck(10,1,2,5,new BoxParams(10,10,10));
        Box box1 = new Box(5, 5, 5, 0.8);
        Box box2 = new Box(5, 5, 5, 0.8);
        Box box3 = new Box(5, 5, 5, 0.8);
        truck.loadingOfCargo(box1);
        assertEquals(null,truck.loadingOfCargo(box3));
    }
    @Test
    public void getMaxBoxParamTest(){
        Truck truck = new Truck(10,1,2,5,new BoxParams(10,10,10));
        assertEquals(new BoxParams(10,10,10), CalculationUtils.getMaxDimensionsOfFitableBox(truck));
    }
    @Test
    public void hasEnoughSpaceToPlaceTooBigBox(){
        Box tooBigBox = new Box(100, 100, 100, 1000);
        BoxParams Param=new BoxParams(1,2,3);
        assertEquals(false,hasEnoughSpace(tooBigBox,Param));

    }
    @Test
    public void optimalTruckTest(){
        Truck truck1 = new Truck(10,1,2,5,new BoxParams(10,10,10));
        Truck truck2 = new Truck(5,2,1,3,new BoxParams(10,10,10));
        Box box=new Box(5,5,5,10);
        List<Truck> trucks=new ArrayList<>();
        trucks.add(truck1);
        trucks.add(truck2);
        assertEquals(truck1, CalculationUtils.findBestTruckForTransportation(trucks,box,10.0));

    }
}

