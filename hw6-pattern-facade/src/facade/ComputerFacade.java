package facade;

import computer.Computer;

public class ComputerFacade {
    private final Computer computer = new Computer();
    private boolean isTurnedOn = false;

    public void turnOnPC() {
        if (isTurnedOn) {
            System.out.println("Computer is already switched on!");
            return;
        }
        if (computer.checkHardWare()) {
            imitateSleep("Computer turns on", 200, 4);
            isTurnedOn = true;
        } else {
            System.out.println("Some problem inside PC");
        }
    }

    public void turnOffPC() {
        if (!isTurnedOn) {
            System.out.println("Computer is not switched on!");
            return;
        }
        imitateSleep("Saving your data", 100, 3);
        if (computer.saveData()) {
            System.out.println("Goodbye!");
            isTurnedOn = false;
        } else {
            System.out.println("Sorry, your data was not saved");
        }
    }

    public void turnOnChrome() {
        if (!isTurnedOn) {
            System.out.println("Computer is not switched on!");
            return;
        }
        if (computer.checkConnection()) {
            imitateSleep("Chrome starts", 100, 3);
        } else {
            System.out.println("Internet is not available");
        }
    }

    public void turnOffChrome() {
        if (!isTurnedOn) {
            System.out.println("Computer is not switched on!");
            return;
        }
        imitateSleep("Chrome switches off", 50, 3);
    }

    private void imitateSleep(String message, int millis, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(message + " " + (i + 1));
            try {
                Thread.sleep(millis);
            } catch (Exception exc) {
                System.out.println("Unexpected exception");
            }
        }
    }
}
