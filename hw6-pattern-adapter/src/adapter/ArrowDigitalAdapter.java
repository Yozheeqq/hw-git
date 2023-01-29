package adapter;

import arrows.ArrowWatch;
import digital.DigitalWatch;

public class ArrowDigitalAdapter extends DigitalWatch {
    private final ArrowWatch arrowWatch;

    public ArrowDigitalAdapter(ArrowWatch digitalWatch) {
        this.arrowWatch = digitalWatch;
    }

    @Override
    public int getHour() {
        return arrowWatch.getHourDegree() / 30;
    }

    @Override
    public int getMinute() {
        return arrowWatch.getMinuteDegree() / 6;
    }

    @Override
    public int getSecond() {
        return arrowWatch.getSecondDegree() / 6;
    }

}
