import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    nullCheck()
    ignoreNulls("BSS")
}

fun nullCheck() {
    // NonNull
    var name: String = "baek"

    // Nullable
    var nullName: String? = null

    // name은 NonNull이 확실하여 String api 호출 가능
    var nameInUpperCase: String = name.toUpperCase()

    // nullName은 null이므로 toUpperCase를 실행하지 않는다
    var nullNameInUpperCase: String? = nullName?.toUpperCase()
    println(nullNameInUpperCase)

    var lastName: String? = null
    // lastName이 null이므로 no last name으로 대체된다
    var fullName: String = name + (lastName?: " no last name")
    println(fullName)

    // lastName이 null이므로 exception발생시킨다
    try {
        lastName?: throw IllegalArgumentException("no last name")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun ignoreNulls(str: String?) {
    // Nullable값이지만 null이 아닌 것이 확실할 때 String api를 null체크 없이 사용
    val mNotNull: String = str!!
    println(mNotNull.toLowerCase())

    val email: String? = "bss@gmail.com"
    email?.let{
        // email이 null이 아닐때 실행 it은 요소를 가리킴
        println("my email is ${email}, ${it}")
    }
}
