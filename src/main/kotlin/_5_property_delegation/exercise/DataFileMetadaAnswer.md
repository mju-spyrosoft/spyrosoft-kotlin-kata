```kotlin
class DataFileMetadata(private val file: File) {

    val contents: String by lazy {
        println("loading contents")
        loadFromFile()
    }

    @Throws(IOException::class) // Annotation  is not needed
    private fun loadFromFile(): String {
        return String(Files.readAllBytes(file.toPath()))
    }

}
```
