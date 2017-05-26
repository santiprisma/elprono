package net.deveando.elprono.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alumno on 26/5/2017.
 */

public class UtilHelper {

    public static boolean validName(String name) {
        return !(name == null || name.trim().isEmpty() || name.length() < 3);
    }

    public static boolean validMail(String mail) {
        String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

}
