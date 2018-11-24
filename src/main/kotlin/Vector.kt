package pl.edu.amu.wmi.students.mario.arithmeticmodel

import java.util.*

class Vector(vararg val complexNumbers: ComplexNumber) {
    operator fun plus(other: Vector): Vector {
        return Vector(
            *complexNumbers
                .mapIndexed { index, complexNumber -> complexNumber + other.complexNumbers[index] }
                .toTypedArray())
    }

    operator fun minus(other: Vector): Vector {
        return Vector(
            *complexNumbers
                .mapIndexed { index, complexNumber -> complexNumber - other.complexNumbers[index] }
                .toTypedArray())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vector

        if (!complexNumbers.contentEquals(other.complexNumbers)) return false

        return true
    }

    override fun hashCode(): Int {
        return complexNumbers.contentHashCode()
    }

    fun scalarProduct(other: Vector): ComplexNumber {
        return complexNumbers
            .mapIndexed { index, complexNumber -> complexNumber * other.complexNumbers[index].conjugate()}
            .reduce{ a, b -> a + b}
    }

    operator fun times(scalar: ComplexNumber): Vector {
        return Vector(*complexNumbers.map { it * scalar }.toTypedArray())
    }

    override fun toString(): String {
        return Arrays.toString(complexNumbers)
    }

}
