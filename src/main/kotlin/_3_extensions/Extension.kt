package _3_extensions;

/**
 * Extension functions
 */
fun String.leetSpeech(): String {
    return this.replace("e", "3")   //This refers to string this is called on
        .replace("t", "7")
        .replace("b", "8");
}

/**
 * Class members always take priority
 */
class ExtensionFunctions {
    fun printHello() {
        println("hello")
    }
}

//Gets ignored
fun ExtensionFunctions.printHello() {
    println("actually goodbye")
}

// However different signature is ok
fun ExtensionFunctions.printHello(greeting: String) {
    println(greeting)
}

//Can write extension for nullable receiver
fun ExtensionFunctions?.sayGreetings(): String {
    if (this == null)
        return "Im actually null, i cant greet"
    return "hello"
}

/**
 * Extension properties
 */
val <T> List<T>.lastIndex: Int
    get() = size -1


fun main() {
    val leetSpeech = "I love kata, its the best".leetSpeech()
    println(leetSpeech)

    ExtensionFunctions().printHello()                             //hello
    ExtensionFunctions().printHello("Greeting traveler") //Greeting traveler

    val foo : ExtensionFunctions? = null;
    println(foo.sayGreetings())
}
