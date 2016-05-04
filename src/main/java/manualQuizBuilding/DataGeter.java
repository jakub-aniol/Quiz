package manualQuizBuilding;

import settings.Category;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
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

    public int askForInteger(String message) throws InputMismatchException {
        int i = 0;
        out.println(message);
        i = scanner.nextInt();
        return i;
    }

    public Category askForCategory() {
        String strCategory;
        strCategory = scanner.next();
        return Category.valueOf(strCategory);
    }

    public Category askForCategory(String message) {
        String strCategory;
        out.println(message);
        strCategory = scanner.next();
        return Category.valueOf(strCategory);
    }

    public String askForString(String message) {
        String str;
        out.println(message);
        str = scanner.next();
        return str;
    }

    public boolean askForBoolean(String message) {
        String str;
        boolean isProper = true;
        out.println(message);
        str = scanner.next();
        if (str.equals("t") || str.equals("T"))
            return isProper;
        return !isProper;

    }

}
