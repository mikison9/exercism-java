class NeedForSpeed {
    private final int speed;
    private final int batteryDrain;

    int drivenTimes = 0;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    private int getBattery() {
        return 100 - (this.drivenTimes * this.batteryDrain);
    }

    public boolean batteryDrained() {
        return !(this.getBattery() >= this.batteryDrain);
    }

    public int distanceDriven() {
        return this.drivenTimes * this.speed;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.drivenTimes++;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }

        return car.distanceDriven() >= this.distance;
    }
}
