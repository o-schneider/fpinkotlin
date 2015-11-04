package fpinscala.inkoltin.chapter2

fun <T,U,V> curry(f:(T,U) -> V): (T) -> ((U) -> V) = { t -> { u -> f(t,u)} }
