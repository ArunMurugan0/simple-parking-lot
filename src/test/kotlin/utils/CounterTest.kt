package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CounterTest {

    @Test
    fun `it should increment counter by one each time next() is called`() {
        val counter = Counter()

        for (i  in 1L..100) {
            assertEquals(i, counter.next())
        }
    }

    @Test
    fun `it should not share state across instances`() {
        val counterOne = Counter()
        val counterTwo = Counter()

        assertEquals(1, counterOne.next())
        assertEquals(1, counterTwo.next())
    }
}