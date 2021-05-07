// 람다식명: 매개 변수와 리턴의 타입 = 매개 변수 -> 몸통 로직 작성
val square: (Int) -> (Int) = {number -> number * number}
val nameAge: (String, Int) -> String = {name: String, age: Int ->
    "my name is ${name} I'm ${age}"}

fun main() {
    println(square(12))
    println(nameAge("bss", 35))
    val comment = "bss said"
    println(comment.pizzaIsGood())
    println(extendsString("bss", 34))
    println(calculateGrade(99))

    val lambda = {number: Double -> number == 4.3213}
    println(invokeLambda(lambda))
    println(invokeLambda {it > 3.22})
}

// 확장함수
val pizzaIsGood: String.() -> String = {
    this + "Pizza is the best"
}

fun extendsString(name: String, age: Int): String {
    // String의 메소드(introduceMySelf) 추가
    val introduceMySelf: String.(Int) -> String = {
        "I am is ${this} and ${it} years old"
    }
    // introduceMySelf 메소드 안에서 name이 this가 됨
    return name.introduceMySelf(age)
}

val calculateGrade: (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

fun invokeLambda(lambda: (Double) -> Boolean): Boolean {
    return lambda(5.2343)
}
