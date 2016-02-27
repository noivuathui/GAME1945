import java.io.IOException;
import java.util.Scanner;

/**
 * Created by noivu on 2/27/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GameWindown game = new GameWindown();
        Thread thread = new Thread(game);
        thread.start();

    }
}
