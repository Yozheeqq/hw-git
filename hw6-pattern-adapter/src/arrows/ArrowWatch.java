package arrows;

public class ArrowWatch {
    private final int hourDegree;
    private final int minuteDegree;
    private final int secondDegree;

    public ArrowWatch() {
        hourDegree = 0;
        minuteDegree = 0;
        secondDegree = 0;
    }

    public ArrowWatch(int hourDegree, int minuteDegree, int secondDegree) {
        if (!checkCorrectTime(hourDegree, minuteDegree, secondDegree)) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        this.hourDegree = hourDegree;
        this.minuteDegree = minuteDegree;
        this.secondDegree = secondDegree;
    }

    public int getHourDegree() {
        return hourDegree;
    }

    public int getMinuteDegree() {
        return minuteDegree;
    }

    public int getSecondDegree() {
        return secondDegree;
    }

    private boolean checkCorrectTime(int hourDegree, int minuteDegree, int secondDegree) {
        if (hourDegree < 0 || hourDegree >= 360) {
            return false;
        }
        if (minuteDegree < 0 || minuteDegree >= 360) {
            return false;
        }
        return secondDegree >= 0 && secondDegree < 360;
    }
}
