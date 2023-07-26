package com.example.anibalgomez

class Reto1 {
}

fun main() {

    println("juego de dados")
    println("en este juego lanzas los lados y ganas si sacas:")
    println("un par de unos en los dados")
    println("un total de tres en los dados")
    println("si se obtiene un dos o doce en los dados")
    println("un total de siete en los dados")

    var dado1:Int=(1..6).random()
    println("el dado1 el $dado1")
    var dado2:Int=(1..6).random()
    println("el dado2 el $dado2")

    val suma:Int=dado1.plus(dado2)

    if(dado1==1 && dado2==1){
        print("Gano")
    }
    if(suma==3){
        print("Gano")
    }
    if(suma==11){
        print("Gano")
    }
    if(suma==2){
        print("Gano")
    }
    if(suma==12){
        print("Gano")
    }
    if(suma==7){
        print("Gano")
    }else{
        print("perdio")
    }


}