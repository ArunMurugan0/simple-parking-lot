package utils

class Counter {
    private var counter: Long = 0
    fun next(): Long {
        return ++counter
    }
}