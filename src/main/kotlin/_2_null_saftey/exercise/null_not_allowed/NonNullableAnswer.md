```kotlin
package _1_basic_syntax.exercise.nullable_types.null_not_allowed

fun sendMessageToClient(
    client: Client, message: String, mailer: Mailer
) {
    val email = client.personalInfo.email
    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo)
class PersonalInfo(val email: String)

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
```
