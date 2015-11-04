package fpinscala.inkoltin.chapter3

fun main(args: Array<String>) {
    val listInt = List.create(1, 2, 3)
    println("sum of $listInt = ${List.sum(listInt)}")

    val listDouble = List.create(1.0, 2.0, 6.0)
    println("product of $listDouble = ${List.product(listDouble)}")

    val listDoubleZero = List.create(1.0, 0.0, 6.0)
    println("product of $listDoubleZero = ${List.product(listDoubleZero)}")

    val list = List.create(1, 1, 1)
    println("sum of $list = ${List.sum(list)}");

    println("-----")
    ex3_2();
    ex3_3();
    ex3_4();
    ex3_5();
    ex3_6();
}

fun ex3_2() {
    print("Ex 3.2 : ")
    val list = List.create(1, 2, 3)
    println("tail of $list = ${List.tail(list)}")
    println("-----")
}

fun ex3_3() {
    print("Ex 3.3 : ")
    val list = List.create(1, 2, 3)
    println("setHead 10 of $list = ${List.setHead(list, 10)}")
    println("-----")
}

fun ex3_4() {
    print("Ex 3.4 : ")
    val list = List.create(1, 2, 3, 4, 5, 6)
    println("drop 3 from $list = ${List.drop(list, 3)}")
    println("-----")
}

fun ex3_5() {
    print("Ex 3.5 : ")
    val list = List.create(2, 4, 6, 7, 8, 9)
    println("drop while n % 2 == 0 from $list = ${List.dropWhile(list, { n -> n % 2 == 0 })}")
    println("-----")
}

fun ex3_6() {
    print("Ex 3.6 : ")
    val list = List.create(2, 4, 6, 7, 8, 9)
    println("init of $list = ${List.init(list)}")
    println("-----")
}
