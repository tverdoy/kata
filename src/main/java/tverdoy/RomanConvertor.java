package tverdoy;

import java.util.Set;

public class RomanConvertor {
    private static final Set<String> romansNumbers = Set.of("I", "V", "X", "L", "C", "D", "M");

    protected static boolean isRoman(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (char symbol : input.toCharArray()) {
            if (!romansNumbers.contains(String.valueOf(symbol))) {
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
            result += romanCharToArabic(symbol);
        }

        return result;
    }

    private static int romanCharToArabic(char symbol) {
        switch (symbol) {
            case 'I' -> {
                return 1;
            }
            case 'V' -> {
                return 5;
            }
            case 'X' -> {
                return 10;
            }
            case 'L' -> {
                return 50;
            }
            case 'C' -> {
                return 100;
            }
            case 'D' -> {
                return 500;
            }
            case 'M' -> {
                return 1000;
            }
        }

        throw new Error("Unknow roman symbol");
    }
}
