class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    int travelled = 0;
    int victories = 0;

    public void drive() {
        this.travelled += 10;
    }

    public int getDistanceTravelled() {
        return this.travelled;
    }

    public int getNumberOfVictories() {
        return this.victories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.victories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar productionRemoteControlCar) {
        return this.victories - productionRemoteControlCar.getNumberOfVictories();
    }
}
