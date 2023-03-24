package Solvings.y2020d5

import java.io.File


fun main(args: Array<String>) {
    val passIds = File("src/main/kotlin/Solvings/y2020d5/input.txt").readLines()
        .map { it.replace("[BR]".toRegex(), "1") }
        .map { it.replace("[FL]".toRegex(), "0") }
        .map { it.toInt(2)  }

    println(passIds.max())
}