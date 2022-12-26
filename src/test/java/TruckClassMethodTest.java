import models.Box;
import models.BoxParams;
import models.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckClassMethodTest {
    @Test
    public void hasEnoughSpaceToPlaceTooBigBox(){
        Truck truck = new Truck(1.0, 1.0, 1.0 ,1.0, new BoxParams(10, 10, 10));
        Box tooBigBox = new Box(100, 100, 100, 1000);

        assertEquals(false, truck.hasEnoughSpaceToPlace(tooBigBox));
    }
}
import models.Box;
import models.BoxParams;
import models.Truck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.CalculationUtils.getMaxDimensionsOfFitableBox;
import static utils.CalculationUtils.hasEnoughSpace;

public class TruckClassMethodTest {
    @Test
    public void hasEnoughSpaceToPlaceTooBigBox(){
        Box tooBigBox = new Box(100, 100, 100, 1000);
        BoxParams Param=new BoxParams(1,2,3);
        assertEquals(false,hasEnoughSpace(tooBigBox,Param));

    }
    @Test
    public void  findBestTruckForTransportation() {
        Truck truck1 = new Truck(1.0, 1.0, 1.0, 1.0, new BoxParams(10, 10, 10));
        Truck truck2 = new Truck(2.0, 3.0, 4.0, 2.0, new BoxParams(10, 10, 10));
        Box tooBigBox = new Box(10, 10, 10, 100);
        List<Truck> trucks=new ArrayList<>();
        trucks.add(truck1);
        trucks.add(truck2);


        assertEquals(truck1, findBestTruckForTransportation(trucks, tooBigBox ,10.0));
    }

}

