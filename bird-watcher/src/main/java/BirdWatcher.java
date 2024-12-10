
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] lastWeek = new int[7];

        for (int i = 0; i < 7; i++) {
            lastWeek[6 - i] = birdsPerDay[birdsPerDay.length - 1 - i];
        }

        return lastWeek;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int x : birdsPerDay) {
            if (x == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;

        for (int x = 0; x < Math.min(numberOfDays, birdsPerDay.length); x++) {
            count += birdsPerDay[x];
        }

        return count;
    }

    public int getBusyDays() {
        int count = 0;
        for (int x : birdsPerDay) {
            if (x >= 5) {
                count++;
            }
        }

        return count;
    }
}
