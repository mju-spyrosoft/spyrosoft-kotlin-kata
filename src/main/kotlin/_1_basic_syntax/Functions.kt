package _1_basic_syntax

//With body
fun squared(x: Int): Int {
    //x = 10; // wont compile
    return x * x
}

//As single-expression
fun squared2(x: Int): Int = x * x

//Something more complex
fun beginsWithCapitalA(x: List<String>): Int =
    x.asSequence()
        .filter { it.startsWith("A") }
        .count()

//Return type cant be omitted in single-expression functions
fun squaredWithoutType(x: Int) = x*x

/* won't compile, no return type on body function
fun beginsWithCapitalA2(x: List<String>){
    return x.asSequence()
        .filter { it.startsWith("A") }
        .count()
}
 */

//Void return type from java is "Unit"
fun printSquared(x: Int): Unit = println(x * x)

//Local functions from like in js
fun nestedFunction(){
    val x = 1;

    fun imNested(){
        //I can access variables from outside scope
        println("im nested and im reading: $x")
    }
    imNested()
}

//Generics
fun <T> singletonList(item: T): List<T> = listOf(item)
