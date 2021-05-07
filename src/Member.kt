open class Member constructor(val name: String = "Anonymous") {
    var age: Int = 0

    constructor(name: String, age: Int): this(name) {
        this.age = age
        println("부 생성자 실행")
    }

    init {
        println("주 생성자 실행")
    }
    fun speakName(): String {
        return name
    }

    fun speakNameAge(): String {
        return "my name is ${name} and ${age} years old."
    }

    open fun move(): String {
        return "${name} is moving"
    }
}

class Client: Member("비회원", 30) {
    override fun move(): String {
        return "${name} is fast moving"
    }
}

fun main(args: Array<String>) {
    // 생성자 첫번째 인자값을 이미 Anonymous로 할당하여 NoArgument 생성자로도 객체 생성 가능
    val nonMember: Member = Member()
    println(nonMember.speakName()) // Anonymous 출력

    val member: Member = Member("mark")
    println(member.speakName()) // mark

    val subMember: Member = Member("tom", 30)
    println(subMember.speakNameAge())
    println(subMember.age)

    val client: Member = Client()
    println(client.move())
}
