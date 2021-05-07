fun maxBy(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxBy2(a: Int, b: Int): Int = if (a > b) a else b

fun checkNumber(score: Long): Boolean {
    when (score) {
        0L -> println("this is 0")
        1L -> println("this is 1")
        2L, 3L -> println("this is 2 or 3")
    }

    var b: Boolean = when (score) {
        1L -> true
        2L -> true
        else -> false
    }

    return b
}

fun showRank(rank: Int) {
    when (rank) {
        in 90..100 -> println("상위")
        in 70..98 -> println("중위")
        else -> println("기타")
    }
}
