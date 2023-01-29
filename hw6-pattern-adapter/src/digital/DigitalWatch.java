package digital;

public class DigitalWatch {
    private final int hour;
    private final int minute;
    private final int second;

    public DigitalWatch() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    public DigitalWatch(int hour, int minute, int second) {
        if (!checkCorrectTime(hour, minute, second)) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public String getTime() {
        return getHour() + ":" + getMinute() + ":" + getSecond();
    }

    private boolean checkCorrectTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            return false;
        }
        if (minute < 0 || minute >= 60) {
            return false;
        }
        return second >= 0 && second < 60;
    }
}
