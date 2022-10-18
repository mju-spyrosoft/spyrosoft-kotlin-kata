package _4_delegation

interface Greeter {
    fun greet()
}

class NiceGreeter() : Greeter {
    override fun greet() {
        println("hello kata")
    }
}

class RudeGreeter(): Greeter{
    override fun greet() {
        println("Oh its you, meh")
    }
}

class Derived(b: Greeter) : Greeter by b {
    fun fullConversation(){
        greet()
        println("BlahBlah")
    }
}

fun main() {
    val greeter = NiceGreeter()
    val rudeGreeter = RudeGreeter()

    Derived(greeter).greet()
    Derived(rudeGreeter).greet()

    Derived(greeter).fullConversation()
    Derived(rudeGreeter).fullConversation()

}
