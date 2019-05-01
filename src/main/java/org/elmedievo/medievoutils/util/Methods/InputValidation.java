package org.elmedievo.medievoutils.util.Methods;

public class InputValidation {
    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
