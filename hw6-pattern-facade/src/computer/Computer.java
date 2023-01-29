package computer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class Computer {
    public boolean checkConnection() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }

    public boolean checkHardWare() {
        var freeMemoryMegaBytes = Runtime.getRuntime().freeMemory() / 1024;
        if (freeMemoryMegaBytes <= 5000) {
            return false;
        }
        Random random = new Random();
        // А вдруг метеорит упадет
        return random.nextInt(0, 1000) != 1;
    }

    public boolean saveData() {
        Random random = new Random();
        // А вдруг внутри паук живет, который не дает сохранить
        return random.nextInt(0, 1000) % 10 != 1;
    }
}
