package stringcalulator.view;

import java.util.Scanner;

public class InputView {
    public String inputValue(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }
}
