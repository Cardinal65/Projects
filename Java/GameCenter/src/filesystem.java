import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Random;

public class filesystem {
    public static void main(String [] args) throws IOException {
        Random r = new Random();
        String[] games = new String[20];
        for (int i = 0; i < 20; i++) {
            games[i] = "hello world" + i;
        }
        int num = r.nextInt(20);
        System.out.println(num);
        System.out.println(games[num]);
    }
}
