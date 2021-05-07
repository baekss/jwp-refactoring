package com.bss.practice

class Book private constructor(val id: Int, val name: String) {

    // BookFactory라는 static inner class가 정의됨
    companion object BookFactory: IdProvider {

        override fun getId(): Int {
            return 777
        }

        val myBook = "name"

        fun create() = Book(0, myBook)
    }
}

interface IdProvider {
    fun getId(): Int
}

fun main(args: Array<String>) {
    val book: Book = Book.BookFactory.create();

    val bookId = Book.getId()
    println("${book.id} ${book.name}")
    println(bookId)
}
