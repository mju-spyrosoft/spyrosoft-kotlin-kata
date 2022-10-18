package _1_basic_syntax

enum class Colors { RED, BLUE, GREEN }

//if can be expression
fun ifExpression(number: Int): String {
    return if (number % 2 == 0) "divisible by two"
    else if (number % 3 == 0) "divisible by three"
    else if (number % 5 == 0) "divisible by five"
    else "divisible by who knows what";
}

//Long branches of if statements can be replaced with when
fun whenExpressionAsIfElse(number: Int): String{
    return when {
        number % 2 == 0 -> "divisible by two"
        number % 3 == 0 -> "divisible by three"
        number % 5 == 0 -> "divisible by five"
        else -> "divisible by who knows what"
    }
}

//when as switch
fun whenAsSwitch(colors: Colors): String {
    return when (colors) {
        Colors.RED -> "Red"
        Colors.BLUE -> "Blue"
        Colors.GREEN -> "Green"
    }
}

//smart casting
fun smartCast(x: Any) {
    if (x is String) {      // x instanceof String
        print(x.length)     // x is automatically cast to String
    }

    //Switch on type
    when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
        is Colors -> print(x.name)
    }
}

//Exceptions
//Exceptions are always unchecked
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun tryStatement(message: String): String {
    return try {
        if(message.equals("throw")){
            throw IllegalArgumentException(message)
        }
        return "Legal"
    }catch (e : IllegalArgumentException) {
        return "Illegal"
    }
}
