package common;

public class Validation {
    public static  String regexAge = "^([1-9][8-9])|([2-7][0-9])|(80)$";

    public static boolean checkAge(String  age){
        return age.matches(regexAge);
    }
}
