package _6_classes

class StackedBox(val box: List<Box>){
    override fun toString(): String {
        return "StackedBox(box=$box)"
    }
}

class Box(private val height: Int, private val width: Int, private val depth: Int) {
    operator fun plus(other: Box): StackedBox {
        return StackedBox(listOf(this, other))
    }

    operator fun times(other: Box): Box {
        return Box(this.height + other.height, this.width + other.width, other.height + other.height)
    }

    override fun toString(): String {
        return "Box(height=$height, width=$width, depth=$depth)"
    }
}

fun main() {
    val boxA = Box(10, 10, 10);
    val boxB = Box(10, 10, 10);

    val boxC = boxB + boxA
    val bigBox = boxB * boxA

    println(boxC)
    println(bigBox)
}
