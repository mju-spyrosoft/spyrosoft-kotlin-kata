package _4_delegation;

import static java.sql.DriverManager.println;

interface GreeterJ {
    public void greet();
}


class NiceGreeterJ implements GreeterJ {
    public void greet() {
        System.out.println("hello kata");
    }
}

class RudeGreeterJ implements GreeterJ {
    public void greet() {
        System.out.println("Oh its you, meh");
    }
}

class DerivedJ implements GreeterJ {

    private final GreeterJ greeterJ;

    public DerivedJ(GreeterJ greeterJ) {
        this.greeterJ = greeterJ;
    }

    public void fullConversation() {
        greeterJ.greet();
        println("BlahBlah");
    }

    @Override
    public void greet() {
        greeterJ.greet();
    }
}

class Delegation{
    public static void main(String[] args) {
        var rudeGreeterJ = new RudeGreeterJ();
        var niceGreeterJ = new NiceGreeterJ();

        new DerivedJ(rudeGreeterJ).greet();
        new DerivedJ(niceGreeterJ).greet();

        new DerivedJ(rudeGreeterJ).fullConversation();
        new DerivedJ(niceGreeterJ).fullConversation();
    }
}
