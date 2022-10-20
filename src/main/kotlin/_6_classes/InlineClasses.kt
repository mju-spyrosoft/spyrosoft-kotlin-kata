package _6_classes


//https://kotlinlang.org/docs/inline-classes.html
@JvmInline
value class Email(private val email: String) {
    init {
        if (email.length < 3) throw IllegalStateException("Email must be longer than 3 characters")
    }

    val length: Int
        get() = email.length


    fun getDomain(): String {
        return email.split("@").last()
    }
}


fun main() {
    val email = Email("mail@kata.com")
    val domain = email.getDomain()
    println(domain)
    println(email.length)
}
