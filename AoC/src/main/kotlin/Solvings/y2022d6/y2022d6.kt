package Solvings

import java.io.File

val input = File("src/main/kotlin/Solvings/y2022d6/input.txt").readText()
val marker = input.toCharArray().toList()
    .windowed(4, 1, false)
    .first { window -> window.toSet().size == 4 }
    .joinToString("");


fun main() {
    println( input.indexOf(marker) + 4
    )
}