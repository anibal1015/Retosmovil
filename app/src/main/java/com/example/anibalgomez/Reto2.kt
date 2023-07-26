package com.example.anibalgomez

import kotlin.random.Random

class Reto2 {
}


fun main() {
    val productos = mutableMapOf<String, Double>()
    var totalCompra = 0.0

    println("BIENVENIDO A SUPERMERCADOS NOE")
    println("Ingrese los productos que desea comprar (nombre y precio).")
    println("Para terminar de agregar productos, simplemente presione ENTER en lugar de ingresar un nombre.")

    // Ingresar productos y precios.
    while (true) {
        print("Producto (ENTER para terminar): ")
        val producto = readLine()!!.trim().toLowerCase()

        if (producto.isEmpty()) {
            break
        }

        print("Precio: ")
        val precio = readLine()!!.toDoubleOrNull()
        if (precio == null || precio <= 0) {
            println("Precio inválido. Intente nuevamente.")
            continue
        }

        var cantidad = 0
        while (true) {
            print("Cantidad: ")
            cantidad = readLine()!!.toIntOrNull() ?: continue
            if (cantidad <= 0) {
                println("Cantidad inválida. Intente nuevamente.")
            } else {
                break
            }
        }

        productos[producto] = precio * cantidad
        totalCompra += precio * cantidad
    }

    // Mostrar la lista de productos y el total de la compra.
    println("\nLista de productos y precios:")
    for ((producto, precioTotal) in productos) {
        println("$producto: $precioTotal")
    }
    println("Total de la compra: $totalCompra")

    // Check if the total purchase amount qualifies for discounts and draw
    if (totalCompra >= 60000) {
        // Verificar si la compra supera los 60,000 para aplicar el descuento y entrar al sorteo.
        val bolitaObtenida = Random.nextInt(1, 5) // 1: Roja, 2: Azul, 3: Amarilla, 4: Blanca

        // Cálculo del descuento.
        val descuento: Double
        val bolita: String
        when (bolitaObtenida) {
            1 -> {
                descuento = 0.1 // 10% de descuento
                bolita = "roja"
            }
            2 -> {
                descuento = 0.3 // 30% de descuento
                bolita = "azul"
            }
            3 -> {
                descuento = 0.5 // 50% de descuento
                bolita = "amarilla"
            }
            else -> {
                descuento = 1.0 // 100% de descuento (bolita blanca)
                bolita = "blanca"
            }
        }

        // Cálculo del valor final a pagar con descuento.
        val valorDescuento = totalCompra * descuento
        val valorFinalAPagar = totalCompra - valorDescuento

        // Mostrar resultados del descuento y cambio (si no es una bolita blanca).
        if (bolita != "blanca") {
            println("\n¡Has sacado la bolita $bolita!")
            println("Tu descuento es del ${(descuento * 100).toInt()}%.")
            println("El valor final a pagar es: $valorFinalAPagar")
            println("Por favor, ingresa el monto con el que vas a pagar:")
            val montoPago = readLine()!!.toDouble()

            if (montoPago >= valorFinalAPagar) {
                val cambio = montoPago - valorFinalAPagar
                println("Gracias por tu compra. Tu cambio es de: $cambio")
            } else {
                println("El monto ingresado no es suficiente para pagar la compra.")
            }
        } else {
            // Bolita blanca, no se solicita el monto a pagar ni se calcula el cambio.
            println("\n¡Has sacado la bolita blanca!")
            println("¡Felicidades! Tu compra es GRATIS.")
            println("Gracias por tu visita a Supermercados Noe.")
        }
    } else {

        println("\nTu compra es menor a 60,000, no aplicas para descuentos ni el sorteo.")
        println("Por favor, ingresa el monto con el que vas a pagar:")
        val montoPago = readLine()!!.toDouble()

        if (montoPago >= totalCompra) {
            val cambio = montoPago - totalCompra
            println("Gracias por tu compra. Tu cambio es de: $cambio")
        } else {
            println("El monto ingresado no es suficiente para pagar la compra.")
        }
    }
}
