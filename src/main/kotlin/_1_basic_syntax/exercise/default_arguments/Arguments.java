package _1_basic_syntax.exercise.default_arguments;

import java.util.List;

public class Arguments {

    public String foo(String name, int number, boolean toUpperCase) {
        String transformedName = toUpperCase ? name.toUpperCase() : name;
        return transformedName + number;
    }

    public String foo(String name, int number) {
        return foo(name, number, false);
    }

    public String foo(String name, boolean toUpperCase) {
        return foo(name, 42, toUpperCase);
    }

    public String foo(String name) {
        return foo(name, 42);
    }

    public static void useFoo() {
        var defaultArguments = new Arguments();
        List.of(
                defaultArguments.foo("a"),
                defaultArguments.foo("b", 1),
                defaultArguments.foo("c", true),
                defaultArguments.foo("d", 2, true)
        );

    }

    public static void main(String[] args) {
        Arguments.useFoo();
    }
}
