public class ExperimentalRemoteControlCar implements RemoteControlCar {
    int travelled = 0;
    public void drive() {
        this.travelled += 20;
    }

    public int getDistanceTravelled() {
        return this.travelled;
    }
}
