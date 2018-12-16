package pl.edu.amu.wmi.students.mario.arithmeticmodel

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.sqrt

class VectorTest {

    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @MethodSource("addVectorsParams")
    fun `should add two vectors`(component1: V, component2: V, expectedResult: V) {
        assertEquals(expectedResult, component1 + component2)
    }

    @ParameterizedTest(name = "{index} => {0} - {1} = {2}")
    @MethodSource("subtractVectorsParams")
    fun `should subtract two vectors`(minuend: V, subtrahend: V, expectedResult: V) {
        assertEquals(expectedResult, minuend - subtrahend)
    }

    @ParameterizedTest(name = "{index} => {0} * {1} = {2}")
    @MethodSource("multiplyVectorByScalarParams")
    fun `should multiply by scalar`(vector: V, scalar: C, expectedResult: V) {
        assertEquals(expectedResult, vector * scalar)
    }

    @ParameterizedTest(name = "{index} => <{0}|{1}> = {2}")
    @MethodSource("scalarProductParams")
    fun `should return scalar product`(vector1: V, vector2: V, expectedResult: C) {
        assertEquals(expectedResult, vector1.scalarProduct(vector2))
    }

    @ParameterizedTest(name = "{index} => ||{0}|| = {1}")
    @MethodSource("normParams")
    fun `should return norm`(vector: V, expectedResult: Double) {
        assertEquals(expectedResult, vector.norm())
    }

    companion object {
        @JvmStatic
        fun addVectorsParams() = listOf(
            Arguments.of(V(C(1.0, 2.0), C(3.0, -4.0)), V(C(-1.0, -1.0), C(2.0, 1.0)), V(C(0.0, 1.0), C(5.0, -3.0)))
        )

        @JvmStatic
        fun subtractVectorsParams() = listOf(
            Arguments.of(V(C(1.0, 2.0), C(3.0, -4.0)), V(C(-1.0, -1.0), C(2.0, 1.0)), V(C(2.0, 3.0), C(1.0, -5.0)))
        )

        @JvmStatic
        fun multiplyVectorByScalarParams() = listOf(
            Arguments.of(V(C(1.0, 2.0), C(3.0, -4.0)), C(0.0, 1.0), V(C(-2.0, 1.0), C(4.0, 3.0)))
        )

        @JvmStatic
        fun scalarProductParams() = listOf(
            Arguments.of(V(C(-1.0, -1.0), C(2.0, 1.0)), V(C(1.0, 2.0), C(3.0, -4.0)), C(-1.0, 12.0))
        )

        @JvmStatic
        fun normParams() = listOf(
            Arguments.of(V(C(1.0, 1.0), C(3.0, -1.0)), 2.0 * sqrt(3.0)),
            Arguments.of(V(C(0.0, 1.0), C(0.0, 0.0)), 1),
            Arguments.of(V(C(0.0, 0.0), C(1.0, 0.0)), 1)
        )
    }
}
