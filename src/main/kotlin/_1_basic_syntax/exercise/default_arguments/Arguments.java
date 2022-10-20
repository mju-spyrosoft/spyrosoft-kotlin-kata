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

    public void useFoo() {
        List.of(
                this.foo("a"),
                this.foo("b", 1),
                this.foo("c", true),
                this.foo("d", 2, true)
        );

    }

    public static void main(String[] args) {
        var arguments = new Arguments();
        arguments.useFoo();
    }
}
