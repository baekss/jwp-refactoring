fun main(args: Array<String>) {
    array()
    forAndWhile()
}

fun array() {
    val array: Array<Int> = arrayOf(1, 2, 3)
    val list: List<Int> = listOf(10, 11, 12)

    val array2: Array<Any> = arrayOf(1, "b", 3.4f)
    val list2: List<Any> = listOf(10, "c", 11L)

    array[0] = 3
    // list[0] = 2 // unmodifiableList

    var arrayList: ArrayList<Int> = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList.set(0, 30)
}

fun forAndWhile() {
    val students: ArrayList<String> = arrayListOf("mark", "tom", "mike")

    for ((index: Int, name: String) in students.withIndex()) {
        println("${index + 1}번째 학생 : ${name}")
    }
}
