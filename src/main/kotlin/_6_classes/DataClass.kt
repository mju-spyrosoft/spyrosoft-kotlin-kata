package _6_classes

data class Pet(val name: String, var age: Int) {}

fun getPets(): List<Pet> {
    return listOf(Pet("Alice", 29), Pet("Bob", 31))
}

fun comparePeople(): Unit {
    val p1 = Pet("Alice", 29)
    val p2 = Pet("Alice", 29)
    println(p1 == p2 ) // should be true

    val newP1 = p1.copy(name = "Bob")

    println(newP1 == p2 ) // should be false
}

fun main() {
    comparePeople()
}
