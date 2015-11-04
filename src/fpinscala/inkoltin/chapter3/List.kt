package fpinscala.inkoltin.chapter3


sealed class List<out T> {
    object Nil : List<Nothing>()

    class Cons<T>(val head: T, val tail: List<T>) : List<T>()

    override fun toString(): String = List.print(this)

    companion object Factory {
        fun <T> create(vararg ts: T): List<T> = when {
            ts.isEmpty() -> Nil
            else -> Cons(ts.first(), create(*ts.copyOfRange(1, ts.size)))
        }

        fun <T> print(list: List<T>): String = when (list) {
            is Nil -> "Nil"
            is Cons<T> -> "Cons(${list.head}, ${print(list.tail)})"
        }

        fun sum(ints: List<Int>): Int = when (ints) {
            is Nil -> 0
            is Cons<Int> -> ints.head + sum(ints.tail)
        }

        fun product(ds: List<Double>): Double = when (ds) {
            is Nil -> 1.0
            is Cons<Double> -> if (ds.head == 0.0) 0.0 else ds.head * product(ds.tail)
        }

        fun <T> tail(l: List<T>): List<T> = when (l) {
            is Nil -> throw IllegalStateException("Cannot get tail of empty list")
            is Cons<T> -> l.tail
        }

        fun <T> setHead(l: List<T>, h: T): List<T> = when (l) {
            is Nil -> throw IllegalStateException("Cannot set head of empty list")
            is Cons<T> -> Cons(h, l.tail)
        }

        fun <T> drop(l: List<T>, n: Int): List<T> = when (l) {
            is Nil -> throw IllegalStateException("Cannot drop of empty list")
            is Cons<T> -> if (n <= 0) l else drop(l.tail, n - 1)
        }

        fun <T> dropWhile(l: List<T>, f: (T) -> Boolean): List<T> = when (l) {
            is Nil -> throw IllegalStateException("Cannot drop of empty list")
            is Cons<T> -> if (f(l.head)) dropWhile(l.tail, f) else l
        }

        fun <T> init(l: List<T>): List<T> = when(l) {
            is Nil -> throw IllegalStateException("Cannot init empty list")
            is Cons<T> -> if(l.tail is Nil) Nil else Cons(l.head, init(l.tail))
        }

        fun <T,U> foldRight(l: List<T>, z: U): ((T,U) -> U) -> U = { f -> when(l) {
                is Nil -> z
                is Cons<T> -> f(l.head, foldRight(l.tail, z)(f))
            }
        }
    }

}

