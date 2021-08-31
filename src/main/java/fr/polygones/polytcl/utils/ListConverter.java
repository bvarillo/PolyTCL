package fr.polygones.polytcl.utils;

import java.util.Arrays;

public class ListConverter {
    public static Integer[] stringsToIntegers(String[] strings){
        Integer[] inegers = new Integer[strings.length];
        return Arrays.stream(strings).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    }
}
