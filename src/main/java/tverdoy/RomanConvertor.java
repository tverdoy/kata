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
}
