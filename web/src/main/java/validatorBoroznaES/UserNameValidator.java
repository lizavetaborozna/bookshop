package validatorBoroznaES;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameValidator {

    public static List<String> checkUserName(String username, List<String> errors) {
        if (username.trim().length() > 15 || username.trim().length() < 3) {
            errors.add("Логин не валиден. Введите от 3 до 15 символов.");
        }
        if (!checkWithRegExp(username.trim())) {
            errors.add("Логин не валиден.Ввeдите только буквы и числа.");
        }
        return errors;
    }

    public static boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,15}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
