package com.example.anibalgomez

class Reto3 {
}

class Carro(val marca: String, val modelo: String, val año: Int)

fun main() {
    val listaCarros = mutableListOf<Carro>()
    var hayAutosIngresados = false // Variable para verificar si se han ingresado autos

    do {
        println("=== Menú de opciones ===")
        println("1. Insertar nuevo auto")

        // Verificar si hay autos ingresados antes de mostrar las opciones 2, 3, 4 y 5
        if (hayAutosIngresados) {
            println("2. Mostrar todos los autos")
            println("3. Buscar un auto por marca")
            println("4. Modificar un auto existente")
            println("5. Eliminar un auto existente")
        }

        println("6. Salir")

        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                val carro = crearCarroDesdeConsola()
                listaCarros.add(carro)
                hayAutosIngresados = true // Actualizar la variable al ingresar un auto
                println("Auto agregado exitosamente.")
            }
            2 -> {
                if (hayAutosIngresados) {
                    mostrarTodosLosCarros(listaCarros)
                } else {
                    println("No se ha ingresado ningún auto.")
                }
            }
            3 -> {
                if (hayAutosIngresados) {
                    print("Ingrese la marca del auto a buscar: ")
                    val marcaBuscada = readLine()?.trim()
                    buscarCarrosPorMarca(listaCarros, marcaBuscada)
                } else {
                    println("No se ha ingresado ningún auto.")
                }
            }
            4 -> {
                if (hayAutosIngresados) {
                    print("Ingrese la posición del auto a modificar (1-${listaCarros.size}): ")
                    val indiceCarroModificar = readLine()?.toIntOrNull()?.let { it - 1 }

                    if (indiceCarroModificar in 0 until listaCarros.size) {
                        val carroModificado = crearCarroDesdeConsola()
                        listaCarros[indiceCarroModificar!!] = carroModificado
                        println("El auto en la posición ${indiceCarroModificar + 1} ha sido modificado.")
                    } else {
                        println("Posición inválida. No existe un auto en la posición ${indiceCarroModificar?.let { it + 1 }}.")
                    }
                } else {
                    println("No se ha ingresado ningún auto.")
                }
            }
            5 -> {
                if (hayAutosIngresados) {
                    print("Ingrese la posición del auto a eliminar (1-${listaCarros.size}): ")
                    val indiceCarroEliminar = readLine()?.toIntOrNull()?.let { it - 1 }

                    if (indiceCarroEliminar in 0 until listaCarros.size) {
                        listaCarros.removeAt(indiceCarroEliminar!!)
                        println("El auto en la posición ${indiceCarroEliminar + 1} ha sido eliminado.")

                        // Verificar si la lista está vacía después de eliminar un auto
                        if (listaCarros.isEmpty()) {
                            hayAutosIngresados = false
                        }
                    } else {
                        println("Posición inválida. No existe un auto en la posición ${indiceCarroEliminar?.let { it + 1 }}.")
                    }
                } else {
                    println("No se ha ingresado ningún auto.")
                }
            }
            6 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción inválida. Por favor, seleccione una opción válida.")
        }
        println()
    } while (true)
}



fun crearCarroDesdeConsola(): Carro {
    print("Ingrese la marca del auto: ")
    val marca = readLine()?.trim()

    print("Ingrese el modelo del auto: ")
    val modelo = readLine()?.trim()

    print("Ingrese el año del auto: ")
    val año = readLine()?.toIntOrNull() ?: 0

    return Carro(marca ?: "", modelo ?: "", año)
}

fun mostrarTodosLosCarros(listaCarros: List<Carro>) {
    if (listaCarros.isNotEmpty()) {
        println("Lista de autos:")
        listaCarros.forEachIndexed { index, carro ->
            println("Auto ${index + 1}: Marca: ${carro.marca}, Modelo: ${carro.modelo}, Año: ${carro.año}")
        }
    } else {
        println("La lista de autos está vacía.")
    }
}

fun buscarCarrosPorMarca(listaCarros: List<Carro>, marcaBuscada: String?) {
    if (marcaBuscada != null && marcaBuscada.isNotBlank()) {
        val carrosEncontrados = listaCarros.filter { it.marca == marcaBuscada }
        if (carrosEncontrados.isNotEmpty()) {
            println("Autos encontrados con la marca '$marcaBuscada':")
            carrosEncontrados.forEachIndexed { index, carro ->
                println("Auto ${index + 1}: Modelo: ${carro.modelo}, Año: ${carro.año}")
            }
        } else {
            println("No se encontraron autos con la marca '$marcaBuscada'.")
        }
    } else {
        println("Marca inválida. Por favor, ingrese una marca válida.")
    }
}