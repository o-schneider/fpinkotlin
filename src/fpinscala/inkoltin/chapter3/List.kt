package fpinscala.inkoltin.chapter3


sealed class List<out T> {
    object Nil : List<Nothing>()

    class Cons<T>(val head: T, val tail: List<T>) : List<T>()

    companion object Factory {
        fun sum(ints: List<Int>): Int = when (ints) {
            is Nil -> 0
            is Cons<Int> -> ints.head + sum(ints.tail)
        }

        fun product(ds: List<Double>): Double = when (ds) {
            is Nil -> 1.0
            is Cons<Double> -> if (ds.head == 0.0) 0.0 else ds.head * product(ds.tail)
        }

        fun <T> create(vararg ts: T): List<T> = when {
            ts.isEmpty() -> Nil
            else -> Cons(ts.first(), create(*ts.copyOfRange(1, ts.size)))
        }
        
    }

}

