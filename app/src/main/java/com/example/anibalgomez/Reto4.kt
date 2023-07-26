package com.example.anibalgomez


import java.util.Random

class Reto4 {
}
class Nequi {
    private val phoneNumber = "3024580736" // NUMERO DE CELULAR PARA INGRESO
    private val pin = "1234" // CLAVE PARA INGRESO
    private var saldoDisponible = 4500.0

    fun acceder() {
        var intentos = 3

        while (intentos > 0) {
            println("Ingrese número de celular:")
            val userInputPhone = readLine()

            println("Ingrese clave de 4 dígitos:")
            val userInputPin = readLine()

            if (userInputPhone == phoneNumber && userInputPin == pin) {
                println("¡Bienvenido(a) al Nequi!")
                mostrarSaldo()
                mostrarOpciones()
                return
            } else {
                intentos--
                if (intentos > 0) {
                    println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes $intentos intentos más.")
                } else {
                    println("¡Upps! No te quedan más intentos. La sesión se cerrará.")
                }
            }
        }
    }

    private fun mostrarSaldo() {
        println("Saldo disponible: $saldoDisponible")
    }

    private fun mostrarOpciones() {
        while (true) {
            println("\nOpciones disponibles:")
            println("1. Saca (Retirar dinero)")
            println("2. Envía (Enviar dinero)")
            println("3. Recarga (Recargar saldo)")
            println("4. Salir")

            val opcion = readLine()?.toIntOrNull()

            when (opcion) {
                1 -> saca()
                2 -> envia()
                3 -> recarga()
                4 -> {
                    println("Gracias por usar Nequi. ¡Hasta luego!")
                    return
                }
                else -> println("Opción no válida, por favor intente nuevamente.")
            }
        }
    }

    private fun saca() {
        println("Escoge una opción:")
        println("1. Cajero")
        println("2. Punto físico")

        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1, 2 -> {
                if (saldoDisponible < 2000) {
                    println("No te alcanza para hacer el retiro.")
                } else {
                    println("Ingrese el monto a retirar:")
                    val montoRetiro = readLine()?.toDoubleOrNull()

                    if (montoRetiro != null && montoRetiro <= saldoDisponible) {
                        saldoDisponible -= montoRetiro
                        println("Retiro exitoso. Su saldo actual es: $saldoDisponible")
                        generarCodigoRetiro()
                    } else {
                        println("El monto ingresado no es válido o excede su saldo disponible.")
                    }
                }
            }
            else -> println("Opción no válida.")
        }
    }

    private fun generarCodigoRetiro() {
        val random = Random()
        val codigoRetiro = random.nextInt(900000) + 100000
        println("Su código de retiro de 6 dígitos es: $codigoRetiro")
    }

    private fun envia() {
        println("Ingrese el número de teléfono al que desea enviar dinero:")
        val phoneNumberToSend = readLine()

        println("Ingrese el valor a enviar:")
        val valorEnviar = readLine()?.toDoubleOrNull()

        if (valorEnviar != null && valorEnviar <= saldoDisponible) {
            saldoDisponible -= valorEnviar
            println("Se ha enviado el dinero correctamente. Su saldo actual es: $saldoDisponible")
        } else {
            println("No es posible enviar el dinero. Verifique el valor ingresado o su saldo disponible.")
        }
    }

    private fun recarga() {
        println("Ingrese el valor a recargar:")
        val valorRecarga = readLine()?.toDoubleOrNull()

        if (valorRecarga != null) {
            println("¿Desea confirmar la recarga de $valorRecarga? (s/n)")
            val confirmacion = readLine()

            if (confirmacion?.equals("s", ignoreCase = true) == true) {
                saldoDisponible += valorRecarga
                println("Recarga exitosa. Su saldo actual es: $saldoDisponible")
            } else {
                println("La recarga ha sido cancelada.")
            }
        } else {
            println("Valor de recarga no válido.")
        }
    }
}

fun main() {
    val nequi = Nequi()
    nequi.acceder()
}