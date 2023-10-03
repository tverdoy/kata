package tverdoy;

import java.util.Map;
import java.util.TreeMap;

public class RomanConvertor {
    private final static TreeMap<Integer, String> romans = new TreeMap<>();
    static {

        romans.put(1000, "M");
        romans.put(900, "CM");
        romans.put(500, "D");
        romans.put(400, "CD");
        romans.put(100, "C");
        romans.put(90, "XC");
        romans.put(50, "L");
        romans.put(40, "XL");
        romans.put(10, "X");
        romans.put(9, "IX");
        romans.put(5, "V");
        romans.put(4, "IV");
        romans.put(1, "I");

    }

    protected static boolean isRoman(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (char symbol : input.toCharArray()) {
            if (!romans.containsValue(String.valueOf(symbol))) {
                return false;
            }
        }

        return true;
    }

    protected static int toArabic(String roman) {
        String formatRoman = roman.replace("IV","IIII");
        formatRoman = formatRoman.replace("IX","VIIII");
        formatRoman = formatRoman.replace("XL","XXXX");
        formatRoman = formatRoman.replace("XC","LXXXX");
        formatRoman = formatRoman.replace("CD","CCCC");
        formatRoman = formatRoman.replace("CM","DCCCC");

        int result = 0;

        for (char symbol : formatRoman.toCharArray()) {
            for( Map.Entry<Integer, String> entry : romans.entrySet() ){
                if(entry.getValue().equals(String.valueOf(symbol))){
                    result += entry.getKey();
                }
            }
        }

        return result;
    }

    protected static String toRoman(int number) {
        int l =  romans.floorKey(number);
        if ( number == l ) {
            return romans.get(number);
        }

        return romans.get(l) + toRoman(number-l);
    }
}
