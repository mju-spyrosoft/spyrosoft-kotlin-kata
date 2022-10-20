package _6_classes

class Person public constructor(val firstName: String, lastName: String) {

    private val parsedLastname: String
    private val fullName: String
    public var age: Int? = null
        get() {
            println("Getting value")
            return field?.times(2)
        }
        set(value) {
            println("Setting value")
            field = value
        }


    init {
        parsedLastname = lastName.replaceFirstChar { it.uppercase() }
        fullName = firstName + "" + parsedLastname

        println("Init block")
    }

    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
        println("secondary")
        this.age = age
    }

    fun tellAge(){
        println(age)
    }
}

fun main() {
    Person("Kata", "Smith");
    Person("Kata", "Smith").firstName
//    DifferentPerson("Kata", "Smith").lastName

    val person = Person("Kata", "Smith")
    person.age = 20;
    person.tellAge()
}
