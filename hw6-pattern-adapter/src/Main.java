import adapter.ArrowDigitalAdapter;
import arrows.ArrowWatch;

public class Main {
    public static void main(String[] args) {
        ArrowWatch arrowWatch = new ArrowWatch(95, 180, 15);

        ArrowDigitalAdapter adapter = new ArrowDigitalAdapter(arrowWatch);
        System.out.println(adapter.getTime());
    }
}