import DataLoader.Loader;
import Main.MainApp;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
           MainApp.main(args);
        } else {
            Loader.main(args);
        }
    }
}
