package _3_extensions.exercises;

import java.util.AbstractMap;

public class ExtensionFunctionUtils {

    private static RationalNumber r(Integer i){
        return new RationalNumber(i, 1);
    }

    private static RationalNumber r(AbstractMap.SimpleEntry<Integer, Integer> entry){
        return new RationalNumber(entry.getKey(), entry.getValue());
    }

    public static void main(String[] args) {
        var i = 1;

        ExtensionFunctionUtils.r(i);

        var entry = new AbstractMap.SimpleEntry<>(1, 2);

        ExtensionFunctionUtils.r(entry);

    }

}

/**
 * You cant modify Rational number, it's not part of your codebase
 */
record RationalNumberJ(Integer numerator, Integer denominator){}
