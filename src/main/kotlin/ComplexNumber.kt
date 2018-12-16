package pl.edu.amu.wmi.students.mario.arithmeticmodel

import kotlin.math.pow
import kotlin.math.sqrt

data class ComplexNumber(val realPart: Double, val imaginaryPart: Double) {
    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(realPart + other.realPart, imaginaryPart + other.imaginaryPart)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(realPart - other.realPart, imaginaryPart - other.imaginaryPart)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(
            realPart * other.realPart - imaginaryPart * other.imaginaryPart,
            realPart * other.imaginaryPart + imaginaryPart * other.realPart
        )
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        val nominator = this * other.conjugate()
        val denominator = other * other.conjugate()
        return ComplexNumber(
            nominator.realPart / denominator.realPart,
            nominator.imaginaryPart / denominator.realPart
        )
    }

    fun conjugate(): ComplexNumber = ComplexNumber(realPart, -imaginaryPart)

    fun modulus(): Double = sqrt(realPart.pow(2) + imaginaryPart.pow(2))


    override fun toString(): String {
        return "($realPart, $imaginaryPart)"
    }

    operator fun unaryMinus(): ComplexNumber = this * ComplexNumber(-1.0, 0.0)
}
