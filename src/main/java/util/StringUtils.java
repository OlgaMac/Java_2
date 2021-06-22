package util;

import reflexion.annatation.RandomString;

import java.util.Random;

public class StringUtils {
    public StringUtils() {}
    public static String generateString(int length){
        Random random = new Random();
        //65-90
        //97-122
        String s = " ";
        for (int i = 0; i < length; i++) {
            s += Character.toString((char) random.nextInt(122-97)+97);
        }
        return s;
    }
}
