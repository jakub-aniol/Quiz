package manualQuizBuilding;

import settings.Category;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ja on 01.05.16.
 */
public class DataGeter {
    private final Scanner scanner;
    private final PrintStream out;

    public DataGeter(InputStream in) {
        scanner = new Scanner(in);
        this.out = System.out;
    }

    public int askForInteger(String message) throws InputMismatchException {
        int ansNumber = 0;
        out.println(message);
        try {
            ansNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

    return ansNumber;
}
    public Category askForCategory(String message) {
        Category category =null;
        int numberCategory;
        out.println("Wybierz Kategorię z podanej listy");
        System.out.println("Podaj wartosc od 1 do "+ Arrays.asList(Category.values()).size());
        System.out.println(Arrays.asList(Category.values()));
        numberCategory = scanner.nextInt();

        System.out.println("numberCategoty: "+numberCategory);
        int i=Arrays.asList(Category.values()).size();
        System.out.println("i: "+i);

        while(numberCategory > i) {
            System.out.println("podałeś złą kategorię wpisz ponownie");
            numberCategory = scanner.nextInt();
        }

        System.out.println("lolo");

        for (Category a : Category.values()) {
            if (numberCategory == a.ordinal()+1) {
                category = a;
                break;
            }
        }

        assert category != null;
        System.out.println("Wybrales: "+category.toString());

        return category;
    }

    public String askForString(String message) {
        String str;
        out.println(message);
        str = scanner.next();
        return str;
    }

    public boolean askForBoolean(String message) {
        String str;
        boolean isTrue = true;
        out.println(message);
        str = scanner.next();
        if (str.equals("t") || str.equals("T"))
            return isTrue;
        return !isTrue;
    }
}
