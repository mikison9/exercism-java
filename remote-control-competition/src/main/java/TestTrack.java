import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        List<ProductionRemoteControlCar> copy = new ArrayList<ProductionRemoteControlCar>(cars);
        copy.sort((c1, c2) -> c2.getNumberOfVictories() - c1.getNumberOfVictories());
        return copy;
    }
}
