import java.io.IOException;
import java.util.Scanner;

/**
 * Created by noivu on 2/27/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GameWindow game = new GameWindow();
        Thread thread = new Thread(game);
        thread.start();

    }
}
