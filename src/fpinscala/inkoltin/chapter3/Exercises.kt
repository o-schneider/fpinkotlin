package fpinscala.inkoltin.chapter3

fun main(args: Array<String>) {
    val listInt = List.create(1, 2, 3)
    println("sum of List.create(1, 2, 3) = ${List.sum(listInt)}")

    val listDouble = List.create(1.0, 2.0, 6.0)
    println("product of List.create(1.0, 2.0, 6.0) = ${List.product(listDouble)}")

    val listDoubleZero = List.create(1.0, 0.0, 6.0)
    println("product of List.create(1.0, 0.0, 6.0) = ${List.product(listDoubleZero)}")

    val list = List.create(1, 1, 1)
    println("sum ${List.sum(list)}");
}