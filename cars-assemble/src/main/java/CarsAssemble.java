public class CarsAssemble {

    private double scaleProduction(double produced, int speed) {
        if (speed >= 1 && speed <= 4) {
            return produced;
        } else if (speed >= 5 && speed <= 8) {
            return (produced * 0.9);
        } else if (speed == 9) {
            return (produced * 0.8);
        } else {
            return (produced * 0.77);
        }
    }

    public double productionRatePerHour(int speed) {
        double produced =  speed * 221d;

        return this.scaleProduction(produced, speed);
    }

    public int workingItemsPerMinute(int speed) {
        double produced = this.productionRatePerHour(speed);

        return (int) (produced / 60);
    }
}
