package _3_extensions.exercises

/**
 *
 * Look at the java code and implement the extension functions
 *
 * Then implement the extension functions Int.r() and Pair.r() and make them convert Int and Pair to a RationalNumber.
 * Pair is a class defined in the standard library:
 *
 * data class Pair<out A, out B>(
 *  val first: A,
 *  val second: B
 *  )
 */

data class RationalNumber(val numerator: Int, val denominator: Int)

fun main() {
    val num = 1;
//    num.r()

    val pair = Pair(1, 2)
//    pair.r()
}
