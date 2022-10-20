package _2_null_safety

/**
 * Null safety built into language
 */
fun nullTypes() {
    val a: String;
    //a = null //Will not compile
    a = "test"


    val b: String?
    b = null;
}

//Can check for null explicitly
fun checkNull(text: String?) {
    //text.length                                       //Not allowed since text is nullable
    val l = if (text != null) text.length else -1   //Allowed, we performed explicit check
}


data class ProblematicOpinion(val content: String?) {
    fun nagBrain() = println(content)
    fun ruinMood(): String = "mood ruined"
}

data class NonProblematicOpinion(val opinion: String?)
data class Opinions(val problematicOpinion: ProblematicOpinion?, val nonProblematicOpinion: NonProblematicOpinion)
data class Person(val opinions: Opinions, val age: Int) {

}

//Safe calls
fun safeCalls(person: Person?) {
    //person.opinions                                   //Compilation error
    person?.opinions?.problematicOpinion?.nagBrain()   //Does nothing if null

    val problematicOpinions = person?.opinions?.problematicOpinion //null if null anywhere in chain

    //Nullable types also have additional methods available
    person.takeIf {
        if (it == null) {
            false
        } else {
            it.age > 10
        }
    }
}

//Elvis operator. Optional.orElse/orElseGet()
fun elivs(person: Person?) {
    person?.opinions?.problematicOpinion?.nagBrain()

    val problematicOpinion = person?.opinions?.problematicOpinion ?: ProblematicOpinion("I hate spyrosoft")
    //Optional.of(new Person(...)).map(Person::getOpinions).map(Opinion::getProblematicOpinion).)

    val fallback: Any = person?.opinions?.problematicOpinion ?: NonProblematicOpinion("I love spyrosoft")

    person?.opinions?.problematicOpinion
        ?: throw IllegalArgumentException("we only like people with problematic opinions")

    //Compiler knows method chain is safe after explicit check above
    val foo: ProblematicOpinion? = person.opinions.problematicOpinion

    //Can use any expresion after elvis operator, like return, if, when
    person?.opinions?.problematicOpinion ?: return
}

//Explicit null check. Optional.orElseThrow()
fun explicitNPECheck(person: Person?) {
    val l =
        person!!.opinions.problematicOpinion!!.content  //If person or problematicOpinion is null this will throw null pointer exception
}

//Java interOp can throw NPE exceptions
fun javaInterop() {
    //Both types are allowed, it's up to programmer to decide
    val imSneakyNonNull: String =
        ReturnNull.returnNull()     // allowed, may fail at runtime, compiler asserts this during assigment
    val imReturnNullable: String? = ReturnNull.returnNull()   // allowed, always works


}

fun main() {
    javaInterop()
}
