import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;


public class TelefonNumberDop {
    public static void main(String[] args) {

        Pattern p = compile("^(7)[\\d]{10}$", Pattern.UNICODE_CASE);
        String input = "";

        System.out.println("Введите телефонный номер: ");
        try {
            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        input = input.replaceAll("[^\\d.]", "");
        if (input.startsWith("8")) {
            input = input.replaceFirst("8", "7");
        }
        if (input.length() != 11) {
            System.out.println("Amount of digits is not equals 11.");
            return;
        }
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("\"" + input + "\" - Правильный ввод");
        } else {

            input.replaceAll("/^\\+?(?=(.*?\\d){10})[-\\d()]+$/", "");
            System.out.println(input);

            //System.out.println("\"" + m + "\" - Отредактированный ввод");
        }
    }
}