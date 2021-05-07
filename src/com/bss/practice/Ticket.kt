package com.bss.practice

data class Ticket(val companyName: String, val name: String, var date: String, var seatNumber: Int) {
    // toString(), hashCode(), equals(), copy()
}

class TicketNormal(val companyName: String, val name: String, var date: String, var seatNumber: Int) {
}

fun main() {
    val ticketA = Ticket("korAir", "bss", "2021-04-27", 100)
    val ticketB = TicketNormal("korAir", "bss", "2021-04-27", 100)

    println(ticketA) // Ticket(companyName=korAir, name=bss, date=2021-04-27, seatNumber=100)
    println(ticketB) // com.bss.practice.TicketNormal@506e1b77
}
