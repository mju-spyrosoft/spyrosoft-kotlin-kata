package _4_delegation

import kotlin.reflect.KProperty


class PropertyGreeter() {

    var greeting: String by GreeterDelegate()

    public fun greet() = println(greeting)
}

class GreeterDelegate() {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun main() {
    PropertyGreeter().greet()
    PropertyGreeter().greeting = "Hate kata"
}
