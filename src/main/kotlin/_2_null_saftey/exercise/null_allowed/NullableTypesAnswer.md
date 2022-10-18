```kotlin
fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val personalInfo = client?.personalInfo
    val email = personalInfo?.email

    if (email == null || message == null) return

    mailer.sendMessage(email, message)
}
```
