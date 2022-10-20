package _4_delegation

import kotlin.reflect.KProperty


class PropertyGreeter() {

    var greeting: String by GreeterDelegate()

    fun greet() = println(greeting)
}

class GreeterDelegate() {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class LazyGreeter(){
    val greeting by lazy {
        brainComputeValue()
    }

    fun greet() = println(greeting)


    private fun brainComputeValue(): String {
        println("Brain working hard on the best greeting possible")
        return "Hello kata, you look beautiful today"
    }
}

fun main() {
    val propertyGreeter = PropertyGreeter()
    propertyGreeter.greet()
    propertyGreeter.greeting = "Hate kata"

    val lazyGreeter = LazyGreeter()
    lazyGreeter.greet()
    lazyGreeter.greet()
    lazyGreeter.greet()
}
