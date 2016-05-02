package manualQuizBuilding;

import settings.Category;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by ja on 01.05.16.
 */
public class DataGeter {
    private final Scanner scanner;
    private final PrintStream out;

    public DataGeter(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int askForInteger(String message) throws Exception {
        int i = 0;
        out.println(message);
        i = scanner.nextInt();
        return i;
    }

    public Category askForCategory(String message) {
        String strCategory;
        out.println(message);
        strCategory = scanner.nextLine();
        return Category.valueOf(strCategory);
    }

    public String askForString(String message) {
        String str;
        out.println(message);
        str = scanner.nextLine();
        return str;
    }

}
