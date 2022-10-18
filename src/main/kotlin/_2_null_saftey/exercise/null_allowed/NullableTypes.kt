package _1_basic_syntax.exercise.nullable_types

/**
 * Look at sendMessageToClient in NullableTypes.java,
 * Using kotlin built in null safety it can be rewritten to single if statement
 */
fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    TODO()
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

fun main() {
    val client = Client(PersonalInfo("email"))
    val anonymousMailer = object : Mailer {
        override fun sendMessage(email: String, message: String) = println("Sending message to $email")
    }
    sendMessageToClient(client, "hey kata", anonymousMailer)
}
