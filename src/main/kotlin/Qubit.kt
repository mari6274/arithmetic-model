package pl.edu.amu.wmi.students.mario.arithmeticmodel

import kotlin.math.pow
import kotlin.math.sqrt

class Qubit(private val alpha: ComplexNumber, private val beta: ComplexNumber) {

    fun x() = Qubit(beta, alpha)

    fun y() = Qubit(alpha * ComplexNumber(0.0, 1.0), ComplexNumber(0.0, 1.0))

    fun z() = Qubit(alpha, -beta)

    fun h() = Qubit((alpha + beta) / ComplexNumber(sqrt(2.0), 0.0), (alpha - beta) / ComplexNumber(sqrt(2.0), 0.0))

    fun makeMeasurement() = Measurement(alpha.modulus().pow(2), beta.modulus().pow(2))

    class Measurement(val p0: Double, val p1: Double)
}