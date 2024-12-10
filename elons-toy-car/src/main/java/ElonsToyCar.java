public class ElonsToyCar {
    int drivenTimes = 0;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", drivenTimes * 20);
    }

    public String batteryDisplay() {
        if (drivenTimes == 100) return "Battery empty";

        return String.format("Battery at %d%%", 100 - drivenTimes);
    }

    public void drive() {
        if (drivenTimes < 100)
            this.drivenTimes++;
    }
}
