fun main(args: Array<String>) {
    helloWorld()
    println(add(1, 4))
    println(maxBy(5, 10))
    println(maxBy2(12, 10))
    println(checkNumber(5L))
    println(showRank(75)) // return kotlin.Unit
}

fun helloWorld(): Unit {
    println("hello World")
}

fun add(a: Int, b: Int): Int {
    return a + b;
}
