fun printReformat(
    str: String,
    upperCaseFirstLetter: Boolean = true,
    replaceSpacesWithUnderscore: Boolean = false,
): Unit {
    var result = str;
    if (upperCaseFirstLetter) {
        result = str.replaceFirstChar(Char::uppercase)
    }
    if (replaceSpacesWithUnderscore) {
        result = str.replace(" ", "_")
    }
    println(result)
}

fun main() {
    printReformat("hey")
    printReformat("hey spyro-soft", replaceSpacesWithUnderscore = true)
    printReformat("hey spyro-soft", upperCaseFirstLetter = true)
    printReformat("hey spyro-soft", true, true)
    //Many arguments of the same type can be confusing. Want to be more explicit?
    printReformat(
        "hey spyro-soft",
        upperCaseFirstLetter = true,
        replaceSpacesWithUnderscore = true
    )
}
