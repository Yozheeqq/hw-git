import facade.ComputerFacade;

public class Main {
    public static void main(String[] args) {
        ComputerFacade facade = new ComputerFacade();

        facade.turnOnPC();
        facade.turnOnChrome();
        facade.turnOffChrome();
        facade.turnOffPC();
    }
}