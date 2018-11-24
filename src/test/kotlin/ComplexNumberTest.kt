package pl.edu.amu.wmi.students.mario.arithmeticmodel

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.sqrt

class ComplexNumberTest {

    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @MethodSource("addComplexParams")
    fun `should add two complex numbers`(component1: C, component2: C, expectedResult: C) {
        assertEquals(expectedResult, component1 + component2)
    }

    @ParameterizedTest(name = "{index} => {0} - {1} = {2}")
    @MethodSource("subtractComplexParams")
    fun `should subtract two complex numbers`(minuend: C, subtrahend: C, expectedResult: C) {
        assertEquals(expectedResult, minuend - subtrahend)
    }

    @ParameterizedTest(name = "{index} => {0}  * {1} = {2}")
    @MethodSource("multiplyComplexParams")
    fun `should multiply two complex numbers`(factor1: C, factor2: C, expectedResult: C) {
        assertEquals(expectedResult, factor1 * factor2)
    }

    @ParameterizedTest(name = "{index} => {0} / {1} = {2}")
    @MethodSource("divideComplexParams")
    fun `should divide two complex numbers`(dividend: C, divider: C, expectedResult: C) {
        assertEquals(expectedResult, dividend / divider)
    }


    @ParameterizedTest(name = "{index} => conjugate({0}) = {1}")
    @MethodSource("conjugateComplexParams")
    fun `should conjugate complex number`(complexNumber: C, expectedResult: C) {
        assertEquals(expectedResult, complexNumber.conjugate())
    }

    @ParameterizedTest(name = "{index} => |{0}| = {1}")
    @MethodSource("modulusComplexParams")
    fun `should return complex number modulus`(complexNumber: C, expectedResult: Double) {
        assertEquals(expectedResult, complexNumber.modulus())
    }

    @ParameterizedTest
    @MethodSource("equalComplexParams")
    fun `two complex numbers should be equal if real part and imaginary part are equal`(
        complexNumber1: C,
        complexNumber2: C
    ) {
        assertTrue(complexNumber1 == complexNumber2)
    }

    @ParameterizedTest
    @MethodSource("notEqualComplexParams")
    fun `two complex numbers should not be equal if real part and imaginary part are not equal`(
        complexNumber1: C,
        complexNumber2: C
    ) {
        assertFalse(complexNumber1 == complexNumber2)
    }

    companion object {
        @JvmStatic
        fun addComplexParams() = listOf(
            Arguments.of(C(2.0, 3.0), C(1.0, 2.0), C(3.0, 5.0))
        )

        @JvmStatic
        fun subtractComplexParams() = listOf(
            Arguments.of(C(2.0, 3.0), C(1.0, 2.0), C(1.0, 1.0))
        )

        @JvmStatic
        fun multiplyComplexParams() = listOf(
            Arguments.of(C(2.0, 3.0), C(2.0, 2.0), C(-2.0, 10.0))
        )

        @JvmStatic
        fun divideComplexParams() = listOf(
            Arguments.of(C(2.0, 3.0), C(2.0, 2.0), C(5.0 / 4.0, 1.0 / 4.0))
        )

        @JvmStatic
        fun conjugateComplexParams() = listOf(
            Arguments.of(C(2.0, 3.0), C(2.0, -3.0))
        )

        @JvmStatic
        fun modulusComplexParams() = listOf(
            Arguments.of(C(2.0, 2.0), 2.0 * sqrt(2.0))
        )

        @JvmStatic
        fun equalComplexParams() = listOf(
            Arguments.of(C(2.0, 2.0), C(2.0, 2.0)),
            Arguments.of(C(2.0, 0.0), C(2.0, 0.0)),
            Arguments.of(C(10.1, 8.2), C(10.1, 8.2))
        )

        @JvmStatic
        fun notEqualComplexParams() = listOf(
            Arguments.of(C(2.0, 2.0), C(2.0, 1.0)),
            Arguments.of(C(2.0, 2.0), C(1.0, 1.0)),
            Arguments.of(C(2.0, 2.0), C(4.0, 4.0))
        )
    }
}