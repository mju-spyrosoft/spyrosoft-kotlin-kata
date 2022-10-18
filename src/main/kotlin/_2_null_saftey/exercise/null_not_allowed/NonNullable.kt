package _2_null_saftey.exercise.null_not_allowed

/**
 * Java programmer that wrote null_allowed had revelation about why nulls are bad and decided to remove them from his codebase.
 *
 * Disallow nulls in bellow code and compare it to NonNullable java code
 */
fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val personalInfo = client?.personalInfo
    val email = personalInfo?.email

    if (email == null || message == null) return

    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

fun main() {
    val personalInfo = PersonalInfo(null);  //Should fail at compilation
    val client = Client(null)          //Should fail at compilation
    val anonymousMailer = object : Mailer {
        override fun sendMessage(email: String, message: String) = println("Sending message to $email")
    }
    sendMessageToClient(null, "hey kata", anonymousMailer)  //Should fail at compilation
    sendMessageToClient(client, null, anonymousMailer)            //Should fail at compilation



}
