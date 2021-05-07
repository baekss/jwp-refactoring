package com.bss.practice

object CarFactory {
    // static block에서 초기화 되어 생성됨(singleton)
    val cars: MutableList<Car> = mutableListOf<Car>()

    fun makeCar(horsePower: Int): Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }

    fun getSize(): Int {
        return this.cars.size
    }
}

data class Car(val horsePower: Int) {
}

fun main() {
    val car: Car = CarFactory.makeCar(10)
    val car2: Car = CarFactory.makeCar(200)

    println(CarFactory.getSize())
}
